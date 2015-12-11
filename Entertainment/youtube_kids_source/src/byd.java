// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.ImageView;

final class byd
    implements android.view.View.OnLayoutChangeListener
{

    private final boolean a;
    private blt b;
    private byc c;

    byd(byc byc1, boolean flag)
    {
        c = byc1;
        super();
        a = flag;
    }

    static void a(byd byd1)
    {
        if (byd1.a)
        {
            byd1.c.a.removeOnLayoutChangeListener(byd1);
        }
        byd1.b = null;
    }

    static void a(byd byd1, blt blt)
    {
        byd1.b = blt;
        byd1.c.a.addOnLayoutChangeListener(byd1);
    }

    public final void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        c.a(b);
    }
}
