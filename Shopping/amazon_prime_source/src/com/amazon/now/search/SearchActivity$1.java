// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.search;

import android.view.View;
import com.amazon.now.permissions.PermissionsHelper;

// Referenced classes of package com.amazon.now.search:
//            SearchActivity

class this._cls0
    implements android.view.ner
{

    final SearchActivity this$0;

    public void onClick(View view)
    {
        PermissionsHelper.launchVoiceSearch(SearchActivity.this);
    }

    elper()
    {
        this$0 = SearchActivity.this;
        super();
    }
}
