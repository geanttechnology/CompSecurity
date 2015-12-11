// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.widget.ListView;

// Referenced classes of package co.vine.android:
//            CommentsFragment

class val.listView
    implements Runnable
{

    final val.listView this$1;
    final ListView val$listView;

    public void run()
    {
        val$listView.setSelection(val$listView.getCount() - 1);
    }

    ()
    {
        this$1 = final_;
        val$listView = ListView.this;
        super();
    }
}
