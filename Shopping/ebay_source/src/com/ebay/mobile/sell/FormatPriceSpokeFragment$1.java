// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ebay.mobile.activities.ShowWebViewActivity;

// Referenced classes of package com.ebay.mobile.sell:
//            FormatPriceSpokeFragment

static final class val.termsUrl extends ClickableSpan
{

    final Activity val$activity;
    final String val$termsUrl;

    public void onClick(View view)
    {
        ShowWebViewActivity.start(val$activity, val$termsUrl, "", "spgLearnMore");
    }

    public void updateDrawState(TextPaint textpaint)
    {
        textpaint.setColor(textpaint.linkColor);
        textpaint.setUnderlineText(false);
    }

    (Activity activity1, String s)
    {
        val$activity = activity1;
        val$termsUrl = s;
        super();
    }
}
