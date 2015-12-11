// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.verticalviewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.a;
import android.support.v4.view.a.ag;
import android.support.v4.view.a.e;
import android.support.v4.view.ae;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package fr.castorflex.android.verticalviewpager:
//            VerticalViewPager

final class g extends a
{

    final VerticalViewPager b;

    g(VerticalViewPager verticalviewpager)
    {
        b = verticalviewpager;
        super();
    }

    private boolean a()
    {
        return VerticalViewPager.b(b) != null && VerticalViewPager.b(b).c() > 1;
    }

    public final void a(View view, e e1)
    {
        super.a(view, e1);
        e1.a(android/support/v4/view/ViewPager.getName());
        e1.a(a());
        if (b.a(1))
        {
            e1.a(4096);
        }
        if (b.a(-1))
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
            if (b.a(1))
            {
                b.setCurrentItem(VerticalViewPager.c(b) + 1);
                return true;
            } else
            {
                return false;
            }

        case 8192: 
            break;
        }
        if (b.a(-1))
        {
            b.setCurrentItem(VerticalViewPager.c(b) - 1);
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
        if (accessibilityevent.getEventType() == 4096 && VerticalViewPager.b(b) != null)
        {
            view.a(VerticalViewPager.b(b).c());
            view.b(VerticalViewPager.c(b));
            view.c(VerticalViewPager.c(b));
        }
    }
}
