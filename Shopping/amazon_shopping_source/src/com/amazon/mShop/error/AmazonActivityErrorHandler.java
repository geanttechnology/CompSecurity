// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.error;

import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.util.AmazonErrorUtils;
import com.amazon.mShop.util.UIUtils;
import java.util.Stack;

// Referenced classes of package com.amazon.mShop.error:
//            AmazonErrorInfo

public class AmazonActivityErrorHandler
{

    private AmazonActivity mAmazonActivity;
    private Stack mErrorInfoStack;

    public AmazonActivityErrorHandler(AmazonActivity amazonactivity)
    {
        mErrorInfoStack = new Stack();
        mAmazonActivity = null;
        mAmazonActivity = amazonactivity;
    }

    private void setErrorInfoAt(int i, AmazonErrorInfo amazonerrorinfo)
    {
        mErrorInfoStack.set(i, amazonerrorinfo);
    }

    public AmazonErrorInfo getCurrentErrorInfo()
    {
        if (mErrorInfoStack.size() > 0)
        {
            return (AmazonErrorInfo)mErrorInfoStack.lastElement();
        } else
        {
            return null;
        }
    }

    public void onErrorBoxDisappeared()
    {
        AmazonErrorInfo amazonerrorinfo = getCurrentErrorInfo();
        if (amazonerrorinfo != null)
        {
            amazonerrorinfo.setErrorId(0);
            amazonerrorinfo.setActionListener(null);
            amazonerrorinfo.setMessage(null);
            amazonerrorinfo.setActionButtonText(null);
        }
    }

    public void onErrorReportAt(AmazonErrorInfo amazonerrorinfo, int i)
    {
        if (i >= 0 && i < mErrorInfoStack.size())
        {
            setErrorInfoAt(i, amazonerrorinfo);
        }
    }

    public void onPoppedToRoot()
    {
        AmazonErrorInfo amazonerrorinfo = null;
        if (mErrorInfoStack != null)
        {
            if (mErrorInfoStack.size() > 0)
            {
                amazonerrorinfo = (AmazonErrorInfo)mErrorInfoStack.get(0);
                mAmazonActivity.dismissErrorBox();
            }
            mErrorInfoStack.removeAllElements();
            mErrorInfoStack.push(amazonerrorinfo);
            if (amazonerrorinfo != null && amazonerrorinfo.getErrorId() != 0)
            {
                mAmazonActivity.reportErrorOnView(amazonerrorinfo, UIUtils.createErrorBox(mAmazonActivity, amazonerrorinfo), mAmazonActivity.getCurrentView());
            }
        }
    }

    public void onPushView()
    {
        mErrorInfoStack.push(null);
        mAmazonActivity.dismissErrorBox();
    }

    public void onTopViewRemoved()
    {
        mAmazonActivity.dismissErrorBox();
        AmazonErrorInfo amazonerrorinfo = getCurrentErrorInfo();
        if (amazonerrorinfo != null && amazonerrorinfo.getErrorId() != 0)
        {
            mAmazonActivity.reportErrorOnView(amazonerrorinfo, UIUtils.createErrorBox(mAmazonActivity, amazonerrorinfo), mAmazonActivity.getCurrentView());
        }
    }

    public void onViewPopped()
    {
        mErrorInfoStack.pop();
        AmazonErrorInfo amazonerrorinfo = getCurrentErrorInfo();
        if (amazonerrorinfo != null && amazonerrorinfo.getErrorId() != 0)
        {
            AmazonErrorUtils.reportError(mAmazonActivity, amazonerrorinfo, mAmazonActivity.getCurrentView());
        }
    }

    public void onViewSwapped()
    {
        int i = mErrorInfoStack.size();
        if (1 < i)
        {
            mErrorInfoStack.remove(i - 2);
        }
    }

    public void removeAllErrors()
    {
        mErrorInfoStack.removeAllElements();
    }

    public void removeErrorAt(int i)
    {
        if (i >= 0 && i < mErrorInfoStack.size())
        {
            mErrorInfoStack.removeElementAt(i);
        }
    }

    public void setCurrentErrorInfo(AmazonErrorInfo amazonerrorinfo)
    {
        if (!mErrorInfoStack.empty())
        {
            mErrorInfoStack.pop();
        }
        mErrorInfoStack.push(amazonerrorinfo);
    }
}
