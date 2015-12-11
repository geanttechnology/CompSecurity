// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.hardware.Camera;
import android.view.View;

// Referenced classes of package com.poshmark.ui.fragments:
//            CameraPreviewFragment

class this._cls0
    implements android.view.ewFragment._cls1
{

    final CameraPreviewFragment this$0;

    public void onClick(View view)
    {
        if (!pictureTaken)
        {
            pictureTaken = true;
            if (mCamera != null)
            {
                mCamera.autoFocus(mAutoFocusCallback);
            }
        }
    }

    ()
    {
        this$0 = CameraPreviewFragment.this;
        super();
    }
}
