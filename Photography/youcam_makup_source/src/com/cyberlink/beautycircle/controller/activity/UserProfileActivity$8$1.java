// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;
import android.widget.ListView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.i;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            UserProfileActivity

class b
    implements android.content.istener
{

    final int a;
    final String b[];
    final c c;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        i = ((AlertDialog)dialoginterface).getListView().getCheckedItemPosition();
        if (i != a)
        {
            Globals.a((String)Arrays.asList(b).get(i));
            UserProfileActivity.d(c.c).run();
        }
    }

    ( , int i, String as[])
    {
        c = ;
        a = i;
        b = as;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/UserProfileActivity$8

/* anonymous class */
    class UserProfileActivity._cls8
        implements android.view.View.OnClickListener
    {

        final UserProfileActivity a;

        public void onClick(View view)
        {
            view = i.a();
            String s = Globals.c();
            int j = Arrays.asList(view).indexOf(s);
            view = (new android.app.AlertDialog.Builder(a)).setTitle("Change Server and Logout").setSingleChoiceItems(view, j, null).setPositiveButton(m.bc_dialog_button_yes, new UserProfileActivity._cls8._cls1(this, j, view)).setNegativeButton(m.bc_dialog_button_no, null).create();
            view.show();
            Globals.a(view, a.getResources().getColor(g.bc_color_main_style));
        }

            
            {
                a = userprofileactivity;
                super();
            }
    }

}
