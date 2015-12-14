// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import com.cyberlink.you.c.e;
import com.cyberlink.you.c.j;
import java.util.List;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class a
    implements j
{

    final ChatDialogActivity a;

    public void a()
    {
        boolean flag;
        if (!ChatDialogActivity.k(a).d().isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.a(flag);
    }

    (ChatDialogActivity chatdialogactivity)
    {
        a = chatdialogactivity;
        super();
    }
}
