// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package org.apache.spark.bts.deal.entity


/** 
$Id$
$Revision$
$Date$
$Name$
@Filename PB_BAS_GEDD_TI_1.xsd
@Generator IFMS 5.0
@GeneratedAt 2016-04-13 06:54:21 UTC

*/


/** 
Validity period for an object. 

Zeitraum der Gueltigkeit eines Objekts.
@State Active

*/
case class Period(ValidFrom: String,
  ValidTo: String)
      


/** 
Defines period begin and period end date.
@State Active

*/
case class PeriodDates(PeriodFromDate: javax.xml.datatype.XMLGregorianCalendar,
  PeriodToDate: javax.xml.datatype.XMLGregorianCalendar)
      
