// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import co.vine.android.client.VineAPI;
import co.vine.android.provider.VineDatabaseHelper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package co.vine.android:
//            BaseCursorListFragment, SearchActivity

public abstract class BaseSearchFragment extends BaseCursorListFragment
    implements android.view.View.OnClickListener
{

    protected SearchActivity mCallback;
    protected VineDatabaseHelper mDbHelper;
    protected String mEncodedQueryString;
    protected ExecutorService mExecutor;
    protected String mProjection[];
    protected String mQueryString;
    private TextView mSearchHint;
    private ViewGroup mSearchHintContainer;
    protected String mSortOrder;

    public BaseSearchFragment()
    {
    }

    public abstract void cleanSearchResults();

    protected abstract void fetchContent(int i);

    public abstract int getMinimumSearchQueryLength();

    public String getQueryText()
    {
        return mQueryString;
    }

    public void hideSearchHint()
    {
        mSearchHintContainer.setVisibility(8);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = (RelativeLayout)getView().findViewById(0x7f0a0096);
        ViewGroup viewgroup = (ViewGroup)LayoutInflater.from(getActivity()).inflate(0x7f03008c, null);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(0x7f0b0077));
        layoutparams.addRule(10, -1);
        viewgroup.setLayoutParams(layoutparams);
        viewgroup.setOnClickListener(mCallback);
        bundle.addView(viewgroup);
        mSearchHint = (TextView)viewgroup.findViewById(0x7f0a01ed);
        mSearchHintContainer = viewgroup;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mDbHelper = VineDatabaseHelper.getDatabaseHelper(activity);
        mExecutor = Executors.newCachedThreadPool();
        if (activity instanceof SearchActivity)
        {
            mCallback = (SearchActivity)activity;
            return;
        } else
        {
            throw new IllegalStateException("BaseSearchFragment instances must be added to a SearchActivity.");
        }
    }

    public void onClick(View view)
    {
    }

    public void onDestroy()
    {
        cleanSearchResults();
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
        mCallback.setCurrentTab(this);
        initLoader();
        hideProgress(3);
        if (!TextUtils.isEmpty(mQueryString))
        {
            mCallback.restoreQueryText(mQueryString);
            mSearchHintContainer.setVisibility(8);
        } else
        {
            String s = mCallback.getQueryText();
            if (!TextUtils.isEmpty(s) && s.length() >= getMinimumSearchQueryLength())
            {
                showSearchHint(getResources(), s);
                return;
            }
        }
    }

    protected abstract void performSearch();

    public void setQueryText(String s)
    {
        mQueryString = s;
        mEncodedQueryString = VineAPI.encode(s.trim());
    }

    public void showSearchHint(Resources resources, String s)
    {
        if (resources != null)
        {
            if (!mSearchHintContainer.isShown())
            {
                mSearchHintContainer.setVisibility(0);
                mSearchHintContainer.bringToFront();
            }
            mSearchHint.setText(resources.getString(0x7f0e01ba, new Object[] {
                s
            }));
        }
    }
}
