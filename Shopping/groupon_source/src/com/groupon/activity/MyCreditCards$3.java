// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;

// Referenced classes of package com.groupon.activity:
//            MyCreditCards, IntentFactory

class this._cls0
    implements android.view.ener
{

    final MyCreditCards this$0;

    public void onClick(View view)
    {
        startActivityForResult(MyCreditCards.access$200(MyCreditCards.this).newEditCreditCardIntent(dealId, cartUUID, null, channel, storageConsentRequirements), 10102);
    }

    ()
    {
        this$0 = MyCreditCards.this;
        super();
    }
}
