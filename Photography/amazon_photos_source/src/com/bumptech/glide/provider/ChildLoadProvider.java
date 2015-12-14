// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;

// Referenced classes of package com.bumptech.glide.provider:
//            LoadProvider

public class ChildLoadProvider
    implements LoadProvider, Cloneable
{

    private ResourceDecoder cacheDecoder;
    private ResourceEncoder encoder;
    private final LoadProvider parent;
    private ResourceDecoder sourceDecoder;
    private Encoder sourceEncoder;
    private ResourceTranscoder transcoder;

    public ChildLoadProvider(LoadProvider loadprovider)
    {
        parent = loadprovider;
    }

    public ChildLoadProvider clone()
    {
        ChildLoadProvider childloadprovider;
        try
        {
            childloadprovider = (ChildLoadProvider)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new RuntimeException(clonenotsupportedexception);
        }
        return childloadprovider;
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public ResourceDecoder getCacheDecoder()
    {
        if (cacheDecoder != null)
        {
            return cacheDecoder;
        } else
        {
            return parent.getCacheDecoder();
        }
    }

    public ResourceEncoder getEncoder()
    {
        if (encoder != null)
        {
            return encoder;
        } else
        {
            return parent.getEncoder();
        }
    }

    public ModelLoader getModelLoader()
    {
        return parent.getModelLoader();
    }

    public ResourceDecoder getSourceDecoder()
    {
        if (sourceDecoder != null)
        {
            return sourceDecoder;
        } else
        {
            return parent.getSourceDecoder();
        }
    }

    public Encoder getSourceEncoder()
    {
        if (sourceEncoder != null)
        {
            return sourceEncoder;
        } else
        {
            return parent.getSourceEncoder();
        }
    }

    public ResourceTranscoder getTranscoder()
    {
        if (transcoder != null)
        {
            return transcoder;
        } else
        {
            return parent.getTranscoder();
        }
    }

    public void setCacheDecoder(ResourceDecoder resourcedecoder)
    {
        cacheDecoder = resourcedecoder;
    }

    public void setEncoder(ResourceEncoder resourceencoder)
    {
        encoder = resourceencoder;
    }

    public void setSourceDecoder(ResourceDecoder resourcedecoder)
    {
        sourceDecoder = resourcedecoder;
    }

    public void setSourceEncoder(Encoder encoder1)
    {
        sourceEncoder = encoder1;
    }
}
