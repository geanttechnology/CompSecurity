// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.util.Log;
import com.cyberlink.you.ChatListHandler;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.friends.e;
import com.cyberlink.you.friends.i;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class f
    implements e, i
{

    final ChatDialogActivity a;
    private com.cyberlink.you.database.MessageObj.MessageType b;
    private String c;

    public f(ChatDialogActivity chatdialogactivity, com.cyberlink.you.database.MessageObj.MessageType messagetype, String s)
    {
        a = chatdialogactivity;
        super();
        b = messagetype;
        c = s;
    }

    public void a(Group group)
    {
        if (group == null) goto _L2; else goto _L1
_L1:
        Log.d("ChatDialogActivity", (new StringBuilder()).append("[OnCreateChatroomAndSendMessageCallback] Succes create chat group=").append(group).toString());
        ChatListHandler.c(group.b);
        ChatDialogActivity.a(a, group);
        if (b != null && c != null)
        {
            ChatDialogActivity.a(a, b, c);
        }
        a.b();
_L4:
        a.b(false);
        return;
_L2:
        if (!ChatDialogActivity.T(a))
        {
            a.c();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public volatile void a(Object obj)
    {
        a((Group)obj);
    }

    public void a(String s)
    {
        a.b(false);
        if (!ChatDialogActivity.T(a))
        {
            a.c();
        }
    }
}
