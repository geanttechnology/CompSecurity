// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.b;

import android.app.Dialog;
import android.view.View;
import com.tencent.tauth.b;

// Referenced classes of package com.tencent.connect.b:
//            c, b

class nit> extends c
{

    final b a;
    final Object b;
    final com.tencent.connect.b.b c;

    public void onClick(View view)
    {
        c.b();
        if (d != null && d.isShowing())
        {
            d.dismiss();
        }
        if (a != null)
        {
            a.a(b);
        }
    }

    (com.tencent.connect.b.b b1, Dialog dialog, b b2, Object obj)
    {
        c = b1;
        a = b2;
        b = obj;
        super(b1, dialog);
    }
}
