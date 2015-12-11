// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;

public final class adc
    implements ServiceConnection
{

    final acy a;

    public adc(acy acy1)
    {
        a = acy1;
        super();
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        a.c(ibinder);
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        a.b.sendMessage(a.b.obtainMessage(4, Integer.valueOf(1)));
    }
}
