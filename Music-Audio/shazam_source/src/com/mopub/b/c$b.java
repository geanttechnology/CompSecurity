// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.WindowManager;

// Referenced classes of package com.mopub.b:
//            c

public final class c extends BroadcastReceiver
{

    public Context a;
    final c b;
    private int c;

    public final void onReceive(Context context, Intent intent)
    {
        if (a != null && "android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction()))
        {
            int i = ((WindowManager)b.a.getSystemService("window")).getDefaultDisplay().getRotation();
            if (i != c)
            {
                c = i;
                b.a(null);
                return;
            }
        }
    }

    Intent(c c1)
    {
        b = c1;
        super();
        c = -1;
    }
}
