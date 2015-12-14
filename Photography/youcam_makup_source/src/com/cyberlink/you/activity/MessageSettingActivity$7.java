// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.content.DialogInterface;
import android.view.View;
import com.cyberlink.you.r;
import com.cyberlink.you.utility.d;

// Referenced classes of package com.cyberlink.you.activity:
//            MessageSettingActivity

class a
    implements android.view.ingActivity._cls7
{

    final MessageSettingActivity a;

    public void onClick(View view)
    {
        d.a(a, r.u_leave_group_chat, r.u_you_will_no_longer_receive_message_from_this_group_again, r.u_leave, 0x1040000, new android.content.DialogInterface.OnClickListener() {

            final MessageSettingActivity._cls7 a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                MessageSettingActivity.e(a.a);
            }

            
            {
                a = MessageSettingActivity._cls7.this;
                super();
            }
        }, null);
    }

    _cls1.a(MessageSettingActivity messagesettingactivity)
    {
        a = messagesettingactivity;
        super();
    }
}
