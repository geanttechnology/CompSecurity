// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.a;
import android.support.v4.view.a.f;
import android.support.v4.view.a.g;
import android.support.v4.view.bi;
import android.support.v4.view.s;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

// Referenced classes of package android.support.v4.widget:
//            DrawerLayout

final class p extends a
{

    private final Rect a = new Rect();
    private DrawerLayout b;

    p(DrawerLayout drawerlayout)
    {
        b = drawerlayout;
        super();
    }

    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        if (accessibilityevent.getEventType() == 32)
        {
            view = accessibilityevent.getText();
            accessibilityevent = android.support.v4.widget.DrawerLayout.a(b);
            if (accessibilityevent != null)
            {
                if (s.a(b.c(accessibilityevent), bi.h(b)) == 3);
                if (false)
                {
                    view.add(null);
                }
            }
            return true;
        } else
        {
            return super.dispatchPopulateAccessibilityEvent(view, accessibilityevent);
        }
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(view, accessibilityevent);
        accessibilityevent.setClassName(android/support/v4/widget/DrawerLayout.getName());
    }

    public final void onInitializeAccessibilityNodeInfo(View view, f f1)
    {
        if (DrawerLayout.d())
        {
            super.onInitializeAccessibilityNodeInfo(view, f1);
        } else
        {
            f f2 = f.a(f1);
            super.onInitializeAccessibilityNodeInfo(view, f2);
            f1.a(view);
            Object obj = bi.i(view);
            if (obj instanceof View)
            {
                f1.c((View)obj);
            }
            obj = a;
            f2.a(((Rect) (obj)));
            f1.b(((Rect) (obj)));
            f2.c(((Rect) (obj)));
            f1.d(((Rect) (obj)));
            f1.c(f2.e());
            f1.a(f2.k());
            f1.b(f2.l());
            f1.c(f2.m());
            f1.h(f2.j());
            f1.f(f2.h());
            f1.a(f2.c());
            f1.b(f2.d());
            f1.d(f2.f());
            f1.e(f2.g());
            f1.g(f2.i());
            f1.a(f2.b());
            f2.n();
            view = (ViewGroup)view;
            int j = view.getChildCount();
            int i = 0;
            while (i < j) 
            {
                View view1 = view.getChildAt(i);
                if (android.support.v4.widget.DrawerLayout.f(view1))
                {
                    f1.b(view1);
                }
                i++;
            }
        }
        f1.b(android/support/v4/widget/DrawerLayout.getName());
        f1.a(false);
        f1.b(false);
        f1.a(g.a);
        f1.a(g.b);
    }

    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        if (DrawerLayout.d() || android.support.v4.widget.DrawerLayout.f(view))
        {
            return super.onRequestSendAccessibilityEvent(viewgroup, view, accessibilityevent);
        } else
        {
            return false;
        }
    }
}
