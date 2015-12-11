// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import java.util.WeakHashMap;

// Referenced classes of package android.support.v4.view:
//            ck, cs, cn, cj, 
//            cw

class cm extends ck
{

    WeakHashMap b;

    cm()
    {
        b = null;
    }

    public final void a(cj cj, View view)
    {
        cs.a(view);
    }

    public final void a(cj cj, View view, float f)
    {
        cs.a(view, f);
    }

    public void a(cj cj, View view, cw cw)
    {
        view.setTag(0x7e000000, cw);
        cs.a(view, new cn(cj));
    }

    public final void a(View view, long l)
    {
        cs.a(view, l);
    }

    public final void b(cj cj, View view)
    {
        cs.b(view);
    }

    public final void b(cj cj, View view, float f)
    {
        cs.b(view, f);
    }

    public final void c(cj cj, View view, float f)
    {
        cs.c(view, f);
    }
}
