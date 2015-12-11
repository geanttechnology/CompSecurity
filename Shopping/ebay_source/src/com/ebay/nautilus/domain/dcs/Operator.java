// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


final class Operator extends Enum
{

    private static final Operator $VALUES[];
    public static final Operator And;
    public static final Operator Equal;
    public static final Operator GreaterThan;
    public static final Operator GreaterThanOrEqual;
    public static final Operator In;
    public static final Operator LessThan;
    public static final Operator LessThanOrEqual;
    public static final Operator Not;
    public static final Operator NotEqual;
    public static final Operator Or;
    public static final Operator RegexMatch;
    public final int priority;
    public final String symbol;

    private Operator(String s, int i, String s1, int j)
    {
        super(s, i);
        symbol = s1;
        priority = j;
    }

    public static Operator valueOf(String s)
    {
        return (Operator)Enum.valueOf(com/ebay/nautilus/domain/dcs/Operator, s);
    }

    public static Operator[] values()
    {
        return (Operator[])$VALUES.clone();
    }

    static 
    {
        Or = new Operator("Or", 0, "|", 1);
        And = new Operator("And", 1, "&", 2);
        Equal = new Operator("Equal", 2, "=", 3);
        NotEqual = new Operator("NotEqual", 3, "!=", 3);
        LessThan = new Operator("LessThan", 4, "<", 3);
        LessThanOrEqual = new Operator("LessThanOrEqual", 5, "<=", 3);
        GreaterThan = new Operator("GreaterThan", 6, ">", 3);
        GreaterThanOrEqual = new Operator("GreaterThanOrEqual", 7, ">=", 3);
        RegexMatch = new Operator("RegexMatch", 8, "=~", 3);
        In = new Operator("In", 9, "in", 3);
        Not = new Operator("Not", 10, "!", 4);
        $VALUES = (new Operator[] {
            Or, And, Equal, NotEqual, LessThan, LessThanOrEqual, GreaterThan, GreaterThanOrEqual, RegexMatch, In, 
            Not
        });
    }
}
