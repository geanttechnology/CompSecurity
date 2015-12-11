// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import java.lang.ref.WeakReference;

// Referenced classes of package android.support.v4.view:
//            ad

final class <init>
    implements Runnable
{

    WeakReference a;
    ad b;
    final b c;

    public final void run()
    {
        View view = (View)a.get();
        if (view != null)
        {
            c.c(b, view);
        }
    }

    private ( , ad ad1, View view)
    {
        c = ;
        super();
        a = new WeakReference(view);
        b = ad1;
    }

    b(b b1, ad ad1, View view, byte byte0)
    {
        this(b1, ad1, view);
    }
}
