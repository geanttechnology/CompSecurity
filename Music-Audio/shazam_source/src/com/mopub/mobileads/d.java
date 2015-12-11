// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


public final class d
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        public static final a i;
        public static final a j;
        public static final a k;
        private static final a n[];
        private final String l;
        private final String m;

        public static a a(String s)
        {
            a aa[] = values();
            int j1 = aa.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                a a1 = aa[i1];
                if (a1.l.equals(s))
                {
                    return a1;
                }
            }

            return k;
        }

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/mopub/mobileads/d$a, s);
        }

        public static a[] values()
        {
            return (a[])n.clone();
        }

        public final String toString()
        {
            return m;
        }

        static 
        {
            a = new a("GOOGLE_PLAY_SERVICES_BANNER", 0, "admob_native_banner", "com.mopub.mobileads.GooglePlayServicesBanner");
            b = new a("GOOGLE_PLAY_SERVICES_INTERSTITIAL", 1, "admob_full_interstitial", "com.mopub.mobileads.GooglePlayServicesInterstitial");
            c = new a("MILLENNIAL_BANNER", 2, "millennial_native_banner", "com.mopub.mobileads.MillennialBanner");
            d = new a("MILLENNIAL_INTERSTITIAL", 3, "millennial_full_interstitial", "com.mopub.mobileads.MillennialInterstitial");
            e = new a("MRAID_BANNER", 4, "mraid_banner", "com.mopub.mraid.MraidBanner");
            f = new a("MRAID_INTERSTITIAL", 5, "mraid_interstitial", "com.mopub.mraid.MraidInterstitial");
            g = new a("HTML_BANNER", 6, "html_banner", "com.mopub.mobileads.HtmlBanner");
            h = new a("HTML_INTERSTITIAL", 7, "html_interstitial", "com.mopub.mobileads.HtmlInterstitial");
            i = new a("VAST_VIDEO_INTERSTITIAL", 8, "vast_interstitial", "com.mopub.mobileads.VastVideoInterstitial");
            j = new a("MOPUB_NATIVE", 9, "mopub_native", "com.mopub.nativeads.MoPubCustomEventNative");
            k = new a("UNSPECIFIED", 10, "", null);
            n = (new a[] {
                a, b, c, d, e, f, g, h, i, j, 
                k
            });
        }

        private a(String s, int i1, String s1, String s2)
        {
            super(s, i1);
            l = s1;
            m = s2;
        }
    }

}
