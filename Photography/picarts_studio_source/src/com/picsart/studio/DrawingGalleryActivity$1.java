// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import com.firegnom.rat.util.DialogUtils;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.brushlib.project.a;
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.photo.exception.InvalidIndexFileException;
import com.socialin.android.util.ModernAsyncTask;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.picsart.studio:
//            DrawingGalleryActivity, c

final class nit> extends ModernAsyncTask
{

    private DrawingGalleryActivity a;

    private transient List a()
    {
        List list;
label0:
        {
            publishProgress(new String[] {
                a.getString(0x7f0803dd)
            });
            if (isCancelled())
            {
                return null;
            }
            list = com.socialin.android.brushlib.project.a.a();
            Object obj = new HashSet();
            if (isCancelled())
            {
                return null;
            }
            publishProgress(new String[] {
                a.getString(0x7f080376)
            });
            Iterator iterator = list.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Project project = (Project)iterator.next();
                if (isCancelled())
                {
                    return null;
                }
                try
                {
                    if (!com.socialin.android.brushlib.project.a.d(project.getRootFolder()))
                    {
                        com.socialin.android.brushlib.project.a.a(project.getRootFolder(), com.picsart.studio.DrawingGalleryActivity.a(a));
                    }
                }
                catch (InvalidIndexFileException invalidindexfileexception)
                {
                    d.b(com.picsart.studio.DrawingGalleryActivity.a(), new Object[] {
                        (new StringBuilder("Got unexpected exception: ")).append(invalidindexfileexception.getMessage()).toString()
                    });
                    ((Set) (obj)).add(project);
                }
            } while (true);
            if (isCancelled())
            {
                return null;
            }
            for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); list.remove((Project)((Iterator) (obj)).next())) { }
            if (DrawingGalleryActivity.b(a) == null)
            {
                break label0;
            }
            obj = list.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
            } while (!((Project)((Iterator) (obj)).next()).getRootFolder().getAbsolutePath().equals(DrawingGalleryActivity.b(a)));
            ((Iterator) (obj)).remove();
        }
        return list;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (List)obj;
        com.picsart.studio.DrawingGalleryActivity.a(a, ((List) (obj)));
        com.picsart.studio.DrawingGalleryActivity.d(a).notifyDataSetChanged();
        DialogUtils.dismissDialog(a, DrawingGalleryActivity.c(a), true);
    }

    protected final void onProgressUpdate(Object aobj[])
    {
        aobj = (String[])aobj;
        DrawingGalleryActivity.c(a).setMessage(((CharSequence) (aobj[0])));
    }

    IndexFileException(DrawingGalleryActivity drawinggalleryactivity)
    {
        a = drawinggalleryactivity;
        super();
    }
}
