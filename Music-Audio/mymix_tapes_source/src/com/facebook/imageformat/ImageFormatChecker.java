// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imageformat;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Ints;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

// Referenced classes of package com.facebook.imageformat:
//            ImageFormat

public class ImageFormatChecker
{

    private static final byte BMP_HEADER[];
    private static final int EXTENDED_WEBP_HEADER_LENGTH = 21;
    private static final byte GIF_HEADER_87A[] = asciiBytes("GIF87a");
    private static final byte GIF_HEADER_89A[] = asciiBytes("GIF89a");
    private static final int GIF_HEADER_LENGTH = 6;
    private static final byte JPEG_HEADER[] = {
        -1, -40, -1
    };
    private static final int MAX_HEADER_LENGTH;
    private static final byte PNG_HEADER[] = {
        -119, 80, 78, 71, 13, 10, 26, 10
    };
    private static final int SIMPLE_WEBP_HEADER_LENGTH = 20;
    private static final byte WEBP_NAME_BYTES[] = asciiBytes("WEBP");
    private static final byte WEBP_RIFF_BYTES[] = asciiBytes("RIFF");
    private static final byte WEBP_VP8L_BYTES[] = asciiBytes("VP8L");
    private static final byte WEBP_VP8X_BYTES[] = asciiBytes("VP8X");
    private static final byte WEBP_VP8_BYTES[] = asciiBytes("VP8 ");

    private ImageFormatChecker()
    {
    }

    private static byte[] asciiBytes(String s)
    {
        Preconditions.checkNotNull(s);
        try
        {
            s = s.getBytes("ASCII");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("ASCII not found!", s);
        }
        return s;
    }

    private static ImageFormat doGetImageFormat(byte abyte0[], int i)
    {
        Preconditions.checkNotNull(abyte0);
        if (isWebpHeader(abyte0, i))
        {
            return getWebpFormat(abyte0, i);
        }
        if (isJpegHeader(abyte0, i))
        {
            return ImageFormat.JPEG;
        }
        if (isPngHeader(abyte0, i))
        {
            return ImageFormat.PNG;
        }
        if (isGifHeader(abyte0, i))
        {
            return ImageFormat.GIF;
        }
        if (isBmpHeader(abyte0, i))
        {
            return ImageFormat.BMP;
        } else
        {
            return ImageFormat.UNKNOWN;
        }
    }

    public static ImageFormat getImageFormat(InputStream inputstream)
        throws IOException
    {
        Preconditions.checkNotNull(inputstream);
        byte abyte0[] = new byte[MAX_HEADER_LENGTH];
        return doGetImageFormat(abyte0, readHeaderFromStream(inputstream, abyte0));
    }

    public static ImageFormat getImageFormat(String s)
    {
        Object obj;
        ImageFormat imageformat;
        obj = null;
        imageformat = null;
        s = new FileInputStream(s);
        obj = getImageFormat(((InputStream) (s)));
        Closeables.closeQuietly(s);
        return ((ImageFormat) (obj));
        s;
        s = imageformat;
_L4:
        obj = s;
        imageformat = ImageFormat.UNKNOWN;
        Closeables.closeQuietly(s);
        return imageformat;
        s;
_L2:
        Closeables.closeQuietly(((InputStream) (obj)));
        throw s;
        Exception exception;
        exception;
        obj = s;
        s = exception;
        if (true) goto _L2; else goto _L1
_L1:
        IOException ioexception;
        ioexception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static ImageFormat getImageFormat_WrapIOException(InputStream inputstream)
    {
        try
        {
            inputstream = getImageFormat(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw Throwables.propagate(inputstream);
        }
        return inputstream;
    }

    private static ImageFormat getWebpFormat(byte abyte0[], int i)
    {
        Preconditions.checkArgument(isWebpHeader(abyte0, i));
        if (isSimpleWebpHeader(abyte0))
        {
            return ImageFormat.WEBP_SIMPLE;
        }
        if (isLosslessWebpHeader(abyte0))
        {
            return ImageFormat.WEBP_LOSSLESS;
        }
        if (isExtendedWebpHeader(abyte0, i))
        {
            if (isAnimatedWebpHeader(abyte0))
            {
                return ImageFormat.WEBP_ANIMATED;
            }
            if (isExtendedWebpHeaderWithAlpha(abyte0))
            {
                return ImageFormat.WEBP_EXTENDED_WITH_ALPHA;
            } else
            {
                return ImageFormat.WEBP_EXTENDED;
            }
        } else
        {
            return ImageFormat.UNKNOWN;
        }
    }

    private static boolean isAnimatedWebpHeader(byte abyte0[])
    {
        boolean flag1 = matchBytePattern(abyte0, 12, WEBP_VP8X_BYTES);
        boolean flag;
        if ((abyte0[20] & 2) == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag1 && flag;
    }

    private static boolean isBmpHeader(byte abyte0[], int i)
    {
        if (i < BMP_HEADER.length)
        {
            return false;
        } else
        {
            return matchBytePattern(abyte0, 0, BMP_HEADER);
        }
    }

    private static boolean isExtendedWebpHeader(byte abyte0[], int i)
    {
        return i >= 21 && matchBytePattern(abyte0, 12, WEBP_VP8X_BYTES);
    }

    private static boolean isExtendedWebpHeaderWithAlpha(byte abyte0[])
    {
        boolean flag1 = matchBytePattern(abyte0, 12, WEBP_VP8X_BYTES);
        boolean flag;
        if ((abyte0[20] & 0x10) == 16)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag1 && flag;
    }

    private static boolean isGifHeader(byte abyte0[], int i)
    {
        while (i < 6 || !matchBytePattern(abyte0, 0, GIF_HEADER_87A) && !matchBytePattern(abyte0, 0, GIF_HEADER_89A)) 
        {
            return false;
        }
        return true;
    }

    private static boolean isJpegHeader(byte abyte0[], int i)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (i >= JPEG_HEADER.length)
        {
            flag = flag1;
            if (matchBytePattern(abyte0, 0, JPEG_HEADER))
            {
                flag = true;
            }
        }
        return flag;
    }

    private static boolean isLosslessWebpHeader(byte abyte0[])
    {
        return matchBytePattern(abyte0, 12, WEBP_VP8L_BYTES);
    }

    private static boolean isPngHeader(byte abyte0[], int i)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (i >= PNG_HEADER.length)
        {
            flag = flag1;
            if (matchBytePattern(abyte0, 0, PNG_HEADER))
            {
                flag = true;
            }
        }
        return flag;
    }

    private static boolean isSimpleWebpHeader(byte abyte0[])
    {
        return matchBytePattern(abyte0, 12, WEBP_VP8_BYTES);
    }

    private static boolean isWebpHeader(byte abyte0[], int i)
    {
        boolean flag1 = false;
        Preconditions.checkNotNull(abyte0);
        boolean flag = flag1;
        if (i >= 20)
        {
            flag = flag1;
            if (matchBytePattern(abyte0, 0, WEBP_RIFF_BYTES))
            {
                flag = flag1;
                if (matchBytePattern(abyte0, 8, WEBP_NAME_BYTES))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private static boolean matchBytePattern(byte abyte0[], int i, byte abyte1[])
    {
        Preconditions.checkNotNull(abyte0);
        Preconditions.checkNotNull(abyte1);
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        if (abyte1.length + i <= abyte0.length) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j = 0;
label0:
        do
        {
label1:
            {
                if (j >= abyte1.length)
                {
                    break label1;
                }
                if (abyte0[j + i] != abyte1[j])
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    private static int readHeaderFromStream(InputStream inputstream, byte abyte0[])
        throws IOException
    {
        Preconditions.checkNotNull(inputstream);
        Preconditions.checkNotNull(abyte0);
        int i;
        boolean flag;
        if (abyte0.length >= MAX_HEADER_LENGTH)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        if (!inputstream.markSupported())
        {
            break MISSING_BLOCK_LABEL_66;
        }
        inputstream.mark(MAX_HEADER_LENGTH);
        i = ByteStreams.read(inputstream, abyte0, 0, MAX_HEADER_LENGTH);
        inputstream.reset();
        return i;
        abyte0;
        inputstream.reset();
        throw abyte0;
        return ByteStreams.read(inputstream, abyte0, 0, MAX_HEADER_LENGTH);
    }

    static 
    {
        BMP_HEADER = asciiBytes("BM");
        MAX_HEADER_LENGTH = Ints.max(new int[] {
            21, 20, JPEG_HEADER.length, PNG_HEADER.length, 6, BMP_HEADER.length
        });
    }
}
