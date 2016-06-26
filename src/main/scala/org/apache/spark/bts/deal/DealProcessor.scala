package org.apache.spark.bts.deal

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.kafka.OffsetRange

import kafka.serializer.StringDecoder

object DealProcessor {

	def main(args: scala.Array[String]) {

	  implicit lazy val formats = org.json4s.DefaultFormats;
	  
    if (args.length < 5) {
      System.err.println("Usage: DealProcessor master <zkQuorum> <group> <topics> <numThreads>")
      System.exit(1)
    }

		val Array(master, zkQuorum, group, topics, numThreads) = args
		val topicMap = topics.split(",").map((_, numThreads.toInt)).toMap
		
		val sparkConf = new SparkConf()
		sparkConf.setMaster("local")
		sparkConf.setAppName("DealProcessor")
		
		// hostname:port for Kafka brokers, not Zookeeper
    val kafkaParams = Map("metadata.broker.list" -> "localhost:9092")
    val offsetRanges = Array(
      OffsetRange("bts", 0, 1, 30)
    )
 
    val sc = new SparkContext(sparkConf)
    val rdd = KafkaUtils.createRDD[String, String, StringDecoder, StringDecoder](
      sc, kafkaParams, offsetRanges)
//      .map(line => toJson(xml.XML.loadString(line._2)).extract[Message])
	  
      rdd.collect().foreach(println)
      
//      val ssc = new StreamingContext(sparkConf, Seconds(2))
//      val deal =  KafkaUtils.createStream(ssc, zkQuorum,group, topicMap)
//      .map(line => toJson(xml.XML.loadString(line._2)).extract[Message])
//
//      deal.count().print()
//
//      ssc.start;
//		  ssc.awaitTermination;
	}
}