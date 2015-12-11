// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.k;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

// Referenced classes of package com.shazam.android.k:
//            k, j

final class Receiver extends BroadcastReceiver
{

    final k a;

    public final void onReceive(Context context, Intent intent)
    {
        (new StringBuilder("Error loading resource Uri: ")).append(a.a.toString());
        (new StringBuilder("Error intent: ")).append(intent.toUri(1));
        a.b = intent.getExtras();
        if (a.d != null)
        {
            a.d.r = false;
            a.d.i();
        }
    }

    Receiver(k k1)
    {
        a = k1;
        super();
    }
}
