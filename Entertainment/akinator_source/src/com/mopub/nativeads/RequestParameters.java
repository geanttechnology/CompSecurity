// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.location.Location;
import android.text.TextUtils;
import java.util.EnumSet;

public class RequestParameters
{
    public static final class Builder
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

    public static final class NativeAdAsset extends Enum
    {

        private static final NativeAdAsset $VALUES[];
        public static final NativeAdAsset CALL_TO_ACTION_TEXT;
        public static final NativeAdAsset ICON_IMAGE;
        public static final NativeAdAsset MAIN_IMAGE;
        public static final NativeAdAsset STAR_RATING;
        public static final NativeAdAsset TEXT;
        public static final NativeAdAsset TITLE;
        private final String mAssetName;

        public static NativeAdAsset valueOf(String s)
        {
            return (NativeAdAsset)Enum.valueOf(com/mopub/nativeads/RequestParameters$NativeAdAsset, s);
        }

        public static NativeAdAsset[] values()
        {
            return (NativeAdAsset[])$VALUES.clone();
        }

        public String toString()
        {
            return mAssetName;
        }

        static 
        {
            TITLE = new NativeAdAsset("TITLE", 0, "title");
            TEXT = new NativeAdAsset("TEXT", 1, "text");
            ICON_IMAGE = new NativeAdAsset("ICON_IMAGE", 2, "iconimage");
            MAIN_IMAGE = new NativeAdAsset("MAIN_IMAGE", 3, "mainimage");
            CALL_TO_ACTION_TEXT = new NativeAdAsset("CALL_TO_ACTION_TEXT", 4, "ctatext");
            STAR_RATING = new NativeAdAsset("STAR_RATING", 5, "starrating");
            $VALUES = (new NativeAdAsset[] {
                TITLE, TEXT, ICON_IMAGE, MAIN_IMAGE, CALL_TO_ACTION_TEXT, STAR_RATING
            });
        }

        private NativeAdAsset(String s, int i, String s1)
        {
            super(s, i);
            mAssetName = s1;
        }
    }


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
}
