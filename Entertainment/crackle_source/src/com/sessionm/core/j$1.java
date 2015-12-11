// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;

import java.io.File;
import java.io.FileFilter;

// Referenced classes of package com.sessionm.core:
//            j

class >
    implements FileFilter
{

    final j dZ;

    public boolean accept(File file)
    {
        return file.getName().endsWith("complete");
    }

    (j j1)
    {
        dZ = j1;
        super();
    }
}
