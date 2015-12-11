// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;

import com.groupon.Channel;

// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class DealImageCarouselMetadata extends JsonEncodedNSTField
{

    private String channel;

    public DealImageCarouselMetadata(Channel channel1)
    {
        channel = channel1.name();
    }
}
