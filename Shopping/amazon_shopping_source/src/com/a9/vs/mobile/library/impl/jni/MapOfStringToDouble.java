// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, VectorOfString

public class MapOfStringToDouble
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public MapOfStringToDouble()
    {
        this(A9VSMobileJNI.new_MapOfStringToDouble__SWIG_0(), true);
    }

    protected MapOfStringToDouble(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    public MapOfStringToDouble(MapOfStringToDouble mapofstringtodouble)
    {
        this(A9VSMobileJNI.new_MapOfStringToDouble__SWIG_1(getCPtr(mapofstringtodouble), mapofstringtodouble), true);
    }

    protected static long getCPtr(MapOfStringToDouble mapofstringtodouble)
    {
        if (mapofstringtodouble == null)
        {
            return 0L;
        } else
        {
            return mapofstringtodouble.swigCPtr;
        }
    }

    public static VectorOfString getKeysForDoubleMap(MapOfStringToDouble mapofstringtodouble)
    {
        return new VectorOfString(A9VSMobileJNI.MapOfStringToDouble_getKeysForDoubleMap(getCPtr(mapofstringtodouble), mapofstringtodouble), true);
    }

    public void clear()
    {
        A9VSMobileJNI.MapOfStringToDouble_clear(swigCPtr, this);
    }

    public void del(String s)
    {
        A9VSMobileJNI.MapOfStringToDouble_del(swigCPtr, this, s);
    }

    public void delete()
    {
        this;
        JVM INSTR monitorenter ;
        if (swigCPtr != 0L)
        {
            if (swigCMemOwn)
            {
                swigCMemOwn = false;
                A9VSMobileJNI.delete_MapOfStringToDouble(swigCPtr);
            }
            swigCPtr = 0L;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean empty()
    {
        return A9VSMobileJNI.MapOfStringToDouble_empty(swigCPtr, this);
    }

    protected void finalize()
    {
        delete();
    }

    public double get(String s)
    {
        return A9VSMobileJNI.MapOfStringToDouble_get(swigCPtr, this, s);
    }

    public boolean has_key(String s)
    {
        return A9VSMobileJNI.MapOfStringToDouble_has_key(swigCPtr, this, s);
    }

    public void set(String s, double d)
    {
        A9VSMobileJNI.MapOfStringToDouble_set(swigCPtr, this, s, d);
    }

    public long size()
    {
        return A9VSMobileJNI.MapOfStringToDouble_size(swigCPtr, this);
    }
}
