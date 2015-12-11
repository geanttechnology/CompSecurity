// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.util.Map;
import org.roboguice.shaded.goole.common.collect.MapMaker;

// Referenced classes of package com.google.inject.internal.util:
//            SourceProvider, Classes

public class StackTraceElements
{
    public static class InMemoryStackTraceElement
    {

        private String declaringClass;
        private int lineNumber;
        private String methodName;

        public boolean equals(Object obj)
        {
            if (obj != this)
            {
                if (!(obj instanceof InMemoryStackTraceElement))
                {
                    return false;
                }
                obj = (InMemoryStackTraceElement)obj;
                if (!((InMemoryStackTraceElement) (obj)).declaringClass.equals(declaringClass) || ((InMemoryStackTraceElement) (obj)).lineNumber != lineNumber || !methodName.equals(((InMemoryStackTraceElement) (obj)).methodName))
                {
                    return false;
                }
            }
            return true;
        }

        String getClassName()
        {
            return declaringClass;
        }

        int getLineNumber()
        {
            return lineNumber;
        }

        String getMethodName()
        {
            return methodName;
        }

        public int hashCode()
        {
            return (declaringClass.hashCode() * 31 + methodName.hashCode()) * 31 + lineNumber;
        }

        public String toString()
        {
            return (new StringBuilder()).append(declaringClass).append(".").append(methodName).append("(").append(lineNumber).append(")").toString();
        }

        InMemoryStackTraceElement(StackTraceElement stacktraceelement)
        {
            this(stacktraceelement.getClassName(), stacktraceelement.getMethodName(), stacktraceelement.getLineNumber());
        }

        InMemoryStackTraceElement(String s, String s1, int i)
        {
            declaringClass = s;
            methodName = s1;
            lineNumber = i;
        }
    }


    private static final InMemoryStackTraceElement EMPTY_INMEMORY_STACK_TRACE[] = new InMemoryStackTraceElement[0];
    private static final StackTraceElement EMPTY_STACK_TRACE[] = new StackTraceElement[0];
    private static final String UNKNOWN_SOURCE = "Unknown Source";
    private static Map cache = (new MapMaker()).makeMap();

    public StackTraceElements()
    {
    }

    public static void clearCache()
    {
        cache.clear();
    }

    public static InMemoryStackTraceElement[] convertToInMemoryStackTraceElement(StackTraceElement astacktraceelement[])
    {
        if (astacktraceelement.length != 0) goto _L2; else goto _L1
_L1:
        InMemoryStackTraceElement ainmemorystacktraceelement[] = EMPTY_INMEMORY_STACK_TRACE;
_L4:
        return ainmemorystacktraceelement;
_L2:
        InMemoryStackTraceElement ainmemorystacktraceelement1[] = new InMemoryStackTraceElement[astacktraceelement.length];
        int i = 0;
        do
        {
            ainmemorystacktraceelement = ainmemorystacktraceelement1;
            if (i >= astacktraceelement.length)
            {
                continue;
            }
            ainmemorystacktraceelement1[i] = weakIntern(new InMemoryStackTraceElement(astacktraceelement[i]));
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static StackTraceElement[] convertToStackTraceElement(InMemoryStackTraceElement ainmemorystacktraceelement[])
    {
        if (ainmemorystacktraceelement.length != 0) goto _L2; else goto _L1
_L1:
        StackTraceElement astacktraceelement[] = EMPTY_STACK_TRACE;
_L4:
        return astacktraceelement;
_L2:
        StackTraceElement astacktraceelement1[] = new StackTraceElement[ainmemorystacktraceelement.length];
        int i = 0;
        do
        {
            astacktraceelement = astacktraceelement1;
            if (i >= ainmemorystacktraceelement.length)
            {
                continue;
            }
            astacktraceelement1[i] = new StackTraceElement(ainmemorystacktraceelement[i].getClassName(), ainmemorystacktraceelement[i].getMethodName(), "Unknown Source", ainmemorystacktraceelement[i].getLineNumber());
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static Object forMember(Member member)
    {
        if (member == null)
        {
            return SourceProvider.UNKNOWN_SOURCE;
        }
        Class class1 = member.getDeclaringClass();
        if (Classes.memberType(member) == java/lang/reflect/Constructor)
        {
            member = "<init>";
        } else
        {
            member = member.getName();
        }
        return new StackTraceElement(class1.getName(), member, null, -1);
    }

    public static Object forType(Class class1)
    {
        return new StackTraceElement(class1.getName(), "class", null, -1);
    }

    private static InMemoryStackTraceElement weakIntern(InMemoryStackTraceElement inmemorystacktraceelement)
    {
        InMemoryStackTraceElement inmemorystacktraceelement1 = (InMemoryStackTraceElement)cache.get(inmemorystacktraceelement);
        if (inmemorystacktraceelement1 != null)
        {
            return inmemorystacktraceelement1;
        } else
        {
            inmemorystacktraceelement = new InMemoryStackTraceElement(weakIntern(inmemorystacktraceelement.getClassName()), weakIntern(inmemorystacktraceelement.getMethodName()), inmemorystacktraceelement.getLineNumber());
            cache.put(inmemorystacktraceelement, inmemorystacktraceelement);
            return inmemorystacktraceelement;
        }
    }

    private static String weakIntern(String s)
    {
        String s1 = (String)cache.get(s);
        if (s1 != null)
        {
            return s1;
        } else
        {
            cache.put(s, s);
            return s;
        }
    }

}
