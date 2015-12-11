// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.android.apptools;

import java.io.File;
import java.io.FileFilter;

// Referenced classes of package com.j256.ormlite.android.apptools:
//            OrmLiteConfigUtil

final class 
    implements FileFilter
{

    public boolean accept(File file)
    {
        return file.getName().equals("raw") && file.isDirectory();
    }

    ()
    {
    }
}
