// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.b;

import android.content.DialogInterface;
import android.support.v4.app.t;
import android.view.KeyEvent;

// Referenced classes of package com.offerup.android.g.b:
//            k

final class l
    implements android.content.DialogInterface.OnKeyListener
{

    private k a;

    l(k k1)
    {
        a = k1;
        super();
    }

    public final boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            a.dismissAllowingStateLoss();
            a.getActivity().finish();
            return true;
        } else
        {
            return false;
        }
    }
}
