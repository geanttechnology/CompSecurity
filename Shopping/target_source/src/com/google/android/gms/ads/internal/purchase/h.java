// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import com.google.android.gms.ads.internal.c;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.bz;

// Referenced classes of package com.google.android.gms.ads.internal.purchase:
//            f, i

public class h
{

    private final String a;

    public String a()
    {
        return c.c().b();
    }

    public boolean a(String s, int j, Intent intent)
    {
        if (s != null && intent != null)
        {
            String s1 = c.j().b(intent);
            intent = c.j().c(intent);
            if (s1 != null && intent != null)
            {
                if (!s.equals(c.j().a(s1)))
                {
                    b.e("Developer payload not match.");
                    return false;
                }
                if (a != null && !i.a(a, s1, intent))
                {
                    b.e("Fail to verify signature.");
                    return false;
                } else
                {
                    return true;
                }
            }
        }
        return false;
    }
}
