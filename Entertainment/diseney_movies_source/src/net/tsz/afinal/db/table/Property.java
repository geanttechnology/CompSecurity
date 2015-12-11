// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.db.table;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Property
{

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String column;
    private Class dataType;
    private String defaultValue;
    private Field field;
    private String fieldName;
    private Method get;
    private Method set;

    public Property()
    {
    }

    private static Date stringToDateTime(String s)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        s = sdf.parse(s);
        return s;
        s;
        s.printStackTrace();
        return null;
    }

    public String getColumn()
    {
        return column;
    }

    public Class getDataType()
    {
        return dataType;
    }

    public String getDefaultValue()
    {
        return defaultValue;
    }

    public Field getField()
    {
        return field;
    }

    public String getFieldName()
    {
        return fieldName;
    }

    public Method getGet()
    {
        return get;
    }

    public Method getSet()
    {
        return set;
    }

    public Object getValue(Object obj)
    {
        if (obj == null || get == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        obj = get.invoke(obj, new Object[0]);
        return obj;
        obj;
        ((IllegalArgumentException) (obj)).printStackTrace();
_L2:
        return null;
        obj;
        ((IllegalAccessException) (obj)).printStackTrace();
        continue; /* Loop/switch isn't completed */
        obj;
        ((InvocationTargetException) (obj)).printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void setColumn(String s)
    {
        column = s;
    }

    public void setDataType(Class class1)
    {
        dataType = class1;
    }

    public void setDefaultValue(String s)
    {
        defaultValue = s;
    }

    public void setField(Field field1)
    {
        field = field1;
    }

    public void setFieldName(String s)
    {
        fieldName = s;
    }

    public void setGet(Method method)
    {
        get = method;
    }

    public void setSet(Method method)
    {
        set = method;
    }

    public void setValue(Object obj, Object obj1)
    {
        Method method;
        int i;
        method = null;
        if (set == null || obj1 == null)
        {
            break MISSING_BLOCK_LABEL_471;
        }
        try
        {
            if (dataType == java/lang/String)
            {
                set.invoke(obj, new Object[] {
                    obj1.toString()
                });
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return;
        }
        if (dataType != Integer.TYPE && dataType != java/lang/Integer)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        method = set;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        throw new NullPointerException();
_L1:
        method.invoke(obj, new Object[] {
            Integer.valueOf(i)
        });
        return;
        i = Integer.parseInt(obj1.toString());
          goto _L1
        if (dataType != Float.TYPE && dataType != java/lang/Float)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        method = set;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        throw new NullPointerException();
        f = Float.parseFloat(obj1.toString());
        method.invoke(obj, new Object[] {
            Float.valueOf(f)
        });
        return;
        if (dataType != Double.TYPE && dataType != java/lang/Double)
        {
            break MISSING_BLOCK_LABEL_255;
        }
        method = set;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_244;
        }
        throw new NullPointerException();
        d = Double.parseDouble(obj1.toString());
        method.invoke(obj, new Object[] {
            Double.valueOf(d)
        });
        return;
        if (dataType != Long.TYPE && dataType != java/lang/Long)
        {
            break MISSING_BLOCK_LABEL_324;
        }
        method = set;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_312;
        }
        throw new NullPointerException();
        l = Long.parseLong(obj1.toString());
        method.invoke(obj, new Object[] {
            Long.valueOf(l)
        });
        return;
        Method method1;
        if (dataType != java/util/Date && dataType != java/sql/Date)
        {
            break MISSING_BLOCK_LABEL_382;
        }
        method1 = set;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_371;
        }
        obj1 = method;
_L3:
        method1.invoke(obj, new Object[] {
            obj1
        });
        return;
        obj1 = stringToDateTime(obj1.toString());
        if (true) goto _L3; else goto _L2
_L2:
        if (dataType != Boolean.TYPE && dataType != java/lang/Boolean)
        {
            break MISSING_BLOCK_LABEL_453;
        }
        method = set;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_439;
        }
        throw new NullPointerException();
        flag = "1".equals(obj1.toString());
        method.invoke(obj, new Object[] {
            Boolean.valueOf(flag)
        });
        return;
        set.invoke(obj, new Object[] {
            obj1
        });
        return;
        try
        {
            field.setAccessible(true);
            field.set(obj, obj1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
        }
        return;
    }

}
