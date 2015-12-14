// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.opengl;


// Referenced classes of package com.aviary.android.feather.sdk.opengl:
//            AviaryGLSurfaceView

class val.height
    implements Runnable
{

    final AviaryGLSurfaceView this$0;
    final boolean val$changed;
    final int val$height;
    final int val$width;

    public void run()
    {
        AviaryGLSurfaceView.access$1000(AviaryGLSurfaceView.this).onSurfaceChanged(val$changed, val$width, val$height);
    }

    RendererListener()
    {
        this$0 = final_aviaryglsurfaceview;
        val$changed = flag;
        val$width = i;
        val$height = I.this;
        super();
    }
}
