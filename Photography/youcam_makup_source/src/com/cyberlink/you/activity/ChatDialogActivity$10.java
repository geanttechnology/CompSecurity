// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.app.Activity;
import com.cyberlink.you.chat.o;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class a
    implements o
{

    final ChatDialogActivity a;

    public void a(boolean flag)
    {
        ChatDialogActivity.g(a).runOnUiThread(new Runnable(flag) {

            final boolean a;
            final ChatDialogActivity._cls10 b;

            public void run()
            {
                ChatDialogActivity.u(b.a);
                if (a)
                {
                    ChatDialogActivity.v(b.a);
                    return;
                } else
                {
                    b.a.b(false);
                    return;
                }
            }

            
            {
                b = ChatDialogActivity._cls10.this;
                a = flag;
                super();
            }
        });
    }

    _cls1.a(ChatDialogActivity chatdialogactivity)
    {
        a = chatdialogactivity;
        super();
    }
}
