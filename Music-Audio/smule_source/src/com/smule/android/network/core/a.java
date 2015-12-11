// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.core;

import android.os.Handler;
import com.smule.android.c.aa;
import java.lang.reflect.Method;

// Referenced classes of package com.smule.android.network.core:
//            b, u

public class a
{

    private static final String a = com/smule/android/network/core/a.getName();

    public a()
    {
    }

    public static void a(u u1, Object obj)
    {
        if (u1 == null)
        {
            return;
        }
        try
        {
            if ((com.smule.android.a.a)u1.getClass().getMethod("handleResponse", new Class[] {
    obj.getClass()
}).getAnnotation(com/smule/android/a/a) != null)
            {
                aa.a(a, "Running on UI thread");
                b.e().post(new Runnable(u1, obj) {

                    final u a;
                    final Object b;

                    public void run()
                    {
                        a.handleResponse(b);
                    }

            
            {
                a = u1;
                b = obj;
                super();
            }
                });
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (u u1)
        {
            u1.printStackTrace();
            throw new RuntimeException(u1);
        }
        aa.a(a, "Running off UI thread");
        u1.handleResponse(obj);
        return;
    }

}
