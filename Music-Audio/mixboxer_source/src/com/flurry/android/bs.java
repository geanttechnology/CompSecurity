// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.view.ViewGroup;

// Referenced classes of package com.flurry.android:
//            fm, ae, AdUnit

final class bs extends fm
{

    private final ae dL;

    public bs(ae ae1, AdUnit adunit)
    {
        super(adunit);
        dL = ae1;
    }

    public final void a(Context context, ViewGroup viewgroup)
    {
        if (dL != null)
        {
            dL.M();
        }
    }
}
