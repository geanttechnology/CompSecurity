// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.aa;
import android.support.v4.app.an;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import com.offerup.android.g.b.a;
import com.offerup.android.g.b.af;
import com.offerup.android.g.b.i;
import com.offerup.android.g.b.k;
import com.offerup.android.g.b.x;
import com.offerup.android.g.b.z;

public class LoginActivity extends AppCompatActivity
    implements af, i, x
{

    public LoginActivity()
    {
    }

    private void a(int j)
    {
        if (getIntent() != null && getIntent().hasExtra("login_complete_intent"))
        {
            setResult(-1, (Intent)getIntent().getParcelableExtra("login_complete_intent"));
            return;
        } else
        {
            setResult(-1);
            return;
        }
    }

    public final void a()
    {
        a a1 = com.offerup.android.g.b.a.a();
        getSupportFragmentManager().a().a(null).a(a1, null).b();
    }

    public final void b()
    {
        z z1 = z.a();
        getSupportFragmentManager().a().a(null).a(z1, null).b();
    }

    public final void c()
    {
        a(-1);
        finish();
    }

    public final void d()
    {
        a(-1);
        finish();
    }

    public final void e()
    {
        a(-1);
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040026);
        bundle = k.a();
        getSupportFragmentManager().a().a(null).a(bundle, null).b();
    }

    public boolean onKeyDown(int j, KeyEvent keyevent)
    {
        if (j == 82)
        {
            return true;
        } else
        {
            return super.onKeyDown(j, keyevent);
        }
    }
}
