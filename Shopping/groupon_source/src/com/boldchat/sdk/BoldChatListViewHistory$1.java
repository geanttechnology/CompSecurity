// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import com.boldchat.visitor.api.PersonType;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatListViewHistory

class val.senderAvatar
    implements Runnable
{

    final BoldChatListViewHistory this$0;
    final long val$messageID;
    final String val$messageText;
    final String val$senderAvatar;
    final String val$senderName;
    final PersonType val$senderType;
    final String val$time;

    public void run()
    {
        BoldChatListViewHistory.access$200(BoldChatListViewHistory.this).addItem(new storyMessage(BoldChatListViewHistory.this, val$messageText, val$senderType, val$messageID, val$time, val$senderName, val$senderAvatar, null));
    }

    storyAdapter()
    {
        this$0 = final_boldchatlistviewhistory;
        val$messageText = s;
        val$senderType = persontype;
        val$messageID = l;
        val$time = s1;
        val$senderName = s2;
        val$senderAvatar = String.this;
        super();
    }
}
