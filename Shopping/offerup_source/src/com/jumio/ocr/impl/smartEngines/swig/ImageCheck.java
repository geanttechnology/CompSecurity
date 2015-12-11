// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI

public class ImageCheck
{

    private long a;
    protected boolean swigCMemOwn;

    public ImageCheck()
    {
        this(jniInterfaceJNI.new_ImageCheck(), true);
    }

    protected ImageCheck(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public static float computeFlashConfidence(byte abyte0[], int i, int j, int k, int l)
    {
        return jniInterfaceJNI.ImageCheck_computeFlashConfidence(abyte0, i, j, k, l);
    }

    public static int computeFocusConfidence(byte abyte0[], int i, int j, int k, int l)
    {
        return jniInterfaceJNI.ImageCheck_computeFocusConfidence(abyte0, i, j, k, l);
    }

    protected static long getCPtr(ImageCheck imagecheck)
    {
        if (imagecheck == null)
        {
            return 0L;
        } else
        {
            return imagecheck.a;
        }
    }

    public static boolean isFlashNeeded(byte abyte0[], int i, int j, int k, int l, int i1)
    {
        return jniInterfaceJNI.ImageCheck_isFlashNeeded(abyte0, i, j, k, l, i1);
    }

    public static boolean isRefocusNeeded(byte abyte0[], int i, int j, int k, int l, int i1)
    {
        return jniInterfaceJNI.ImageCheck_isRefocusNeeded(abyte0, i, j, k, l, i1);
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
                jniInterfaceJNI.delete_ImageCheck(a);
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
