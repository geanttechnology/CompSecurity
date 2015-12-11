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

// Referenced classes of package com.groupon.activity:
//            GiftingThemeSelection

private class <init>
    implements android.view.istener
{

    final GiftingThemeSelection this$0;

    public void onClick(View view)
    {
        giftingRecord.themeId = GiftingThemeSelection.access$500(GiftingThemeSelection.this);
        giftingRecord.themeCategoryIndex = GiftingThemeSelection.access$300(GiftingThemeSelection.this);
        giftingRecord.themeSubIndex = GiftingThemeSelection.access$400(GiftingThemeSelection.this);
        setResult(-1, (new Intent()).putExtra("giftingRecord", giftingRecord));
        view = new ClickExtraInfo();
        GiftingNSTField giftingnstfield = new GiftingNSTField();
        giftingnstfield.deliveryMethod = giftingRecord.deliveryMethod;
        view.gifting = giftingnstfield;
        view.pageId = "gift_theme_selection";
        GiftingThemeSelection.access$900(GiftingThemeSelection.this).logClick("", "gifting_details_done_click", "", null, view);
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
        this$0 = GiftingThemeSelection.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
