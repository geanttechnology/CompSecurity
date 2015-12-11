// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.widget.ListView;

// Referenced classes of package co.vine.android:
//            ConversationFragment

class val.count
    implements Runnable
{

    final ConversationFragment this$0;
    final int val$count;
    final ListView val$listView;
    final boolean val$smooth;

    public void run()
    {
        if (val$smooth)
        {
            val$listView.smoothScrollToPosition(val$count - 1);
            return;
        } else
        {
            val$listView.setSelectionFromTop(val$count - 1, 0);
            return;
        }
    }

    ()
    {
        this$0 = final_conversationfragment;
        val$smooth = flag;
        val$listView = listview;
        val$count = I.this;
        super();
    }
}
