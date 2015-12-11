// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import java.lang.ref.WeakReference;

// Referenced classes of package android.support.v4.view:
//            ck, cj

final class cl
    implements Runnable
{

    WeakReference a;
    cj b;
    final ck c;

    private cl(ck ck1, cj cj, View view)
    {
        c = ck1;
        super();
        a = new WeakReference(view);
        b = cj;
    }

    cl(ck ck1, cj cj, View view, byte byte0)
    {
        this(ck1, cj, view);
    }

    public final void run()
    {
        c.c(b, (View)a.get());
    }
}
