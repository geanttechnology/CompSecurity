// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            BrandFragment, ShareFragment

class this._cls0
    implements android.view.ener
{

    final BrandFragment this$0;

    public void onClick(View view)
    {
        view = new Bundle();
        view.putString("MODE", com.poshmark.utils.RE_MODE.SHARE_MODE_BRAND.name());
        PMActivity pmactivity = (PMActivity)getActivity();
        if (isAdded() && BrandFragment.access$100(BrandFragment.this) != null)
        {
            pmactivity.launchFragmentInNewActivity(view, com/poshmark/ui/fragments/ShareFragment, BrandFragment.access$100(BrandFragment.this));
        }
    }

    ()
    {
        this$0 = BrandFragment.this;
        super();
    }
}
