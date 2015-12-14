// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Encoder;
import java.io.OutputStream;

// Referenced classes of package com.bumptech.glide.load.model:
//            ImageVideoWrapper

public class ImageVideoWrapperEncoder
    implements Encoder
{

    private final Encoder fileDescriptorEncoder;
    private String id;
    private final Encoder streamEncoder;

    public ImageVideoWrapperEncoder(Encoder encoder, Encoder encoder1)
    {
        streamEncoder = encoder;
        fileDescriptorEncoder = encoder1;
    }

    public boolean encode(ImageVideoWrapper imagevideowrapper, OutputStream outputstream)
    {
        if (imagevideowrapper.getStream() != null)
        {
            return streamEncoder.encode(imagevideowrapper.getStream(), outputstream);
        } else
        {
            return fileDescriptorEncoder.encode(imagevideowrapper.getFileDescriptor(), outputstream);
        }
    }

    public volatile boolean encode(Object obj, OutputStream outputstream)
    {
        return encode((ImageVideoWrapper)obj, outputstream);
    }

    public String getId()
    {
        if (id == null)
        {
            id = (new StringBuilder()).append(streamEncoder.getId()).append(fileDescriptorEncoder.getId()).toString();
        }
        return id;
    }
}
