// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;

// Referenced classes of package com.google.android.gms.internal:
//            bz, cu, ct, cm, 
//            cb

public final class bw
{
    public static interface a
    {

        public abstract void a(cb cb);
    }


    public static cm a(Context context, bz bz1, a a1)
    {
        if (bz1.ej.iM)
        {
            return b(context, bz1, a1);
        } else
        {
            return c(context, bz1, a1);
        }
    }

    private static cm b(Context context, bz bz1, a a1)
    {
        ct.r("Fetching ad response from local ad request service.");
        context = new bx.a(context, bz1, a1);
        context.start();
        return context;
    }

    private static cm c(Context context, bz bz1, a a1)
    {
        ct.r("Fetching ad response from remote ad request service.");
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) != 0)
        {
            ct.v("Failed to connect to remote ad request service.");
            return null;
        } else
        {
            return new bx.b(context, bz1, a1);
        }
    }
}
