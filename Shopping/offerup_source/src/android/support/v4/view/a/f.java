// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.a;

import android.graphics.Rect;
import android.view.View;

// Referenced classes of package android.support.v4.view.a:
//            i, h, n, m, 
//            l, k, j, e, 
//            o, g, p

public final class f
{

    private static final e a;
    private final Object b;

    public f(Object obj)
    {
        b = obj;
    }

    public static f a(f f1)
    {
        f1 = ((f) (a.a(f1.b)));
        if (f1 != null)
        {
            return new f(f1);
        } else
        {
            return null;
        }
    }

    static e o()
    {
        return a;
    }

    public final Object a()
    {
        return b;
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
        a.a(b, view);
    }

    public final void a(CharSequence charsequence)
    {
        a.a(b, charsequence);
    }

    public final void a(Object obj)
    {
        a.b(b, ((o)obj).a);
    }

    public final void a(boolean flag)
    {
        a.a(b, flag);
    }

    public final boolean a(g g1)
    {
        return a.a(b, android.support.v4.view.a.g.a(g1));
    }

    public final int b()
    {
        return a.b(b);
    }

    public final void b(Rect rect)
    {
        a.b(b, rect);
    }

    public final void b(View view)
    {
        a.b(b, view);
    }

    public final void b(CharSequence charsequence)
    {
        a.b(b, charsequence);
    }

    public final void b(Object obj)
    {
        a.c(b, p.a((p)obj));
    }

    public final void b(boolean flag)
    {
        a.b(b, flag);
    }

    public final void c(Rect rect)
    {
        a.c(b, rect);
    }

    public final void c(View view)
    {
        a.c(b, view);
    }

    public final void c(CharSequence charsequence)
    {
        a.c(b, charsequence);
    }

    public final void c(boolean flag)
    {
        a.c(b, flag);
    }

    public final boolean c()
    {
        return a.e(b);
    }

    public final void d(Rect rect)
    {
        a.d(b, rect);
    }

    public final void d(boolean flag)
    {
        a.d(b, flag);
    }

    public final boolean d()
    {
        return a.f(b);
    }

    public final void e(boolean flag)
    {
        a.e(b, flag);
    }

    public final boolean e()
    {
        return a.g(b);
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
        obj = (f)obj;
        if (b != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((f) (obj)).b == null) goto _L1; else goto _L3
_L3:
        return false;
        if (b.equals(((f) (obj)).b)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public final void f(boolean flag)
    {
        a.f(b, flag);
    }

    public final boolean f()
    {
        return a.h(b);
    }

    public final void g(boolean flag)
    {
        a.g(b, flag);
    }

    public final boolean g()
    {
        return a.i(b);
    }

    public final void h(boolean flag)
    {
        a.h(b, flag);
    }

    public final boolean h()
    {
        return a.j(b);
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

    public final void i(boolean flag)
    {
        a.i(b, flag);
    }

    public final boolean i()
    {
        return a.k(b);
    }

    public final boolean j()
    {
        return a.l(b);
    }

    public final CharSequence k()
    {
        return a.o(b);
    }

    public final CharSequence l()
    {
        return a.p(b);
    }

    public final CharSequence m()
    {
        return a.r(b);
    }

    public final void n()
    {
        a.s(b);
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
        c(rect);
        stringbuilder.append((new StringBuilder("; boundsInScreen: ")).append(rect).toString());
        stringbuilder.append("; packageName: ").append(k());
        stringbuilder.append("; className: ").append(l());
        stringbuilder.append("; text: ").append(a.q(b));
        stringbuilder.append("; contentDescription: ").append(m());
        stringbuilder.append("; viewId: ").append(a.t(b));
        stringbuilder.append("; checkable: ").append(a.c(b));
        stringbuilder.append("; checked: ").append(a.d(b));
        stringbuilder.append("; focusable: ").append(c());
        stringbuilder.append("; focused: ").append(d());
        stringbuilder.append("; selected: ").append(g());
        stringbuilder.append("; clickable: ").append(h());
        stringbuilder.append("; longClickable: ").append(i());
        stringbuilder.append("; enabled: ").append(j());
        stringbuilder.append("; password: ").append(a.m(b));
        stringbuilder.append((new StringBuilder("; scrollable: ")).append(a.n(b)).toString());
        stringbuilder.append("; [");
        i1 = b();
_L24:
        if (i1 == 0) goto _L2; else goto _L1
_L1:
        int j1;
        j1 = 1 << Integer.numberOfTrailingZeros(i1);
        i1 = ~j1 & i1;
        j1;
        JVM INSTR lookupswitch 18: default 528
    //                   1: 553
    //                   2: 560
    //                   4: 567
    //                   8: 574
    //                   16: 581
    //                   32: 588
    //                   64: 595
    //                   128: 602
    //                   256: 609
    //                   512: 616
    //                   1024: 623
    //                   2048: 630
    //                   4096: 637
    //                   8192: 644
    //                   16384: 658
    //                   32768: 665
    //                   65536: 651
    //                   131072: 672;
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
        if (android.os.Build.VERSION.SDK_INT >= 22)
        {
            a = new i();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            a = new h();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            a = new n();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            a = new m();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            a = new l();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            a = new k();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new j();
        } else
        {
            a = new e();
        }
    }
}
