// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.f;
import com.cyberlink.you.e;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class h extends Thread
{

    private boolean a;
    private Group b;

    public h(Group group)
    {
        a = false;
        b = group;
    }

    public void a()
    {
        a = true;
    }

    public void run()
    {
        Thread.currentThread().setName("sendReceivedReceipt4UnreadMessage");
        Thread.currentThread().setPriority(4);
        java.util.List list = e.d().b(String.valueOf(b.b), String.valueOf(b.k));
        if (a)
        {
            return;
        } else
        {
            ChatDialogActivity.a(b, list);
            return;
        }
    }
}
