// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk;

import android.content.Context;
import com.immersion.content.EndpointWarp;
import com.immersion.hapticmediasdk.b.b;

// Referenced classes of package com.immersion.hapticmediasdk:
//            d, a

public class c
{

    public static int a = 19;
    public static int b = 1;
    public static int c = 2;

    public static a a(int i, Context context)
    {
_L2:
        context = new d(context);
        i = context.b();
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
                com.immersion.hapticmediasdk.b.b.d("HapticContentSDKFactory", context.append("Failed to create Haptic Content SDK instance. error=").append(i).toString());
                break;
            }
            return null;
        } else
        {
            com.immersion.hapticmediasdk.b.b.b("HapticContentSDKFactory", "Haptic Content SDK instance was created successfully");
            return context;
        }
        if (!EndpointWarp.f())
        {
            return null;
        }
        if (context == null)
        {
            com.immersion.hapticmediasdk.b.b.d("HapticContentSDKFactory", "Failed to create a Haptic Content SDK instance. invalid context: null");
            return null;
        }
        switch (i)
        {
        default:
            break; /* Loop/switch isn't completed */

        case 0: // '\0'
            break;
        }
        if (true) goto _L2; else goto _L1
_L1:
label0:
        do
        {
            switch (1)
            {
            default:
                while (true) 
                {
                    switch (1)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        continue label0;

                    case 1: // '\001'
                        break label0;
                    }
                }
                break;

            case 0: // '\0'
                break;

            case 1: // '\001'
                break label0;
            }
        } while (true);
        com.immersion.hapticmediasdk.b.b.d("HapticContentSDKFactory", "Failed to create a Haptic Content SDK instance. Invalid mode");
        return null;
    }
}
