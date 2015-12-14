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

class b
    implements android.view.er
{

    final SettingActivity a;
    private Dialog b;

    static Dialog a(b b1)
    {
        return b1.b;
    }

    static Dialog a(b b1, Dialog dialog)
    {
        b1.b = dialog;
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
        android.app.r r = new android.app.r(a, 0x7f0a022f);
        r.setTitle(0x7f07064c);
        r.setSingleChoiceItems(as, j, new android.content.DialogInterface.OnClickListener(view) {

            final PhotoQuality a[];
            final SettingActivity._cls5 b;

            public void onClick(DialogInterface dialoginterface, int k)
            {
                if (SettingActivity._cls5.a(b) != null)
                {
                    SettingActivity._cls5.a(b).dismiss();
                    SettingActivity._cls5.a(b, null);
                }
                if (SettingActivity.a(b.a) == a[k])
                {
                    return;
                }
                dialoginterface = Globals.d().e();
                if (a[k] == PhotoQuality.a && (z.n() || dialoginterface.intValue() <= 0x16e360))
                {
                    SettingActivity.b(b.a, a[k]);
                    return;
                } else
                {
                    SettingActivity.c(b.a, a[k]);
                    return;
                }
            }

            
            {
                b = SettingActivity._cls5.this;
                a = aphotoquality;
                super();
            }
        });
        b = r.show();
        SettingActivity.a(b, Color.parseColor("#A186C4"));
    }

    _cls1.a(SettingActivity settingactivity)
    {
        a = settingactivity;
        super();
        b = null;
    }
}
