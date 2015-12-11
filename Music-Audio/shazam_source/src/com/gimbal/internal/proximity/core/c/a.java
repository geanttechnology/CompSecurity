// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.gimbal.internal.c.c;
import com.gimbal.internal.proximity.core.sighting.b;

public class a extends com.gimbal.internal.e.a
{

    private static final com.gimbal.a.a b = com.gimbal.internal.c.c.e(com/gimbal/internal/proximity/core/c/a.getName());
    private b c;

    public a(com.gimbal.internal.persistance.b b1, Context context, b b2)
    {
        super(b1, context, new IntentFilter[] {
            new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED")
        });
        c = b2;
    }

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED"))
        {
            int i = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0x80000000);
            if (i == 10 || i == 12)
            {
                context = c;
                if (((b) (context)).b != null)
                {
                    if (i == 10)
                    {
                        context.b();
                    } else
                    if (i == 12)
                    {
                        context.a();
                        return;
                    }
                }
            }
        }
    }

}
