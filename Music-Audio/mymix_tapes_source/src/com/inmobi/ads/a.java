// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.content.ContentValues;

// Referenced classes of package com.inmobi.ads:
//            f, e

class a
{

    private static final String a = com/inmobi/ads/a.getSimpleName();
    private String b;
    private String c;
    private String d;
    private long e;
    private long f;
    private String g;

    public a(ContentValues contentvalues)
    {
        b = contentvalues.getAsString("ad_type");
        c = contentvalues.getAsString("ad_size");
        d = contentvalues.getAsString("ad_content");
        e = contentvalues.getAsLong("placement_id").longValue();
        f = contentvalues.getAsLong("insertion_ts").longValue();
        g = contentvalues.getAsString("imp_id");
    }

    public a(f f1, String s, String s1)
    {
        b = f1.b().b();
        c = f1.b().c();
        d = s;
        e = f1.b().e();
        f = System.currentTimeMillis();
        g = s1;
    }

    public ContentValues a()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("ad_type", b);
        contentvalues.put("ad_size", c);
        contentvalues.put("ad_content", d);
        contentvalues.put("placement_id", Long.valueOf(e));
        contentvalues.put("insertion_ts", Long.valueOf(f));
        contentvalues.put("imp_id", g);
        return contentvalues;
    }

    public String b()
    {
        return d;
    }

    public String c()
    {
        return g;
    }

    public long d()
    {
        return f;
    }

}
