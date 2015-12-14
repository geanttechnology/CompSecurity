// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.ViewParent;

class fa
    implements Runnable
{

    final ez a;

    private fa(ez ez1)
    {
        a = ez1;
        super();
    }

    fa(ez ez1, ev ev)
    {
        this(ez1);
    }

    public void run()
    {
        ez.a(a).getParent().requestDisallowInterceptTouchEvent(true);
    }
}
