// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.PrintStream;
import java.io.PrintWriter;

// Referenced classes of package com.flurry.sdk:
//            kg

public abstract class ly
    implements Runnable
{

    private static final String a = com/flurry/sdk/ly.getSimpleName();
    PrintStream h;
    PrintWriter i;

    public ly()
    {
    }

    public abstract void a();

    public final void run()
    {
        try
        {
            a();
            return;
        }
        catch (Throwable throwable)
        {
            if (h != null)
            {
                throwable.printStackTrace(h);
            } else
            if (i != null)
            {
                throwable.printStackTrace(i);
            } else
            {
                throwable.printStackTrace();
            }
        }
        kg.a(6, a, "", throwable);
    }

}
