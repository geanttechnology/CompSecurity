// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import com.cyberlink.you.chat.UnreadCountManager;
import com.cyberlink.you.database.Group;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class a
    implements com.cyberlink.you.chat.nreadCountListner
{

    final ChatDialogActivity a;

    public void a(com.cyberlink.you.chat.nreadCountListner.Type type)
    {
        if (ChatDialogActivity.b(a) != null && (type.equals(com.cyberlink.you.chat.nreadCountListner.Type.a) || type.equals(com.cyberlink.you.chat.nreadCountListner.Type.c)))
        {
            UnreadCountManager.b().b(ChatDialogActivity.b(a).c, false);
            a.d();
        }
    }

    dCountListner.Type(ChatDialogActivity chatdialogactivity)
    {
        a = chatdialogactivity;
        super();
    }
}
