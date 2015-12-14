// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.sdk.graphics.PreviewSpotDrawable;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            DelayedSpotDrawPanel

class mRes extends BaseAdapter
{

    private static final int INVALID_POSITION = 1;
    private static final float RADIUS_MULTIPLIER = 0.55F;
    private static final int VALID_POSITION = 0;
    LayoutInflater mLayoutInflater;
    Resources mRes;
    private int sizes[];
    final DelayedSpotDrawPanel this$0;

    public int getCount()
    {
        return sizes.length;
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(sizes[i]);
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public int getItemViewType(int i)
    {
        if (i >= 0 && i < getCount())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return i == 0 ? 1 : 0;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        int j;
        boolean flag;
        flag = false;
        j = getItemViewType(i);
        viewgroup = null;
        if (view != null) goto _L2; else goto _L1
_L1:
        View view1;
        view = mLayoutInflater.inflate(com.aviary.android.feather.sdk.dapter.mLayoutInflater, mGallery, false);
        view1 = view;
        if (j == 0)
        {
            viewgroup = new PreviewSpotDrawable(getContext().getBaseContext());
            ((ImageView)view.findViewById(com.aviary.android.feather.sdk.seContext)).setImageDrawable(viewgroup);
            view.setTag(viewgroup);
            view1 = view;
        }
_L4:
        if (viewgroup != null && j == 0)
        {
            j = sizes[i];
            float f = minRadiusSize + (((float)j - (float)DelayedSpotDrawPanel.access$000(DelayedSpotDrawPanel.this)) / (float)(DelayedSpotDrawPanel.access$100(DelayedSpotDrawPanel.this) - DelayedSpotDrawPanel.access$000(DelayedSpotDrawPanel.this))) * (maxRadiusSize - minRadiusSize) * 0.55F;
            viewgroup.setRadius(f);
            view1.setContentDescription((new StringBuilder()).append(mSizeContentDescription).append(" ").append(Float.toString(f)).toString());
        }
        if (mSelectedPosition == i)
        {
            flag = true;
        }
        view1.setSelected(flag);
        view1.setId(i);
        return view1;
_L2:
        view1 = view;
        if (j == 0)
        {
            viewgroup = (PreviewSpotDrawable)view.getTag();
            view1 = view;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    public (Context context, int ai[])
    {
        this$0 = DelayedSpotDrawPanel.this;
        super();
        mLayoutInflater = LayoutInflater.from(context);
        sizes = ai;
        mRes = context.getResources();
    }
}
