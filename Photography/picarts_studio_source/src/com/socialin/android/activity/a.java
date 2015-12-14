// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import java.io.File;
import java.io.FilenameFilter;

// Referenced classes of package com.socialin.android.activity:
//            FolderChooserActivity

final class a
    implements FilenameFilter
{

    private a()
    {
    }

    a(FolderChooserActivity folderchooseractivity)
    {
        this();
    }

    public final boolean accept(File file, String s)
    {
        if (s.startsWith("."))
        {
            return false;
        } else
        {
            return (new File(file, s)).isDirectory();
        }
    }
}
