// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;
import java.util.ArrayList;

class at extends ViewPropertyAnimatorListenerAdapter
{

    final as a;
    private boolean b;
    private int c;

    at(as as1)
    {
        a = as1;
        super();
        b = false;
        c = 0;
    }

    void a()
    {
        c = 0;
        b = false;
        as.b(a);
    }

    public void onAnimationEnd(View view)
    {
        int i = c + 1;
        c = i;
        if (i == as.c(a).size())
        {
            if (as.a(a) != null)
            {
                as.a(a).onAnimationEnd(null);
            }
            a();
        }
    }

    public void onAnimationStart(View view)
    {
        if (!b)
        {
            b = true;
            if (as.a(a) != null)
            {
                as.a(a).onAnimationStart(null);
                return;
            }
        }
    }
}
