// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Handler;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;

// Referenced classes of package co.vine.android:
//            InboxFragment

public class targetAdapter
    implements android.view.er, Runnable
{

    public final BaseAdapter targetAdapter;
    final InboxFragment this$0;

    public void onClick(View view)
    {
        if (InboxFragment.access$100(InboxFragment.this) != targetAdapter && !InboxFragment.access$700(InboxFragment.this))
        {
            InboxFragment.access$702(InboxFragment.this, true);
            mHandler.removeCallbacks(this);
            mHandler.postDelayed(this, 200L);
        }
    }

    public void run()
    {
        InboxFragment.access$102(InboxFragment.this, targetAdapter);
        mListView.setAdapter(InboxFragment.access$100(InboxFragment.this));
        InboxFragment.access$702(InboxFragment.this, false);
        InboxFragment.access$800(InboxFragment.this);
    }

    public (BaseAdapter baseadapter)
    {
        this$0 = InboxFragment.this;
        super();
        targetAdapter = baseadapter;
    }
}
