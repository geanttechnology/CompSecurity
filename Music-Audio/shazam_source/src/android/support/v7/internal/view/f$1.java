// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view;

import android.support.v4.view.ah;
import android.support.v4.view.ai;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.internal.view:
//            f

final class c extends ai
{

    final f a;
    private boolean b;
    private int c;

    public final void a(View view)
    {
        if (!b)
        {
            b = true;
            if (a.b != null)
            {
                a.b.a(null);
                return;
            }
        }
    }

    public final void b(View view)
    {
        int i = c + 1;
        c = i;
        if (i == a.a.size())
        {
            if (a.b != null)
            {
                a.b.b(null);
            }
            c = 0;
            b = false;
            a.c = false;
        }
    }

    (f f1)
    {
        a = f1;
        super();
        b = false;
        c = 0;
    }
}
