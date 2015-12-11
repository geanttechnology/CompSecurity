// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal.util;


// Referenced classes of package com.google.inject.internal.util:
//            StackTraceElements

public static class lineNumber
{

    private String declaringClass;
    private int lineNumber;
    private String methodName;

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof lineNumber))
            {
                return false;
            }
            obj = (lineNumber)obj;
            if (!((lineNumber) (obj)).declaringClass.equals(declaringClass) || ((declaringClass) (obj)).lineNumber != lineNumber || !methodName.equals(((methodName) (obj)).methodName))
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

    (StackTraceElement stacktraceelement)
    {
        this(stacktraceelement.getClassName(), stacktraceelement.getMethodName(), stacktraceelement.getLineNumber());
    }

    <init>(String s, String s1, int i)
    {
        declaringClass = s;
        methodName = s1;
        lineNumber = i;
    }
}
