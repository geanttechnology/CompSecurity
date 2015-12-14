// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.inmobi.commons.core.utilities.Logger;

// Referenced classes of package com.inmobi.rendering.mraid:
//            MraidMediaProcessor

public final class b extends BroadcastReceiver
{

    final MraidMediaProcessor a;
    private String b;

    public void onReceive(Context context, Intent intent)
    {
        boolean flag = true;
        if (intent != null && "android.intent.action.HEADSET_PLUG".equals(intent.getAction()))
        {
            int i = intent.getIntExtra("state", 0);
            Logger.a(com.inmobi.commons.core.utilities., MraidMediaProcessor.j(), (new StringBuilder()).append("Headphone plugged state changed: ").append(i).toString());
            context = a;
            intent = b;
            if (1 != i)
            {
                flag = false;
            }
            MraidMediaProcessor.b(context, intent, flag);
        }
    }

    public (MraidMediaProcessor mraidmediaprocessor, String s)
    {
        a = mraidmediaprocessor;
        super();
        b = s;
    }
}
