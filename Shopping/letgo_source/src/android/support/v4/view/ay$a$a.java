// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import java.lang.ref.WeakReference;

// Referenced classes of package android.support.v4.view:
//            ay

class <init>
    implements Runnable
{

    WeakReference a;
    ay b;
    final b c;

    public void run()
    {
        View view = (View)a.get();
        if (view != null)
        {
            (c, b, view);
        }
    }

    private ( , ay ay1, View view)
    {
        c = ;
        super();
        a = new WeakReference(view);
        b = ay1;
    }

    b(b b1, ay ay1, View view, b b2)
    {
        this(b1, ay1, view);
    }
}
