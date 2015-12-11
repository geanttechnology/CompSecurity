// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.db;

import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.List;

// Referenced classes of package com.j256.ormlite.db:
//            DatabaseType

public abstract class BaseDatabaseType
    implements DatabaseType
{

    protected static String DEFAULT_SEQUENCE_SUFFIX = "_id_seq";
    protected Driver driver;

    public BaseDatabaseType()
    {
    }

    private void addSingleUnique(StringBuilder stringbuilder, FieldType fieldtype, List list, List list1)
    {
        stringbuilder = new StringBuilder();
        stringbuilder.append(" UNIQUE (");
        appendEscapedEntityName(stringbuilder, fieldtype.getDbColumnName());
        stringbuilder.append(")");
        list.add(stringbuilder.toString());
    }

    private void appendCanBeNull(StringBuilder stringbuilder, FieldType fieldtype)
    {
    }

    private void appendDefaultValue(StringBuilder stringbuilder, FieldType fieldtype, Object obj)
    {
        if (fieldtype.isEscapedDefaultValue())
        {
            appendEscapedWord(stringbuilder, obj.toString());
            return;
        } else
        {
            stringbuilder.append(obj);
            return;
        }
    }

    private void appendDoubleType(StringBuilder stringbuilder, int i)
    {
        stringbuilder.append("DOUBLE PRECISION");
    }

    private void appendFloatType(StringBuilder stringbuilder, int i)
    {
        stringbuilder.append("FLOAT");
    }

    private void appendIntegerType(StringBuilder stringbuilder, int i)
    {
        stringbuilder.append("INTEGER");
    }

    public void addPrimaryKeySql(FieldType afieldtype[], List list, List list1, List list2, List list3)
    {
        int j = afieldtype.length;
        list1 = null;
        int i = 0;
        while (i < j) 
        {
            list3 = afieldtype[i];
            if (list3.isGeneratedId() && !generatedIdSqlAtEnd() && !list3.isSelfGeneratedId())
            {
                list2 = list1;
            } else
            {
                list2 = list1;
                if (list3.isId())
                {
                    if (list1 == null)
                    {
                        list1 = new StringBuilder(48);
                        list1.append("PRIMARY KEY (");
                    } else
                    {
                        list1.append(',');
                    }
                    appendEscapedEntityName(list1, list3.getDbColumnName());
                    list2 = list1;
                }
            }
            i++;
            list1 = list2;
        }
        if (list1 != null)
        {
            list1.append(") ");
            list.add(list1.toString());
        }
    }

    public void addUniqueComboSql(FieldType afieldtype[], List list, List list1, List list2, List list3)
    {
        int j = afieldtype.length;
        list1 = null;
        int i = 0;
        while (i < j) 
        {
            list3 = afieldtype[i];
            list2 = list1;
            if (list3.isUniqueCombo())
            {
                if (list1 == null)
                {
                    list1 = new StringBuilder(48);
                    list1.append("UNIQUE (");
                } else
                {
                    list1.append(',');
                }
                appendEscapedEntityName(list1, list3.getDbColumnName());
                list2 = list1;
            }
            i++;
            list1 = list2;
        }
        if (list1 != null)
        {
            list1.append(") ");
            list.add(list1.toString());
        }
    }

    protected void appendBooleanType(StringBuilder stringbuilder, int i)
    {
        stringbuilder.append("BOOLEAN");
    }

    protected void appendByteArrayType(StringBuilder stringbuilder, int i)
    {
        stringbuilder.append("BLOB");
    }

    protected void appendByteType(StringBuilder stringbuilder, int i)
    {
        stringbuilder.append("TINYINT");
    }

    protected void appendCharType(StringBuilder stringbuilder, int i)
    {
        stringbuilder.append("CHAR");
    }

    public void appendColumnArg(String s, StringBuilder stringbuilder, FieldType fieldtype, List list, List list1, List list2, List list3)
    {
        DataPersister datapersister;
        int i;
        appendEscapedEntityName(stringbuilder, fieldtype.getDbColumnName());
        stringbuilder.append(' ');
        datapersister = fieldtype.getDataPersister();
        int j = fieldtype.getWidth();
        i = j;
        if (j == 0)
        {
            i = datapersister.getDefaultWidth();
        }
        class _cls1
        {

            static final int $SwitchMap$com$j256$ormlite$field$SqlType[];

            static 
            {
                $SwitchMap$com$j256$ormlite$field$SqlType = new int[SqlType.values().length];
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.STRING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG_STRING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BOOLEAN.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DATE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.CHAR.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE_ARRAY.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SHORT.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.INTEGER.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.FLOAT.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DOUBLE.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SERIALIZABLE.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.UNKNOWN.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.j256.ormlite.field.SqlType[datapersister.getSqlType().ordinal()];
        JVM INSTR tableswitch 1 13: default 128
    //                   1 161
    //                   2 269
    //                   3 279
    //                   4 289
    //                   5 299
    //                   6 309
    //                   7 319
    //                   8 329
    //                   9 339
    //                   10 349
    //                   11 359
    //                   12 369
    //                   13 379;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L14:
        break MISSING_BLOCK_LABEL_379;
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown SQL-type ").append(datapersister.getSqlType()).toString());
_L2:
        appendStringType(stringbuilder, i);
_L15:
        stringbuilder.append(' ');
        if (fieldtype.isGeneratedIdSequence() && !fieldtype.isSelfGeneratedId())
        {
            configureGeneratedIdSequence(stringbuilder, fieldtype, list1, list, list3);
        } else
        if (fieldtype.isGeneratedId() && !fieldtype.isSelfGeneratedId())
        {
            configureGeneratedId(s, stringbuilder, fieldtype, list1, list2, list, list3);
        } else
        if (fieldtype.isId())
        {
            configureId(stringbuilder, fieldtype, list1, list, list3);
        }
        if (!fieldtype.isGeneratedId())
        {
            s = ((String) (fieldtype.getDefaultValue()));
            if (s != null)
            {
                stringbuilder.append("DEFAULT ");
                appendDefaultValue(stringbuilder, fieldtype, s);
                stringbuilder.append(' ');
            }
            if (fieldtype.isCanBeNull())
            {
                appendCanBeNull(stringbuilder, fieldtype);
            } else
            {
                stringbuilder.append("NOT NULL ");
            }
            if (fieldtype.isUnique())
            {
                addSingleUnique(stringbuilder, fieldtype, list, list2);
            }
        }
        return;
_L3:
        appendLongStringType(stringbuilder, i);
          goto _L15
_L4:
        appendBooleanType(stringbuilder, i);
          goto _L15
_L5:
        appendDateType(stringbuilder, i);
          goto _L15
_L6:
        appendCharType(stringbuilder, i);
          goto _L15
_L7:
        appendByteType(stringbuilder, i);
          goto _L15
_L8:
        appendByteArrayType(stringbuilder, i);
          goto _L15
_L9:
        appendShortType(stringbuilder, i);
          goto _L15
_L10:
        appendIntegerType(stringbuilder, i);
          goto _L15
_L11:
        appendLongType(stringbuilder, i);
          goto _L15
_L12:
        appendFloatType(stringbuilder, i);
          goto _L15
_L13:
        appendDoubleType(stringbuilder, i);
          goto _L15
        appendSerializableType(stringbuilder, i);
          goto _L15
    }

    public void appendCreateTableSuffix(StringBuilder stringbuilder)
    {
    }

    protected void appendDateType(StringBuilder stringbuilder, int i)
    {
        stringbuilder.append("TIMESTAMP");
    }

    public void appendEscapedEntityName(StringBuilder stringbuilder, String s)
    {
        stringbuilder.append('`').append(s).append('`');
    }

    public void appendEscapedWord(StringBuilder stringbuilder, String s)
    {
        stringbuilder.append('\'').append(s).append('\'');
    }

    public void appendLimitValue(StringBuilder stringbuilder, int i, Integer integer)
    {
        stringbuilder.append("LIMIT ").append(i).append(' ');
    }

    protected void appendLongStringType(StringBuilder stringbuilder, int i)
    {
        stringbuilder.append("TEXT");
    }

    protected void appendLongType(StringBuilder stringbuilder, int i)
    {
        stringbuilder.append("BIGINT");
    }

    public void appendOffsetValue(StringBuilder stringbuilder, int i)
    {
        stringbuilder.append("OFFSET ").append(i).append(' ');
    }

    public void appendSelectNextValFromSequence(StringBuilder stringbuilder, String s)
    {
    }

    protected void appendSerializableType(StringBuilder stringbuilder, int i)
    {
        stringbuilder.append("BLOB");
    }

    protected void appendShortType(StringBuilder stringbuilder, int i)
    {
        stringbuilder.append("SMALLINT");
    }

    protected void appendStringType(StringBuilder stringbuilder, int i)
    {
        if (isVarcharFieldWidthSupported())
        {
            stringbuilder.append("VARCHAR(").append(i).append(")");
            return;
        } else
        {
            stringbuilder.append("VARCHAR");
            return;
        }
    }

    protected void configureGeneratedId(String s, StringBuilder stringbuilder, FieldType fieldtype, List list, List list1, List list2, List list3)
    {
        throw new IllegalStateException((new StringBuilder()).append("GeneratedId is not supported by database ").append(getDatabaseName()).append(" for field ").append(fieldtype).toString());
    }

    protected void configureGeneratedIdSequence(StringBuilder stringbuilder, FieldType fieldtype, List list, List list1, List list2)
    {
        throw new SQLException((new StringBuilder()).append("GeneratedIdSequence is not supported by database ").append(getDatabaseName()).append(" for field ").append(fieldtype).toString());
    }

    protected void configureId(StringBuilder stringbuilder, FieldType fieldtype, List list, List list1, List list2)
    {
    }

    public void dropColumnArg(FieldType fieldtype, List list, List list1)
    {
    }

    public String generateIdSequenceName(String s, FieldType fieldtype)
    {
        fieldtype = (new StringBuilder()).append(s).append(DEFAULT_SEQUENCE_SUFFIX).toString();
        s = fieldtype;
        if (isEntityNamesMustBeUpCase())
        {
            s = fieldtype.toUpperCase();
        }
        return s;
    }

    protected boolean generatedIdSqlAtEnd()
    {
        return true;
    }

    public String getCommentLinePrefix()
    {
        return "-- ";
    }

    protected abstract String getDriverClassName();

    public FieldConverter getFieldConverter(DataPersister datapersister)
    {
        return datapersister;
    }

    public String getPingStatement()
    {
        return "SELECT 1";
    }

    public boolean isAllowGeneratedIdInsertSupported()
    {
        return true;
    }

    public boolean isBatchUseTransaction()
    {
        return false;
    }

    public boolean isCreateIfNotExistsSupported()
    {
        return false;
    }

    public boolean isCreateTableReturnsZero()
    {
        return true;
    }

    public boolean isEntityNamesMustBeUpCase()
    {
        return false;
    }

    public boolean isIdSequenceNeeded()
    {
        return false;
    }

    public boolean isLimitAfterSelect()
    {
        return false;
    }

    public boolean isLimitSqlSupported()
    {
        return true;
    }

    public boolean isNestedSavePointsSupported()
    {
        return true;
    }

    public boolean isOffsetLimitArgument()
    {
        return false;
    }

    public boolean isOffsetSqlSupported()
    {
        return true;
    }

    public boolean isSelectSequenceBeforeInsert()
    {
        return false;
    }

    public boolean isTruncateSupported()
    {
        return false;
    }

    public boolean isVarcharFieldWidthSupported()
    {
        return true;
    }

    public void loadDriver()
    {
        String s;
        s = getDriverClassName();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        Class.forName(s);
        return;
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        throw SqlExceptionUtil.create((new StringBuilder()).append("Driver class was not found for ").append(getDatabaseName()).append(" database.  Missing jar with class ").append(s).append(".").toString(), classnotfoundexception);
    }

    public void setDriver(Driver driver1)
    {
        driver = driver1;
    }

}
