// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class StringUtils
{

    private StringUtils()
    {
    }

    public static String hashCode(Collection collection)
    {
        int i = 1;
        for (collection = collection.iterator(); collection.hasNext();)
        {
            i = i * 31 + ((String)collection.next()).hashCode();
        }

        return String.valueOf(i);
    }

    public static String join(List list, String s)
    {
        StringBuilder stringbuilder = new StringBuilder("");
        for (int i = 0; i < list.size(); i++)
        {
            stringbuilder.append(list.get(i).toString());
            if (i < list.size() - 1)
            {
                stringbuilder.append(s);
            }
        }

        return stringbuilder.toString();
    }

    public static String join(Object aobj[], String s)
    {
        StringBuilder stringbuilder = new StringBuilder("");
        for (int i = 0; i < aobj.length; i++)
        {
            stringbuilder.append(aobj[i].toString());
            if (i < aobj.length - 1)
            {
                stringbuilder.append(s);
            }
        }

        return stringbuilder.toString();
    }
}
