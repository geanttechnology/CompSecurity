// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;

// Referenced classes of package com.google.android.gms.internal:
//            zzls

final class zzaex extends android.graphics.drawable.ConstantState
{

    int zzaew;
    int zzaex;

    public final int getChangingConfigurations()
    {
        return zzaew;
    }

    public final Drawable newDrawable()
    {
        return new zzls(this);
    }

    ntState(ntState ntstate)
    {
        if (ntstate != null)
        {
            zzaew = ntstate.zzaew;
            zzaex = ntstate.zzaex;
        }
    }
}
