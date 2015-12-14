// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.os.AsyncTask;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.brushlib.project.a;
import com.socialin.android.d;
import com.socialin.android.photo.exception.InvalidIndexFileException;
import com.socialin.android.util.FileUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class b extends AsyncTask
{

    private Project a;
    private Runnable b;

    private transient List a()
    {
        Object obj = com.socialin.android.brushlib.project.a.a();
        if (obj != null)
        {
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                Project project = (Project)((Iterator) (obj)).next();
                if (project.equals(a))
                {
                    continue;
                }
                if (project.isValid())
                {
                    try
                    {
                        myobfuscated.br.a.a(project);
                        continue;
                    }
                    catch (InvalidIndexFileException invalidindexfileexception)
                    {
                        d.b(DrawingActivity.c(), new Object[] {
                            (new StringBuilder("Got unexpected exception: ")).append(invalidindexfileexception.getMessage()).toString()
                        });
                    }
                }
                FileUtils.b(project.getRootFolder().getAbsolutePath());
            } while (true);
            if (b != null)
            {
                b.run();
            }
        }
        return null;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    leException(Project project, Runnable runnable)
    {
        a = project;
        b = runnable;
        super();
    }
}
