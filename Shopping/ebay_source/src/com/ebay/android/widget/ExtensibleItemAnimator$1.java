// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.android.widget:
//            ExtensibleItemAnimator

class val.moves
    implements Runnable
{

    final ExtensibleItemAnimator this$0;
    final ArrayList val$moves;

    public void run()
    {
        veInfo veinfo;
        for (Iterator iterator = val$moves.iterator(); iterator.hasNext(); ExtensibleItemAnimator.access$000(ExtensibleItemAnimator.this, veinfo.holder, veinfo.fromX, veinfo.fromY, veinfo.toX, veinfo.toY))
        {
            veinfo = (veInfo)iterator.next();
        }

        val$moves.clear();
        ExtensibleItemAnimator.access$100(ExtensibleItemAnimator.this).remove(val$moves);
    }

    veInfo()
    {
        this$0 = final_extensibleitemanimator;
        val$moves = ArrayList.this;
        super();
    }
}
