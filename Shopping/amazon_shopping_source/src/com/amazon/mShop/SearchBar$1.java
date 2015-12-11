// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.view.View;

// Referenced classes of package com.amazon.mShop:
//            SearchBar

class this._cls0
    implements android.view.Listener
{

    final SearchBar this$0;

    public void onClick(View view)
    {
        goToSearchEntry(null, true);
        logRefMarker();
        SearchBar.access$002(SearchBar.this, true);
    }

    ener()
    {
        this$0 = SearchBar.this;
        super();
    }
}
