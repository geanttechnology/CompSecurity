// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more;

import android.provider.BaseColumns;
import java.util.ArrayList;

public final class l
    implements BaseColumns
{

    private static String a[];

    public static String[] a()
    {
        if (a != null)
        {
            return a;
        } else
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add("Nindex");
            arraylist.add("JsonString");
            a = (String[])arraylist.toArray(new String[arraylist.size()]);
            return a;
        }
    }
}
