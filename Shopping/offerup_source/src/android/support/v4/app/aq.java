// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;

// Referenced classes of package android.support.v4.app:
//            as, d

final class aq extends android.transition.Transition.EpicenterCallback
{

    private Rect a;
    private as b;

    aq(as as1)
    {
        b = as1;
        super();
    }

    public final Rect onGetEpicenter(Transition transition)
    {
        if (a == null && b.a != null)
        {
            a = d.a(b.a);
        }
        return a;
    }
}
