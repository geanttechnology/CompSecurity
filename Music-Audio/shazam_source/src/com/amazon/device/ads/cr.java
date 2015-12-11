// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.Locale;

// Referenced classes of package com.amazon.device.ads:
//            bp

final class cr
{

    Boolean a;
    bp b;

    cr()
    {
        a = Boolean.valueOf(true);
        b = bp.c;
    }

    public final String toString()
    {
        return String.format(Locale.US, "{\"allowOrientationChange\":%s,\"forceOrientation\":\"%s\"}", new Object[] {
            a.toString(), b.toString()
        });
    }
}
