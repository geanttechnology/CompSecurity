// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.a;

import java.io.File;
import java.io.FileFilter;

// Referenced classes of package com.tencent.open.a:
//            b

class 
    implements FileFilter
{

    final b a;

    public boolean accept(File file)
    {
        while (!file.getName().endsWith(a.i()) || b.d(file) == -1) 
        {
            return false;
        }
        return true;
    }

    (b b1)
    {
        a = b1;
        super();
    }
}
