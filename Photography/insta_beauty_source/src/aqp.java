// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;

class aqp extends BroadcastReceiver
{

    final aqo a;

    aqp(aqo aqo1)
    {
        a = aqo1;
        super();
    }

    public void onReceive(Context context, Intent intent)
    {
        if (aqo.a(a).getBoolean("has_token", false) && aqo.b(a) != null && aqo.b(a).get() != null)
        {
            context = aqo.a(a).getString("token", "");
            ((anz)aqo.b(a).get()).b(context);
        }
    }
}
