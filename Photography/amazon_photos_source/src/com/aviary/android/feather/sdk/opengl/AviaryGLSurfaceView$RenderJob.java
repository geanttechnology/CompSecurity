// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.opengl;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;

// Referenced classes of package com.aviary.android.feather.sdk.opengl:
//            AviaryGLSurfaceView

class mBitmap
    implements com.aviary.android.feather.common.threading.p
{

    WeakReference mBitmap;
    final AviaryGLSurfaceView this$0;

    public transient Boolean run(com.aviary.android.feather.common.threading.p p, String as[])
        throws Exception
    {
        AviaryGLSurfaceView.access$300().("RenderJob::run");
        if (mBitmap != null && mBitmap.get() != null)
        {
            return Boolean.valueOf(AviaryGLSurfaceView.access$400(AviaryGLSurfaceView.this, (Bitmap)mBitmap.get(), as[0]));
        } else
        {
            return Boolean.valueOf(false);
        }
    }

    public volatile Object run(com.aviary.android.feather.common.threading.p p, Object aobj[])
        throws Exception
    {
        return run(p, (String[])aobj);
    }

    public I(Bitmap bitmap)
    {
        this$0 = AviaryGLSurfaceView.this;
        super();
        mBitmap = new WeakReference(bitmap);
    }
}
