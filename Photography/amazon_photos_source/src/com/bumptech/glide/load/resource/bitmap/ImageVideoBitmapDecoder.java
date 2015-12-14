// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import java.io.IOException;

public class ImageVideoBitmapDecoder
    implements ResourceDecoder
{

    private final ResourceDecoder fileDescriptorDecoder;
    private final ResourceDecoder streamDecoder;

    public ImageVideoBitmapDecoder(ResourceDecoder resourcedecoder, ResourceDecoder resourcedecoder1)
    {
        streamDecoder = resourcedecoder;
        fileDescriptorDecoder = resourcedecoder1;
    }

    public Resource decode(ImageVideoWrapper imagevideowrapper, int i, int j)
        throws IOException
    {
        Resource resource;
        Resource resource1;
        java.io.InputStream inputstream;
        resource1 = null;
        inputstream = imagevideowrapper.getStream();
        resource = resource1;
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        resource = streamDecoder.decode(inputstream, i, j);
_L2:
        resource1 = resource;
        if (resource == null)
        {
            imagevideowrapper = imagevideowrapper.getFileDescriptor();
            resource1 = resource;
            if (imagevideowrapper != null)
            {
                resource1 = fileDescriptorDecoder.decode(imagevideowrapper, i, j);
            }
        }
        return resource1;
        IOException ioexception;
        ioexception;
        resource = resource1;
        if (Log.isLoggable("ImageVideoDecoder", 2))
        {
            Log.v("ImageVideoDecoder", "Failed to load image from stream, trying FileDescriptor", ioexception);
            resource = resource1;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public volatile Resource decode(Object obj, int i, int j)
        throws IOException
    {
        return decode((ImageVideoWrapper)obj, i, j);
    }

    public String getId()
    {
        return "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
}
