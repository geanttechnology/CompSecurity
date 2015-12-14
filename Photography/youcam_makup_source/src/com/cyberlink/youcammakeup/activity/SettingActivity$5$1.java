// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.setting.PhotoQuality;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SettingActivity

class a
    implements android.content.ickListener
{

    final PhotoQuality a[];
    final a b;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (a(b) != null)
        {
            b(b).dismiss();
            b(b, null);
        }
        if (SettingActivity.a(b.b) == a[i])
        {
            return;
        }
        dialoginterface = Globals.d().e();
        if (a[i] == PhotoQuality.a && (z.n() || dialoginterface.intValue() <= 0x16e360))
        {
            SettingActivity.b(b.b, a[i]);
            return;
        } else
        {
            SettingActivity.c(b.b, a[i]);
            return;
        }
    }

    ( , PhotoQuality aphotoquality[])
    {
        b = ;
        a = aphotoquality;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/activity/SettingActivity$5

/* anonymous class */
    class SettingActivity._cls5
        implements android.view.View.OnClickListener
    {

        final SettingActivity a;
        private Dialog b;

        static Dialog a(SettingActivity._cls5 _pcls5)
        {
            return _pcls5.b;
        }

        static Dialog a(SettingActivity._cls5 _pcls5, Dialog dialog)
        {
            _pcls5.b = dialog;
            return dialog;
        }

        public void onClick(View view)
        {
            int i = 0;
            if (b != null)
            {
                b.dismiss();
                b = null;
            }
            ArrayList arraylist = new ArrayList();
            view = PhotoQuality.e();
            int j = 0;
            for (; i < view.length; i++)
            {
                PhotoQuality photoquality = view[i];
                if (SettingActivity.a(a) == photoquality)
                {
                    j = i;
                }
                arraylist.add(SettingActivity.a(a, photoquality));
            }

            String as[] = (String[])arraylist.toArray(new String[arraylist.size()]);
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(a, 0x7f0a022f);
            builder.setTitle(0x7f07064c);
            builder.setSingleChoiceItems(as, j, new SettingActivity._cls5._cls1(this, view));
            b = builder.show();
            SettingActivity.a(b, Color.parseColor("#A186C4"));
        }

            
            {
                a = settingactivity;
                super();
                b = null;
            }
    }

}
