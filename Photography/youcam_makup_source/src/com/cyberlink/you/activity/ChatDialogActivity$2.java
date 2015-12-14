// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.view.View;
import android.widget.ListView;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity, b

class a
    implements android.view.stener
{

    final ChatDialogActivity a;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        if (b.a(ChatDialogActivity.l(a)) && l - j < l1 - j1 && ChatDialogActivity.c(a).getLastVisiblePosition() != ChatDialogActivity.c(a).getCount() - 1)
        {
            ChatDialogActivity.m(a);
        }
    }

    (ChatDialogActivity chatdialogactivity)
    {
        a = chatdialogactivity;
        super();
    }
}
