// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


// Referenced classes of package com.mopub.mobileads:
//            d

public static final class m extends Enum
{

    public static final k a;
    public static final k b;
    public static final k c;
    public static final k d;
    public static final k e;
    public static final k f;
    public static final k g;
    public static final k h;
    public static final k i;
    public static final k j;
    public static final k k;
    private static final k n[];
    private final String l;
    private final String m;

    public static m a(String s)
    {
        m am[] = values();
        int j1 = am.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            m m1 = am[i1];
            if (m1.l.equals(s))
            {
                return m1;
            }
        }

        return k;
    }

    public static k valueOf(String s)
    {
        return (k)Enum.valueOf(com/mopub/mobileads/d$a, s);
    }

    public static k[] values()
    {
        return (k[])n.clone();
    }

    public final String toString()
    {
        return m;
    }

    static 
    {
        a = new <init>("GOOGLE_PLAY_SERVICES_BANNER", 0, "admob_native_banner", "com.mopub.mobileads.GooglePlayServicesBanner");
        b = new <init>("GOOGLE_PLAY_SERVICES_INTERSTITIAL", 1, "admob_full_interstitial", "com.mopub.mobileads.GooglePlayServicesInterstitial");
        c = new <init>("MILLENNIAL_BANNER", 2, "millennial_native_banner", "com.mopub.mobileads.MillennialBanner");
        d = new <init>("MILLENNIAL_INTERSTITIAL", 3, "millennial_full_interstitial", "com.mopub.mobileads.MillennialInterstitial");
        e = new <init>("MRAID_BANNER", 4, "mraid_banner", "com.mopub.mraid.MraidBanner");
        f = new <init>("MRAID_INTERSTITIAL", 5, "mraid_interstitial", "com.mopub.mraid.MraidInterstitial");
        g = new <init>("HTML_BANNER", 6, "html_banner", "com.mopub.mobileads.HtmlBanner");
        h = new <init>("HTML_INTERSTITIAL", 7, "html_interstitial", "com.mopub.mobileads.HtmlInterstitial");
        i = new <init>("VAST_VIDEO_INTERSTITIAL", 8, "vast_interstitial", "com.mopub.mobileads.VastVideoInterstitial");
        j = new <init>("MOPUB_NATIVE", 9, "mopub_native", "com.mopub.nativeads.MoPubCustomEventNative");
        k = new <init>("UNSPECIFIED", 10, "", null);
        n = (new n[] {
            a, b, c, d, e, f, g, h, i, j, 
            k
        });
    }

    private (String s, int i1, String s1, String s2)
    {
        super(s, i1);
        l = s1;
        m = s2;
    }
}
