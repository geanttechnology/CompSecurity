// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;

// Referenced classes of package com.google.android.gms.internal:
//            fp

final class fs extends android.graphics.drawable.Drawable.ConstantState
{

    int a;
    int b;

    fs(fs fs1)
    {
        if (fs1 != null)
        {
            a = fs1.a;
            b = fs1.b;
        }
    }

    public final int getChangingConfigurations()
    {
        return a;
    }

    public final Drawable newDrawable()
    {
        return new fp(this);
    }
}
