// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.activities.handlers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import io.presage.activities.PresageActivity;
import io.presage.activities.do.b;
import io.presage.activities.do.c;
import io.presage.activities.do.d;
import io.presage.ads.a;
import io.presage.formats.f;

public class LegacyActivityHandler extends io.presage.activities.PresageActivity.ActivityHandler
    implements b
{

    private io.presage.ads.d b;
    private d c;

    public LegacyActivityHandler(Activity activity)
    {
        super(activity);
    }

    public void dontShowAd(String s)
    {
        if (b != null && c.a() == io.presage.activities.do.c.a.b)
        {
            b.b("youtube", s);
        }
        a.finish();
    }

    public void finishActivity()
    {
        a.finish();
    }

    public void onCreate(Bundle bundle)
    {
        Bundle bundle1 = a.getIntent().getExtras();
        bundle = null;
        if (bundle1 != null)
        {
            bundle = bundle1.getString("io.presage.extras.ADVERT_ID");
        }
        if (bundle == null)
        {
            a.finish();
            return;
        }
        bundle = a.a().a(bundle);
        b = bundle;
        if (bundle == null)
        {
            a.finish();
            return;
        }
        ((f)bundle.d()).a(this);
        io.presage.activities.do.c.a();
        c = io.presage.activities.do.c.a((PresageActivity)a, this, b);
        if (c == null)
        {
            a.finish();
            return;
        } else
        {
            c.i();
            a.setContentView(c.g(), c.h());
            return;
        }
    }

    public void onDestroy()
    {
        if (c == null) goto _L2; else goto _L1
_L1:
        c.c();
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[io.presage.activities.do.a.a.values().length];
                try
                {
                    a[io.presage.activities.do.a.a.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[io.presage.activities.do.a.a.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[io.presage.activities.do.a.a.a.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        io.presage.activities.handlers._cls1.a[c.b().ordinal()];
        JVM INSTR tableswitch 1 2: default 56
    //                   1 57
    //                   2 81;
           goto _L2 _L3 _L4
_L2:
        return;
_L3:
        b.b("cancel");
        b = null;
        a.finish();
        return;
_L4:
        b.b("close");
        a.finish();
        return;
    }

    public void onPause()
    {
        if (c != null)
        {
            c.a(a.isFinishing());
        }
    }

    public void setErroredState()
    {
        c.d();
    }

    public void showAd()
    {
    }
}
