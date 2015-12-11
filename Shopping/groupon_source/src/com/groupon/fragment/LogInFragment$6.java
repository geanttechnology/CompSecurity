// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.view.View;

// Referenced classes of package com.groupon.fragment:
//            LogInFragment, ForgotPasswordFragment

class this._cls0
    implements android.view.ener
{

    final LogInFragment this$0;

    public void onClick(View view)
    {
        view = new ForgotPasswordFragment();
        view.setCancelable(false);
        view.show(getActivity().getFragmentManager(), "FP");
    }

    agment()
    {
        this$0 = LogInFragment.this;
        super();
    }
}
