// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import java.lang.ref.WeakReference;

final class er
    implements Runnable
{

    private WeakReference a;
    private ep b;
    private eq c;

    er(eq eq1, ep ep, View view)
    {
        c = eq1;
        super();
        a = new WeakReference(view);
        b = ep;
    }

    public final void run()
    {
        c.b(b, (View)a.get());
    }
}
