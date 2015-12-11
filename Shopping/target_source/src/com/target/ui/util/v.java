// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import com.google.a.a.e;
import java.util.Collections;
import java.util.List;

public class v
{

    public static e a(Object obj)
    {
        if (obj == null)
        {
            return e.e();
        } else
        {
            return e.b(obj);
        }
    }

    public static List a(List list)
    {
        List list1 = list;
        if (list == null)
        {
            list1 = Collections.emptyList();
        }
        return list1;
    }
}
