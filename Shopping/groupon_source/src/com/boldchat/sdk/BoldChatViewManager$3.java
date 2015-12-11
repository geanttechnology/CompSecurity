// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import java.util.HashMap;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatViewManager

class er extends AnimatorListenerAdapter
{

    final BoldChatViewManager this$0;
    final View val$view;

    public void onAnimationEnd(Animator animator)
    {
        val$view.setVisibility(((Integer)BoldChatViewManager.access$300(BoldChatViewManager.this).get(val$view)).intValue());
        val$view.setAlpha(1.0F);
    }

    er()
    {
        this$0 = final_boldchatviewmanager;
        val$view = View.this;
        super();
    }
}
