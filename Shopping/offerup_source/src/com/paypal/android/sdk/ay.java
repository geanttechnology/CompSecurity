// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

// Referenced classes of package com.paypal.android.sdk:
//            y, ax

final class ay
    implements Runnable
{

    private Context a;
    private y b;

    ay(Context context, y y1)
    {
        a = context;
        b = y1;
        super();
    }

    public final void run()
    {
        try
        {
            com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo(a);
            b.Y = info.getId();
            return;
        }
        catch (Throwable throwable)
        {
            ax.h();
            throwable.getLocalizedMessage();
            ax.a();
            return;
        }
    }
}
