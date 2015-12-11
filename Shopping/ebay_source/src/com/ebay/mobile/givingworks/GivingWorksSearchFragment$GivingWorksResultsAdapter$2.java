// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.givingworks;

import android.view.View;

// Referenced classes of package com.ebay.mobile.givingworks:
//            GivingWorksSearchFragment

class this._cls1
    implements android.view.sultsAdapter._cls2
{

    final nNonProfitSelected this$1;

    public void onClick(View view)
    {
        if (GivingWorksSearchFragment.access$000(_fld0) != null)
        {
            GivingWorksSearchFragment.access$000(_fld0).nNonProfitSelected((com.ebay.common.model.givingworks.ofitSelected)view.getTag());
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
