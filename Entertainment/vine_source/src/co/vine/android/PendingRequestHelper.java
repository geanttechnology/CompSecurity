// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import co.vine.android.client.AppController;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package co.vine.android:
//            PendingRequest, PendingCaptchaRequest, CaptchaRequestHelper

public abstract class PendingRequestHelper
{

    public static final int PROGRESS_FETCH_DATA = 3;
    public static final int PROGRESS_FETCH_DATA_NEW_AUTO = 4;
    public static final int PROGRESS_FETCH_NEWER = 2;
    public static final int PROGRESS_FETCH_OLDER = 1;
    public static final int PROGRESS_FIRST_USER = 6;
    public static final int PROGRESS_LOAD_DATA = 5;
    public static final int PROGRESS_LOAD_DATA_OLDER = 7;
    public static final int PROGRESS_NONE = 0;
    private static final String STATE_CURRENT_REQ_IDS = "pending_reqs";
    private AppController mAppController;
    private final CaptchaRequestHelper mCaptchaRequestHelper = new CaptchaRequestHelper() {

        final PendingRequestHelper this$0;

        protected void handleFailedCaptchaRequest(PendingCaptchaRequest pendingcaptcharequest)
        {
            PendingRequestHelper.this.handleFailedCaptchaRequest(pendingcaptcharequest);
        }

        protected void handleRetryCaptchaRequest(PendingCaptchaRequest pendingcaptcharequest)
        {
            PendingRequestHelper.this.handleRetryCaptchaRequest(pendingcaptcharequest);
        }

            
            {
                this$0 = PendingRequestHelper.this;
                super();
            }
    };
    private ArrayList mPendingRequests;

    public PendingRequestHelper()
    {
    }

    public String addRequest(String s)
    {
        mPendingRequests.add(new PendingRequest(s));
        return s;
    }

    public String addRequest(String s, int i)
    {
        mPendingRequests.add(new PendingRequest(s, i));
        return s;
    }

    public void handleFailedCaptchaRequest(PendingCaptchaRequest pendingcaptcharequest)
    {
        if (mAppController != null)
        {
            String s = mAppController.generateReqIdForCanceledCaptcha();
            addRequest(s);
            mAppController.failRequest(s, pendingcaptcharequest.actionCode, pendingcaptcharequest.bundle);
        }
    }

    public void handlePendingCaptchaRequest()
    {
        mCaptchaRequestHelper.handlePendingCaptchaRequest();
    }

    public void handleRetryCaptchaRequest(PendingCaptchaRequest pendingcaptcharequest)
    {
        if (mAppController != null)
        {
            addRequest(mAppController.retryRequest(pendingcaptcharequest.actionCode, pendingcaptcharequest.bundle));
        }
    }

    public boolean hasPendingRequest()
    {
        return !mPendingRequests.isEmpty();
    }

    public boolean hasPendingRequest(int i)
    {
label0:
        {
            if (i == 0)
            {
                break label0;
            }
            Iterator iterator = mPendingRequests.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (((PendingRequest)iterator.next()).fetchType != i);
            return true;
        }
        return false;
    }

    public abstract void hideProgress(int i);

    public boolean onActivityResult(int i, int j, Intent intent)
    {
        return mCaptchaRequestHelper.onActivityResult(i, j, intent);
    }

    public void onCaptchaRequired(FragmentActivity fragmentactivity, String s, int i, Bundle bundle, String s1)
    {
        mCaptchaRequestHelper.onCaptchaRequired(fragmentactivity, s, i, bundle, s1);
    }

    public void onCreate(AppController appcontroller, Bundle bundle)
    {
        mAppController = appcontroller;
        if (bundle != null)
        {
            mPendingRequests = bundle.getParcelableArrayList("pending_reqs");
        }
        if (mPendingRequests == null)
        {
            mPendingRequests = new ArrayList(5);
        }
    }

    public void onResume()
    {
        int i = mPendingRequests.size() - 1;
        while (i >= 0) 
        {
            PendingRequest pendingrequest = (PendingRequest)mPendingRequests.get(i);
            if (mAppController.isPendingRequest(pendingrequest.id))
            {
                showProgress(pendingrequest.fetchType);
            } else
            {
                hideProgress(pendingrequest.fetchType);
                mPendingRequests.remove(pendingrequest);
            }
            i--;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putParcelableArrayList("pending_reqs", mPendingRequests);
        mCaptchaRequestHelper.onSaveInstanceState(bundle);
    }

    public PendingRequest removeRequest(String s)
    {
        ArrayList arraylist = mPendingRequests;
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            if (((PendingRequest)arraylist.get(i)).id.equals(s))
            {
                return (PendingRequest)arraylist.remove(i);
            }
        }

        return null;
    }

    public void restorePendingCaptchaRequest(Bundle bundle)
    {
        mCaptchaRequestHelper.restorePendingCaptchaRequest(bundle);
    }

    public abstract void showProgress(int i);
}
