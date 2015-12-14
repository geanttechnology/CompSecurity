// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.exif2;

import android.util.Log;
import android.util.SparseIntArray;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

// Referenced classes of package it.sephiroth.android.library.exif2:
//            ExifInterface, ExifInvalidFormatException, CountedDataInputStream, ExifTag, 
//            Rational

class ExifParser
{
    private static class ExifTagEvent
    {

        boolean isRequested;
        ExifTag tag;

        ExifTagEvent(ExifTag exiftag, boolean flag)
        {
            tag = exiftag;
            isRequested = flag;
        }
    }

    private static class IfdEvent
    {

        int ifd;
        boolean isRequested;

        IfdEvent(int i, boolean flag)
        {
            ifd = i;
            isRequested = flag;
        }
    }

    private static class ImageEvent
    {

        int stripIndex;
        int type;

        ImageEvent(int i)
        {
            stripIndex = 0;
            type = i;
        }

        ImageEvent(int i, int j)
        {
            type = i;
            stripIndex = j;
        }
    }

    public static class Section
    {

        byte data[];
        int size;
        int type;

        public Section()
        {
        }
    }


    protected static final short BIG_ENDIAN_TAG = 19789;
    protected static final int DEFAULT_IFD0_OFFSET = 8;
    public static final int EVENT_COMPRESSED_IMAGE = 3;
    public static final int EVENT_END = 5;
    public static final int EVENT_NEW_TAG = 1;
    public static final int EVENT_START_OF_IFD = 0;
    public static final int EVENT_UNCOMPRESSED_STRIP = 4;
    public static final int EVENT_VALUE_OF_REGISTERED_TAG = 2;
    protected static final int EXIF_HEADER = 0x45786966;
    protected static final short EXIF_HEADER_TAIL = 0;
    protected static final short LITTLE_ENDIAN_TAG = 18761;
    protected static final int OFFSET_SIZE = 2;
    private static final String TAG = "ExifParser";
    private static final short TAG_EXIF_IFD;
    private static final short TAG_GPS_IFD;
    private static final short TAG_INTEROPERABILITY_IFD;
    private static final short TAG_JPEG_INTERCHANGE_FORMAT;
    private static final short TAG_JPEG_INTERCHANGE_FORMAT_LENGTH;
    protected static final int TAG_SIZE = 12;
    private static final short TAG_STRIP_BYTE_COUNTS;
    private static final short TAG_STRIP_OFFSETS;
    protected static final short TIFF_HEADER_TAIL = 42;
    private static final Charset US_ASCII = Charset.forName("US-ASCII");
    static final int deftabs[][] = {
        std_luminance_quant_tbl, std_chrominance_quant_tbl
    };
    static final int std_chrominance_quant_tbl[] = {
        17, 18, 18, 24, 21, 24, 47, 26, 26, 47, 
        99, 66, 56, 66, 99, 99, 99, 99, 99, 99, 
        99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 
        99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 
        99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 
        99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 
        99, 99, 99, 99
    };
    static final int std_luminance_quant_tbl[] = {
        16, 11, 12, 14, 12, 10, 16, 14, 13, 14, 
        18, 17, 16, 19, 24, 40, 26, 24, 22, 22, 
        24, 49, 35, 37, 29, 40, 58, 51, 61, 60, 
        57, 51, 56, 55, 64, 72, 92, 78, 64, 68, 
        87, 69, 55, 56, 80, 109, 81, 87, 95, 98, 
        103, 104, 103, 62, 77, 113, 121, 112, 100, 120, 
        92, 101, 103, 99
    };
    private final byte mByteArray[] = new byte[8];
    private final ByteBuffer mByteBuffer;
    private final TreeMap mCorrespondingEvent = new TreeMap();
    private byte mDataAboveIfd0[];
    private int mIfd0Position;
    private int mIfdStartOffset;
    private int mIfdType;
    private ImageEvent mImageEvent;
    private int mImageLength;
    private int mImageWidth;
    private final ExifInterface mInterface;
    private ExifTag mJpegSizeTag;
    private boolean mNeedToParseOffsetsInCurrentIfd;
    private int mNumOfTagInIfd;
    private final int mOptions;
    private short mProcess;
    private int mQualityGuess;
    private List mSections;
    private ExifTag mStripSizeTag;
    private ExifTag mTag;
    private final CountedDataInputStream mTiffStream;
    private int mUncompressedDataPosition;

    private ExifParser(InputStream inputstream, int i, ExifInterface exifinterface)
        throws IOException, ExifInvalidFormatException
    {
        mIfdStartOffset = 0;
        mNumOfTagInIfd = 0;
        mProcess = 0;
        mUncompressedDataPosition = 0;
        mByteBuffer = ByteBuffer.wrap(mByteArray);
        if (inputstream == null)
        {
            throw new IOException("Null argument inputStream to ExifParser");
        }
        Log.v("ExifParser", "Reading exif...");
        mSections = new ArrayList(0);
        mInterface = exifinterface;
        mTiffStream = seekTiffData(inputstream);
        mOptions = i;
        if (mTiffStream != null)
        {
            parseTiffHeader(mTiffStream);
            long l = mTiffStream.readUnsignedInt();
            if (l > 0x7fffffffL)
            {
                throw new ExifInvalidFormatException((new StringBuilder()).append("Invalid offset ").append(l).toString());
            }
            mIfd0Position = (int)l;
            mIfdType = 0;
            if (isIfdRequested(0) || needToParseOffsetsInCurrentIfd())
            {
                registerIfd(0, l);
                if (l != 8L)
                {
                    mDataAboveIfd0 = new byte[(int)l - 8];
                    read(mDataAboveIfd0);
                    return;
                }
            }
        }
    }

    static int Get16m(byte abyte0[], int i)
    {
        return (abyte0[i] & 0xff) << 8 | abyte0[i + 1] & 0xff;
    }

    private void checkOffsetOrImageTag(ExifTag exiftag)
    {
        if (exiftag.getComponentCount() != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        int j;
        i = exiftag.getTagId();
        j = exiftag.getIfd();
        if (i == TAG_EXIF_IFD && checkAllowed(j, ExifInterface.TAG_EXIF_IFD))
        {
            if (isIfdRequested(2) || isIfdRequested(3))
            {
                registerIfd(2, exiftag.getValueAt(0));
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (i == TAG_GPS_IFD && checkAllowed(j, ExifInterface.TAG_GPS_IFD))
        {
            if (isIfdRequested(4))
            {
                registerIfd(4, exiftag.getValueAt(0));
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (i == TAG_INTEROPERABILITY_IFD && checkAllowed(j, ExifInterface.TAG_INTEROPERABILITY_IFD))
        {
            if (isIfdRequested(3))
            {
                registerIfd(3, exiftag.getValueAt(0));
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (i == TAG_JPEG_INTERCHANGE_FORMAT && checkAllowed(j, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT))
        {
            if (isThumbnailRequested())
            {
                registerCompressedImage(exiftag.getValueAt(0));
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (i == TAG_JPEG_INTERCHANGE_FORMAT_LENGTH && checkAllowed(j, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH))
        {
            if (isThumbnailRequested())
            {
                mJpegSizeTag = exiftag;
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (i != TAG_STRIP_OFFSETS || !checkAllowed(j, ExifInterface.TAG_STRIP_OFFSETS))
        {
            break; /* Loop/switch isn't completed */
        }
        if (isThumbnailRequested())
        {
            if (exiftag.hasValue())
            {
                i = 0;
                while (i < exiftag.getComponentCount()) 
                {
                    if (exiftag.getDataType() == 3)
                    {
                        registerUncompressedStrip(i, exiftag.getValueAt(i));
                    } else
                    {
                        registerUncompressedStrip(i, exiftag.getValueAt(i));
                    }
                    i++;
                }
            } else
            {
                mCorrespondingEvent.put(Integer.valueOf(exiftag.getOffset()), new ExifTagEvent(exiftag, false));
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (i != TAG_STRIP_BYTE_COUNTS || !checkAllowed(j, ExifInterface.TAG_STRIP_BYTE_COUNTS) || !isThumbnailRequested() || !exiftag.hasValue()) goto _L1; else goto _L4
_L4:
        mStripSizeTag = exiftag;
        return;
    }

    private boolean isIfdRequested(int i)
    {
        boolean flag = true;
        i;
        JVM INSTR tableswitch 0 4: default 36
    //                   0 40
    //                   1 51
    //                   2 62
    //                   3 85
    //                   4 73;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        flag = false;
_L8:
        return flag;
_L2:
        if ((mOptions & 1) == 0)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if ((mOptions & 2) == 0)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if ((mOptions & 4) == 0)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if ((mOptions & 8) == 0)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if ((mOptions & 0x10) == 0)
        {
            return false;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    private boolean isThumbnailRequested()
    {
        return (mOptions & 0x20) != 0;
    }

    private boolean needToParseOffsetsInCurrentIfd()
    {
        mIfdType;
        JVM INSTR tableswitch 0 2: default 32
    //                   0 34
    //                   1 68
    //                   2 73;
           goto _L1 _L2 _L3 _L4
_L1:
        return false;
_L2:
        if (isIfdRequested(2) || isIfdRequested(4) || isIfdRequested(3) || isIfdRequested(1))
        {
            return true;
        }
          goto _L1
_L3:
        return isThumbnailRequested();
_L4:
        return isIfdRequested(3);
    }

    protected static ExifParser parse(InputStream inputstream, int i, ExifInterface exifinterface)
        throws IOException, ExifInvalidFormatException
    {
        return new ExifParser(inputstream, i, exifinterface);
    }

    private void parseTiffHeader(CountedDataInputStream counteddatainputstream)
        throws IOException, ExifInvalidFormatException
    {
        short word0 = counteddatainputstream.readShort();
        if (18761 == word0)
        {
            counteddatainputstream.setByteOrder(ByteOrder.LITTLE_ENDIAN);
        } else
        if (19789 == word0)
        {
            counteddatainputstream.setByteOrder(ByteOrder.BIG_ENDIAN);
        } else
        {
            throw new ExifInvalidFormatException("Invalid TIFF header");
        }
        if (counteddatainputstream.readShort() != 42)
        {
            throw new ExifInvalidFormatException("Invalid TIFF header");
        } else
        {
            return;
        }
    }

    private void process_M_DQT(byte abyte0[], int i)
    {
        i = 2;
        double d = 0.0D;
        int ai[] = null;
        boolean flag = true;
        while (i < abyte0.length) 
        {
            int k = i + 1;
            byte byte0 = abyte0[i];
            int k1 = byte0 & 0xf;
            if (k1 < 2)
            {
                ai = deftabs[k1];
            }
            int j = 0;
            double d1 = d;
            i = k;
            while (j < 64) 
            {
                boolean flag1;
                int j1;
                if (byte0 >> 4 != 0)
                {
                    int l = i + 1;
                    i = abyte0[i];
                    j1 = abyte0[l] + i * 256;
                    i = l + 1;
                } else
                {
                    int i1 = i + 1;
                    j1 = abyte0[i];
                    i = i1;
                }
                flag1 = flag;
                d = d1;
                if (ai != null)
                {
                    d1 += (100D * (double)j1) / (double)ai[j];
                    flag1 = flag;
                    d = d1;
                    if (j1 != 1)
                    {
                        flag1 = false;
                        d = d1;
                    }
                }
                j++;
                flag = flag1;
                d1 = d;
            }
            if (ai != null)
            {
                d1 /= 64D;
                if (flag)
                {
                    d = 100D;
                } else
                if (d1 <= 100D)
                {
                    d = (200D - d1) / 2D;
                } else
                {
                    d = 5000D / d1;
                }
                if (k1 == 0)
                {
                    mQualityGuess = (int)(0.5D + d);
                }
                d = d1;
            } else
            {
                d = d1;
            }
        }
    }

    private void process_M_SOFn(byte abyte0[], int i)
    {
        if (abyte0.length > 7)
        {
            mImageLength = Get16m(abyte0, 3);
            mImageWidth = Get16m(abyte0, 5);
        }
        mProcess = (short)i;
    }

    private int readBytes(InputStream inputstream, byte abyte0[], int i, int j)
        throws IOException
    {
        int l = 0;
        int i1 = Math.min(1024, j);
        int k = i;
        i = i1;
        do
        {
            int j1 = inputstream.read(abyte0, k, i);
            if (j1 > 0)
            {
                l += j1;
                k += j1;
                i = Math.min(i, j - l);
            } else
            {
                return l;
            }
        } while (true);
    }

    private int readInt(byte abyte0[], int i)
    {
        mByteBuffer.rewind();
        mByteBuffer.put(abyte0, i, 4);
        mByteBuffer.rewind();
        return mByteBuffer.getInt();
    }

    private short readShort(byte abyte0[], int i)
    {
        mByteBuffer.rewind();
        mByteBuffer.put(abyte0, i, 2);
        mByteBuffer.rewind();
        return mByteBuffer.getShort();
    }

    private ExifTag readTag()
        throws IOException, ExifInvalidFormatException
    {
        short word0 = mTiffStream.readShort();
        short word1 = mTiffStream.readShort();
        long l = mTiffStream.readUnsignedInt();
        if (l > 0x7fffffffL)
        {
            throw new ExifInvalidFormatException("Number of component is larger then Integer.MAX_VALUE");
        }
        if (!ExifTag.isValidType(word1))
        {
            Log.w("ExifParser", String.format("Tag %04x: Invalid data type %d", new Object[] {
                Short.valueOf(word0), Short.valueOf(word1)
            }));
            mTiffStream.skip(4L);
            return null;
        }
        int i = (int)l;
        int j = mIfdType;
        ExifTag exiftag;
        boolean flag;
        if ((int)l != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        exiftag = new ExifTag(word0, word1, i, j, flag);
        i = exiftag.getDataSize();
        if (i > 4)
        {
            long l1 = mTiffStream.readUnsignedInt();
            if (l1 > 0x7fffffffL)
            {
                throw new ExifInvalidFormatException("offset is larger then Integer.MAX_VALUE");
            }
            if (l1 < (long)mIfd0Position && word1 == 7)
            {
                byte abyte0[] = new byte[(int)l];
                System.arraycopy(mDataAboveIfd0, (int)l1 - 8, abyte0, 0, (int)l);
                exiftag.setValue(abyte0);
                return exiftag;
            } else
            {
                exiftag.setOffset((int)l1);
                return exiftag;
            }
        } else
        {
            boolean flag1 = exiftag.hasDefinedCount();
            exiftag.setHasDefinedCount(false);
            readFullTagValue(exiftag);
            exiftag.setHasDefinedCount(flag1);
            mTiffStream.skip(4 - i);
            exiftag.setOffset(mTiffStream.getReadByteCount() - 4);
            return exiftag;
        }
    }

    private void registerCompressedImage(long l)
    {
        mCorrespondingEvent.put(Integer.valueOf((int)l), new ImageEvent(3));
    }

    private void registerIfd(int i, long l)
    {
        mCorrespondingEvent.put(Integer.valueOf((int)l), new IfdEvent(i, isIfdRequested(i)));
    }

    private void registerUncompressedStrip(int i, long l)
    {
        mCorrespondingEvent.put(Integer.valueOf((int)l), new ImageEvent(4, i));
    }

    private CountedDataInputStream seekTiffData(InputStream inputstream)
        throws IOException, ExifInvalidFormatException
    {
        Object obj;
        CountedDataInputStream counteddatainputstream;
        counteddatainputstream = new CountedDataInputStream(inputstream);
        obj = null;
        int i = counteddatainputstream.readUnsignedByte();
        int k = counteddatainputstream.readUnsignedByte();
        if (i != 255 || k != 216)
        {
            Log.e("ExifParser", "invalid jpeg header");
            return null;
        }
          goto _L1
_L7:
        byte abyte0[];
        int j;
        int l;
        int j1;
        process_M_DQT(abyte0, j1);
        inputstream = ((InputStream) (obj));
        j = l;
        continue; /* Loop/switch isn't completed */
_L12:
        byte byte0;
        byte byte1;
        Section section;
        int i1;
        if (j == 0)
        {
            mSections.add(section);
            obj = inputstream;
        } else
        {
            Log.v("ExifParser", (new StringBuilder()).append("ignoring marker: ").append(String.format("0x%2X", new Object[] {
                Integer.valueOf(i1)
            })).append(", length: ").append(j1).toString());
            obj = inputstream;
        }
_L1:
        l = 0;
        j = 0;
        do
        {
            i1 = counteddatainputstream.readUnsignedByte();
            if (i1 != 255 && l == 255)
            {
                if (j > 10)
                {
                    Log.w("ExifParser", (new StringBuilder()).append("Extraneous ").append(j - 1).append(" padding bytes before section ").append(i1).toString());
                }
                section = new Section();
                section.type = i1;
                byte0 = counteddatainputstream.readByte();
                byte1 = counteddatainputstream.readByte();
                j1 = (byte0 & 0xff) << 8 | byte1 & 0xff;
                if (j1 < 2)
                {
                    throw new ExifInvalidFormatException("Invalid marker");
                }
                break;
            }
            l = i1;
            j++;
        } while (true);
        section.size = j1;
        abyte0 = new byte[j1];
        abyte0[0] = byte0;
        abyte0[1] = byte1;
        j = readBytes(counteddatainputstream, abyte0, 2, j1 - 2);
        if (j != j1 - 2)
        {
            throw new ExifInvalidFormatException((new StringBuilder()).append("Premature end of file? Expecting ").append(j1 - 2).append(", received ").append(j).toString());
        }
        section.data = abyte0;
        l = 0;
        j = l;
        inputstream = ((InputStream) (obj));
        i1;
        JVM INSTR lookupswitch 21: default 524
    //                   192: 655
    //                   193: 655
    //                   194: 655
    //                   195: 655
    //                   196: 69
    //                   197: 655
    //                   198: 655
    //                   199: 655
    //                   201: 655
    //                   202: 655
    //                   203: 655
    //                   205: 655
    //                   206: 655
    //                   207: 655
    //                   217: 612
    //                   218: 588
    //                   219: 54
    //                   224: 632
    //                   225: 673
    //                   237: 69
    //                   254: 623;
           goto _L2 _L3 _L3 _L3 _L3 _L4 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L5 _L6 _L7 _L8 _L9 _L4 _L10
_L4:
        continue; /* Loop/switch isn't completed */
_L2:
        Log.w("ExifParser", (new StringBuilder()).append("Unknown marker: ").append(String.format("0x%2X", new Object[] {
            Integer.valueOf(i1)
        })).append(", length: ").append(j1).toString());
        j = l;
        inputstream = ((InputStream) (obj));
        continue; /* Loop/switch isn't completed */
_L6:
        mSections.add(section);
        mUncompressedDataPosition = counteddatainputstream.getReadByteCount();
        return ((CountedDataInputStream) (obj));
_L5:
        Log.w("ExifParser", "No image in jpeg!");
        return null;
_L10:
        j = 1;
        inputstream = ((InputStream) (obj));
        continue; /* Loop/switch isn't completed */
_L8:
        j = l;
        inputstream = ((InputStream) (obj));
        if (j1 < 16)
        {
            j = 1;
            inputstream = ((InputStream) (obj));
        }
        continue; /* Loop/switch isn't completed */
_L3:
        process_M_SOFn(abyte0, i1);
        j = l;
        inputstream = ((InputStream) (obj));
        continue; /* Loop/switch isn't completed */
_L9:
        j = l;
        inputstream = ((InputStream) (obj));
        if (j1 >= 8)
        {
            j = readInt(abyte0, 2);
            short word0 = readShort(abyte0, 6);
            if (j == 0x45786966 && word0 == 0)
            {
                inputstream = new CountedDataInputStream(new ByteArrayInputStream(abyte0, 8, j1 - 8));
                inputstream.setEnd(j1 - 6);
                j = 0;
            } else
            {
                Log.v("ExifParser", "Image cotains XMP section");
                j = l;
                inputstream = ((InputStream) (obj));
            }
        }
        if (true) goto _L12; else goto _L11
_L11:
    }

    private void skipTo(int i)
        throws IOException
    {
        mTiffStream.skipTo(i);
        for (; !mCorrespondingEvent.isEmpty() && ((Integer)mCorrespondingEvent.firstKey()).intValue() < i; mCorrespondingEvent.pollFirstEntry()) { }
    }

    public boolean checkAllowed(int i, int j)
    {
        j = mInterface.getTagInfo().get(j);
        if (j == 0)
        {
            return false;
        } else
        {
            return ExifInterface.isIfdAllowed(j, i);
        }
    }

    protected ByteOrder getByteOrder()
    {
        if (mTiffStream != null)
        {
            return mTiffStream.getByteOrder();
        } else
        {
            return null;
        }
    }

    protected int getCompressedImageSize()
    {
        if (mJpegSizeTag == null)
        {
            return 0;
        } else
        {
            return (int)mJpegSizeTag.getValueAt(0);
        }
    }

    protected int getCurrentIfd()
    {
        return mIfdType;
    }

    public int getImageLength()
    {
        return mImageLength;
    }

    public int getImageWidth()
    {
        return mImageWidth;
    }

    public short getJpegProcess()
    {
        return mProcess;
    }

    public int getQualityGuess()
    {
        return mQualityGuess;
    }

    public List getSections()
    {
        return mSections;
    }

    protected int getStripIndex()
    {
        return mImageEvent.stripIndex;
    }

    protected int getStripSize()
    {
        if (mStripSizeTag == null)
        {
            return 0;
        } else
        {
            return (int)mStripSizeTag.getValueAt(0);
        }
    }

    protected ExifTag getTag()
    {
        return mTag;
    }

    public int getTagCountInCurrentIfd()
    {
        return mNumOfTagInIfd;
    }

    public int getUncompressedDataPosition()
    {
        return mUncompressedDataPosition;
    }

    public boolean isDefinedTag(int i, int j)
    {
        return mInterface.getTagInfo().get(ExifInterface.defineTag(i, (short)j)) != 0;
    }

    protected int next()
        throws IOException, ExifInvalidFormatException
    {
        if (mTiffStream == null)
        {
            return 5;
        }
        int i = mTiffStream.getReadByteCount();
        int k = mIfdStartOffset + 2 + mNumOfTagInIfd * 12;
        if (i < k)
        {
            mTag = readTag();
            if (mTag == null)
            {
                return next();
            }
            if (mNeedToParseOffsetsInCurrentIfd)
            {
                checkOffsetOrImageTag(mTag);
            }
            return 1;
        }
        if (i == k)
        {
            if (mIfdType == 0)
            {
                long l = readUnsignedLong();
                if ((isIfdRequested(1) || isThumbnailRequested()) && l != 0L)
                {
                    registerIfd(1, l);
                }
            } else
            {
                int j = 4;
                if (mCorrespondingEvent.size() > 0)
                {
                    j = ((Integer)mCorrespondingEvent.firstEntry().getKey()).intValue() - mTiffStream.getReadByteCount();
                }
                if (j < 4)
                {
                    Log.w("ExifParser", (new StringBuilder()).append("Invalid size of link to next IFD: ").append(j).toString());
                } else
                {
                    long l1 = readUnsignedLong();
                    if (l1 != 0L)
                    {
                        Log.w("ExifParser", (new StringBuilder()).append("Invalid link to next IFD: ").append(l1).toString());
                    }
                }
            }
        }
        do
        {
            if (mCorrespondingEvent.size() == 0)
            {
                break;
            }
            java.util.Map.Entry entry = mCorrespondingEvent.pollFirstEntry();
            Object obj = entry.getValue();
            try
            {
                skipTo(((Integer)entry.getKey()).intValue());
            }
            catch (IOException ioexception)
            {
                Log.w("ExifParser", (new StringBuilder()).append("Failed to skip to data at: ").append(entry.getKey()).append(" for ").append(obj.getClass().getName()).append(", the file may be broken.").toString());
                continue;
            }
            if (obj instanceof IfdEvent)
            {
                mIfdType = ((IfdEvent)obj).ifd;
                mNumOfTagInIfd = mTiffStream.readUnsignedShort();
                mIfdStartOffset = ((Integer)entry.getKey()).intValue();
                if (mNumOfTagInIfd * 12 + mIfdStartOffset + 2 > mTiffStream.getEnd())
                {
                    Log.w("ExifParser", (new StringBuilder()).append("Invalid size of IFD ").append(mIfdType).toString());
                    return 5;
                }
                mNeedToParseOffsetsInCurrentIfd = needToParseOffsetsInCurrentIfd();
                if (((IfdEvent)obj).isRequested)
                {
                    return 0;
                }
                skipRemainingTagsInCurrentIfd();
            } else
            {
                if (obj instanceof ImageEvent)
                {
                    mImageEvent = (ImageEvent)obj;
                    return mImageEvent.type;
                }
                ExifTagEvent exiftagevent = (ExifTagEvent)obj;
                mTag = exiftagevent.tag;
                if (mTag.getDataType() != 7)
                {
                    readFullTagValue(mTag);
                    checkOffsetOrImageTag(mTag);
                }
                if (exiftagevent.isRequested)
                {
                    return 2;
                }
            }
        } while (true);
        return 5;
    }

    protected int read(byte abyte0[])
        throws IOException
    {
        return mTiffStream.read(abyte0);
    }

    protected int read(byte abyte0[], int i, int j)
        throws IOException
    {
        return mTiffStream.read(abyte0, i, j);
    }

    protected void readFullTagValue(ExifTag exiftag)
        throws IOException
    {
        int j = exiftag.getDataType();
        int i = exiftag.getComponentCount();
        if (i >= 0x66000000)
        {
            throw new IOException("size out of bounds");
        }
        if (j == 2 || j == 7 || j == 1)
        {
            j = exiftag.getComponentCount();
            if (mCorrespondingEvent.size() > 0 && ((Integer)mCorrespondingEvent.firstEntry().getKey()).intValue() < mTiffStream.getReadByteCount() + j)
            {
                Object obj = mCorrespondingEvent.firstEntry().getValue();
                if (obj instanceof ImageEvent)
                {
                    Log.w("ExifParser", (new StringBuilder()).append("Thumbnail overlaps value for tag: \n").append(exiftag.toString()).toString());
                    obj = mCorrespondingEvent.pollFirstEntry();
                    Log.w("ExifParser", (new StringBuilder()).append("Invalid thumbnail offset: ").append(((java.util.Map.Entry) (obj)).getKey()).toString());
                } else
                {
                    if (obj instanceof IfdEvent)
                    {
                        Log.w("ExifParser", (new StringBuilder()).append("Ifd ").append(((IfdEvent)obj).ifd).append(" overlaps value for tag: \n").append(exiftag.toString()).toString());
                    } else
                    if (obj instanceof ExifTagEvent)
                    {
                        Log.w("ExifParser", (new StringBuilder()).append("Tag value for tag: \n").append(((ExifTagEvent)obj).tag.toString()).append(" overlaps value for tag: \n").append(exiftag.toString()).toString());
                    }
                    j = ((Integer)mCorrespondingEvent.firstEntry().getKey()).intValue() - mTiffStream.getReadByteCount();
                    Log.w("ExifParser", (new StringBuilder()).append("Invalid size of tag: \n").append(exiftag.toString()).append(" setting count to: ").append(j).toString());
                    exiftag.forceSetComponentCount(j);
                }
            }
        }
        Rational arational1[];
        switch (exiftag.getDataType())
        {
        case 6: // '\006'
        case 8: // '\b'
        default:
            return;

        case 1: // '\001'
        case 7: // '\007'
            byte abyte0[] = new byte[i];
            read(abyte0);
            exiftag.setValue(abyte0);
            return;

        case 2: // '\002'
            exiftag.setValue(readString(i));
            return;

        case 4: // '\004'
            long al[] = new long[i];
            i = 0;
            for (j = al.length; i < j; i++)
            {
                al[i] = readUnsignedLong();
            }

            exiftag.setValue(al);
            return;

        case 5: // '\005'
            Rational arational[] = new Rational[i];
            i = 0;
            for (j = arational.length; i < j; i++)
            {
                arational[i] = readUnsignedRational();
            }

            exiftag.setValue(arational);
            return;

        case 3: // '\003'
            int ai[] = new int[i];
            i = 0;
            for (j = ai.length; i < j; i++)
            {
                ai[i] = readUnsignedShort();
            }

            exiftag.setValue(ai);
            return;

        case 9: // '\t'
            int ai1[] = new int[i];
            i = 0;
            for (j = ai1.length; i < j; i++)
            {
                ai1[i] = readLong();
            }

            exiftag.setValue(ai1);
            return;

        case 10: // '\n'
            arational1 = new Rational[i];
            i = 0;
            j = arational1.length;
            break;
        }
        for (; i < j; i++)
        {
            arational1[i] = readRational();
        }

        exiftag.setValue(arational1);
    }

    protected int readLong()
        throws IOException
    {
        return mTiffStream.readInt();
    }

    protected Rational readRational()
        throws IOException
    {
        int i = readLong();
        int j = readLong();
        return new Rational(i, j);
    }

    protected String readString(int i)
        throws IOException
    {
        return readString(i, US_ASCII);
    }

    protected String readString(int i, Charset charset)
        throws IOException
    {
        if (i > 0)
        {
            return mTiffStream.readString(i, charset);
        } else
        {
            return "";
        }
    }

    protected long readUnsignedLong()
        throws IOException
    {
        return (long)readLong() & 0xffffffffL;
    }

    protected Rational readUnsignedRational()
        throws IOException
    {
        return new Rational(readUnsignedLong(), readUnsignedLong());
    }

    protected int readUnsignedShort()
        throws IOException
    {
        return mTiffStream.readShort() & 0xffff;
    }

    protected void registerForTagValue(ExifTag exiftag)
    {
        if (exiftag.getOffset() >= mTiffStream.getReadByteCount())
        {
            mCorrespondingEvent.put(Integer.valueOf(exiftag.getOffset()), new ExifTagEvent(exiftag, true));
        }
    }

    protected void skipRemainingTagsInCurrentIfd()
        throws IOException, ExifInvalidFormatException
    {
        int k = mIfdStartOffset + 2 + mNumOfTagInIfd * 12;
        int i = mTiffStream.getReadByteCount();
        if (i <= k)
        {
            if (mNeedToParseOffsetsInCurrentIfd)
            {
                do
                {
                    if (i >= k)
                    {
                        break;
                    }
                    mTag = readTag();
                    int j = i + 12;
                    i = j;
                    if (mTag != null)
                    {
                        checkOffsetOrImageTag(mTag);
                        i = j;
                    }
                } while (true);
            } else
            {
                skipTo(k);
            }
            long l = readUnsignedLong();
            if (mIfdType == 0 && (isIfdRequested(1) || isThumbnailRequested()) && l > 0L)
            {
                registerIfd(1, l);
                return;
            }
        }
    }

    static 
    {
        TAG_EXIF_IFD = ExifInterface.getTrueTagKey(ExifInterface.TAG_EXIF_IFD);
        TAG_GPS_IFD = ExifInterface.getTrueTagKey(ExifInterface.TAG_GPS_IFD);
        TAG_INTEROPERABILITY_IFD = ExifInterface.getTrueTagKey(ExifInterface.TAG_INTEROPERABILITY_IFD);
        TAG_JPEG_INTERCHANGE_FORMAT = ExifInterface.getTrueTagKey(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT);
        TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = ExifInterface.getTrueTagKey(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        TAG_STRIP_OFFSETS = ExifInterface.getTrueTagKey(ExifInterface.TAG_STRIP_OFFSETS);
        TAG_STRIP_BYTE_COUNTS = ExifInterface.getTrueTagKey(ExifInterface.TAG_STRIP_BYTE_COUNTS);
    }
}
