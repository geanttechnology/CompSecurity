// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.chat;

import android.support.v7.ht;
import android.widget.ListView;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.chat:
//            MessagesActivity

class a
    implements Runnable
{

    final MessagesActivity a;

    public void run()
    {
        if (a.listView != null && MessagesActivity.f(a) != null && MessagesActivity.f(a).getCount() > 0)
        {
            a.listView.smoothScrollToPosition(MessagesActivity.f(a).getCount() - 1);
        }
    }

    (MessagesActivity messagesactivity)
    {
        a = messagesactivity;
        super();
    }
}
