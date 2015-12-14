// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters;

import com.facebook.ads.internal.server.AdPlacementType;

// Referenced classes of package com.facebook.ads.internal.adapters:
//            h, f, i, j

public final class g extends Enum
{

    public static final g a;
    public static final g b;
    public static final g c;
    private static final g h[];
    public Class d;
    public String e;
    public f f;
    public AdPlacementType g;

    private g(String s, int k, Class class1, f f1, AdPlacementType adplacementtype)
    {
        super(s, k);
        d = class1;
        f = f1;
        g = adplacementtype;
    }

    public static g valueOf(String s)
    {
        return (g)Enum.valueOf(com/facebook/ads/internal/adapters/g, s);
    }

    public static g[] values()
    {
        return (g[])h.clone();
    }

    static 
    {
        a = new g("ANBANNER", 0, com/facebook/ads/internal/adapters/h, f.b, AdPlacementType.BANNER);
        b = new g("ANINTERSTITIAL", 1, com/facebook/ads/internal/adapters/i, f.b, AdPlacementType.INTERSTITIAL);
        c = new g("ANNATIVE", 2, com/facebook/ads/internal/adapters/j, f.b, AdPlacementType.NATIVE);
        h = (new g[] {
            a, b, c
        });
    }
}
