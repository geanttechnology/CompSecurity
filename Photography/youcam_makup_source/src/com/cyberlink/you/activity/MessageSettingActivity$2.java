// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.content.DialogInterface;
import com.cyberlink.you.friends.Friend;

// Referenced classes of package com.cyberlink.you.activity:
//            MessageSettingActivity

class a
    implements android.content.stener
{

    final Friend a;
    final MessageSettingActivity b;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        MessageSettingActivity.a(b, a);
    }

    _cls9(MessageSettingActivity messagesettingactivity, Friend friend)
    {
        b = messagesettingactivity;
        a = friend;
        super();
    }
}
