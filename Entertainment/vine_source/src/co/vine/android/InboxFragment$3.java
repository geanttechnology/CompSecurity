// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.widget.ListView;
import co.vine.android.util.CrashUtil;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android:
//            InboxFragment, MessageBoxAdapter

class this._cls0
    implements Runnable
{

    final InboxFragment this$0;

    public void run()
    {
        if (InboxFragment.access$100(InboxFragment.this) != InboxFragment.access$200(InboxFragment.this)) goto _L2; else goto _L1
_L1:
        boolean flag;
        int i;
        i = mListView.getLastVisiblePosition();
        flag = true;
        if (i != mListView.getCount() - 1) goto _L4; else goto _L3
_L3:
        int j;
        i = mListView.getChildAt(i).getBottom();
        j = mListView.getHeight();
        if (i > j) goto _L4; else goto _L5
_L5:
        flag = true;
_L6:
        boolean flag1 = false;
        boolean flag2 = mInboxAdapter.isEmpty();
        flag1 = flag2;
_L7:
        if (InboxFragment.access$1300(InboxFragment.this) || isFetched(1) && flag1 || isFetched(3) && flag)
        {
            addEntriesToAddressAdapter();
        }
_L2:
        return;
_L4:
        flag = false;
          goto _L6
        Exception exception;
        exception;
        SLog.e("Cannot get listview state.");
          goto _L6
        exception;
        CrashUtil.logException(exception);
          goto _L7
    }

    ()
    {
        this$0 = InboxFragment.this;
        super();
    }
}
