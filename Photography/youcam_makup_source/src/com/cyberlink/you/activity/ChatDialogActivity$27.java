// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.widget.RelativeLayout;
import com.cyberlink.you.database.Group;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class a
    implements Runnable
{

    final ChatDialogActivity a;

    public void run()
    {
        int i;
        if (ChatDialogActivity.b(a).i)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        ChatDialogActivity.P(a).setVisibility(i);
    }

    (ChatDialogActivity chatdialogactivity)
    {
        a = chatdialogactivity;
        super();
    }
}
