// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common;


public final class c extends Enum
{

    private static final c $VALUES[];
    public static final c Fax;
    public static final c Home;
    public static final c Main;
    public static final c Mobile;
    public static final c Other;
    public static final c Work;
    private String mValue;

    private c(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static c a(String s)
    {
        if (s != null)
        {
            c ac[] = values();
            int j = ac.length;
            for (int i = 0; i < j; i++)
            {
                c c1 = ac[i];
                if (s.equalsIgnoreCase(c1.mValue))
                {
                    return c1;
                }
            }

        }
        return Other;
    }

    public static c valueOf(String s)
    {
        return (c)Enum.valueOf(com/target/mothership/model/common/c, s);
    }

    public static c[] values()
    {
        return (c[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        Home = new c("Home", 0, "Home");
        Mobile = new c("Mobile", 1, "Mobile");
        Work = new c("Work", 2, "Work");
        Other = new c("Other", 3, "Other");
        Main = new c("Main", 4, "Main");
        Fax = new c("Fax", 5, "Fax");
        $VALUES = (new c[] {
            Home, Mobile, Work, Other, Main, Fax
        });
    }
}
