// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.a.ag;
import android.support.v4.view.a.e;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.support.v4.view:
//            a, ViewPager, ae

final class cb extends a
{

    final ViewPager b;

    cb(ViewPager viewpager)
    {
        b = viewpager;
        super();
    }

    private boolean a()
    {
        return ViewPager.b(b) != null && ViewPager.b(b).c() > 1;
    }

    public final void a(View view, e e1)
    {
        super.a(view, e1);
        e1.a(android/support/v4/view/ViewPager.getName());
        e1.a(a());
        if (b.canScrollHorizontally(1))
        {
            e1.a(4096);
        }
        if (b.canScrollHorizontally(-1))
        {
            e1.a(8192);
        }
    }

    public final boolean a(View view, int i, Bundle bundle)
    {
        if (super.a(view, i, bundle))
        {
            return true;
        }
        switch (i)
        {
        default:
            return false;

        case 4096: 
            if (b.canScrollHorizontally(1))
            {
                b.setCurrentItem(ViewPager.c(b) + 1);
                return true;
            } else
            {
                return false;
            }

        case 8192: 
            break;
        }
        if (b.canScrollHorizontally(-1))
        {
            b.setCurrentItem(ViewPager.c(b) - 1);
            return true;
        } else
        {
            return false;
        }
    }

    public final void d(View view, AccessibilityEvent accessibilityevent)
    {
        super.d(view, accessibilityevent);
        accessibilityevent.setClassName(android/support/v4/view/ViewPager.getName());
        view = ag.a();
        view.a(a());
        if (accessibilityevent.getEventType() == 4096 && ViewPager.b(b) != null)
        {
            view.a(ViewPager.b(b).c());
            view.b(ViewPager.c(b));
            view.c(ViewPager.c(b));
        }
    }
}
