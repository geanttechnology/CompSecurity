// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.opengl;

import com.aviary.android.feather.common.threading.Future;
import com.aviary.android.feather.common.threading.FutureListener;

// Referenced classes of package com.aviary.android.feather.sdk.opengl:
//            AviaryGLSurfaceView

class this._cls0
    implements FutureListener
{

    final AviaryGLSurfaceView this$0;

    public void onFutureDone(Future future)
    {
        AviaryGLSurfaceView.access$100(AviaryGLSurfaceView.this);
    }

    A()
    {
        this$0 = AviaryGLSurfaceView.this;
        super();
    }
}
