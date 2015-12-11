// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.widget.RelativeLayout;
import android.widget.TextView;
import com.boldchat.visitor.api.ChatAvailabilityListener;
import com.boldchat.visitor.api.UnavailableReason;

// Referenced classes of package com.groupon.view:
//            LiveChatView

class this._cls0
    implements ChatAvailabilityListener
{

    final LiveChatView this$0;

    public void onChatAvailabilityFailed(int i, String s)
    {
        setVisibility(8);
    }

    public void onChatAvailable()
    {
        LiveChatView.access$100(LiveChatView.this).setVisibility(0);
        LiveChatView.access$200(LiveChatView.this).setVisibility(8);
        LiveChatView.access$300(LiveChatView.this).setVisibility(8);
        setVisibility(0);
        LiveChatView.access$500(LiveChatView.this).setOnClickListener(LiveChatView.access$400(LiveChatView.this));
    }

    public void onChatUnavailable(UnavailableReason unavailablereason)
    {
        setVisibility(8);
    }

    ableReason()
    {
        this$0 = LiveChatView.this;
        super();
    }
}
