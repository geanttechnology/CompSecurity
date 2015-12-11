// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class rb extends BroadcastReceiver
{

    final Context a;
    rx b;
    boolean c;
    boolean d;
    private final bje e;

    public rb(Context context, bje bje1)
    {
        a = (Context)b.a(context);
        e = (bje)b.a(bje1);
        d = true;
    }

    public final void onReceive(Context context, Intent intent)
    {
        bmo.e("Audio becoming noisy. Pausing if needed");
        while (!d || b == null) 
        {
            return;
        }
        b.i();
        e.d(new csd());
    }
}
