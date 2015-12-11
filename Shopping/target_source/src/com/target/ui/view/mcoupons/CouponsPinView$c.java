// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.mcoupons;

import android.text.Editable;
import android.text.TextWatcher;
import com.target.ui.view.BackSpaceDetectorEditText;

// Referenced classes of package com.target.ui.view.mcoupons:
//            CouponsPinView

private final class <init>
    implements TextWatcher
{

    final CouponsPinView this$0;
    private boolean wasValid;

    public void afterTextChanged(Editable editable)
    {
        editable = Boolean.valueOf(CouponsPinView.a(CouponsPinView.this, CouponsPinView.a(CouponsPinView.this).pinOne));
        if (wasValid != editable.booleanValue())
        {
            CouponsPinView.a(CouponsPinView.this, editable.booleanValue());
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        wasValid = CouponsPinView.a(CouponsPinView.this, CouponsPinView.a(CouponsPinView.this).pinOne);
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (CouponsPinView.a(CouponsPinView.this).pinOne.getText().toString().length() == 1)
        {
            CouponsPinView.a(CouponsPinView.this).pinTwo.requestFocus();
        }
    }

    private ()
    {
        this$0 = CouponsPinView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
