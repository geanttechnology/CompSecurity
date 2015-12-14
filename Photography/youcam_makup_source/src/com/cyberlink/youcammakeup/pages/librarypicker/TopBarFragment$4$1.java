// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YCPInstallTrackEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.flurry.LauncherGotoEvent;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.kernelctrl.Camera;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.al;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.dialogs.h;
import com.cyberlink.youcammakeup.widgetpool.dialogs.i;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker:
//            TopBarFragment

class a
    implements i
{

    final Activity a;
    final eption b;

    public void a(boolean flag)
    {
        if (flag)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        Camera.a().a(a);
        return;
        com.cyberlink.youcammakeup.kernelctrl.FolderException folderexception;
        folderexception;
        com.cyberlink.youcammakeup.pages.librarypicker.a(b, a, folderexception);
        return;
    }

    eption(eption eption, Activity activity)
    {
        b = eption;
        a = activity;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/pages/librarypicker/TopBarFragment$4

/* anonymous class */
    class TopBarFragment._cls4
        implements android.view.View.OnClickListener
    {

        final TopBarFragment a;
        private Toast b;

        private void a(Activity activity, com.cyberlink.youcammakeup.kernelctrl.Camera.CannotCreateFolderException cannotcreatefolderexception)
        {
            m.e("pages.librarypicker.TopBarFragment", cannotcreatefolderexception.toString());
            if (b != null)
            {
                b.cancel();
                b = null;
            }
            b = Toast.makeText(activity, 0x7f0704ea, 0);
            b.show();
        }

        static void a(TopBarFragment._cls4 _pcls4, Activity activity, com.cyberlink.youcammakeup.kernelctrl.Camera.CannotCreateFolderException cannotcreatefolderexception)
        {
            _pcls4.a(activity, cannotcreatefolderexception);
        }

        public void onClick(View view)
        {
            boolean flag = false;
            view = a.getActivity();
            if (view == null)
            {
                return;
            }
            com.cyberlink.youcammakeup.flurry.a.a(new LauncherGotoEvent(com.cyberlink.youcammakeup.flurry.LauncherGotoEvent.DestName.a));
            Globals.d().a(false);
            if (!al.a(view.getPackageManager()))
            {
                int j = z.b();
                if (j % 3 == 0)
                {
                    if (z.g().isEmpty())
                    {
                        z.a(com.cyberlink.youcammakeup.clflurry.YCPInstallTrackEvent.STATUS.a);
                        com.cyberlink.youcammakeup.clflurry.b.a(new YCPInstallTrackEvent(com.cyberlink.youcammakeup.clflurry.YCPInstallTrackEvent.STATUS.a));
                    }
                    h h1 = new h();
                    h1.a(new TopBarFragment._cls4._cls1(this, view));
                    o.a(view, h1, "DownloadYouPerfectDialog");
                    j = ((flag) ? 1 : 0);
                } else
                {
                    try
                    {
                        Camera.a().a(view);
                    }
                    catch (com.cyberlink.youcammakeup.kernelctrl.Camera.CannotCreateFolderException cannotcreatefolderexception)
                    {
                        a(view, cannotcreatefolderexception);
                    }
                }
                z.a(j + 1);
                return;
            }
            try
            {
                Camera.a().a(view);
                return;
            }
            catch (com.cyberlink.youcammakeup.kernelctrl.Camera.CannotCreateFolderException cannotcreatefolderexception1)
            {
                a(view, cannotcreatefolderexception1);
            }
        }

            
            {
                a = topbarfragment;
                super();
            }
    }

}
