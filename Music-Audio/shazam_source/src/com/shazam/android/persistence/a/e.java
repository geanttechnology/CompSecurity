// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.a;

import com.shazam.android.persistence.n.b;
import com.shazam.j.c;
import com.shazam.k.a;
import com.shazam.model.account.Account;

public final class e
    implements a
{

    private final b a;
    private final com.shazam.j.b b;

    public e(b b1, com.shazam.j.b b2)
    {
        a = b1;
        b = b2;
    }

    public final Account a()
    {
        Account account = com.shazam.model.account.Account.Builder.a().b();
        Account account1;
        if (!a.a("pk_account"))
        {
            break MISSING_BLOCK_LABEL_52;
        }
        account1 = (Account)b.a(a.a("pk_account", ""), com/shazam/model/account/Account);
        return account1;
        c c1;
        c1;
        return account;
    }

    public final void a(Account account)
    {
        try
        {
            a.b("pk_account", b.a(account));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Account account)
        {
            return;
        }
    }
}
