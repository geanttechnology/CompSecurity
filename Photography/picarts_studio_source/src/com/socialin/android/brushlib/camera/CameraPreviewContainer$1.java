// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.camera;


// Referenced classes of package com.socialin.android.brushlib.camera:
//            CameraPreviewContainer

final class a
    implements Runnable
{

    private CameraPreviewContainer a;

    public final void run()
    {
        a.requestLayout();
    }

    (CameraPreviewContainer camerapreviewcontainer)
    {
        a = camerapreviewcontainer;
        super();
    }
}
