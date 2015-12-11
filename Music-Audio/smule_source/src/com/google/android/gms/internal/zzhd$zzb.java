// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;

// Referenced classes of package com.google.android.gms.internal:
//            zzhd

final class zzSI extends android.graphics.drawable.ConstantState
{

    int zzSH;
    int zzSI;

    public int getChangingConfigurations()
    {
        return zzSH;
    }

    public Drawable newDrawable()
    {
        return new zzhd(this);
    }

    ntState(ntState ntstate)
    {
        if (ntstate != null)
        {
            zzSH = ntstate.zzSH;
            zzSI = ntstate.zzSI;
        }
    }
}
