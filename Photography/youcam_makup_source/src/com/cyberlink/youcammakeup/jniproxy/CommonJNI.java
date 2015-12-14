// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;

import com.pf.common.a;
import java.io.PrintStream;

// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            d, as, p, h, 
//            i

public class CommonJNI
{

    public static final native boolean CImageBuffer_ApplyMaskBitmap(long l, d d, Object obj);

    public static final native boolean CImageBuffer_AttachAndroidBitmap(long l, d d, Object obj);

    public static final native boolean CImageBuffer_ClearAlphaChannel(long l, d d);

    public static final native boolean CImageBuffer_ConvertColorDepth(long l, d d, long l1, d d1);

    public static final native boolean CImageBuffer_CopyImageBufferToImageBuffer__SWIG_0(long l, d d, long l1, d d1, long l2, 
            as as);

    public static final native boolean CImageBuffer_CopyToAndroidBitmap(long l, d d, Object obj);

    public static final native boolean CImageBuffer_CreateBuffer(long l, d d, long l1, long l2, long l3);

    public static final native boolean CImageBuffer_CreateFromImageBuffer(long l, d d, long l1, d d1, long l2, 
            as as);

    public static final native void CImageBuffer_Destroy(long l, d d);

    public static final native boolean CImageBuffer_DetachAndroidBitmap(long l, d d);

    public static final native boolean CImageBuffer_DumpToFile(long l, d d, String s);

    public static final native long CImageBuffer_GetBytesPerPixel(long l, d d);

    public static final native boolean CImageBuffer_GetCacheFileInfo(String s, long l, p p);

    public static final native long CImageBuffer_GetHeight(long l, d d);

    public static final native int CImageBuffer_GetPixelFormat(long l, d d);

    public static final native long CImageBuffer_GetWidth(long l, d d);

    public static final native boolean CImageBuffer_LoadFromFile(long l, d d, String s);

    public static final native long CImageBuffer_SWIGUpcast(long l);

    public static final native void CImageBuffer_SetAccessMode(long l, d d, int i);

    public static final native void CImageBuffer_SetPixelFormat(long l, d d, int i);

    public static final native boolean CImageBuffer_SwapColorChannel__SWIG_0(long l, d d);

    public static final native boolean CImageBuffer_SwapColorChannel__SWIG_1(long l, d d, long l1, d d1);

    public static final native void IDestroyable_Destroy(long l, h h);

    public static final native long IImageBuffer_GetBytesPerPixel(long l, i i);

    public static final native long IImageBuffer_GetHeight(long l, i i);

    public static final native long IImageBuffer_GetWidth(long l, i i);

    public static final native long IImageBuffer_SWIGUpcast(long l);

    public static final native void IImageBuffer_SetAccessMode(long l, i i, int j);

    public static final native boolean RuntimeHelper_IsARMArch();

    public static final native boolean RuntimeHelper_IsSupportNeon();

    public static final native long UICacheFileInfo_ulBpp_get(long l, p p);

    public static final native long UICacheFileInfo_ulHeight_get(long l, p p);

    public static final native long UICacheFileInfo_ulWidth_get(long l, p p);

    public static final native void delete_CImageBuffer(long l);

    public static final native void delete_IDestroyable(long l);

    public static final native void delete_IImageBuffer(long l);

    public static final native void delete_RuntimeHelper(long l);

    public static final native void delete_UICacheFileInfo(long l);

    public static final native void delete_UIImageROI(long l);

    public static final native long new_CImageBuffer__SWIG_0(int i);

    public static final native long new_CImageBuffer__SWIG_1();

    public static final native long new_UICacheFileInfo();

    public static final native long new_UIImageROI(long l, long l1, long l2, long l3);

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
