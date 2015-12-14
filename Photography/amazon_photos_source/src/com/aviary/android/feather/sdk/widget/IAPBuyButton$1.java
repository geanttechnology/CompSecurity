// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.util.Pair;
import com.aviary.android.feather.cds.CdsUtils;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            IAPBuyButton

class this._cls0
    implements Runnable
{

    final IAPBuyButton this$0;

    public void run()
    {
        if (mPackId > -1L && getContext() != null && mOption != null)
        {
            Pair pair = CdsUtils.getPackOptionDownloadStatus(getContext(), mPackId);
            if (pair != null && getContext() != null)
            {
                setPackOption(new com.aviary.android.feather.cds.tionWithPrice((com.aviary.android.feather.cds.tion)pair.first), mPackId);
            }
        }
    }

    hPrice()
    {
        this$0 = IAPBuyButton.this;
        super();
    }
}
