// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.foundations.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import com.google.inject.Injector;
import roboguice.RoboGuice;

public class BaseActionBarActivity extends ActionBarActivity
{

    protected Injector injector;

    public BaseActionBarActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (injector == null)
        {
            injector = RoboGuice.getInjector(this);
            injector.injectMembers(this);
        }
    }

    protected void onDestroy()
    {
        RoboGuice.destroyInjector(this);
        super.onDestroy();
    }
}
