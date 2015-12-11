// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Intent;

// Referenced classes of package com.ebay.mobile.activities:
//            SampleMessageActivity

class this._cls0
    implements stItem
{

    final SampleMessageActivity this$0;

    public void start(int i)
    {
        Intent intent = new Intent(SampleMessageActivity.this, com/ebay/mobile/activities/SampleMessageActivity);
        if (!getIntent().getBooleanExtra("invert", false))
        {
            intent.putExtra("invert", true);
        }
        startActivity(intent);
        finish();
    }

    public String toString()
    {
        return "Invert theme";
    }

    stItem()
    {
        this$0 = SampleMessageActivity.this;
        super();
    }
}
