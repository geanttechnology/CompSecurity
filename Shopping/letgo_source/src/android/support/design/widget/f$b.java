// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.support.v4.view.ah;
import android.support.v4.widget.u;
import android.view.View;

// Referenced classes of package android.support.design.widget:
//            f

private class c
    implements Runnable
{

    final f a;
    private final View b;
    private final boolean c;

    public void run()
    {
        if (f.b(a) != null && f.b(a).a(true))
        {
            ah.a(b, this);
        } else
        if (c && f.a(a) != null)
        {
            f.a(a).a(b);
            return;
        }
    }

    (f f1, View view, boolean flag)
    {
        a = f1;
        super();
        b = view;
        c = flag;
    }
}
