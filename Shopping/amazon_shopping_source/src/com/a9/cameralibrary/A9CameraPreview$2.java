// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.cameralibrary;

import android.hardware.Camera;
import java.util.Date;

// Referenced classes of package com.a9.cameralibrary:
//            A9CameraPreview

class this._cls0
    implements android.hardware.llback
{

    final A9CameraPreview this$0;

    public void onAutoFocus(boolean flag, Camera camera)
    {
        if (!A9CameraPreview.access$000(A9CameraPreview.this)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        A9CameraPreview.access$102(A9CameraPreview.this, false);
        A9CameraPreview.access$202(A9CameraPreview.this, 3);
        A9CameraPreview.access$302(A9CameraPreview.this, new Date());
        if (!A9CameraPreview.access$400(A9CameraPreview.this)) goto _L1; else goto _L3
_L3:
        camera = A9CameraPreview.access$500(A9CameraPreview.this).getParameters();
        camera.setFocusMode("continuous-picture");
        A9CameraPreview.access$500(A9CameraPreview.this).setParameters(camera);
        A9CameraPreview.access$600(A9CameraPreview.this);
        return;
        camera;
        A9CameraPreview.access$102(A9CameraPreview.this, false);
        return;
    }

    ck()
    {
        this$0 = A9CameraPreview.this;
        super();
    }
}
