// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.support.v4.view.bf;
import android.support.v7.widget.Toolbar;
import android.view.View;

// Referenced classes of package android.support.v7.internal.widget:
//            t

class b extends bf
{

    final t a;
    private boolean b;

    public void b(View view)
    {
        if (!b)
        {
            t.a(a).setVisibility(8);
        }
    }

    public void c(View view)
    {
        b = true;
    }

    (t t1)
    {
        a = t1;
        super();
        b = false;
    }
}
