// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package org.apache.spark.bts.deal.entity


/** 
$Id$
$Revision$
$Date$
$Name$
@Filename PB_BAS_GEDD_IL_1.xsd
@Generator IFMS 5.0
@GeneratedAt 2016-04-13 06:54:21 UTC

*/

trait LangSelWithAll

object LangSelWithAll {
  def fromString(value: String, scope: scala.xml.NamespaceBinding): LangSelWithAll = value match {
    case "BUDEF" => BUDEF
    case "CSCD" => CSCD
    case "ISOCD" => ISOCD
    case "ALL" => ALL

  }
}

case object BUDEF extends LangSelWithAll { override def toString = "BUDEF" }
case object CSCD extends LangSelWithAll { override def toString = "CSCD" }
case object ISOCD extends LangSelWithAll { override def toString = "ISOCD" }
case object ALL extends LangSelWithAll { override def toString = "ALL" }

