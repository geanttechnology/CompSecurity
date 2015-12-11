// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.mcoupons;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

// Referenced classes of package com.target.ui.fragment.mcoupons:
//            CouponOnDemandFragment

private class cancelButton
{

    Button cancelButton;
    EditText codeInput;
    Button submitButton;
    final CouponOnDemandFragment this$0;

    (View view)
    {
        this$0 = CouponOnDemandFragment.this;
        super();
        codeInput = (EditText)view.findViewById(0x7f1001a1);
        submitButton = (Button)view.findViewById(0x7f1001a2);
        cancelButton = (Button)view.findViewById(0x7f1001a3);
    }
}
