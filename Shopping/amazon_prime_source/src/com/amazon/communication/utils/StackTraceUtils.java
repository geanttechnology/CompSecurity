// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.utils;


public final class StackTraceUtils
{

    public StackTraceUtils()
    {
    }

    public static String buildSingleLineFormattedStackTrace()
    {
        StringBuilder stringbuilder = new StringBuilder();
        StackTraceElement astacktraceelement[] = Thread.currentThread().getStackTrace();
        for (int i = 3; i < astacktraceelement.length; i++)
        {
            stringbuilder.append(astacktraceelement[i].getClassName());
            stringbuilder.append(".");
            stringbuilder.append(astacktraceelement[i].getMethodName());
            stringbuilder.append("(");
            stringbuilder.append(astacktraceelement[i].getFileName());
            stringbuilder.append(":");
            stringbuilder.append(astacktraceelement[i].getLineNumber());
            stringbuilder.append(")");
            if (i < astacktraceelement.length - 1)
            {
                stringbuilder.append(";");
            }
        }

        return stringbuilder.toString();
    }
}
