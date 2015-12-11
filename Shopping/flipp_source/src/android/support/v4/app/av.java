// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;

// Referenced classes of package android.support.v4.app:
//            ax, as

final class av extends android.transition.Transition.EpicenterCallback
{

    final ax a;
    private Rect b;

    av(ax ax1)
    {
        a = ax1;
        super();
    }

    public final Rect onGetEpicenter(Transition transition)
    {
        if (b == null && a.a != null)
        {
            b = as.b(a.a);
        }
        return b;
    }
}
