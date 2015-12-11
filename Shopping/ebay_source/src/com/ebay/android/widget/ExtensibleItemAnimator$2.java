// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.android.widget:
//            ExtensibleItemAnimator

class val.changes
    implements Runnable
{

    final ExtensibleItemAnimator this$0;
    final ArrayList val$changes;

    public void run()
    {
        angeInfo angeinfo;
        for (Iterator iterator = val$changes.iterator(); iterator.hasNext(); ExtensibleItemAnimator.access$200(ExtensibleItemAnimator.this, angeinfo))
        {
            angeinfo = (angeInfo)iterator.next();
        }

        val$changes.clear();
        ExtensibleItemAnimator.access$300(ExtensibleItemAnimator.this).remove(val$changes);
    }

    angeInfo()
    {
        this$0 = final_extensibleitemanimator;
        val$changes = ArrayList.this;
        super();
    }
}
