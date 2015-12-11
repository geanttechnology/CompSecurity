// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.adapter.DiscussionsAdapter;
import com.groupon.callbacks.DefaultQandARequestCallback;
import com.groupon.util.DialogManager;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.view.GrouponSwipeRefreshLayout;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            QaDiscussionsNativeActivity

private class <init> extends DefaultQandARequestCallback
{

    final QaDiscussionsNativeActivity this$0;

    public void onException(Exception exception)
    {
        exception = dialogManager.getDialogFragment(Integer.valueOf(0x7f080165));
        GrouponDialogFragment.show(getFragmentManager(), exception, "http_error_dialog");
    }

    public void onFinally()
    {
        int i = 0;
        swipeLayout.setRefreshing(false);
        View view = emptyView;
        if (QaDiscussionsNativeActivity.access$200(QaDiscussionsNativeActivity.this).getCount() != 0)
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    public void onPostsSuccess(List list)
    {
        QaDiscussionsNativeActivity.access$200(QaDiscussionsNativeActivity.this).clear();
        QaDiscussionsNativeActivity.access$200(QaDiscussionsNativeActivity.this).addAll(list);
        QaDiscussionsNativeActivity.access$200(QaDiscussionsNativeActivity.this).notifyDataSetChanged();
    }

    private ()
    {
        this$0 = QaDiscussionsNativeActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
