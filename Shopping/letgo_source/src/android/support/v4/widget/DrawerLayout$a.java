// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.a;
import android.support.v4.view.ah;
import android.support.v7.be;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

// Referenced classes of package android.support.v4.widget:
//            DrawerLayout

class a extends a
{

    final DrawerLayout a;
    private final Rect b = new Rect();

    private void a(be be1, be be2)
    {
        Rect rect = b;
        be2.a(rect);
        be1.b(rect);
        be2.c(rect);
        be1.d(rect);
        be1.c(be2.g());
        be1.a(be2.o());
        be1.b(be2.p());
        be1.c(be2.r());
        be1.h(be2.l());
        be1.f(be2.j());
        be1.a(be2.e());
        be1.b(be2.f());
        be1.d(be2.h());
        be1.e(be2.i());
        be1.g(be2.k());
        be1.a(be2.b());
    }

    private void a(be be1, ViewGroup viewgroup)
    {
        int j = viewgroup.getChildCount();
        for (int i = 0; i < j; i++)
        {
            View view = viewgroup.getChildAt(i);
            if (DrawerLayout.l(view))
            {
                be1.b(view);
            }
        }

    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        if (accessibilityevent.getEventType() == 32)
        {
            view = accessibilityevent.getText();
            accessibilityevent = android.support.v4.widget.DrawerLayout.a(a);
            if (accessibilityevent != null)
            {
                int i = a.e(accessibilityevent);
                accessibilityevent = a.a(i);
                if (accessibilityevent != null)
                {
                    view.add(accessibilityevent);
                }
            }
            return true;
        } else
        {
            return super.dispatchPopulateAccessibilityEvent(view, accessibilityevent);
        }
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(view, accessibilityevent);
        accessibilityevent.setClassName(android/support/v4/widget/DrawerLayout.getName());
    }

    public void onInitializeAccessibilityNodeInfo(View view, be be1)
    {
        if (DrawerLayout.e())
        {
            super.onInitializeAccessibilityNodeInfo(view, be1);
        } else
        {
            be be2 = be.a(be1);
            super.onInitializeAccessibilityNodeInfo(view, be2);
            be1.a(view);
            android.view.ViewParent viewparent = ah.h(view);
            if (viewparent instanceof View)
            {
                be1.c((View)viewparent);
            }
            a(be1, be2);
            be2.s();
            a(be1, (ViewGroup)view);
        }
        be1.b(android/support/v4/widget/DrawerLayout.getName());
        be1.a(false);
        be1.b(false);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        if (DrawerLayout.e() || DrawerLayout.l(view))
        {
            return super.onRequestSendAccessibilityEvent(viewgroup, view, accessibilityevent);
        } else
        {
            return false;
        }
    }

    vent(DrawerLayout drawerlayout)
    {
        a = drawerlayout;
        super();
    }
}
