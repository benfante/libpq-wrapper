/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.benfante.experiments.libpqwrapper.swig;

public class PQArgBlock_u {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected PQArgBlock_u(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(PQArgBlock_u obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pqJNI.delete_PQArgBlock_u(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setPtr(SWIGTYPE_p_int value) {
    pqJNI.PQArgBlock_u_ptr_set(swigCPtr, this, SWIGTYPE_p_int.getCPtr(value));
  }

  public SWIGTYPE_p_int getPtr() {
    long cPtr = pqJNI.PQArgBlock_u_ptr_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
  }

  public void setInteger(int value) {
    pqJNI.PQArgBlock_u_integer_set(swigCPtr, this, value);
  }

  public int getInteger() {
    return pqJNI.PQArgBlock_u_integer_get(swigCPtr, this);
  }

  public PQArgBlock_u() {
    this(pqJNI.new_PQArgBlock_u(), true);
  }

}
