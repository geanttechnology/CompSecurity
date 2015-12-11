// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.support.v4.view.bc;
import android.support.v4.view.bd;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package android.support.v7:
//            cf

class c extends bd
{

    final cf a;
    private boolean b;
    private int c;

    void a()
    {
        c = 0;
        b = false;
        cf.b(a);
    }

    public void onAnimationEnd(View view)
    {
        int i = c + 1;
        c = i;
        if (i == cf.c(a).size())
        {
            if (cf.a(a) != null)
            {
                cf.a(a).onAnimationEnd(null);
            }
            a();
        }
    }

    public void onAnimationStart(View view)
    {
        if (!b)
        {
            b = true;
            if (cf.a(a) != null)
            {
                cf.a(a).onAnimationStart(null);
                return;
            }
        }
    }

    bc(cf cf1)
    {
        a = cf1;
        super();
        b = false;
        c = 0;
    }
}
