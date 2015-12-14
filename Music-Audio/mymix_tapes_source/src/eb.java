// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class eb extends dt
    implements el
{

    private static final bm a = d.a(eb);

    public eb(byte abyte0[])
    {
        super((short)29189, abyte0);
    }

    public final String g()
    {
        a.b("PDXQueryRetry.getName()");
        String s = f("name");
        if (s != null)
        {
            return s;
        } else
        {
            return "";
        }
    }

    public final int h()
    {
        a.b("PDXQueryRetry.getCause()");
        int j;
        try
        {
            j = d("cause");
        }
        catch (Exception exception)
        {
            return 0;
        }
        return j;
    }

    public final String i()
    {
        a.b("PDXQueryRetry.getPrompt()");
        String s;
        try
        {
            s = f("prompt");
        }
        catch (Exception exception)
        {
            exception = "";
        }
        if (s != null)
        {
            return s;
        } else
        {
            return "";
        }
    }

}
