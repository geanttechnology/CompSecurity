// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.e;
import com.google.android.gms.common.f;
import com.google.android.gms.common.g;
import java.io.IOException;
import java.util.UUID;

// Referenced classes of package com.wishabi.flipp.b:
//            a

public final class h extends AsyncTask
{

    final SharedPreferences a;
    final a b;

    public h(a a1, SharedPreferences sharedpreferences)
    {
        b = a1;
        a = sharedpreferences;
        super();
    }

    private transient com.google.android.gms.ads.identifier.AdvertisingIdClient.Info a()
    {
        if (g.a(com.wishabi.flipp.b.a.f(b)) != 0)
        {
            return null;
        }
        com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info;
        try
        {
            info = AdvertisingIdClient.getAdvertisingIdInfo(com.wishabi.flipp.b.a.f(b));
        }
        catch (IOException ioexception)
        {
            return null;
        }
        catch (e e1)
        {
            return null;
        }
        catch (f f1)
        {
            return null;
        }
        return info;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (com.google.android.gms.ads.identifier.AdvertisingIdClient.Info)obj;
        if (obj != null)
        {
            com.wishabi.flipp.b.a.b(b, ((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) (obj)).getId());
            com.wishabi.flipp.b.a.a(b, ((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) (obj)).isLimitAdTrackingEnabled());
            (new StringBuilder("AdvertisingId:")).append(com.wishabi.flipp.b.a.g(b)).append(" isLat:").append(com.wishabi.flipp.b.a.h(b));
            a.edit().putString("advertising_id", com.wishabi.flipp.b.a.g(b)).putBoolean("is_lat", com.wishabi.flipp.b.a.h(b)).commit();
            return;
        } else
        {
            com.wishabi.flipp.b.a.a(b, UUID.fromString(a.getString("uuid", UUID.randomUUID().toString())));
            a.edit().putString("uuid", com.wishabi.flipp.b.a.i(b).toString()).commit();
            return;
        }
    }
}
