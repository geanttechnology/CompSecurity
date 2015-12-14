// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import java.util.Comparator;

// Referenced classes of package com.instamag.activity.lib:
//            MagLocalListViewdapter

class a
    implements Comparator
{

    final MagLocalListViewdapter a;

    public int compare(Object obj, Object obj1)
    {
        int j = 0x7fffffff;
        if ((obj instanceof String) && (obj1 instanceof String))
        {
            obj = (String)obj;
            obj1 = (String)obj1;
            int i;
            if (((String) (obj)).equalsIgnoreCase("S"))
            {
                i = 0x7fffffff;
            } else
            {
                i = Integer.valueOf(((String) (obj))).intValue();
            }
            if (!((String) (obj1)).equalsIgnoreCase("S"))
            {
                j = Integer.valueOf(((String) (obj1))).intValue();
            }
            if (i > j)
            {
                return 1;
            }
            return i != j ? -1 : 0;
        } else
        {
            return 0;
        }
    }

    (MagLocalListViewdapter maglocallistviewdapter)
    {
        a = maglocallistviewdapter;
        super();
    }
}
