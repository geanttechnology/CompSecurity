// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.tsz.afinal.annotation.sqlite.Id;
import net.tsz.afinal.annotation.sqlite.ManyToOne;
import net.tsz.afinal.annotation.sqlite.OneToMany;
import net.tsz.afinal.annotation.sqlite.Property;
import net.tsz.afinal.annotation.sqlite.Transient;

// Referenced classes of package net.tsz.afinal.reflect:
//            ClassUtils

public class FieldUtils
{

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public FieldUtils()
    {
    }

    public static Method getBooleanFieldGetMethod(Class class1, String s)
    {
        String s1 = (new StringBuilder("is")).append(s.substring(0, 1).toUpperCase()).append(s.substring(1)).toString();
        if (isISStart(s))
        {
            s1 = s;
        }
        try
        {
            class1 = class1.getDeclaredMethod(s1, new Class[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            class1.printStackTrace();
            return null;
        }
        return class1;
    }

    public static Method getBooleanFieldSetMethod(Class class1, Field field)
    {
        String s1 = field.getName();
        String s = (new StringBuilder("set")).append(s1.substring(0, 1).toUpperCase()).append(s1.substring(1)).toString();
        if (isISStart(field.getName()))
        {
            s = (new StringBuilder("set")).append(s1.substring(2, 3).toUpperCase()).append(s1.substring(3)).toString();
        }
        try
        {
            class1 = class1.getDeclaredMethod(s, new Class[] {
                field.getType()
            });
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            class1.printStackTrace();
            return null;
        }
        return class1;
    }

    public static String getColumnByField(Field field)
    {
        Object obj = (Property)field.getAnnotation(net/tsz/afinal/annotation/sqlite/Property);
        if (obj != null && ((Property) (obj)).column().trim().length() != 0)
        {
            return ((Property) (obj)).column();
        }
        obj = (ManyToOne)field.getAnnotation(net/tsz/afinal/annotation/sqlite/ManyToOne);
        if (obj != null && ((ManyToOne) (obj)).column().trim().length() != 0)
        {
            return ((ManyToOne) (obj)).column();
        }
        obj = (OneToMany)field.getAnnotation(net/tsz/afinal/annotation/sqlite/OneToMany);
        if (obj != null && ((OneToMany) (obj)).manyColumn() != null && ((OneToMany) (obj)).manyColumn().trim().length() != 0)
        {
            return ((OneToMany) (obj)).manyColumn();
        }
        obj = (Id)field.getAnnotation(net/tsz/afinal/annotation/sqlite/Id);
        if (obj != null && ((Id) (obj)).column().trim().length() != 0)
        {
            return ((Id) (obj)).column();
        } else
        {
            return field.getName();
        }
    }

    public static Field getFieldByColumnName(Class class1, String s)
    {
        Field field;
        Field field1;
        Object obj;
        obj = null;
        field = null;
        field1 = ((Field) (obj));
        if (s == null) goto _L2; else goto _L1
_L1:
        Field afield[];
        afield = class1.getDeclaredFields();
        field1 = ((Field) (obj));
        if (afield == null) goto _L2; else goto _L3
_L3:
        field1 = ((Field) (obj));
        if (afield.length <= 0) goto _L2; else goto _L4
_L4:
        field1 = field;
        if (s.equals(ClassUtils.getPrimaryKeyColumn(class1)))
        {
            field1 = ClassUtils.getPrimaryKeyField(class1);
        }
        field = field1;
        if (field1 != null) goto _L6; else goto _L5
_L5:
        int i;
        int j;
        j = afield.length;
        i = 0;
_L12:
        if (i < j) goto _L8; else goto _L7
_L7:
        field = field1;
_L6:
        field1 = field;
        if (field == null)
        {
            field1 = getFieldByName(class1, s);
        }
_L2:
        return field1;
_L8:
        field = afield[i];
        obj = (Property)field.getAnnotation(net/tsz/afinal/annotation/sqlite/Property);
        if (obj == null || !s.equals(((Property) (obj)).column())) goto _L9; else goto _L6
_L9:
        obj = (ManyToOne)field.getAnnotation(net/tsz/afinal/annotation/sqlite/ManyToOne);
        if (obj == null || ((ManyToOne) (obj)).column().trim().length() == 0) goto _L10; else goto _L6
_L10:
        i++;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public static Field getFieldByName(Class class1, String s)
    {
        Field field = null;
        if (s != null)
        {
            try
            {
                field = class1.getDeclaredField(s);
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                class1.printStackTrace();
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                class1.printStackTrace();
                return null;
            }
        }
        return field;
    }

    public static Method getFieldGetMethod(Class class1, String s)
    {
        s = (new StringBuilder("get")).append(s.substring(0, 1).toUpperCase()).append(s.substring(1)).toString();
        try
        {
            class1 = class1.getDeclaredMethod(s, new Class[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            class1.printStackTrace();
            return null;
        }
        return class1;
    }

    public static Method getFieldGetMethod(Class class1, Field field)
    {
        String s = field.getName();
        Method method = null;
        if (field.getType() == Boolean.TYPE)
        {
            method = getBooleanFieldGetMethod(class1, s);
        }
        field = method;
        if (method == null)
        {
            field = getFieldGetMethod(class1, s);
        }
        return field;
    }

    public static Method getFieldSetMethod(Class class1, String s)
    {
        class1 = getFieldSetMethod(class1, class1.getDeclaredField(s));
        return class1;
        class1;
        class1.printStackTrace();
_L2:
        return null;
        class1;
        class1.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static Method getFieldSetMethod(Class class1, Field field)
    {
        Object obj = field.getName();
        obj = (new StringBuilder("set")).append(((String) (obj)).substring(0, 1).toUpperCase()).append(((String) (obj)).substring(1)).toString();
        try
        {
            obj = class1.getDeclaredMethod(((String) (obj)), new Class[] {
                field.getType()
            });
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            if (field.getType() == Boolean.TYPE)
            {
                return getBooleanFieldSetMethod(class1, field);
            } else
            {
                return null;
            }
        }
        return ((Method) (obj));
    }

    public static Object getFieldValue(Object obj, String s)
    {
        return invoke(obj, getFieldGetMethod(obj.getClass(), s));
    }

    public static Object getFieldValue(Object obj, Field field)
    {
        return invoke(obj, getFieldGetMethod(obj.getClass(), field));
    }

    public static String getPropertyDefaultValue(Field field)
    {
        field = (Property)field.getAnnotation(net/tsz/afinal/annotation/sqlite/Property);
        if (field != null && field.defaultValue().trim().length() != 0)
        {
            return field.defaultValue();
        } else
        {
            return null;
        }
    }

    private static Object invoke(Object obj, Method method)
    {
        if (obj == null || method == null)
        {
            return null;
        }
        try
        {
            obj = method.invoke(obj, new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IllegalArgumentException) (obj)).printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IllegalAccessException) (obj)).printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((InvocationTargetException) (obj)).printStackTrace();
            return null;
        }
        return obj;
    }

    public static boolean isBaseDateType(Field field)
    {
        field = field.getType();
        return field.equals(java/lang/String) || field.equals(java/lang/Integer) || field.equals(java/lang/Byte) || field.equals(java/lang/Long) || field.equals(java/lang/Double) || field.equals(java/lang/Float) || field.equals(java/lang/Character) || field.equals(java/lang/Short) || field.equals(java/lang/Boolean) || field.equals(java/util/Date) || field.equals(java/util/Date) || field.equals(java/sql/Date) || field.isPrimitive();
    }

    private static boolean isISStart(String s)
    {
        while (s == null || s.trim().length() == 0 || !s.startsWith("is") || Character.isLowerCase(s.charAt(2))) 
        {
            return false;
        }
        return true;
    }

    public static boolean isManyToOne(Field field)
    {
        return field.getAnnotation(net/tsz/afinal/annotation/sqlite/ManyToOne) != null;
    }

    public static boolean isManyToOneOrOneToMany(Field field)
    {
        return isManyToOne(field) || isOneToMany(field);
    }

    public static boolean isOneToMany(Field field)
    {
        return field.getAnnotation(net/tsz/afinal/annotation/sqlite/OneToMany) != null;
    }

    public static boolean isTransient(Field field)
    {
        return field.getAnnotation(net/tsz/afinal/annotation/sqlite/Transient) != null;
    }

    public static void setFieldValue(Object obj, Field field, Object obj1)
    {
        Object obj2 = null;
        Method method = getFieldSetMethod(obj.getClass(), field);
        if (method == null)
        {
            break MISSING_BLOCK_LABEL_284;
        }
        method.setAccessible(true);
        field = field.getType();
        int i;
        if (field == java/lang/String)
        {
            try
            {
                method.invoke(obj, new Object[] {
                    obj1.toString()
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
            }
            return;
        }
        if (field != Integer.TYPE && field != java/lang/Integer)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        throw new NullPointerException();
_L1:
        method.invoke(obj, new Object[] {
            Integer.valueOf(i)
        });
        return;
        i = Integer.parseInt(obj1.toString());
          goto _L1
        if (field != Float.TYPE && field != java/lang/Float)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        throw new NullPointerException();
        f = Float.parseFloat(obj1.toString());
        method.invoke(obj, new Object[] {
            Float.valueOf(f)
        });
        return;
        if (field != Long.TYPE && field != java/lang/Long)
        {
            break MISSING_BLOCK_LABEL_229;
        }
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_217;
        }
        throw new NullPointerException();
        l = Long.parseLong(obj1.toString());
        method.invoke(obj, new Object[] {
            Long.valueOf(l)
        });
        return;
        if (field != java/util/Date)
        {
            break MISSING_BLOCK_LABEL_269;
        }
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_258;
        }
        field = obj2;
_L3:
        method.invoke(obj, new Object[] {
            field
        });
        return;
        field = stringToDateTime(obj1.toString());
        if (true) goto _L3; else goto _L2
_L2:
        method.invoke(obj, new Object[] {
            obj1
        });
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

}
