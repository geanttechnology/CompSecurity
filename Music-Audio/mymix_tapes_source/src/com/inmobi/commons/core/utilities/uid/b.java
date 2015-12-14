// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.utilities.uid;

import android.content.Context;
import com.inmobi.commons.core.b.c;

class b
{

    private c a;

    public b()
    {
        a = com.inmobi.commons.core.b.c.b("uid_store");
    }

    public b(Context context)
    {
        a = com.inmobi.commons.core.b.c.a(context, "uid_store");
    }

    public String a()
    {
        return a.b("adv_id", null);
    }

    public void a(long l)
    {
        a.a("imid_timestamp", l);
    }

    public void a(String s)
    {
        a.a("adv_id", s);
    }

    public void a(boolean flag)
    {
        a.a("limit_ad_tracking", flag);
    }

    public void b(String s)
    {
        a.a("app_id", s);
    }

    public boolean b()
    {
        return a.b("limit_ad_tracking", true);
    }

    public String c()
    {
        return a.b("app_id", null);
    }

    public void c(String s)
    {
        a.a("im_id", s);
    }

    public String d()
    {
        return a.b("im_id", null);
    }

    public void d(String s)
    {
        a.a("appended_id", s);
    }

    public long e()
    {
        return a.b("imid_timestamp", 0L);
    }

    public String f()
    {
        return a.b("appended_id", null);
    }
}
