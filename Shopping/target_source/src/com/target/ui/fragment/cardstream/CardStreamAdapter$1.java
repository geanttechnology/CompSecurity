// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.cardstream:
//            CardStreamAdapter, b

class val.newCardData
    implements Runnable
{

    final CardStreamAdapter this$0;
    final List val$newCardData;

    public void run()
    {
        for (Iterator iterator = val$newCardData.iterator(); iterator.hasNext(); d(CardStreamAdapter.a(CardStreamAdapter.this).size() - 1))
        {
            b b1 = (b)iterator.next();
            CardStreamAdapter.a(CardStreamAdapter.this).add(b1);
        }

    }

    ()
    {
        this$0 = final_cardstreamadapter;
        val$newCardData = List.this;
        super();
    }
}
