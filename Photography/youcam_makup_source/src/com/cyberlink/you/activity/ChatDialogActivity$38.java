// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.cyberlink.you.d.d;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class a
    implements android.widget.kListener
{

    final ChatDialogActivity a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (!ChatDialogActivity.M(a).equals(tDialogMode.a))
        {
            ((d)view.getTag()).s.setSelected(ChatDialogActivity.c(a).isItemChecked(i));
            ChatDialogActivity.R(a);
        }
    }

    tDialogMode(ChatDialogActivity chatdialogactivity)
    {
        a = chatdialogactivity;
        super();
    }
}
