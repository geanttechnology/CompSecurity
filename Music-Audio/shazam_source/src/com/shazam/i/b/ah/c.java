// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b.ah;

import android.accounts.AccountManager;
import com.shazam.android.persistence.a.a;
import com.shazam.model.account.EmailAddressAccessor;

public final class c
{

    public static EmailAddressAccessor a()
    {
        return new a(AccountManager.get(com.shazam.i.b.c.a()), new com.shazam.android.ag.a.a());
    }
}
