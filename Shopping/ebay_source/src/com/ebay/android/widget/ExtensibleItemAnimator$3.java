// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.android.widget:
//            ExtensibleItemAnimator

class val.additions
    implements Runnable
{

    final ExtensibleItemAnimator this$0;
    final ArrayList val$additions;

    public void run()
    {
        android.support.v7.widget.l.additions additions1;
        for (Iterator iterator = val$additions.iterator(); iterator.hasNext(); ExtensibleItemAnimator.access$400(ExtensibleItemAnimator.this, additions1))
        {
            additions1 = (android.support.v7.widget.is._cls0)iterator.next();
        }

        val$additions.clear();
        ExtensibleItemAnimator.access$500(ExtensibleItemAnimator.this).remove(val$additions);
    }

    ()
    {
        this$0 = final_extensibleitemanimator;
        val$additions = ArrayList.this;
        super();
    }
}
