// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.graphics.Rect;
import android.util.Log;
import com.poshmark.ui.customviews.CameraViewportRectView;
import com.poshmark.ui.customviews.GestureView;

// Referenced classes of package com.poshmark.ui.fragments:
//            GestureTester

class this._cls0
    implements com.poshmark.ui.customviews.ctView.CustomListener
{

    final GestureTester this$0;

    public void afterDraw()
    {
        Log.d("GestureTester", (new StringBuilder()).append(croppable_space.getViewportRect().width()).append(":").append(croppable_space.getViewportRect().height()).append(":").append(croppable_space.getViewportRect().left).append(":").append(croppable_space.getViewportRect().top).toString());
        croppable_view.setVisibility(0);
        croppable_view.setupBitmap(croppable_space.getViewportRect());
    }

    RectView()
    {
        this$0 = GestureTester.this;
        super();
    }
}
