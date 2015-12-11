// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.a.aa;
import android.support.v4.view.a.f;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.support.v4.view:
//            a, ViewPager, bb

final class cm extends a
{

    private ViewPager a;

    cm(ViewPager viewpager)
    {
        a = viewpager;
        super();
    }

    private boolean a()
    {
        return ViewPager.a(a) != null && ViewPager.a(a).b() > 1;
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(view, accessibilityevent);
        accessibilityevent.setClassName(android/support/v4/view/ViewPager.getName());
        view = aa.a();
        view.a(a());
        if (accessibilityevent.getEventType() == 4096 && ViewPager.a(a) != null)
        {
            view.a(ViewPager.a(a).b());
            view.b(ViewPager.b(a));
            view.c(ViewPager.b(a));
        }
    }

    public final void onInitializeAccessibilityNodeInfo(View view, f f1)
    {
        super.onInitializeAccessibilityNodeInfo(view, f1);
        f1.b(android/support/v4/view/ViewPager.getName());
        f1.i(a());
        if (a.canScrollHorizontally(1))
        {
            f1.a(4096);
        }
        if (a.canScrollHorizontally(-1))
        {
            f1.a(8192);
        }
    }

    public final boolean performAccessibilityAction(View view, int i, Bundle bundle)
    {
        if (super.performAccessibilityAction(view, i, bundle))
        {
            return true;
        }
        switch (i)
        {
        default:
            return false;

        case 4096: 
            if (a.canScrollHorizontally(1))
            {
                a.setCurrentItem(ViewPager.b(a) + 1);
                return true;
            } else
            {
                return false;
            }

        case 8192: 
            break;
        }
        if (a.canScrollHorizontally(-1))
        {
            a.setCurrentItem(ViewPager.b(a) - 1);
            return true;
        } else
        {
            return false;
        }
    }
}
