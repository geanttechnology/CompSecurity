// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import android.widget.Toast;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YCPInstallTrackEvent;
import com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.f;
import com.cyberlink.youcammakeup.flurry.LauncherGotoEvent;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.kernelctrl.Camera;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.al;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.dialogs.h;
import com.cyberlink.youcammakeup.widgetpool.dialogs.i;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SponsorAdActivity

class a
    implements i
{

    final a a;

    public void a(boolean flag)
    {
        if (!flag)
        {
            try
            {
                Camera.a().a(a.a);
            }
            catch (com.cyberlink.youcammakeup.kernelctrl.derException derexception)
            {
                com.cyberlink.youcammakeup.activity.a(a, derexception);
            }
        }
        com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a.a, true);
    }

    olderException(olderException olderexception)
    {
        a = olderexception;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/activity/SponsorAdActivity$9

/* anonymous class */
    class SponsorAdActivity._cls9
        implements android.view.View.OnClickListener
    {

        final SponsorAdActivity a;
        private Toast b;

        static void a(SponsorAdActivity._cls9 _pcls9, com.cyberlink.youcammakeup.kernelctrl.Camera.CannotCreateFolderException cannotcreatefolderexception)
        {
            _pcls9.a(cannotcreatefolderexception);
        }

        private void a(com.cyberlink.youcammakeup.kernelctrl.Camera.CannotCreateFolderException cannotcreatefolderexception)
        {
            m.e("SponsorAdActivity", cannotcreatefolderexception.toString());
            if (b != null)
            {
                b.cancel();
                b = null;
            }
            b = Toast.makeText(a.getApplicationContext(), 0x7f0704ea, 0);
            b.show();
            com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a, true);
        }

        public void onClick(View view)
        {
            boolean flag = false;
            if (!view.isClickable() || !view.isEnabled() || com.cyberlink.youcammakeup.activity.SponsorAdActivity.h(a).getVisibility() != 0)
            {
                return;
            }
            if (com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a) != null)
            {
                view = com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a).type;
                String s = com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a).skuGuid;
                String s1 = com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a).itemGuid;
                com.cyberlink.youcammakeup.clflurry.b.a(new f(view, s, s1));
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKClicksADFromLauncherBannerEvent(s, s1, com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ButtonName.e));
            }
            com.cyberlink.youcammakeup.flurry.a.a(new LauncherGotoEvent(com.cyberlink.youcammakeup.flurry.LauncherGotoEvent.DestName.a));
            com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a, false);
            Globals.d().a(false);
            if (!al.a(a.getPackageManager()))
            {
                int j = z.b();
                if (j % 3 == 0)
                {
                    if (z.g().isEmpty())
                    {
                        z.a(com.cyberlink.youcammakeup.clflurry.YCPInstallTrackEvent.STATUS.a);
                        com.cyberlink.youcammakeup.clflurry.b.a(new YCPInstallTrackEvent(com.cyberlink.youcammakeup.clflurry.YCPInstallTrackEvent.STATUS.a));
                    }
                    view = new h();
                    view.a(new SponsorAdActivity._cls9._cls1(this));
                    o.a(a, view, "DownloadYouPerfectDialog");
                    j = ((flag) ? 1 : 0);
                } else
                {
                    try
                    {
                        Camera.a().a(a);
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        a(view);
                    }
                }
                z.a(j + 1);
                return;
            }
            try
            {
                Camera.a().a(a);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                a(view);
            }
        }

            
            {
                a = sponsoradactivity;
                super();
            }
    }

}
