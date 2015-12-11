// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.db;

import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.DateStringType;

// Referenced classes of package com.j256.ormlite.db:
//            BaseSqliteDatabaseType, DatabaseType

public class SqliteAndroidDatabaseType extends BaseSqliteDatabaseType
    implements DatabaseType
{

    public SqliteAndroidDatabaseType()
    {
    }

    protected void appendBooleanType(StringBuilder stringbuilder, int i)
    {
        appendShortType(stringbuilder, i);
    }

    protected void appendDateType(StringBuilder stringbuilder, int i)
    {
        appendStringType(stringbuilder, i);
    }

    public String getDatabaseName()
    {
        return "Android SQLite";
    }

    protected String getDriverClassName()
    {
        return null;
    }

    public FieldConverter getFieldConverter(DataPersister datapersister)
    {
        class _cls1
        {

            static final int $SwitchMap$com$j256$ormlite$field$SqlType[];

            static 
            {
                $SwitchMap$com$j256$ormlite$field$SqlType = new int[SqlType.values().length];
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DATE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls1..SwitchMap.com.j256.ormlite.field.SqlType[datapersister.getSqlType().ordinal()])
        {
        default:
            return super.getFieldConverter(datapersister);

        case 1: // '\001'
            return DateStringType.getSingleton();
        }
    }

    public boolean isBatchUseTransaction()
    {
        return true;
    }

    public boolean isDatabaseUrlThisType(String s, String s1)
    {
        return true;
    }

    public boolean isNestedSavePointsSupported()
    {
        return false;
    }

    public void loadDriver()
    {
    }
}
