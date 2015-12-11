// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.view.View;
import com.poshmark.ui.customviews.CameraViewportRectView;
import com.poshmark.ui.customviews.CropImageSurfaceView;

// Referenced classes of package com.poshmark.ui.fragments:
//            CropImageFragment

class this._cls0
    implements android.view.
{

    final CropImageFragment this$0;

    public void onClick(View view)
    {
        if (!isNextClicked)
        {
            isNextClicked = true;
            view = CropImageFragment.access$100(CropImageFragment.this).getBitmap(CropImageFragment.access$000(CropImageFragment.this).getViewportRect());
            Intent intent = new Intent();
            intent.setData(view);
            finishActivityWithResult(-1, intent);
        }
    }

    ew()
    {
        this$0 = CropImageFragment.this;
        super();
    }
}
