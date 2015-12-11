// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.support.v7.internal.view.menu.f;
import android.support.v7.internal.view.menu.k;
import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            a

private final class ew.menu.k.d extends k
{

    final a g;

    public final void onDismiss()
    {
        super.onDismiss();
        g.c.close();
        g.m = null;
    }

    public ew.menu.f(a a1, Context context, f f1, View view)
    {
        g = a1;
        super(context, f1, view, true, android.support.v7.b.actionOverflowMenuStyle);
        super.f = 0x800005;
        super.d = a1.p;
    }
}
