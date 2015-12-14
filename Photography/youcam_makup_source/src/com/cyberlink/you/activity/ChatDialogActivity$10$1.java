// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.app.Activity;
import com.cyberlink.you.chat.o;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class a
    implements Runnable
{

    final boolean a;
    final b b;

    public void run()
    {
        ChatDialogActivity.u(b.b);
        if (a)
        {
            ChatDialogActivity.v(b.b);
            return;
        } else
        {
            b.b.b(false);
            return;
        }
    }

    ( , boolean flag)
    {
        b = ;
        a = flag;
        super();
    }

    // Unreferenced inner class com/cyberlink/you/activity/ChatDialogActivity$10

/* anonymous class */
    class ChatDialogActivity._cls10
        implements o
    {

        final ChatDialogActivity a;

        public void a(boolean flag)
        {
            ChatDialogActivity.g(a).runOnUiThread(new ChatDialogActivity._cls10._cls1(this, flag));
        }

            
            {
                a = chatdialogactivity;
                super();
            }
    }

}
