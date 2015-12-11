// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.ui.PMContainerActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            BrandFragment

class this._cls0
    implements android.view.ener
{

    final BrandFragment this$0;

    public void onClick(View view)
    {
        view = new Bundle();
        view.putString("NAME", BrandFragment.access$200(BrandFragment.this));
        view.putString("MODE", DE.JUST_IN.toString());
        ((PMContainerActivity)getActivity()).launchFragment(view, com/poshmark/ui/fragments/BrandFragment, null);
    }

    DE()
    {
        this$0 = BrandFragment.this;
        super();
    }
}
