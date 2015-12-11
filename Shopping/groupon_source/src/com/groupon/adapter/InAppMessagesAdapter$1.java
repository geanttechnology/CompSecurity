// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.view.View;
import com.groupon.db.models.InAppMessage;

// Referenced classes of package com.groupon.adapter:
//            InAppMessagesAdapter

class val.position
    implements android.view.pter._cls1
{

    final InAppMessagesAdapter this$0;
    final InAppMessage val$message;
    final int val$position;

    public void onClick(View view)
    {
        if (InAppMessagesAdapter.access$000(InAppMessagesAdapter.this) != null)
        {
            InAppMessagesAdapter.access$000(InAppMessagesAdapter.this).onMessageClicked(val$message, val$position);
        }
    }

    eClickedListener()
    {
        this$0 = final_inappmessagesadapter;
        val$message = inappmessage;
        val$position = I.this;
        super();
    }
}
