// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.hardware.Camera;
import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;

public class byz
    implements android.hardware.Camera.AutoFocusCallback
{

    final BeautyCameraGLSurfaceView a;

    public byz(BeautyCameraGLSurfaceView beautycameraglsurfaceview)
    {
        a = beautycameraglsurfaceview;
        super();
    }

    public void onAutoFocus(boolean flag, Camera camera)
    {
        if (!flag);
    }
}
