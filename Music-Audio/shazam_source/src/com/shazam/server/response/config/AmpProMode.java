// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import com.shazam.server.response.follow.FollowData;
import java.io.Serializable;

public class AmpProMode
    implements Serializable
{
    public static class Builder
    {

        private String artistId;
        private boolean enabled;
        private FollowData followKey;

        public static Builder ampProMode()
        {
            return new Builder();
        }

        public AmpProMode build()
        {
            return new AmpProMode(this, null);
        }

        public Builder withArtistId(String s)
        {
            artistId = s;
            return this;
        }

        public Builder withEnabled(boolean flag)
        {
            enabled = flag;
            return this;
        }

        public Builder withFollowKey(FollowData followdata)
        {
            followKey = followdata;
            return this;
        }




        public Builder()
        {
        }
    }


    private String artistId;
    private boolean enabled;
    private FollowData followKey;

    private AmpProMode()
    {
    }

    private AmpProMode(Builder builder)
    {
        enabled = builder.enabled;
        artistId = builder.artistId;
        followKey = builder.followKey;
    }

    AmpProMode(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public String getArtistId()
    {
        return artistId;
    }

    public FollowData getFollowKey()
    {
        if (followKey == null)
        {
            return FollowData.EMPTY;
        } else
        {
            return followKey;
        }
    }

    public boolean isEnabled()
    {
        return enabled;
    }
}
