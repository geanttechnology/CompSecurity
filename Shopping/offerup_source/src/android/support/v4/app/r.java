// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.support.v4.e.a;
import e.b.i;

public class r extends RuntimeException
{

    public r(String s)
    {
        super(s);
    }

    public r(String s, Exception exception)
    {
        super(s, exception);
    }

    public static Throwable a(Throwable throwable, Object obj)
    {
        int j = 0;
        Object obj1 = throwable;
        do
        {
label0:
            {
                if (((Throwable) (obj1)).getCause() != null)
                {
                    if (j < 25)
                    {
                        break label0;
                    }
                    obj1 = new RuntimeException("Stack too deep to get final cause");
                }
                if (obj1 != null && (obj1 instanceof i) && ((i)obj1).a() == obj)
                {
                    return throwable;
                } else
                {
                    android.support.v4.e.a.a(throwable, new i(obj));
                    return throwable;
                }
            }
            obj1 = ((Throwable) (obj1)).getCause();
            j++;
        } while (true);
    }
}
