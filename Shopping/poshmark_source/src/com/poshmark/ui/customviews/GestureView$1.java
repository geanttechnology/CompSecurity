// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.view.SurfaceHolder;
import com.poshmark.utils.PMGestureDetector;

// Referenced classes of package com.poshmark.ui.customviews:
//            GestureView

class this._cls0
    implements android.view.Callback
{

    final GestureView this$0;

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        updateImage();
        gestureDetector = new PMGestureDetector(GestureView.this, GestureView.this);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
    }

    ()
    {
        this$0 = GestureView.this;
        super();
    }
}
