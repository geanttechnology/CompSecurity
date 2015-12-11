// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search;

import android.content.DialogInterface;

// Referenced classes of package com.amazon.mShop.search:
//            SearchActivity

class this._cls0
    implements android.content.nCancelListener
{

    final SearchActivity this$0;

    public void onCancel(DialogInterface dialoginterface)
    {
        if (getCurrentView() == null)
        {
            finish();
        }
    }

    istener()
    {
        this$0 = SearchActivity.this;
        super();
    }
}
