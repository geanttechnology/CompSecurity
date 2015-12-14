// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.view.View;
import android.widget.ListView;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity, e

class b
    implements Runnable
{

    final boolean a;
    final View b;
    final ChatDialogActivity c;

    public void run()
    {
        if (ChatDialogActivity.a(c) != null && !ChatDialogActivity.a(c).isEmpty())
        {
            if (a)
            {
                ChatDialogActivity.c(c).requestFocusFromTouch();
            }
            ChatDialogActivity.c(c).setSelection(ChatDialogActivity.a(c).getCount() - 1);
            if (a && b != null)
            {
                b.requestFocusFromTouch();
            }
        }
    }

    (ChatDialogActivity chatdialogactivity, boolean flag, View view)
    {
        c = chatdialogactivity;
        a = flag;
        b = view;
        super();
    }
}
