// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;

// Referenced classes of package com.google.android.gms.internal:
//            bv, h, cw, bb, 
//            cm, cj

public final class bu
{
    public static interface a
    {

        public abstract void a(cj cj);
    }


    public static cm a(Context context, bz.a a1, h h, cw cw, bb bb, a a2)
    {
        context = new bv(context, a1, h, cw, bb, a2);
        context.start();
        return context;
    }
}
