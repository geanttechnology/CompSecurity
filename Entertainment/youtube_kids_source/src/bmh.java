// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public final class bmh
{

    private static final IntentFilter a = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private final Context b;

    public bmh(Context context)
    {
        b = (Context)b.a(context);
    }

    public final float a()
    {
        Bundle bundle = b();
        float f = bundle.getInt("level", -1);
        float f1 = bundle.getInt("scale", -1);
        if (f < 0.0F || f1 <= 0.0F)
        {
            return -1F;
        } else
        {
            return f / f1;
        }
    }

    public Bundle b()
    {
        Intent intent = b.registerReceiver(null, a);
        if (intent == null)
        {
            return new Bundle();
        } else
        {
            return intent.getExtras();
        }
    }

}
