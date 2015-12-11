// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import java.lang.ref.WeakReference;

// Referenced classes of package android.support.v4.view:
//            cy, cx

final class cz
    implements Runnable
{

    private WeakReference a;
    private cx b;
    private cy c;

    private cz(cy cy1, cx cx, View view)
    {
        c = cy1;
        super();
        a = new WeakReference(view);
        b = cx;
    }

    cz(cy cy1, cx cx, View view, byte byte0)
    {
        this(cy1, cx, view);
    }

    public final void run()
    {
        View view = (View)a.get();
        if (view != null)
        {
            cy.a(c, b, view);
        }
    }
}
