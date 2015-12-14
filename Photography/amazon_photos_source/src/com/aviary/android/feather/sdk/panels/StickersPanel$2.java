// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.widget.SeekBar;
import com.aviary.android.feather.common.utils.ApiHelper;
import com.aviary.android.feather.library.graphics.drawable.FeatherDrawable;
import com.aviary.android.feather.sdk.widget.DrawableHighlightView;
import com.aviary.android.feather.sdk.widget.ImageViewDrawableOverlay;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            StickersPanel

class this._cls0
    implements android.widget.rChangeListener
{

    final StickersPanel this$0;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        seekbar = ((ImageViewDrawableOverlay)mImageView).getHighlightViewAt(0);
        if (seekbar != null)
        {
            seekbar.setOpacity((int)(((double)i / 100D) * 255D));
        }
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        if (!ApiHelper.AT_LEAST_14)
        {
            seekbar = ((ImageViewDrawableOverlay)mImageView).getHighlightViewAt(0);
            seekbar.invalidateDrawable(seekbar.getContent().getCurrent());
        }
    }

    eatherDrawable()
    {
        this$0 = StickersPanel.this;
        super();
    }
}
