// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import java.util.ArrayList;
import java.util.List;

public class CommonLangUtils
{

    public CommonLangUtils()
    {
    }

    public static final List arrayToList(long al[])
        throws NullPointerException
    {
        if (al != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((List) (obj));
_L2:
        ArrayList arraylist = new ArrayList(al.length);
        int j = al.length;
        int i = 0;
        do
        {
            obj = arraylist;
            if (i >= j)
            {
                continue;
            }
            arraylist.add(Long.valueOf(al[i]));
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }
}
