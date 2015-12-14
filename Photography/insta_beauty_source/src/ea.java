// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.widget.Toolbar;
import android.view.View;

class ea extends ViewPropertyAnimatorListenerAdapter
{

    final dy a;
    private boolean b;

    ea(dy dy1)
    {
        a = dy1;
        super();
        b = false;
    }

    public void onAnimationCancel(View view)
    {
        b = true;
    }

    public void onAnimationEnd(View view)
    {
        if (!b)
        {
            dy.a(a).setVisibility(8);
        }
    }
}
