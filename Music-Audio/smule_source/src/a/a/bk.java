// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

// Referenced classes of package a.a:
//            bd, be

public final class bk
    implements bd
{

    private Double a;

    public bk()
    {
        a = null;
        be.b();
        double d1 = 1.0D;
        Intent intent = be.b().getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int i = intent.getIntExtra("level", -1);
        double d2 = intent.getIntExtra("scale", -1);
        double d = d1;
        if (i >= 0)
        {
            d = d1;
            if (d2 > 0.0D)
            {
                d = (double)i / d2;
            }
        }
        a = Double.valueOf(d);
    }

    public final String a()
    {
        return "battery_level";
    }

    public final volatile Object b()
    {
        return a;
    }
}
