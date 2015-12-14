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
    implements android.content.ener
{

    final a a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        MessageSettingActivity.e(a.a);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/you/activity/MessageSettingActivity$7

/* anonymous class */
    class MessageSettingActivity._cls7
        implements android.view.View.OnClickListener
    {

        final MessageSettingActivity a;

        public void onClick(View view)
        {
            d.a(a, r.u_leave_group_chat, r.u_you_will_no_longer_receive_message_from_this_group_again, r.u_leave, 0x1040000, new MessageSettingActivity._cls7._cls1(this), null);
        }

            
            {
                a = messagesettingactivity;
                super();
            }
    }

}
