// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo;

import java.io.File;
import java.util.Comparator;

public final class a
    implements Comparator
{

    public a()
    {
    }

    public final int compare(Object obj, Object obj1)
    {
        obj = (File)obj;
        obj1 = (File)obj1;
        obj = ((File) (obj)).getPath();
        obj1 = ((File) (obj1)).getPath();
        obj = ((String) (obj)).substring(((String) (obj)).lastIndexOf("_") + 1);
        obj1 = ((String) (obj1)).substring(((String) (obj1)).lastIndexOf("_") + 1);
        long l = Long.parseLong(((String) (obj)));
        long l1 = Long.parseLong(((String) (obj1)));
        if (l1 < l)
        {
            return -1;
        }
        return l != l1 ? 1 : 0;
    }
}
