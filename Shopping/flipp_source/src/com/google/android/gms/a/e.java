// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.a;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.g;
import com.google.android.gms.internal.ha;

// Referenced classes of package com.google.android.gms.a:
//            f

public abstract class e
{

    private final String a;
    private Object b;

    public e(String s)
    {
        a = s;
    }

    public final Object a(Context context)
    {
        if (b == null)
        {
            ha.a(context);
            context = g.c(context);
            if (context == null)
            {
                throw new f("Could not get remote context.");
            }
            context = context.getClassLoader();
            try
            {
                b = a((IBinder)context.loadClass(a).newInstance());
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new f("Could not load creator class.");
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new f("Could not instantiate creator.");
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new f("Could not access creator.");
            }
        }
        return b;
    }

    public abstract Object a(IBinder ibinder);
}
