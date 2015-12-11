// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.view.View;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, StoreActivity, PostHomeActivity

class this._cls0
    implements android.view.istener
{

    final AkActivity this$0;

    public void onClick(View view)
    {
        if ((AkActivity.this instanceof StoreActivity) || (AkActivity.this instanceof PostHomeActivity))
        {
            goToHome(false);
            return;
        } else
        {
            goToHome(true);
            return;
        }
    }

    ity()
    {
        this$0 = AkActivity.this;
        super();
    }
}
