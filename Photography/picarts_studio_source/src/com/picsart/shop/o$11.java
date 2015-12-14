// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.app.ProgressDialog;
import myobfuscated.cp.c;

// Referenced classes of package com.picsart.shop:
//            o

final class >
    implements c
{

    private ProgressDialog a;
    private o b;

    public final void a()
    {
        try
        {
            a.dismiss();
            b.a();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public final void a(int i)
    {
        a.setProgress(i);
    }

    alog(o o1, ProgressDialog progressdialog)
    {
        b = o1;
        a = progressdialog;
        super();
    }
}
