// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;

// Referenced classes of package com.bumptech.glide.provider:
//            DataLoadProvider

public class EmptyDataLoadProvider
    implements DataLoadProvider
{

    private static final DataLoadProvider EMPTY_DATA_LOAD_PROVIDER = new EmptyDataLoadProvider();

    public EmptyDataLoadProvider()
    {
    }

    public static DataLoadProvider get()
    {
        return EMPTY_DATA_LOAD_PROVIDER;
    }

    public ResourceDecoder getCacheDecoder()
    {
        return null;
    }

    public ResourceEncoder getEncoder()
    {
        return null;
    }

    public ResourceDecoder getSourceDecoder()
    {
        return null;
    }

    public Encoder getSourceEncoder()
    {
        return null;
    }

}
