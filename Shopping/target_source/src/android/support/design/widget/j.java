// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

class j
{

    private static final a a;

    static void a(ViewGroup viewgroup, View view, Rect rect)
    {
    /* block-local class not found */
    class a {}

        a.a(viewgroup, view, rect);
    }

    static void b(ViewGroup viewgroup, View view, Rect rect)
    {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        a(viewgroup, view, rect);
    }

    static 
    {
    /* block-local class not found */
    class b {}

    /* block-local class not found */
    class c {}

        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = new c(null);
        } else
        {
            a = new b(null);
        }
    }
}
