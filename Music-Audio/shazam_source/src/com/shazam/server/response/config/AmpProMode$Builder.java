// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import com.shazam.server.response.follow.FollowData;

// Referenced classes of package com.shazam.server.response.config:
//            AmpProMode

public static class 
{

    private String artistId;
    private boolean enabled;
    private FollowData followKey;

    public static  ampProMode()
    {
        return new <init>();
    }

    public AmpProMode build()
    {
        return new AmpProMode(this, null);
    }

    public <init> withArtistId(String s)
    {
        artistId = s;
        return this;
    }

    public artistId withEnabled(boolean flag)
    {
        enabled = flag;
        return this;
    }

    public enabled withFollowKey(FollowData followdata)
    {
        followKey = followdata;
        return this;
    }




    public ()
    {
    }
}
