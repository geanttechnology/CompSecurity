// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.activity:
//            Thanks, IntentFactory

class an extends ClickableSpan
{

    final Thanks this$0;

    public void onClick(View view)
    {
        Thanks.access$600(Thanks.this).logClick("", "my_groupons_click", dealId, orderId);
        startActivity(Thanks.access$700(Thanks.this).newMyGrouponIntent(channel));
        finish();
    }

    public void updateDrawState(TextPaint textpaint)
    {
        textpaint.setUnderlineText(false);
        textpaint.setColor(getResources().getColor(0x7f0e0197));
    }

    tory()
    {
        this$0 = Thanks.this;
        super();
    }
}
