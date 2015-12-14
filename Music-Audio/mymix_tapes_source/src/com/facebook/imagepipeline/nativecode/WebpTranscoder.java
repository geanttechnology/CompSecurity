// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.nativecode;

import android.graphics.BitmapFactory;
import android.util.Base64;
import com.facebook.common.internal.Preconditions;
import com.facebook.imageformat.ImageFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.facebook.imagepipeline.nativecode:
//            ImagePipelineNativeLoader

public class WebpTranscoder
{

    private static final String VP8X_WEBP_BASE64 = "UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==";
    private static final boolean mIsExtendedWebpSupported = isExtendedWebpSupported();

    public WebpTranscoder()
    {
    }

    private static boolean isExtendedWebpSupported()
    {
        if (android.os.Build.VERSION.SDK_INT >= 17) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        android.graphics.BitmapFactory.Options options;
        if (android.os.Build.VERSION.SDK_INT != 17)
        {
            break; /* Loop/switch isn't completed */
        }
        byte abyte0[] = Base64.decode("UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==", 0);
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length, options);
        if (options.outHeight != 1 || options.outWidth != 1) goto _L1; else goto _L3
_L3:
        return true;
    }

    public static boolean isWebpNativelySupported(ImageFormat imageformat)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$facebook$imageformat$ImageFormat[];

            static 
            {
                $SwitchMap$com$facebook$imageformat$ImageFormat = new int[ImageFormat.values().length];
                try
                {
                    $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.WEBP_SIMPLE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.WEBP_LOSSLESS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.WEBP_EXTENDED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.WEBP_EXTENDED_WITH_ALPHA.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.WEBP_ANIMATED.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.facebook.imageformat.ImageFormat[imageformat.ordinal()];
        JVM INSTR tableswitch 1 5: default 44
    //                   1 50
    //                   2 60
    //                   3 60
    //                   4 60
    //                   5 48;
           goto _L1 _L2 _L3 _L3 _L3 _L4
_L1:
        Preconditions.checkArgument(false);
_L4:
        return false;
_L2:
        if (android.os.Build.VERSION.SDK_INT < 14) goto _L4; else goto _L5
_L5:
        return true;
_L3:
        return mIsExtendedWebpSupported;
    }

    private static native void nativeTranscodeWebpToJpeg(InputStream inputstream, OutputStream outputstream, int i)
        throws IOException;

    private static native void nativeTranscodeWebpToPng(InputStream inputstream, OutputStream outputstream)
        throws IOException;

    public static void transcodeWebpToJpeg(InputStream inputstream, OutputStream outputstream, int i)
        throws IOException
    {
        nativeTranscodeWebpToJpeg((InputStream)Preconditions.checkNotNull(inputstream), (OutputStream)Preconditions.checkNotNull(outputstream), i);
    }

    public static void transcodeWebpToPng(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        nativeTranscodeWebpToPng((InputStream)Preconditions.checkNotNull(inputstream), (OutputStream)Preconditions.checkNotNull(outputstream));
    }

    static 
    {
        ImagePipelineNativeLoader.load();
    }
}
