// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.accounts.AccountAuthenticatorActivity;
import android.os.Bundle;
import com.shazam.android.util.s;
import com.shazam.i.b.au.d;

public class StubAccountActivity extends AccountAuthenticatorActivity
{

    private final s a = d.a();

    public StubAccountActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = a;
        com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
        a1.a = 0x7f09006e;
        a1.c = 0;
        bundle.a(a1.a());
        finish();
    }
}
