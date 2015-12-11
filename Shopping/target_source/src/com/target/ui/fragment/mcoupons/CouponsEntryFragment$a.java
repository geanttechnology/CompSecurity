// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.mcoupons;

import android.view.View;
import android.widget.Button;
import com.target.ui.view.mcoupons.CouponsSignUpView;

// Referenced classes of package com.target.ui.fragment.mcoupons:
//            CouponsEntryFragment

private class continueButton
{

    Button continueButton;
    CouponsSignUpView signUpView;
    final CouponsEntryFragment this$0;

    (View view)
    {
        this$0 = CouponsEntryFragment.this;
        super();
        signUpView = (CouponsSignUpView)view.findViewById(0x7f100193);
        continueButton = (Button)view.findViewById(0x7f100194);
    }
}
