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

class a
    implements android.content.ickListener
{

    final a a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (a(a) != null)
        {
            a(a).dismiss();
            a(a, null);
        }
        if (SettingActivity.b(a.a).equals(SettingActivity.j()[i]))
        {
            return;
        }
        if (i == 1)
        {
            if (android.os.T >= 19)
            {
                if (android.os.T > 19 && Exporter.d())
                {
                    SettingActivity.a(a.a, SettingActivity.j()[i]);
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
        SettingActivity.b(a.a, SettingActivity.j()[i]);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/activity/SettingActivity$6

/* anonymous class */
    class SettingActivity._cls6
        implements android.view.View.OnClickListener
    {

        final SettingActivity a;
        private Dialog b;

        static Dialog a(SettingActivity._cls6 _pcls6)
        {
            return _pcls6.b;
        }

        static Dialog a(SettingActivity._cls6 _pcls6, Dialog dialog)
        {
            _pcls6.b = dialog;
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
            obj = new android.app.AlertDialog.Builder(a, 0x7f0a022f);
            ((android.app.AlertDialog.Builder) (obj)).setTitle(0x7f070650);
            ((android.app.AlertDialog.Builder) (obj)).setSingleChoiceItems(view, i, new SettingActivity._cls6._cls1(this));
            b = ((android.app.AlertDialog.Builder) (obj)).show();
            SettingActivity.a(b, Color.parseColor("#A186C4"));
        }

            
            {
                a = settingactivity;
                super();
                b = null;
            }
    }

}
