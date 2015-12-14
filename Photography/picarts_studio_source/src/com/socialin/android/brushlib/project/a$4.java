// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.project;

import com.socialin.android.util.FileUtils;
import java.io.File;

// Referenced classes of package com.socialin.android.brushlib.project:
//            a, Project, c

final class b
    implements Runnable
{

    private Project a;
    private c b;

    public final void run()
    {
        File afile[] = a.getRootFolder().listFiles();
        if (afile != null)
        {
            int j = afile.length;
            int i = 0;
            while (i < j) 
            {
                File file = afile[i];
                String s = file.getName();
                if (b != null && !b.a(s))
                {
                    if (file.isFile())
                    {
                        file.delete();
                    } else
                    if (file.isDirectory())
                    {
                        FileUtils.b(file);
                    }
                }
                i++;
            }
        }
    }

    ect(Project project, c c1)
    {
        a = project;
        b = c1;
        super();
    }
}
