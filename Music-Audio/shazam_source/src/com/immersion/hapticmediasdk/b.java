// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk;

import android.content.Context;
import com.immersion.content.EndpointWarp;

// Referenced classes of package com.immersion.hapticmediasdk:
//            c, a

public final class b
{

    public static int a = 19;
    public static int b = 1;
    public static int c = 2;

    public static a a(Context context)
    {
        if (!EndpointWarp.b())
        {
            return null;
        }
        while (context != null) 
        {
            context = new c(context);
            int i = context.a();
            if (i != 0)
            {
                context = new StringBuilder();
                int j = a;
                switch ((j * (b + j)) % c)
                {
                default:
                    a = 42;
                    b = 92;
                    // fall through

                case 0: // '\0'
                    com.immersion.hapticmediasdk.b.b.a("HapticContentSDKFactory", context.append("Failed to create Haptic Content SDK instance. error=").append(i).toString());
                    break;
                }
                return null;
            } else
            {
                com.immersion.hapticmediasdk.b.b.a();
                return context;
            }
        }
        com.immersion.hapticmediasdk.b.b.a("HapticContentSDKFactory", "Failed to create a Haptic Content SDK instance. invalid context: null");
        return null;
    }
}
