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
import com.perfectcorp.utility.e;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            FreeSampleFillDataActivity

class c
    implements android.content.reeSampleFillDataActivity._cls10._cls1
{

    final String a[];
    final ArrayList b;
    final String c;
    final d d;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (dialoginterface != null)
        {
            dialoginterface.dismiss();
        }
        if (FreeSampleFillDataActivity.l(d.d) == dialoginterface)
        {
            FreeSampleFillDataActivity.a(d.d, null);
        }
        String s = a[i];
        dialoginterface = (com.cyberlink.beautycircle.model.Activity._cls10._cls1.a)b.get(i);
        if (dialoginterface != null)
        {
            dialoginterface = ((com.cyberlink.beautycircle.model.Activity._cls10._cls1.b) (dialoginterface)).b;
        } else
        {
            dialoginterface = null;
        }
        if (!c.equals(s))
        {
            FreeSampleFillDataActivity.i(d.d).setText(s);
            FreeSampleFillDataActivity.j(d.d).setText(dialoginterface);
        }
    }

    ( , String as[], ArrayList arraylist, String s)
    {
        d = ;
        a = as;
        b = arraylist;
        c = s;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/FreeSampleFillDataActivity$10

/* anonymous class */
    class FreeSampleFillDataActivity._cls10
        implements android.view.View.OnClickListener
    {

        final FreeSampleFillDataActivity a;

        public void onClick(View view)
        {
            String s;
            boolean flag;
            flag = false;
            a.i();
            if (a.f == null || a.f.stores == null)
            {
                return;
            }
            s = FreeSampleFillDataActivity.h(a).getText().toString();
            view = a.f.stores.iterator();
_L4:
            if (!view.hasNext()) goto _L2; else goto _L1
_L1:
            com.cyberlink.beautycircle.model.Event.CityStoreInfo citystoreinfo = (com.cyberlink.beautycircle.model.Event.CityStoreInfo)view.next();
            if (!s.equals(citystoreinfo.city)) goto _L4; else goto _L3
_L3:
            view = citystoreinfo.stores;
_L6:
            if (view == null)
            {
                e.e(new Object[] {
                    "Invalid city: ", s
                });
                return;
            }
            String as[] = new String[view.size()];
            String s1 = FreeSampleFillDataActivity.i(a).getText().toString();
            Object obj = view.iterator();
            int i = 0;
            int j = -1;
            while (((Iterator) (obj)).hasNext()) 
            {
                com.cyberlink.beautycircle.model.Event.StoreInfo storeinfo = (com.cyberlink.beautycircle.model.Event.StoreInfo)((Iterator) (obj)).next();
                if (storeinfo == null)
                {
                    as[i] = "";
                } else
                {
                    as[i] = storeinfo.name;
                    if (!flag && s1.equals(storeinfo.name))
                    {
                        flag = true;
                        j = i;
                    }
                    i++;
                }
            }
            obj = new android.app.AlertDialog.Builder(a);
            ((android.app.AlertDialog.Builder) (obj)).setTitle(m.bc_freesample_select_store_hint);
            ((android.app.AlertDialog.Builder) (obj)).setSingleChoiceItems(as, j, new FreeSampleFillDataActivity._cls10._cls1(this, as, view, s1));
            if (FreeSampleFillDataActivity.l(a) != null)
            {
                FreeSampleFillDataActivity.l(a).dismiss();
            }
            FreeSampleFillDataActivity.a(a, ((android.app.AlertDialog.Builder) (obj)).show());
            Globals.a(FreeSampleFillDataActivity.l(a), a.getResources().getColor(g.bc_color_main_style));
            return;
_L2:
            view = null;
            if (true) goto _L6; else goto _L5
_L5:
        }

            
            {
                a = freesamplefilldataactivity;
                super();
            }
    }

}
