// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import com.boldchat.visitor.api.ChatAvailabilityListener;
import com.boldchat.visitor.api.UnavailableReason;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession

private class mAvailabilityListener
    implements ChatAvailabilityListener
{

    ChatAvailabilityListener mAvailabilityListener;
    final BoldChatSession this$0;

    public void onChatAvailabilityFailed(final int failType, final String message)
    {
        if (mAvailabilityListener != null)
        {
            BoldChatSession.access$2400(BoldChatSession.this, new Runnable() {

                final BoldChatSession.ChatAvailabilityWrapper this$1;
                final int val$failType;
                final String val$message;

                public void run()
                {
                    mAvailabilityListener.onChatAvailabilityFailed(failType, message);
                }

            
            {
                this$1 = BoldChatSession.ChatAvailabilityWrapper.this;
                failType = i;
                message = s;
                super();
            }
            });
        }
    }

    public void onChatAvailable()
    {
        if (mAvailabilityListener != null)
        {
            BoldChatSession.access$2400(BoldChatSession.this, new Runnable() {

                final BoldChatSession.ChatAvailabilityWrapper this$1;

                public void run()
                {
                    mAvailabilityListener.onChatAvailable();
                }

            
            {
                this$1 = BoldChatSession.ChatAvailabilityWrapper.this;
                super();
            }
            });
        }
    }

    public void onChatUnavailable(final UnavailableReason unavailableReason)
    {
        if (mAvailabilityListener != null)
        {
            BoldChatSession.access$2400(BoldChatSession.this, new Runnable() {

                final BoldChatSession.ChatAvailabilityWrapper this$1;
                final UnavailableReason val$unavailableReason;

                public void run()
                {
                    mAvailabilityListener.onChatUnavailable(unavailableReason);
                }

            
            {
                this$1 = BoldChatSession.ChatAvailabilityWrapper.this;
                unavailableReason = unavailablereason;
                super();
            }
            });
        }
    }

    public _cls3.val.message(ChatAvailabilityListener chatavailabilitylistener)
    {
        this$0 = BoldChatSession.this;
        super();
        mAvailabilityListener = chatavailabilitylistener;
    }
}
