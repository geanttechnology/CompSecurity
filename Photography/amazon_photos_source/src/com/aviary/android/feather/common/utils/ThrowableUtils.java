// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;

public final class ThrowableUtils
{

    private ThrowableUtils()
    {
    }

    public static String getLocalizedMessage(Collection collection, CharSequence charsequence)
    {
        StringBuilder stringbuilder = new StringBuilder();
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            stringbuilder.append(((Throwable)collection.next()).getLocalizedMessage());
            if (collection.hasNext())
            {
                stringbuilder.append(charsequence);
            }
        } while (true);
        return stringbuilder.toString();
    }

    public static String getStackTrace(Throwable throwable)
    {
        StringWriter stringwriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringwriter));
        return stringwriter.toString();
    }

    public static String getStackTrace(Collection collection, CharSequence charsequence)
    {
        StringBuilder stringbuilder = new StringBuilder();
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            stringbuilder.append(getStackTrace((Throwable)collection.next()));
            if (collection.hasNext())
            {
                stringbuilder.append(charsequence);
            }
        } while (true);
        return stringbuilder.toString();
    }
}
