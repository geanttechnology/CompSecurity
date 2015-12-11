// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.support.v4.app.FragmentManager;

// Referenced classes of package co.vine.android:
//            ConversationActivity, ConversationFragment

class val.userId
    implements Runnable
{

    final val.userId this$1;
    final boolean val$show;
    final long val$userId;

    public void run()
    {
        android.support.v4.app.Fragment fragment = getSupportFragmentManager().findFragmentByTag("conversationFragment");
        if (fragment instanceof ConversationFragment)
        {
            ((ConversationFragment)fragment).showTypingIndicator(val$show, val$userId);
        }
    }

    ()
    {
        this$1 = final_;
        val$show = flag;
        val$userId = J.this;
        super();
    }
}
