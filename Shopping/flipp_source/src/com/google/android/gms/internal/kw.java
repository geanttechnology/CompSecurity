// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.a.d;
import com.google.android.gms.a.e;
import com.google.android.gms.a.f;
import com.google.android.gms.common.g;

// Referenced classes of package com.google.android.gms.internal:
//            et, kr, cu, i, 
//            g, j, x, bl, 
//            f

public final class kw extends e
{

    private static final kw a = new kw();

    private kw()
    {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public static com.google.android.gms.internal.f a(Context context, x x, String s, bl bl)
    {
        Object obj;
label0:
        {
            if (g.a(context) == 0)
            {
                com.google.android.gms.internal.f f1 = a.b(context, x, s, bl);
                obj = f1;
                if (f1 != null)
                {
                    break label0;
                }
            }
            et.a("Using AdManager from the client jar.");
            obj = new kr(context, x, s, bl, new cu());
        }
        return ((com.google.android.gms.internal.f) (obj));
    }

    private com.google.android.gms.internal.f b(Context context, x x, String s, bl bl)
    {
        try
        {
            com.google.android.gms.a.a a1 = d.a(context);
            context = g.a(((i)a(context)).a(a1, x, s, bl, 0x40ba50));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            et.a("Could not create remote AdManager.", context);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            et.a("Could not create remote AdManager.", context);
            return null;
        }
        return context;
    }

    protected final Object a(IBinder ibinder)
    {
        return j.a(ibinder);
    }

}
