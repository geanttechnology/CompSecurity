// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;

import android.text.TextPaint;
import android.text.style.UnderlineSpan;

// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            ShippingLabelFragment

class this._cls0 extends UnderlineSpan
{

    final ShippingLabelFragment this$0;

    public void updateDrawState(TextPaint textpaint)
    {
        textpaint.setUnderlineText(false);
    }

    ()
    {
        this$0 = ShippingLabelFragment.this;
        super();
    }
}
