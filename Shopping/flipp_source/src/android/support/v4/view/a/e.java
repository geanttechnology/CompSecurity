// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.a;

import android.graphics.Rect;
import android.view.View;

// Referenced classes of package android.support.v4.view.a:
//            f, k, j, i, 
//            g, l, h, n

public final class e
{

    public static final h a;
    public final Object b;

    public e(Object obj)
    {
        b = obj;
    }

    public static e a(e e1)
    {
        e1 = ((e) (a.a(e1.b)));
        if (e1 != null)
        {
            return new e(e1);
        } else
        {
            return null;
        }
    }

    public static h k()
    {
        return a;
    }

    public final int a()
    {
        return a.b(b);
    }

    public final void a(int i1)
    {
        a.a(b, i1);
    }

    public final void a(Rect rect)
    {
        a.a(b, rect);
    }

    public final void a(View view)
    {
        a.b(b, view);
    }

    public final void a(CharSequence charsequence)
    {
        a.a(b, charsequence);
    }

    public final void a(Object obj)
    {
        a.b(b, ((n)obj).a);
    }

    public final void a(boolean flag)
    {
        a.f(b, flag);
    }

    public final void b(Rect rect)
    {
        a.b(b, rect);
    }

    public final boolean b()
    {
        return a.k(b);
    }

    public final boolean c()
    {
        return a.l(b);
    }

    public final boolean d()
    {
        return a.p(b);
    }

    public final boolean e()
    {
        return a.i(b);
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
        obj = (e)obj;
        if (b != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((e) (obj)).b == null) goto _L1; else goto _L3
_L3:
        return false;
        if (b.equals(((e) (obj)).b)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public final boolean f()
    {
        return a.m(b);
    }

    public final boolean g()
    {
        return a.j(b);
    }

    public final CharSequence h()
    {
        return a.e(b);
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

    public final CharSequence i()
    {
        return a.c(b);
    }

    public final CharSequence j()
    {
        return a.d(b);
    }

    public final String toString()
    {
        StringBuilder stringbuilder;
        int i1;
        stringbuilder = new StringBuilder();
        stringbuilder.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        stringbuilder.append((new StringBuilder("; boundsInParent: ")).append(rect).toString());
        b(rect);
        stringbuilder.append((new StringBuilder("; boundsInScreen: ")).append(rect).toString());
        stringbuilder.append("; packageName: ").append(h());
        stringbuilder.append("; className: ").append(i());
        stringbuilder.append("; text: ").append(a.f(b));
        stringbuilder.append("; contentDescription: ").append(j());
        stringbuilder.append("; viewId: ").append(a.t(b));
        stringbuilder.append("; checkable: ").append(a.g(b));
        stringbuilder.append("; checked: ").append(a.h(b));
        stringbuilder.append("; focusable: ").append(b());
        stringbuilder.append("; focused: ").append(c());
        stringbuilder.append("; selected: ").append(d());
        stringbuilder.append("; clickable: ").append(e());
        stringbuilder.append("; longClickable: ").append(f());
        stringbuilder.append("; enabled: ").append(g());
        stringbuilder.append("; password: ").append(a.n(b));
        stringbuilder.append((new StringBuilder("; scrollable: ")).append(a.o(b)).toString());
        stringbuilder.append("; [");
        i1 = a();
_L24:
        if (i1 == 0) goto _L2; else goto _L1
_L1:
        int j1;
        j1 = 1 << Integer.numberOfTrailingZeros(i1);
        i1 = ~j1 & i1;
        j1;
        JVM INSTR lookupswitch 18: default 532
    //                   1: 555
    //                   2: 561
    //                   4: 567
    //                   8: 573
    //                   16: 579
    //                   32: 585
    //                   64: 591
    //                   128: 598
    //                   256: 605
    //                   512: 612
    //                   1024: 619
    //                   2048: 626
    //                   4096: 633
    //                   8192: 640
    //                   16384: 654
    //                   32768: 661
    //                   65536: 647
    //                   131072: 668;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21
_L3:
        String s = "ACTION_UNKNOWN";
_L22:
        stringbuilder.append(s);
        if (i1 != 0)
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
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            a = new f();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            a = new k();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            a = new j();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            a = new i();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new g();
        } else
        {
            a = new l();
        }
    }
}
