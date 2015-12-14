// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.location.Location;
import android.text.TextUtils;
import java.util.EnumSet;

public class RequestParameters
{

    private final EnumSet mDesiredAssets;
    private final String mKeywords;
    private final Location mLocation;

    private RequestParameters(Builder builder)
    {
        mKeywords = builder.keywords;
        mLocation = builder.location;
        mDesiredAssets = builder.desiredAssets;
    }


    public final String getDesiredAssets()
    {
        String s = "";
        if (mDesiredAssets != null)
        {
            s = TextUtils.join(",", mDesiredAssets.toArray());
        }
        return s;
    }

    public final String getKeywords()
    {
        return mKeywords;
    }

    public final Location getLocation()
    {
        return mLocation;
    }

    private class Builder
    {

        private EnumSet desiredAssets;
        private String keywords;
        private Location location;

        public final RequestParameters build()
        {
            return new RequestParameters(this);
        }

        public final Builder desiredAssets(EnumSet enumset)
        {
            desiredAssets = EnumSet.copyOf(enumset);
            return this;
        }

        public final Builder keywords(String s)
        {
            keywords = s;
            return this;
        }

        public final Builder location(Location location1)
        {
            location = location1;
            return this;
        }




        public Builder()
        {
        }
    }

}
