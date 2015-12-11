// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.a.e;
import android.support.v4.view.a.h;
import android.support.v4.view.ap;
import android.support.v4.view.n;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

// Referenced classes of package android.support.v4.widget:
//            DrawerLayout

final class a extends android.support.v4.view.a
{

    final DrawerLayout b;
    private final Rect c = new Rect();

    a(DrawerLayout drawerlayout)
    {
        b = drawerlayout;
        super();
    }

    public final void a(View view, e e1)
    {
        if (DrawerLayout.c())
        {
            super.a(view, e1);
        } else
        {
            e e2 = e.a(e1);
            super.a(view, e2);
            e.a.c(e1.b, view);
            Object obj = ap.i(view);
            if (obj instanceof View)
            {
                e1.a((View)obj);
            }
            obj = c;
            e2.a(((Rect) (obj)));
            e.a.c(e1.b, ((Rect) (obj)));
            e2.b(((Rect) (obj)));
            e.a.d(e1.b, ((Rect) (obj)));
            boolean flag = e.a.r(e2.b);
            e.a.h(e1.b, flag);
            obj = e2.h();
            e.a.c(e1.b, ((CharSequence) (obj)));
            e1.a(e2.i());
            obj = e2.j();
            e.a.b(e1.b, ((CharSequence) (obj)));
            flag = e2.g();
            e.a.b(e1.b, flag);
            flag = e2.e();
            e.a.a(e1.b, flag);
            flag = e2.b();
            e.a.c(e1.b, flag);
            flag = e2.c();
            e.a.d(e1.b, flag);
            flag = e.a.s(e2.b);
            e.a.i(e1.b, flag);
            flag = e2.d();
            e.a.g(e1.b, flag);
            flag = e2.f();
            e.a.e(e1.b, flag);
            e1.a(e2.a());
            e.a.q(e2.b);
            view = (ViewGroup)view;
            int j = view.getChildCount();
            int i = 0;
            while (i < j) 
            {
                View view1 = view.getChildAt(i);
                if (android.support.v4.widget.DrawerLayout.h(view1))
                {
                    e.a.a(e1.b, view1);
                }
                i++;
            }
        }
        e1.a(android/support/v4/widget/DrawerLayout.getName());
    }

    public final boolean a(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        if (DrawerLayout.c() || android.support.v4.widget.DrawerLayout.h(view))
        {
            return super.a(viewgroup, view, accessibilityevent);
        } else
        {
            return false;
        }
    }

    public final boolean b(View view, AccessibilityEvent accessibilityevent)
    {
        if (accessibilityevent.getEventType() == 32)
        {
            accessibilityevent = accessibilityevent.getText();
            view = DrawerLayout.a(b);
            if (view != null)
            {
                int i = b.c(view);
                view = b;
                i = n.a(i, ap.h(view));
                if (i == 3)
                {
                    view = ((DrawerLayout) (view)).f;
                } else
                if (i == 5)
                {
                    view = ((DrawerLayout) (view)).g;
                } else
                {
                    view = null;
                }
                if (view != null)
                {
                    accessibilityevent.add(view);
                }
            }
            return true;
        } else
        {
            return super.b(view, accessibilityevent);
        }
    }

    public final void d(View view, AccessibilityEvent accessibilityevent)
    {
        super.d(view, accessibilityevent);
        accessibilityevent.setClassName(android/support/v4/widget/DrawerLayout.getName());
    }
}
