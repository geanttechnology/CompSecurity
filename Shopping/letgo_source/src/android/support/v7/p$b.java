// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

// Referenced classes of package android.support.v7:
//            p

private static class b
{

    final IntentFilter a;
    final BroadcastReceiver b;
    boolean c;

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("Receiver{");
        stringbuilder.append(b);
        stringbuilder.append(" filter=");
        stringbuilder.append(a);
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    stReceiver(IntentFilter intentfilter, BroadcastReceiver broadcastreceiver)
    {
        a = intentfilter;
        b = broadcastreceiver;
    }
}
