// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

final class ft
    implements fs
{

    ft()
    {
    }

    public final Object a(Context context, Interpolator interpolator)
    {
        if (interpolator != null)
        {
            return new Scroller(context, interpolator);
        } else
        {
            return new Scroller(context);
        }
    }
}
