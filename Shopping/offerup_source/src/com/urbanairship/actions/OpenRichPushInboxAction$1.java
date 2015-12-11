// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions;

import com.urbanairship.UAirship;
import com.urbanairship.richpush.RichPushMessage;

// Referenced classes of package com.urbanairship.actions:
//            OpenRichPushInboxAction

class val.message
    implements Runnable
{

    final OpenRichPushInboxAction this$0;
    final RichPushMessage val$message;

    public void run()
    {
        if (val$message != null)
        {
            OpenRichPushInboxAction.access$000(OpenRichPushInboxAction.this, UAirship.getApplicationContext(), val$message);
            return;
        } else
        {
            OpenRichPushInboxAction.access$100(OpenRichPushInboxAction.this, UAirship.getApplicationContext());
            return;
        }
    }

    ()
    {
        this$0 = final_openrichpushinboxaction;
        val$message = RichPushMessage.this;
        super();
    }
}
