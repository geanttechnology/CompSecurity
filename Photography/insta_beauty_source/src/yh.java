// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.MotionEvent;

public abstract class yh
{

    ym a;

    public yh()
    {
    }

    public static yh a(Context context, ym ym)
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i < 5)
        {
            context = new yi(context);
        } else
        if (i < 8)
        {
            context = new yj(context);
        } else
        {
            context = new yk(context);
        }
        context.a = ym;
        return context;
    }

    public abstract boolean a();

    public abstract boolean a(MotionEvent motionevent);
}
