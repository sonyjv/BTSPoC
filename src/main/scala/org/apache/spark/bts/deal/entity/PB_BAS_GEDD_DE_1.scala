// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package org.apache.spark.bts.deal.entity


/** 
$Id$
$Revision$
$Date$
$Name$
@Filename PB_BAS_GEDD_DE_1.xsd
@Generator IFMS 5.0
@GeneratedAt 2016-04-13 06:54:21 UTC

*/


/** 
CS and/or ISO currency specification 
Usage in input data structures: One valid currency code (CS or ISO) must be defined; in case of defining both codes (CS and ISO), they must be the same in the meaning of representing the identical currency.
@State Active

*/
case class CurrencyCd(CurrencyCdCs: Option[String] = None,
  CurrencyCdIso: Option[String] = None)
      


/** 
Amount with ISO currency specification 
Usage in input data structures: Valid currency code (ISO) can be defined; in case of defining amount
@State Active

*/
case class Amounts(CurencyISO: String,
  Amount: BigDecimal)
      


/** 
Defines range of amount in decimal format.
@State Active

*/
case class AmountRange(AmountFrom: BigDecimal,
  AmountTo: BigDecimal,
  Currency: String)
      


/** 
Amount with ISO currency specification 
Usage in input/output data structures: One valid currency ISO code must be defined;

Usage in output structures: The ISO currency code is always defined;
@State Active

*/
case class CurrencyISOAmount(CurrencyISO: String,
  Amount: BigDecimal)
      


/** 
Amount with CS and/or ISO currency specification 
Usage in input data structures: One valid currency code (CS or ISO) must be defined; in case of defining both codes (CS and ISO), they must be the same in the meaning of representing the identical currency. 

Usage in output structures: The CS currency code is always defined; if an identical representation in form of an ISO currency code is available it must be defined as well. 

Betrag mit CS- und/oder ISO-Waehrungscode 
Verwendung bei Eingabestrukturen: Mindestens gültigen CS- oder ISO-Code enthalten; sind beide enthalten müssen sie konsistent sein, d.h. die genau gleiche Waehrung identifizieren. 

Verwendung in Ausgabestrukturen: Der CS-Code wird immer geliefert, der ISO-Code muss zusätzlich enthalten sein, wenn es ihn für die Währung gibt, d.h. bei den echten, gaengigen Zahlungsmitteln.
@State Active

*/
case class Amount(CurrencyCS: Option[String] = None,
  CurencyISO: Option[String] = None,
  Amount: BigDecimal)
      

