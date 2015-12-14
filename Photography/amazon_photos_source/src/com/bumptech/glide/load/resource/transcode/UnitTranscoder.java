// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.engine.Resource;

// Referenced classes of package com.bumptech.glide.load.resource.transcode:
//            ResourceTranscoder

public class UnitTranscoder
    implements ResourceTranscoder
{

    private static final UnitTranscoder UNIT_TRANSCODER = new UnitTranscoder();

    public UnitTranscoder()
    {
    }

    public static ResourceTranscoder get()
    {
        return UNIT_TRANSCODER;
    }

    public String getId()
    {
        return "";
    }

    public Resource transcode(Resource resource)
    {
        return resource;
    }

}
