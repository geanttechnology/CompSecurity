// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.piprender.Opengles2GLSurfaceView;

public class blf
    implements Runnable
{

    final Opengles2GLSurfaceView a;

    public blf(Opengles2GLSurfaceView opengles2glsurfaceview)
    {
        a = opengles2glsurfaceview;
        super();
    }

    public void run()
    {
        Opengles2GLSurfaceView.access$000(a).a();
    }
}
