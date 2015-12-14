// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.utility;


// Referenced classes of package com.perfectcorp.utility:
//            e

public class b
    implements Thread.UncaughtExceptionHandler
{

    private Thread.UncaughtExceptionHandler a;

    public b()
    {
        a = Thread.getDefaultUncaughtExceptionHandler();
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        StackTraceElement astacktraceelement[] = throwable.getStackTrace();
        String s = (new StringBuilder()).append(throwable.toString()).append("\n\n").toString();
        s = (new StringBuilder()).append(s).append("--------- Stack trace ---------\n").toString();
        for (int i = 0; i < astacktraceelement.length; i++)
        {
            s = (new StringBuilder()).append(s).append("   ").append(astacktraceelement[i].toString()).append("\n").toString();
        }

        s = (new StringBuilder()).append(s).append("-------------------------------\n\n").toString();
        s = (new StringBuilder()).append(s).append("--------- Cause ---------\n\n").toString();
        Object obj = throwable.getCause();
        if (obj != null)
        {
            s = (new StringBuilder()).append(s).append(((Throwable) (obj)).toString()).append("\n\n").toString();
            StackTraceElement astacktraceelement1[] = ((Throwable) (obj)).getStackTrace();
            int j = 0;
            do
            {
                obj = s;
                if (j >= astacktraceelement1.length)
                {
                    break;
                }
                s = (new StringBuilder()).append(s).append("    ").append(astacktraceelement1[j].toString()).append("\n").toString();
                j++;
            } while (true);
        } else
        {
            obj = (new StringBuilder()).append(s).append("There is no cause for exception. \n").toString();
        }
        e.g(new Object[] {
            (new StringBuilder()).append(((String) (obj))).append("-------------------------------\n\n").toString()
        });
        a.uncaughtException(thread, throwable);
    }
}
