// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.mcoupons;

import android.view.View;
import android.widget.EditText;
import com.target.ui.view.CustomErrorViewWrapper;
import com.target.ui.view.common.NameView;

// Referenced classes of package com.target.ui.view.mcoupons:
//            CouponsSignUpView

private static class mNameView
{

    NameView mNameView;
    CustomErrorViewWrapper phoneNumWrapper;
    EditText phoneNumber;
    EditText zipCode;
    CustomErrorViewWrapper zipCodeWrapper;

    public (View view)
    {
        zipCode = (EditText)view.findViewById(0x7f100424);
        zipCodeWrapper = (CustomErrorViewWrapper)view.findViewById(0x7f100423);
        phoneNumber = (EditText)view.findViewById(0x7f100427);
        phoneNumWrapper = (CustomErrorViewWrapper)view.findViewById(0x7f100426);
        mNameView = (NameView)view.findViewById(0x7f100421);
    }
}
