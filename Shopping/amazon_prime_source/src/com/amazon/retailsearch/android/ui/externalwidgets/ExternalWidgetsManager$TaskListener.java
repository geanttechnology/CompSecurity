// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.externalwidgets;

import com.amazon.searchapp.retailsearch.model.TrackingInfo;

// Referenced classes of package com.amazon.retailsearch.android.ui.externalwidgets:
//            ExternalWidgetsManager, ExternalWidgetState

private class <init> extends com.amazon.retailsearch.data.sManager.TaskListener
{

    final ExternalWidgetsManager this$0;

    public void trackingInfo(TrackingInfo trackinginfo)
    {
        if (trackinginfo == null)
        {
            return;
        } else
        {
            ExternalWidgetsManager.access$100(ExternalWidgetsManager.this).setStore(trackinginfo.getStore());
            return;
        }
    }

    private ()
    {
        this$0 = ExternalWidgetsManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
