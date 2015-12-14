// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.opengl;

import com.aviary.android.feather.common.threading.Future;
import com.aviary.android.feather.common.threading.FutureListener;

// Referenced classes of package com.aviary.android.feather.sdk.opengl:
//            AviaryGLSurfaceView

class val.height
    implements FutureListener
{

    final AviaryGLSurfaceView this$0;
    final boolean val$changed;
    final int val$height;
    final int val$width;

    public void onFutureDone(Future future)
    {
        AviaryGLSurfaceView.access$200(AviaryGLSurfaceView.this, val$changed, val$width, val$height);
    }

    A()
    {
        this$0 = final_aviaryglsurfaceview;
        val$changed = flag;
        val$width = i;
        val$height = I.this;
        super();
    }
}
