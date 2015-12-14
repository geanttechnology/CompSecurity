// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;

import com.pf.common.a;
import java.io.PrintStream;

// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            g, j

public class UIImageRetouchJNI
{

    public static final native boolean CropRotateParam_ChangeResolution(long l, g g, int i, int j);

    public static final native boolean CropRotateParam_Compare(long l, g g, long l1, j j);

    public static final native void CropRotateParam_DecodeString(long l, g g, String s);

    public static final native String CropRotateParam_EncodeString(long l, g g);

    public static final native void CropRotateParam_InitFrom(long l, g g, long l1, j j);

    public static final native boolean CropRotateParam_IsDefault(long l, g g);

    public static final native long CropRotateParam_SWIGUpcast(long l);

    public static final native float CropRotateParam_fAngle_get(long l, g g);

    public static final native int CropRotateParam_nHeight_get(long l, g g);

    public static final native int CropRotateParam_nLeft_get(long l, g g);

    public static final native int CropRotateParam_nTop_get(long l, g g);

    public static final native int CropRotateParam_nWidth_get(long l, g g);

    public static final native boolean IParamBase_Compare(long l, j j, long l1, j j1);

    public static final native void IParamBase_DecodeString(long l, j j, String s);

    public static final native String IParamBase_EncodeString(long l, j j);

    public static final native void IParamBase_InitFrom(long l, j j, long l1, j j1);

    public static final native boolean IParamBase_IsDefault(long l, j j);

    public static final native void delete_CropRotateParam(long l);

    public static final native void delete_IParamBase(long l);

    public static final native long new_CropRotateParam__SWIG_0();

    static 
    {
        try
        {
            a.b();
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            System.err.println((new StringBuilder()).append("JNI error: ").append(unsatisfiedlinkerror).toString());
            System.exit(1);
        }
    }
}
