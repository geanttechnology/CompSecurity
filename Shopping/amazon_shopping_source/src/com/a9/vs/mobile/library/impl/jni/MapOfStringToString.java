// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, VectorOfString

public class MapOfStringToString
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public MapOfStringToString()
    {
        this(A9VSMobileJNI.new_MapOfStringToString__SWIG_0(), true);
    }

    protected MapOfStringToString(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    public MapOfStringToString(MapOfStringToString mapofstringtostring)
    {
        this(A9VSMobileJNI.new_MapOfStringToString__SWIG_1(getCPtr(mapofstringtostring), mapofstringtostring), true);
    }

    protected static long getCPtr(MapOfStringToString mapofstringtostring)
    {
        if (mapofstringtostring == null)
        {
            return 0L;
        } else
        {
            return mapofstringtostring.swigCPtr;
        }
    }

    public static VectorOfString getKeys(MapOfStringToString mapofstringtostring)
    {
        return new VectorOfString(A9VSMobileJNI.MapOfStringToString_getKeys(getCPtr(mapofstringtostring), mapofstringtostring), true);
    }

    public void clear()
    {
        A9VSMobileJNI.MapOfStringToString_clear(swigCPtr, this);
    }

    public void del(String s)
    {
        A9VSMobileJNI.MapOfStringToString_del(swigCPtr, this, s);
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
                A9VSMobileJNI.delete_MapOfStringToString(swigCPtr);
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
        return A9VSMobileJNI.MapOfStringToString_empty(swigCPtr, this);
    }

    protected void finalize()
    {
        delete();
    }

    public String get(String s)
    {
        return A9VSMobileJNI.MapOfStringToString_get(swigCPtr, this, s);
    }

    public boolean has_key(String s)
    {
        return A9VSMobileJNI.MapOfStringToString_has_key(swigCPtr, this, s);
    }

    public void set(String s, String s1)
    {
        A9VSMobileJNI.MapOfStringToString_set(swigCPtr, this, s, s1);
    }

    public long size()
    {
        return A9VSMobileJNI.MapOfStringToString_size(swigCPtr, this);
    }
}
