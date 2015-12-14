// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.util.Log;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.f;
import com.cyberlink.you.e;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class i extends Thread
{

    private boolean a;
    private Group b;

    public i(Group group)
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
        Log.d("ChatDialogActivity", "SendReceiptThread begin @@");
        Thread.currentThread().setName("Send Receipt");
        Thread.currentThread().setPriority(4);
        if (!a)
        {
            java.util.List list = e.d().c(String.valueOf(b.b));
            if (!a)
            {
                ChatDialogActivity.a(b, list);
                Log.d("ChatDialogActivity", "SendReceiptThread end @@");
                return;
            }
        }
    }
}
