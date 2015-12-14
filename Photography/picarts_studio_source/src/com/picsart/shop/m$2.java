// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.app.ProgressDialog;
import com.socialin.android.util.Utils;
import myobfuscated.cp.c;

// Referenced classes of package com.picsart.shop:
//            m

final class t>
    implements c
{

    private ProgressDialog a;
    private String b;
    private m c;

    public final void a()
    {
        try
        {
            a.dismiss();
        }
        catch (Exception exception) { }
        if (com.picsart.shop.m.c(c).data.price > 0 && !com.picsart.shop.m.c(c).owned && b != null && b.length() > 0)
        {
            Utils.c(c.getActivity(), b);
        }
        m.n(c);
    }

    public final void a(int i)
    {
        a.setProgress(i);
    }

    ialog(m m1, ProgressDialog progressdialog, String s)
    {
        c = m1;
        a = progressdialog;
        b = s;
        super();
    }
}
