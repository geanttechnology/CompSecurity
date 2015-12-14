// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.exif2;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package it.sephiroth.android.library.exif2:
//            ExifInvalidFormatException, ExifParser, ExifData, IfdData, 
//            ExifTag, ExifInterface

class ExifReader
{

    private static final String TAG = "ExifReader";
    private final ExifInterface mInterface;

    ExifReader(ExifInterface exifinterface)
    {
        mInterface = exifinterface;
    }

    protected ExifData read(InputStream inputstream, int i)
        throws ExifInvalidFormatException, IOException
    {
        ExifData exifdata;
        inputstream = ExifParser.parse(inputstream, i, mInterface);
        exifdata = new ExifData(inputstream.getByteOrder());
        exifdata.setSections(inputstream.getSections());
        exifdata.mUncompressedDataPosition = inputstream.getUncompressedDataPosition();
        exifdata.setQualityGuess(inputstream.getQualityGuess());
        exifdata.setJpegProcess(inputstream.getJpegProcess());
        i = inputstream.getImageWidth();
        int j = inputstream.getImageLength();
        if (i > 0 && j > 0)
        {
            exifdata.setImageSize(i, j);
        }
        i = inputstream.next();
_L8:
        if (i == 5)
        {
            break MISSING_BLOCK_LABEL_365;
        }
        i;
        JVM INSTR tableswitch 0 4: default 128
    //                   0 136
    //                   1 154
    //                   2 241
    //                   3 281
    //                   4 321;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_321;
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break; /* Loop/switch isn't completed */
_L9:
        i = inputstream.next();
        if (true) goto _L8; else goto _L7
_L7:
        exifdata.addIfdData(new IfdData(inputstream.getCurrentIfd()));
          goto _L9
_L3:
        ExifTag exiftag = inputstream.getTag();
        if (!exiftag.hasValue())
        {
            inputstream.registerForTagValue(exiftag);
        } else
        if (inputstream.isDefinedTag(exiftag.getIfd(), exiftag.getTagId()))
        {
            exifdata.getIfdData(exiftag.getIfd()).setTag(exiftag);
        } else
        {
            Log.w("ExifReader", (new StringBuilder()).append("skip tag because not registered in the tag table:").append(exiftag).toString());
        }
          goto _L9
_L4:
        ExifTag exiftag1 = inputstream.getTag();
        if (exiftag1.getDataType() == 7)
        {
            inputstream.readFullTagValue(exiftag1);
        }
        exifdata.getIfdData(exiftag1.getIfd()).setTag(exiftag1);
          goto _L9
_L5:
        byte abyte0[] = new byte[inputstream.getCompressedImageSize()];
        if (abyte0.length == inputstream.read(abyte0))
        {
            exifdata.setCompressedThumbnail(abyte0);
        } else
        {
            Log.w("ExifReader", "Failed to read the compressed thumbnail");
        }
          goto _L9
        byte abyte1[] = new byte[inputstream.getStripSize()];
        if (abyte1.length == inputstream.read(abyte1))
        {
            exifdata.setStripBytes(inputstream.getStripIndex(), abyte1);
        } else
        {
            Log.w("ExifReader", "Failed to read the strip bytes");
        }
          goto _L9
        return exifdata;
    }
}
