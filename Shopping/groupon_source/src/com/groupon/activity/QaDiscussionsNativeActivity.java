// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.groupon.adapter.DiscussionsAdapter;
import com.groupon.service.QaDiscussionsService;
import com.groupon.util.DialogManager;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.GrouponDialogListener;
import com.groupon.util.IntlDateFormat;
import com.groupon.view.GrouponSwipeRefreshLayout;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponListActivity

public class QaDiscussionsNativeActivity extends GrouponListActivity
    implements GrouponDialogListener
{
    private class DefaultQandARequestCallback extends com.groupon.callbacks.DefaultQandARequestCallback
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
            if (discussionsAdapter.getCount() != 0)
            {
                i = 8;
            }
            view.setVisibility(i);
        }

        public void onPostsSuccess(List list)
        {
            discussionsAdapter.clear();
            discussionsAdapter.addAll(list);
            discussionsAdapter.notifyDataSetChanged();
        }

        private DefaultQandARequestCallback()
        {
            this$0 = QaDiscussionsNativeActivity.this;
            super();
        }

    }


    String dealId;
    DialogManager dialogManager;
    private DiscussionsAdapter discussionsAdapter;
    View emptyView;
    private IntlDateFormat intlDateFormat;
    ProgressBar loadingView;
    QaDiscussionsService qaDiscussionsService;
    GrouponSwipeRefreshLayout swipeLayout;

    public QaDiscussionsNativeActivity()
    {
    }

    private void reload()
    {
        emptyView.setVisibility(8);
        int i = discussionsAdapter.getCount();
        QaDiscussionsService qadiscussionsservice = qaDiscussionsService;
        String s = dealId;
        Object obj;
        if (i > 0)
        {
            obj = null;
        } else
        {
            obj = loadingView;
        }
        qadiscussionsservice.getPosts(s, ((View) (obj)), new DefaultQandARequestCallback());
    }

    private void setupAdapter()
    {
        discussionsAdapter = new DiscussionsAdapter(getApplicationContext(), intlDateFormat);
        getListView().setAdapter(discussionsAdapter);
    }

    private void setupRefreshListener()
    {
        swipeLayout.setOnRefreshListener(new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {

            final QaDiscussionsNativeActivity this$0;

            public void onRefresh()
            {
                reload();
            }

            
            {
                this$0 = QaDiscussionsNativeActivity.this;
                super();
            }
        });
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(getString(0x7f080137));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300d2);
        setupAdapter();
        setupRefreshListener();
        reload();
    }

    public void onDialogCancel(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogItemClick(String s, DialogInterface dialoginterface, int i)
    {
    }

    public void onDialogMultiChoiceItemClick(String s, DialogInterface dialoginterface, int i, boolean flag)
    {
    }

    public void onDialogNegativeButtonClick(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
    {
        if (Strings.equalsIgnoreCase(s, "http_error_dialog"))
        {
            finish();
        }
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }


}
