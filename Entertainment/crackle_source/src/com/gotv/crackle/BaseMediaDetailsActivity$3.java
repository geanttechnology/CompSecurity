// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.view.View;
import com.gotv.crackle.data.DetailsProvider;

// Referenced classes of package com.gotv.crackle:
//            BaseMediaDetailsActivity

class this._cls0
    implements android.view.y._cls3
{

    final BaseMediaDetailsActivity this$0;

    public void onClick(View view)
    {
        playMediaItem(mDetailsProvider.getMediaId());
    }

    ()
    {
        this$0 = BaseMediaDetailsActivity.this;
        super();
    }
}
