// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.a;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;

public final class android.support.v4.view.a.b
{
    static class a extends g
    {

        public final Object a(int k, int l)
        {
            return android.view.accessibility.AccessibilityNodeInfo.CollectionInfo.obtain(k, l, false, 0);
        }

        public final Object a(int k, int l, int i1, int j1, boolean flag)
        {
            return android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo.obtain(k, l, i1, j1, flag, false);
        }

        a()
        {
        }
    }

    static final class b extends a
    {

        b()
        {
        }
    }

    static class c extends h
    {

        public final int a(Object obj)
        {
            return ((AccessibilityNodeInfo)obj).getActions();
        }

        public final void a(Object obj, int i1)
        {
            ((AccessibilityNodeInfo)obj).addAction(i1);
        }

        public final void a(Object obj, Rect rect)
        {
            ((AccessibilityNodeInfo)obj).getBoundsInParent(rect);
        }

        public final void a(Object obj, CharSequence charsequence)
        {
            ((AccessibilityNodeInfo)obj).setClassName(charsequence);
        }

        public final void a(Object obj, boolean flag)
        {
            ((AccessibilityNodeInfo)obj).setScrollable(flag);
        }

        public final CharSequence b(Object obj)
        {
            return ((AccessibilityNodeInfo)obj).getClassName();
        }

        public final void b(Object obj, Rect rect)
        {
            ((AccessibilityNodeInfo)obj).getBoundsInScreen(rect);
        }

        public final CharSequence c(Object obj)
        {
            return ((AccessibilityNodeInfo)obj).getContentDescription();
        }

        public final CharSequence d(Object obj)
        {
            return ((AccessibilityNodeInfo)obj).getPackageName();
        }

        public final CharSequence e(Object obj)
        {
            return ((AccessibilityNodeInfo)obj).getText();
        }

        public final boolean f(Object obj)
        {
            return ((AccessibilityNodeInfo)obj).isCheckable();
        }

        public final boolean g(Object obj)
        {
            return ((AccessibilityNodeInfo)obj).isChecked();
        }

        public final boolean h(Object obj)
        {
            return ((AccessibilityNodeInfo)obj).isClickable();
        }

        public final boolean i(Object obj)
        {
            return ((AccessibilityNodeInfo)obj).isEnabled();
        }

        public final boolean j(Object obj)
        {
            return ((AccessibilityNodeInfo)obj).isFocusable();
        }

        public final boolean k(Object obj)
        {
            return ((AccessibilityNodeInfo)obj).isFocused();
        }

        public final boolean l(Object obj)
        {
            return ((AccessibilityNodeInfo)obj).isLongClickable();
        }

        public final boolean m(Object obj)
        {
            return ((AccessibilityNodeInfo)obj).isPassword();
        }

        public final boolean n(Object obj)
        {
            return ((AccessibilityNodeInfo)obj).isScrollable();
        }

        public final boolean o(Object obj)
        {
            return ((AccessibilityNodeInfo)obj).isSelected();
        }

        c()
        {
        }
    }

    public static interface d
    {

        public abstract int a(Object obj);

        public abstract Object a(int i1, int j1);

        public abstract Object a(int i1, int j1, int k1, int l1, boolean flag);

        public abstract void a(Object obj, int i1);

        public abstract void a(Object obj, Rect rect);

        public abstract void a(Object obj, CharSequence charsequence);

        public abstract void a(Object obj, Object obj1);

        public abstract void a(Object obj, boolean flag);

        public abstract CharSequence b(Object obj);

        public abstract void b(Object obj, Rect rect);

        public abstract void b(Object obj, Object obj1);

        public abstract CharSequence c(Object obj);

        public abstract CharSequence d(Object obj);

        public abstract CharSequence e(Object obj);

        public abstract boolean f(Object obj);

        public abstract boolean g(Object obj);

        public abstract boolean h(Object obj);

        public abstract boolean i(Object obj);

        public abstract boolean j(Object obj);

        public abstract boolean k(Object obj);

        public abstract boolean l(Object obj);

        public abstract boolean m(Object obj);

        public abstract boolean n(Object obj);

        public abstract boolean o(Object obj);

        public abstract String p(Object obj);
    }

    static class e extends c
    {

        e()
        {
        }
    }

    static class f extends e
    {

        public final String p(Object obj)
        {
            return ((AccessibilityNodeInfo)obj).getViewIdResourceName();
        }

        f()
        {
        }
    }

    static class g extends f
    {

        public Object a(int k, int l)
        {
            return android.view.accessibility.AccessibilityNodeInfo.CollectionInfo.obtain(k, l, false);
        }

        public Object a(int k, int l, int i1, int j1, boolean flag)
        {
            return android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo.obtain(k, l, i1, j1, flag);
        }

        public final void a(Object obj, Object obj1)
        {
            ((AccessibilityNodeInfo)obj).setCollectionInfo((android.view.accessibility.AccessibilityNodeInfo.CollectionInfo)obj1);
        }

        public final void b(Object obj, Object obj1)
        {
            ((AccessibilityNodeInfo)obj).setCollectionItemInfo((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo)obj1);
        }

        g()
        {
        }
    }

    static class h
        implements d
    {

        public int a(Object obj)
        {
            return 0;
        }

        public Object a(int i1, int j1)
        {
            return null;
        }

        public Object a(int i1, int j1, int k1, int l1, boolean flag)
        {
            return null;
        }

        public void a(Object obj, int i1)
        {
        }

        public void a(Object obj, Rect rect)
        {
        }

        public void a(Object obj, CharSequence charsequence)
        {
        }

        public void a(Object obj, Object obj1)
        {
        }

        public void a(Object obj, boolean flag)
        {
        }

        public CharSequence b(Object obj)
        {
            return null;
        }

        public void b(Object obj, Rect rect)
        {
        }

        public void b(Object obj, Object obj1)
        {
        }

        public CharSequence c(Object obj)
        {
            return null;
        }

        public CharSequence d(Object obj)
        {
            return null;
        }

        public CharSequence e(Object obj)
        {
            return null;
        }

        public boolean f(Object obj)
        {
            return false;
        }

        public boolean g(Object obj)
        {
            return false;
        }

        public boolean h(Object obj)
        {
            return false;
        }

        public boolean i(Object obj)
        {
            return false;
        }

        public boolean j(Object obj)
        {
            return false;
        }

        public boolean k(Object obj)
        {
            return false;
        }

        public boolean l(Object obj)
        {
            return false;
        }

        public boolean m(Object obj)
        {
            return false;
        }

        public boolean n(Object obj)
        {
            return false;
        }

        public boolean o(Object obj)
        {
            return false;
        }

        public String p(Object obj)
        {
            return null;
        }

        h()
        {
        }
    }

    public static final class i
    {

        public final Object a;

        public i(Object obj)
        {
            a = obj;
        }
    }

    public static final class j
    {

        final Object a;

        public static j a(int k, int l, int i1, int j1, boolean flag)
        {
            return new j(android.support.v4.view.a.b.a().a(k, l, i1, j1, flag));
        }

        private j(Object obj)
        {
            a = obj;
        }
    }


    public static final d a;
    public final Object b;

    public android.support.v4.view.a.b(Object obj)
    {
        b = obj;
    }

    public static d a()
    {
        return a;
    }

    public final void a(int k)
    {
        a.a(b, k);
    }

    public final void a(CharSequence charsequence)
    {
        a.a(b, charsequence);
    }

    public final void a(Object obj)
    {
        a.b(b, ((j)obj).a);
    }

    public final void a(boolean flag)
    {
        a.a(b, flag);
    }

    public final boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (android.support.v4.view.a.b)obj;
        if (b != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((android.support.v4.view.a.b) (obj)).b == null) goto _L1; else goto _L3
_L3:
        return false;
        if (b.equals(((android.support.v4.view.a.b) (obj)).b)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public final int hashCode()
    {
        if (b == null)
        {
            return 0;
        } else
        {
            return b.hashCode();
        }
    }

    public final String toString()
    {
        StringBuilder stringbuilder;
        int k;
        stringbuilder = new StringBuilder();
        stringbuilder.append(super.toString());
        Rect rect = new Rect();
        a.a(b, rect);
        stringbuilder.append((new StringBuilder("; boundsInParent: ")).append(rect).toString());
        a.b(b, rect);
        stringbuilder.append((new StringBuilder("; boundsInScreen: ")).append(rect).toString());
        stringbuilder.append("; packageName: ").append(a.d(b));
        stringbuilder.append("; className: ").append(a.b(b));
        stringbuilder.append("; text: ").append(a.e(b));
        stringbuilder.append("; contentDescription: ").append(a.c(b));
        stringbuilder.append("; viewId: ").append(a.p(b));
        stringbuilder.append("; checkable: ").append(a.f(b));
        stringbuilder.append("; checked: ").append(a.g(b));
        stringbuilder.append("; focusable: ").append(a.j(b));
        stringbuilder.append("; focused: ").append(a.k(b));
        stringbuilder.append("; selected: ").append(a.o(b));
        stringbuilder.append("; clickable: ").append(a.h(b));
        stringbuilder.append("; longClickable: ").append(a.l(b));
        stringbuilder.append("; enabled: ").append(a.i(b));
        stringbuilder.append("; password: ").append(a.m(b));
        stringbuilder.append((new StringBuilder("; scrollable: ")).append(a.n(b)).toString());
        stringbuilder.append("; [");
        k = a.a(b);
_L24:
        if (k == 0) goto _L2; else goto _L1
_L1:
        int l;
        l = 1 << Integer.numberOfTrailingZeros(k);
        k = ~l & k;
        l;
        JVM INSTR lookupswitch 18: default 628
    //                   1: 651
    //                   2: 657
    //                   4: 663
    //                   8: 669
    //                   16: 675
    //                   32: 681
    //                   64: 687
    //                   128: 693
    //                   256: 699
    //                   512: 705
    //                   1024: 711
    //                   2048: 717
    //                   4096: 723
    //                   8192: 729
    //                   16384: 741
    //                   32768: 747
    //                   65536: 735
    //                   131072: 753;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21
_L3:
        String s = "ACTION_UNKNOWN";
_L22:
        stringbuilder.append(s);
        if (k != 0)
        {
            stringbuilder.append(", ");
        }
        continue; /* Loop/switch isn't completed */
_L4:
        s = "ACTION_FOCUS";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "ACTION_CLEAR_FOCUS";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "ACTION_SELECT";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "ACTION_CLEAR_SELECTION";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "ACTION_CLICK";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "ACTION_LONG_CLICK";
        continue; /* Loop/switch isn't completed */
_L10:
        s = "ACTION_ACCESSIBILITY_FOCUS";
        continue; /* Loop/switch isn't completed */
_L11:
        s = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
        continue; /* Loop/switch isn't completed */
_L12:
        s = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
        continue; /* Loop/switch isn't completed */
_L13:
        s = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
        continue; /* Loop/switch isn't completed */
_L14:
        s = "ACTION_NEXT_HTML_ELEMENT";
        continue; /* Loop/switch isn't completed */
_L15:
        s = "ACTION_PREVIOUS_HTML_ELEMENT";
        continue; /* Loop/switch isn't completed */
_L16:
        s = "ACTION_SCROLL_FORWARD";
        continue; /* Loop/switch isn't completed */
_L17:
        s = "ACTION_SCROLL_BACKWARD";
        continue; /* Loop/switch isn't completed */
_L20:
        s = "ACTION_CUT";
        continue; /* Loop/switch isn't completed */
_L18:
        s = "ACTION_COPY";
        continue; /* Loop/switch isn't completed */
_L19:
        s = "ACTION_PASTE";
        continue; /* Loop/switch isn't completed */
_L21:
        s = "ACTION_SET_SELECTION";
        if (true) goto _L22; else goto _L2
_L2:
        stringbuilder.append("]");
        return stringbuilder.toString();
        if (true) goto _L24; else goto _L23
_L23:
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 22)
        {
            a = new b();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            a = new a();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            a = new g();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            a = new f();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            a = new e();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new c();
        } else
        {
            a = new h();
        }
    }
}
