// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;

// Referenced classes of package com.millennialmedia.android:
//            e, OverlaySettings, al, ab, 
//            f, z, ap

final class <init> extends 
{

    final e a;

    final void a()
    {
        e.a(a);
    }

    final boolean b()
    {
        if (a.b.b())
        {
            OverlaySettings overlaysettings = a.b;
            boolean flag;
            if (!overlaysettings.p)
            {
                overlaysettings.p = true;
                flag = false;
            } else
            {
                flag = true;
            }
            if (!flag)
            {
                return true;
            }
        }
        return false;
    }

    final ap c()
    {
        (new StringBuilder("Returning a client for user: OverlayWebViewClient, adimpl=")).append(a.h);
        al.b();
        if (a.h.o != 0L || a.b.b())
        {
            f f1 = new f(n, new <init>(this));
            m = f1;
            return f1;
        } else
        {
            z z1 = new z(n, new <init>(this));
            m = z1;
            return z1;
        }
    }

    public laySettings(e e1, Context context)
    {
        a = e1;
        super(e1, context);
        n = new <init>(this);
    }
}
