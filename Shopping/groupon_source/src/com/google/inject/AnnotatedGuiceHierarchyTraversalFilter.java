// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.inject:
//            HierarchyTraversalFilter, AnnotationDatabaseFinder

public class AnnotatedGuiceHierarchyTraversalFilter extends HierarchyTraversalFilter
{

    private HashSet classesContainingInjectionPointsSet;
    private HierarchyTraversalFilter _flddelegate;
    private boolean hasHadInjectionPoints;
    private HashMap mapAnnotationToMapClassWithInjectionNameToConstructorSet;
    private HashMap mapAnnotationToMapClassWithInjectionNameToFieldSet;
    private HashMap mapAnnotationToMapClassWithInjectionNameToMethodSet;

    public AnnotatedGuiceHierarchyTraversalFilter(AnnotationDatabaseFinder annotationdatabasefinder, HierarchyTraversalFilter hierarchytraversalfilter)
    {
        classesContainingInjectionPointsSet = new HashSet();
        _flddelegate = hierarchytraversalfilter;
        mapAnnotationToMapClassWithInjectionNameToFieldSet = annotationdatabasefinder.getMapAnnotationToMapClassContainingInjectionToInjectedFieldSet();
        mapAnnotationToMapClassWithInjectionNameToMethodSet = annotationdatabasefinder.getMapAnnotationToMapClassContainingInjectionToInjectedMethodSet();
        mapAnnotationToMapClassWithInjectionNameToConstructorSet = annotationdatabasefinder.getMapAnnotationToMapClassContainingInjectionToInjectedConstructorSet();
        classesContainingInjectionPointsSet = annotationdatabasefinder.getClassesContainingInjectionPointsSet();
        if (classesContainingInjectionPointsSet.isEmpty())
        {
            throw new IllegalStateException("Unable to find Annotation Database which should be output as part of annotation processing");
        } else
        {
            return;
        }
    }

    public Set getAllConstructors(String s, Class class1)
    {
        s = (Map)mapAnnotationToMapClassWithInjectionNameToConstructorSet.get(s);
        if (class1 == null || s == null) goto _L2; else goto _L1
_L1:
        s = (Set)s.get(class1.getName());
        if (s == null) goto _L2; else goto _L3
_L3:
        HashSet hashset = new HashSet();
        Iterator iterator = s.iterator();
_L7:
        s = hashset;
        Class aclass[];
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = ((String)iterator.next()).split(":");
        aclass = new Class[s.length - 1];
        int i = 1;
_L5:
        if (i >= s.length)
        {
            break; /* Loop/switch isn't completed */
        }
        aclass[i - 1] = getClass().getClassLoader().loadClass(s[i]);
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        hashset.add(class1.getDeclaredConstructor(aclass));
        if (true) goto _L7; else goto _L6
        s;
        s.printStackTrace();
_L2:
        s = Collections.emptySet();
_L6:
        return s;
    }

    public Set getAllFields(String s, Class class1)
    {
        s = (Map)mapAnnotationToMapClassWithInjectionNameToFieldSet.get(s);
        if (class1 == null || s == null) goto _L2; else goto _L1
_L1:
        s = (Set)s.get(class1.getName());
        if (s == null) goto _L2; else goto _L3
_L3:
        HashSet hashset = new HashSet();
        Iterator iterator = s.iterator();
_L5:
        s = hashset;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        hashset.add(class1.getDeclaredField((String)iterator.next()));
        if (true) goto _L5; else goto _L4
        s;
        s.printStackTrace();
_L2:
        s = Collections.emptySet();
_L4:
        return s;
    }

    public Set getAllMethods(String s, Class class1)
    {
        s = (Map)mapAnnotationToMapClassWithInjectionNameToMethodSet.get(s);
        if (class1 == null || s == null) goto _L2; else goto _L1
_L1:
        s = (Set)s.get(class1.getName());
        if (s == null) goto _L2; else goto _L3
_L3:
        HashSet hashset = new HashSet();
        Iterator iterator = s.iterator();
_L7:
        s = hashset;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = ((String)iterator.next()).split(":");
        String s1 = s[0];
        Class aclass[] = new Class[s.length - 1];
        int i = 1;
_L5:
        if (i >= s.length)
        {
            break; /* Loop/switch isn't completed */
        }
        aclass[i - 1] = getClass().getClassLoader().loadClass(s[i]);
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        hashset.add(class1.getDeclaredMethod(s1, aclass));
        if (true) goto _L7; else goto _L6
        s;
        s.printStackTrace();
_L2:
        s = Collections.emptySet();
_L6:
        return s;
    }

    public boolean isWorthScanning(Class class1)
    {
        if (hasHadInjectionPoints)
        {
            return _flddelegate.isWorthScanning(class1);
        }
        Class class2;
        if (class1 != null)
        {
            do
            {
                if (classesContainingInjectionPointsSet.contains(class1.getName()))
                {
                    hasHadInjectionPoints = true;
                    return true;
                }
                class2 = class1.getSuperclass();
                class1 = class2;
            } while (_flddelegate.isWorthScanning(class2));
        }
        return false;
    }

    public boolean isWorthScanningForConstructors(String s, Class class1)
    {
        boolean flag1 = false;
        boolean flag;
        if (hasHadInjectionPoints)
        {
            flag = _flddelegate.isWorthScanning(class1);
        } else
        {
            flag = flag1;
            if (class1 != null)
            {
                Map map = (Map)mapAnnotationToMapClassWithInjectionNameToConstructorSet.get(s);
                flag = flag1;
                if (map != null)
                {
                    do
                    {
                        if (map.containsKey(class1.getName()))
                        {
                            hasHadInjectionPoints = true;
                            return true;
                        }
                        s = class1.getSuperclass();
                        class1 = s;
                    } while (_flddelegate.isWorthScanning(s));
                    return false;
                }
            }
        }
        return flag;
    }

    public boolean isWorthScanningForFields(String s, Class class1)
    {
        boolean flag1 = false;
        boolean flag;
        if (hasHadInjectionPoints)
        {
            flag = _flddelegate.isWorthScanning(class1);
        } else
        {
            flag = flag1;
            if (class1 != null)
            {
                Map map = (Map)mapAnnotationToMapClassWithInjectionNameToFieldSet.get(s);
                flag = flag1;
                if (map != null)
                {
                    do
                    {
                        if (map.containsKey(class1.getName()))
                        {
                            hasHadInjectionPoints = true;
                            return true;
                        }
                        s = class1.getSuperclass();
                        class1 = s;
                    } while (_flddelegate.isWorthScanning(s));
                    return false;
                }
            }
        }
        return flag;
    }

    public boolean isWorthScanningForMethods(String s, Class class1)
    {
        boolean flag1 = false;
        boolean flag;
        if (hasHadInjectionPoints)
        {
            flag = _flddelegate.isWorthScanning(class1);
        } else
        {
            flag = flag1;
            if (class1 != null)
            {
                Map map = (Map)mapAnnotationToMapClassWithInjectionNameToMethodSet.get(s);
                flag = flag1;
                if (map != null)
                {
                    do
                    {
                        if (map.containsKey(class1.getName()))
                        {
                            hasHadInjectionPoints = true;
                            return true;
                        }
                        s = class1.getSuperclass();
                        class1 = s;
                    } while (_flddelegate.isWorthScanning(s));
                    return false;
                }
            }
        }
        return flag;
    }

    public void reset()
    {
        _flddelegate.reset();
        hasHadInjectionPoints = false;
    }
}
