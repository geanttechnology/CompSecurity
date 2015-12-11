// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.support.v4.view.d;
import android.support.v7.internal.widget.ActivityChooserView;
import android.support.v7.internal.widget.p;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class ShareActionProvider extends d
{
    public static interface OnShareTargetSelectedListener
    {

        public abstract boolean onShareTargetSelected(ShareActionProvider shareactionprovider, Intent intent);
    }

    private class ShareActivityChooserModelPolicy
        implements android.support.v7.internal.widget.d.e
    {

        final ShareActionProvider this$0;

        public boolean onChooseActivity(android.support.v7.internal.widget.d d1, Intent intent)
        {
            if (mOnShareTargetSelectedListener != null)
            {
                mOnShareTargetSelectedListener.onShareTargetSelected(ShareActionProvider.this, intent);
            }
            return false;
        }

        private ShareActivityChooserModelPolicy()
        {
            this$0 = ShareActionProvider.this;
            super();
        }

    }

    private class ShareMenuItemOnMenuItemClickListener
        implements android.view.MenuItem.OnMenuItemClickListener
    {

        final ShareActionProvider this$0;

        public boolean onMenuItemClick(MenuItem menuitem)
        {
            menuitem = android.support.v7.internal.widget.d.a(mContext, mShareHistoryFileName).b(menuitem.getItemId());
            if (menuitem != null)
            {
                String s = menuitem.getAction();
                if ("android.intent.action.SEND".equals(s) || "android.intent.action.SEND_MULTIPLE".equals(s))
                {
                    updateIntent(menuitem);
                }
                mContext.startActivity(menuitem);
            }
            return true;
        }

        private ShareMenuItemOnMenuItemClickListener()
        {
            this$0 = ShareActionProvider.this;
            super();
        }

    }


    private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
    private final Context mContext;
    private int mMaxShownActivityCount;
    private android.support.v7.internal.widget.d.e mOnChooseActivityListener;
    private final ShareMenuItemOnMenuItemClickListener mOnMenuItemClickListener = new ShareMenuItemOnMenuItemClickListener();
    private OnShareTargetSelectedListener mOnShareTargetSelectedListener;
    private String mShareHistoryFileName;

    public ShareActionProvider(Context context)
    {
        super(context);
        mMaxShownActivityCount = 4;
        mShareHistoryFileName = "share_history.xml";
        mContext = context;
    }

    private void setActivityChooserPolicyIfNeeded()
    {
        if (mOnShareTargetSelectedListener == null)
        {
            return;
        }
        if (mOnChooseActivityListener == null)
        {
            mOnChooseActivityListener = new ShareActivityChooserModelPolicy();
        }
        android.support.v7.internal.widget.d.a(mContext, mShareHistoryFileName).a(mOnChooseActivityListener);
    }

    private void updateIntent(Intent intent)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            intent.addFlags(0x8080000);
            return;
        } else
        {
            intent.addFlags(0x80000);
            return;
        }
    }

    public boolean hasSubMenu()
    {
        return true;
    }

    public View onCreateActionView()
    {
        ActivityChooserView activitychooserview = new ActivityChooserView(mContext);
        if (!activitychooserview.isInEditMode())
        {
            activitychooserview.setActivityChooserModel(android.support.v7.internal.widget.d.a(mContext, mShareHistoryFileName));
        }
        TypedValue typedvalue = new TypedValue();
        mContext.getTheme().resolveAttribute(android.support.v7.br.a.actionModeShareDrawable, typedvalue, true);
        activitychooserview.setExpandActivityOverflowButtonDrawable(p.a(mContext, typedvalue.resourceId));
        activitychooserview.setProvider(this);
        activitychooserview.setDefaultActionButtonContentDescription(android.support.v7.br.i.abc_shareactionprovider_share_with_application);
        activitychooserview.setExpandActivityOverflowButtonContentDescription(android.support.v7.br.i.abc_shareactionprovider_share_with);
        return activitychooserview;
    }

    public void onPrepareSubMenu(SubMenu submenu)
    {
        submenu.clear();
        android.support.v7.internal.widget.d d1 = android.support.v7.internal.widget.d.a(mContext, mShareHistoryFileName);
        android.content.pm.PackageManager packagemanager = mContext.getPackageManager();
        int k = d1.a();
        int l = Math.min(k, mMaxShownActivityCount);
        for (int i = 0; i < l; i++)
        {
            ResolveInfo resolveinfo = d1.a(i);
            submenu.add(0, i, i, resolveinfo.loadLabel(packagemanager)).setIcon(resolveinfo.loadIcon(packagemanager)).setOnMenuItemClickListener(mOnMenuItemClickListener);
        }

        if (l < k)
        {
            submenu = submenu.addSubMenu(0, l, l, mContext.getString(android.support.v7.br.i.abc_activity_chooser_view_see_all));
            for (int j = 0; j < k; j++)
            {
                ResolveInfo resolveinfo1 = d1.a(j);
                submenu.add(0, j, j, resolveinfo1.loadLabel(packagemanager)).setIcon(resolveinfo1.loadIcon(packagemanager)).setOnMenuItemClickListener(mOnMenuItemClickListener);
            }

        }
    }

    public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener onsharetargetselectedlistener)
    {
        mOnShareTargetSelectedListener = onsharetargetselectedlistener;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareHistoryFileName(String s)
    {
        mShareHistoryFileName = s;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareIntent(Intent intent)
    {
        if (intent != null)
        {
            String s = intent.getAction();
            if ("android.intent.action.SEND".equals(s) || "android.intent.action.SEND_MULTIPLE".equals(s))
            {
                updateIntent(intent);
            }
        }
        android.support.v7.internal.widget.d.a(mContext, mShareHistoryFileName).a(intent);
    }




}
