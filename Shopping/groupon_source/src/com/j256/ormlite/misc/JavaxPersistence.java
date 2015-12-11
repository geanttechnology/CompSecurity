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

    public static DatabaseFieldConfig createFieldConfig(DatabaseType databasetype, Field field)
        throws SQLException
    {
        Annotation annotation3;
        DatabaseFieldConfig databasefieldconfig;
        Annotation annotation9 = null;
        Annotation annotation8 = null;
        Annotation annotation7 = null;
        Annotation annotation6 = null;
        Annotation annotation5 = null;
        Annotation annotation4 = null;
        annotation3 = null;
        Annotation annotation2 = null;
        Annotation annotation1 = null;
        Annotation aannotation[] = field.getAnnotations();
        int j = aannotation.length;
        for (int i = 0; i < j; i++)
        {
            Annotation annotation = aannotation[i];
            Class class1 = annotation.annotationType();
            if (class1.getName().equals("javax.persistence.Column"))
            {
                annotation9 = annotation;
            }
            if (class1.getName().equals("javax.persistence.Basic"))
            {
                annotation8 = annotation;
            }
            if (class1.getName().equals("javax.persistence.Id"))
            {
                annotation7 = annotation;
            }
            if (class1.getName().equals("javax.persistence.GeneratedValue"))
            {
                annotation6 = annotation;
            }
            if (class1.getName().equals("javax.persistence.OneToOne"))
            {
                annotation5 = annotation;
            }
            if (class1.getName().equals("javax.persistence.ManyToOne"))
            {
                annotation4 = annotation;
            }
            if (class1.getName().equals("javax.persistence.JoinColumn"))
            {
                annotation3 = annotation;
            }
            if (class1.getName().equals("javax.persistence.Enumerated"))
            {
                annotation2 = annotation;
            }
            if (class1.getName().equals("javax.persistence.Version"))
            {
                annotation1 = annotation;
            }
        }

        if (annotation9 == null && annotation8 == null && annotation7 == null && annotation5 == null && annotation4 == null && annotation2 == null && annotation1 == null)
        {
            return null;
        }
        databasefieldconfig = new DatabaseFieldConfig();
        String s1 = field.getName();
        String s = s1;
        if (databasetype.isEntityNamesMustBeUpCase())
        {
            s = s1.toUpperCase();
        }
        databasefieldconfig.setFieldName(s);
        if (annotation9 == null)
        {
            break MISSING_BLOCK_LABEL_495;
        }
        try
        {
            databasetype = (String)annotation9.getClass().getMethod("name", new Class[0]).invoke(annotation9, new Object[0]);
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
            databasefieldconfig.setColumnName(databasetype);
        }
        databasetype = (String)annotation9.getClass().getMethod("columnDefinition", new Class[0]).invoke(annotation9, new Object[0]);
        if (databasetype == null)
        {
            break MISSING_BLOCK_LABEL_381;
        }
        if (databasetype.length() > 0)
        {
            databasefieldconfig.setColumnDefinition(databasetype);
        }
        databasefieldconfig.setWidth(((Integer)annotation9.getClass().getMethod("length", new Class[0]).invoke(annotation9, new Object[0])).intValue());
        databasetype = (Boolean)annotation9.getClass().getMethod("nullable", new Class[0]).invoke(annotation9, new Object[0]);
        if (databasetype == null)
        {
            break MISSING_BLOCK_LABEL_455;
        }
        databasefieldconfig.setCanBeNull(databasetype.booleanValue());
        databasetype = (Boolean)annotation9.getClass().getMethod("unique", new Class[0]).invoke(annotation9, new Object[0]);
        if (databasetype == null)
        {
            break MISSING_BLOCK_LABEL_495;
        }
        databasefieldconfig.setUnique(databasetype.booleanValue());
        if (annotation8 == null) goto _L2; else goto _L1
_L1:
        try
        {
            databasetype = (Boolean)annotation8.getClass().getMethod("optional", new Class[0]).invoke(annotation8, new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (DatabaseType databasetype)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Problem accessing fields from the @Basic annotation for field ").append(field).toString(), databasetype);
        }
        if (databasetype != null) goto _L4; else goto _L3
_L3:
        databasefieldconfig.setCanBeNull(true);
_L2:
        if (annotation7 != null)
        {
            if (annotation6 == null)
            {
                databasefieldconfig.setId(true);
            } else
            {
                databasefieldconfig.setGeneratedId(true);
            }
        }
        if (annotation5 == null && annotation4 == null) goto _L6; else goto _L5
_L5:
        if (!java/util/Collection.isAssignableFrom(field.getType()) && !com/j256/ormlite/dao/ForeignCollection.isAssignableFrom(field.getType())) goto _L8; else goto _L7
_L7:
        databasefieldconfig.setForeignCollection(true);
        if (annotation3 == null) goto _L6; else goto _L9
_L9:
        try
        {
            databasetype = (String)annotation3.getClass().getMethod("name", new Class[0]).invoke(annotation3, new Object[0]);
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
            databasefieldconfig.setForeignCollectionColumnName(databasetype);
        }
        databasetype = ((DatabaseType) (annotation3.getClass().getMethod("fetch", new Class[0]).invoke(annotation3, new Object[0])));
        if (databasetype == null) goto _L6; else goto _L10
_L10:
        if (databasetype.toString().equals("EAGER"))
        {
            databasefieldconfig.setForeignCollectionEager(true);
        }
_L6:
        if (annotation2 == null)
        {
            break MISSING_BLOCK_LABEL_741;
        }
        try
        {
            databasetype = ((DatabaseType) (annotation2.getClass().getMethod("value", new Class[0]).invoke(annotation2, new Object[0])));
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
        databasefieldconfig.setDataType(DataType.ENUM_STRING);
_L13:
        if (annotation1 != null)
        {
            databasefieldconfig.setVersion(true);
        }
        if (databasefieldconfig.getDataPersister() == null)
        {
            databasefieldconfig.setDataPersister(DataPersisterManager.lookupForField(field));
        }
        boolean flag;
        if (DatabaseFieldConfig.findGetMethod(field, false) != null && DatabaseFieldConfig.findSetMethod(field, false) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        databasefieldconfig.setUseGetSet(flag);
        return databasefieldconfig;
_L4:
        databasefieldconfig.setCanBeNull(databasetype.booleanValue());
          goto _L2
_L8:
        databasefieldconfig.setForeign(true);
        if (annotation3 == null) goto _L6; else goto _L11
_L11:
        try
        {
            databasetype = (String)annotation3.getClass().getMethod("name", new Class[0]).invoke(annotation3, new Object[0]);
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
            databasefieldconfig.setColumnName(databasetype);
        }
        databasetype = (Boolean)annotation3.getClass().getMethod("nullable", new Class[0]).invoke(annotation3, new Object[0]);
        if (databasetype == null)
        {
            break MISSING_BLOCK_LABEL_988;
        }
        databasefieldconfig.setCanBeNull(databasetype.booleanValue());
        databasetype = (Boolean)annotation3.getClass().getMethod("unique", new Class[0]).invoke(annotation3, new Object[0]);
        if (databasetype == null) goto _L6; else goto _L12
_L12:
        databasefieldconfig.setUnique(databasetype.booleanValue());
          goto _L6
        databasefieldconfig.setDataType(DataType.ENUM_INTEGER);
          goto _L13
    }

    public static String getEntityName(Class class1)
    {
        Object obj;
        obj = null;
        Annotation aannotation[] = class1.getAnnotations();
        int k = aannotation.length;
        for (int i = 0; i < k; i++)
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
