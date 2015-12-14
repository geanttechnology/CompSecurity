// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.view.View;
import android.widget.SeekBar;
import com.aviary.android.feather.sdk.widget.DrawableHighlightView;
import com.aviary.android.feather.sdk.widget.ImageViewDrawableOverlay;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            StickersPanel, SimpleStatusMachine

class this._cls0
    implements android.view.ener
{

    final StickersPanel this$0;

    public void onClick(View view)
    {
        mLogger.log("sticker opacity dismiss clicked");
        view = ((ImageViewDrawableOverlay)mImageView).getHighlightViewAt(0);
        if (view != null)
        {
            view.setOpacity(view.getConfirmedOpacity());
            StickersPanel.access$100(StickersPanel.this).setProgress((int)(((double)view.getConfirmedOpacity() / 255D) * 100D));
        }
        StickersPanel.access$200(StickersPanel.this).setStatus(StickersPanel.access$200(StickersPanel.this).getPreviousStatus());
    }

    ine()
    {
        this$0 = StickersPanel.this;
        super();
    }
}
