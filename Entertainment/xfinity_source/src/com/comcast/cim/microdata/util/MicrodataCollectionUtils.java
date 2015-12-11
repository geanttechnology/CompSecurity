// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.util;

import java.util.Collections;
import java.util.List;

public class MicrodataCollectionUtils
{

    public MicrodataCollectionUtils()
    {
    }

    public static List unmodifiableList(List list)
    {
        if (list != null)
        {
            return Collections.unmodifiableList(list);
        } else
        {
            return Collections.emptyList();
        }
    }
}
