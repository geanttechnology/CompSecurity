// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.view.GrouponCheckMark;

// Referenced classes of package com.groupon.activity:
//            GiftCodes

class this._cls0
    implements android.view.Listener
{

    final GiftCodes this$0;

    public void onClick(View view)
    {
        giftCardCheckMark.toggle();
    }

    ()
    {
        this$0 = GiftCodes.this;
        super();
    }
}
