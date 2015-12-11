// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.NullArgHolder;
import java.sql.SQLException;
import java.util.List;

// Referenced classes of package com.j256.ormlite.stmt.query:
//            BaseComparison

public class SetValue extends BaseComparison
{

    private static final ArgumentHolder nullValue = new NullArgHolder();

    public SetValue(String s, FieldType fieldtype, Object obj)
        throws SQLException
    {
        Object obj1 = obj;
        if (obj == null)
        {
            obj1 = nullValue;
        }
        super(s, fieldtype, obj1, false);
    }

    public void appendOperation(StringBuilder stringbuilder)
    {
        stringbuilder.append("= ");
    }

    public volatile void appendSql(DatabaseType databasetype, String s, StringBuilder stringbuilder, List list)
        throws SQLException
    {
        super.appendSql(databasetype, s, stringbuilder, list);
    }

    public volatile void appendValue(DatabaseType databasetype, StringBuilder stringbuilder, List list)
        throws SQLException
    {
        super.appendValue(databasetype, stringbuilder, list);
    }

    public volatile String getColumnName()
    {
        return super.getColumnName();
    }

    public volatile String toString()
    {
        return super.toString();
    }

}
