// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.view.View;
import com.groupon.util.ViewUtils;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.activity:
//            Gifting, IntentFactory

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
        view = ((IntentFactory)Gifting.access$1300(Gifting.this).get()).newGiftingThemeSelectionIntent();
        if (next != null)
        {
            view.putExtra("next", next);
        }
        view.putExtra("giftingRecord", giftingRecord);
        startActivityForResult(view, 10153);
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
