// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v7.internal.view.menu.f;
import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            a

private final class b
    implements Runnable
{

    final a a;
    private a b;

    public final void run()
    {
        Object obj = a.c;
        if (((f) (obj)).b != null)
        {
            ((f) (obj)).b.a(((f) (obj)));
        }
        obj = (View)a.g;
        if (obj != null && ((View) (obj)).getWindowToken() != null && b.b())
        {
            a.m = b;
        }
        a.o = null;
    }

    public ew.menu.f.a(a a1, ew.menu.f.a a2)
    {
        a = a1;
        super();
        b = a2;
    }
}
