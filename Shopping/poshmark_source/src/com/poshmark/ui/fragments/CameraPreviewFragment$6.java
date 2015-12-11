// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.hardware.Camera;

// Referenced classes of package com.poshmark.ui.fragments:
//            CameraPreviewFragment

class this._cls0
    implements android.hardware.
{

    final CameraPreviewFragment this$0;

    public void onAutoFocus(boolean flag, Camera camera)
    {
        mCamera.takePicture(null, null, CameraPreviewFragment.access$400(CameraPreviewFragment.this));
    }

    ()
    {
        this$0 = CameraPreviewFragment.this;
        super();
    }
}
