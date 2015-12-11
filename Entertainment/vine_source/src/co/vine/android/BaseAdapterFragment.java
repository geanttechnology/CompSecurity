// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

// Referenced classes of package co.vine.android:
//            BaseControllerFragment, PendingRequestHelper, PendingRequest

public abstract class BaseAdapterFragment extends BaseControllerFragment
{
    protected class BasePendingRequestHelper extends PendingRequestHelper
    {

        final BaseAdapterFragment this$0;

        public void hideProgress(int i)
        {
            BaseAdapterFragment.this.hideProgress(i);
        }

        public void showProgress(int i)
        {
            BaseAdapterFragment.this.showProgress(i);
        }

        protected BasePendingRequestHelper()
        {
            this$0 = BaseAdapterFragment.this;
            super();
        }
    }


    protected static final int PROGRESS_FETCH_DATA = 3;
    protected static final int PROGRESS_FETCH_DATA_NEW_AUTO = 4;
    protected static final int PROGRESS_FETCH_NEWER = 2;
    protected static final int PROGRESS_FETCH_OLDER = 1;
    protected final Handler mHandler = new Handler(Looper.getMainLooper());
    protected final PendingRequestHelper mPendingRequestHelper = createPendingRequestHelper();
    protected ProgressDialog mProgressDialog;
    protected boolean mRefreshing;

    public BaseAdapterFragment()
    {
    }

    protected String addRequest(String s)
    {
        return mPendingRequestHelper.addRequest(s);
    }

    protected String addRequest(String s, int i)
    {
        return mPendingRequestHelper.addRequest(s, i);
    }

    protected PendingRequestHelper createPendingRequestHelper()
    {
        return new BasePendingRequestHelper();
    }

    protected void dismissDialog()
    {
        if (mProgressDialog != null)
        {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    protected boolean hasPendingRequest()
    {
        return mPendingRequestHelper.hasPendingRequest();
    }

    protected boolean hasPendingRequest(int i)
    {
        return mPendingRequestHelper.hasPendingRequest(i);
    }

    protected abstract void hideProgress(int i);

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mPendingRequestHelper.onCreate(mAppController, bundle);
    }

    public void onPause()
    {
        super.onPause();
        dismissDialog();
    }

    public void onResume()
    {
        super.onResume();
        mPendingRequestHelper.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        mPendingRequestHelper.onSaveInstanceState(bundle);
    }

    protected PendingRequest removeRequest(String s)
    {
        return mPendingRequestHelper.removeRequest(s);
    }

    protected abstract void showProgress(int i);
}
