// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;


public final class at extends Enum
{

    public static final at a;
    public static final at b;
    public static final at c;
    public static final at d;
    private static final at g[];
    private final String e;
    private final String f;

    private at(String s, int i, String s1, String s2)
    {
        super(s, i);
        e = s1;
        f = s2;
    }

    public static at a(String s)
    {
        if (s.matches("[0-9a-fA-F]+")) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if (s.length() == 24)
        {
            return a;
        }
        if (s.length() == 40)
        {
            s = s.substring(s.length() - 8);
            at aat[] = values();
            int j = aat.length;
            int i = 0;
            while (i < j) 
            {
                at at1 = aat[i];
                if (s.equals(at1.e))
                {
                    return at1;
                }
                i++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static at valueOf(String s)
    {
        return (at)Enum.valueOf(a/a/at, s);
    }

    public static at[] values()
    {
        return (at[])g.clone();
    }

    public final String a()
    {
        return f;
    }

    static 
    {
        a = new at("US_WEST_1_PROD", 0, "00555300", "crittercism.com");
        b = new at("US_WEST_2_CI", 1, "00555304", "crit-ci.com");
        c = new at("US_WEST_2_STAGING", 2, "00555305", "crit-staging.com");
        d = new at("EU_CENTRAL_1", 3, "00444503", "eu.crittercism.com");
        g = (new at[] {
            a, b, c, d
        });
    }
}
