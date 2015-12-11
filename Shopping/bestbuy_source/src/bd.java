// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Writer;

final class bd
    implements al
{

    private final Writer a;
    private final be e = new be(this);

    bd(Writer writer)
    {
        a = writer;
    }

    private bd a(StackTraceElement stacktraceelement)
    {
        return b().a("c", stacktraceelement.getClassName()).a().a("m", stacktraceelement.getMethodName()).a().a("f", stacktraceelement.getFileName()).a().a("l", stacktraceelement.getLineNumber()).c();
    }

    private bd a(Throwable throwable, int i, boolean flag)
    {
        if (i > 4)
        {
            return this;
        }
        b().a("exceptionClassName", throwable.getClass().getName()).a().a("message", throwable.getMessage());
        if (throwable.getCause() != null)
        {
            a().a("cause");
            a.append(": ");
            a(throwable.getCause(), i + 1, flag);
        }
        a().a("stackTraceElements");
        a.append(": ");
        d();
        StackTraceElement astacktraceelement[] = throwable.getStackTrace();
        int j = astacktraceelement.length - 1;
        for (i = 0; i < j; i++)
        {
            a(astacktraceelement[i]).a();
        }

        a(astacktraceelement[j]);
        e();
        if (flag)
        {
            throwable = bc.a(throwable);
            if (throwable.length > 0)
            {
                a().a("suppressed");
                a.append(":");
                d();
                for (i = 0; i < throwable.length - 1; i++)
                {
                    a(throwable[i], 0, false).a();
                }

                a(throwable[throwable.length - 1], 0, false);
                e();
            }
        }
        return c();
    }

    static Writer a(bd bd1)
    {
        return bd1.a;
    }

    public final bd a()
    {
        a.append(",");
        return this;
    }

    public final bd a(String s)
    {
        a.append("\"");
        e.append(s);
        a.append("\"");
        return this;
    }

    public final bd a(String s, long l)
    {
        a.append("\"").append(s).append("\": ").append(String.valueOf(l));
        return this;
    }

    public final bd a(String s, String s1)
    {
        bd bd1 = a(s).f();
        s = s1;
        if (s1 == null)
        {
            s = "";
        }
        return bd1.a(s);
    }

    public final bd a(Throwable throwable, boolean flag)
    {
        return a(throwable, 0, true);
    }

    public final bd b()
    {
        a.append("{");
        return this;
    }

    public final bd c()
    {
        a.append("}");
        return this;
    }

    public final bd d()
    {
        a.append("[");
        return this;
    }

    public final bd e()
    {
        a.append("]");
        return this;
    }

    public final bd f()
    {
        a.append(": ");
        return this;
    }
}
