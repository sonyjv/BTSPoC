// Copyright (C) 2011-2012 the original author or authors.
// See the LICENCE.txt file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.apache.spark.bts.base

import scala.concurrent.duration.FiniteDuration

import org.apache.spark.SparkContext
import org.apache.spark.bts.base.SparkApplication
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.StreamingContext

trait SparkStreamingApplication extends SparkApplication {

  def streamingBatchDuration: FiniteDuration

  def streamingCheckpointDir: String

  def withSparkStreamingContext(f: (SparkContext, StreamingContext) => Unit): Unit = {
    withSparkContext { sc =>
      val ssc = new StreamingContext(sc, Seconds(streamingBatchDuration.toSeconds))
      ssc.checkpoint(streamingCheckpointDir)

      f(sc, ssc)

      ssc.start()
      ssc.awaitTermination()
    }
  }

}