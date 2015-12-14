// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.a;

import java.io.File;
import java.util.Comparator;

// Referenced classes of package com.tencent.open.a:
//            b

class 
    implements Comparator
{

    final b a;

    public int a(File file, File file1)
    {
        return b.d(file) - b.d(file1);
    }

    public int compare(Object obj, Object obj1)
    {
        return a((File)obj, (File)obj1);
    }

    (b b1)
    {
        a = b1;
        super();
    }
}
