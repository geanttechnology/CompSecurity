// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import org.jivesoftware.smack.util.p;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class b
    implements Runnable
{

    final String a;
    final int b;
    final b c;

    public void run()
    {
        c.c.a(com.cyberlink.you.database., (new StringBuilder()).append("Auto sent message (").append(a).append(") #").append(b).toString());
    }

    ( , String s, int i)
    {
        c = ;
        a = s;
        b = i;
        super();
    }

    // Unreferenced inner class com/cyberlink/you/activity/ChatDialogActivity$42

/* anonymous class */
    class ChatDialogActivity._cls42
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
                b.runOnUiThread(new ChatDialogActivity._cls42._cls1(this, s, i));
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

            
            {
                b = chatdialogactivity;
                a = i;
                super();
            }
    }

}
