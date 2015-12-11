// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.support.v7.e.b;
import android.support.v7.internal.view.menu.f;
import android.support.v7.internal.view.menu.h;
import android.support.v7.internal.view.menu.l;
import android.support.v7.internal.view.menu.p;
import android.view.View;
import android.widget.ImageButton;

// Referenced classes of package android.support.v7.widget:
//            Toolbar

private final class <init>
    implements l
{

    f a;
    public h b;
    final Toolbar c;

    public final void a(Context context, f f1)
    {
        if (a != null && b != null)
        {
            a.b(b);
        }
        a = f1;
    }

    public final void a(f f1, boolean flag)
    {
    }

    public final boolean a()
    {
        return false;
    }

    public final boolean a(p p)
    {
        return false;
    }

    public final void b(boolean flag)
    {
        boolean flag2 = false;
        if (b == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = flag2;
        if (a == null) goto _L4; else goto _L3
_L3:
        int i;
        int j;
        j = a.size();
        i = 0;
_L9:
        flag1 = flag2;
        if (i >= j) goto _L4; else goto _L5
_L5:
        if (a.getItem(i) != b) goto _L7; else goto _L6
_L6:
        flag1 = true;
_L4:
        if (!flag1)
        {
            c(b);
        }
_L2:
        return;
_L7:
        i++;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public final boolean b(h h1)
    {
        android.support.v7.widget.Toolbar.b(c);
        if (Toolbar.c(c).getParent() != c)
        {
            c.addView(Toolbar.c(c));
        }
        c.d = h1.getActionView();
        b = h1;
        if (c.d.getParent() != c)
        {
            u.h h2 = Toolbar.e();
            h2.a = 0x800003 | Toolbar.d(c) & 0x70;
            h2.b = 2;
            c.d.setLayoutParams(h2);
            c.addView(c.d);
        }
        Toolbar.a(c, true);
        c.requestLayout();
        h1.d(true);
        if (c.d instanceof b)
        {
            ((b)c.d).a();
        }
        return true;
    }

    public final boolean c(h h1)
    {
        if (c.d instanceof b)
        {
            ((b)c.d).b();
        }
        c.removeView(c.d);
        c.removeView(Toolbar.c(c));
        c.d = null;
        Toolbar.a(c, false);
        b = null;
        c.requestLayout();
        h1.d(false);
        return true;
    }

    private u.h(Toolbar toolbar)
    {
        c = toolbar;
        super();
    }

    public c(Toolbar toolbar, byte byte0)
    {
        this(toolbar);
    }
}
