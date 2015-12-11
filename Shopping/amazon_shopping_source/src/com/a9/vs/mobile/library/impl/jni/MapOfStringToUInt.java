// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, VectorOfString

public class MapOfStringToUInt
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public MapOfStringToUInt()
    {
        this(A9VSMobileJNI.new_MapOfStringToUInt__SWIG_0(), true);
    }

    protected MapOfStringToUInt(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    public MapOfStringToUInt(MapOfStringToUInt mapofstringtouint)
    {
        this(A9VSMobileJNI.new_MapOfStringToUInt__SWIG_1(getCPtr(mapofstringtouint), mapofstringtouint), true);
    }

    protected static long getCPtr(MapOfStringToUInt mapofstringtouint)
    {
        if (mapofstringtouint == null)
        {
            return 0L;
        } else
        {
            return mapofstringtouint.swigCPtr;
        }
    }

    public static VectorOfString getKeysForIntMap(MapOfStringToUInt mapofstringtouint)
    {
        return new VectorOfString(A9VSMobileJNI.MapOfStringToUInt_getKeysForIntMap(getCPtr(mapofstringtouint), mapofstringtouint), true);
    }

    public void clear()
    {
        A9VSMobileJNI.MapOfStringToUInt_clear(swigCPtr, this);
    }

    public void del(String s)
    {
        A9VSMobileJNI.MapOfStringToUInt_del(swigCPtr, this, s);
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
                A9VSMobileJNI.delete_MapOfStringToUInt(swigCPtr);
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
        return A9VSMobileJNI.MapOfStringToUInt_empty(swigCPtr, this);
    }

    protected void finalize()
    {
        delete();
    }

    public long get(String s)
    {
        return A9VSMobileJNI.MapOfStringToUInt_get(swigCPtr, this, s);
    }

    public boolean has_key(String s)
    {
        return A9VSMobileJNI.MapOfStringToUInt_has_key(swigCPtr, this, s);
    }

    public void set(String s, long l)
    {
        A9VSMobileJNI.MapOfStringToUInt_set(swigCPtr, this, s, l);
    }

    public long size()
    {
        return A9VSMobileJNI.MapOfStringToUInt_size(swigCPtr, this);
    }
}
