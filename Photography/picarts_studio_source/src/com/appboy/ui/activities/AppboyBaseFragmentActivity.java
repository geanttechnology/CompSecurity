// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appboy.ui.activities;

import android.support.v4.app.FragmentActivity;
import com.appboy.Appboy;
import com.appboy.ui.inappmessage.a;

public class AppboyBaseFragmentActivity extends FragmentActivity
{

    public AppboyBaseFragmentActivity()
    {
    }

    public void onPause()
    {
        super.onPause();
        a.a().b(this);
    }

    public void onResume()
    {
        super.onResume();
        a.a().a(this);
    }

    public void onStart()
    {
        super.onStart();
        Appboy.getInstance(this).openSession(this);
    }

    public void onStop()
    {
        super.onStop();
        Appboy.getInstance(this).closeSession(this);
    }
}
