// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.amazon.mShop.util.BitmapUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.mShop:
//            AmazonChooserActivity, AmazonAlertDialog

private class mDialog extends BaseAdapter
    implements android.widget.r, ListAdapter
{

    protected AmazonChooserActivity mActivity;
    protected AmazonAlertDialog mDialog;
    protected LayoutInflater mLayoutInflater;
    private boolean mNeedRedraw;
    private PackageManager mPackManager;
    protected Map mPackageIconMap;
    private List mResolveInfoList;
    protected Intent mTargetIntent;
    final AmazonChooserActivity this$0;

    public int getCount()
    {
        if (mResolveInfoList == null)
        {
            return 0;
        } else
        {
            return mResolveInfoList.size();
        }
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        Object obj = viewgroup;
        if (mResolveInfoList != null)
        {
            obj = viewgroup;
            if (mResolveInfoList.size() > 0)
            {
                viewgroup = (ResolveInfo)mResolveInfoList.get(i);
                obj = populateItemView(view, viewgroup.loadLabel(mPackManager), null, ((ResolveInfo) (viewgroup)).activityInfo.packageName, viewgroup);
            }
        }
        return ((View) (obj));
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (mResolveInfoList != null && mResolveInfoList.size() > 0)
        {
            AmazonChooserActivity.access$000(mActivity, (ResolveInfo)mResolveInfoList.get(i), mTargetIntent);
            AmazonChooserActivity.access$100(AmazonChooserActivity.this, ((ResolveInfo)mResolveInfoList.get(i)).activityInfo.name, -1);
            mDialog.dismiss();
        }
    }

    protected View populateItemView(View view, CharSequence charsequence, Drawable drawable, final String packageName, final ResolveInfo resolveInfo)
    {
        final ImageView appIcon;
        appIcon = null;
        if (view != null)
        {
            appIcon = (String)view.getTag();
        }
        if (packageName == null || appIcon == null || !packageName.equals(appIcon))
        {
            view = mLayoutInflater.inflate(com.amazon.mShop.android.lib.ter, null);
            view.setTag(packageName);
        }
        appIcon = (ImageView)view.findViewById(com.amazon.mShop.android.lib.ter);
        if (!mPackageIconMap.containsKey(packageName)) goto _L2; else goto _L1
_L1:
        drawable = (Drawable)mPackageIconMap.get(packageName);
        appIcon.setImageDrawable(drawable);
        if (drawable == null)
        {
            mNeedRedraw = true;
        }
_L4:
        ((TextView)view.findViewById(com.amazon.mShop.android.lib.Map)).setText(charsequence);
        return view;
_L2:
        if (drawable != null)
        {
            mPackageIconMap.put(packageName, drawable);
            appIcon.setImageDrawable(drawable);
        } else
        if (resolveInfo != null)
        {
            mPackageIconMap.put(packageName, null);
            appIcon.setImageDrawable(null);
            BitmapUtil.tryInCaseOfOutOfMemory(new Runnable() {

                final AmazonChooserActivity.ActivityListAdapter this$1;
                final ImageView val$appIcon;
                final String val$packageName;
                final ResolveInfo val$resolveInfo;

                public void run()
                {
                    Drawable drawable1 = resolveInfo.loadIcon(mPackManager);
                    if (drawable1 != null)
                    {
                        mPackageIconMap.put(packageName, drawable1);
                        runOnUiThread(drawable1. new Runnable() {

                            final _cls1 this$2;
                            final Drawable val$defaultIcon;

                            public void run()
                            {
                                appIcon.setImageDrawable(defaultIcon);
                                if (mNeedRedraw)
                                {
                                    notifyDataSetChanged();
                                    mNeedRedraw = false;
                                }
                            }

            
            {
                this$2 = final__pcls1;
                defaultIcon = Drawable.this;
                super();
            }
                        });
                    }
                }

            
            {
                this$1 = AmazonChooserActivity.ActivityListAdapter.this;
                resolveInfo = resolveinfo;
                packageName = s;
                appIcon = imageview;
                super();
            }
            });
        }
        if (true) goto _L4; else goto _L3
_L3:
    }




/*
    static boolean access$302(_cls1._cls1 _pcls1, boolean flag)
    {
        _pcls1.mNeedRedraw = flag;
        return flag;
    }

*/

    public _cls1.val.appIcon(List list, Intent intent, AmazonAlertDialog amazonalertdialog)
    {
        this$0 = AmazonChooserActivity.this;
        super();
        mActivity = null;
        mResolveInfoList = null;
        mTargetIntent = null;
        mLayoutInflater = null;
        mPackManager = null;
        mPackageIconMap = new HashMap();
        mNeedRedraw = false;
        mActivity = AmazonChooserActivity.this;
        mResolveInfoList = list;
        mTargetIntent = intent;
        mLayoutInflater = LayoutInflater.from(mActivity);
        mPackManager = mActivity.getPackageManager();
        mDialog = amazonalertdialog;
    }
}
