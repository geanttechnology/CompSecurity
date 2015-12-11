// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.db;

import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.util.List;

// Referenced classes of package com.j256.ormlite.db:
//            BaseDatabaseType, DatabaseType

public abstract class BaseSqliteDatabaseType extends BaseDatabaseType
    implements DatabaseType
{

    private static final FieldConverter booleanConverter = new BaseDatabaseType.BooleanNumberFieldConverter();

    public BaseSqliteDatabaseType()
    {
    }

    protected void configureGeneratedId(String s, StringBuilder stringbuilder, FieldType fieldtype, List list, List list1, List list2, List list3)
    {
        if (fieldtype.getSqlType() != SqlType.INTEGER)
        {
            throw new IllegalArgumentException("Sqlite requires that auto-increment generated-id be integer types");
        } else
        {
            stringbuilder.append("PRIMARY KEY AUTOINCREMENT ");
            return;
        }
    }

    protected boolean generatedIdSqlAtEnd()
    {
        return false;
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
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BOOLEAN.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls1..SwitchMap.com.j256.ormlite.field.SqlType[datapersister.getSqlType().ordinal()])
        {
        default:
            return super.getFieldConverter(datapersister);

        case 1: // '\001'
            return booleanConverter;
        }
    }

    public boolean isCreateIfNotExistsSupported()
    {
        return true;
    }

    public boolean isCreateTableReturnsZero()
    {
        return false;
    }

    public boolean isVarcharFieldWidthSupported()
    {
        return false;
    }

}
