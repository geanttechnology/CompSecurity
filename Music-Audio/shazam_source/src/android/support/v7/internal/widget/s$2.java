// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.support.v4.view.ai;
import android.support.v7.widget.Toolbar;
import android.view.View;

// Referenced classes of package android.support.v7.internal.widget:
//            s

final class b extends ai
{

    final s a;
    private boolean b;

    public final void b(View view)
    {
        if (!b)
        {
            a.a.setVisibility(8);
        }
    }

    public final void c(View view)
    {
        b = true;
    }

    (s s1)
    {
        a = s1;
        super();
        b = false;
    }
}
