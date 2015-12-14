// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


public final class mClassName extends Enum
{

    private static final UNSPECIFIED $VALUES[];
    public static final UNSPECIFIED GOOGLE_PLAY_SERVICES_BANNER;
    public static final UNSPECIFIED GOOGLE_PLAY_SERVICES_INTERSTITIAL;
    public static final UNSPECIFIED HTML_BANNER;
    public static final UNSPECIFIED HTML_INTERSTITIAL;
    public static final UNSPECIFIED MILLENNIAL_BANNER;
    public static final UNSPECIFIED MILLENNIAL_INTERSTITIAL;
    public static final UNSPECIFIED MOPUB_NATIVE;
    public static final UNSPECIFIED MRAID_BANNER;
    public static final UNSPECIFIED MRAID_INTERSTITIAL;
    public static final UNSPECIFIED UNSPECIFIED;
    public static final UNSPECIFIED VAST_VIDEO_INTERSTITIAL;
    private final String mClassName;
    private final String mKey;

    private static mClassName fromString(String s)
    {
        mClassName amclassname[] = values();
        int j = amclassname.length;
        for (int i = 0; i < j; i++)
        {
            mClassName mclassname = amclassname[i];
            if (mclassname.mKey.equals(s))
            {
                return mclassname;
            }
        }

        return UNSPECIFIED;
    }

    public static UNSPECIFIED valueOf(String s)
    {
        return (UNSPECIFIED)Enum.valueOf(com/mopub/mobileads/AdTypeTranslator$CustomEventType, s);
    }

    public static UNSPECIFIED[] values()
    {
        return (UNSPECIFIED[])$VALUES.clone();
    }

    public final String toString()
    {
        return mClassName;
    }

    static 
    {
        GOOGLE_PLAY_SERVICES_BANNER = new <init>("GOOGLE_PLAY_SERVICES_BANNER", 0, "admob_native_banner", "com.mopub.mobileads.GooglePlayServicesBanner");
        GOOGLE_PLAY_SERVICES_INTERSTITIAL = new <init>("GOOGLE_PLAY_SERVICES_INTERSTITIAL", 1, "admob_full_interstitial", "com.mopub.mobileads.GooglePlayServicesInterstitial");
        MILLENNIAL_BANNER = new <init>("MILLENNIAL_BANNER", 2, "millennial_native_banner", "com.mopub.mobileads.MillennialBanner");
        MILLENNIAL_INTERSTITIAL = new <init>("MILLENNIAL_INTERSTITIAL", 3, "millennial_full_interstitial", "com.mopub.mobileads.MillennialInterstitial");
        MRAID_BANNER = new <init>("MRAID_BANNER", 4, "mraid_banner", "com.mopub.mraid.MraidBanner");
        MRAID_INTERSTITIAL = new <init>("MRAID_INTERSTITIAL", 5, "mraid_interstitial", "com.mopub.mraid.MraidInterstitial");
        HTML_BANNER = new <init>("HTML_BANNER", 6, "html_banner", "com.mopub.mobileads.HtmlBanner");
        HTML_INTERSTITIAL = new <init>("HTML_INTERSTITIAL", 7, "html_interstitial", "com.mopub.mobileads.HtmlInterstitial");
        VAST_VIDEO_INTERSTITIAL = new <init>("VAST_VIDEO_INTERSTITIAL", 8, "vast_interstitial", "com.mopub.mobileads.VastVideoInterstitial");
        MOPUB_NATIVE = new <init>("MOPUB_NATIVE", 9, "mopub_native", "com.mopub.nativeads.MoPubCustomEventNative");
        UNSPECIFIED = new <init>("UNSPECIFIED", 10, "", null);
        $VALUES = (new .VALUES[] {
            GOOGLE_PLAY_SERVICES_BANNER, GOOGLE_PLAY_SERVICES_INTERSTITIAL, MILLENNIAL_BANNER, MILLENNIAL_INTERSTITIAL, MRAID_BANNER, MRAID_INTERSTITIAL, HTML_BANNER, HTML_INTERSTITIAL, VAST_VIDEO_INTERSTITIAL, MOPUB_NATIVE, 
            UNSPECIFIED
        });
    }


    private (String s, int i, String s1, String s2)
    {
        super(s, i);
        mKey = s1;
        mClassName = s2;
    }
}
