// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.messagecenter.view;

import android.widget.FrameLayout;
import com.apptentive.android.sdk.model.Message;

// Referenced classes of package com.apptentive.android.sdk.module.messagecenter.view:
//            AvatarView, PersonalMessageView

class val.avatarFrame extends Thread
{

    final PersonalMessageView this$0;
    final FrameLayout val$avatarFrame;

    public void run()
    {
        final AvatarView avatar = new AvatarView(context, message.getSenderProfilePhoto());
        class _cls1
            implements Runnable
        {

            final PersonalMessageView._cls1 this$1;
            final AvatarView val$avatar;

            public void run()
            {
                avatarFrame.addView(avatar);
            }

            _cls1()
            {
                this$1 = PersonalMessageView._cls1.this;
                avatar = avatarview;
                super();
            }
        }

        post(new _cls1());
    }

    _cls1()
    {
        this$0 = final_personalmessageview;
        val$avatarFrame = FrameLayout.this;
        super();
    }
}
