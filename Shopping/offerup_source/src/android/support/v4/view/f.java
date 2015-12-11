// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.a.q;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.support.v4.view:
//            j, a, e

class f
    implements j
{

    private a a;

    f(e e, a a1)
    {
        a = a1;
        super();
    }

    public final Object a(View view)
    {
        view = a.getAccessibilityNodeProvider(view);
        if (view != null)
        {
            return view.a();
        } else
        {
            return null;
        }
    }

    public final void a(View view, int i)
    {
        a.sendAccessibilityEvent(view, i);
    }

    public final void a(View view, Object obj)
    {
        a.onInitializeAccessibilityNodeInfo(view, new android.support.v4.view.a.f(obj));
    }

    public final boolean a(View view, int i, Bundle bundle)
    {
        return a.performAccessibilityAction(view, i, bundle);
    }

    public final boolean a(View view, AccessibilityEvent accessibilityevent)
    {
        return a.dispatchPopulateAccessibilityEvent(view, accessibilityevent);
    }

    public final boolean a(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        return a.onRequestSendAccessibilityEvent(viewgroup, view, accessibilityevent);
    }

    public final void b(View view, AccessibilityEvent accessibilityevent)
    {
        a.onInitializeAccessibilityEvent(view, accessibilityevent);
    }

    public final void c(View view, AccessibilityEvent accessibilityevent)
    {
        a.onPopulateAccessibilityEvent(view, accessibilityevent);
    }

    public final void d(View view, AccessibilityEvent accessibilityevent)
    {
        a.sendAccessibilityEventUnchecked(view, accessibilityevent);
    }
}
