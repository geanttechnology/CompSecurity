// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.oauth2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.socialin.android.activity.BaseActivity;
import myobfuscated.ca.a;

public class OAuth2BaseActivity extends BaseActivity
{

    public OAuth2BaseActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03017e);
        bundle = getFragmentManager().beginTransaction();
        bundle.add(0x7f10074e, new a(), "oauth_fragment_tag");
        bundle.commit();
    }

    public void onFragmentResult(int i, Intent intent)
    {
        super.onFragmentResult(i, intent);
        setResult(i, intent);
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            setResult(1);
            finish();
        }
        return super.onKeyDown(i, keyevent);
    }
}
