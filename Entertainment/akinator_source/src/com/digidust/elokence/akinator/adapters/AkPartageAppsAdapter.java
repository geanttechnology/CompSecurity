// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.adapters;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.digidust.elokence.akinator.factories.AkApplication;
import java.util.ArrayList;
import java.util.List;

public class AkPartageAppsAdapter extends BaseAdapter
    implements android.view.View.OnClickListener
{
    private class ViewHolder
    {

        ImageView appImage;
        LinearLayout appLayout;
        TextView appName;
        final AkPartageAppsAdapter this$0;

        private ViewHolder()
        {
            this$0 = AkPartageAppsAdapter.this;
            super();
        }

    }


    private List mApps;
    private final Context mContext;
    private LayoutInflater mInflater;
    private ArrayList mViews;
    private Typeface tf;

    public AkPartageAppsAdapter(Context context, List list)
    {
        tf = AkApplication.getTypeFace();
        mApps = null;
        mInflater = null;
        mViews = new ArrayList();
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mApps = list;
    }

    public int getCount()
    {
        return mApps.size();
    }

    public Object getItem(int i)
    {
        return mApps.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            viewgroup = new ViewHolder();
            view = mInflater.inflate(0x7f03005e, null);
            viewgroup.appImage = (ImageView)view.findViewById(0x7f0d0270);
            viewgroup.appName = (TextView)view.findViewById(0x7f0d0271);
            ((ViewHolder) (viewgroup)).appName.setTextSize(0, ((ViewHolder) (viewgroup)).appName.getTextSize() * AkApplication.getCoeffFont());
            ((ViewHolder) (viewgroup)).appName.setTypeface(tf);
            viewgroup.appLayout = (LinearLayout)view.findViewById(0x7f0d026f);
            ((ViewHolder) (viewgroup)).appLayout.setOnClickListener(this);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        try
        {
            ((ViewHolder) (viewgroup)).appImage.setImageDrawable(((ResolveInfo)mApps.get(i)).loadIcon(mContext.getPackageManager()));
            ((ViewHolder) (viewgroup)).appName.setText(((ResolveInfo)mApps.get(i)).loadLabel(mContext.getPackageManager()));
            ((ViewHolder) (viewgroup)).appLayout.setClickable(false);
            ((ViewHolder) (viewgroup)).appLayout.setFocusableInTouchMode(false);
            ((ViewHolder) (viewgroup)).appLayout.setFocusable(false);
            ((ViewHolder) (viewgroup)).appImage.setClickable(false);
            ((ViewHolder) (viewgroup)).appImage.setFocusableInTouchMode(false);
            ((ViewHolder) (viewgroup)).appImage.setFocusable(false);
            ((ViewHolder) (viewgroup)).appName.setClickable(false);
            ((ViewHolder) (viewgroup)).appName.setFocusableInTouchMode(false);
            ((ViewHolder) (viewgroup)).appName.setFocusable(false);
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            return view;
        }
        return view;
    }

    public void onClick(View view)
    {
    }
}
