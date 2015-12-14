// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.project;

import com.socialin.android.util.FileUtils;
import java.io.File;

// Referenced classes of package com.socialin.android.brushlib.project:
//            a

final class 
    implements Runnable
{

    public final void run()
    {
        File afile[] = (new File(a.d)).listFiles();
        if (afile != null)
        {
            int j = afile.length;
            int i = 0;
            while (i < j) 
            {
                File file = afile[i];
                if (file.isFile())
                {
                    file.delete();
                } else
                if (file.isDirectory())
                {
                    FileUtils.b(file);
                }
                i++;
            }
        }
    }

    ()
    {
    }
}
