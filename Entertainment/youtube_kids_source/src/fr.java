// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.animation.Interpolator;

public final class fr
{

    public Object a;
    public fs b;

    private fr(int i, Context context, Interpolator interpolator)
    {
        if (i >= 14)
        {
            b = new fv();
        } else
        if (i >= 9)
        {
            b = new fu();
        } else
        {
            b = new ft();
        }
        a = b.a(context, interpolator);
    }

    public fr(Context context, Interpolator interpolator)
    {
        this(android.os.Build.VERSION.SDK_INT, context, interpolator);
    }
}
