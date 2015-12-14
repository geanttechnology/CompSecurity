// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor;

import android.graphics.Bitmap;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.history.a;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.w;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.picsart.studio.editor:
//            e, EditorProject

final class rnAsyncTask extends ModernAsyncTask
{

    private EditorProject a;
    private boolean b;
    private Runnable c;
    private e d;

    private transient Void a()
    {
        if (com.picsart.studio.editor.e.a(d).a())
        {
            (new File(a.getCurrentImagePath())).delete();
        } else
        if (e.b(d) != null && !e.b(d).isRecycled())
        {
            if (b)
            {
                try
                {
                    w.a(e.b(d), a.getCurrentImagePath());
                }
                catch (Throwable throwable) { }
            } else
            {
                try
                {
                    w.a(e.b(d), a.getCurrentImagePath());
                }
                catch (OutOfMemoryError outofmemoryerror)
                {
                    outofmemoryerror.printStackTrace();
                    System.gc();
                }
            }
        }
        com.picsart.studio.editor.e.a(d).a(a.getHistoryFilePath());
        try
        {
            FileUtils.a(new File(a.getTrackFilePath()), e.c(d).c());
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        return null;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
        super.onPostExecute((Void)obj);
        if (c != null)
        {
            c.run();
        }
    }

    orProject(e e1, EditorProject editorproject, boolean flag, Runnable runnable)
    {
        d = e1;
        a = editorproject;
        b = flag;
        c = runnable;
        super();
    }
}
