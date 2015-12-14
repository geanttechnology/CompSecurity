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
//            LoadProvider, DataLoadProvider

public class FixedLoadProvider
    implements LoadProvider
{

    private final DataLoadProvider dataLoadProvider;
    private final ModelLoader modelLoader;
    private final ResourceTranscoder transcoder;

    public FixedLoadProvider(ModelLoader modelloader, ResourceTranscoder resourcetranscoder, DataLoadProvider dataloadprovider)
    {
        if (modelloader == null)
        {
            throw new NullPointerException("ModelLoader must not be null");
        }
        modelLoader = modelloader;
        if (resourcetranscoder == null)
        {
            throw new NullPointerException("Transcoder must not be null");
        }
        transcoder = resourcetranscoder;
        if (dataloadprovider == null)
        {
            throw new NullPointerException("DataLoadProvider must not be null");
        } else
        {
            dataLoadProvider = dataloadprovider;
            return;
        }
    }

    public ResourceDecoder getCacheDecoder()
    {
        return dataLoadProvider.getCacheDecoder();
    }

    public ResourceEncoder getEncoder()
    {
        return dataLoadProvider.getEncoder();
    }

    public ModelLoader getModelLoader()
    {
        return modelLoader;
    }

    public ResourceDecoder getSourceDecoder()
    {
        return dataLoadProvider.getSourceDecoder();
    }

    public Encoder getSourceEncoder()
    {
        return dataLoadProvider.getSourceEncoder();
    }

    public ResourceTranscoder getTranscoder()
    {
        return transcoder;
    }
}
