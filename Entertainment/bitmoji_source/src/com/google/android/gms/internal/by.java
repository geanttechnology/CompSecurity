// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;

// Referenced classes of package com.google.android.gms.internal:
//            bz, l, dd, bf, 
//            ct, cn

public final class by
{
    public static interface a
    {

        public abstract void a(cn cn);
    }


    public static ct a(Context context, cd.a a1, l l, dd dd, bf bf, a a2)
    {
        context = new bz(context, a1, l, dd, bf, a2);
        context.start();
        return context;
    }
}
