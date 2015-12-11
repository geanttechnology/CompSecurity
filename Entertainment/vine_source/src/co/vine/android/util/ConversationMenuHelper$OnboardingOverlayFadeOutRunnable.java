// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

// Referenced classes of package co.vine.android.util:
//            ConversationMenuHelper

private class <init>
    implements Runnable
{

    private View mView;
    final ConversationMenuHelper this$0;

    public void run()
    {
        Animation animation = AnimationUtils.loadAnimation(ConversationMenuHelper.access$300(ConversationMenuHelper.this), 0x7f04000f);
        animation.setAnimationListener(ConversationMenuHelper.access$400(ConversationMenuHelper.this));
        if (mView != null && mView.getVisibility() == 0)
        {
            mView.startAnimation(animation);
        }
    }

    public void setView(View view)
    {
        mView = view;
    }

    private ()
    {
        this$0 = ConversationMenuHelper.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
