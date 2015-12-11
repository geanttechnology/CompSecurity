// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.util.Map;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            av

public class a
{

    private static final String a = com/smule/pianoandroid/magicpiano/a.getName();
    private static a b = new a();

    private a()
    {
    }

    public static a a()
    {
        return b;
    }

    private Integer b(Context context)
    {
        Object obj = com.smule.android.network.managers.a.a(context).a("latency", "devices", null);
        if (obj != null)
        {
            obj = (Integer)((Map) (obj)).get(Build.MODEL);
            if (obj != null)
            {
                av.b(context, true);
                av.b(context, ((Integer) (obj)).intValue());
                Log.i(a, (new StringBuilder()).append("Found default latency: ").append(obj).toString());
                return ((Integer) (obj));
            }
        }
        Log.i(a, "no default found for this device, using default: 250");
        return Integer.valueOf(250);
    }

    public Integer a(Context context)
    {
        if (av.e(context))
        {
            return Integer.valueOf(av.d(context));
        } else
        {
            return b(context);
        }
    }

}
