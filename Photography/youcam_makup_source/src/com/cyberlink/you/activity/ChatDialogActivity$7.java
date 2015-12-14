// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import com.cyberlink.you.database.MessageObj;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class a
    implements Runnable
{

    final MessageObj a;
    final ChatDialogActivity b;

    public void run()
    {
        b.a(com.cyberlink.you.database.e.a, (new StringBuilder()).append("Echo ").append(a.g()).toString());
    }

    e(ChatDialogActivity chatdialogactivity, MessageObj messageobj)
    {
        b = chatdialogactivity;
        a = messageobj;
        super();
    }
}
