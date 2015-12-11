// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.browse;

import android.content.Context;
import android.widget.ListView;
import com.amazon.now.ChromeStyle;
import com.amazon.now.location.Location;
import com.amazon.now.platform.AndroidPlatform;
import com.amazon.retailsearch.android.api.log.CategoryBrowseLogger;
import com.amazon.searchapp.retailsearch.model.Refinements;
import com.amazon.searchapp.retailsearch.model.SearchResult;

// Referenced classes of package com.amazon.now.browse:
//            BrowseActivity, BrowseErrorView, BrowseListAdapter

private class mContext
    implements com.amazon.retailsearch.android.fastBrowse.sultListener
{

    private final Context mContext;
    final BrowseActivity this$0;

    public void onError(final Exception errorView)
    {
        errorView = new BrowseErrorView(mContext, errorView, new BrowseActivity.BrowseRetry() {

            final BrowseActivity.ResultListener this$1;

            public void retry()
            {
                BrowseActivity.access$500(this$0, mContext);
            }

            
            {
                this$1 = BrowseActivity.ResultListener.this;
                super();
            }
        });
        AndroidPlatform.getInstance().invokeLater(new Runnable() {

            final BrowseActivity.ResultListener this$1;
            final BrowseErrorView val$errorView;

            public void run()
            {
                setRootView(errorView, new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.NORMAL));
            }

            
            {
                this$1 = BrowseActivity.ResultListener.this;
                errorView = browseerrorview;
                super();
            }
        });
    }

    public void onResult(final SearchResult adapter)
    {
        if (adapter == null || adapter.getRefinements() == null || adapter.getRefinements().getDepartments() == null)
        {
            onError(null);
            return;
        } else
        {
            com.amazon.searchapp.retailsearch.model.Department _tmp = BrowseActivity.access$002(adapter.getRefinements().getDepartments());
            String _tmp1 = BrowseActivity.access$102(Location.getZipcode());
            adapter = new BrowseListAdapter(mContext, BrowseActivity.access$000());
            AndroidPlatform.getInstance().invokeLater(new Runnable() {

                final BrowseActivity.ResultListener this$1;
                final BrowseListAdapter val$adapter;

                public void run()
                {
                    BrowseActivity.access$200(this$0).setAdapter(adapter);
                    setRootView(BrowseActivity.access$200(this$0), new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.NORMAL));
                }

            
            {
                this$1 = BrowseActivity.ResultListener.this;
                adapter = browselistadapter;
                super();
            }
            });
            BrowseActivity.access$300(BrowseActivity.this).recordPageLoaded();
            return;
        }
    }


    public _cls3.val.errorView(Context context)
    {
        this$0 = BrowseActivity.this;
        super();
        mContext = context;
    }
}
