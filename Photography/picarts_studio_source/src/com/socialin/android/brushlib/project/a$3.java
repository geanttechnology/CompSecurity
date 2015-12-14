// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.project;

import com.socialin.android.brushlib.state.Snapshot;
import com.socialin.android.util.FileUtils;
import java.io.File;
import java.util.Comparator;
import java.util.List;
import myobfuscated.br.d;

// Referenced classes of package com.socialin.android.brushlib.project:
//            a, Project

final class ot
    implements Comparator
{

    private static Snapshot a(File file)
    {
        List list = FileUtils.e(new File(file, "INDEX"));
        if (list.size() != 2)
        {
            return null;
        } else
        {
            return d.a(new File(file, (String)list.get(0)));
        }
    }

    public final int compare(Object obj, Object obj1)
    {
        obj = (Project)obj;
        obj1 = (Project)obj1;
        obj = a(((Project) (obj)).getRootFolder());
        obj1 = a(((Project) (obj1)).getRootFolder());
        if (obj != null && obj1 != null)
        {
            if (((Snapshot) (obj)).creationDate > ((Snapshot) (obj1)).creationDate)
            {
                return -1;
            }
            if (((Snapshot) (obj)).creationDate < ((Snapshot) (obj1)).creationDate)
            {
                return 1;
            }
        }
        return 0;
    }

    ot()
    {
    }
}
