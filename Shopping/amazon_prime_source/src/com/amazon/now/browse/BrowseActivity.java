// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.browse;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.amazon.now.AmazonActivity;
import com.amazon.now.ChromeStyle;
import com.amazon.now.location.Location;
import com.amazon.now.platform.AndroidPlatform;
import com.amazon.retailsearch.android.api.log.CategoryBrowseLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.fastBrowse.RefinementsLoader;
import com.amazon.searchapp.retailsearch.model.Department;
import com.amazon.searchapp.retailsearch.model.Refinements;
import com.amazon.searchapp.retailsearch.model.SearchResult;

// Referenced classes of package com.amazon.now.browse:
//            BrowseListAdapter, BrowseErrorView

public class BrowseActivity extends AmazonActivity
{
    static interface BrowseRetry
    {

        public abstract void retry();
    }

    private class ResultListener
        implements com.amazon.retailsearch.android.fastBrowse.RefinementsLoader.RefinementResultListener
    {

        private final Context mContext;
        final BrowseActivity this$0;

        public void onError(Exception exception)
        {
            exception = new BrowseErrorView(mContext, exception, new BrowseRetry() {

                final ResultListener this$1;

                public void retry()
                {
                    loadRefinements(mContext);
                }

            
            {
                this$1 = ResultListener.this;
                super();
            }
            });
            AndroidPlatform.getInstance().invokeLater(exception. new Runnable() {

                final ResultListener this$1;
                final BrowseErrorView val$errorView;

                public void run()
                {
                    setRootView(errorView, new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.NORMAL));
                }

            
            {
                this$1 = final_resultlistener;
                errorView = BrowseErrorView.this;
                super();
            }
            });
        }

        public void onResult(SearchResult searchresult)
        {
            if (searchresult == null || searchresult.getRefinements() == null || searchresult.getRefinements().getDepartments() == null)
            {
                onError(null);
                return;
            } else
            {
                BrowseActivity.sDepartments = searchresult.getRefinements().getDepartments();
                BrowseActivity.sLastZipCode = Location.getZipcode();
                searchresult = new BrowseListAdapter(mContext, BrowseActivity.sDepartments);
                AndroidPlatform.getInstance().invokeLater(searchresult. new Runnable() {

                    final ResultListener this$1;
                    final BrowseListAdapter val$adapter;

                    public void run()
                    {
                        departmentList.setAdapter(adapter);
                        setRootView(departmentList, new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.NORMAL));
                    }

            
            {
                this$1 = final_resultlistener;
                adapter = BrowseListAdapter.this;
                super();
            }
                });
                mBrowseLogger.recordPageLoaded();
                return;
            }
        }


        public ResultListener(Context context)
        {
            this$0 = BrowseActivity.this;
            super();
            mContext = context;
        }
    }


    private static Department sDepartments;
    private static String sLastZipCode;
    private ListView departmentList;
    private final CategoryBrowseLogger mBrowseLogger = RetailSearchLoggingProvider.getInstance().getCategoryBrowseLogger();
    private LinearLayout progressContainer;

    public BrowseActivity()
    {
    }

    private void loadRefinements(final Context context)
    {
        setRootView(progressContainer, new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.NORMAL));
        (new Thread(new Runnable() {

            final BrowseActivity this$0;
            final Context val$context;

            public void run()
            {
                (new RefinementsLoader(new ResultListener(context), null)).getRefinements();
            }

            
            {
                this$0 = BrowseActivity.this;
                context = context1;
                super();
            }
        })).start();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        departmentList = new ListView(this);
        progressContainer = (LinearLayout)getLayoutInflater().inflate(0x7f030058, departmentList, false);
        bundle = (TextView)getLayoutInflater().inflate(0x7f030003, departmentList, false);
        departmentList.addHeaderView(bundle, null, false);
        departmentList.setHeaderDividersEnabled(false);
        departmentList.setOverScrollMode(2);
        if (sLastZipCode != null && sLastZipCode.equals(Location.getZipcode()) && sDepartments != null)
        {
            departmentList.setAdapter(new BrowseListAdapter(this, sDepartments));
            setRootView(departmentList, new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.NORMAL));
            return;
        } else
        {
            loadRefinements(this);
            return;
        }
    }



/*
    static Department access$002(Department department)
    {
        sDepartments = department;
        return department;
    }

*/


/*
    static String access$102(String s)
    {
        sLastZipCode = s;
        return s;
    }

*/



}
