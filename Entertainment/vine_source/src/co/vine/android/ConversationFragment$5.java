// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.ViewGroup;

// Referenced classes of package co.vine.android:
//            ConversationFragment

class val.container
    implements Runnable
{

    final ConversationFragment this$0;
    final ViewGroup val$container;

    public void run()
    {
        val$container.setVisibility(8);
    }

    ()
    {
        this$0 = final_conversationfragment;
        val$container = ViewGroup.this;
        super();
    }
}
