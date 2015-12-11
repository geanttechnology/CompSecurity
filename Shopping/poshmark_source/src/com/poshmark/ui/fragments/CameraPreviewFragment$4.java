// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.hardware.Camera;
import android.view.View;

// Referenced classes of package com.poshmark.ui.fragments:
//            CameraPreviewFragment

class this._cls0
    implements android.view.ewFragment._cls4
{

    final CameraPreviewFragment this$0;

    public void onClick(View view)
    {
        CameraPreviewFragment.access$000(CameraPreviewFragment.this);
        CameraPreviewFragment.access$100(CameraPreviewFragment.this);
        CameraPreviewFragment.access$200(CameraPreviewFragment.this);
        CameraPreviewFragment.access$300(CameraPreviewFragment.this, surfaceHolder);
        mCamera.startPreview();
    }

    ()
    {
        this$0 = CameraPreviewFragment.this;
        super();
    }
}
