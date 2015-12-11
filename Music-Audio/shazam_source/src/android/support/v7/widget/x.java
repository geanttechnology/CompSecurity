// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.support.v4.view.d;
import android.support.v7.internal.widget.ActivityChooserView;
import android.support.v7.internal.widget.q;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class x extends d
{
    public static interface a
    {

        public abstract boolean a(Intent intent);
    }

    private final class b
        implements android.support.v7.internal.widget.d.e
    {

        final x a;

        public final boolean a(Intent intent)
        {
            if (a.mOnShareTargetSelectedListener != null)
            {
                a.mOnShareTargetSelectedListener.a(intent);
            }
            return false;
        }

        private b()
        {
            a = x.this;
            super();
        }

        b(byte byte0)
        {
            this();
        }
    }

    private final class c
        implements android.view.MenuItem.OnMenuItemClickListener
    {

        final x a;

        public final boolean onMenuItemClick(MenuItem menuitem)
        {
            menuitem = android.support.v7.internal.widget.d.a(a.mContext, a.mShareHistoryFileName).b(menuitem.getItemId());
            if (menuitem != null)
            {
                String s = menuitem.getAction();
                if ("android.intent.action.SEND".equals(s) || "android.intent.action.SEND_MULTIPLE".equals(s))
                {
                    a.updateIntent(menuitem);
                }
                a.mContext.startActivity(menuitem);
            }
            return true;
        }

        private c()
        {
            a = x.this;
            super();
        }

        c(byte byte0)
        {
            this();
        }
    }


    private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
    private final Context mContext;
    private int mMaxShownActivityCount;
    private android.support.v7.internal.widget.d.e mOnChooseActivityListener;
    private final c mOnMenuItemClickListener = new c((byte)0);
    private a mOnShareTargetSelectedListener;
    private String mShareHistoryFileName;

    public x(Context context)
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
            mOnChooseActivityListener = new b((byte)0);
        }
        android.support.v7.internal.widget.d d1 = android.support.v7.internal.widget.d.a(mContext, mShareHistoryFileName);
        android.support.v7.internal.widget.d.e e = mOnChooseActivityListener;
        synchronized (d1.a)
        {
            d1.e = e;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
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
        mContext.getTheme().resolveAttribute(android.support.v7.b.a.a.actionModeShareDrawable, typedvalue, true);
        activitychooserview.setExpandActivityOverflowButtonDrawable(q.a(mContext, typedvalue.resourceId));
        activitychooserview.setProvider(this);
        activitychooserview.setDefaultActionButtonContentDescription(android.support.v7.b.a.i.abc_shareactionprovider_share_with_application);
        activitychooserview.setExpandActivityOverflowButtonContentDescription(android.support.v7.b.a.i.abc_shareactionprovider_share_with);
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
            submenu = submenu.addSubMenu(0, l, l, mContext.getString(android.support.v7.b.a.i.abc_activity_chooser_view_see_all));
            for (int j = 0; j < k; j++)
            {
                ResolveInfo resolveinfo1 = d1.a(j);
                submenu.add(0, j, j, resolveinfo1.loadLabel(packagemanager)).setIcon(resolveinfo1.loadIcon(packagemanager)).setOnMenuItemClickListener(mOnMenuItemClickListener);
            }

        }
    }

    public void setOnShareTargetSelectedListener(a a1)
    {
        mOnShareTargetSelectedListener = a1;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareHistoryFileName(String s)
    {
        mShareHistoryFileName = s;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareIntent(Intent intent)
    {
        android.support.v7.internal.widget.d d1;
label0:
        {
            if (intent != null)
            {
                String s = intent.getAction();
                if ("android.intent.action.SEND".equals(s) || "android.intent.action.SEND_MULTIPLE".equals(s))
                {
                    updateIntent(intent);
                }
            }
            d1 = android.support.v7.internal.widget.d.a(mContext, mShareHistoryFileName);
            synchronized (d1.a)
            {
                if (d1.c != intent)
                {
                    break label0;
                }
            }
            return;
        }
        d1.c = intent;
        d1.d = true;
        d1.d();
        obj;
        JVM INSTR monitorexit ;
        return;
        intent;
        obj;
        JVM INSTR monitorexit ;
        throw intent;
    }




}
