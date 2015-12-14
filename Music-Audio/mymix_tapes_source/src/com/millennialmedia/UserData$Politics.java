// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;


// Referenced classes of package com.millennialmedia:
//            UserData

public static final class value extends Enum
{

    private static final OTHER $VALUES[];
    public static final OTHER CONSERVATIVE;
    public static final OTHER DEMOCRAT;
    public static final OTHER INDEPENDENT;
    public static final OTHER LIBERAL;
    public static final OTHER MODERATE;
    public static final OTHER OTHER;
    public static final OTHER REPUBLICAN;
    public final String value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/millennialmedia/UserData$Politics, s);
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    static 
    {
        REPUBLICAN = new <init>("REPUBLICAN", 0, "republican");
        DEMOCRAT = new <init>("DEMOCRAT", 1, "democrat");
        CONSERVATIVE = new <init>("CONSERVATIVE", 2, "conservative");
        MODERATE = new <init>("MODERATE", 3, "moderate");
        LIBERAL = new <init>("LIBERAL", 4, "liberal");
        INDEPENDENT = new <init>("INDEPENDENT", 5, "independent");
        OTHER = new <init>("OTHER", 6, "other");
        $VALUES = (new .VALUES[] {
            REPUBLICAN, DEMOCRAT, CONSERVATIVE, MODERATE, LIBERAL, INDEPENDENT, OTHER
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }
}
