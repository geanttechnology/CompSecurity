// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            wd

public final class wp extends wd
{

    public String a;
    public boolean b;

    public wp()
    {
    }

    public String a()
    {
        return a;
    }

    public volatile void a(wd wd1)
    {
        a((wp)wd1);
    }

    public void a(wp wp1)
    {
        if (!TextUtils.isEmpty(a))
        {
            wp1.a(a);
        }
        if (b)
        {
            wp1.a(b);
        }
    }

    public void a(String s)
    {
        a = s;
    }

    public void a(boolean flag)
    {
        b = flag;
    }

    public boolean b()
    {
        return b;
    }

    public String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("description", a);
        hashmap.put("fatal", Boolean.valueOf(b));
        return a(hashmap);
    }
}
