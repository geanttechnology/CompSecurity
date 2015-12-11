// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


// Referenced classes of package com.jumio.clientlib.impl.livenessAndTM:
//            jniLivenessAndTMJNI, SWIGTYPE_p_unsigned_char

public class Uint8Array
{

    private long a;
    protected boolean swigCMemOwn;

    public Uint8Array(int i)
    {
        this(jniLivenessAndTMJNI.new_Uint8Array(i), true);
    }

    protected Uint8Array(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public static Uint8Array frompointer(SWIGTYPE_p_unsigned_char swigtype_p_unsigned_char)
    {
        long l = jniLivenessAndTMJNI.Uint8Array_frompointer(SWIGTYPE_p_unsigned_char.getCPtr(swigtype_p_unsigned_char));
        if (l == 0L)
        {
            return null;
        } else
        {
            return new Uint8Array(l, false);
        }
    }

    protected static long getCPtr(Uint8Array uint8array)
    {
        if (uint8array == null)
        {
            return 0L;
        } else
        {
            return uint8array.a;
        }
    }

    public SWIGTYPE_p_unsigned_char cast()
    {
        long l = jniLivenessAndTMJNI.Uint8Array_cast(a, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new SWIGTYPE_p_unsigned_char(l, false);
        }
    }

    public void delete()
    {
        this;
        JVM INSTR monitorenter ;
        if (a != 0L)
        {
            if (swigCMemOwn)
            {
                swigCMemOwn = false;
                jniLivenessAndTMJNI.delete_Uint8Array(a);
            }
            a = 0L;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void finalize()
    {
        delete();
    }

    public short getitem(int i)
    {
        return jniLivenessAndTMJNI.Uint8Array_getitem(a, this, i);
    }

    public void setitem(int i, short word0)
    {
        jniLivenessAndTMJNI.Uint8Array_setitem(a, this, i, word0);
    }
}
