// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.ViewTreeObserver;

// Referenced classes of package com.groupon.view:
//            ExpandablePanel

protected class this._cls0
    implements android.view.ner
{

    final ExpandablePanel this$0;

    public void onGlobalLayout()
    {
        updatePanelState(true, false);
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    protected ()
    {
        this$0 = ExpandablePanel.this;
        super();
    }
}
