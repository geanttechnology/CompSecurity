// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import net.tsz.afinal.annotation.sqlite.Id;
import net.tsz.afinal.annotation.sqlite.Table;
import net.tsz.afinal.db.table.ManyToOne;
import net.tsz.afinal.db.table.OneToMany;
import net.tsz.afinal.db.table.Property;
import net.tsz.afinal.exception.DbException;

// Referenced classes of package net.tsz.afinal.reflect:
//            FieldUtils

public class ClassUtils
{

    public ClassUtils()
    {
    }

    public static List getManyToOneList(Class class1)
    {
        ArrayList arraylist;
        int i;
        int j;
        arraylist = new ArrayList();
        Field afield[];
        Field field;
        ManyToOne manytoone;
        try
        {
            afield = class1.getDeclaredFields();
            j = afield.length;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RuntimeException(class1.getMessage(), class1);
        }
        i = 0;
          goto _L1
_L3:
        field = afield[i];
        if (!FieldUtils.isTransient(field) && FieldUtils.isManyToOne(field))
        {
            manytoone = new ManyToOne();
            manytoone.setManyClass(field.getType());
            manytoone.setColumn(FieldUtils.getColumnByField(field));
            manytoone.setFieldName(field.getName());
            manytoone.setDataType(field.getType());
            manytoone.setSet(FieldUtils.getFieldSetMethod(class1, field));
            manytoone.setGet(FieldUtils.getFieldGetMethod(class1, field));
            arraylist.add(manytoone);
        }
        i++;
_L1:
        if (i < j) goto _L3; else goto _L2
_L2:
        return arraylist;
    }

    public static List getOneToManyList(Class class1)
    {
        ArrayList arraylist;
        int i;
        int j;
        i = 0;
        arraylist = new ArrayList();
        Field afield[];
        Field field;
        OneToMany onetomany;
        Class class2;
        try
        {
            afield = class1.getDeclaredFields();
            j = afield.length;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RuntimeException(class1.getMessage(), class1);
        }
          goto _L1
_L3:
        field = afield[i];
        if (FieldUtils.isTransient(field) || !FieldUtils.isOneToMany(field))
        {
            break; /* Loop/switch isn't completed */
        }
        onetomany = new OneToMany();
        onetomany.setColumn(FieldUtils.getColumnByField(field));
        onetomany.setFieldName(field.getName());
        if (!(field.getGenericType() instanceof ParameterizedType))
        {
            break MISSING_BLOCK_LABEL_151;
        }
        class2 = (Class)((ParameterizedType)field.getGenericType()).getActualTypeArguments()[0];
        if (class2 == null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        onetomany.setOneClass(class2);
        onetomany.setDataType(field.getClass());
        onetomany.setSet(FieldUtils.getFieldSetMethod(class1, field));
        onetomany.setGet(FieldUtils.getFieldGetMethod(class1, field));
        arraylist.add(onetomany);
        break; /* Loop/switch isn't completed */
        throw new DbException((new StringBuilder("getOneToManyList Exception:")).append(field.getName()).append("'s type is null").toString());
_L1:
        if (i >= j)
        {
            return arraylist;
        }
        if (true) goto _L3; else goto _L2
_L2:
        i++;
          goto _L1
        if (true) goto _L3; else goto _L4
_L4:
    }

    public static String getPrimaryKeyColumn(Class class1)
    {
        Field field;
        String s;
        Field afield[];
        int i;
        boolean flag;
        int j;
        flag = false;
        s = null;
        afield = class1.getDeclaredFields();
        if (afield == null)
        {
            break MISSING_BLOCK_LABEL_192;
        }
        class1 = null;
        field = null;
        j = afield.length;
        i = 0;
_L3:
        if (i < j)
        {
label0:
            {
                Field field1 = afield[i];
                class1 = (Id)field1.getAnnotation(net/tsz/afinal/annotation/sqlite/Id);
                if (class1 == null)
                {
                    break label0;
                }
                field = field1;
            }
        }
_L9:
        if (class1 == null) goto _L2; else goto _L1
_L1:
label1:
        {
            s = class1.column();
            if (s != null)
            {
                class1 = s;
                if (s.trim().length() != 0)
                {
                    break label1;
                }
            }
            class1 = field.getName();
        }
_L6:
        return class1;
        i++;
          goto _L3
_L2:
        j = afield.length;
        i = 0;
_L7:
        if (i < j) goto _L5; else goto _L4
_L4:
        j = afield.length;
        i = ((flag) ? 1 : 0);
_L8:
        class1 = s;
        if (i < j)
        {
            if ("id".equals(afield[i].getName()))
            {
                return "id";
            }
            break MISSING_BLOCK_LABEL_183;
        }
          goto _L6
_L5:
        if ("_id".equals(afield[i].getName()))
        {
            return "_id";
        }
        i++;
          goto _L7
        i++;
          goto _L8
        throw new RuntimeException((new StringBuilder("this model[")).append(class1).append("] has no field").toString());
          goto _L9
    }

    public static Field getPrimaryKeyField(Class class1)
    {
        boolean flag = false;
        Object obj = null;
        Field afield[] = class1.getDeclaredFields();
        int i;
        int j;
        if (afield != null)
        {
            j = afield.length;
            i = 0;
        } else
        {
            throw new RuntimeException((new StringBuilder("this model[")).append(class1).append("] has no field").toString());
        }
        if (i >= j)
        {
            class1 = ((Class) (obj));
        } else
        {
            class1 = afield[i];
            if (class1.getAnnotation(net/tsz/afinal/annotation/sqlite/Id) == null)
            {
                i++;
                break MISSING_BLOCK_LABEL_20;
            }
        }
        obj = class1;
        if (class1 != null) goto _L2; else goto _L1
_L1:
        j = afield.length;
        i = 0;
_L8:
        if (i < j) goto _L4; else goto _L3
_L3:
        obj = class1;
_L2:
        if (obj != null) goto _L6; else goto _L5
_L5:
        j = afield.length;
        i = ((flag) ? 1 : 0);
_L9:
        if (i < j)
        {
            break MISSING_BLOCK_LABEL_116;
        }
_L6:
        return ((Field) (obj));
_L4:
        obj = afield[i];
        if (!"_id".equals(((Field) (obj)).getName())) goto _L7; else goto _L2
_L7:
        i++;
          goto _L8
        class1 = afield[i];
        if ("id".equals(class1.getName()))
        {
            return class1;
        }
        i++;
          goto _L9
    }

    public static String getPrimaryKeyFieldName(Class class1)
    {
        class1 = getPrimaryKeyField(class1);
        if (class1 == null)
        {
            return null;
        } else
        {
            return class1.getName();
        }
    }

    public static Object getPrimaryKeyValue(Object obj)
    {
        return FieldUtils.getFieldValue(obj, getPrimaryKeyField(obj.getClass()));
    }

    public static List getPropertyList(Class class1)
    {
        ArrayList arraylist;
        int i;
        int j;
        arraylist = new ArrayList();
        Field afield[];
        String s;
        Field field;
        Property property;
        try
        {
            afield = class1.getDeclaredFields();
            s = getPrimaryKeyFieldName(class1);
            j = afield.length;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RuntimeException(class1.getMessage(), class1);
        }
        i = 0;
          goto _L1
_L3:
        field = afield[i];
        if (FieldUtils.isTransient(field) || !FieldUtils.isBaseDateType(field) || field.getName().equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        property = new Property();
        property.setColumn(FieldUtils.getColumnByField(field));
        property.setFieldName(field.getName());
        property.setDataType(field.getType());
        property.setDefaultValue(FieldUtils.getPropertyDefaultValue(field));
        property.setSet(FieldUtils.getFieldSetMethod(class1, field));
        property.setGet(FieldUtils.getFieldGetMethod(class1, field));
        property.setField(field);
        arraylist.add(property);
        break; /* Loop/switch isn't completed */
_L1:
        if (i >= j)
        {
            return arraylist;
        }
        if (true) goto _L3; else goto _L2
_L2:
        i++;
          goto _L1
        if (true) goto _L3; else goto _L4
_L4:
    }

    public static String getTableName(Class class1)
    {
        Table table = (Table)class1.getAnnotation(net/tsz/afinal/annotation/sqlite/Table);
        if (table == null || table.name().trim().length() == 0)
        {
            return class1.getName().replace('.', '_');
        } else
        {
            return table.name();
        }
    }
}
