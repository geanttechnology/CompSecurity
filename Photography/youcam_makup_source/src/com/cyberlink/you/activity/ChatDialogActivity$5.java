// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import com.cyberlink.you.chat.b;
import com.cyberlink.you.chat.w;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class a
    implements w
{

    final ChatDialogActivity a;

    public String a(b b1)
    {
        if (b1.a())
        {
            return ChatDialogActivity.a(a, b1);
        }
        if (b1.g() == com.cyberlink.you.database.e.h)
        {
            return com.cyberlink.you.activity.ChatDialogActivity.b(a, b1);
        } else
        {
            return ChatDialogActivity.c(a, b1);
        }
    }

    public boolean a()
    {
        return false;
    }

    e(ChatDialogActivity chatdialogactivity)
    {
        a = chatdialogactivity;
        super();
    }
}
