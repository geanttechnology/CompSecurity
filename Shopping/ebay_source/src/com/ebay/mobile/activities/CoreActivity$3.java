// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Intent;
import android.view.View;
import com.ebay.mobile.search.MainSearchActivity;

// Referenced classes of package com.ebay.mobile.activities:
//            CoreActivity

class this._cls0
    implements android.view.tener
{

    final CoreActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(CoreActivity.this, com/ebay/mobile/search/MainSearchActivity);
        startActivity(view);
    }

    ()
    {
        this$0 = CoreActivity.this;
        super();
    }
}
