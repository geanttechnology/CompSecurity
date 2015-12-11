// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.j.a.c.e;
import com.j.a.g.o;
import com.j.a.g.w;

// Referenced classes of package com.j.a.d:
//            e, b, ai, ac, 
//            ag

class c
    implements android.content.DialogInterface.OnClickListener
{

    final b a;

    c(b b1)
    {
        a = b1;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        i;
        JVM INSTR tableswitch 0 1: default 24
    //                   0 25
    //                   1 177;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if (com.j.a.d.e.e().k() != null)
        {
            dialoginterface = com.j.a.d.e.e().k();
            a.a.b = o.a("Experiments", dialoginterface.a(true), new ai(this, dialoginterface)).create();
            a.a.b.dismiss();
            a.a.b.show();
            a.a.a.dismiss();
            o.a(a.a.b, 80);
            return;
        }
        TextView textview;
        try
        {
            dialoginterface = Toast.makeText(com.j.a.d.e.e().p(), "No experiments found. If you have created an experiment, check your api key and internet connection.", 1);
            textview = (TextView)dialoginterface.getView().findViewById(0x102000b);
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            w.b("something dialog", dialoginterface);
            return;
        }
        if (textview == null) goto _L5; else goto _L4
_L4:
        textview.setGravity(17);
_L5:
        dialoginterface.show();
        return;
_L3:
        ag.c().j();
        com.j.a.d.e.e().a(null, null);
        ag.c().a(false);
        com.j.a.d.e.e().u();
        return;
    }
}
