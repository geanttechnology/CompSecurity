// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook.activity;

import android.content.Intent;
import android.os.Bundle;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.facebook.util.FacebookUtils;

public class FacebookAdapterActivity extends BaseActivity
{

    public FacebookAdapterActivity()
    {
    }

    public void dismissFragmentProgressDialog()
    {
        super.dismissFragmentProgressDialog();
        finish();
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (j == 0)
        {
            finish();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        boolean flag1 = false;
        super.onCreate(bundle);
        boolean flag = flag1;
        if (bundle != null)
        {
            flag = flag1;
            if (bundle.getBoolean("videoPost", false))
            {
                flag = true;
            }
        }
        FacebookUtils.postToFbWall(getIntent().getStringExtra("fbImagePath"), "", this, com.facebook.CallbackManager.Factory.create(), flag);
    }
}
