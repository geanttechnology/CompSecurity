// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.d;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

public class z extends a
{

    final RecyclerView a;
    final a b = new a() {

        final z a;

        public void onInitializeAccessibilityNodeInfo(View view, d d1)
        {
            super.onInitializeAccessibilityNodeInfo(view, d1);
            if (a.a.getLayoutManager() != null)
            {
                a.a.getLayoutManager().a(view, d1);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle)
        {
            if (super.performAccessibilityAction(view, i, bundle))
            {
                return true;
            }
            if (a.a.getLayoutManager() != null)
            {
                return a.a.getLayoutManager().a(view, i, bundle);
            } else
            {
                return false;
            }
        }

            
            {
                a = z.this;
                super();
            }
    };

    public z(RecyclerView recyclerview)
    {
        a = recyclerview;
    }

    a a()
    {
        return b;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(view, accessibilityevent);
        accessibilityevent.setClassName(android/support/v7/widget/RecyclerView.getName());
        if (view instanceof RecyclerView)
        {
            view = (RecyclerView)view;
            if (view.getLayoutManager() != null)
            {
                view.getLayoutManager().a(accessibilityevent);
            }
        }
    }

    public void onInitializeAccessibilityNodeInfo(View view, d d1)
    {
        super.onInitializeAccessibilityNodeInfo(view, d1);
        d1.b(android/support/v7/widget/RecyclerView.getName());
        if (a.getLayoutManager() != null)
        {
            a.getLayoutManager().a(d1);
        }
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle)
    {
        if (super.performAccessibilityAction(view, i, bundle))
        {
            return true;
        }
        if (a.getLayoutManager() != null)
        {
            return a.getLayoutManager().a(i, bundle);
        } else
        {
            return false;
        }
    }
}
