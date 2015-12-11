// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.DialogInterface;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.flurry.android:
//            gt, ft, gk

final class bk
    implements android.content.DialogInterface.OnClickListener
{

    private gt dn;
    private int _flddo;
    private ft dp;

    bk(ft ft1, gt gt1, int i)
    {
        dp = ft1;
        dn = gt1;
        _flddo = i;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("sourceEvent", dn.jf);
        dp.a("userConfirmed", hashmap, dp.T, dp.S, dp.U, _flddo + 1);
        dialoginterface.dismiss();
        if (ft.v(dp) != null && dp.bw() == 3)
        {
            ft.v(dp).start();
        }
    }
}
