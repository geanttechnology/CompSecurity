// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.mcoupons;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.target.mothership.util.o;

// Referenced classes of package com.target.ui.fragment.mcoupons:
//            CouponOnDemandFragment

class this._cls0
    implements TextWatcher
{

    final CouponOnDemandFragment this$0;

    public void afterTextChanged(Editable editable)
    {
        if (o.f(editable.toString()))
        {
            CouponOnDemandFragment.a(CouponOnDemandFragment.this).submitButton.setEnabled(true);
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    ()
    {
        this$0 = CouponOnDemandFragment.this;
        super();
    }
}
