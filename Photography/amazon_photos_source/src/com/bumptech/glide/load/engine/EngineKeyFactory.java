// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;

// Referenced classes of package com.bumptech.glide.load.engine:
//            EngineKey

class EngineKeyFactory
{

    EngineKeyFactory()
    {
    }

    public EngineKey buildKey(String s, Key key, int i, int j, ResourceDecoder resourcedecoder, ResourceDecoder resourcedecoder1, Transformation transformation, 
            ResourceEncoder resourceencoder, ResourceTranscoder resourcetranscoder, Encoder encoder)
    {
        return new EngineKey(s, key, i, j, resourcedecoder, resourcedecoder1, transformation, resourceencoder, resourcetranscoder, encoder);
    }
}
