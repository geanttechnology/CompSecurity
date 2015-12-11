// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.view.View;
import com.groupon.models.gift.GiftingRecord;
import com.groupon.models.nst.ClickExtraInfo;
import com.groupon.models.nst.GiftingNSTField;
import com.groupon.util.LoggingUtils;
import com.groupon.util.ViewUtils;

// Referenced classes of package com.groupon.activity:
//            Gifting

private class <init>
    implements android.view.istener
{

    final Gifting this$0;

    public void onClick(View view)
    {
        if (!Gifting.access$800(Gifting.this))
        {
            ViewUtils.setSoftKeyboardState(Gifting.access$900(Gifting.this), true, Gifting.access$1000(Gifting.this));
            return;
        }
        Gifting.access$1100(Gifting.this);
        setResult(-1, (new Intent()).putExtra("giftingRecord", giftingRecord));
        view = new ClickExtraInfo();
        GiftingNSTField giftingnstfield = new GiftingNSTField();
        giftingnstfield.deliveryMethod = giftingRecord.deliveryMethod;
        view.gifting = giftingnstfield;
        view.pageId = "edit_gift_info_page";
        Gifting.access$1200(Gifting.this).logClick("", "gifting_details_done_click", "", null, view);
        if (next != null)
        {
            next.setExtrasClassLoader(getClassLoader());
            next.putExtra("giftingRecord", giftingRecord);
            startActivity(next);
        }
        finish();
    }

    private ()
    {
        this$0 = Gifting.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
