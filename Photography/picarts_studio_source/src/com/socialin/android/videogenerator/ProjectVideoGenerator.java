// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator;

import android.graphics.Bitmap;
import com.picsart.studio.gifencoder.GifEncoder;
import com.socialin.android.brushlib.overlay.ImageOverlay;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.encoder.factory.VideoEncoderFactory;
import com.socialin.android.videogenerator.actions.Action;
import com.socialin.android.videogenerator.actions.LayerConfigChangeAction;
import com.socialin.android.videogenerator.actions.OverlayAdditionAction;
import com.socialin.android.videogenerator.actions.RedoAction;
import com.socialin.android.videogenerator.actions.UndoAction;
import com.socialin.android.videogenerator.actions.a;
import java.util.List;
import myobfuscated.br.e;

// Referenced classes of package com.socialin.android.videogenerator:
//            c, e, d

public final class ProjectVideoGenerator
{

    public static Project a;
    public static int c = 1;
    private static int g = 20;
    private static int h = 50;
    Bitmap b;
    private final d d;
    private VideoOptions e;
    private com.socialin.android.videogenerator.e f;
    private int i;
    private boolean j;
    private int k;
    private GifOptions l;
    private GifEncoder m;
    private VideoEncoderFactory n;

    public ProjectVideoGenerator(Project project, d d1, GifOptions gifoptions, GifEncoder gifencoder)
    {
        i = 0;
        j = false;
        k = 0;
        a = project;
        d = d1;
        l = gifoptions;
        m = gifencoder;
    }

    public ProjectVideoGenerator(Project project, d d1, VideoOptions videooptions, Bitmap bitmap, VideoEncoderFactory videoencoderfactory)
    {
        i = 0;
        j = false;
        k = 0;
        a = project;
        d = d1;
        e = videooptions;
        b = bitmap;
        n = videoencoderfactory;
    }

    static int a(ProjectVideoGenerator projectvideogenerator, int i1)
    {
        projectvideogenerator.k = i1;
        return i1;
    }

    static int a(ProjectVideoGenerator projectvideogenerator, boolean flag, e e1, a a1)
    {
        return projectvideogenerator.a(flag, e1, a1);
    }

    private int a(boolean flag, e e1, a a1)
    {
        if (!j) goto _L2; else goto _L1
_L1:
        int k1 = e1.f().size();
_L4:
        return k1;
_L2:
        Object obj;
        Action action;
        int i1;
        int j1;
        if (flag)
        {
            i1 = g;
        } else
        {
            i1 = 0;
        }
        if (flag)
        {
            j1 = e1.f().size();
        } else
        {
            j1 = 0;
        }
        if (e1.e())
        {
            obj = "";
        } else
        {
            obj = ((Action)e1.c()).getSnapshotKey();
        }
_L7:
        k1 = j1;
        if (i1 >= g + h) goto _L4; else goto _L3
_L3:
        int i2;
        action = a1.c();
        if (action == null)
        {
            j = true;
            return e1.f().size();
        }
        i2 = j1;
        if (i1 + 1 == g + h)
        {
            List list = e1.f();
            String s = "";
            int j2 = 0;
            int l1 = 0;
            j1 = 0;
            do
            {
                i2 = j1;
                if (l1 >= h)
                {
                    break;
                }
                Action action1 = (Action)list.get(j2);
                if (!s.equals((new StringBuilder()).append(action1.getSnapshotKey()).toString()))
                {
                    s = (new StringBuilder()).append(action1.getSnapshotKey()).toString();
                    l1++;
                }
                j1++;
                j2++;
            } while (true);
        }
        if (!(action instanceof UndoAction)) goto _L6; else goto _L5
_L5:
        for (obj = ((Action)e1.c()).getSnapshotKey(); ((String) (obj)).equals(((Action)e1.c()).getSnapshotKey()); e1.a()) { }
        i1--;
        obj = (new StringBuilder()).append(action.getSnapshotKey()).toString();
_L8:
        i = i + 1;
        j1 = i2;
          goto _L7
_L6:
        if (!(action instanceof RedoAction))
        {
            break MISSING_BLOCK_LABEL_432;
        }
        e1.b();
        obj = ((Action)e1.c()).getSnapshotKey();
        while (((String) (obj)).equals(((Action)e1.c()).getSnapshotKey())) 
        {
            e1.b();
        }
        break MISSING_BLOCK_LABEL_424;
        try
        {
            e1.a();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        i1++;
        obj = (new StringBuilder()).append(action.getSnapshotKey()).toString();
          goto _L8
        if ((action instanceof OverlayAdditionAction) && (((OverlayAdditionAction)action).getOverlay() instanceof ImageOverlay))
        {
            ((ImageOverlay)((OverlayAdditionAction)action).getOverlay()).initImage(a.getImageDataFolder());
        }
        if (!((String) (obj)).equals(action.getSnapshotKey()))
        {
            i1++;
            obj = (new StringBuilder()).append(action.getSnapshotKey()).toString();
        }
        e1.a(action);
        System.gc();
          goto _L8
    }

    static VideoOptions a(ProjectVideoGenerator projectvideogenerator)
    {
        return projectvideogenerator.e;
    }

    public static e a(Project project, ActionCollector.ActionsInfo actionsinfo)
    {
        e e1;
        a a1;
        e1 = new e(0x7fffffff);
        a1 = new a(project.getActionsFile());
        a1.b();
_L1:
        Object obj = a1.c();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        if (!(obj instanceof UndoAction))
        {
            break MISSING_BLOCK_LABEL_91;
        }
        obj = ((Action)e1.c()).getSnapshotKey();
        while (((String) (obj)).equals(((Action)e1.c()).getSnapshotKey())) 
        {
            e1.a();
        }
          goto _L1
        project;
        project.printStackTrace();
        return e1;
        if (!(obj instanceof RedoAction))
        {
            break MISSING_BLOCK_LABEL_148;
        }
        e1.b();
        obj = ((Action)e1.c()).getSnapshotKey();
        while (((String) (obj)).equals(((Action)e1.c()).getSnapshotKey())) 
        {
            e1.b();
        }
        try
        {
            e1.a();
        }
        catch (Exception exception) { }
          goto _L1
        if ((obj instanceof OverlayAdditionAction) && (((OverlayAdditionAction)obj).getOverlay() instanceof ImageOverlay))
        {
            ((ImageOverlay)((OverlayAdditionAction)obj).getOverlay()).initImage(project.getImageDataFolder());
        }
        if (!(obj instanceof LayerConfigChangeAction)) goto _L3; else goto _L2
_L2:
        actionsinfo.shortActionsCount = actionsinfo.shortActionsCount + 1;
_L4:
        e1.a(obj);
          goto _L1
_L3:
label0:
        {
            if (((Action) (obj)).isVisible())
            {
                break label0;
            }
            actionsinfo.invisibleActionsCount = actionsinfo.invisibleActionsCount + 1;
        }
          goto _L4
        actionsinfo.longActionsCount = actionsinfo.longActionsCount + 1;
          goto _L4
    }

    static void a(e e1, Action action)
    {
        do
        {
            if (e1.a.size() <= 0)
            {
                throw new IndexOutOfBoundsException();
            }
            if (e1.a.get(0) != action)
            {
                e1.d();
            } else
            {
                e1.d();
                return;
            }
        } while (true);
    }

    static VideoEncoderFactory b(ProjectVideoGenerator projectvideogenerator)
    {
        return projectvideogenerator.n;
    }

    static int c(ProjectVideoGenerator projectvideogenerator)
    {
        int i1 = projectvideogenerator.k;
        projectvideogenerator.k = i1 + 1;
        return i1;
    }

    static int d(ProjectVideoGenerator projectvideogenerator)
    {
        return projectvideogenerator.k;
    }

    static int e(ProjectVideoGenerator projectvideogenerator)
    {
        return projectvideogenerator.i;
    }

    static d f(ProjectVideoGenerator projectvideogenerator)
    {
        return projectvideogenerator.d;
    }

    static GifEncoder g(ProjectVideoGenerator projectvideogenerator)
    {
        return projectvideogenerator.m;
    }

    static Bitmap h(ProjectVideoGenerator projectvideogenerator)
    {
        return projectvideogenerator.b;
    }

    static GifOptions i(ProjectVideoGenerator projectvideogenerator)
    {
        return projectvideogenerator.l;
    }

    static boolean j(ProjectVideoGenerator projectvideogenerator)
    {
        return projectvideogenerator.j;
    }

    public final void a()
    {
        if (l != null && m != null)
        {
            f = new c(this, (byte)0);
        } else
        {
            f = new com.socialin.android.videogenerator.e(this, (byte)0);
        }
        f.execute(new Integer[0]);
    }

    public final void b()
    {
        f.cancel(false);
    }

}
