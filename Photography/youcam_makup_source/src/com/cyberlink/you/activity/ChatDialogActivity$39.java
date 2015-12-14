// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.view.View;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class a
    implements Runnable
{

    final boolean a;
    final ChatDialogActivity b;

    public void run()
    {
        if (ChatDialogActivity.S(b) != null)
        {
            View view = ChatDialogActivity.S(b);
            int i;
            if (a)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    (ChatDialogActivity chatdialogactivity, boolean flag)
    {
        b = chatdialogactivity;
        a = flag;
        super();
    }
}
