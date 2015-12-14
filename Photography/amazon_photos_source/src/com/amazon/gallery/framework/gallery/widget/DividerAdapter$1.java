// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import java.util.Collections;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            DividerAdapter

class val.timelineEntries
    implements Runnable
{

    final DividerAdapter this$0;
    final List val$timelineEntries;

    public void run()
    {
        DividerAdapter divideradapter = DividerAdapter.this;
        divideradapter;
        JVM INSTR monitorenter ;
        if (val$timelineEntries != null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        DividerAdapter.this.timelineEntries = Collections.emptyList();
_L2:
        highlightedDividerIndex = -1;
        return;
        DividerAdapter.this.timelineEntries = val$timelineEntries;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        divideradapter;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ()
    {
        this$0 = final_divideradapter;
        val$timelineEntries = List.this;
        super();
    }
}
