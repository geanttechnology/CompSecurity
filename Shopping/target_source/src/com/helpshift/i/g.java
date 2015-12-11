// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;
import java.util.HashMap;

public final class g
{

    private static HashMap a = new HashMap();
    private static Long b;
    private static Long c;
    private static HashMap d;

    public static void a(int i, ProgressDialog progressdialog, Context context)
    {
        if (progressdialog != null)
        {
            progressdialog.dismiss();
        }
        if (i == 0)
        {
            progressdialog = context.getResources().getString(com.helpshift.b.g.A);
        } else
        if (i == 404)
        {
            progressdialog = context.getResources().getString(com.helpshift.b.g.B);
        } else
        if (i == 2)
        {
            progressdialog = context.getResources().getString(com.helpshift.b.g.C);
        } else
        if (i == 3)
        {
            progressdialog = context.getResources().getString(com.helpshift.b.g.P);
        } else
        if (i == 4)
        {
            progressdialog = context.getResources().getString(com.helpshift.b.g.Q);
        } else
        if (i == 5)
        {
            progressdialog = context.getResources().getString(com.helpshift.b.g.R);
        } else
        {
            progressdialog = context.getResources().getString(com.helpshift.b.g.D);
        }
        b = (Long)a.get(Integer.valueOf(i));
        if (d.containsKey(Integer.valueOf(i)))
        {
            c = (Long)d.get(Integer.valueOf(i));
        } else
        {
            c = new Long(1000L);
        }
        if (i == -1) goto _L2; else goto _L1
_L1:
        if (b != null) goto _L4; else goto _L3
_L3:
        a(context, ((CharSequence) (progressdialog)));
_L2:
        a.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
        return;
_L4:
        if (System.currentTimeMillis() - b.longValue() > c.longValue())
        {
            a(context, ((CharSequence) (progressdialog)));
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private static void a(Context context, CharSequence charsequence)
    {
        context = Toast.makeText(context, charsequence, 0);
        context.setGravity(16, 0, 0);
        context.show();
    }

    static 
    {
        d = new HashMap();
        d.put(Integer.valueOf(0), new Long(0x15f90L));
        d.put(Integer.valueOf(404), new Long(1000L));
        d.put(Integer.valueOf(1), new Long(5000L));
        d.put(Integer.valueOf(2), new Long(6000L));
    }
}
