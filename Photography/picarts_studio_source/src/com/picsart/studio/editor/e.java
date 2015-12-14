// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor;

import android.graphics.Bitmap;
import com.picsart.studio.EditingData;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.editor.history.EditorAction;
import com.picsart.studio.editor.history.a;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.n;
import com.socialin.android.util.w;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.picsart.studio.editor:
//            EditorProject, b

public final class e
{

    private static final e f = new e();
    public com.picsart.studio.editor.helper.e a;
    public Bitmap b;
    public a c;
    public EditorProject d;
    public EditingData e;

    private e()
    {
        c = new a();
    }

    public static e a()
    {
        return f;
    }

    static a a(e e1)
    {
        return e1.c;
    }

    private static Bitmap b(Bitmap bitmap)
    {
        int i = bitmap.getWidth();
        int j = bitmap.getHeight();
        int k = PicsartContext.a();
        Object obj = bitmap;
        if (i * j > k)
        {
            obj = w.a(new n(bitmap.getWidth(), bitmap.getHeight()), k);
            obj = Bitmap.createScaledBitmap(bitmap, ((n) (obj)).a, ((n) (obj)).b, false);
        }
        return w.d(((Bitmap) (obj)));
    }

    static Bitmap b(e e1)
    {
        return e1.b;
    }

    static EditingData c(e e1)
    {
        return e1.e;
    }

    public final void a(Bitmap bitmap)
    {
        b = b(bitmap);
    }

    public final void a(Bitmap bitmap, EditingData editingdata, String s)
    {
        this;
        JVM INSTR monitorenter ;
        d();
        bitmap = b(bitmap);
        c = new a();
        d = new EditorProject((new StringBuilder()).append(com.picsart.studio.editor.b.a).append(File.separator).append(s).toString());
        a = new com.picsart.studio.editor.helper.e(bitmap, d.getOriginalImagePath());
        e = editingdata;
        a(bitmap);
        this;
        JVM INSTR monitorexit ;
        return;
        bitmap;
        throw bitmap;
    }

    public final void a(EditorAction editoraction)
    {
        if (c != null)
        {
            c.a(this, editoraction);
        }
    }

    public final void a(Runnable runnable, boolean flag)
    {
        if (b())
        {
            (new ModernAsyncTask(d, flag, runnable) {

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

            
            {
                d = e.this;
                a = editorproject;
                b = flag;
                c = runnable;
                super();
            }
            }).execute(new Void[0]);
        }
    }

    public final void a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        String s1;
        d();
        c = new a();
        d = new EditorProject(s);
        a = new com.picsart.studio.editor.helper.e(d.getOriginalImagePath());
        e = EditingData.b(d.getTrackFilePath());
        s1 = d.getCurrentImagePath();
        s = s1;
        if (!(new File(s1)).exists())
        {
            s = d.getOriginalImagePath();
        }
        s = w.g(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        a(((Bitmap) (s)));
        c.b(d.getHistoryFilePath());
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public final void b(EditorAction editoraction)
    {
        if (c != null)
        {
            a a1 = c;
            a1.a(this, editoraction);
            a1.c.execute(new com.picsart.studio.editor.history.a._cls2(a1, this, editoraction));
        }
    }

    public final boolean b()
    {
        this;
        JVM INSTR monitorenter ;
        if (b == null || c == null || d == null) goto _L2; else goto _L1
_L1:
        EditingData editingdata = e;
        if (editingdata == null) goto _L2; else goto _L3
_L3:
        boolean flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    public final Bitmap c()
    {
        Bitmap bitmap;
        try
        {
            bitmap = b.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            outofmemoryerror.printStackTrace();
            return b;
        }
        if (bitmap != null)
        {
            return bitmap;
        } else
        {
            return b;
        }
    }

    public final void d()
    {
        this;
        JVM INSTR monitorenter ;
        b = null;
        if (c != null)
        {
            c.e.clear();
        }
        c = null;
        d = null;
        if (a != null)
        {
            com.picsart.studio.editor.helper.e e1 = a;
            if (e1.a != null)
            {
                e1.c();
            }
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

}
