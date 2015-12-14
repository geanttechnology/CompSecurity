// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.app.ProgressDialog;
import com.cyberlink.you.friends.e;
import com.cyberlink.you.friends.i;

// Referenced classes of package com.cyberlink.you.activity:
//            MessageSettingActivity

class l
    implements e, i
{

    ProgressDialog a;
    final MessageSettingActivity b;

    public l(MessageSettingActivity messagesettingactivity, ProgressDialog progressdialog)
    {
        b = messagesettingactivity;
        super();
        a = progressdialog;
    }

    public void a(Object obj)
    {
        if (a != null)
        {
            a.dismiss();
        }
        MessageSettingActivity.g(b);
    }

    public void a(String s)
    {
        if (a != null)
        {
            a.dismiss();
        }
    }
}
