// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Dialog;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ax, n

class b
    implements b
{

    final c a;
    final String b;
    final ax c;

    public void a(Dialog dialog)
    {
        dialog.dismiss();
    }

    public void a(Dialog dialog, String s)
    {
        c.i = s;
        a.f(s);
        if (b != null)
        {
            s = c.a.().c(b);
            if (s != null)
            {
                c.a(s);
                c.b(s);
            }
        }
        dialog.dismiss();
    }

    (ax ax1,  , String s)
    {
        c = ax1;
        a = ;
        b = s;
        super();
    }
}
