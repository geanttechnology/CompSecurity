// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.l;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            PlacesParams, d

public class i extends l
{
    public static class a extends com.google.android.gms.common.api.a.b
    {

        private final String a;
        private final String b;

        public com.google.android.gms.common.api.a.c a(Context context, Looper looper, h h1, Object obj, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c)
        {
            return a(context, looper, h1, (com.google.android.gms.location.places.l)obj, b1, c);
        }

        public i a(Context context, Looper looper, h h1, com.google.android.gms.location.places.l l1, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c)
        {
            String s;
            String s1;
            if (a != null)
            {
                s = a;
            } else
            {
                s = context.getPackageName();
            }
            if (b != null)
            {
                s1 = b;
            } else
            {
                s1 = context.getPackageName();
            }
            if (l1 == null)
            {
                l1 = (new com.google.android.gms.location.places.l.a()).a();
            }
            return new i(context, looper, h1, b1, c, s, s1, l1);
        }

        public a(String s, String s1)
        {
            a = s;
            b = s1;
        }
    }


    private final PlacesParams a;
    private final Locale b = Locale.getDefault();

    public i(Context context, Looper looper, h h1, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c, String s, String s1, 
            com.google.android.gms.location.places.l l1)
    {
        super(context, looper, 67, h1, b1, c);
        context = null;
        if (h1.b() != null)
        {
            context = h1.b().name;
        }
        a = new PlacesParams(s, b, context, l1.a, s1);
    }

    protected d a(IBinder ibinder)
    {
        return d.a.a(ibinder);
    }

    protected IInterface zzV(IBinder ibinder)
    {
        return a(ibinder);
    }

    protected String zzfA()
    {
        return "com.google.android.gms.location.places.PlaceDetectionApi";
    }

    protected String zzfB()
    {
        return "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService";
    }
}
