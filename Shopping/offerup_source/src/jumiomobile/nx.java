// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


public class nx extends Exception
{

    public nx(Exception exception, String s)
    {
        super(s);
        if (exception != null)
        {
            setStackTrace(exception.getStackTrace());
        }
    }

    public nx(String s)
    {
        this(null, s);
    }
}
