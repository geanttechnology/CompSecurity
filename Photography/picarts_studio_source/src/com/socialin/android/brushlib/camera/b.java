// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.camera;


// Referenced classes of package com.socialin.android.brushlib.camera:
//            CameraPreviewContainer

public final class b
{

    public final android.hardware.Camera.Size a;
    final android.hardware.Camera.Size b;
    private CameraPreviewContainer c;

    public b(CameraPreviewContainer camerapreviewcontainer, android.hardware.Camera.Size size, android.hardware.Camera.Size size1)
    {
        c = camerapreviewcontainer;
        super();
        a = size;
        b = size1;
    }

    public final String toString()
    {
        return (new StringBuilder("preview : ")).append(CameraPreviewContainer.b(a)).append(", picture : ").append(CameraPreviewContainer.b(b)).toString();
    }
}
