// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ClassUtils
{

    public static final String INNER_CLASS_SEPARATOR = String.valueOf('$');
    public static final String PACKAGE_SEPARATOR = String.valueOf('.');
    private static final Map abbreviationMap = new HashMap();
    private static final Map primitiveWrapperMap;
    private static final Map reverseAbbreviationMap = new HashMap();
    private static final Map wrapperPrimitiveMap;

    private static void addAbbreviation(String s, String s1)
    {
        abbreviationMap.put(s, s1);
        reverseAbbreviationMap.put(s1, s);
    }

    public static String getShortClassName(Class class1)
    {
        if (class1 == null)
        {
            return "";
        } else
        {
            return getShortClassName(class1.getName());
        }
    }

    public static String getShortClassName(String s)
    {
        int i = 0;
        if (s == null)
        {
            return "";
        }
        if (s.length() == 0)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        String s1 = s;
        if (s.startsWith("["))
        {
            for (; s.charAt(0) == '['; stringbuilder.append("[]"))
            {
                s = s.substring(1);
            }

            s1 = s;
            if (s.charAt(0) == 'L')
            {
                s1 = s;
                if (s.charAt(s.length() - 1) == ';')
                {
                    s1 = s.substring(1, s.length() - 1);
                }
            }
        }
        s = s1;
        if (reverseAbbreviationMap.containsKey(s1))
        {
            s = (String)reverseAbbreviationMap.get(s1);
        }
        int j = s.lastIndexOf('.');
        if (j != -1)
        {
            i = j + 1;
        }
        i = s.indexOf('$', i);
        s1 = s.substring(j + 1);
        s = s1;
        if (i != -1)
        {
            s = s1.replace('$', '.');
        }
        return (new StringBuilder()).append(s).append(stringbuilder).toString();
    }

    static 
    {
        primitiveWrapperMap = new HashMap();
        primitiveWrapperMap.put(Boolean.TYPE, java/lang/Boolean);
        primitiveWrapperMap.put(Byte.TYPE, java/lang/Byte);
        primitiveWrapperMap.put(Character.TYPE, java/lang/Character);
        primitiveWrapperMap.put(Short.TYPE, java/lang/Short);
        primitiveWrapperMap.put(Integer.TYPE, java/lang/Integer);
        primitiveWrapperMap.put(Long.TYPE, java/lang/Long);
        primitiveWrapperMap.put(Double.TYPE, java/lang/Double);
        primitiveWrapperMap.put(Float.TYPE, java/lang/Float);
        primitiveWrapperMap.put(Void.TYPE, Void.TYPE);
        wrapperPrimitiveMap = new HashMap();
        Iterator iterator = primitiveWrapperMap.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Class class1 = (Class)iterator.next();
            Class class2 = (Class)primitiveWrapperMap.get(class1);
            if (!class1.equals(class2))
            {
                wrapperPrimitiveMap.put(class2, class1);
            }
        } while (true);
        addAbbreviation("int", "I");
        addAbbreviation("boolean", "Z");
        addAbbreviation("float", "F");
        addAbbreviation("long", "J");
        addAbbreviation("short", "S");
        addAbbreviation("byte", "B");
        addAbbreviation("double", "D");
        addAbbreviation("char", "C");
    }
}
