// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.amazon.gallery.foundation.utils.log.GLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.io.IOUtils;

// Referenced classes of package com.amazon.gallery.framework.gallery.utils:
//            Dimension, GifEncoderParams, GifEncoder

public class GifGenerator
{

    private static final String TAG = com/amazon/gallery/framework/gallery/utils/GifGenerator.getName();

    public GifGenerator()
    {
    }

    private Bitmap loadInputFrame(String s, int i)
        throws IOException
    {
        FileInputStream fileinputstream = new FileInputStream(s);
        Bitmap bitmap;
        bitmap = BitmapFactory.decodeStream(fileinputstream);
        GLogger.d(TAG, "Image %s loaded. Size: [w: %d, h: %d]", new Object[] {
            s, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())
        });
        double d = 300D / (double)Math.max(bitmap.getHeight(), bitmap.getWidth());
        Dimension dimension = new Dimension(bitmap.getWidth(), bitmap.getHeight(), d);
        bitmap = Bitmap.createScaledBitmap(bitmap, dimension.w, dimension.h, false);
        GLogger.d(TAG, "Image %s scaled. Size: [w: %d, h: %d]", new Object[] {
            s, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())
        });
        IOUtils.closeQuietly(fileinputstream);
        return bitmap;
        s;
        IOUtils.closeQuietly(fileinputstream);
        throw s;
    }

    public File generate(GifEncoderParams gifencoderparams)
    {
        Object obj;
        String s;
        GLogger.d(TAG, "Generating GIF for resources: %s", new Object[] {
            gifencoderparams.getInputFileNames()
        });
        obj = null;
        s = null;
        Object obj1 = new FileOutputStream(gifencoderparams.getOutputFileName());
        obj = new GifEncoder();
        ((GifEncoder) (obj)).start(((java.io.OutputStream) (obj1)));
        ((GifEncoder) (obj)).setDelay(gifencoderparams.getDelay());
        ((GifEncoder) (obj)).setQuality(gifencoderparams.getQuality());
        ((GifEncoder) (obj)).setRepeat(gifencoderparams.getRepeat());
        ((GifEncoder) (obj)).setSize(gifencoderparams.getDimension().w, gifencoderparams.getDimension().h);
        Bitmap bitmap;
        for (Iterator iterator = gifencoderparams.getInputFileNames().iterator(); iterator.hasNext(); ((GifEncoder) (obj)).addFrame(bitmap))
        {
            s = (String)iterator.next();
            GLogger.d(TAG, "Loading input file: %s", new Object[] {
                s
            });
            bitmap = loadInputFrame(s, 300);
            GLogger.d(TAG, "Adding scaled image %s as frame to GIF. Size: [w: %d, h: %d]", new Object[] {
                s, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())
            });
        }

          goto _L1
        IOException ioexception;
        ioexception;
_L5:
        obj = obj1;
        GLogger.exf(TAG, ioexception, "Failed to process images into GIF. Params: %s", new Object[] {
            gifencoderparams.toString()
        });
        obj = obj1;
        throw new RuntimeException(ioexception);
        gifencoderparams;
_L3:
        IOUtils.closeQuietly(((java.io.OutputStream) (obj)));
        throw gifencoderparams;
_L1:
        ((GifEncoder) (obj)).finish();
        obj = new File(gifencoderparams.getOutputFileName());
        IOUtils.closeQuietly(((java.io.OutputStream) (obj1)));
        return ((File) (obj));
        gifencoderparams;
        obj = obj1;
        if (true) goto _L3; else goto _L2
_L2:
        ioexception;
        obj1 = s;
        if (true) goto _L5; else goto _L4
_L4:
    }

}
