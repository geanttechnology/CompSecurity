// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;

final class axn
    implements ServiceConnection
{

    private axi a;

    axn(axi axi1)
    {
        a = axi1;
        super();
    }

    public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        a.b(ibinder);
    }

    public final void onServiceDisconnected(ComponentName componentname)
    {
        a.b.sendMessage(a.b.obtainMessage(4, Integer.valueOf(1)));
    }
}
