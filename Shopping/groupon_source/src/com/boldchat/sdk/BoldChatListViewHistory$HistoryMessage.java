// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import com.boldchat.visitor.api.PersonType;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatListViewHistory

private class <init>
{

    final long messageID;
    final String messageText;
    final String senderAvatar;
    final String senderName;
    final PersonType senderType;
    final BoldChatListViewHistory this$0;
    final String time;

    private (String s, PersonType persontype, long l, String s1, String s2, 
            String s3)
    {
        this$0 = BoldChatListViewHistory.this;
        super();
        messageText = s;
        senderType = persontype;
        messageID = l;
        time = s1;
        senderName = s2;
        senderAvatar = s3;
    }

    senderAvatar(String s, PersonType persontype, long l, String s1, String s2, 
            String s3, senderAvatar senderavatar)
    {
        this(s, persontype, l, s1, s2, s3);
    }
}
