// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.target.ui.view.BackSpaceDetectorEditText;
import com.target.ui.view.CustomErrorViewWrapper;
import com.target.ui.view.a;

// Referenced classes of package com.target.ui.view.checkout:
//            GiftCardInputView

static class _cls9 extends a
{

    BackSpaceDetectorEditText gcAccessCode;
    EditText gcEditText;
    CustomErrorViewWrapper gcInputWrapper;
    EditText gcLastDigits;
    CustomErrorViewWrapper gcNumberWrapper;
    Button redeemButton;
    ImageView scanButton;

    _cls9(View view)
    {
        super(view);
    }
}
