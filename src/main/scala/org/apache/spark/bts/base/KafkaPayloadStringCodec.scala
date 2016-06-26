package org.apache.spark.bts.base

import com.twitter.bijection.{Injection, StringCodec}
import org.apache.log4j.Logger

import scala.util.{Failure, Success}

class KafkaPayloadStringCodec extends Serializable {

  @transient lazy private val logger = Logger.getLogger(getClass)
  @transient lazy implicit private val stringInjection = StringCodec.utf8

  def decodeValue(payload: KafkaPayload): Option[String] = {
    val decodedTry = Injection.invert[String, Array[Byte]](payload.value)
    decodedTry match {
      case Success(record) =>
        Some(record)
      case Failure(ex) =>
        logger.warn("Could not decode payload", ex)
        None
    }
  }

  def encodeValue(value: String): KafkaPayload = {
    val encoded = Injection[String, Array[Byte]](value)
    KafkaPayload(None, encoded)
  }
}

object KafkaPayloadStringCodec {
  def apply(): KafkaPayloadStringCodec = new KafkaPayloadStringCodec
}