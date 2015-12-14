// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.support.v4.widget.SwipeRefreshLayout;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class a
    implements android.support.v4.widget.efreshListener
{

    final ChatDialogActivity a;

    public void onRefresh()
    {
        ChatDialogActivity.i(a).setRefreshing(false);
    }

    freshListener(ChatDialogActivity chatdialogactivity)
    {
        a = chatdialogactivity;
        super();
    }
}
