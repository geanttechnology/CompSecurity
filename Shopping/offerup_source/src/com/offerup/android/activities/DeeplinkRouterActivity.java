// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.b.a.a.g;
import com.offerup.android.utils.a;

// Referenced classes of package com.offerup.android.activities:
//            a

public class DeeplinkRouterActivity extends AppCompatActivity
{

    public DeeplinkRouterActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent();
        boolean flag = bundle.getBooleanExtra("activity_started_externally", true);
        if ("android.intent.action.VIEW".equals(bundle.getAction()))
        {
            bundle = bundle.getData();
            if (bundle != null)
            {
                g.b(this, (new StringBuilder("loading uri ")).append(bundle.toString()).toString());
                (new a(new com.offerup.android.activities.a(this), flag)).a(bundle);
            } else
            {
                g.a(this, new Throwable("attempted to load with invalid uri"));
            }
        } else
        {
            g.a(this, new Throwable("attempted to load with invalid configured intent action"));
        }
        finish();
    }
}
