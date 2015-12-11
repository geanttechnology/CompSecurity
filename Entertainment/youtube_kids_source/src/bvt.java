// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;

public class bvt
{

    public int a;
    public Uri b;
    public Uri c;
    public String d;
    private String e;
    private String f;
    private boolean g;
    private float h;

    public bvt(String s, String s1)
    {
        e = s;
        f = s1;
    }

    public final bvr a()
    {
        return new bvr(e, d, b, f, g, h, c, a);
    }

    public final bvt a(float f1)
    {
        if (f1 > 0.1F)
        {
            g = true;
            h = f1;
        }
        return this;
    }
}
