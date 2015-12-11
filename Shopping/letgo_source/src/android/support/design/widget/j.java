// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package android.support.design.widget:
//            k

class j
{
    private static interface a
    {

        public abstract void a(ViewGroup viewgroup, View view, Rect rect);
    }

    private static class b
        implements a
    {

        public void a(ViewGroup viewgroup, View view, Rect rect)
        {
            viewgroup.offsetDescendantRectToMyCoords(view, rect);
        }

        private b()
        {
        }

    }

    private static class c
        implements a
    {

        public void a(ViewGroup viewgroup, View view, Rect rect)
        {
            k.a(viewgroup, view, rect);
        }

        private c()
        {
        }

    }


    private static final a a;

    static void a(ViewGroup viewgroup, View view, Rect rect)
    {
        a.a(viewgroup, view, rect);
    }

    static void b(ViewGroup viewgroup, View view, Rect rect)
    {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        a(viewgroup, view, rect);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = new c();
        } else
        {
            a = new b();
        }
    }
}
