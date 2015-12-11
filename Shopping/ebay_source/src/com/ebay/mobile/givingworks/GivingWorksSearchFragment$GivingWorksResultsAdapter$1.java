// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.givingworks;

import android.os.Bundle;
import android.view.View;

// Referenced classes of package com.ebay.mobile.givingworks:
//            GivingWorksSearchFragment, GivingWorksCharityFragment

class this._cls1
    implements android.view.sultsAdapter._cls1
{

    final this._cls1 this$1;

    public void onClick(View view)
    {
        Object obj = (com.ebay.common.model.givingworks.)view.getTag();
        view = new Bundle();
        view.putParcelable("charity_nonprofit", ((android.os.Parcelable) (obj)));
        obj = new GivingWorksCharityFragment();
        ((GivingWorksCharityFragment) (obj)).setArguments(view);
        ((GivingWorksCharityFragment) (obj)).show(getFragmentManager(), "giving_works_charity");
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
