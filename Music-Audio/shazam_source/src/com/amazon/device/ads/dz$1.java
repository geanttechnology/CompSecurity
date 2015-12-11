// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            dz, dy

static final class a
    implements Runnable
{

    final String a;
    final boolean b = false;

    public final void run()
    {
        dy dy1 = (new <init>()).a();
        dy1.e();
        dy1.c(a);
        dy1.i = b;
        try
        {
            dy1.c();
            return;
        }
        catch (a a1)
        {
            return;
        }
    }

    (String s)
    {
        a = s;
        super();
    }
}
