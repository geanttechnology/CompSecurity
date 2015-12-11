// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;


// Referenced classes of package com.shazam.h:
//            o

public class j extends Exception
{

    private o a;

    public j(Exception exception)
    {
        super(exception);
    }

    public j(String s, o o)
    {
        super(s);
        a = o;
    }

    public j(String s, Exception exception)
    {
        super(s, exception);
    }

    public final o a()
    {
        if (a != null)
        {
            return a;
        } else
        {
            return (new o.a()).a();
        }
    }
}
