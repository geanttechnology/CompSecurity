// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import com.aviary.android.feather.common.tracking.AviaryTracker;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.sdk.widget.DrawableHighlightView;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            StickersPanel

class this._cls0
    implements com.aviary.android.feather.sdk.widget.View.OnContentFlipListener
{

    final StickersPanel this$0;

    public void onContentFlip(DrawableHighlightView drawablehighlightview)
    {
        getContext().getTracker().tagEvent("stickers: item_flipped");
    }

    View()
    {
        this$0 = StickersPanel.this;
        super();
    }
}
