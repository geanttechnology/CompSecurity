// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field;

import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

// Referenced classes of package com.j256.ormlite.field:
//            SqlType, FieldType

public interface FieldConverter
{

    public abstract SqlType getSqlType();

    public abstract boolean isStreamType();

    public abstract Object javaToSqlArg(FieldType fieldtype, Object obj)
        throws SQLException;

    public abstract Object parseDefaultString(FieldType fieldtype, String s)
        throws SQLException;

    public abstract Object resultStringToJava(FieldType fieldtype, String s, int i)
        throws SQLException;

    public abstract Object resultToJava(FieldType fieldtype, DatabaseResults databaseresults, int i)
        throws SQLException;

    public abstract Object resultToSqlArg(FieldType fieldtype, DatabaseResults databaseresults, int i)
        throws SQLException;
}
