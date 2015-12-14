// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifencoder.AnimatedGifEncoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.bumptech.glide.load.resource.gif:
//            GifBitmapProvider, GifDrawable

public class GifResourceEncoder
    implements ResourceEncoder
{
    static class Factory
    {

        public GifDecoder buildDecoder(com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider bitmapprovider)
        {
            return new GifDecoder(bitmapprovider);
        }

        public AnimatedGifEncoder buildEncoder()
        {
            return new AnimatedGifEncoder();
        }

        public Resource buildFrameResource(Bitmap bitmap, BitmapPool bitmappool)
        {
            return new BitmapResource(bitmap, bitmappool);
        }

        public GifHeaderParser buildParser()
        {
            return new GifHeaderParser();
        }

        Factory()
        {
        }
    }


    private static final Factory FACTORY = new Factory();
    private final BitmapPool bitmapPool;
    private final Factory factory;
    private final com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider provider;

    public GifResourceEncoder(BitmapPool bitmappool)
    {
        this(bitmappool, FACTORY);
    }

    GifResourceEncoder(BitmapPool bitmappool, Factory factory1)
    {
        bitmapPool = bitmappool;
        provider = new GifBitmapProvider(bitmappool);
        factory = factory1;
    }

    private GifDecoder decodeHeaders(byte abyte0[])
    {
        Object obj = factory.buildParser();
        ((GifHeaderParser) (obj)).setData(abyte0);
        obj = ((GifHeaderParser) (obj)).parseHeader();
        GifDecoder gifdecoder = factory.buildDecoder(provider);
        gifdecoder.setData(((com.bumptech.glide.gifdecoder.GifHeader) (obj)), abyte0);
        gifdecoder.advance();
        return gifdecoder;
    }

    private Resource getTransformedFrame(Bitmap bitmap, Transformation transformation, GifDrawable gifdrawable)
    {
        bitmap = factory.buildFrameResource(bitmap, bitmapPool);
        transformation = transformation.transform(bitmap, gifdrawable.getIntrinsicWidth(), gifdrawable.getIntrinsicHeight());
        if (!bitmap.equals(transformation))
        {
            bitmap.recycle();
        }
        return transformation;
    }

    private boolean writeDataDirect(byte abyte0[], OutputStream outputstream)
    {
        try
        {
            outputstream.write(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            if (Log.isLoggable("GifEncoder", 3))
            {
                Log.d("GifEncoder", "Failed to write data to output stream in GifResourceEncoder", abyte0);
            }
            return false;
        }
        return true;
    }

    public boolean encode(Resource resource, OutputStream outputstream)
    {
        Transformation transformation;
        long l;
        l = LogTime.getLogTime();
        resource = (GifDrawable)resource.get();
        transformation = resource.getFrameTransformation();
        if (!(transformation instanceof UnitTransformation)) goto _L2; else goto _L1
_L1:
        boolean flag = writeDataDirect(resource.getData(), outputstream);
_L6:
        return flag;
_L2:
        GifDecoder gifdecoder;
        AnimatedGifEncoder animatedgifencoder;
        int i;
        gifdecoder = decodeHeaders(resource.getData());
        animatedgifencoder = factory.buildEncoder();
        if (!animatedgifencoder.start(outputstream))
        {
            return false;
        }
        i = 0;
_L4:
        if (i >= gifdecoder.getFrameCount())
        {
            break; /* Loop/switch isn't completed */
        }
        outputstream = getTransformedFrame(gifdecoder.getNextFrame(), transformation, resource);
        flag = animatedgifencoder.addFrame((Bitmap)outputstream.get());
        if (!flag)
        {
            outputstream.recycle();
            return false;
        }
        animatedgifencoder.setDelay(gifdecoder.getDelay(gifdecoder.getCurrentFrameIndex()));
        gifdecoder.advance();
        outputstream.recycle();
        i++;
        if (true) goto _L4; else goto _L3
        resource;
        outputstream.recycle();
        throw resource;
_L3:
        boolean flag1 = animatedgifencoder.finish();
        flag = flag1;
        if (Log.isLoggable("GifEncoder", 2))
        {
            Log.v("GifEncoder", (new StringBuilder()).append("Encoded gif with ").append(gifdecoder.getFrameCount()).append(" frames and ").append(resource.getData().length).append(" bytes in ").append(LogTime.getElapsedMillis(l)).append(" ms").toString());
            return flag1;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public volatile boolean encode(Object obj, OutputStream outputstream)
    {
        return encode((Resource)obj, outputstream);
    }

    public String getId()
    {
        return "";
    }

}
