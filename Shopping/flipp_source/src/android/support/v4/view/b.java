// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.support.v4.view.a.e;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.support.v4.view:
//            g, h, c, a

class b extends g
{

    b()
    {
    }

    public final Object a()
    {
        return h.a();
    }

    public Object a(a a1)
    {
        return h.a(new c(this, a1));
    }

    public final void a(Object obj, View view, int i)
    {
        h.a(obj, view, i);
    }

    public final void a(Object obj, View view, e e1)
    {
        h.a(obj, view, e1.b);
    }

    public final boolean a(Object obj, View view, AccessibilityEvent accessibilityevent)
    {
        return h.a(obj, view, accessibilityevent);
    }

    public final boolean a(Object obj, ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        return h.a(obj, viewgroup, view, accessibilityevent);
    }

    public final void b(Object obj, View view, AccessibilityEvent accessibilityevent)
    {
        h.b(obj, view, accessibilityevent);
    }

    public final void c(Object obj, View view, AccessibilityEvent accessibilityevent)
    {
        h.c(obj, view, accessibilityevent);
    }

    public final void d(Object obj, View view, AccessibilityEvent accessibilityevent)
    {
        h.d(obj, view, accessibilityevent);
    }
}
