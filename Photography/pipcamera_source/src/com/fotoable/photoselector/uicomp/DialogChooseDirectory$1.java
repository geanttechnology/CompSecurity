// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.uicomp;

import java.io.File;
import java.util.Comparator;

// Referenced classes of package com.fotoable.photoselector.uicomp:
//            DialogChooseDirectory

class a
    implements Comparator
{

    final DialogChooseDirectory a;

    public int a(File file, File file1)
    {
        return file.getName().toLowerCase().compareTo(file1.getName().toLowerCase());
    }

    public int compare(Object obj, Object obj1)
    {
        return a((File)obj, (File)obj1);
    }

    (DialogChooseDirectory dialogchoosedirectory)
    {
        a = dialogchoosedirectory;
        super();
    }
}
