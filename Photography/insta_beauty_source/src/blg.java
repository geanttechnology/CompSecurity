// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.model.res.pip.TDFSceneInfo;
import com.wantu.piprender.Opengles2GLSurfaceView;

public class blg
    implements Runnable
{

    final Opengles2GLSurfaceView a;
    private TDFSceneInfo b;

    public blg(Opengles2GLSurfaceView opengles2glsurfaceview, TDFSceneInfo tdfsceneinfo)
    {
        a = opengles2glsurfaceview;
        super();
        b = tdfsceneinfo;
    }

    public void run()
    {
        Opengles2GLSurfaceView.access$000(a).a(b);
    }
}
