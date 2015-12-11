// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Handler;

final class cju extends GLSurfaceView
    implements ckf
{

    final cmp a;

    public cju(Context context, Handler handler)
    {
        super(context);
        setEGLContextClientVersion(2);
        a = new cmp(context, handler);
        setRenderer(a);
    }

    public final void a(cms cms)
    {
        a.a(cms);
    }

    public final void layout(int i, int j, int k, int l)
    {
        super.layout(i, j, k, l);
        a.a.a(k - i, l - j);
    }
}
