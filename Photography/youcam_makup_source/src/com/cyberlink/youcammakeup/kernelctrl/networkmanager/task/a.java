// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import java.util.Collection;
import java.util.Iterator;

public class a
{

    private static final String a = com/cyberlink/youcammakeup/kernelctrl/networkmanager/task/a.getSimpleName();

    private a()
    {
    }

    public static String a(Collection collection)
    {
        if (collection.size() <= 0)
        {
            return "";
        }
        collection = collection.iterator();
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(collection.next());
        for (; collection.hasNext(); stringbuilder.append(collection.next()))
        {
            stringbuilder.append(",");
        }

        return stringbuilder.toString();
    }

}
