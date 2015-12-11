// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.misc;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataPersisterManager;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseFieldConfig;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Collection;

// Referenced classes of package com.j256.ormlite.misc:
//            SqlExceptionUtil

public class JavaxPersistence
{

    public JavaxPersistence()
    {
    }

    public static DatabaseFieldConfig createFieldConfig(DatabaseType databasetype, Field field)
        throws SQLException
    {
        Annotation annotation8 = null;
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
                annotation8 = ((Annotation) (obj));
            }
            if (((Class) (obj1)).getName().equals("javax.persistence.Basic"))
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
        if (annotation8 == null && annotation7 == null && annotation6 == null && annotation4 == null && annotation3 == null && annotation1 == null && annotation == null)
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
        if (annotation8 == null)
        {
            break MISSING_BLOCK_LABEL_495;
        }
        try
        {
            databasetype = (String)annotation8.getClass().getMethod("name", new Class[0]).invoke(annotation8, new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (DatabaseType databasetype)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Problem accessing fields from the @Column annotation for field ").append(field).toString(), databasetype);
        }
        if (databasetype == null)
        {
            break MISSING_BLOCK_LABEL_337;
        }
        if (databasetype.length() > 0)
        {
            ((DatabaseFieldConfig) (obj1)).setColumnName(databasetype);
        }
        databasetype = (String)annotation8.getClass().getMethod("columnDefinition", new Class[0]).invoke(annotation8, new Object[0]);
        if (databasetype == null)
        {
            break MISSING_BLOCK_LABEL_381;
        }
        if (databasetype.length() > 0)
        {
            ((DatabaseFieldConfig) (obj1)).setColumnDefinition(databasetype);
        }
        ((DatabaseFieldConfig) (obj1)).setWidth(((Integer)annotation8.getClass().getMethod("length", new Class[0]).invoke(annotation8, new Object[0])).intValue());
        databasetype = (Boolean)annotation8.getClass().getMethod("nullable", new Class[0]).invoke(annotation8, new Object[0]);
        if (databasetype == null)
        {
            break MISSING_BLOCK_LABEL_455;
        }
        ((DatabaseFieldConfig) (obj1)).setCanBeNull(databasetype.booleanValue());
        databasetype = (Boolean)annotation8.getClass().getMethod("unique", new Class[0]).invoke(annotation8, new Object[0]);
        if (databasetype == null)
        {
            break MISSING_BLOCK_LABEL_495;
        }
        ((DatabaseFieldConfig) (obj1)).setUnique(databasetype.booleanValue());
        if (annotation7 == null) goto _L2; else goto _L1
_L1:
        try
        {
            databasetype = (Boolean)annotation7.getClass().getMethod("optional", new Class[0]).invoke(annotation7, new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (DatabaseType databasetype)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Problem accessing fields from the @Basic annotation for field ").append(field).toString(), databasetype);
        }
        if (databasetype != null) goto _L4; else goto _L3
_L3:
        ((DatabaseFieldConfig) (obj1)).setCanBeNull(true);
_L2:
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
        if (annotation4 == null && annotation3 == null) goto _L6; else goto _L5
_L5:
        if (!java/util/Collection.isAssignableFrom(field.getType()) && !com/j256/ormlite/dao/ForeignCollection.isAssignableFrom(field.getType())) goto _L8; else goto _L7
_L7:
        ((DatabaseFieldConfig) (obj1)).setForeignCollection(true);
        if (annotation2 == null) goto _L6; else goto _L9
_L9:
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
            break MISSING_BLOCK_LABEL_642;
        }
        if (databasetype.length() > 0)
        {
            ((DatabaseFieldConfig) (obj1)).setForeignCollectionColumnName(databasetype);
        }
        databasetype = ((DatabaseType) (annotation2.getClass().getMethod("fetch", new Class[0]).invoke(annotation2, new Object[0])));
        if (databasetype == null) goto _L6; else goto _L10
_L10:
        if (databasetype.toString().equals("EAGER"))
        {
            ((DatabaseFieldConfig) (obj1)).setForeignCollectionEager(true);
        }
_L6:
        if (annotation1 == null)
        {
            break MISSING_BLOCK_LABEL_741;
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
            break MISSING_BLOCK_LABEL_1056;
        }
        if (!databasetype.toString().equals("STRING"))
        {
            break MISSING_BLOCK_LABEL_1056;
        }
        ((DatabaseFieldConfig) (obj1)).setDataType(DataType.ENUM_STRING);
_L13:
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
_L4:
        ((DatabaseFieldConfig) (obj1)).setCanBeNull(databasetype.booleanValue());
          goto _L2
_L8:
        ((DatabaseFieldConfig) (obj1)).setForeign(true);
        if (annotation2 == null) goto _L6; else goto _L11
_L11:
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
            break MISSING_BLOCK_LABEL_948;
        }
        if (databasetype.length() > 0)
        {
            ((DatabaseFieldConfig) (obj1)).setColumnName(databasetype);
        }
        databasetype = (Boolean)annotation2.getClass().getMethod("nullable", new Class[0]).invoke(annotation2, new Object[0]);
        if (databasetype == null)
        {
            break MISSING_BLOCK_LABEL_988;
        }
        ((DatabaseFieldConfig) (obj1)).setCanBeNull(databasetype.booleanValue());
        databasetype = (Boolean)annotation2.getClass().getMethod("unique", new Class[0]).invoke(annotation2, new Object[0]);
        if (databasetype == null) goto _L6; else goto _L12
_L12:
        ((DatabaseFieldConfig) (obj1)).setUnique(databasetype.booleanValue());
          goto _L6
        ((DatabaseFieldConfig) (obj1)).setDataType(DataType.ENUM_INTEGER);
          goto _L13
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
