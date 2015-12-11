// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Context;
import android.graphics.Rect;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import com.smule.android.c.aa;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicGLSurfaceView, p

class GlobeGLSurfaceView extends GLSurfaceView
{

    private static final String a = com/smule/pianoandroid/magicpiano/MagicGLSurfaceView.getCanonicalName();
    private p b;

    public GlobeGLSurfaceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setEGLContextClientVersion(2);
        b = new p(context);
        setRenderer(b);
        aa.c(a, "Creating GlobeGLSurfaceView");
    }

    public void a(float f, float f1)
    {
        b.a(f, f1);
    }

    public void a(Rect rect)
    {
        b.a(rect);
    }

}
