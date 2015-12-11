// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.localeswitch;

import android.content.Context;
import android.content.Intent;
import com.amazon.mShop.AmazonProgressDialog;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.mShop.localeswitch:
//            LocaleSwitchProcessor

public class LocaleSwitchChain
{

    private Context mContext;
    private int mCurrentIndex;
    private Intent mLaunchIntent;
    private String mLocaleName;
    private List mProcessorList;
    private AmazonProgressDialog mProgDiag;

    public LocaleSwitchChain(String s, Context context, Intent intent)
    {
        mProcessorList = new ArrayList();
        mCurrentIndex = 0;
        mProgDiag = null;
        mLocaleName = s;
        mContext = context;
        mLaunchIntent = intent;
    }

    public LocaleSwitchChain addProcessor(LocaleSwitchProcessor localeswitchprocessor)
    {
        mProcessorList.add(localeswitchprocessor);
        return this;
    }

    public AmazonProgressDialog getExistentProgDiag()
    {
        return mProgDiag;
    }

    public Intent getLaunchIntent()
    {
        return mLaunchIntent;
    }

    public void process()
    {
        if (mCurrentIndex == mProcessorList.size())
        {
            return;
        } else
        {
            List list = mProcessorList;
            int i = mCurrentIndex;
            mCurrentIndex = i + 1;
            ((LocaleSwitchProcessor)list.get(i)).doProcess(mLocaleName, mContext, this);
            return;
        }
    }

    public void setExistentProgressDialog(AmazonProgressDialog amazonprogressdialog)
    {
        mProgDiag = amazonprogressdialog;
    }
}
