// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.crashlytics.android.Crashlytics;

public class ij extends aqo.a
{

    public ij()
    {
    }

    private transient void e(String s, Object aobj[])
    {
        Crashlytics.log(String.format(s, aobj));
    }

    protected void a(int i, String s, String s1, Throwable throwable)
    {
        if (i != 2 && i != 3)
        {
            Crashlytics.log(i, s, s1);
            if (throwable != null)
            {
                if (i == 6)
                {
                    Crashlytics.logException(throwable);
                    return;
                }
                if (i == 5)
                {
                    Crashlytics.log(throwable.getMessage());
                    return;
                }
            }
        }
    }

    public transient void a(String s, Object aobj[])
    {
        e(s, aobj);
    }

    public transient void a(Throwable throwable, String s, Object aobj[])
    {
        e((new StringBuilder()).append("WARN: ").append(s).toString(), aobj);
    }

    public transient void b(String s, Object aobj[])
    {
        e((new StringBuilder()).append("WARN: ").append(s).toString(), aobj);
    }

    public transient void b(Throwable throwable, String s, Object aobj[])
    {
        e((new StringBuilder()).append("ERROR: ").append(s).toString(), aobj);
        Crashlytics.logException(throwable);
    }

    public transient void c(String s, Object aobj[])
    {
        e((new StringBuilder()).append("ERROR: ").append(s).toString(), aobj);
    }
}
