// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            wd

public final class wr extends wd
{

    public String a;
    public String b;
    public String c;

    public wr()
    {
    }

    public String a()
    {
        return a;
    }

    public volatile void a(wd wd1)
    {
        a((wr)wd1);
    }

    public void a(wr wr1)
    {
        if (!TextUtils.isEmpty(a))
        {
            wr1.a(a);
        }
        if (!TextUtils.isEmpty(b))
        {
            wr1.b(b);
        }
        if (!TextUtils.isEmpty(c))
        {
            wr1.c(c);
        }
    }

    public void a(String s)
    {
        a = s;
    }

    public String b()
    {
        return b;
    }

    public void b(String s)
    {
        b = s;
    }

    public String c()
    {
        return c;
    }

    public void c(String s)
    {
        c = s;
    }

    public String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("network", a);
        hashmap.put("action", b);
        hashmap.put("target", c);
        return a(hashmap);
    }
}
