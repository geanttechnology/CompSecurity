// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.e;

// Referenced classes of package com.google.android.gms.internal:
//            da, v, db, ah, 
//            ab, be, ag

public final class y extends e
{

    private static final y ld = new y();

    private y()
    {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public static ag a(Context context, ab ab, String s, be be)
    {
        Object obj;
label0:
        {
            if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0)
            {
                ag ag = ld.b(context, ab, s, be);
                obj = ag;
                if (ag != null)
                {
                    break label0;
                }
            }
            da.s("Using AdManager from the client jar.");
            obj = new v(context, ab, s, be, new db(0x41f6b8, 0x41f6b8, true));
        }
        return ((ag) (obj));
    }

    private ag b(Context context, ab ab, String s, be be)
    {
        try
        {
            com.google.android.gms.dynamic.b b1 = com.google.android.gms.dynamic.c.h(context);
            context = ag.a.f(((ah)z(context)).a(b1, ab, s, be, 0x41f6b8));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            da.b("Could not create remote AdManager.", context);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            da.b("Could not create remote AdManager.", context);
            return null;
        }
        return context;
    }

    protected ah c(IBinder ibinder)
    {
        return ah.a.g(ibinder);
    }

    protected Object d(IBinder ibinder)
    {
        return c(ibinder);
    }

}
