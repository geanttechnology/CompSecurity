// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.m;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            FreeSampleFillDataActivity

class b
    implements android.content.
{

    final String a[];
    final String b;
    final c c;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (dialoginterface != null)
        {
            dialoginterface.dismiss();
        }
        if (FreeSampleFillDataActivity.l(c.c) == dialoginterface)
        {
            FreeSampleFillDataActivity.a(c.c, null);
        }
        dialoginterface = a[i];
        if (!b.equals(dialoginterface))
        {
            FreeSampleFillDataActivity.h(c.c).setText(dialoginterface);
            FreeSampleFillDataActivity.i(c.c).setText("");
            FreeSampleFillDataActivity.j(c.c).setText("");
            FreeSampleFillDataActivity.i(c.c).setClickable(true);
        }
    }

    ( , String as[], String s)
    {
        c = ;
        a = as;
        b = s;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/FreeSampleFillDataActivity$8

/* anonymous class */
    class FreeSampleFillDataActivity._cls8
        implements android.view.View.OnClickListener
    {

        final FreeSampleFillDataActivity a;

        public void onClick(View view)
        {
            a.i();
            if (a.f == null || a.f.stores == null)
            {
                return;
            }
            Object obj = a.f.stores;
            view = new String[((ArrayList) (obj)).size()];
            String s = FreeSampleFillDataActivity.h(a).getText().toString();
            obj = ((ArrayList) (obj)).iterator();
            int i = 0;
            int j = -1;
            boolean flag = false;
            while (((Iterator) (obj)).hasNext()) 
            {
                com.cyberlink.beautycircle.model.Event.CityStoreInfo citystoreinfo = (com.cyberlink.beautycircle.model.Event.CityStoreInfo)((Iterator) (obj)).next();
                if (citystoreinfo == null)
                {
                    view[i] = "";
                } else
                {
                    view[i] = citystoreinfo.city;
                    if (!flag && s.equals(citystoreinfo.city))
                    {
                        flag = true;
                        j = i;
                    }
                    i++;
                }
            }
            obj = new android.app.AlertDialog.Builder(a);
            ((android.app.AlertDialog.Builder) (obj)).setTitle(m.bc_freesample_select_location_hint);
            ((android.app.AlertDialog.Builder) (obj)).setSingleChoiceItems(view, j, new FreeSampleFillDataActivity._cls8._cls1(this, view, s));
            if (FreeSampleFillDataActivity.l(a) != null)
            {
                FreeSampleFillDataActivity.l(a).dismiss();
            }
            FreeSampleFillDataActivity.a(a, ((android.app.AlertDialog.Builder) (obj)).show());
            Globals.a(FreeSampleFillDataActivity.l(a), a.getResources().getColor(g.bc_color_main_style));
        }

            
            {
                a = freesamplefilldataactivity;
                super();
            }
    }

}
