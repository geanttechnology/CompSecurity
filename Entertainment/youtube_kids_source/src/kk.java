// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class kk extends BroadcastReceiver
{

    private ki a;

    kk(ki ki1)
    {
        a = ki1;
        super();
    }

    public final void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION") && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3)
        {
            int i = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", -1);
            if (i >= 0 && i != ki.c(a))
            {
                ki.b(a);
            }
        }
    }
}
