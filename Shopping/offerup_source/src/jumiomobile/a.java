// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.clientlib.impl.imagequality.jniImageQualityAcquisitionJNI;

// Referenced classes of package jumiomobile:
//            b

public class a
{

    public static float a(byte abyte0[], long l, int i, int j, b b1)
    {
        return jniImageQualityAcquisitionJNI.ImageQualityAcquisition_Evaluate(abyte0, l, i, j, b1.a());
    }
}
