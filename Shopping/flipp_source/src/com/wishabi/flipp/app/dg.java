// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.view.KeyEvent;

// Referenced classes of package com.wishabi.flipp.app:
//            df

final class dg
    implements android.content.DialogInterface.OnKeyListener
{

    final df a;

    dg(df df1)
    {
        a = df1;
        super();
    }

    public final boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        if (keyevent.getKeyCode() == 4 && keyevent.getAction() == 1)
        {
            if (!a.getChildFragmentManager().popBackStackImmediate())
            {
                a.getDialog().dismiss();
            }
            return true;
        } else
        {
            return false;
        }
    }
}
