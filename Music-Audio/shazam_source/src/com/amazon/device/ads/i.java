// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;

// Referenced classes of package com.amazon.device.ads:
//            h, ac

public final class i
{

    private static h a = null;

    i()
    {
    }

    public static h a()
    {
        return a;
    }

    public static h a(Context context, ac ac)
    {
        try
        {
            context = new h(context, ac);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    public static void a(h h1)
    {
        a = h1;
    }

    public static h b()
    {
        h h1 = a;
        a = null;
        return h1;
    }

}
