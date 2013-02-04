/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.benfante.experiments.libpqwrapper.swig;

public final class PGPing {
  public final static PGPing PQPING_OK = new PGPing("PQPING_OK");
  public final static PGPing PQPING_REJECT = new PGPing("PQPING_REJECT");
  public final static PGPing PQPING_NO_RESPONSE = new PGPing("PQPING_NO_RESPONSE");
  public final static PGPing PQPING_NO_ATTEMPT = new PGPing("PQPING_NO_ATTEMPT");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static PGPing swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + PGPing.class + " with value " + swigValue);
  }

  private PGPing(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private PGPing(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private PGPing(String swigName, PGPing swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static PGPing[] swigValues = { PQPING_OK, PQPING_REJECT, PQPING_NO_RESPONSE, PQPING_NO_ATTEMPT };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}
