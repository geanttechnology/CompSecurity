// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.ui.PMContainerActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment

class this._cls0
    implements android.view.istener
{

    final PMFragment this$0;

    public void onClick(View view)
    {
        ((PMContainerActivity)getActivity()).toggleDrawer();
    }

    ()
    {
        this$0 = PMFragment.this;
        super();
    }
}
