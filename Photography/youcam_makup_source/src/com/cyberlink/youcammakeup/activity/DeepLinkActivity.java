// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.utility.a;

public class DeepLinkActivity extends BaseActivity
{

    public DeepLinkActivity()
    {
    }

    private void a(Intent intent)
    {
        if (intent == null || intent.getData() == null)
        {
            return;
        } else
        {
            com.cyberlink.youcammakeup.utility.a.b(intent.getData().toString(), this, intent);
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent();
        if (bundle == null || bundle.getData() == null)
        {
            finish();
        }
        a(bundle);
        finish();
    }
}
