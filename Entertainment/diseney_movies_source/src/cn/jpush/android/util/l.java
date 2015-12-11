// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import java.io.File;
import java.util.Comparator;

final class l
    implements Comparator
{

    l()
    {
    }

    public final int compare(Object obj, Object obj1)
    {
        obj = (File)obj;
        obj1 = (File)obj1;
        if (((File) (obj)).lastModified() > ((File) (obj1)).lastModified())
        {
            return -1;
        }
        return ((File) (obj)).lastModified() >= ((File) (obj1)).lastModified() ? 0 : 1;
    }
}
