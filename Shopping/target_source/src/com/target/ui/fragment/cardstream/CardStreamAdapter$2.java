// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream;

import com.target.ui.analytics.b.f;

// Referenced classes of package com.target.ui.fragment.cardstream:
//            CardStreamAdapter, b

class val.position
    implements Runnable
{

    final CardStreamAdapter this$0;
    final b val$cardData;
    final int val$position;

    public void run()
    {
        f.a(val$cardData.cardName, val$position).a();
    }

    ()
    {
        this$0 = final_cardstreamadapter;
        val$cardData = b1;
        val$position = I.this;
        super();
    }
}
