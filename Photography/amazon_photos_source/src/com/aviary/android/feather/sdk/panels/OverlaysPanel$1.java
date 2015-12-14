// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import com.aviary.android.feather.sdk.overlays.AviaryOverlay;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            OverlaysPanel

class this._cls0
    implements com.aviary.android.feather.sdk.overlays.CloseListener
{

    final OverlaysPanel this$0;

    public void onClose(AviaryOverlay aviaryoverlay)
    {
        aviaryoverlay.dismiss();
    }

    OnCloseListener()
    {
        this$0 = OverlaysPanel.this;
        super();
    }
}
