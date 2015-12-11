// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.richpush;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.urbanairship.richpush:
//            RichPushInbox

class this._cls0
    implements Runnable
{

    final RichPushInbox this$0;

    public void run()
    {
        java.util.List list = RichPushInbox.access$100(RichPushInbox.this);
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = (new ArrayList(RichPushInbox.access$100(RichPushInbox.this))).iterator(); iterator.hasNext(); ((stener)iterator.next()).onUpdateInbox()) { }
        break MISSING_BLOCK_LABEL_59;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    stener()
    {
        this$0 = RichPushInbox.this;
        super();
    }
}
