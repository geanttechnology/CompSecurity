// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import java.util.TimerTask;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity, e

public class j extends TimerTask
{

    final ChatDialogActivity a;

    public j(ChatDialogActivity chatdialogactivity)
    {
        a = chatdialogactivity;
        super();
    }

    public void run()
    {
        a.runOnUiThread(new Runnable() {

            final j a;

            public void run()
            {
                if (ChatDialogActivity.a(a.a) != null)
                {
                    ChatDialogActivity.a(a.a).notifyDataSetChanged();
                }
            }

            
            {
                a = j.this;
                super();
            }
        });
    }
}
