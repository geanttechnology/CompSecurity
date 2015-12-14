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
    implements android.view.ner
{

    final TopBarFragment a;
    private Toast b;

    private void a(Activity activity, com.cyberlink.youcammakeup.kernelctrl.teFolderException tefolderexception)
    {
        m.e("pages.librarypicker.TopBarFragment", tefolderexception.toString());
        if (b != null)
        {
            b.cancel();
            b = null;
        }
        b = Toast.makeText(activity, 0x7f0704ea, 0);
        b.show();
    }

    static void a(xception xception, Activity activity, com.cyberlink.youcammakeup.kernelctrl.teFolderException tefolderexception)
    {
        xception.a(activity, tefolderexception);
    }

    public void onClick(View view)
    {
        boolean flag = false;
        view = a.getActivity();
        if (view == null)
        {
            return;
        }
        com.cyberlink.youcammakeup.flurry.a.a(new LauncherGotoEvent(com.cyberlink.youcammakeup.flurry..DestName.a));
        Globals.d().a(false);
        if (!al.a(view.getPackageManager()))
        {
            int i = z.b();
            if (i % 3 == 0)
            {
                if (z.g().isEmpty())
                {
                    z.a(com.cyberlink.youcammakeup.clflurry.ent.STATUS.a);
                    com.cyberlink.youcammakeup.clflurry.b.a(new YCPInstallTrackEvent(com.cyberlink.youcammakeup.clflurry.ent.STATUS.a));
                }
                h h1 = new h();
                h1.a(new i(view) {

                    final Activity a;
                    final TopBarFragment._cls4 b;

                    public void a(boolean flag1)
                    {
                        if (flag1)
                        {
                            break MISSING_BLOCK_LABEL_14;
                        }
                        Camera.a().a(a);
                        return;
                        com.cyberlink.youcammakeup.kernelctrl.Camera.CannotCreateFolderException cannotcreatefolderexception;
                        cannotcreatefolderexception;
                        com.cyberlink.youcammakeup.pages.librarypicker.TopBarFragment._cls4.a(b, a, cannotcreatefolderexception);
                        return;
                    }

            
            {
                b = TopBarFragment._cls4.this;
                a = activity;
                super();
            }
                });
                o.a(view, h1, "DownloadYouPerfectDialog");
                i = ((flag) ? 1 : 0);
            } else
            {
                try
                {
                    Camera.a().a(view);
                }
                catch (com.cyberlink.youcammakeup.kernelctrl.teFolderException tefolderexception)
                {
                    a(view, tefolderexception);
                }
            }
            z.a(i + 1);
            return;
        }
        try
        {
            Camera.a().a(view);
            return;
        }
        catch (com.cyberlink.youcammakeup.kernelctrl.teFolderException tefolderexception1)
        {
            a(view, tefolderexception1);
        }
    }

    _cls1.a(TopBarFragment topbarfragment)
    {
        a = topbarfragment;
        super();
    }
}
