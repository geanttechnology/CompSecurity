// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

// Referenced classes of package com.bumptech.glide.load.resource.gif:
//            GifBitmapProvider, GifDrawableResource, GifDrawable

public class GifResourceDecoder
    implements ResourceDecoder
{
    static class GifDecoderPool
    {

        private final Queue pool = Util.createQueue(0);

        public GifDecoder obtain(com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider bitmapprovider)
        {
            this;
            JVM INSTR monitorenter ;
            GifDecoder gifdecoder1 = (GifDecoder)pool.poll();
            GifDecoder gifdecoder;
            gifdecoder = gifdecoder1;
            if (gifdecoder1 != null)
            {
                break MISSING_BLOCK_LABEL_30;
            }
            gifdecoder = new GifDecoder(bitmapprovider);
            this;
            JVM INSTR monitorexit ;
            return gifdecoder;
            bitmapprovider;
            throw bitmapprovider;
        }

        public void release(GifDecoder gifdecoder)
        {
            this;
            JVM INSTR monitorenter ;
            gifdecoder.clear();
            pool.offer(gifdecoder);
            this;
            JVM INSTR monitorexit ;
            return;
            gifdecoder;
            throw gifdecoder;
        }

        GifDecoderPool()
        {
        }
    }

    static class GifHeaderParserPool
    {

        private final Queue pool = Util.createQueue(0);

        public GifHeaderParser obtain(byte abyte0[])
        {
            this;
            JVM INSTR monitorenter ;
            GifHeaderParser gifheaderparser1 = (GifHeaderParser)pool.poll();
            GifHeaderParser gifheaderparser;
            gifheaderparser = gifheaderparser1;
            if (gifheaderparser1 != null)
            {
                break MISSING_BLOCK_LABEL_29;
            }
            gifheaderparser = new GifHeaderParser();
            abyte0 = gifheaderparser.setData(abyte0);
            this;
            JVM INSTR monitorexit ;
            return abyte0;
            abyte0;
            throw abyte0;
        }

        public void release(GifHeaderParser gifheaderparser)
        {
            this;
            JVM INSTR monitorenter ;
            gifheaderparser.clear();
            pool.offer(gifheaderparser);
            this;
            JVM INSTR monitorexit ;
            return;
            gifheaderparser;
            throw gifheaderparser;
        }

        GifHeaderParserPool()
        {
        }
    }


    private static final GifDecoderPool DECODER_POOL = new GifDecoderPool();
    private static final GifHeaderParserPool PARSER_POOL = new GifHeaderParserPool();
    private final BitmapPool bitmapPool;
    private final Context context;
    private final GifDecoderPool decoderPool;
    private final GifHeaderParserPool parserPool;
    private final GifBitmapProvider provider;

    public GifResourceDecoder(Context context1, BitmapPool bitmappool)
    {
        this(context1, bitmappool, PARSER_POOL, DECODER_POOL);
    }

    GifResourceDecoder(Context context1, BitmapPool bitmappool, GifHeaderParserPool gifheaderparserpool, GifDecoderPool gifdecoderpool)
    {
        context = context1;
        bitmapPool = bitmappool;
        decoderPool = gifdecoderpool;
        provider = new GifBitmapProvider(bitmappool);
        parserPool = gifheaderparserpool;
    }

    private GifDrawableResource decode(byte abyte0[], int i, int j, GifHeaderParser gifheaderparser, GifDecoder gifdecoder)
    {
        gifheaderparser = gifheaderparser.parseHeader();
        if (gifheaderparser.getNumFrames() > 0 && gifheaderparser.getStatus() == 0)
        {
            if ((gifdecoder = decodeFirstFrame(gifdecoder, gifheaderparser, abyte0)) != null)
            {
                UnitTransformation unittransformation = UnitTransformation.get();
                return new GifDrawableResource(new GifDrawable(context, provider, bitmapPool, unittransformation, i, j, gifheaderparser, abyte0, gifdecoder));
            }
        }
        return null;
    }

    private Bitmap decodeFirstFrame(GifDecoder gifdecoder, GifHeader gifheader, byte abyte0[])
    {
        gifdecoder.setData(gifheader, abyte0);
        gifdecoder.advance();
        return gifdecoder.getNextFrame();
    }

    private static byte[] inputStreamToBytes(InputStream inputstream)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(16384);
        byte abyte0[] = new byte[16384];
_L3:
        int i = inputstream.read(abyte0);
        if (i == -1) goto _L2; else goto _L1
_L1:
        bytearrayoutputstream.write(abyte0, 0, i);
          goto _L3
_L5:
        return bytearrayoutputstream.toByteArray();
_L2:
        try
        {
            bytearrayoutputstream.flush();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            Log.w("GifResourceDecoder", "Error reading data from stream", inputstream);
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public volatile Resource decode(Object obj, int i, int j)
        throws IOException
    {
        return decode((InputStream)obj, i, j);
    }

    public GifDrawableResource decode(InputStream inputstream, int i, int j)
    {
        GifDecoder gifdecoder;
        byte abyte0[];
        abyte0 = inputStreamToBytes(inputstream);
        inputstream = parserPool.obtain(abyte0);
        gifdecoder = decoderPool.obtain(provider);
        GifDrawableResource gifdrawableresource = decode(abyte0, i, j, ((GifHeaderParser) (inputstream)), gifdecoder);
        parserPool.release(inputstream);
        decoderPool.release(gifdecoder);
        return gifdrawableresource;
        Exception exception;
        exception;
        parserPool.release(inputstream);
        decoderPool.release(gifdecoder);
        throw exception;
    }

    public String getId()
    {
        return "";
    }

}
