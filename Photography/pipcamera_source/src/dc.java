// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.ViewParent;

class dc
    implements Runnable
{

    final db a;

    private dc(db db1)
    {
        a = db1;
        super();
    }

    dc(db db1, android.support.v7.widget.ListPopupWindow._cls1 _pcls1)
    {
        this(db1);
    }

    public void run()
    {
        db.a(a).getParent().requestDisallowInterceptTouchEvent(true);
    }
}
