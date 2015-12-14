// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.ByteArrayPool;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.bumptech.glide.load.resource.gifbitmap:
//            GifBitmapWrapper, GifBitmapWrapperResource

public class GifBitmapWrapperResourceDecoder
    implements ResourceDecoder
{
    static class BufferedStreamFactory
    {

        public InputStream build(InputStream inputstream, byte abyte0[])
        {
            return new RecyclableBufferedInputStream(inputstream, abyte0);
        }

        BufferedStreamFactory()
        {
        }
    }

    static class ImageTypeParser
    {

        public com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.ImageType parse(InputStream inputstream)
            throws IOException
        {
            return (new ImageHeaderParser(inputstream)).getType();
        }

        ImageTypeParser()
        {
        }
    }


    private static final ImageTypeParser DEFAULT_PARSER = new ImageTypeParser();
    private static final BufferedStreamFactory DEFAULT_STREAM_FACTORY = new BufferedStreamFactory();
    private final ResourceDecoder bitmapDecoder;
    private final BitmapPool bitmapPool;
    private final ResourceDecoder gifDecoder;
    private String id;
    private final ImageTypeParser parser;
    private final BufferedStreamFactory streamFactory;

    public GifBitmapWrapperResourceDecoder(ResourceDecoder resourcedecoder, ResourceDecoder resourcedecoder1, BitmapPool bitmappool)
    {
        this(resourcedecoder, resourcedecoder1, bitmappool, DEFAULT_PARSER, DEFAULT_STREAM_FACTORY);
    }

    GifBitmapWrapperResourceDecoder(ResourceDecoder resourcedecoder, ResourceDecoder resourcedecoder1, BitmapPool bitmappool, ImageTypeParser imagetypeparser, BufferedStreamFactory bufferedstreamfactory)
    {
        bitmapDecoder = resourcedecoder;
        gifDecoder = resourcedecoder1;
        bitmapPool = bitmappool;
        parser = imagetypeparser;
        streamFactory = bufferedstreamfactory;
    }

    private GifBitmapWrapper decode(ImageVideoWrapper imagevideowrapper, int i, int j, byte abyte0[])
        throws IOException
    {
        if (imagevideowrapper.getStream() != null)
        {
            return decodeStream(imagevideowrapper, i, j, abyte0);
        } else
        {
            return decodeBitmapWrapper(imagevideowrapper, i, j);
        }
    }

    private GifBitmapWrapper decodeBitmapWrapper(ImageVideoWrapper imagevideowrapper, int i, int j)
        throws IOException
    {
        Object obj = null;
        Resource resource = bitmapDecoder.decode(imagevideowrapper, i, j);
        imagevideowrapper = obj;
        if (resource != null)
        {
            imagevideowrapper = new GifBitmapWrapper(resource, null);
        }
        return imagevideowrapper;
    }

    private GifBitmapWrapper decodeGifWrapper(InputStream inputstream, int i, int j)
        throws IOException
    {
label0:
        {
            Object obj = null;
            Resource resource = gifDecoder.decode(inputstream, i, j);
            inputstream = obj;
            if (resource != null)
            {
                inputstream = (GifDrawable)resource.get();
                if (inputstream.getFrameCount() <= 1)
                {
                    break label0;
                }
                inputstream = new GifBitmapWrapper(null, resource);
            }
            return inputstream;
        }
        return new GifBitmapWrapper(new BitmapResource(inputstream.getFirstFrame(), bitmapPool), null);
    }

    private GifBitmapWrapper decodeStream(ImageVideoWrapper imagevideowrapper, int i, int j, byte abyte0[])
        throws IOException
    {
        InputStream inputstream = streamFactory.build(imagevideowrapper.getStream(), abyte0);
        inputstream.mark(2048);
        Object obj = parser.parse(inputstream);
        inputstream.reset();
        abyte0 = null;
        if (obj == com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.ImageType.GIF)
        {
            abyte0 = decodeGifWrapper(inputstream, i, j);
        }
        obj = abyte0;
        if (abyte0 == null)
        {
            obj = decodeBitmapWrapper(new ImageVideoWrapper(inputstream, imagevideowrapper.getFileDescriptor()), i, j);
        }
        return ((GifBitmapWrapper) (obj));
    }

    public Resource decode(ImageVideoWrapper imagevideowrapper, int i, int j)
        throws IOException
    {
        ByteArrayPool bytearraypool;
        byte abyte0[];
        bytearraypool = ByteArrayPool.get();
        abyte0 = bytearraypool.getBytes();
        imagevideowrapper = decode(imagevideowrapper, i, j, abyte0);
        bytearraypool.releaseBytes(abyte0);
        if (imagevideowrapper != null)
        {
            return new GifBitmapWrapperResource(imagevideowrapper);
        } else
        {
            return null;
        }
        imagevideowrapper;
        bytearraypool.releaseBytes(abyte0);
        throw imagevideowrapper;
    }

    public volatile Resource decode(Object obj, int i, int j)
        throws IOException
    {
        return decode((ImageVideoWrapper)obj, i, j);
    }

    public String getId()
    {
        if (id == null)
        {
            id = (new StringBuilder()).append(gifDecoder.getId()).append(bitmapDecoder.getId()).toString();
        }
        return id;
    }

}
