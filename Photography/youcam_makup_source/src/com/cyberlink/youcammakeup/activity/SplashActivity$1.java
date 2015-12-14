// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.pf.common.restart.RestartService;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SplashActivity, GpuBenchmarkActivity, OpeningTutorialActivity, LauncherActivity, 
//            EditViewActivity, CameraActivity, CameraLandscapeActivity, MoreActivity, 
//            MoreMakeupActivity, ExtraDownloadActivity, NoticeActivity, FacebookFriendPickerActivity, 
//            FacebookPlacePickerActivity, FacebookSharingActivity, VideoPlaybackActivity, BeautyTipFilmActivity, 
//            BeautyTipCategoryActivity, SponsorAdActivity, LibraryPickerActivity, SettingActivity, 
//            AboutActivity, WebViewerExActivity, WeekStarActivity

class a
    implements Runnable
{

    final SplashActivity a;

    public void run()
    {
        Intent intent1 = null;
        String s = Globals.d().v();
        Intent intent;
        if (!z.a("HAD_RUN_GPU_BENCHMARK", false, Globals.d()))
        {
            intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/GpuBenchmarkActivity);
        } else
        {
            intent = intent1;
            if (s != null)
            {
                if (!Globals.d().N().equals("") || s.equals(""))
                {
                    a.finish();
                    return;
                }
                if (s.equals("launcher"))
                {
                    intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity);
                } else
                if (s.equals("editView"))
                {
                    intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/EditViewActivity);
                } else
                if (s.equals("cameraView"))
                {
                    intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/CameraActivity);
                } else
                if (s.equals("cameraLandscapeView"))
                {
                    intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/CameraLandscapeActivity);
                } else
                if (s.equals("morePage"))
                {
                    intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/MoreActivity);
                } else
                if (s.equals("makeupCategoryActivity"))
                {
                    intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/MoreMakeupActivity);
                } else
                if (s.equals("extraDownloadPage"))
                {
                    intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/ExtraDownloadActivity);
                } else
                if (s.equals("noticePage"))
                {
                    intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/NoticeActivity);
                } else
                if (s.equals("facebookFriendPickerPage"))
                {
                    intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/FacebookFriendPickerActivity);
                } else
                if (s.equals("facebookPlacePickerPage"))
                {
                    intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/FacebookPlacePickerActivity);
                } else
                if (s.equals("facebookSharingPage"))
                {
                    intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/FacebookSharingActivity);
                } else
                if (s.equals("videoPlaybackPage"))
                {
                    intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/VideoPlaybackActivity);
                } else
                if (s.equals("beautyTipFilmActivity"))
                {
                    intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/BeautyTipFilmActivity);
                } else
                if (s.equals("beautyTipCategoryActivity"))
                {
                    intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/BeautyTipCategoryActivity);
                } else
                if (s.equals("sponsorAdActivity"))
                {
                    intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/SponsorAdActivity);
                } else
                if (s.equals("libraryView"))
                {
                    intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/LibraryPickerActivity);
                } else
                if (s.equals("settingPage"))
                {
                    intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/SettingActivity);
                } else
                if (s.equals("aboutPage"))
                {
                    intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/AboutActivity);
                } else
                if (s.equals("webViewerExActivity"))
                {
                    intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/WebViewerExActivity);
                } else
                {
                    intent = intent1;
                    if (s.equals("weekStar"))
                    {
                        intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/WeekStarActivity);
                    }
                }
            }
        }
        intent1 = intent;
        if (intent == null)
        {
            if (!z.a("HAD_SHOWN_OPENING_TUTORIAL_V4.13.0", false, a.getApplicationContext()))
            {
                intent1 = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/OpeningTutorialActivity);
            } else
            {
                intent1 = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity);
            }
        }
        intent1.putExtra("RestartService.reason", RestartService.a(a.getIntent()));
        a.startActivity(intent1);
        a.finish();
    }

    ty(SplashActivity splashactivity)
    {
        a = splashactivity;
        super();
    }
}
