// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.input;

import com.amazon.retailsearch.android.ui.ClearButtonEventListener;

// Referenced classes of package com.amazon.retailsearch.android.ui.input:
//            RetailSearchQueryEntry

class this._cls0
    implements ClearButtonEventListener
{

    final RetailSearchQueryEntry this$0;

    public void onTextCleared()
    {
        openSearch();
    }

    ()
    {
        this$0 = RetailSearchQueryEntry.this;
        super();
    }
}
