// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import com.amazon.mShop.startup.BaseActivity;
import com.amazon.mShop.startup.StartupSequenceMediator;

public class StartupActivity extends BaseActivity
{

    private final StartupSequenceMediator mStartupSequenceMediator = new StartupSequenceMediator(this);

    public StartupActivity()
    {
    }

    public StartupSequenceMediator getStartupMediator()
    {
        return mStartupSequenceMediator;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (16 == i && intent != null)
        {
            String s = (String)intent.getCharSequenceExtra("intentExtraDataTaskId");
            intent = (String)intent.getCharSequenceExtra("intentExtraDataTaskResult");
            mStartupSequenceMediator.endTask(s, intent);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(com.amazon.mShop.android.lib.R.layout.splash_screen);
    }
}
