// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.crash;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public abstract class ExceptionUtils
{

    public static String getStackTraceString(Throwable throwable)
    {
        if (throwable == null)
        {
            return "";
        } else
        {
            StringWriter stringwriter = new StringWriter();
            throwable.printStackTrace(new PrintWriter(stringwriter));
            return stringwriter.toString();
        }
    }

    public static List getThrowableList(Throwable throwable)
    {
        LinkedHashSet linkedhashset;
        for (linkedhashset = new LinkedHashSet(); throwable != null && !linkedhashset.contains(throwable); throwable = throwable.getCause())
        {
            linkedhashset.add(throwable);
        }

        return new ArrayList(linkedhashset);
    }
}
