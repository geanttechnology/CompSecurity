// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.misc;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataPersisterManager;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseFieldConfig;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// Referenced classes of package com.j256.ormlite.misc:
//            SqlExceptionUtil

public class JavaxPersistence
{

    public JavaxPersistence()
    {
    }

    public static DatabaseFieldConfig createFieldConfig(DatabaseType databasetype, Field field)
    {
        Annotation annotation7 = null;
        Annotation annotation6 = null;
        Annotation annotation5 = null;
        Annotation annotation4 = null;
        Annotation annotation3 = null;
        Annotation annotation2 = null;
        Annotation annotation1 = null;
        Annotation annotation = null;
        Annotation aannotation[] = field.getAnnotations();
        int j = aannotation.length;
        int i = 0;
        while (i < j) 
        {
            Object obj = aannotation[i];
            Object obj1 = ((Annotation) (obj)).annotationType();
            if (((Class) (obj1)).getName().equals("javax.persistence.Column"))
            {
                annotation7 = ((Annotation) (obj));
            }
            if (((Class) (obj1)).getName().equals("javax.persistence.Id"))
            {
                annotation6 = ((Annotation) (obj));
            }
            if (((Class) (obj1)).getName().equals("javax.persistence.GeneratedValue"))
            {
                annotation5 = ((Annotation) (obj));
            }
            if (((Class) (obj1)).getName().equals("javax.persistence.OneToOne"))
            {
                annotation4 = ((Annotation) (obj));
            }
            if (((Class) (obj1)).getName().equals("javax.persistence.ManyToOne"))
            {
                annotation3 = ((Annotation) (obj));
            }
            if (((Class) (obj1)).getName().equals("javax.persistence.JoinColumn"))
            {
                annotation2 = ((Annotation) (obj));
            }
            if (((Class) (obj1)).getName().equals("javax.persistence.Enumerated"))
            {
                annotation1 = ((Annotation) (obj));
            }
            String s;
            boolean flag;
            if (!((Class) (obj1)).getName().equals("javax.persistence.Version"))
            {
                obj = annotation;
            }
            i++;
            annotation = ((Annotation) (obj));
        }
        if (annotation7 == null && annotation6 == null && annotation4 == null && annotation3 == null && annotation1 == null && annotation == null)
        {
            return null;
        }
        obj1 = new DatabaseFieldConfig();
        s = field.getName();
        obj = s;
        if (databasetype.isEntityNamesMustBeUpCase())
        {
            obj = s.toUpperCase();
        }
        ((DatabaseFieldConfig) (obj1)).setFieldName(((String) (obj)));
        if (annotation7 == null)
        {
            break MISSING_BLOCK_LABEL_471;
        }
        try
        {
            databasetype = (String)annotation7.getClass().getMethod("name", new Class[0]).invoke(annotation7, new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (DatabaseType databasetype)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Problem accessing fields from the @Column annotation for field ").append(field).toString(), databasetype);
        }
        if (databasetype == null)
        {
            break MISSING_BLOCK_LABEL_313;
        }
        if (databasetype.length() > 0)
        {
            ((DatabaseFieldConfig) (obj1)).setColumnName(databasetype);
        }
        databasetype = (String)annotation7.getClass().getMethod("columnDefinition", new Class[0]).invoke(annotation7, new Object[0]);
        if (databasetype == null)
        {
            break MISSING_BLOCK_LABEL_357;
        }
        if (databasetype.length() > 0)
        {
            ((DatabaseFieldConfig) (obj1)).setColumnDefinition(databasetype);
        }
        ((DatabaseFieldConfig) (obj1)).setWidth(((Integer)annotation7.getClass().getMethod("length", new Class[0]).invoke(annotation7, new Object[0])).intValue());
        databasetype = (Boolean)annotation7.getClass().getMethod("nullable", new Class[0]).invoke(annotation7, new Object[0]);
        if (databasetype == null)
        {
            break MISSING_BLOCK_LABEL_431;
        }
        ((DatabaseFieldConfig) (obj1)).setCanBeNull(databasetype.booleanValue());
        databasetype = (Boolean)annotation7.getClass().getMethod("unique", new Class[0]).invoke(annotation7, new Object[0]);
        if (databasetype == null)
        {
            break MISSING_BLOCK_LABEL_471;
        }
        ((DatabaseFieldConfig) (obj1)).setUnique(databasetype.booleanValue());
        if (annotation6 != null)
        {
            if (annotation5 == null)
            {
                ((DatabaseFieldConfig) (obj1)).setId(true);
            } else
            {
                ((DatabaseFieldConfig) (obj1)).setGeneratedId(true);
            }
        }
        if (annotation4 == null && annotation3 == null)
        {
            break MISSING_BLOCK_LABEL_632;
        }
        ((DatabaseFieldConfig) (obj1)).setForeign(true);
        if (annotation2 == null)
        {
            break MISSING_BLOCK_LABEL_632;
        }
        try
        {
            databasetype = (String)annotation2.getClass().getMethod("name", new Class[0]).invoke(annotation2, new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (DatabaseType databasetype)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Problem accessing fields from the @JoinColumn annotation for field ").append(field).toString(), databasetype);
        }
        if (databasetype == null)
        {
            break MISSING_BLOCK_LABEL_552;
        }
        if (databasetype.length() > 0)
        {
            ((DatabaseFieldConfig) (obj1)).setColumnName(databasetype);
        }
        databasetype = (Boolean)annotation2.getClass().getMethod("nullable", new Class[0]).invoke(annotation2, new Object[0]);
        if (databasetype == null)
        {
            break MISSING_BLOCK_LABEL_592;
        }
        ((DatabaseFieldConfig) (obj1)).setCanBeNull(databasetype.booleanValue());
        databasetype = (Boolean)annotation2.getClass().getMethod("unique", new Class[0]).invoke(annotation2, new Object[0]);
        if (databasetype == null)
        {
            break MISSING_BLOCK_LABEL_632;
        }
        ((DatabaseFieldConfig) (obj1)).setUnique(databasetype.booleanValue());
        if (annotation1 == null)
        {
            break MISSING_BLOCK_LABEL_685;
        }
        try
        {
            databasetype = ((DatabaseType) (annotation1.getClass().getMethod("value", new Class[0]).invoke(annotation1, new Object[0])));
        }
        // Misplaced declaration of an exception variable
        catch (DatabaseType databasetype)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Problem accessing fields from the @Enumerated annotation for field ").append(field).toString(), databasetype);
        }
        if (databasetype == null)
        {
            break MISSING_BLOCK_LABEL_800;
        }
        if (!databasetype.toString().equals("STRING"))
        {
            break MISSING_BLOCK_LABEL_800;
        }
        ((DatabaseFieldConfig) (obj1)).setDataType(DataType.ENUM_STRING);
_L1:
        if (annotation != null)
        {
            ((DatabaseFieldConfig) (obj1)).setVersion(true);
        }
        if (((DatabaseFieldConfig) (obj1)).getDataPersister() == null)
        {
            ((DatabaseFieldConfig) (obj1)).setDataPersister(DataPersisterManager.lookupForField(field));
        }
        if (DatabaseFieldConfig.findGetMethod(field, false) != null && DatabaseFieldConfig.findSetMethod(field, false) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((DatabaseFieldConfig) (obj1)).setUseGetSet(flag);
        return ((DatabaseFieldConfig) (obj1));
        ((DatabaseFieldConfig) (obj1)).setDataType(DataType.ENUM_INTEGER);
          goto _L1
    }

    public static String getEntityName(Class class1)
    {
        Object obj;
        Annotation aannotation[] = class1.getAnnotations();
        int k = aannotation.length;
        int i = 0;
        obj = null;
        for (; i < k; i++)
        {
            Annotation annotation = aannotation[i];
            if (annotation.annotationType().getName().equals("javax.persistence.Entity"))
            {
                obj = annotation;
            }
        }

        if (obj != null) goto _L2; else goto _L1
_L1:
        class1 = null;
_L4:
        return class1;
_L2:
        int j;
        try
        {
            obj = (String)obj.getClass().getMethod("name", new Class[0]).invoke(obj, new Object[0]);
        }
        catch (Exception exception)
        {
            throw new IllegalStateException((new StringBuilder()).append("Could not get entity name from class ").append(class1).toString(), exception);
        }
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        j = ((String) (obj)).length();
        class1 = ((Class) (obj));
        if (j > 0) goto _L4; else goto _L3
_L3:
        return null;
    }
}
