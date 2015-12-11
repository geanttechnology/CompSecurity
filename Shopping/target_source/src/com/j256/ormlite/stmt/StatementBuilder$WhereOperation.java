// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt;


// Referenced classes of package com.j256.ormlite.stmt:
//            StatementBuilder

protected static final class after extends Enum
{

    private static final OR $VALUES[];
    public static final OR AND;
    public static final OR FIRST;
    public static final OR OR;
    private final String after;
    private final String before;

    public static after valueOf(String s)
    {
        return (after)Enum.valueOf(com/j256/ormlite/stmt/StatementBuilder$WhereOperation, s);
    }

    public static after[] values()
    {
        return (after[])$VALUES.clone();
    }

    public void appendAfter(StringBuilder stringbuilder)
    {
        if (after != null)
        {
            stringbuilder.append(after);
        }
    }

    public void appendBefore(StringBuilder stringbuilder)
    {
        if (before != null)
        {
            stringbuilder.append(before);
        }
    }

    static 
    {
        FIRST = new <init>("FIRST", 0, "WHERE ", null);
        AND = new <init>("AND", 1, "AND (", ") ");
        OR = new <init>("OR", 2, "OR (", ") ");
        $VALUES = (new .VALUES[] {
            FIRST, AND, OR
        });
    }

    private (String s, int i, String s1, String s2)
    {
        super(s, i);
        before = s1;
        after = s2;
    }
}
