// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.hardware.Camera;
import android.util.Log;
import java.util.Date;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            FocusingCameraPreview

class this._cls0
    implements android.hardware.
{

    final FocusingCameraPreview this$0;

    public void onAutoFocus(boolean flag, Camera camera)
    {
        if (mCamera != null)
        {
            FocusingCameraPreview.access$002(FocusingCameraPreview.this, false);
            FocusingCameraPreview.access$102(FocusingCameraPreview.this, 3);
            FocusingCameraPreview.access$202(FocusingCameraPreview.this, new Date());
            if (FocusingCameraPreview.access$300(FocusingCameraPreview.this))
            {
                try
                {
                    mCamera.cancelAutoFocus();
                    camera = mCamera.getParameters();
                    camera.usMode("continuous-picture");
                    mCamera.setParameters(camera);
                    FocusingCameraPreview.access$400(FocusingCameraPreview.this);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Camera camera)
                {
                    Log.e("FocusingCameraPreview", (new StringBuilder()).append("Error to set continuse-picture after autoFocus:").append(camera.getMessage()).toString());
                }
                return;
            }
        }
    }

    ()
    {
        this$0 = FocusingCameraPreview.this;
        super();
    }
}
