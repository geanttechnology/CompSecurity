// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ImageHeaderParser
{
    public static final class ImageType extends Enum
    {

        private static final ImageType $VALUES[];
        public static final ImageType GIF;
        public static final ImageType JPEG;
        public static final ImageType PNG;
        public static final ImageType PNG_A;
        public static final ImageType UNKNOWN;
        private final boolean hasAlpha;

        public static ImageType valueOf(String s)
        {
            return (ImageType)Enum.valueOf(com/bumptech/glide/load/resource/bitmap/ImageHeaderParser$ImageType, s);
        }

        public static ImageType[] values()
        {
            return (ImageType[])$VALUES.clone();
        }

        public boolean hasAlpha()
        {
            return hasAlpha;
        }

        static 
        {
            GIF = new ImageType("GIF", 0, true);
            JPEG = new ImageType("JPEG", 1, false);
            PNG_A = new ImageType("PNG_A", 2, true);
            PNG = new ImageType("PNG", 3, false);
            UNKNOWN = new ImageType("UNKNOWN", 4, false);
            $VALUES = (new ImageType[] {
                GIF, JPEG, PNG_A, PNG, UNKNOWN
            });
        }

        private ImageType(String s, int i, boolean flag)
        {
            super(s, i);
            hasAlpha = flag;
        }
    }

    private static class RandomAccessReader
    {

        private final ByteBuffer data;

        public short getInt16(int i)
        {
            return data.getShort(i);
        }

        public int getInt32(int i)
        {
            return data.getInt(i);
        }

        public int length()
        {
            return data.array().length;
        }

        public void order(ByteOrder byteorder)
        {
            data.order(byteorder);
        }

        public RandomAccessReader(byte abyte0[])
        {
            data = ByteBuffer.wrap(abyte0);
            data.order(ByteOrder.BIG_ENDIAN);
        }
    }

    private static class StreamReader
    {

        private final InputStream is;

        public int getByte()
            throws IOException
        {
            return is.read();
        }

        public int getUInt16()
            throws IOException
        {
            return is.read() << 8 & 0xff00 | is.read() & 0xff;
        }

        public short getUInt8()
            throws IOException
        {
            return (short)(is.read() & 0xff);
        }

        public int read(byte abyte0[])
            throws IOException
        {
            return is.read(abyte0);
        }

        public long skip(long l)
            throws IOException
        {
            return is.skip(l);
        }

        public StreamReader(InputStream inputstream)
        {
            is = inputstream;
        }
    }


    private static final int BYTES_PER_FORMAT[];
    private static final byte JPEG_EXIF_SEGMENT_PREAMBLE_BYTES[];
    private final StreamReader streamReader;

    public ImageHeaderParser(InputStream inputstream)
    {
        streamReader = new StreamReader(inputstream);
    }

    private static int calcTagOffset(int i, int j)
    {
        return i + 2 + j * 12;
    }

    private byte[] getExifSegment()
        throws IOException
    {
_L6:
        short word0 = streamReader.getUInt8();
        if (word0 == 255) goto _L2; else goto _L1
_L1:
        byte abyte0[];
        if (Log.isLoggable("ImageHeaderParser", 3))
        {
            Log.d("ImageHeaderParser", (new StringBuilder()).append("Unknown segmentId=").append(word0).toString());
        }
        abyte0 = null;
_L4:
        return abyte0;
_L2:
        byte abyte1[];
        int i;
        word0 = streamReader.getUInt8();
        if (word0 == 218)
        {
            return null;
        }
        if (word0 == 217)
        {
            if (Log.isLoggable("ImageHeaderParser", 3))
            {
                Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
            }
            return null;
        }
        i = streamReader.getUInt16() - 2;
        if (word0 != 225)
        {
            if ((long)i != streamReader.skip(i))
            {
                if (Log.isLoggable("ImageHeaderParser", 3))
                {
                    Log.d("ImageHeaderParser", (new StringBuilder()).append("Unable to skip enough data for type=").append(word0).toString());
                }
                return null;
            }
            continue; /* Loop/switch isn't completed */
        }
        abyte1 = new byte[i];
        abyte0 = abyte1;
        if (i == streamReader.read(abyte1)) goto _L4; else goto _L3
_L3:
        if (Log.isLoggable("ImageHeaderParser", 3))
        {
            Log.d("ImageHeaderParser", (new StringBuilder()).append("Unable to read segment data for type=").append(word0).append(" length=").append(i).toString());
        }
        return null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static boolean handles(int i)
    {
        return (i & 0xffd8) == 65496 || i == 19789 || i == 18761;
    }

    private static int parseExifSegment(RandomAccessReader randomaccessreader)
    {
        int i = "Exif\000\0".length();
        int j = randomaccessreader.getInt16(i);
        ByteOrder byteorder;
        if (j == 19789)
        {
            byteorder = ByteOrder.BIG_ENDIAN;
        } else
        if (j == 18761)
        {
            byteorder = ByteOrder.LITTLE_ENDIAN;
        } else
        {
            if (Log.isLoggable("ImageHeaderParser", 3))
            {
                Log.d("ImageHeaderParser", (new StringBuilder()).append("Unknown endianness = ").append(j).toString());
            }
            byteorder = ByteOrder.BIG_ENDIAN;
        }
        do
        {
            randomaccessreader.order(byteorder);
            j = randomaccessreader.getInt32(i + 4) + i;
            short word0 = randomaccessreader.getInt16(j);
            i = 0;
            while (i < word0) 
            {
                int k = calcTagOffset(j, i);
                short word1 = randomaccessreader.getInt16(k);
                if (word1 == 274)
                {
                    short word2 = randomaccessreader.getInt16(k + 2);
                    if (word2 < 1 || word2 > 12)
                    {
                        if (Log.isLoggable("ImageHeaderParser", 3))
                        {
                            Log.d("ImageHeaderParser", (new StringBuilder()).append("Got invalid format code = ").append(word2).toString());
                        }
                    } else
                    {
                        int l = randomaccessreader.getInt32(k + 4);
                        if (l < 0)
                        {
                            if (Log.isLoggable("ImageHeaderParser", 3))
                            {
                                Log.d("ImageHeaderParser", "Negative tiff component count");
                            }
                        } else
                        {
                            if (Log.isLoggable("ImageHeaderParser", 3))
                            {
                                Log.d("ImageHeaderParser", (new StringBuilder()).append("Got tagIndex=").append(i).append(" tagType=").append(word1).append(" formatCode =").append(word2).append(" componentCount=").append(l).toString());
                            }
                            l += BYTES_PER_FORMAT[word2];
                            if (l > 4)
                            {
                                if (Log.isLoggable("ImageHeaderParser", 3))
                                {
                                    Log.d("ImageHeaderParser", (new StringBuilder()).append("Got byte count > 4, not orientation, continuing, formatCode=").append(word2).toString());
                                }
                            } else
                            {
                                k += 8;
                                if (k < 0 || k > randomaccessreader.length())
                                {
                                    if (Log.isLoggable("ImageHeaderParser", 3))
                                    {
                                        Log.d("ImageHeaderParser", (new StringBuilder()).append("Illegal tagValueOffset=").append(k).append(" tagType=").append(word1).toString());
                                    }
                                } else
                                if (l < 0 || k + l > randomaccessreader.length())
                                {
                                    if (Log.isLoggable("ImageHeaderParser", 3))
                                    {
                                        Log.d("ImageHeaderParser", (new StringBuilder()).append("Illegal number of bytes for TI tag data tagType=").append(word1).toString());
                                    }
                                } else
                                {
                                    return randomaccessreader.getInt16(k);
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

    public int getOrientation()
        throws IOException
    {
        if (handles(streamReader.getUInt16())) goto _L2; else goto _L1
_L1:
        return -1;
_L2:
        int i;
        byte abyte0[] = getExifSegment();
        boolean flag;
        boolean flag1;
        if (abyte0 != null && abyte0.length > JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = 0;
_L4:
        flag1 = flag;
        if (i >= JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (abyte0[i] == JPEG_EXIF_SEGMENT_PREAMBLE_BYTES[i])
        {
            break MISSING_BLOCK_LABEL_91;
        }
        flag1 = false;
        if (!flag1) goto _L1; else goto _L3
_L3:
        return parseExifSegment(new RandomAccessReader(abyte0));
        i++;
          goto _L4
    }

    public ImageType getType()
        throws IOException
    {
        int i = streamReader.getUInt16();
        if (i == 65496)
        {
            return ImageType.JPEG;
        }
        i = i << 16 & 0xffff0000 | streamReader.getUInt16() & 0xffff;
        if (i == 0x89504e47)
        {
            streamReader.skip(21L);
            if (streamReader.getByte() >= 3)
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
        } else
        {
            return ImageType.UNKNOWN;
        }
    }

    public boolean hasAlpha()
        throws IOException
    {
        return getType().hasAlpha();
    }

    static 
    {
        byte abyte0[];
        BYTES_PER_FORMAT = (new int[] {
            0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 
            8, 4, 8
        });
        abyte0 = new byte[0];
        byte abyte1[] = "Exif\000\0".getBytes("UTF-8");
        abyte0 = abyte1;
_L2:
        JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = abyte0;
        return;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
