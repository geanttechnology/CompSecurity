// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Locale;

public final class cge extends Enum
{

    public static final cge a;
    public static final cge b;
    private static final cge c[];

    private cge(String s, int i)
    {
        super(s, i);
    }

    public static cge a(String s)
    {
        if (s == null)
        {
            return null;
        }
        try
        {
            s = valueOf(s.toUpperCase(Locale.US));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static cge valueOf(String s)
    {
        return (cge)Enum.valueOf(cge, s);
    }

    public static cge[] values()
    {
        return (cge[])c.clone();
    }

    static 
    {
        a = new cge("PERMANENT", 0);
        b = new cge("TEMPORARY", 1);
        c = (new cge[] {
            a, b
        });
    }
}
