// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.a;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

// Referenced classes of package android.support.v4.view.a:
//            e

class j extends e
{

    j()
    {
    }

    public final Object a(Object obj)
    {
        return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo)obj);
    }

    public final void a(Object obj, int i1)
    {
        ((AccessibilityNodeInfo)obj).addAction(i1);
    }

    public final void a(Object obj, Rect rect)
    {
        ((AccessibilityNodeInfo)obj).getBoundsInParent(rect);
    }

    public final void a(Object obj, View view)
    {
        ((AccessibilityNodeInfo)obj).setSource(view);
    }

    public final void a(Object obj, CharSequence charsequence)
    {
        ((AccessibilityNodeInfo)obj).setPackageName(charsequence);
    }

    public final void a(Object obj, boolean flag)
    {
        ((AccessibilityNodeInfo)obj).setFocusable(flag);
    }

    public final int b(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).getActions();
    }

    public final void b(Object obj, Rect rect)
    {
        ((AccessibilityNodeInfo)obj).setBoundsInParent(rect);
    }

    public final void b(Object obj, View view)
    {
        ((AccessibilityNodeInfo)obj).addChild(view);
    }

    public final void b(Object obj, CharSequence charsequence)
    {
        ((AccessibilityNodeInfo)obj).setClassName(charsequence);
    }

    public final void b(Object obj, boolean flag)
    {
        ((AccessibilityNodeInfo)obj).setFocused(flag);
    }

    public final void c(Object obj, Rect rect)
    {
        ((AccessibilityNodeInfo)obj).getBoundsInScreen(rect);
    }

    public final void c(Object obj, View view)
    {
        ((AccessibilityNodeInfo)obj).setParent(view);
    }

    public final void c(Object obj, CharSequence charsequence)
    {
        ((AccessibilityNodeInfo)obj).setContentDescription(charsequence);
    }

    public final boolean c(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isCheckable();
    }

    public final void d(Object obj, Rect rect)
    {
        ((AccessibilityNodeInfo)obj).setBoundsInScreen(rect);
    }

    public final boolean d(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isChecked();
    }

    public final void e(Object obj, boolean flag)
    {
        ((AccessibilityNodeInfo)obj).setSelected(flag);
    }

    public final boolean e(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isFocusable();
    }

    public final void f(Object obj, boolean flag)
    {
        ((AccessibilityNodeInfo)obj).setClickable(flag);
    }

    public final boolean f(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isFocused();
    }

    public final void g(Object obj, boolean flag)
    {
        ((AccessibilityNodeInfo)obj).setLongClickable(flag);
    }

    public final void h(Object obj, boolean flag)
    {
        ((AccessibilityNodeInfo)obj).setEnabled(flag);
    }

    public final void i(Object obj, boolean flag)
    {
        ((AccessibilityNodeInfo)obj).setScrollable(flag);
    }

    public final boolean i(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isSelected();
    }

    public final boolean j(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isClickable();
    }

    public final boolean k(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isLongClickable();
    }

    public final boolean l(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isEnabled();
    }

    public final boolean m(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isPassword();
    }

    public final boolean n(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isScrollable();
    }

    public final CharSequence o(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).getPackageName();
    }

    public final CharSequence p(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).getClassName();
    }

    public final CharSequence q(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).getText();
    }

    public final CharSequence r(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).getContentDescription();
    }

    public final void s(Object obj)
    {
        ((AccessibilityNodeInfo)obj).recycle();
    }
}
