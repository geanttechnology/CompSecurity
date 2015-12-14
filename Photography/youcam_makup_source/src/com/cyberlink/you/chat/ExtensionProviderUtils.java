// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.util.Pair;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.util.p;

public class ExtensionProviderUtils
{

    public static String a(List list)
    {
        Iterator iterator = list.iterator();
        Pair pair;
        for (list = ""; iterator.hasNext(); list = (new StringBuilder()).append(list).append("</").append((String)pair.first).append(">").toString())
        {
            pair = (Pair)iterator.next();
            list = (new StringBuilder()).append(list).append("<").append((String)pair.first).append(">").toString();
            list = (new StringBuilder()).append(list).append(p.e((String)pair.second)).toString();
        }

        return list;
    }
}
