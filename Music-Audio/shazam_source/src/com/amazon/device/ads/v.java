// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.amazon.device.ads:
//            co, cn

public class v
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        private static final a h[];
        final String f;
        private final String g;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/amazon/device/ads/v$a, s);
        }

        public static a[] values()
        {
            return (a[])h.clone();
        }

        public final String toString()
        {
            return g;
        }

        static 
        {
            a = new a("IMAGE_BANNER", 0, "Image Banner");
            b = new a("MRAID_1", 1, "MRAID 1.0");
            c = new a("MRAID_2", 2, "MRAID 2.0");
            d = new a("INTERSTITIAL", 3, "Interstitial", "i");
            e = new a("MODELESS_INTERSTITIAL", 4, "Modeless Interstitial", "mi");
            h = (new a[] {
                a, b, c, d, e
            });
        }

        private a(String s, int i, String s1)
        {
            this(s, i, s1, null);
        }

        private a(String s, int i, String s1, String s2)
        {
            super(s, i);
            g = s1;
            f = s2;
        }
    }

