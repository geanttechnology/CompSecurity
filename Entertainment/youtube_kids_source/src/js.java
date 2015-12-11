// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class js extends BroadcastReceiver
{

    private jr a;

    js(jr jr1)
    {
        a = jr1;
        super();
    }

    public final void onReceive(Context context, Intent intent)
    {
        jr.a(a);
    }
}
