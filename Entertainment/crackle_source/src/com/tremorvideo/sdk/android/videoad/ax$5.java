// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Dialog;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ax, n

class a
    implements a
{

    final String a;
    final ax b;

    public void a(Dialog dialog)
    {
        dialog.dismiss();
    }

    public void a(Dialog dialog, String s)
    {
        b.i = s;
        for (Iterator iterator = b.k.iterator(); iterator.hasNext(); ((b)iterator.next()).f(s)) { }
        if (a != null)
        {
            s = b.a.().c(a);
            if (s != null)
            {
                b.a(s);
                b.b(s);
            }
        }
        dialog.dismiss();
    }

    (ax ax1, String s)
    {
        b = ax1;
        a = s;
        super();
    }
}
