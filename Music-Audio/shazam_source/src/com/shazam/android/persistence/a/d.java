// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.a;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.res.Resources;
import com.shazam.android.persistence.n.b;

// Referenced classes of package com.shazam.android.persistence.a:
//            c

public final class d
    implements c
{

    private final b a;
    private final AccountManager b;
    private final String c;
    private String d;

    public d(AccountManager accountmanager, Resources resources, b b1)
    {
        b = accountmanager;
        a = b1;
        c = resources.getString(0x7f0900f7);
    }

    public final String a()
    {
        if (d != null)
        {
            return d;
        }
        String s = a.a("pk_re", null);
        Account aaccount[] = b.getAccountsByType("com.google");
        if (s != null)
        {
            d = s;
        } else
        if (aaccount != null && aaccount.length > 0)
        {
            d = aaccount[0].name;
        } else
        {
            return c;
        }
        return d;
    }

    public final void a(String s)
    {
        d = s;
    }

    public final boolean b()
    {
        if (d != null)
        {
            a.b("pk_re", d);
            return true;
        } else
        {
            return false;
        }
    }
}
