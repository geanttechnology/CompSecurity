// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Dialog;
import com.tremorvideo.sdk.android.richmedia.ae;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ax, bb

class a
    implements a
{

    final String a;
    final ax b;

    public void a(Dialog dialog)
    {
        if (a != null && a.length() > 0)
        {
            String s = ae.c(a);
            bb.a(a, s).c();
        }
        dialog.dismiss();
    }

    public void b(Dialog dialog)
    {
        dialog.dismiss();
    }

    public void c(Dialog dialog)
    {
        ax.a(b, "http://www.youradchoices.com/learn.aspx");
        dialog.dismiss();
    }

    (ax ax1, String s)
    {
        b = ax1;
        a = s;
        super();
    }
}
