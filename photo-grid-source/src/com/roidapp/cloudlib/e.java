// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.roidapp.cloudlib;

import android.content.DialogInterface;
import com.roidapp.cloudlib.facebook.al;

// Referenced classes of package com.roidapp.cloudlib:
//            d, AccountMgrActivity

final class e
    implements android.content.DialogInterface.OnClickListener
{

    final d a;

    e(d d1)
    {
        a = d1;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        al.a(a.b);
        AccountMgrActivity.c(a.b);
    }
}
