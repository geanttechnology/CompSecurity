// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.view.ViewGroup;

// Referenced classes of package com.flurry.android:
//            AdUnit

abstract class fm
{

    private final AdUnit T;
    private final String dq;

    public fm(AdUnit adunit)
    {
        T = adunit;
        if (adunit != null)
        {
            adunit = adunit.getAdSpace().toString();
        } else
        {
            adunit = null;
        }
        dq = adunit;
    }

    public final AdUnit L()
    {
        return T;
    }

    public abstract void a(Context context, ViewGroup viewgroup);

    public final String bs()
    {
        return dq;
    }
}
