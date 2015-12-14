// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import org.jivesoftware.smack.util.p;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class a
    implements Runnable
{

    final int a;
    final ChatDialogActivity b;

    public void run()
    {
        Thread.currentThread().setName("Auto send message");
        String s = p.a(6);
        int i = 1;
        while (i <= a) 
        {
            b.runOnUiThread(new Runnable(s, i) {

                final String a;
                final int b;
                final ChatDialogActivity._cls42 c;

                public void run()
                {
                    c.b.a(com.cyberlink.you.database.MessageObj.MessageType.a, (new StringBuilder()).append("Auto sent message (").append(a).append(") #").append(b).toString());
                }

            
            {
                c = ChatDialogActivity._cls42.this;
                a = s;
                b = i;
                super();
            }
            });
            try
            {
                Thread.sleep(ChatDialogActivity.j(b));
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
            i++;
        }
    }

    _cls1.b(ChatDialogActivity chatdialogactivity, int i)
    {
        b = chatdialogactivity;
        a = i;
        super();
    }
}
