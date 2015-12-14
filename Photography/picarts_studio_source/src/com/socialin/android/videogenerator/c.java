// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import com.picsart.studio.gifencoder.GifEncoder;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.videogenerator.actions.Action;
import com.socialin.android.videogenerator.actions.a;
import java.util.ArrayList;
import myobfuscated.br.e;

// Referenced classes of package com.socialin.android.videogenerator:
//            e, ActionCollector, ProjectVideoGenerator, d

final class c extends com.socialin.android.videogenerator.e
{

    private ProjectVideoGenerator d;

    private c(ProjectVideoGenerator projectvideogenerator)
    {
        d = projectvideogenerator;
        super(projectvideogenerator, (byte)0);
    }

    c(ProjectVideoGenerator projectvideogenerator, byte byte0)
    {
        this(projectvideogenerator);
    }

    protected final transient Boolean a()
    {
        float f;
        e e1;
        a a1;
        myobfuscated.cz.a a2;
        int j;
        int k;
        System.gc();
        if (com.socialin.android.videogenerator.ActionCollector.a() == null || com.socialin.android.videogenerator.ActionCollector.a().b() == 0)
        {
            com.socialin.android.videogenerator.ActionCollector.a().a(com.socialin.android.videogenerator.ProjectVideoGenerator.a.getActionsFile(), com.socialin.android.videogenerator.ProjectVideoGenerator.a.getActionsInfoFile(), com.socialin.android.videogenerator.ProjectVideoGenerator.a.isValid());
        }
        com.socialin.android.videogenerator.ActionCollector.a();
        ActionCollector.ActionsInfo actionsinfo = com.socialin.android.videogenerator.ActionCollector.a(com.socialin.android.videogenerator.ProjectVideoGenerator.a.getActionsInfoFile());
        float f1;
        boolean flag;
        int l;
        int j1;
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
            e1 = new e(0x7fffffff);
        }
        a1 = new a(com.socialin.android.videogenerator.ProjectVideoGenerator.a.getActionsFile());
        a = com.socialin.android.brushlib.project.a.b(com.socialin.android.videogenerator.ProjectVideoGenerator.a.getRootFolder());
        j = (int)a.x;
        k = (int)a.y;
        a2 = new myobfuscated.cz.a(com.socialin.android.videogenerator.ProjectVideoGenerator.a, j, k);
        j = a2.c;
        k = a2.d;
        l = ProjectVideoGenerator.i(d).getWidth();
        j1 = ProjectVideoGenerator.i(d).getHeight();
        f = (float)j / (float)l;
        f1 = (float)k / (float)j1;
        if (f <= f1)
        {
            f = f1;
        }
        f = 1.0F / f;
        a2.e = f;
        a2.f = f;
        c = (int)((float)a2.c * a2.e);
        b = (int)((float)a2.d * a2.f);
        if (b % 2 == 1)
        {
            b = b - 1;
        }
        if (c % 2 == 1)
        {
            c = c - 1;
        }
        j = actionsinfo.getActionsCount();
        f = (float)j / 10F;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_329;
        }
        j = e1.b + 1;
        if (ProjectVideoGenerator.g(d).init(ProjectVideoGenerator.i(d).getOutputPath(), c, b, ProjectVideoGenerator.i(d).getCOLORMX(), ProjectVideoGenerator.i(d).getQuality(), (int)ProjectVideoGenerator.i(d).getDelay()) == 0)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        if (!k) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        a(e1, a2, actionsinfo.getActionsCount(), j);
_L2:
        if (isCancelled())
        {
            (new Handler(Looper.getMainLooper())).post(new Runnable() {

                public final void run()
                {
                }

            });
            ProjectVideoGenerator.g(d).cancelGifGeneration(ProjectVideoGenerator.i(d).getOutputPath());
        }
        a1.d();
        return Boolean.valueOf(true);
_L4:
        Bitmap bitmap;
        a1.b();
        k = com.socialin.android.videogenerator.ProjectVideoGenerator.a(d, false, e1, a1);
        bitmap = Bitmap.createBitmap(c, b, android.graphics.Bitmap.Config.ARGB_8888);
        int i;
        int i1;
        int k1;
        k1 = 0;
        i1 = 1;
        i = 1;
_L16:
        if (k == 0) goto _L6; else goto _L5
_L5:
        if (isCancelled()) goto _L6; else goto _L7
_L7:
        int i2 = k1 + k;
        if (!ProjectVideoGenerator.j(d) || i2 >= j)
        {
            break MISSING_BLOCK_LABEL_594;
        }
        f = (float)i2 / 10F;
        ArrayList arraylist = e1.g();
        k1 = 1;
_L12:
        if (k1 > k) goto _L9; else goto _L8
_L8:
        Action action;
        action = (Action)arraylist.get(0);
        action.apply(a2);
        if (!action.isVisible() || (int)((float)i1 * f) != i && j >= 10) goto _L11; else goto _L10
_L10:
        a(a2, bitmap);
        break MISSING_BLOCK_LABEL_918;
_L14:
        arraylist.remove(0);
        com.socialin.android.videogenerator.ProjectVideoGenerator.a(e1, action);
        ProjectVideoGenerator.c(d);
        if (ProjectVideoGenerator.d(d) > j)
        {
            com.socialin.android.videogenerator.ProjectVideoGenerator.a(d, j);
        }
        publishProgress(new Integer[] {
            Integer.valueOf((ProjectVideoGenerator.d(d) * 99) / j)
        });
        int l1;
        i++;
        k1++;
        i1 = l1;
          goto _L12
_L11:
        l1 = i1;
        if (action.isVisible()) goto _L14; else goto _L13
_L13:
        if ((int)((float)i1 * f) == i)
        {
            break MISSING_BLOCK_LABEL_918;
        }
        l1 = i1;
        if (j >= 10) goto _L14; else goto _L15
_L15:
        break MISSING_BLOCK_LABEL_918;
_L9:
        com.socialin.android.videogenerator.ProjectVideoGenerator.a(d, com.socialin.android.videogenerator.ProjectVideoGenerator.e(d));
        k = com.socialin.android.videogenerator.ProjectVideoGenerator.a(d, true, e1, a1);
        k1 = i2;
          goto _L16
_L6:
        ProjectVideoGenerator.g(d).close();
        publishProgress(new Integer[] {
            Integer.valueOf(100)
        });
        bitmap.recycle();
          goto _L2
        Object obj;
        obj;
        ProjectVideoGenerator.f(d).a(ProjectVideoGenerator.c);
        System.gc();
        a1.d();
        return Boolean.valueOf(false);
        obj;
        ((Exception) (obj)).printStackTrace();
        a1.d();
        return Boolean.valueOf(false);
        obj;
        a1.d();
        throw obj;
        l1 = i1 + 1;
          goto _L14
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }
}
