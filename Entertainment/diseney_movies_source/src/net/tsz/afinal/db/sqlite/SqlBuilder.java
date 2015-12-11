// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.db.sqlite;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.tsz.afinal.db.table.Id;
import net.tsz.afinal.db.table.KeyValue;
import net.tsz.afinal.db.table.ManyToOne;
import net.tsz.afinal.db.table.Property;
import net.tsz.afinal.db.table.TableInfo;
import net.tsz.afinal.exception.DbException;

// Referenced classes of package net.tsz.afinal.db.sqlite:
//            SqlInfo

public class SqlBuilder
{

    public SqlBuilder()
    {
    }

    public static String buildDeleteSql(Class class1, String s)
    {
        class1 = new StringBuffer(getDeleteSqlBytableName(TableInfo.get(class1).getTableName()));
        if (!TextUtils.isEmpty(s))
        {
            class1.append(" WHERE ");
            class1.append(s);
        }
        return class1.toString();
    }

    public static SqlInfo buildDeleteSql(Class class1, Object obj)
    {
        Object obj1 = TableInfo.get(class1);
        class1 = ((TableInfo) (obj1)).getId();
        if (obj == null)
        {
            throw new DbException("getDeleteSQL:idValue is null");
        } else
        {
            obj1 = new StringBuffer(getDeleteSqlBytableName(((TableInfo) (obj1)).getTableName()));
            ((StringBuffer) (obj1)).append(" WHERE ").append(class1.getColumn()).append("=?");
            class1 = new SqlInfo();
            class1.setSql(((StringBuffer) (obj1)).toString());
            class1.addValue(obj);
            return class1;
        }
    }

    public static SqlInfo buildDeleteSql(Object obj)
    {
        TableInfo tableinfo = TableInfo.get(obj.getClass());
        Object obj2 = tableinfo.getId();
        Object obj1 = ((Id) (obj2)).getValue(obj);
        if (obj1 == null)
        {
            throw new DbException((new StringBuilder("getDeleteSQL:")).append(obj.getClass()).append(" id value is null").toString());
        } else
        {
            obj = new StringBuffer(getDeleteSqlBytableName(tableinfo.getTableName()));
            ((StringBuffer) (obj)).append(" WHERE ").append(((Id) (obj2)).getColumn()).append("=?");
            obj2 = new SqlInfo();
            ((SqlInfo) (obj2)).setSql(((StringBuffer) (obj)).toString());
            ((SqlInfo) (obj2)).addValue(obj1);
            return ((SqlInfo) (obj2));
        }
    }

    public static SqlInfo buildInsertSql(Object obj)
    {
        SqlInfo sqlinfo;
        Object obj1;
        List list;
        StringBuffer stringbuffer;
        list = getSaveKeyValueListByEntity(obj);
        stringbuffer = new StringBuffer();
        obj1 = null;
        sqlinfo = obj1;
        if (list == null) goto _L2; else goto _L1
_L1:
        sqlinfo = obj1;
        if (list.size() <= 0) goto _L2; else goto _L3
_L3:
        sqlinfo = new SqlInfo();
        stringbuffer.append("INSERT INTO ");
        stringbuffer.append(TableInfo.get(obj.getClass()).getTableName());
        stringbuffer.append(" (");
        obj = list.iterator();
_L6:
        if (((Iterator) (obj)).hasNext()) goto _L5; else goto _L4
_L4:
        int i;
        int j;
        stringbuffer.deleteCharAt(stringbuffer.length() - 1);
        stringbuffer.append(") VALUES ( ");
        j = list.size();
        i = 0;
_L7:
        if (i < j)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        stringbuffer.deleteCharAt(stringbuffer.length() - 1);
        stringbuffer.append(")");
        sqlinfo.setSql(stringbuffer.toString());
_L2:
        return sqlinfo;
_L5:
        KeyValue keyvalue = (KeyValue)((Iterator) (obj)).next();
        stringbuffer.append(keyvalue.getKey()).append(",");
        sqlinfo.addValue(keyvalue.getValue());
          goto _L6
        stringbuffer.append("?,");
        i++;
          goto _L7
    }

    public static String getCreatTableSQL(Class class1)
    {
        Object obj;
        Object obj1;
        obj = TableInfo.get(class1);
        obj1 = ((TableInfo) (obj)).getId();
        class1 = new StringBuffer();
        class1.append("CREATE TABLE IF NOT EXISTS ");
        class1.append(((TableInfo) (obj)).getTableName());
        class1.append(" ( ");
        Class class2 = ((Id) (obj1)).getDataType();
        if (class2 == Integer.TYPE || class2 == java/lang/Integer)
        {
            class1.append("\"").append(((Id) (obj1)).getColumn()).append("\"    ").append("INTEGER PRIMARY KEY AUTOINCREMENT,");
        } else
        {
            class1.append("\"").append(((Id) (obj1)).getColumn()).append("\"    ").append("TEXT PRIMARY KEY,");
        }
        obj1 = ((TableInfo) (obj)).propertyMap.values().iterator();
_L3:
        if (((Iterator) (obj1)).hasNext()) goto _L2; else goto _L1
_L1:
        obj = ((TableInfo) (obj)).manyToOneMap.values().iterator();
_L4:
        if (!((Iterator) (obj)).hasNext())
        {
            class1.deleteCharAt(class1.length() - 1);
            class1.append(" )");
            return class1.toString();
        }
        break MISSING_BLOCK_LABEL_211;
_L2:
        Property property = (Property)((Iterator) (obj1)).next();
        class1.append("\"").append(property.getColumn());
        class1.append("\",");
          goto _L3
        ManyToOne manytoone = (ManyToOne)((Iterator) (obj)).next();
        class1.append("\"").append(manytoone.getColumn()).append("\",");
          goto _L4
    }

    private static String getDeleteSqlBytableName(String s)
    {
        return (new StringBuilder("DELETE FROM ")).append(s).toString();
    }

    private static String getPropertyStrSql(String s, Object obj)
    {
        s = (new StringBuffer(s)).append("=");
        if ((obj instanceof String) || (obj instanceof Date) || (obj instanceof java.sql.Date))
        {
            s.append("'").append(obj).append("'");
        } else
        {
            s.append(obj);
        }
        return s.toString();
    }

    public static List getSaveKeyValueListByEntity(Object obj)
    {
        ArrayList arraylist;
        Object obj1;
        Object obj2;
        arraylist = new ArrayList();
        obj1 = TableInfo.get(obj.getClass());
        obj2 = ((TableInfo) (obj1)).getId().getValue(obj);
        if (!(obj2 instanceof Integer) && (obj2 instanceof String) && obj2 != null)
        {
            arraylist.add(new KeyValue(((TableInfo) (obj1)).getId().getColumn(), obj2));
        }
        obj2 = ((TableInfo) (obj1)).propertyMap.values().iterator();
_L3:
        if (((Iterator) (obj2)).hasNext()) goto _L2; else goto _L1
_L1:
        obj1 = ((TableInfo) (obj1)).manyToOneMap.values().iterator();
_L4:
        if (!((Iterator) (obj1)).hasNext())
        {
            return arraylist;
        }
        break MISSING_BLOCK_LABEL_143;
_L2:
        KeyValue keyvalue1 = property2KeyValue((Property)((Iterator) (obj2)).next(), obj);
        if (keyvalue1 != null)
        {
            arraylist.add(keyvalue1);
        }
          goto _L3
        KeyValue keyvalue = manyToOne2KeyValue((ManyToOne)((Iterator) (obj1)).next(), obj);
        if (keyvalue != null)
        {
            arraylist.add(keyvalue);
        }
          goto _L4
    }

    public static String getSelectSQL(Class class1)
    {
        return getSelectSqlByTableName(TableInfo.get(class1).getTableName());
    }

    public static String getSelectSQL(Class class1, Object obj)
    {
        class1 = TableInfo.get(class1);
        StringBuffer stringbuffer = new StringBuffer(getSelectSqlByTableName(class1.getTableName()));
        stringbuffer.append(" WHERE ");
        stringbuffer.append(getPropertyStrSql(class1.getId().getColumn(), obj));
        return stringbuffer.toString();
    }

    public static String getSelectSQLByWhere(Class class1, String s)
    {
        class1 = new StringBuffer(getSelectSqlByTableName(TableInfo.get(class1).getTableName()));
        if (!TextUtils.isEmpty(s))
        {
            class1.append(" WHERE ").append(s);
        }
        return class1.toString();
    }

    public static SqlInfo getSelectSqlAsSqlInfo(Class class1, Object obj)
    {
        Object obj1 = TableInfo.get(class1);
        class1 = new StringBuffer(getSelectSqlByTableName(((TableInfo) (obj1)).getTableName()));
        class1.append(" WHERE ").append(((TableInfo) (obj1)).getId().getColumn()).append("=?");
        obj1 = new SqlInfo();
        ((SqlInfo) (obj1)).setSql(class1.toString());
        ((SqlInfo) (obj1)).addValue(obj);
        return ((SqlInfo) (obj1));
    }

    private static String getSelectSqlByTableName(String s)
    {
        return "SELECT * FROM " + s;
    }

    public static SqlInfo getUpdateSqlAsSqlInfo(Object obj)
    {
        TableInfo tableinfo;
        Object obj1;
        Object obj2;
        Iterator iterator;
        tableinfo = TableInfo.get(obj.getClass());
        obj1 = tableinfo.getId().getValue(obj);
        if (obj1 == null)
        {
            throw new DbException((new StringBuilder("this entity[")).append(obj.getClass()).append("]'s id value is null").toString());
        }
        obj2 = new ArrayList();
        iterator = tableinfo.propertyMap.values().iterator();
_L6:
        if (iterator.hasNext()) goto _L2; else goto _L1
_L1:
        iterator = tableinfo.manyToOneMap.values().iterator();
_L4:
        KeyValue keyvalue;
        if (!iterator.hasNext())
        {
            if (obj2 == null || ((List) (obj2)).size() == 0)
            {
                return null;
            }
            break; /* Loop/switch isn't completed */
        }
        keyvalue = manyToOne2KeyValue((ManyToOne)iterator.next(), obj);
        if (keyvalue != null)
        {
            ((List) (obj2)).add(keyvalue);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        keyvalue = property2KeyValue((Property)iterator.next(), obj);
        if (keyvalue != null)
        {
            ((List) (obj2)).add(keyvalue);
        }
        continue; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
        obj = new SqlInfo();
        StringBuffer stringbuffer = new StringBuffer("UPDATE ");
        stringbuffer.append(tableinfo.getTableName());
        stringbuffer.append(" SET ");
        obj2 = ((List) (obj2)).iterator();
        do
        {
            if (!((Iterator) (obj2)).hasNext())
            {
                stringbuffer.deleteCharAt(stringbuffer.length() - 1);
                stringbuffer.append(" WHERE ").append(tableinfo.getId().getColumn()).append("=?");
                ((SqlInfo) (obj)).addValue(obj1);
                ((SqlInfo) (obj)).setSql(stringbuffer.toString());
                return ((SqlInfo) (obj));
            }
            KeyValue keyvalue1 = (KeyValue)((Iterator) (obj2)).next();
            stringbuffer.append(keyvalue1.getKey()).append("=?,");
            ((SqlInfo) (obj)).addValue(keyvalue1.getValue());
        } while (true);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static SqlInfo getUpdateSqlAsSqlInfo(Object obj, String s)
    {
        Object obj1;
        ArrayList arraylist;
        Iterator iterator;
        obj1 = TableInfo.get(obj.getClass());
        arraylist = new ArrayList();
        iterator = ((TableInfo) (obj1)).propertyMap.values().iterator();
_L6:
        if (iterator.hasNext()) goto _L2; else goto _L1
_L1:
        iterator = ((TableInfo) (obj1)).manyToOneMap.values().iterator();
_L4:
        KeyValue keyvalue1;
        if (!iterator.hasNext())
        {
            if (arraylist == null || arraylist.size() == 0)
            {
                throw new DbException((new StringBuilder("this entity[")).append(obj.getClass()).append("] has no property").toString());
            }
            break; /* Loop/switch isn't completed */
        }
        keyvalue1 = manyToOne2KeyValue((ManyToOne)iterator.next(), obj);
        if (keyvalue1 != null)
        {
            arraylist.add(keyvalue1);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        keyvalue1 = property2KeyValue((Property)iterator.next(), obj);
        if (keyvalue1 != null)
        {
            arraylist.add(keyvalue1);
        }
        continue; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
        obj = new SqlInfo();
        StringBuffer stringbuffer = new StringBuffer("UPDATE ");
        stringbuffer.append(((TableInfo) (obj1)).getTableName());
        stringbuffer.append(" SET ");
        obj1 = arraylist.iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                stringbuffer.deleteCharAt(stringbuffer.length() - 1);
                if (!TextUtils.isEmpty(s))
                {
                    stringbuffer.append(" WHERE ").append(s);
                }
                ((SqlInfo) (obj)).setSql(stringbuffer.toString());
                return ((SqlInfo) (obj));
            }
            KeyValue keyvalue = (KeyValue)((Iterator) (obj1)).next();
            stringbuffer.append(keyvalue.getKey()).append("=?,");
            ((SqlInfo) (obj)).addValue(keyvalue.getValue());
        } while (true);
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static KeyValue manyToOne2KeyValue(ManyToOne manytoone, Object obj)
    {
        Object obj1 = null;
        String s = manytoone.getColumn();
        obj = manytoone.getValue(obj);
        manytoone = obj1;
        if (obj != null)
        {
            obj = TableInfo.get(obj.getClass()).getId().getValue(obj);
            manytoone = obj1;
            if (s != null)
            {
                manytoone = obj1;
                if (obj != null)
                {
                    manytoone = new KeyValue(s, obj);
                }
            }
        }
        return manytoone;
    }

    private static KeyValue property2KeyValue(Property property, Object obj)
    {
        Object obj1 = null;
        String s = property.getColumn();
        obj = property.getValue(obj);
        if (obj != null)
        {
            obj = new KeyValue(s, obj);
        } else
        {
            obj = obj1;
            if (property.getDefaultValue() != null)
            {
                obj = obj1;
                if (property.getDefaultValue().trim().length() != 0)
                {
                    return new KeyValue(s, property.getDefaultValue());
                }
            }
        }
        return ((KeyValue) (obj));
    }
}
