// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotobeauty;

import ack;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import aoc;
import apq;
import apr;
import aqx;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.ApplicationState;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.activity.guide.GuideViewAcitivity;
import hu;

// Referenced classes of package com.fotoable.fotobeauty:
//            FullscreenActivity, WantuActivity

public class SplashScreenActivity extends FullscreenActivity
{

    public SplashScreenActivity()
    {
    }

    private void c()
    {
        try
        {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            Object obj = android.content.Intent.ShortcutIconResource.fromContext(this, 0x7f02034c);
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ((android.os.Parcelable) (obj)));
            intent.putExtra("android.intent.extra.shortcut.NAME", getResources().getString(0x7f060077));
            obj = new Intent();
            ((Intent) (obj)).setClass(this, com/fotoable/fotobeauty/SplashScreenActivity);
            ((Intent) (obj)).setAction("android.intent.action.MAIN");
            ((Intent) (obj)).addCategory("android.intent.category.LAUNCHER");
            intent.putExtra("android.intent.extra.shortcut.INTENT", ((android.os.Parcelable) (obj)));
            sendBroadcast(intent);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void a()
    {
        startActivity(new Intent(this, com/wantu/activity/guide/GuideViewAcitivity));
        finish();
        InstaBeautyApplication.g = false;
        overridePendingTransition(0x7f04001c, 0x7f040025);
    }

    public void b()
    {
        startActivity(new Intent(this, com/fotoable/fotobeauty/WantuActivity));
        InstaBeautyApplication.g = false;
        overridePendingTransition(0x7f04001c, 0x7f040025);
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ApplicationState.clearExistTime();
        setContentView(0x7f0300c7);
        bundle = getIntent();
        if (bundle != null)
        {
            Bundle bundle1 = bundle.getExtras();
            if ("android.intent.action.SEND".equals(bundle.getAction()) && bundle1.containsKey("android.intent.extra.STREAM"))
            {
                return;
            }
        }
        bundle = getSharedPreferences("signOfIcon", 0);
        if (!bundle.getBoolean("isCreatedIcon", false))
        {
            bundle = bundle.edit();
            bundle.putBoolean("isCreatedIcon", true);
            bundle.apply();
            c();
            aqx.b(getApplicationContext(), "appnewuser", true);
        }
        bundle = getIntent().getExtras();
        if (bundle != null && Boolean.valueOf(bundle.getBoolean(ActivityCameraNew.c)).booleanValue())
        {
            ActivityCameraNew.a(this, 1001);
            finish();
            return;
        }
        apr.a().a(InstaBeautyApplication.a, null);
        aoc.a(getApplicationContext());
        bundle = getSharedPreferences("isNeedGotoGuideView", 0);
        boolean flag = bundle.getBoolean((new StringBuilder()).append("isGotoGuideView_").append(apq.a).toString(), true);
        if (apq.b())
        {
            if (flag)
            {
                bundle.edit().putBoolean("guideViewShown", true).apply();
            } else
            {
                bundle.edit().putBoolean("guideViewShown", false).apply();
            }
        }
        (new Handler()).postDelayed(new ack(this, flag, bundle), 800L);
        hu.a(InstaBeautyApplication.a);
    }

    protected void onResume()
    {
        super.onResume();
        FlurryAgent.onPageView();
    }

    protected void onStart()
    {
        super.onStart();
        FlurryAgent.setCaptureUncaughtExceptions(false);
        FlurryAgent.setReportLocation(false);
        FlurryAgent.setContinueSessionMillis(0x15f90L);
    }

    protected void onStop()
    {
        super.onStop();
    }
}
