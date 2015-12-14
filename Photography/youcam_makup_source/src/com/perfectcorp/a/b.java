// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.a;

import android.content.Context;
import android.os.AsyncTask;
import com.cyberlink.uma.UMA;
import com.perfectcorp.utility.e;

// Referenced classes of package com.perfectcorp.a:
//            a

public class b
{

    public static void a()
    {
        if (c())
        {
            return;
        } else
        {
            UMA.a();
            return;
        }
    }

    public static void a(Context context, String s)
    {
        if (!context.getApplicationContext().getPackageName().equals("com.perfectcorp.beautycircle"))
        {
            e.b(new Object[] {
                "Don't do init again if beauty circle is library mode"
            });
        } else
        if (!c())
        {
            UMA.a(context, "https://clad.cyberlink.com", s);
            return;
        }
    }

    public static void a(a a1)
    {
        if (a1 == null)
        {
            e.d(new Object[] {
                "event = null"
            });
        } else
        {
            e.b(new Object[] {
                (new StringBuilder()).append("recordEvent name=").append(a1.a()).append(", Parameters is ").append(a1.b()).append(", Count: ").append(a1.c()).toString()
            });
            if (!c())
            {
                AsyncTask.execute(new Runnable(a1) {

                    final a a;

                    public void run()
                    {
                        if (a.b() == null)
                        {
                            e.d(new Object[] {
                                "Parameters is null"
                            });
                            UMA.a(a.a());
                            return;
                        } else
                        {
                            UMA.a(a.a(), a.b(), a.c());
                            return;
                        }
                    }

            
            {
                a = a1;
                super();
            }
                });
                return;
            }
        }
    }

    public static void b()
    {
        if (c())
        {
            return;
        } else
        {
            UMA.b();
            return;
        }
    }

    private static boolean c()
    {
        boolean flag = e.a;
        if (flag)
        {
            e.b(new Object[] {
                "isDebuggable=", Boolean.valueOf(flag)
            });
        }
        return flag;
    }
}
