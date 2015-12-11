// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.services;

import android.content.Intent;
import android.view.View;
import com.bitstrips.imoji.analytics.Action;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.analytics.Category;
import com.bitstrips.imoji.ui.LoginActivity;

// Referenced classes of package com.bitstrips.imoji.services:
//            FloaterService

private class <init>
    implements android.view.erClickListener
{

    final FloaterService this$0;

    public void onClick(View view)
    {
        view = FloaterService.access$400(FloaterService.this);
        if (view != null)
        {
            Intent intent = new Intent(getBaseContext(), com/bitstrips/imoji/ui/LoginActivity);
            intent.addFlags(0x10000000);
            intent.addFlags(32768);
            intent.addFlags(0x40000000);
            if (FloaterService.access$500(FloaterService.this) != null)
            {
                intent.putExtra("targetProcess", view);
            }
            analytics.sendEvent(Category.FLOATER, Action.CLICK, view);
            startActivity(intent);
        }
    }

    private ()
    {
        this$0 = FloaterService.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
