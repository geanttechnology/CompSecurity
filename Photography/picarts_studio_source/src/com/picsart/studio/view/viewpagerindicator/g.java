// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view.viewpagerindicator;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package com.picsart.studio.view.viewpagerindicator:
//            VerticalViewPager

final class g extends AccessibilityDelegateCompat
{

    private VerticalViewPager a;

    g(VerticalViewPager verticalviewpager)
    {
        a = verticalviewpager;
        super();
    }

    private boolean a()
    {
        return VerticalViewPager.b(a) != null && VerticalViewPager.b(a).getCount() > 1;
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(view, accessibilityevent);
        accessibilityevent.setClassName(android/support/v4/view/ViewPager.getName());
        view = AccessibilityRecordCompat.obtain();
        view.setScrollable(a());
        if (accessibilityevent.getEventType() == 4096 && VerticalViewPager.b(a) != null)
        {
            view.setItemCount(VerticalViewPager.b(a).getCount());
            view.setFromIndex(VerticalViewPager.c(a));
            view.setToIndex(VerticalViewPager.c(a));
        }
    }

    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilitynodeinfocompat)
    {
        super.onInitializeAccessibilityNodeInfo(view, accessibilitynodeinfocompat);
        accessibilitynodeinfocompat.setClassName(android/support/v4/view/ViewPager.getName());
        accessibilitynodeinfocompat.setScrollable(a());
        if (a.c(1))
        {
            accessibilitynodeinfocompat.addAction(4096);
        }
        if (a.c(-1))
        {
            accessibilitynodeinfocompat.addAction(8192);
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
            if (a.c(1))
            {
                a.setCurrentItem(VerticalViewPager.c(a) + 1);
                return true;
            } else
            {
                return false;
            }

        case 8192: 
            break;
        }
        if (a.c(-1))
        {
            a.setCurrentItem(VerticalViewPager.c(a) - 1);
            return true;
        } else
        {
            return false;
        }
    }
}
