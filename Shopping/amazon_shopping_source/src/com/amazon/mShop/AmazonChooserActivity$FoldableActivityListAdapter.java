// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.amazon.mShop.share.SharableAppInfo;
import com.amazon.mShop.share.SharableAppInfoManager;
import com.amazon.mShop.share.SocialAppConfig;
import com.amazon.mShop.share.WechatSDKManager;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.mShop:
//            AmazonChooserActivity, AmazonAlertDialog

private class mCurrentList extends mCurrentList
{

    private List mCurrentList;
    private int mFoldPosition;
    private List mFullList;
    private boolean mIsFolded;
    final AmazonChooserActivity this$0;

    private void expandAppList()
    {
        if (mIsFolded)
        {
            mCurrentList.clear();
            mCurrentList = new ArrayList(mFullList);
        }
        mIsFolded = false;
    }

    private void foldAppList()
    {
        if (mFoldPosition == 0)
        {
            return;
        }
        if (mCurrentList != null)
        {
            mCurrentList.clear();
        }
        mCurrentList = new ArrayList(mFullList.subList(0, mFoldPosition));
        String s = getResources().getString(com.amazon.mShop.android.lib.n);
        mCurrentList.add(new SharableAppInfo(s, null, null, SocialAppConfig.getDefaultRefTag(), SocialAppConfig.getDefaultPriority(), null));
        mIsFolded = true;
    }

    public int getCount()
    {
        if (mCurrentList == null)
        {
            return 0;
        } else
        {
            return mCurrentList.size();
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        Object obj = viewgroup;
        if (mCurrentList != null)
        {
            obj = viewgroup;
            if (mCurrentList.size() > 0)
            {
                viewgroup = (SharableAppInfo)mCurrentList.get(i);
                obj = populateItemView(view, viewgroup.getLabel(), viewgroup.getIcon(), viewgroup.getPackageName(), viewgroup.getResolveInfo());
            }
        }
        return ((View) (obj));
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (!mIsFolded || i != mCurrentList.size() - 1) goto _L2; else goto _L1
_L1:
        expandAppList();
        notifyDataSetChanged();
_L4:
        return;
_L2:
        if (mCurrentList == null || mCurrentList.size() <= 0) goto _L4; else goto _L3
_L3:
        boolean flag;
        flag = false;
        adapterview = (SharableAppInfo)mCurrentList.get(i);
        view = adapterview.getPackageName();
        if (!SharableAppInfoManager.isCnMshopPackage(mActivity) || !view.equals(SocialAppConfig.getWechatTimelinePackageName()) && !view.equals(SocialAppConfig.getWechatPackageName())) goto _L6; else goto _L5
_L5:
        SharableAppInfoManager.replaceRefMarker(mTargetIntent, adapterview);
        flag = WechatSDKManager.sendRequest(mActivity, mTargetIntent, view);
_L8:
        if (flag)
        {
            SharableAppInfoManager.logClickRefMarker(adapterview);
            AmazonChooserActivity.access$100(AmazonChooserActivity.this, ((SharableAppInfo)mCurrentList.get(i)).getResolveInfo().activityInfo.name, -1);
        }
        mDialog.dismiss();
        return;
_L6:
        view = adapterview.getResolveInfo();
        if (view != null)
        {
            SharableAppInfoManager.replaceRefMarker(mTargetIntent, adapterview);
            AmazonChooserActivity.access$000(mActivity, view, mTargetIntent);
            flag = true;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public (List list, Intent intent, List list1, int i, AmazonAlertDialog amazonalertdialog)
    {
        this$0 = AmazonChooserActivity.this;
        super(AmazonChooserActivity.this, list, intent, amazonalertdialog);
        mCurrentList = null;
        mFullList = null;
        mFullList = list1;
        mCurrentList = null;
        mIsFolded = false;
        mFoldPosition = i;
        if (i > 0 && list1.size() > i)
        {
            foldAppList();
            return;
        } else
        {
            mCurrentList = new ArrayList(list1);
            return;
        }
    }
}
