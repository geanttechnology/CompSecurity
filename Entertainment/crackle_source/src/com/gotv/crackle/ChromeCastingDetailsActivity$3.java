// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import com.gotv.crackle.data.DetailsProvider;

// Referenced classes of package com.gotv.crackle:
//            ChromeCastingDetailsActivity

class this._cls0
    implements com.gotv.crackle.data.
{

    final ChromeCastingDetailsActivity this$0;

    public void onDataFailed(String s, String s1)
    {
        onDataFailed(s, s1);
    }

    public void onDataSuccess(String s)
    {
        ChromeCastingDetailsActivity.access$1300(ChromeCastingDetailsActivity.this, mDetailsProvider.getMediaDetailsItem(), false);
    }

    tener()
    {
        this$0 = ChromeCastingDetailsActivity.this;
        super();
    }
}
