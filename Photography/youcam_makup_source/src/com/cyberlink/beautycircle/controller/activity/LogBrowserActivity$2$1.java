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

class b
    implements android.content.Listener
{

    final AdapterView a;
    final int b;
    final b c;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (LogBrowserActivity.a(c.c) != null)
        {
            LogBrowserActivity.a(c.c).dismiss();
            LogBrowserActivity.a(c.c, null);
        }
        if (i == 0)
        {
            LogBrowserActivity.a(c.c, a, b);
        } else
        if (i == 1)
        {
            LogBrowserActivity.b(c.c, a, b);
            return;
        }
    }

    ( , AdapterView adapterview, int i)
    {
        c = ;
        a = adapterview;
        b = i;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/LogBrowserActivity$2

/* anonymous class */
    class LogBrowserActivity._cls2
        implements android.widget.AdapterView.OnItemClickListener
    {

        final LogBrowserActivity a;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            view = new android.app.AlertDialog.Builder(a);
            String s = a.getResources().getString(m.bc_log_browser_dialog_email);
            String s1 = a.getResources().getString(m.bc_log_browser_dialog_local_browser);
            view.setTitle(m.bc_log_browser_dialog_title);
            adapterview = new LogBrowserActivity._cls2._cls1(this, adapterview, i);
            view.setSingleChoiceItems(new String[] {
                s, s1
            }, -1, adapterview);
            LogBrowserActivity.a(a, view.show());
            Globals.a(LogBrowserActivity.a(a), a.getResources().getColor(g.bc_color_main_style));
        }

            
            {
                a = logbrowseractivity;
                super();
            }
    }

}
