// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.shazam.android.aq.h;
import com.shazam.android.base.activities.BaseAppCompatActivity;
import com.shazam.android.n.e;
import com.shazam.android.persistence.e.d;
import com.shazam.i.b.ah.c.b;
import com.shazam.i.b.c;
import com.shazam.i.b.q.a;

public class FacebookDeepLinkActivity extends BaseAppCompatActivity
{

    private final d a = com.shazam.i.b.ah.c.b.a();
    private final e b = new e(com.shazam.i.b.q.a.a());
    private final com.shazam.android.e.b c = new com.shazam.android.e.e(com.shazam.i.b.g.b.a.a());
    private final com.shazam.android.n.b d;

    public FacebookDeepLinkActivity()
    {
        Intent intent = com.shazam.android.util.f.a.a(com.shazam.i.b.al.b.a().a().b());
        d = new com.shazam.android.n.b(com.shazam.i.b.c.a(), intent);
    }

    protected void onCreate(Bundle bundle)
    {
        Object obj;
        Intent intent;
        com.shazam.android.n.b b1;
        boolean flag;
        flag = false;
        super.onCreate(bundle);
        intent = getIntent();
        b1 = d;
        obj = null;
        bundle = ((Bundle) (obj));
        if (!b1.b.equals("com.shazam.android")) goto _L2; else goto _L1
_L1:
        android.content.pm.PackageManager packagemanager;
        Intent intent1;
        bundle = new ComponentName("com.shazam.encore.android", com/shazam/android/activities/FacebookDeepLinkActivity.getName());
        new com.shazam.android.util.f.a();
        packagemanager = b1.a;
        intent1 = new Intent();
        intent1.setComponent(bundle);
        if (!com.shazam.android.util.f.a.a(packagemanager, intent1, 0)) goto _L4; else goto _L3
_L3:
        intent.setPackage("com.shazam.encore.android");
        intent.setComponent(bundle);
        bundle = intent;
_L2:
        obj = bundle;
        if (bundle == null)
        {
            obj = bundle;
            if (a.a())
            {
                (new StringBuilder("First time user... for ")).append(intent);
                obj = com.shazam.android.activities.b.b.b(this, intent);
            }
        }
        bundle = ((Bundle) (obj));
        if (obj == null)
        {
            obj = b.a(this, intent, c);
            if (!com.shazam.android.util.f.a.a(this, ((Intent) (obj))))
            {
                flag = true;
            }
            bundle = ((Bundle) (obj));
            if (flag)
            {
                (new StringBuilder("Intent was uninterpretable: ")).append(obj);
                c.c("uninterpretable");
                bundle = com.shazam.android.activities.b.a.a(this);
            }
        }
        c.a();
        startActivity(bundle);
        finish();
        return;
_L4:
        new com.shazam.android.util.f.a();
        android.content.pm.PackageManager packagemanager1 = b1.a;
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setClassName("com.shazam.encore.android", "com.shazam.android.Home");
        bundle = ((Bundle) (obj));
        if (com.shazam.android.util.f.a.a(packagemanager1, intent2, 0x10000))
        {
            bundle = b1.c;
        }
        if (true) goto _L2; else goto _L5
_L5:
    }
}
