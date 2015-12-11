// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.messagecenter.view;

import android.widget.FrameLayout;

// Referenced classes of package com.apptentive.android.sdk.module.messagecenter.view:
//            AvatarView

class val.avatar
    implements Runnable
{

    final val.avatar this$1;
    final AvatarView val$avatar;

    public void run()
    {
        avatarFrame.addView(val$avatar);
    }

    ()
    {
        this$1 = final_;
        val$avatar = AvatarView.this;
        super();
    }
}
