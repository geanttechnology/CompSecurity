// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.widget.ListView;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android:
//            InboxFragment

class this._cls0
    implements Runnable
{

    final InboxFragment this$0;

    public void run()
    {
        if (InboxFragment.access$100(InboxFragment.this) != InboxFragment.access$200(InboxFragment.this)) goto _L2; else goto _L1
_L1:
        if (InboxFragment.access$300(InboxFragment.this) != 0) goto _L4; else goto _L3
_L3:
        if (!InboxFragment.access$400(InboxFragment.this))
        {
            SLog.d("Header change: Add.");
            InboxFragment.access$402(InboxFragment.this, true);
            mListView.addHeaderView(InboxFragment.access$500(InboxFragment.this));
        }
_L6:
        return;
_L4:
        if (!InboxFragment.access$400(InboxFragment.this)) goto _L6; else goto _L5
_L5:
        SLog.d("Header change: Remove.");
        InboxFragment.access$402(InboxFragment.this, false);
        mListView.removeHeaderView(InboxFragment.access$500(InboxFragment.this));
        return;
_L2:
        if (InboxFragment.access$600(InboxFragment.this) != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (InboxFragment.access$400(InboxFragment.this)) goto _L6; else goto _L7
_L7:
        SLog.d("Header change: Add.");
        InboxFragment.access$402(InboxFragment.this, true);
        mListView.addHeaderView(InboxFragment.access$500(InboxFragment.this));
        return;
        if (!InboxFragment.access$400(InboxFragment.this)) goto _L6; else goto _L8
_L8:
        SLog.d("Header change: Remove.");
        InboxFragment.access$402(InboxFragment.this, false);
        mListView.removeHeaderView(InboxFragment.access$500(InboxFragment.this));
        return;
    }

    ()
    {
        this$0 = InboxFragment.this;
        super();
    }
}
