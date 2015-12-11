// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


public final class s extends Enum
{

    public static final s a;
    public static final s b;
    public static final s c;
    public static final s d;
    public static final s e;
    public static final s f;
    public static final s g;
    public static final s h;
    public static final s i;
    public static final s j;
    public static final s k;
    public static final s l;
    public static final s m;
    public static final s n;
    public static final s o;
    public static final s p;
    public static final s q;
    private static final s s[];
    private final String r;

    private s(String s1, int i1, String s2)
    {
        super(s1, i1);
        r = s2;
    }

    public static s valueOf(String s1)
    {
        return (s)Enum.valueOf(com/mopub/mobileads/s, s1);
    }

    public static s[] values()
    {
        return (s[])s.clone();
    }

    public final String toString()
    {
        return r;
    }

    static 
    {
        a = new s("NO_FILL", 0, "No ads found.");
        b = new s("WARMUP", 1, "Ad unit is warming up. Try again in a few minutes.");
        c = new s("SERVER_ERROR", 2, "Unable to connect to MoPub adserver.");
        d = new s("INTERNAL_ERROR", 3, "Unable to serve ad due to invalid internal state.");
        e = new s("CANCELLED", 4, "Ad request was cancelled.");
        f = new s("NO_CONNECTION", 5, "No internet connection detected.");
        g = new s("ADAPTER_NOT_FOUND", 6, "Unable to find Native Network or Custom Event adapter.");
        h = new s("ADAPTER_CONFIGURATION_ERROR", 7, "Native Network or Custom Event adapter was configured incorrectly.");
        i = new s("NETWORK_TIMEOUT", 8, "Third-party network failed to respond in a timely manner.");
        j = new s("NETWORK_NO_FILL", 9, "Third-party network failed to provide an ad.");
        k = new s("NETWORK_INVALID_STATE", 10, "Third-party network failed due to invalid internal state.");
        l = new s("MRAID_LOAD_ERROR", 11, "Error loading MRAID ad.");
        m = new s("VIDEO_CACHE_ERROR", 12, "Error creating a cache to store downloaded videos.");
        n = new s("VIDEO_DOWNLOAD_ERROR", 13, "Error downloading video.");
        o = new s("VIDEO_NOT_AVAILABLE", 14, "No video loaded for ad unit.");
        p = new s("VIDEO_PLAYBACK_ERROR", 15, "Error playing a video.");
        q = new s("UNSPECIFIED", 16, "Unspecified error.");
        s = (new s[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q
        });
    }
}
