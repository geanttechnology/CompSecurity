// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import java.util.Locale;

public class f
{

    public String a;
    public String b;
    public String c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;

    public f()
    {
        a = "anonymous";
        b = "fullscreen";
        c = "exit";
        d = true;
        e = true;
        f = false;
        g = false;
    }

    public boolean a()
    {
        return "fullscreen".equals(b.toLowerCase(Locale.ENGLISH));
    }

    public boolean b()
    {
        return "exit".equals(c.toLowerCase(Locale.ENGLISH));
    }
}
