// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.view.ObservableScrollView;

// Referenced classes of package com.groupon.util:
//            TransparentToolBarHelper

class this._cls0
    implements com.groupon.view.utUpdatedListener
{

    final TransparentToolBarHelper this$0;

    public void onLayoutUpdated(boolean flag, int i, int j, int k, int l)
    {
        adjustToolbarTransparency(TransparentToolBarHelper.access$000(TransparentToolBarHelper.this).getScrollY());
        TransparentToolBarHelper.access$000(TransparentToolBarHelper.this).setOnLayoutUpdatedListener(null);
    }

    utUpdatedListener()
    {
        this$0 = TransparentToolBarHelper.this;
        super();
    }
}
