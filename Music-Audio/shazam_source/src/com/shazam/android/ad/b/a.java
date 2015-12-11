// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ad.b;

import android.support.v4.app.Fragment;
import android.support.v4.view.t;
import com.shazam.android.a.c;

// Referenced classes of package com.shazam.android.ad.b:
//            b

public final class a
    implements com.shazam.android.widget.page.a
{

    public a()
    {
    }

    private static Fragment c(int i, t t)
    {
        if (t instanceof c)
        {
            return ((c)t).c(i);
        } else
        {
            return null;
        }
    }

    public final void a(int i, t t)
    {
        t = c(i, t);
        if (t instanceof b)
        {
            ((b)t).onSelected();
        }
    }

    public final void b(int i, t t)
    {
        t = c(i, t);
        if (t instanceof b)
        {
            ((b)t).onUnselected();
        }
    }
}
