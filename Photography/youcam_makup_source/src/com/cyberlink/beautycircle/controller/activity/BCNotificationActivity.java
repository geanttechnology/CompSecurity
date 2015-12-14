// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.u;
import com.cyberlink.beautycircle.m;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.e;
import java.net.URI;

public class BCNotificationActivity extends BaseActivity
{

    public BCNotificationActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        Object obj = null;
        super.onCreate(bundle);
        c = false;
        Intent intent = getIntent();
        if (intent != null)
        {
            bundle = intent.getStringExtra("DeepLink");
        } else
        {
            bundle = null;
        }
        if (bundle != null && !bundle.isEmpty())
        {
            e.b(new Object[] {
                (new StringBuilder()).append("Old DeepLink : ").append(bundle).toString()
            });
            try
            {
                bundle = Uri.parse(bundle);
                bundle = new URI(getResources().getString(m.bc_appscheme), bundle.getSchemeSpecificPart(), bundle.getFragment());
                e.b(new Object[] {
                    (new StringBuilder()).append("New DeepLink : ").append(bundle.toString()).toString()
                });
                c.a(this, Uri.parse(bundle.toString()));
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
                c.a(this, com.cyberlink.beautycircle.controller.activity.MainActivity.TabPage.e);
            }
        } else
        {
            e.b(new Object[] {
                "No deep link"
            });
            c.a(this, com.cyberlink.beautycircle.controller.activity.MainActivity.TabPage.e);
        }
        bundle = obj;
        if (intent != null)
        {
            bundle = intent.getStringExtra("EventType");
        }
        b.a(new u(bundle));
        finish();
    }
}
