// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field;

import com.j256.ormlite.misc.SqlExceptionUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

// Referenced classes of package com.j256.ormlite.field:
//            DatabaseFieldConfig, DataType, DataPersister

public class DatabaseFieldConfigLoader
{

    private static final DataPersister DEFAULT_DATA_PERSISTER;

    public static DatabaseFieldConfig fromReader(BufferedReader bufferedreader)
        throws SQLException
    {
        DatabaseFieldConfig databasefieldconfig = new DatabaseFieldConfig();
        boolean flag = false;
        do
        {
            do
            {
                String s;
                try
                {
                    s = bufferedreader.readLine();
                }
                // Misplaced declaration of an exception variable
                catch (BufferedReader bufferedreader)
                {
                    throw SqlExceptionUtil.create("Could not read DatabaseFieldConfig from stream", bufferedreader);
                }
                String as[];
                while (s == null || s.equals("# --field-end--")) 
                {
                    if (flag)
                    {
                        return databasefieldconfig;
                    } else
                    {
                        return null;
                    }
                }
            } while (s.length() == 0 || s.startsWith("#") || s.equals("# --field-start--"));
            as = s.split("=", -2);
            if (as.length != 2)
            {
                throw new SQLException((new StringBuilder()).append("DatabaseFieldConfig reading from stream cannot parse line: ").append(s).toString());
            }
            readField(databasefieldconfig, as[0], as[1]);
            flag = true;
        } while (true);
    }

    private static void readField(DatabaseFieldConfig databasefieldconfig, String s, String s1)
    {
        if (!s.equals("fieldName")) goto _L2; else goto _L1
_L1:
        databasefieldconfig.setFieldName(s1);
_L4:
        return;
_L2:
        if (s.equals("columnName"))
        {
            databasefieldconfig.setColumnName(s1);
            return;
        }
        if (s.equals("dataPersister"))
        {
            databasefieldconfig.setDataPersister(DataType.valueOf(s1).getDataPersister());
            return;
        }
        if (s.equals("defaultValue"))
        {
            databasefieldconfig.setDefaultValue(s1);
            return;
        }
        if (s.equals("width"))
        {
            databasefieldconfig.setWidth(Integer.parseInt(s1));
            return;
        }
        if (s.equals("canBeNull"))
        {
            databasefieldconfig.setCanBeNull(Boolean.parseBoolean(s1));
            return;
        }
        if (s.equals("id"))
        {
            databasefieldconfig.setId(Boolean.parseBoolean(s1));
            return;
        }
        if (s.equals("generatedId"))
        {
            databasefieldconfig.setGeneratedId(Boolean.parseBoolean(s1));
            return;
        }
        if (s.equals("generatedIdSequence"))
        {
            databasefieldconfig.setGeneratedIdSequence(s1);
            return;
        }
        if (s.equals("foreign"))
        {
            databasefieldconfig.setForeign(Boolean.parseBoolean(s1));
            return;
        }
        if (s.equals("useGetSet"))
        {
            databasefieldconfig.setUseGetSet(Boolean.parseBoolean(s1));
            return;
        }
        if (!s.equals("unknownEnumValue"))
        {
            break; /* Loop/switch isn't completed */
        }
        s = s1.split("#", -2);
        if (s.length != 2)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid value for unknownEnumValue which should be in class#name format: ").append(s1).toString());
        }
        Class class1;
        Object aobj[];
        try
        {
            class1 = Class.forName(s[0]);
        }
        // Misplaced declaration of an exception variable
        catch (DatabaseFieldConfig databasefieldconfig)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown class specified for unknownEnumValue: ").append(s1).toString());
        }
        aobj = class1.getEnumConstants();
        if (aobj == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid class is not an Enum for unknownEnumValue: ").append(s1).toString());
        }
        aobj = (Enum[])(Enum[])aobj;
        boolean flag = false;
        int j = aobj.length;
        for (int i = 0; i < j; i++)
        {
            Enum enum = aobj[i];
            if (enum.name().equals(s[1]))
            {
                databasefieldconfig.setUnknownEnumValue(enum);
                flag = true;
            }
        }

        if (!flag)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid enum value name for unknownEnumvalue: ").append(s1).toString());
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (s.equals("throwIfNull"))
        {
            databasefieldconfig.setThrowIfNull(Boolean.parseBoolean(s1));
            return;
        }
        if (s.equals("format"))
        {
            databasefieldconfig.setFormat(s1);
            return;
        }
        if (s.equals("unique"))
        {
            databasefieldconfig.setUnique(Boolean.parseBoolean(s1));
            return;
        }
        if (s.equals("uniqueCombo"))
        {
            databasefieldconfig.setUniqueCombo(Boolean.parseBoolean(s1));
            return;
        }
        if (s.equals("index"))
        {
            databasefieldconfig.setIndex(Boolean.parseBoolean(s1));
            return;
        }
        if (s.equals("indexName"))
        {
            databasefieldconfig.setIndex(true);
            databasefieldconfig.setIndexName(s1);
            return;
        }
        if (s.equals("uniqueIndex"))
        {
            databasefieldconfig.setUniqueIndex(Boolean.parseBoolean(s1));
            return;
        }
        if (s.equals("uniqueIndexName"))
        {
            databasefieldconfig.setUniqueIndex(true);
            databasefieldconfig.setUniqueIndexName(s1);
            return;
        }
        if (s.equals("foreignAutoRefresh"))
        {
            databasefieldconfig.setForeignAutoRefresh(Boolean.parseBoolean(s1));
            return;
        }
        if (s.equals("maxForeignAutoRefreshLevel"))
        {
            databasefieldconfig.setMaxForeignAutoRefreshLevel(Integer.parseInt(s1));
            return;
        }
        if (s.equals("persisterClass"))
        {
            try
            {
                databasefieldconfig.setPersisterClass(Class.forName(s1));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (DatabaseFieldConfig databasefieldconfig)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Could not find persisterClass: ").append(s1).toString());
            }
        }
        if (s.equals("allowGeneratedIdInsert"))
        {
            databasefieldconfig.setAllowGeneratedIdInsert(Boolean.parseBoolean(s1));
            return;
        }
        if (s.equals("columnDefinition"))
        {
            databasefieldconfig.setColumnDefinition(s1);
            return;
        }
        if (s.equals("foreignAutoCreate"))
        {
            databasefieldconfig.setForeignAutoCreate(Boolean.parseBoolean(s1));
            return;
        }
        if (s.equals("version"))
        {
            databasefieldconfig.setVersion(Boolean.parseBoolean(s1));
            return;
        }
        if (s.equals("foreignColumnName"))
        {
            databasefieldconfig.setForeignColumnName(s1);
            return;
        }
        if (s.equals("readOnly"))
        {
            databasefieldconfig.setReadOnly(Boolean.parseBoolean(s1));
            return;
        }
        if (s.equals("foreignCollection"))
        {
            databasefieldconfig.setForeignCollection(Boolean.parseBoolean(s1));
            return;
        }
        if (s.equals("foreignCollectionEager"))
        {
            databasefieldconfig.setForeignCollectionEager(Boolean.parseBoolean(s1));
            return;
        }
        if (s.equals("maxEagerForeignCollectionLevel"))
        {
            databasefieldconfig.setForeignCollectionMaxEagerLevel(Integer.parseInt(s1));
            return;
        }
        if (s.equals("foreignCollectionMaxEagerLevel"))
        {
            databasefieldconfig.setForeignCollectionMaxEagerLevel(Integer.parseInt(s1));
            return;
        }
        if (s.equals("foreignCollectionColumnName"))
        {
            databasefieldconfig.setForeignCollectionColumnName(s1);
            return;
        }
        if (s.equals("foreignCollectionOrderColumn"))
        {
            databasefieldconfig.setForeignCollectionOrderColumnName(s1);
            return;
        }
        if (s.equals("foreignCollectionOrderColumnName"))
        {
            databasefieldconfig.setForeignCollectionOrderColumnName(s1);
            return;
        }
        if (s.equals("foreignCollectionOrderAscending"))
        {
            databasefieldconfig.setForeignCollectionOrderAscending(Boolean.parseBoolean(s1));
            return;
        }
        if (s.equals("foreignCollectionForeignColumnName"))
        {
            databasefieldconfig.setForeignCollectionForeignFieldName(s1);
            return;
        }
        if (s.equals("foreignCollectionForeignFieldName"))
        {
            databasefieldconfig.setForeignCollectionForeignFieldName(s1);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    static 
    {
        DEFAULT_DATA_PERSISTER = DatabaseFieldConfig.DEFAULT_DATA_TYPE.getDataPersister();
    }
}
