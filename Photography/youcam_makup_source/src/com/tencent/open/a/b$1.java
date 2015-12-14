// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.a;

import java.io.File;
import java.io.FileFilter;

// Referenced classes of package com.tencent.open.a:
//            b

final class 
    implements FileFilter
{

    public boolean accept(File file)
    {
        while (!file.isDirectory() || b.a(file) <= 0L) 
        {
            return false;
        }
        return true;
    }

    ()
    {
    }
}
