// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bo.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import myobfuscated.i.a;

// Referenced classes of package bo.app:
//            s, y, az

final class t extends BroadcastReceiver
{

    final az a;
    final s b;

    t(s s1, az az)
    {
        b = s1;
        a = az;
        super();
    }

    public final void onReceive(Context context, Intent intent)
    {
        try
        {
            context = (ConnectivityManager)context.getSystemService("connectivity");
            bo.app.s.a(b).a(intent, context);
            b.c();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            myobfuscated.i.a.c(s.d(), "Failed to process connectivity event.", context);
        }
        bo.app.s.a(a, context);
    }
}
