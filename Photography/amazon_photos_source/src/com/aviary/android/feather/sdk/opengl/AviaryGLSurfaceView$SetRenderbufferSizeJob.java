// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.opengl;


// Referenced classes of package com.aviary.android.feather.sdk.opengl:
//            AviaryGLSurfaceView

class this._cls0
    implements com.aviary.android.feather.common.threading.
{

    final AviaryGLSurfaceView this$0;

    public volatile Object run(com.aviary.android.feather.common.threading. , Object aobj[])
        throws Exception
    {
        return run(, (Integer[])aobj);
    }

    public transient Void run(com.aviary.android.feather.common.threading. , Integer ainteger[])
        throws Exception
    {
        AviaryGLSurfaceView.access$300().run("SetRenderbufferSizeJob::run");
        AviaryGLSurfaceView.access$700(AviaryGLSurfaceView.this, ainteger[0].intValue(), ainteger[1].intValue());
        return null;
    }

    public ()
    {
        this$0 = AviaryGLSurfaceView.this;
        super();
    }
}
