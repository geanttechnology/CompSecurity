// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.net.http.AndroidHttpClient;
import android.util.Log;
import org.apache.http.conn.ClientConnectionManager;

// Referenced classes of package com.tapjoy.internal:
//            fk

final class a
    implements Runnable
{

    final AndroidHttpClient a;
    final fk b;

    public final void run()
    {
        if (a == null)
        {
            return;
        }
        try
        {
            a.close();
            a.getConnectionManager().shutdown();
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            Log.e(fk.f(), "Swallowing", runtimeexception);
        }
    }

    ttpClient(fk fk1, AndroidHttpClient androidhttpclient)
    {
        b = fk1;
        super();
        a = androidhttpclient;
    }
}
