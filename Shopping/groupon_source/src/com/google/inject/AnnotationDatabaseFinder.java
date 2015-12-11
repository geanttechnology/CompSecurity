// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.inject:
//            AnnotationDatabase

public class AnnotationDatabaseFinder
{

    private HashSet bindableClassesSet;
    private HashSet classesContainingInjectionPointsSet;
    private HashMap mapAnnotationToMapClassContainingInjectionToInjectedConstructorSet;
    private HashMap mapAnnotationToMapClassContainingInjectionToInjectedFieldSet;
    private HashMap mapAnnotationToMapClassContainingInjectionToInjectedMethodSet;

    public AnnotationDatabaseFinder(String as[])
    {
        classesContainingInjectionPointsSet = new HashSet();
        mapAnnotationToMapClassContainingInjectionToInjectedFieldSet = new HashMap();
        mapAnnotationToMapClassContainingInjectionToInjectedMethodSet = new HashMap();
        mapAnnotationToMapClassContainingInjectionToInjectedConstructorSet = new HashMap();
        bindableClassesSet = new HashSet();
        String s;
        String s1;
        String s2;
        int i;
        int j;
        try
        {
            j = as.length;
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            as.printStackTrace();
            throw new RuntimeException(as);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            as.printStackTrace();
            throw new RuntimeException(as);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            as.printStackTrace();
            throw new RuntimeException(as);
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s2 = as[i];
        s1 = "AnnotationDatabaseImpl";
        s = s1;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        s = s1;
        if (!"".equals(s2))
        {
            s = (new StringBuilder()).append(s2).append(".").append("AnnotationDatabaseImpl").toString();
        }
        addAnnotationDatabase(getAnnotationDatabaseInstance(s));
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_66;
_L1:
    }

    private void addAnnotationDatabase(AnnotationDatabase annotationdatabase)
    {
        annotationdatabase.fillAnnotationClassesAndFieldsNames(mapAnnotationToMapClassContainingInjectionToInjectedFieldSet);
        annotationdatabase.fillAnnotationClassesAndMethods(mapAnnotationToMapClassContainingInjectionToInjectedMethodSet);
        annotationdatabase.fillAnnotationClassesAndConstructors(mapAnnotationToMapClassContainingInjectionToInjectedConstructorSet);
        annotationdatabase.fillClassesContainingInjectionPointSet(classesContainingInjectionPointsSet);
        annotationdatabase.fillBindableClasses(bindableClassesSet);
    }

    private AnnotationDatabase getAnnotationDatabaseInstance(String s)
        throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        return (AnnotationDatabase)Class.forName(s).newInstance();
    }

    public Set getBindableClassesSet()
    {
        return bindableClassesSet;
    }

    public HashSet getClassesContainingInjectionPointsSet()
    {
        return classesContainingInjectionPointsSet;
    }

    public HashMap getMapAnnotationToMapClassContainingInjectionToInjectedConstructorSet()
    {
        return mapAnnotationToMapClassContainingInjectionToInjectedConstructorSet;
    }

    public HashMap getMapAnnotationToMapClassContainingInjectionToInjectedFieldSet()
    {
        return mapAnnotationToMapClassContainingInjectionToInjectedFieldSet;
    }

    public HashMap getMapAnnotationToMapClassContainingInjectionToInjectedMethodSet()
    {
        return mapAnnotationToMapClassContainingInjectionToInjectedMethodSet;
    }
}
