// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.e;
import com.google.android.gms.common.f;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            hq, a, km, kg, 
//            if, kj

public final class ie extends hq
{

    private ie(Context context, kg kg1, kj kj)
    {
        super(context, kg1, kj);
    }

    public static ie a(String s, Context context)
    {
        a a1 = new a();
        a(s, context, ((kg) (a1)));
        return new ie(context, a1, new km());
    }

    private if d(Context context)
    {
        com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info;
label0:
        {
            int i = 0;
            byte abyte0[];
            int j;
            try
            {
                info = AdvertisingIdClient.getAdvertisingIdInfo(context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new IOException(context);
            }
            context = info.getId();
            if (context == null || !context.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$"))
            {
                break label0;
            }
            abyte0 = new byte[16];
            j = 0;
            int k;
            for (; i < context.length(); i = k + 2)
            {
label1:
                {
                    if (i != 8 && i != 13 && i != 18)
                    {
                        k = i;
                        if (i != 23)
                        {
                            break label1;
                        }
                    }
                    k = i + 1;
                }
                abyte0[j] = (byte)((Character.digit(context.charAt(k), 16) << 4) + Character.digit(context.charAt(k + 1), 16));
                j++;
            }

            context = c.a(abyte0);
        }
        return new if(this, context, info.isLimitAdTrackingEnabled());
    }

    protected final void b(Context context)
    {
        long l;
        l = 1L;
        super.b(context);
        context = d(context);
        if (!((if) (context)).b)
        {
            l = 0L;
        }
        a(28, l);
        context = ((if) (context)).a;
        if (context != null)
        {
            try
            {
                a(30, context);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return;
            }
        }
        break MISSING_BLOCK_LABEL_61;
        context;
        a(28, 1L);
        return;
        context;
    }
}
