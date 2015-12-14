// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.picsart.studio.gifencoder.GifEncoder;
import com.picsart.studio.mp4encoder.MP4Writer;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.encoder.factory.VideoEncoderFactory;
import com.socialin.android.videogenerator.actions.Action;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import myobfuscated.cz.a;

// Referenced classes of package com.socialin.android.videogenerator:
//            b, ProjectVideoGenerator, ActionCollector, d

class e extends AsyncTask
{

    protected PointF a;
    protected int b;
    protected int c;
    private Bitmap d;
    private boolean e;
    private MP4Writer f;
    private long g;
    private ProjectVideoGenerator h;

    private e(ProjectVideoGenerator projectvideogenerator)
    {
        h = projectvideogenerator;
        super();
    }

    e(ProjectVideoGenerator projectvideogenerator, byte byte0)
    {
        this(projectvideogenerator);
    }

    private void a(myobfuscated.br.e e1, a a1, b b1, int i)
    {
        int j = 0;
        e1 = e1.f().iterator();
        Bitmap bitmap = Bitmap.createBitmap(c, b, android.graphics.Bitmap.Config.ARGB_8888);
        b();
        double d1 = 0.0D;
        for (; e1.hasNext() && !isCancelled(); publishProgress(new Integer[] {
    Integer.valueOf((j * 100) / i)
}))
        {
            Action action = (Action)e1.next();
            j++;
            action.apply(a1);
            d1 = b1.a;
            if (action.isVisible())
            {
                a(a1, bitmap, d1);
            }
        }

        a(a1, bitmap, d1);
        for (i = 0; i < (int)(3D / d1); i++)
        {
            ProjectVideoGenerator.b(h).addFrame(bitmap, (int)(1000D * d1));
        }

        bitmap.recycle();
    }

    private void a(a a1, Bitmap bitmap, double d1)
    {
        a1.a(bitmap, d);
        if (e)
        {
            f.addFrame(bitmap, g);
            return;
        } else
        {
            ProjectVideoGenerator.b(h).addFrame(bitmap, (int)(1000D * d1));
            return;
        }
    }

    private void b()
    {
        if (d == null)
        {
            Bitmap bitmap1 = Bitmap.createBitmap(c, b, android.graphics.Bitmap.Config.ARGB_8888);
            int i = ProjectVideoGenerator.h(h).getWidth();
            int j = ProjectVideoGenerator.h(h).getHeight();
            float f1 = c / i;
            float f4 = b / j;
            Bitmap bitmap = ProjectVideoGenerator.h(h);
            if (f1 < 3F || f4 < 4F)
            {
                if (f1 / 3F > f4 / 4F)
                {
                    float f2 = b / 4;
                    j = (int)(((float)i * f2) / (float)j);
                    i = (int)f2;
                } else
                {
                    float f3 = c / 3;
                    i = (int)(((float)j * f3) / (float)i);
                    j = (int)f3;
                }
                bitmap = Bitmap.createScaledBitmap(bitmap, j, i, false);
            }
            (new Canvas(bitmap1)).drawBitmap(bitmap, bitmap1.getWidth() - bitmap.getWidth(), bitmap1.getHeight() - bitmap.getHeight(), null);
            d = bitmap1;
            bitmap.recycle();
        }
    }

    protected transient Boolean a()
    {
        myobfuscated.br.e e1;
        com.socialin.android.videogenerator.actions.a a1;
        a a2;
        Object obj1;
        int j;
        boolean flag1;
        System.gc();
        if (com.socialin.android.videogenerator.ActionCollector.a() == null || com.socialin.android.videogenerator.ActionCollector.a().b() == 0)
        {
            com.socialin.android.videogenerator.ActionCollector.a().a(com.socialin.android.videogenerator.ProjectVideoGenerator.a.getActionsFile(), com.socialin.android.videogenerator.ProjectVideoGenerator.a.getActionsInfoFile(), com.socialin.android.videogenerator.ProjectVideoGenerator.a.isValid());
        }
        com.socialin.android.videogenerator.ActionCollector.a();
        ActionCollector.ActionsInfo actionsinfo = com.socialin.android.videogenerator.ActionCollector.a(com.socialin.android.videogenerator.ProjectVideoGenerator.a.getActionsInfoFile());
        float f1;
        float f2;
        boolean flag;
        int k;
        int j1;
        int l1;
        if (actionsinfo == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            actionsinfo = new ActionCollector.ActionsInfo();
            e1 = com.socialin.android.videogenerator.ProjectVideoGenerator.a(com.socialin.android.videogenerator.ProjectVideoGenerator.a, actionsinfo);
        } else
        {
            e1 = new myobfuscated.br.e(0x7fffffff);
        }
        a1 = new com.socialin.android.videogenerator.actions.a(com.socialin.android.videogenerator.ProjectVideoGenerator.a.getActionsFile());
        a = com.socialin.android.brushlib.project.a.b(com.socialin.android.videogenerator.ProjectVideoGenerator.a.getRootFolder());
        j = (int)a.x;
        k = (int)a.y;
        a2 = new a(com.socialin.android.videogenerator.ProjectVideoGenerator.a, j, k);
        j = a2.c;
        k = a2.d;
        obj1 = com.socialin.android.videogenerator.ProjectVideoGenerator.a(h).getResolution();
        j1 = ((ProjectVideoGenerator.VideoResolution) (obj1)).getHeight();
        l1 = ((ProjectVideoGenerator.VideoResolution) (obj1)).getWidth();
        f1 = (float)j / (float)l1;
        f2 = (float)k / (float)j1;
        if (f1 <= f2)
        {
            f1 = f2;
        }
        f1 = 1.0F / f1;
        a2.e = f1;
        a2.f = f1;
        c = (int)((float)a2.c * a2.e);
        b = (int)((float)a2.d * a2.f);
        if (b % 2 == 1)
        {
            b = b + 1;
        }
        if (c % 2 == 1)
        {
            c = c + 1;
        }
        j = ProjectVideoGenerator.VideoOptions.access$300(com.socialin.android.videogenerator.ProjectVideoGenerator.a(h));
        obj1 = new b();
        obj1.a = ((double)j - 2D) / (double)actionsinfo.getActionsCount();
        j = (int)Math.ceil(1.0D / ((b) (obj1)).a);
        if (com.socialin.android.videogenerator.ProjectVideoGenerator.a(h).getFormat() == ProjectVideoGenerator.VideoFormat.mp4)
        {
            e = true;
            g = (long)((((double)com.socialin.android.videogenerator.ProjectVideoGenerator.a(h).getDuration() - 1.5D) / (double)((float)actionsinfo.getActionsCount() * 1.0F)) * 1000000D);
            int l = c;
            int k1 = b;
            j = (l / 16) * 16;
            l = (int)(((float)j / ((float)l * 1.0F)) * (float)k1) / 16;
            int ai[] = new int[2];
            ai[0] = j;
            ai[1] = l * 16;
            c = ai[0];
            b = ai[1];
            f = MP4Writer.initWithParams(com.socialin.android.videogenerator.ProjectVideoGenerator.a(h), new int[] {
                c, b, actionsinfo.getActionsCount()
            });
        } else
        {
            ProjectVideoGenerator.b(h).init(c, b, j, ProjectVideoGenerator.VideoOptions.access$400(com.socialin.android.videogenerator.ProjectVideoGenerator.a(h)));
        }
        j = actionsinfo.getActionsCount();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_552;
        }
        j = e1.b + 1;
        if (e) goto _L2; else goto _L1
_L1:
        flag1 = ProjectVideoGenerator.b(h).startVideoGeneration(new File(ProjectVideoGenerator.VideoOptions.access$600(com.socialin.android.videogenerator.ProjectVideoGenerator.a(h))));
_L11:
        if (!flag1) goto _L4; else goto _L3
_L3:
        if (!flag) goto _L6; else goto _L5
_L5:
        a(e1, a2, ((b) (obj1)), j);
_L4:
        if (!isCancelled()) goto _L8; else goto _L7
_L7:
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            public final void run()
            {
            }

        });
        if (!e) goto _L10; else goto _L9
_L9:
        f.cancelVideoGeneration();
_L19:
        a1.d();
        return Boolean.valueOf(true);
_L2:
        flag1 = f.canStartVideoGeneration();
          goto _L11
_L6:
        double d1;
        Bitmap bitmap;
        int i;
        a1.b();
        i = com.socialin.android.videogenerator.ProjectVideoGenerator.a(h, false, e1, a1);
        bitmap = Bitmap.createBitmap(c, b, android.graphics.Bitmap.Config.ARGB_8888);
        b();
        d1 = ((b) (obj1)).a;
_L14:
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_961;
        }
        if (isCancelled())
        {
            break MISSING_BLOCK_LABEL_961;
        }
        obj1 = e1.g();
        int i1 = 0;
_L13:
        if (i1 >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        Action action = (Action)((ArrayList) (obj1)).get(0);
        action.apply(a2);
        if (action.isVisible())
        {
            a(a2, bitmap, d1);
        }
        ((ArrayList) (obj1)).remove(0);
        com.socialin.android.videogenerator.ProjectVideoGenerator.a(e1, action);
        ProjectVideoGenerator.c(h);
        if (ProjectVideoGenerator.d(h) > j)
        {
            com.socialin.android.videogenerator.ProjectVideoGenerator.a(h, j);
        }
        publishProgress(new Integer[] {
            Integer.valueOf((ProjectVideoGenerator.d(h) * 99) / j)
        });
        i1++;
        if (true) goto _L13; else goto _L12
_L12:
        com.socialin.android.videogenerator.ProjectVideoGenerator.a(h, ProjectVideoGenerator.e(h));
        i = com.socialin.android.videogenerator.ProjectVideoGenerator.a(h, true, e1, a1);
          goto _L14
        a(a2, bitmap, d1);
        if (e)
        {
            break MISSING_BLOCK_LABEL_1190;
        }
        i = 0;
_L16:
        if ((double)i >= 3D / d1)
        {
            break; /* Loop/switch isn't completed */
        }
        ProjectVideoGenerator.b(h).addFrame(bitmap, (int)(1000D * d1));
        i++;
        if (true) goto _L16; else goto _L15
_L18:
        if ((double)i >= 2D / d1) goto _L15; else goto _L17
_L17:
        f.addFrame(bitmap, g);
        i++;
          goto _L18
_L15:
        publishProgress(new Integer[] {
            Integer.valueOf(100)
        });
        bitmap.recycle();
          goto _L4
        Object obj;
        obj;
        ProjectVideoGenerator.f(h).a(ProjectVideoGenerator.c);
        System.gc();
        a1.d();
        return Boolean.valueOf(false);
_L10:
        ProjectVideoGenerator.b(h).cancelVideoGeneration();
          goto _L19
        obj;
        ((Exception) (obj)).printStackTrace();
        a1.d();
        return Boolean.valueOf(false);
_L8:
        if (!e)
        {
            break MISSING_BLOCK_LABEL_1171;
        }
        f.finalizeVideoGeneration();
          goto _L19
        obj;
        a1.d();
        throw obj;
        ProjectVideoGenerator.b(h).endVideoGeneration();
          goto _L19
        i = 0;
          goto _L18
    }

    protected final void a(myobfuscated.br.e e1, a a1, int i, int j)
    {
        e1 = e1.f().iterator();
        Bitmap bitmap = Bitmap.createBitmap(c, b, android.graphics.Bitmap.Config.ARGB_8888);
        b();
        int k;
        if (i > j)
        {
            i = (int)Math.round((double)i / 10D);
        } else
        {
            i = (int)Math.round((double)j / 10D);
        }
        if (i == 0)
        {
            i = 0;
            k = 1;
        } else
        {
            boolean flag = false;
            k = i;
            i = ((flag) ? 1 : 0);
        }
        for (; e1.hasNext() && !isCancelled(); publishProgress(new Integer[] {
    Integer.valueOf((i * 100) / j)
}))
        {
            Action action = (Action)e1.next();
            i++;
            action.apply(a1);
            if (action.isVisible() && i % k == 0)
            {
                a(a1, bitmap);
                System.gc();
            }
        }

        a(a1, bitmap);
        ProjectVideoGenerator.g(h).close();
        bitmap.recycle();
    }

    protected final void a(a a1, Bitmap bitmap)
    {
        if (d == null)
        {
            d = bitmap;
        }
        a1.a(bitmap, d);
        a1 = new int[c * b];
        bitmap.getPixels(a1, 0, c, 0, 0, c, b);
        ProjectVideoGenerator.g(h).addFrame(a1);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected void onPostExecute(Object obj)
    {
        if (((Boolean)obj).booleanValue())
        {
            ProjectVideoGenerator.f(h).b();
        } else
        {
            ProjectVideoGenerator.f(h).a();
        }
        obj = h;
        if (((ProjectVideoGenerator) (obj)).b != null && !((ProjectVideoGenerator) (obj)).b.isRecycled())
        {
            ((ProjectVideoGenerator) (obj)).b.recycle();
        }
        if (d != null && !d.isRecycled())
        {
            d.recycle();
        }
    }

    protected void onProgressUpdate(Object aobj[])
    {
        aobj = (Integer[])aobj;
        ProjectVideoGenerator.f(h).b(((Integer) (aobj[0])).intValue());
    }
}
