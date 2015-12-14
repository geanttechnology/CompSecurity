// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;

import com.pf.common.a;
import java.io.PrintStream;

// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            k, ap, d, t, 
//            q, ba, v, bd, 
//            x, an, bf, be

public class UIImageCodecJNI
{

    public static final native boolean ImageCodec_CalcOutputDimension(long l, k k, String s, int i, long l1, long l2, ap ap);

    public static final native boolean ImageCodec_CalcOutputDimensionFromBuffer(long l, k k, byte abyte0[], int i, int j, long l1, 
            long l2, ap ap);

    public static final native int ImageCodec_DecodeFromBuffer__SWIG_1(long l, k k, byte abyte0[], int i, long l1, d d, 
            long l2, t t);

    public static final native int ImageCodec_DecodeFromFile__SWIG_0(long l, k k, String s, long l1, d d, long l2, t t, long l3, q q);

    public static final native int ImageCodec_DecodeFromFile__SWIG_1(long l, k k, String s, long l1, d d, long l2, t t);

    public static final native void ImageCodec_DumpMetadata(long l, k k, long l1, ba ba);

    public static final native int ImageCodec_EncodeToFile__SWIG_0(long l, k k, String s, long l1, d d, long l2, v v, long l3, ba ba, long l4, 
            q q);

    public static final native int ImageCodec_EncodeToFile__SWIG_1(long l, k k, String s, long l1, d d, long l2, v v, long l3, ba ba);

    public static final native boolean ImageCodec_GetMetadataFromBuffer(long l, k k, byte abyte0[], int i, long l1, ba ba);

    public static final native boolean ImageCodec_GetMetadataFromFile(long l, k k, String s, long l1, ba ba);

    public static final native boolean ImageCodec_GetThumbnailFromFile__SWIG_0(long l, k k, String s, long l1, d d, boolean flag);

    public static final native boolean ImageCodec_GetThumbnailFromFile__SWIG_1(long l, k k, String s, long l1, d d);

    public static final native boolean ImageCodec_GetThumbnailPropertyFromFile(long l, k k, String s, long l1, bd bd);

    public static final native boolean ImageCodec_RotateFlip(long l, k k, long l1, d d, long l2, 
            d d1, int i);

    public static final native boolean ImageCodec_Stretch__SWIG_0(long l, k k, long l1, d d, long l2, 
            d d1, int i);

    public static final native boolean ImageCodec_Stretch__SWIG_1(long l, k k, long l1, d d, long l2, 
            d d1);

    public static final native void UICancellationToken_Cancel(long l, q q);

    public static final native boolean UICancellationToken_IsCancelled(long l, q q);

    public static final native void UIDecodeParamRef_nBytePerPixel_set(long l, t t, int i);

    public static final native void UIDecodeParamRef_nFormat_set(long l, t t, int i);

    public static final native void UIDecodeParamRef_ulHeight_set(long l, t t, long l1);

    public static final native void UIDecodeParamRef_ulSampleSize_set(long l, t t, long l1);

    public static final native void UIDecodeParamRef_ulWidth_set(long l, t t, long l1);

    public static final native int UIEncodeParamRef_GetFormat(long l, v v);

    public static final native void UIEncodeParamRef_SetFormat(long l, v v, int i);

    public static final native void UIEncodeParamRef_SetImageOrientation(long l, v v, int i);

    public static final native void UIEncodeParamRef_SetQuality(long l, v v, int i);

    public static final native int UIExifInfo_nColorSpace_get(long l, x x);

    public static final native int UIFileInfo_nFormat_get(long l, an an);

    public static final native int UIFileInfo_nOrientation_get(long l, an an);

    public static final native long UIFileInfo_ulHeight_get(long l, an an);

    public static final native void UIFileInfo_ulHeight_set(long l, an an, long l1);

    public static final native long UIFileInfo_ulWidth_get(long l, an an);

    public static final native void UIFileInfo_ulWidth_set(long l, an an, long l1);

    public static final native long UIImageDimension_ulHeight_get(long l, ap ap);

    public static final native void UIImageDimension_ulHeight_set(long l, ap ap, long l1);

    public static final native long UIImageDimension_ulWidth_get(long l, ap ap);

    public static final native void UIImageDimension_ulWidth_set(long l, ap ap, long l1);

    public static final native long UIMetadata_exifInfo_get(long l, ba ba);

    public static final native long UIMetadata_fileInfo_get(long l, ba ba);

    public static final native long UIThumbnailPropertyItemVector_get(long l, bf bf, int i);

    public static final native long UIThumbnailPropertyItemVector_size(long l, bf bf);

    public static final native long UIThumbnailPropertyItem_nHeight_get(long l, be be);

    public static final native int UIThumbnailPropertyItem_nOrientation_get(long l, be be);

    public static final native int UIThumbnailPropertyItem_nType_get(long l, be be);

    public static final native long UIThumbnailPropertyItem_nWidth_get(long l, be be);

    public static final native long UIThumbnailProperty_items_get(long l, bd bd);

    public static final native void delete_ImageCodec(long l);

    public static final native void delete_UICancellationToken(long l);

    public static final native void delete_UIDecodeParamRef(long l);

    public static final native void delete_UIEncodeParamRef(long l);

    public static final native void delete_UIExifInfo(long l);

    public static final native void delete_UIFileInfo(long l);

    public static final native void delete_UIImageDimension(long l);

    public static final native void delete_UIMetadata(long l);

    public static final native void delete_UIThumbnailProperty(long l);

    public static final native void delete_UIThumbnailPropertyItem(long l);

    public static final native void delete_UIThumbnailPropertyItemVector(long l);

    public static final native long new_ImageCodec(String s);

    public static final native long new_UICancellationToken();

    public static final native long new_UIDecodeParamRef();

    public static final native long new_UIEncodeParamRef__SWIG_0();

    public static final native long new_UIEncodeParamRef__SWIG_1(int i, int j, int k, int l, int i1, int j1);

    public static final native long new_UIExifInfo();

    public static final native long new_UIFileInfo();

    public static final native long new_UIImageDimension__SWIG_0();

    public static final native long new_UIMetadata();

    public static final native long new_UIThumbnailProperty();

    public static final native long new_UIThumbnailPropertyItem();

    public static final native long new_UIThumbnailPropertyItemVector__SWIG_0();

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
