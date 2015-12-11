// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ViewSwitcher;

final class ahj extends ViewSwitcher
{

    private final abu a;

    public ahj(Context context)
    {
        super(context);
        a = new abu(context);
    }

    static abu a(ahj ahj1)
    {
        return ahj1.a;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        a.a(motionevent);
        return false;
    }
}
