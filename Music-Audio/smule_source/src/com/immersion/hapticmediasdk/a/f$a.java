// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.a;

import android.os.Handler;

// Referenced classes of package com.immersion.hapticmediasdk.a:
//            f, c

public class a
    implements Runnable
{

    public static int b = 92;
    public static int c = 0;
    public static int d = 1;
    public static int e = 2;
    public final f a;

    public static int a()
    {
        return 6;
    }

    public void run()
    {
        if (a.i() && f.d(a) != null)
        {
            f.d(a).b(a.g(), a.h());
            f f1 = a;
            int i = b;
            switch ((i * (d + i)) % e)
            {
            default:
                b = a();
                c = 99;
                // fall through

            case 0: // '\0'
                f.d(f1).f().removeCallbacks(this);
                break;
            }
            f.d(a).f().postDelayed(this, 1000L);
        }
    }

    public (f f1)
    {
        if (((b + d) * b) % e != c)
        {
            b = 15;
            c = 7;
        }
        try
        {
            a = f1;
        }
        // Misplaced declaration of an exception variable
        catch (f f1)
        {
            throw f1;
        }
        try
        {
            super();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (f f1)
        {
            throw f1;
        }
    }
}
