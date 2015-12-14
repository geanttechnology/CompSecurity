// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ListView;
import com.cyberlink.beautycircle.Globals;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            MainActivity

class b
    implements android.content.OnClickListener
{

    final int a;
    final String b[];
    final MainActivity c;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        i = ((AlertDialog)dialoginterface).getListView().getCheckedItemPosition();
        if (i != a)
        {
            Globals.a((String)Arrays.asList(b).get(i));
            MainActivity.m(c).run();
        }
    }

    (MainActivity mainactivity, int i, String as[])
    {
        c = mainactivity;
        a = i;
        b = as;
        super();
    }
}
