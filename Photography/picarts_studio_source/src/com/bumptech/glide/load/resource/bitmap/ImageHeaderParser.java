// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import myobfuscated.f.m;
import myobfuscated.s.j;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            v, s, t, u

public final class ImageHeaderParser
{

    private static final byte a[] = "Exif\000\0".getBytes(Charset.forName("UTF-8"));
    private static final int b[] = {
        0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 
        8, 4, 8
    };
    private final j c;
    private final u d;

    public ImageHeaderParser(InputStream inputstream, j j1)
    {
        m.a(inputstream, "Argument must not be null");
        c = (j)m.a(j1, "Argument must not be null");
        d = new v(inputstream);
    }

    public ImageHeaderParser(ByteBuffer bytebuffer, j j1)
    {
        m.a(bytebuffer, "Argument must not be null");
        c = (j)m.a(j1, "Argument must not be null");
        d = new s(bytebuffer);
    }

    private static int a(t t1)
    {
        short word0 = t1.b(6);
        ByteOrder byteorder;
        if (word0 != 19789)
        {
            int k;
            short word1;
            if (word0 == 18761)
            {
                byteorder = ByteOrder.LITTLE_ENDIAN;
                break MISSING_BLOCK_LABEL_25;
            }
            if (!Log.isLoggable("ImageHeaderParser", 3));
        }
        byteorder = ByteOrder.BIG_ENDIAN;
        continue;
        do
        {
            t1.a.order(byteorder);
            k = t1.a(10) + 6;
            word1 = t1.b(k);
            int i = 0;
            while (i < word1) 
            {
                int l = k + 2 + i * 12;
                short word2 = t1.b(l);
                if (word2 == 274)
                {
                    int i1 = t1.b(l + 2);
                    if (i1 <= 0 || i1 > 12)
                    {
                        if (!Log.isLoggable("ImageHeaderParser", 3));
                    } else
                    {
                        int j1 = t1.a(l + 4);
                        if (j1 < 0)
                        {
                            if (!Log.isLoggable("ImageHeaderParser", 3));
                        } else
                        {
                            if (Log.isLoggable("ImageHeaderParser", 3))
                            {
                                (new StringBuilder("Got tagIndex=")).append(i).append(" tagType=").append(word2).append(" formatCode=").append(i1).append(" componentCount=").append(j1);
                            }
                            i1 = b[i1] + j1;
                            if (i1 > 4)
                            {
                                if (!Log.isLoggable("ImageHeaderParser", 3));
                            } else
                            {
                                l += 8;
                                if (l < 0 || l > t1.a.remaining())
                                {
                                    if (Log.isLoggable("ImageHeaderParser", 3))
                                    {
                                        (new StringBuilder("Illegal tagValueOffset=")).append(l).append(" tagType=").append(word2);
                                    }
                                } else
                                if (i1 < 0 || l + i1 > t1.a.remaining())
                                {
                                    if (!Log.isLoggable("ImageHeaderParser", 3));
                                } else
                                {
                                    return t1.b(l);
                                }
                            }
                        }
                    }
                }
                i++;
            }
            return -1;
        } while (true);
    }

    private static boolean a(byte abyte0[], int i)
    {
        boolean flag;
        if (abyte0 != null && i > a.length)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            for (i = 0; i < a.length; i++)
            {
                if (abyte0[i] != a[i])
                {
                    return false;
                }
            }

        }
        return flag;
    }

    private int c()
    {
_L6:
        if (d.b() == 255) goto _L2; else goto _L1
_L1:
        if (!Log.isLoggable("ImageHeaderParser", 3));
_L4:
        return -1;
_L2:
        int i;
label0:
        {
            short word0 = d.b();
            if (word0 == 218)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (word0 == 217)
            {
                Log.isLoggable("ImageHeaderParser", 3);
                return -1;
            }
            i = d.a() - 2;
            if (word0 == 225)
            {
                break label0;
            }
            long l = d.a(i);
            if (l == (long)i)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (Log.isLoggable("ImageHeaderParser", 3))
            {
                (new StringBuilder("Unable to skip enough data, type: ")).append(word0).append(", wanted to skip: ").append(i).append(", but actually skipped: ").append(l);
                return -1;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L6; else goto _L5
_L5:
        return i;
    }

    public final ImageType a()
    {
        int i = d.a();
        if (i == 65496)
        {
            return ImageType.JPEG;
        }
        i = i << 16 & 0xffff0000 | d.a() & 0xffff;
        if (i == 0x89504e47)
        {
            d.a(21L);
            if (d.c() >= 3)
            {
                return ImageType.PNG_A;
            } else
            {
                return ImageType.PNG;
            }
        }
        if (i >> 8 == 0x474946)
        {
            return ImageType.GIF;
        }
        if (i != 0x52494646)
        {
            return ImageType.UNKNOWN;
        }
        d.a(4L);
        if ((d.a() << 16 & 0xffff0000 | d.a() & 0xffff) != 0x57454250)
        {
            return ImageType.UNKNOWN;
        }
        i = d.a() << 16 & 0xffff0000 | d.a() & 0xffff;
        if ((i & 0xffffff00) != 0x56503800)
        {
            return ImageType.UNKNOWN;
        }
        if ((i & 0xff) == 88)
        {
            d.a(4L);
            if ((d.c() & 0x10) != 0)
            {
                return ImageType.WEBP_A;
            } else
            {
                return ImageType.WEBP;
            }
        }
        if ((i & 0xff) == 76)
        {
            d.a(4L);
            if ((d.c() & 8) != 0)
            {
                return ImageType.WEBP_A;
            } else
            {
                return ImageType.WEBP;
            }
        } else
        {
            return ImageType.WEBP;
        }
    }

    public final int b()
    {
        byte abyte0[];
        byte byte0;
        int l;
        byte0 = -1;
        int i = d.a();
        boolean flag;
        if ((i & 0xffd8) == 65496 || i == 19789 || i == 18761)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            if (!Log.isLoggable("ImageHeaderParser", 3));
            return -1;
        }
        l = c();
        if (l == -1)
        {
            Log.isLoggable("ImageHeaderParser", 3);
            return -1;
        }
        abyte0 = c.a(l);
        int i1 = d.a(abyte0, l);
        if (i1 == l) goto _L2; else goto _L1
_L1:
        int k = byte0;
        if (!Log.isLoggable("ImageHeaderParser", 3))
        {
            break MISSING_BLOCK_LABEL_150;
        }
        (new StringBuilder("Unable to read exif segment data, length: ")).append(l).append(", actually read: ").append(i1);
        k = byte0;
_L3:
        c.a(abyte0);
        return k;
_L2:
label0:
        {
            if (!a(abyte0, l))
            {
                break label0;
            }
            k = a(new t(abyte0, l));
        }
          goto _L3
        Log.isLoggable("ImageHeaderParser", 3);
        k = byte0;
          goto _L3
        Exception exception;
        exception;
        c.a(abyte0);
        throw exception;
    }


    private class ImageType extends Enum
    {

        private static final ImageType $VALUES[];
        public static final ImageType GIF;
        public static final ImageType JPEG;
        public static final ImageType PNG;
        public static final ImageType PNG_A;
        public static final ImageType UNKNOWN;
        public static final ImageType WEBP;
        public static final ImageType WEBP_A;
        private final boolean hasAlpha;

        public static ImageType valueOf(String s1)
        {
            return (ImageType)Enum.valueOf(com/bumptech/glide/load/resource/bitmap/ImageHeaderParser$ImageType, s1);
        }

        public static ImageType[] values()
        {
            return (ImageType[])$VALUES.clone();
        }

        public final boolean hasAlpha()
        {
            return hasAlpha;
        }

        static 
        {
            GIF = new ImageType("GIF", 0, true);
            JPEG = new ImageType("JPEG", 1, false);
            PNG_A = new ImageType("PNG_A", 2, true);
            PNG = new ImageType("PNG", 3, false);
            WEBP_A = new ImageType("WEBP_A", 4, true);
            WEBP = new ImageType("WEBP", 5, false);
            UNKNOWN = new ImageType("UNKNOWN", 6, false);
            $VALUES = (new ImageType[] {
                GIF, JPEG, PNG_A, PNG, WEBP_A, WEBP, UNKNOWN
            });
        }

        private ImageType(String s1, int i, boolean flag)
        {
            super(s1, i);
            hasAlpha = flag;
        }
    }

}
