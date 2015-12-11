// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.hardware.Camera;
import android.view.SurfaceHolder;

// Referenced classes of package com.poshmark.ui.fragments:
//            CameraPreviewFragment

class this._cls0
    implements android.view.ewFragment._cls7
{

    final CameraPreviewFragment this$0;

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
        if (mCamera != null)
        {
            CameraPreviewFragment.access$300(CameraPreviewFragment.this, surfaceholder);
            mCamera.startPreview();
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        CameraPreviewFragment.access$500(CameraPreviewFragment.this);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        CameraPreviewFragment.access$000(CameraPreviewFragment.this);
    }

    ()
    {
        this$0 = CameraPreviewFragment.this;
        super();
    }
}
