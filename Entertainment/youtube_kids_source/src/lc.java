// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.ViewParent;

final class lc
    implements Runnable
{

    private lb a;

    lc(lb lb1)
    {
        a = lb1;
        super();
    }

    public final void run()
    {
        lb.a(a).getParent().requestDisallowInterceptTouchEvent(true);
    }
}
