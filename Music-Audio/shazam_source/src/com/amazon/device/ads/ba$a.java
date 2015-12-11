// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            ba

public static final class m
{

    public static final g a;
    public static final g b;
    public static final g c;
    public static final g d;
    public static final g e;
    public static final g f;
    public static final g g;
    public static final g h[];
    final String i;
    final String j;
    final Class k;
    final String l;
    final boolean m;

    static 
    {
        a = new <init>("config-aaxHostname", java/lang/String, "aaxHostname", "debug.aaxHostname");
        b = new <init>("config-sisURL", java/lang/String, "sisURL", "debug.sisURL");
        c = new <init>("config-adPrefURL", java/lang/String, "adPrefURL", "debug.adPrefURL");
        d = new <init>("config-madsHostname", java/lang/String, "madsHostname", "debug.madsHostname", true);
        e = new <init>("config-sisDomain", java/lang/String, "sisDomain", "debug.sisDomain");
        f = new <init>("config-sendGeo", java/lang/Boolean, "sendGeo", "debug.sendGeo");
        g = new <init>("config-truncateLatLon", java/lang/Boolean, "truncateLatLon", "debug.truncateLatLon");
        h = (new h[] {
            a, b, c, d, e, f, g
        });
    }

    private (String s, Class class1, String s1, String s2)
    {
        this(s, class1, s1, s2, false);
    }

    private <init>(String s, Class class1, String s1, String s2, boolean flag)
    {
        i = s;
        j = s1;
        k = class1;
        l = s2;
        m = flag;
    }
}
