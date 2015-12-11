// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.ai;
import android.support.v4.view.ba;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            r

class <init> extends <init>
{

    final clerView.t a;
    final int b;
    final int c;
    final ba d;
    final r e;

    public void a(View view)
    {
        e.h(a);
    }

    public void b(View view)
    {
        d.a(null);
        e.e(a);
        r.g(e).remove(a);
        r.e(e);
    }

    public void c(View view)
    {
        if (b != 0)
        {
            ai.a(view, 0.0F);
        }
        if (c != 0)
        {
            ai.b(view, 0.0F);
        }
    }

    clerView.t(r r1, clerView.t t, int i, int j, ba ba1)
    {
        e = r1;
        a = t;
        b = i;
        c = j;
        d = ba1;
        super(null);
    }
}
