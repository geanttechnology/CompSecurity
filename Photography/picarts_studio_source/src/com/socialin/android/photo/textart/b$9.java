// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.textart;

import java.io.File;
import java.util.Comparator;

// Referenced classes of package com.socialin.android.photo.textart:
//            b

final class 
    implements Comparator
{

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

    ()
    {
    }
}
