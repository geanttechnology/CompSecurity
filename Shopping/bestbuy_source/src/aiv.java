// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.RemoteException;

public final class aiv
{

    public static int a(Context context)
    {
        ady.a(context);
        try
        {
            context = anf.a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return ((ps) (context)).a;
        }
        a(((akw) (context)));
        return 0;
    }

    public static void a(akw akw1)
    {
        try
        {
            ail.a(akw1.a());
            ani.a(akw1.b());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (akw akw1)
        {
            throw new anl(akw1);
        }
    }
}
