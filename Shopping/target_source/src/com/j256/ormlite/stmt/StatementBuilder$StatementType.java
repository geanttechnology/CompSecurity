// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt;


// Referenced classes of package com.j256.ormlite.stmt:
//            StatementBuilder

public static final class okForExecute extends Enum
{

    private static final EXECUTE $VALUES[];
    public static final EXECUTE DELETE;
    public static final EXECUTE EXECUTE;
    public static final EXECUTE SELECT;
    public static final EXECUTE SELECT_LONG;
    public static final EXECUTE SELECT_RAW;
    public static final EXECUTE UPDATE;
    private final boolean okForExecute;
    private final boolean okForQuery;
    private final boolean okForStatementBuilder;
    private final boolean okForUpdate;

    public static okForExecute valueOf(String s)
    {
        return (okForExecute)Enum.valueOf(com/j256/ormlite/stmt/StatementBuilder$StatementType, s);
    }

    public static okForExecute[] values()
    {
        return (okForExecute[])$VALUES.clone();
    }

    public boolean isOkForExecute()
    {
        return okForExecute;
    }

    public boolean isOkForQuery()
    {
        return okForQuery;
    }

    public boolean isOkForStatementBuilder()
    {
        return okForStatementBuilder;
    }

    public boolean isOkForUpdate()
    {
        return okForUpdate;
    }

    static 
    {
        SELECT = new <init>("SELECT", 0, true, true, false, false);
        SELECT_LONG = new <init>("SELECT_LONG", 1, true, true, false, false);
        SELECT_RAW = new <init>("SELECT_RAW", 2, true, true, false, false);
        UPDATE = new <init>("UPDATE", 3, true, false, true, false);
        DELETE = new <init>("DELETE", 4, true, false, true, false);
        EXECUTE = new <init>("EXECUTE", 5, false, false, false, true);
        $VALUES = (new .VALUES[] {
            SELECT, SELECT_LONG, SELECT_RAW, UPDATE, DELETE, EXECUTE
        });
    }

    private (String s, int i, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        super(s, i);
        okForStatementBuilder = flag;
        okForQuery = flag1;
        okForUpdate = flag2;
        okForExecute = flag3;
    }
}
