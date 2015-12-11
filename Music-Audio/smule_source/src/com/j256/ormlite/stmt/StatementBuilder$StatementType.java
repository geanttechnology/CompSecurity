// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt;


public final class okForStatementBuilder extends Enum
{

    private static final EXECUTE $VALUES[];
    public static final EXECUTE DELETE;
    public static final EXECUTE EXECUTE;
    public static final EXECUTE SELECT;
    public static final EXECUTE SELECT_LONG;
    public static final EXECUTE SELECT_RAW;
    public static final EXECUTE UPDATE;
    private final boolean okForStatementBuilder;

    public static okForStatementBuilder valueOf(String s)
    {
        return (okForStatementBuilder)Enum.valueOf(com/j256/ormlite/stmt/StatementBuilder$StatementType, s);
    }

    public static okForStatementBuilder[] values()
    {
        return (okForStatementBuilder[])$VALUES.clone();
    }

    public boolean isOkForStatementBuilder()
    {
        return okForStatementBuilder;
    }

    static 
    {
        SELECT = new <init>("SELECT", 0, true);
        SELECT_LONG = new <init>("SELECT_LONG", 1, true);
        SELECT_RAW = new <init>("SELECT_RAW", 2, true);
        UPDATE = new <init>("UPDATE", 3, true);
        DELETE = new <init>("DELETE", 4, true);
        EXECUTE = new <init>("EXECUTE", 5, false);
        $VALUES = (new .VALUES[] {
            SELECT, SELECT_LONG, SELECT_RAW, UPDATE, DELETE, EXECUTE
        });
    }

    private (String s, int i, boolean flag)
    {
        super(s, i);
        okForStatementBuilder = flag;
    }
}
