// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.fotoable.ad.ApplicationState;
import com.pipcamera.activity.guide.GuideViewAcitivity;
import com.pipcamera.activity.pip.PipStyleActivity;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.service.net.PushService;
import en;
import kf;
import kg;
import kh;
import la;

// Referenced classes of package com.pipcamera.activity:
//            FullscreenActivity, PIPCameraActivity

public class SplashScreenActivity extends FullscreenActivity
{

    String a;
    String b;
    String c;
    String d;

    public SplashScreenActivity()
    {
        a = "AlertAd";
        b = "alertTime";
        c = "AdButtonGroup";
        d = "adRequestTime";
    }

    private void c()
    {
        startService(new Intent(this, com/wantu/service/net/PushService));
    }

    public void a()
    {
        startActivity(new Intent(this, com/pipcamera/activity/guide/GuideViewAcitivity));
        finish();
        PIPCameraApplication.g = false;
        overridePendingTransition(0x7f040011, 0x7f040018);
    }

    public void b()
    {
        startActivity(new Intent(this, com/pipcamera/activity/PIPCameraActivity));
        finish();
        PIPCameraApplication.g = false;
        overridePendingTransition(0x7f040011, 0x7f040018);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ApplicationState.clearExistTime();
        setContentView(0x7f030089);
        la.a(PIPCameraApplication.b().c(), a, b, "0");
        la.a(PIPCameraApplication.b().c(), c, d, "0");
        en.a(PIPCameraApplication.a);
    }

    protected void onResume()
    {
        super.onResume();
        Object obj = getIntent();
        if (obj != null)
        {
            Object obj1 = ((Intent) (obj)).getExtras();
            if ("android.intent.action.SEND".equals(((Intent) (obj)).getAction()) && ((Bundle) (obj1)).containsKey("android.intent.extra.STREAM"))
            {
                try
                {
                    c();
                    obj = (Uri)((Bundle) (obj1)).getParcelable("android.intent.extra.STREAM");
                    obj1 = new Intent(this, com/pipcamera/activity/pip/PipStyleActivity);
                    ((Intent) (obj1)).putExtra("SelectedImageUri", ((Uri) (obj)).toString());
                    startActivity(((Intent) (obj1)));
                    finish();
                    PIPCameraApplication.g = true;
                    return;
                }
                catch (Exception exception)
                {
                    Log.e(getClass().getName(), exception.toString());
                    Crashlytics.logException(exception);
                }
            }
        }
        exception = getSharedPreferences("config", 0);
        if (!exception.getBoolean("isCreatedIcon", false))
        {
            exception = exception.edit();
            exception.putBoolean("isCreatedIcon", true);
            exception.commit();
            la.b(getApplicationContext(), "appnewuser", true);
        }
        if (la.a(getApplicationContext(), "appnewuser", false))
        {
            kg.a().a(getApplicationContext(), "NewUser", "Add", null, new kh() {

                final SplashScreenActivity a;

                public void a(boolean flag1)
                {
                    if (flag1)
                    {
                        la.b(a.getApplicationContext(), "appnewuser", false);
                    }
                }

            
            {
                a = SplashScreenActivity.this;
                super();
            }
            });
        }
        exception = getSharedPreferences("isNeedGotoGuideView", 0);
        StringBuilder stringbuilder = (new StringBuilder()).append("isGotoGuideView_");
        kf.c();
        boolean flag = exception.getBoolean(stringbuilder.append(kf.a).toString(), true);
        if (kf.b())
        {
            if (flag)
            {
                exception.edit().putBoolean("guideViewShown", true).apply();
            } else
            {
                exception.edit().putBoolean("guideViewShown", false).apply();
            }
        }
        (new Handler()).postDelayed(new Runnable(flag, exception) {

            final boolean a;
            final SharedPreferences b;
            final SplashScreenActivity c;

            public void run()
            {
                if (!kf.b())
                {
                    c.b();
                    return;
                }
                if (a)
                {
                    android.content.SharedPreferences.Editor editor = b.edit();
                    StringBuilder stringbuilder1 = (new StringBuilder()).append("isGotoGuideView_");
                    kf.c();
                    editor.putBoolean(stringbuilder1.append(kf.a).toString(), false);
                    editor.apply();
                    c.a();
                    return;
                } else
                {
                    c.b();
                    return;
                }
            }

            
            {
                c = SplashScreenActivity.this;
                a = flag;
                b = sharedpreferences;
                super();
            }
        }, 800L);
    }

    protected void onStart()
    {
        super.onStart();
    }

    protected void onStop()
    {
        super.onStop();
    }
}
