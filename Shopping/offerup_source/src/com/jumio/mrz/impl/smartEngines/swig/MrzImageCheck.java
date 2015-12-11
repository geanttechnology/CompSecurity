// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mrz.impl.smartEngines.swig;


// Referenced classes of package com.jumio.mrz.impl.smartEngines.swig:
//            mrzjniInterfaceJNI

public class MrzImageCheck
{

    private long a;
    protected boolean swigCMemOwn;

    public MrzImageCheck()
    {
        this(mrzjniInterfaceJNI.new_MrzImageCheck(), true);
    }

    protected MrzImageCheck(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public static float computeFlashConfidence(byte abyte0[], int i, int j, int k, int l)
    {
        return mrzjniInterfaceJNI.MrzImageCheck_computeFlashConfidence(abyte0, i, j, k, l);
    }

    public static int computeFocusConfidence(byte abyte0[], int i, int j, int k, int l)
    {
        return mrzjniInterfaceJNI.MrzImageCheck_computeFocusConfidence(abyte0, i, j, k, l);
    }

    protected static long getCPtr(MrzImageCheck mrzimagecheck)
    {
        if (mrzimagecheck == null)
        {
            return 0L;
        } else
        {
            return mrzimagecheck.a;
        }
    }

    public static boolean isFlashNeeded(byte abyte0[], int i, int j, int k, int l, int i1)
    {
        return mrzjniInterfaceJNI.MrzImageCheck_isFlashNeeded(abyte0, i, j, k, l, i1);
    }

    public static boolean isRefocusNeeded(byte abyte0[], int i, int j, int k, int l, int i1)
    {
        return mrzjniInterfaceJNI.MrzImageCheck_isRefocusNeeded(abyte0, i, j, k, l, i1);
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
                mrzjniInterfaceJNI.delete_MrzImageCheck(a);
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
}
