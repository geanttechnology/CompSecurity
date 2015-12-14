// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import android.widget.ArrayAdapter;
import com.cyberlink.youcammakeup.masteraccess.Exporter;

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
        boolean flag = false;
        if (b != null)
        {
            b.dismiss();
            b = null;
        }
        Object obj;
        int i;
        if (SettingActivity.b(a).equalsIgnoreCase("Local"))
        {
            i = 0;
        } else
        {
            i = 1;
        }
        view = a.getString(0x7f07064a);
        obj = a.getString(0x7f07064b);
        if (!Exporter.d())
        {
            i = ((flag) ? 1 : 0);
        }
        view = new ArrayAdapter(a.getApplicationContext(), 0x7f030191, new String[] {
            view, obj
        });
        obj = new android.app.r(a, 0x7f0a022f);
        ((android.app.r) (obj)).setTitle(0x7f070650);
        ((android.app.r) (obj)).setSingleChoiceItems(view, i, new android.content.DialogInterface.OnClickListener() {

            final SettingActivity._cls6 a;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                if (SettingActivity._cls6.a(a) != null)
                {
                    SettingActivity._cls6.a(a).dismiss();
                    SettingActivity._cls6.a(a, null);
                }
                if (SettingActivity.b(a.a).equals(SettingActivity.j()[j]))
                {
                    return;
                }
                if (j == 1)
                {
                    if (android.os.Build.VERSION.SDK_INT >= 19)
                    {
                        if (android.os.Build.VERSION.SDK_INT > 19 && Exporter.d())
                        {
                            SettingActivity.a(a.a, SettingActivity.j()[j]);
                            return;
                        } else
                        {
                            SettingActivity.a(a.a, 0x7f07066a);
                            return;
                        }
                    }
                    if (!Exporter.d())
                    {
                        SettingActivity.a(a.a, 0x7f07066b);
                        return;
                    }
                }
                SettingActivity.b(a.a, SettingActivity.j()[j]);
            }

            
            {
                a = SettingActivity._cls6.this;
                super();
            }
        });
        b = ((android.app.r) (obj)).show();
        SettingActivity.a(b, Color.parseColor("#A186C4"));
    }

    _cls1.a(SettingActivity settingactivity)
    {
        a = settingactivity;
        super();
        b = null;
    }
}
