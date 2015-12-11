// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.nav;

import com.amazon.mobile.mash.api.MASHNavigationPlugin;
import java.util.List;

// Referenced classes of package com.amazon.mobile.mash.nav:
//            MASHNavOperation

public abstract class MASHNavHandler
{

    public static final String TAG = "MASHNavHandler";
    private int mCurrentIndex;
    private MASHNavigationPlugin mMASHNavigationPlugin;
    private List mOperationList;

    public MASHNavHandler(MASHNavigationPlugin mashnavigationplugin, List list, int i)
    {
        mMASHNavigationPlugin = mashnavigationplugin;
        mOperationList = list;
        mCurrentIndex = i;
    }

    public MASHNavOperation getCurrentOperation()
    {
        Object obj = null;
        MASHNavOperation mashnavoperation = obj;
        if (mCurrentIndex >= 0)
        {
            mashnavoperation = obj;
            if (mCurrentIndex < mOperationList.size())
            {
                mashnavoperation = (MASHNavOperation)mOperationList.get(mCurrentIndex);
            }
        }
        return mashnavoperation;
    }

    public MASHNavigationPlugin getMASHNavigationPlugin()
    {
        return mMASHNavigationPlugin;
    }

    public MASHNavOperation getNextOperation()
    {
        Object obj = null;
        MASHNavOperation mashnavoperation = obj;
        if (mCurrentIndex >= 0)
        {
            mashnavoperation = obj;
            if (mCurrentIndex < mOperationList.size() - 1)
            {
                mashnavoperation = (MASHNavOperation)mOperationList.get(mCurrentIndex + 1);
            }
        }
        return mashnavoperation;
    }

    public MASHNavOperation getPreOperation()
    {
        Object obj = null;
        MASHNavOperation mashnavoperation = obj;
        if (mCurrentIndex > 0)
        {
            mashnavoperation = obj;
            if (mCurrentIndex < mOperationList.size())
            {
                mashnavoperation = (MASHNavOperation)mOperationList.get(mCurrentIndex - 1);
            }
        }
        return mashnavoperation;
    }

    public String[] getRemainingOperations()
    {
        String as[] = null;
        int j = mOperationList.size();
        if (mCurrentIndex < j - 1)
        {
            String as1[] = new String[j - 1 - mCurrentIndex];
            int i = mCurrentIndex + 1;
            do
            {
                as = as1;
                if (i >= j)
                {
                    break;
                }
                as1[i - mCurrentIndex - 1] = ((MASHNavOperation)mOperationList.get(i)).toJSONString();
                i++;
            } while (true);
        }
        return as;
    }

    public abstract void navigate();
}
