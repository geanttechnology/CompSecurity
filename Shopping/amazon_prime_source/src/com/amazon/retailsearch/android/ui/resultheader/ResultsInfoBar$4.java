// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.resultheader;

import com.amazon.retailsearch.android.api.log.RetailSearchLogger;

// Referenced classes of package com.amazon.retailsearch.android.ui.resultheader:
//            ResultsInfoBar

class this._cls0
    implements com.amazon.retailsearch.popup.ntV4.OnCloseListener
{

    final ResultsInfoBar this$0;

    public void onClose()
    {
        ResultsInfoBar.access$200(ResultsInfoBar.this).filterMenuClosed();
        ResultsInfoBar.access$302(ResultsInfoBar.this, null);
    }

    er()
    {
        this$0 = ResultsInfoBar.this;
        super();
    }
}
