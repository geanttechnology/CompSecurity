// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.hardware.Camera;
import android.view.View;
import android.widget.Button;

// Referenced classes of package com.poshmark.ui.fragments:
//            CameraPreviewFragment

class this._cls0
    implements android.view.ewFragment._cls5
{

    final CameraPreviewFragment this$0;

    public void onClick(View view)
    {
        android.hardware.agment._cls5 _lcls5;
        view = (Button)view;
        _lcls5 = mCamera.getParameters();
        if (!currentFlashMode.equals("auto")) goto _L2; else goto _L1
_L1:
        currentFlashMode = "off";
        _lcls5.shMode(currentFlashMode);
        view.setText(getString(0x7f0601db));
_L4:
        mCamera.setParameters(_lcls5);
        return;
_L2:
        if (currentFlashMode.equals("off"))
        {
            currentFlashMode = "on";
            _lcls5.shMode(currentFlashMode);
            view.setText(getString(0x7f0601e2));
        } else
        if (currentFlashMode.equals("on"))
        {
            currentFlashMode = "auto";
            _lcls5.shMode(currentFlashMode);
            view.setText(getString(0x7f06004d));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    ()
    {
        this$0 = CameraPreviewFragment.this;
        super();
    }
}
