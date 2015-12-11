// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.ui.PMContainerActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            BrandFragment_v1

class this._cls0
    implements android.view.r
{

    final BrandFragment_v1 this$0;

    public void onClick(View view)
    {
        view = new Bundle();
        view.putString("NAME", BrandFragment_v1.access$200(BrandFragment_v1.this));
        view.putString("MODE", DE.JUST_IN.toString());
        ((PMContainerActivity)getActivity()).launchFragment(view, com/poshmark/ui/fragments/BrandFragment_v1, null);
    }

    DE()
    {
        this$0 = BrandFragment_v1.this;
        super();
    }
}
