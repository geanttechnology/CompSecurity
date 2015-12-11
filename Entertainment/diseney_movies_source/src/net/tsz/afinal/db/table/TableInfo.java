// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.db.table;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.tsz.afinal.exception.DbException;
import net.tsz.afinal.reflect.ClassUtils;
import net.tsz.afinal.reflect.FieldUtils;

// Referenced classes of package net.tsz.afinal.db.table:
//            Id, Property, ManyToOne, OneToMany

public class TableInfo
{

    private static final HashMap tableInfoMap = new HashMap();
    private boolean checkDatabese;
    private String className;
    private Id id;
    public final HashMap manyToOneMap = new HashMap();
    public final HashMap oneToManyMap = new HashMap();
    public final HashMap propertyMap = new HashMap();
    private String tableName;

    private TableInfo()
    {
    }

    public static TableInfo get(Class class1)
    {
        TableInfo tableinfo;
        Object obj;
        if (class1 == null)
        {
            throw new DbException("table info get error,because the clazz is null");
        }
        obj = (TableInfo)tableInfoMap.get(class1.getName());
        tableinfo = ((TableInfo) (obj));
        if (obj != null) goto _L2; else goto _L1
_L1:
        tableinfo = new TableInfo();
        tableinfo.setTableName(ClassUtils.getTableName(class1));
        tableinfo.setClassName(class1.getName());
        obj = ClassUtils.getPrimaryKeyField(class1);
        if (obj == null) goto _L4; else goto _L3
_L3:
        Id id1 = new Id();
        id1.setColumn(FieldUtils.getColumnByField(((Field) (obj))));
        id1.setFieldName(((Field) (obj)).getName());
        id1.setSet(FieldUtils.getFieldSetMethod(class1, ((Field) (obj))));
        id1.setGet(FieldUtils.getFieldGetMethod(class1, ((Field) (obj))));
        id1.setDataType(((Field) (obj)).getType());
        tableinfo.setId(id1);
        obj = ClassUtils.getPropertyList(class1);
        if (obj == null) goto _L6; else goto _L5
_L5:
        obj = ((List) (obj)).iterator();
_L13:
        if (((Iterator) (obj)).hasNext()) goto _L7; else goto _L6
_L6:
        obj = ClassUtils.getManyToOneList(class1);
        if (obj == null) goto _L9; else goto _L8
_L8:
        obj = ((List) (obj)).iterator();
_L14:
        if (((Iterator) (obj)).hasNext()) goto _L10; else goto _L9
_L9:
        obj = ClassUtils.getOneToManyList(class1);
        if (obj == null) goto _L12; else goto _L11
_L11:
        obj = ((List) (obj)).iterator();
_L15:
        if (((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_331;
        }
_L12:
        tableInfoMap.put(class1.getName(), tableinfo);
_L2:
        if (tableinfo == null)
        {
            throw new DbException((new StringBuilder("the class[")).append(class1).append("]'s table is null").toString());
        } else
        {
            return tableinfo;
        }
_L4:
        throw new DbException((new StringBuilder("the class[")).append(class1).append("]'s idField is null , \n you can define _id,id property or use annotation @id to solution this exception").toString());
_L7:
        Property property = (Property)((Iterator) (obj)).next();
        if (property != null)
        {
            tableinfo.propertyMap.put(property.getColumn(), property);
        }
          goto _L13
_L10:
        ManyToOne manytoone = (ManyToOne)((Iterator) (obj)).next();
        if (manytoone != null)
        {
            tableinfo.manyToOneMap.put(manytoone.getColumn(), manytoone);
        }
          goto _L14
        OneToMany onetomany = (OneToMany)((Iterator) (obj)).next();
        if (onetomany != null)
        {
            tableinfo.oneToManyMap.put(onetomany.getColumn(), onetomany);
        }
          goto _L15
    }

    public static TableInfo get(String s)
    {
        try
        {
            s = get(Class.forName(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    public String getClassName()
    {
        return className;
    }

    public Id getId()
    {
        return id;
    }

    public String getTableName()
    {
        return tableName;
    }

    public boolean isCheckDatabese()
    {
        return checkDatabese;
    }

    public void setCheckDatabese(boolean flag)
    {
        checkDatabese = flag;
    }

    public void setClassName(String s)
    {
        className = s;
    }

    public void setId(Id id1)
    {
        id = id1;
    }

    public void setTableName(String s)
    {
        tableName = s;
    }

}
