// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.view.View;
import com.cyberlink.you.c.e;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class a
    implements android.view.ener
{

    final ChatDialogActivity a;

    public void onFocusChange(View view, boolean flag)
    {
        if (ChatDialogActivity.k(a) != null && flag)
        {
            ChatDialogActivity.k(a).b();
            view = ChatDialogActivity.k(a).d();
            ChatDialogActivity.a(a, view);
        }
    }

    (ChatDialogActivity chatdialogactivity)
    {
        a = chatdialogactivity;
        super();
    }
}
