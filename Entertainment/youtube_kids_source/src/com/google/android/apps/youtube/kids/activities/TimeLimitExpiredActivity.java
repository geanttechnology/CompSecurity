// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.activities;

import acd;
import acr;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.apps.youtube.kids.application.KidsApplication;
import com.google.android.apps.youtube.kids.ui.ParentalControlLaunchBar;
import vq;

// Referenced classes of package com.google.android.apps.youtube.kids.activities:
//            ScalingVideoView

public class TimeLimitExpiredActivity extends vq
{

    private ScalingVideoView h;

    public TimeLimitExpiredActivity()
    {
    }

    protected final void g()
    {
        g.a(false);
    }

    public void onBackPressed()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040066);
        h = (ScalingVideoView)findViewById(0x7f1001ba);
        h.setClickable(false);
        bundle = getResources().openRawResourceFd(0x7f080000);
        h.a(bundle);
        ((ParentalControlLaunchBar)findViewById(0x7f1000b9)).a();
    }

    protected void onPause()
    {
        super.onPause();
        h.b();
    }

    protected void onResume()
    {
        h.a();
        super.onResume();
        if (!((KidsApplication)getApplicationContext()).d.f)
        {
            finish();
        }
    }
}
