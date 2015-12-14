// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.exif2;

import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package it.sephiroth.android.library.exif2:
//            ExifData, ExifInterface, IfdData, ExifTag, 
//            OrderedDataOutputStream

class ExifOutputStream
{

    private static final int EXIF_HEADER = 0x45786966;
    private static final int MAX_EXIF_SIZE = 65535;
    private static final int STATE_SOI = 0;
    private static final int STREAMBUFFER_SIZE = 0x10000;
    private static final String TAG = "ExifOutputStream";
    private static final short TAG_SIZE = 12;
    private static final short TIFF_BIG_ENDIAN = 19789;
    private static final short TIFF_HEADER = 42;
    private static final short TIFF_HEADER_SIZE = 8;
    private static final short TIFF_LITTLE_ENDIAN = 18761;
    private ByteBuffer mBuffer;
    private ExifData mExifData;
    private final ExifInterface mInterface;

    protected ExifOutputStream(ExifInterface exifinterface)
    {
        mBuffer = ByteBuffer.allocate(4);
        mInterface = exifinterface;
    }

    private int calculateAllOffset()
    {
        IfdData ifddata = mExifData.getIfdData(0);
        int i = calculateOffsetOfIfd(ifddata, 8);
        ifddata.getTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_EXIF_IFD)).setValue(i);
        IfdData ifddata1 = mExifData.getIfdData(2);
        int k = calculateOffsetOfIfd(ifddata1, i);
        IfdData ifddata2 = mExifData.getIfdData(3);
        i = k;
        if (ifddata2 != null)
        {
            ifddata1.getTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_INTEROPERABILITY_IFD)).setValue(k);
            i = calculateOffsetOfIfd(ifddata2, k);
        }
        ifddata1 = mExifData.getIfdData(4);
        k = i;
        if (ifddata1 != null)
        {
            ifddata.getTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_GPS_IFD)).setValue(i);
            k = calculateOffsetOfIfd(ifddata1, i);
        }
        ifddata1 = mExifData.getIfdData(1);
        i = k;
        if (ifddata1 != null)
        {
            ifddata.setOffsetToNextIfd(k);
            i = calculateOffsetOfIfd(ifddata1, k);
        }
        if (mExifData.hasCompressedThumbnail())
        {
            ifddata1.getTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT)).setValue(i);
            k = i + mExifData.getCompressedThumbnail().length;
        } else
        {
            k = i;
            if (mExifData.hasUncompressedStrip())
            {
                long al[] = new long[mExifData.getStripCount()];
                boolean flag = false;
                int l = i;
                for (int j = ((flag) ? 1 : 0); j < mExifData.getStripCount(); j++)
                {
                    al[j] = l;
                    l += mExifData.getStrip(j).length;
                }

                ifddata1.getTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_STRIP_OFFSETS)).setValue(al);
                return l;
            }
        }
        return k;
    }

    private int calculateOffsetOfIfd(IfdData ifddata, int i)
    {
        int j = i + (ifddata.getTagCount() * 12 + 2 + 4);
        ifddata = ifddata.getAllTags();
        int l = ifddata.length;
        for (i = 0; i < l;)
        {
            ExifTag exiftag = ifddata[i];
            int k = j;
            if (exiftag.getDataSize() > 4)
            {
                exiftag.setOffset(j);
                k = j + exiftag.getDataSize();
            }
            i++;
            j = k;
        }

        return j;
    }

    private void createRequiredIfdAndTag()
        throws IOException
    {
        Object obj2 = mExifData.getIfdData(0);
        IfdData ifddata = ((IfdData) (obj2));
        if (obj2 == null)
        {
            ifddata = new IfdData(0);
            mExifData.addIfdData(ifddata);
        }
        obj2 = mInterface.buildUninitializedTag(ExifInterface.TAG_EXIF_IFD);
        if (obj2 == null)
        {
            throw new IOException((new StringBuilder()).append("No definition for crucial exif tag: ").append(ExifInterface.TAG_EXIF_IFD).toString());
        }
        ifddata.setTag(((ExifTag) (obj2)));
        IfdData ifddata1 = mExifData.getIfdData(2);
        obj2 = ifddata1;
        if (ifddata1 == null)
        {
            obj2 = new IfdData(2);
            mExifData.addIfdData(((IfdData) (obj2)));
        }
        if (mExifData.getIfdData(4) != null)
        {
            ExifTag exiftag1 = mInterface.buildUninitializedTag(ExifInterface.TAG_GPS_IFD);
            if (exiftag1 == null)
            {
                throw new IOException((new StringBuilder()).append("No definition for crucial exif tag: ").append(ExifInterface.TAG_GPS_IFD).toString());
            }
            ifddata.setTag(exiftag1);
        }
        if (mExifData.getIfdData(3) != null)
        {
            ExifTag exiftag = mInterface.buildUninitializedTag(ExifInterface.TAG_INTEROPERABILITY_IFD);
            if (exiftag == null)
            {
                throw new IOException((new StringBuilder()).append("No definition for crucial exif tag: ").append(ExifInterface.TAG_INTEROPERABILITY_IFD).toString());
            }
            ((IfdData) (obj2)).setTag(exiftag);
        }
        obj2 = mExifData.getIfdData(1);
        if (mExifData.hasCompressedThumbnail())
        {
            Object obj = obj2;
            if (obj2 == null)
            {
                obj = new IfdData(1);
                mExifData.addIfdData(((IfdData) (obj)));
            }
            obj2 = mInterface.buildUninitializedTag(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT);
            if (obj2 == null)
            {
                throw new IOException((new StringBuilder()).append("No definition for crucial exif tag: ").append(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT).toString());
            }
            ((IfdData) (obj)).setTag(((ExifTag) (obj2)));
            obj2 = mInterface.buildUninitializedTag(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
            if (obj2 == null)
            {
                throw new IOException((new StringBuilder()).append("No definition for crucial exif tag: ").append(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH).toString());
            }
            ((ExifTag) (obj2)).setValue(mExifData.getCompressedThumbnail().length);
            ((IfdData) (obj)).setTag(((ExifTag) (obj2)));
            ((IfdData) (obj)).removeTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_STRIP_OFFSETS));
            ((IfdData) (obj)).removeTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_STRIP_BYTE_COUNTS));
        } else
        {
            if (mExifData.hasUncompressedStrip())
            {
                Object obj1 = obj2;
                if (obj2 == null)
                {
                    obj1 = new IfdData(1);
                    mExifData.addIfdData(((IfdData) (obj1)));
                }
                int i = mExifData.getStripCount();
                obj2 = mInterface.buildUninitializedTag(ExifInterface.TAG_STRIP_OFFSETS);
                if (obj2 == null)
                {
                    throw new IOException((new StringBuilder()).append("No definition for crucial exif tag: ").append(ExifInterface.TAG_STRIP_OFFSETS).toString());
                }
                ExifTag exiftag2 = mInterface.buildUninitializedTag(ExifInterface.TAG_STRIP_BYTE_COUNTS);
                if (exiftag2 == null)
                {
                    throw new IOException((new StringBuilder()).append("No definition for crucial exif tag: ").append(ExifInterface.TAG_STRIP_BYTE_COUNTS).toString());
                }
                long al[] = new long[i];
                for (int j = 0; j < mExifData.getStripCount(); j++)
                {
                    al[j] = mExifData.getStrip(j).length;
                }

                exiftag2.setValue(al);
                ((IfdData) (obj1)).setTag(((ExifTag) (obj2)));
                ((IfdData) (obj1)).setTag(exiftag2);
                ((IfdData) (obj1)).removeTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT));
                ((IfdData) (obj1)).removeTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH));
                return;
            }
            if (obj2 != null)
            {
                ((IfdData) (obj2)).removeTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_STRIP_OFFSETS));
                ((IfdData) (obj2)).removeTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_STRIP_BYTE_COUNTS));
                ((IfdData) (obj2)).removeTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT));
                ((IfdData) (obj2)).removeTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH));
                return;
            }
        }
    }

    private int requestByteToBuffer(int i, byte abyte0[], int j, int k)
    {
        i -= mBuffer.position();
        if (k <= i)
        {
            i = k;
        }
        mBuffer.put(abyte0, j, i);
        return i;
    }

    private ArrayList stripNullValueTags(ExifData exifdata)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = exifdata.getAllTags().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ExifTag exiftag = (ExifTag)iterator.next();
            if (exiftag.getValue() == null && !ExifInterface.isOffsetTag(exiftag.getTagId()))
            {
                exifdata.removeTag(exiftag.getTagId(), exiftag.getIfd());
                arraylist.add(exiftag);
            }
        } while (true);
        return arraylist;
    }

    private void writeAllTags(OrderedDataOutputStream ordereddataoutputstream)
        throws IOException
    {
        writeIfd(mExifData.getIfdData(0), ordereddataoutputstream);
        writeIfd(mExifData.getIfdData(2), ordereddataoutputstream);
        IfdData ifddata = mExifData.getIfdData(3);
        if (ifddata != null)
        {
            writeIfd(ifddata, ordereddataoutputstream);
        }
        ifddata = mExifData.getIfdData(4);
        if (ifddata != null)
        {
            writeIfd(ifddata, ordereddataoutputstream);
        }
        if (mExifData.getIfdData(1) != null)
        {
            writeIfd(mExifData.getIfdData(1), ordereddataoutputstream);
        }
    }

    private void writeIfd(IfdData ifddata, OrderedDataOutputStream ordereddataoutputstream)
        throws IOException
    {
        ExifTag aexiftag[] = ifddata.getAllTags();
        ordereddataoutputstream.writeShort((short)aexiftag.length);
        int i1 = aexiftag.length;
        int i = 0;
        while (i < i1) 
        {
            ExifTag exiftag = aexiftag[i];
            ordereddataoutputstream.writeShort(exiftag.getTagId());
            ordereddataoutputstream.writeShort(exiftag.getDataType());
            ordereddataoutputstream.writeInt(exiftag.getComponentCount());
            if (exiftag.getDataSize() > 4)
            {
                ordereddataoutputstream.writeInt(exiftag.getOffset());
            } else
            {
                writeTagValue(exiftag, ordereddataoutputstream);
                int k = 0;
                int j1 = exiftag.getDataSize();
                while (k < 4 - j1) 
                {
                    ordereddataoutputstream.write(0);
                    k++;
                }
            }
            i++;
        }
        ordereddataoutputstream.writeInt(ifddata.getOffsetToNextIfd());
        int l = aexiftag.length;
        for (int j = 0; j < l; j++)
        {
            ifddata = aexiftag[j];
            if (ifddata.getDataSize() > 4)
            {
                writeTagValue(ifddata, ordereddataoutputstream);
            }
        }

    }

    static void writeTagValue(ExifTag exiftag, OrderedDataOutputStream ordereddataoutputstream)
        throws IOException
    {
        exiftag.getDataType();
        JVM INSTR tableswitch 1 10: default 60
    //                   1 162
    //                   2 61
    //                   3 180
    //                   4 99
    //                   5 131
    //                   6 60
    //                   7 162
    //                   8 60
    //                   9 99
    //                   10 131;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L1 _L2 _L1 _L5 _L6
_L1:
        return;
_L3:
        byte abyte0[] = exiftag.getStringByte();
        if (abyte0.length == exiftag.getComponentCount())
        {
            abyte0[abyte0.length - 1] = 0;
            ordereddataoutputstream.write(abyte0);
            return;
        } else
        {
            ordereddataoutputstream.write(abyte0);
            ordereddataoutputstream.write(0);
            return;
        }
_L5:
        int i = 0;
        int l = exiftag.getComponentCount();
        while (i < l) 
        {
            ordereddataoutputstream.writeInt((int)exiftag.getValueAt(i));
            i++;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        int j = 0;
        int i1 = exiftag.getComponentCount();
        while (j < i1) 
        {
            ordereddataoutputstream.writeRational(exiftag.getRational(j));
            j++;
        }
        if (true) goto _L1; else goto _L2
_L2:
        byte abyte1[] = new byte[exiftag.getComponentCount()];
        exiftag.getBytes(abyte1);
        ordereddataoutputstream.write(abyte1);
        return;
_L4:
        int k = 0;
        int j1 = exiftag.getComponentCount();
        while (k < j1) 
        {
            ordereddataoutputstream.writeShort((short)(int)exiftag.getValueAt(k));
            k++;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }

    private void writeThumbnail(OrderedDataOutputStream ordereddataoutputstream)
        throws IOException
    {
        if (!mExifData.hasCompressedThumbnail()) goto _L2; else goto _L1
_L1:
        Log.d("ExifOutputStream", "writing thumbnail..");
        ordereddataoutputstream.write(mExifData.getCompressedThumbnail());
_L4:
        return;
_L2:
        if (mExifData.hasUncompressedStrip())
        {
            Log.d("ExifOutputStream", "writing uncompressed strip..");
            int i = 0;
            while (i < mExifData.getStripCount()) 
            {
                ordereddataoutputstream.write(mExifData.getStrip(i));
                i++;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected ExifData getExifData()
    {
        return mExifData;
    }

    protected void setExifData(ExifData exifdata)
    {
        mExifData = exifdata;
    }

    public void writeExifData(OutputStream outputstream)
        throws IOException
    {
        if (mExifData == null)
        {
            return;
        }
        Log.v("ExifOutputStream", "Writing exif data...");
        Object obj = stripNullValueTags(mExifData);
        createRequiredIfdAndTag();
        int i = calculateAllOffset();
        if (i + 8 > 65535)
        {
            throw new IOException("Exif header is too large (>64Kb)");
        }
        outputstream = new OrderedDataOutputStream(new BufferedOutputStream(outputstream, 0x10000));
        outputstream.setByteOrder(ByteOrder.BIG_ENDIAN);
        outputstream.write(255);
        outputstream.write(225);
        outputstream.writeShort((short)(i + 8));
        outputstream.writeInt(0x45786966);
        outputstream.writeShort((short)0);
        if (mExifData.getByteOrder() == ByteOrder.BIG_ENDIAN)
        {
            outputstream.writeShort((short)19789);
        } else
        {
            outputstream.writeShort((short)18761);
        }
        outputstream.setByteOrder(mExifData.getByteOrder());
        outputstream.writeShort((short)42);
        outputstream.writeInt(8);
        writeAllTags(outputstream);
        writeThumbnail(outputstream);
        ExifTag exiftag;
        for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); mExifData.addTag(exiftag))
        {
            exiftag = (ExifTag)((Iterator) (obj)).next();
        }

        outputstream.flush();
    }
}
