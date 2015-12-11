// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.IBinder;

public abstract class ayl
{

    private final String a;
    private Object b;

    public ayl(String s)
    {
        a = s;
    }

    public final Object a(Context context)
    {
        if (b == null)
        {
            a.d(context);
            context = avw.c(context);
            if (context == null)
            {
                throw new aym("Could not get remote context.");
            }
            context = context.getClassLoader();
            try
            {
                b = a((IBinder)context.loadClass(a).newInstance());
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new aym("Could not load creator class.", context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new aym("Could not instantiate creator.", context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new aym("Could not access creator.", context);
            }
        }
        return b;
    }

    public abstract Object a(IBinder ibinder);
}
