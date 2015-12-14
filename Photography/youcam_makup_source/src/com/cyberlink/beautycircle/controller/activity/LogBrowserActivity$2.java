// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            LogBrowserActivity

class a
    implements android.widget.ckListener
{

    final LogBrowserActivity a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        view = new android.app.init>(a);
        String s = a.getResources().getString(m.bc_log_browser_dialog_email);
        String s1 = a.getResources().getString(m.bc_log_browser_dialog_local_browser);
        view.etTitle(m.bc_log_browser_dialog_title);
        adapterview = new android.content.DialogInterface.OnClickListener(adapterview, i) {

            final AdapterView a;
            final int b;
            final LogBrowserActivity._cls2 c;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                if (LogBrowserActivity.a(c.a) != null)
                {
                    LogBrowserActivity.a(c.a).dismiss();
                    LogBrowserActivity.a(c.a, null);
                }
                if (j == 0)
                {
                    LogBrowserActivity.a(c.a, a, b);
                } else
                if (j == 1)
                {
                    LogBrowserActivity.b(c.a, a, b);
                    return;
                }
            }

            
            {
                c = LogBrowserActivity._cls2.this;
                a = adapterview;
                b = i;
                super();
            }
        };
        view.etSingleChoiceItems(new String[] {
            s, s1
        }, -1, adapterview);
        LogBrowserActivity.a(a, view.how());
        Globals.a(LogBrowserActivity.a(a), a.getResources().getColor(g.bc_color_main_style));
    }

    _cls1.b(LogBrowserActivity logbrowseractivity)
    {
        a = logbrowseractivity;
        super();
    }
}
