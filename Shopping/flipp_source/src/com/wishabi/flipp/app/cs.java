// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.EditText;
import com.wishabi.flipp.b.ag;

// Referenced classes of package com.wishabi.flipp.app:
//            cr, cn, ct

final class cs extends ag
{

    final cr a;

    cs(cr cr1, Context context)
    {
        a = cr1;
        super(context);
    }

    protected final void a(String s)
    {
        if (s != null && s.length() >= 5)
        {
            cn.e(a.a).setText(s);
        } else
        {
            s = a.a.getActivity();
            if (s != null)
            {
                (new android.app.AlertDialog.Builder(s)).setMessage(0x7f0e00c0).setNeutralButton(0x104000a, new ct(this)).create().show();
                return;
            }
        }
    }
}
