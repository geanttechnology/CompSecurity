// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.app.ProgressDialog;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.friends.e;
import com.cyberlink.you.friends.i;

// Referenced classes of package com.cyberlink.you.activity:
//            MessageSettingActivity

class k
    implements e, i
{

    ProgressDialog a;
    Friend b;
    final MessageSettingActivity c;

    public k(MessageSettingActivity messagesettingactivity, ProgressDialog progressdialog, Friend friend)
    {
        c = messagesettingactivity;
        super();
        a = progressdialog;
        b = friend;
    }

    public void a(Object obj)
    {
        if (a != null)
        {
            a.dismiss();
        }
        MessageSettingActivity.b(c, b);
    }

    public void a(String s)
    {
        if (a != null)
        {
            a.dismiss();
        }
    }
}
