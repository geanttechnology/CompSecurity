// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import java.util.Comparator;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            o

final class 
    implements Comparator
{

    public int a(android.hardware.ra.Size size, android.hardware.ra.Size size1)
    {
        int i = size.width * size.height;
        int j = size1.width * size1.height;
        if (i > j)
        {
            return -1;
        }
        return i >= j ? 0 : 1;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((android.hardware.ra.Size)obj, (android.hardware.ra.Size)obj1);
    }

    ()
    {
    }
}
