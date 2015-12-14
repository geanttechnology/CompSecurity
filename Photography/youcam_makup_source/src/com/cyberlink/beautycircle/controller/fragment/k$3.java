// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;
import android.widget.ListView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            k

class a
    implements android.view..OnClickListener
{

    final k a;

    public void onClick(View view)
    {
        int i = 1;
        if (!Globals.d())
        {
            i = 0;
        }
        view = (new android.app.tDialog.Builder(a.getActivity())).setTitle("Set Dominant Color Mode").setSingleChoiceItems(new String[] {
            "Normal", "Dominant Color"
        }, i, null).setPositiveButton(m.bc_dialog_button_yes, new android.content.DialogInterface.OnClickListener() {

            final k._cls3 a;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                dialoginterface.dismiss();
                boolean flag;
                if (((AlertDialog)dialoginterface).getListView().getCheckedItemPosition() == 0)
                {
                    flag = false;
                } else
                {
                    flag = true;
                }
                Globals.b(flag);
            }

            
            {
                a = k._cls3.this;
                super();
            }
        }).setNegativeButton(m.bc_dialog_button_no, null).create();
        view.show();
        Globals.a(view, a.getResources().getColor(g.bc_color_main_style));
    }

    _cls1.a(k k1)
    {
        a = k1;
        super();
    }
}
