// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bo.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import myobfuscated.i.a;

// Referenced classes of package bo.app:
//            bs, az

final class bt extends BroadcastReceiver
{

    final bs a;

    bt(bs bs1)
    {
        a = bs1;
        super();
    }

    public final void onReceive(Context context, Intent intent)
    {
        context = ((Context) (bo.app.bs.a(a)));
        context;
        JVM INSTR monitorenter ;
        bs.b(a);
_L1:
        return;
        intent;
        bs.c(a).a(intent, java/lang/Throwable);
          goto _L1
        intent;
        myobfuscated.i.a.c(bs.f(), "Failed to log throwable.", intent);
          goto _L1
        intent;
        throw intent;
    }
}
