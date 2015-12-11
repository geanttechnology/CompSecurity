// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.mcoupons;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.target.ui.util.h.c;

// Referenced classes of package com.target.ui.fragment.mcoupons:
//            CouponsVerificationFragment

class this._cls0 extends ClickableSpan
{

    final CouponsVerificationFragment this$0;

    public void onClick(View view)
    {
        c.a(getActivity(), getString(0x7f0902cd));
    }

    public void updateDrawState(TextPaint textpaint)
    {
        textpaint.setUnderlineText(false);
    }

    ()
    {
        this$0 = CouponsVerificationFragment.this;
        super();
    }
}
