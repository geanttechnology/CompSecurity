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
import com.aviary.android.feather.sdk.FeatherActivity;
import com.aviary.android.feather.sdk.graphics.PreviewFillColorDrawable;
import com.aviary.android.feather.sdk.graphics.PreviewFillColorFreetime;
import com.aviary.android.feather.sdk.utils.Maturity;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            DrawingPanel

class mRes extends BaseAdapter
{

    public static final int ERASER_POSITION = 2;
    public static final int INVALID_POSITION = 1;
    public static final int VALID_POSITION = 0;
    LayoutInflater mLayoutInflater;
    Resources mRes;
    private int sizes[];
    final DrawingPanel this$0;

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
        boolean flag;
        if (i >= 0 && i < getCount())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            return 1;
        }
        return ((Integer)getItem(i)).intValue() != 0 ? 0 : 2;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        int l = getItemViewType(i);
        View view1 = null;
        if (view == null)
        {
            if (l == 2)
            {
                int j;
                if (FeatherActivity.MATURITY.isKidsFriendly())
                {
                    view = mLayoutInflater.inflate(com.aviary.android.feather.sdk.light_view_freetime, viewgroup, false);
                } else
                {
                    view = mLayoutInflater.inflate(com.aviary.android.feather.sdk.light_view, viewgroup, false);
                }
                view.setContentDescription(mEraserContentDescription);
            } else
            {
                view = mLayoutInflater;
                int k;
                if (FeatherActivity.MATURITY.isKidsFriendly())
                {
                    k = com.aviary.android.feather.sdk._freetime_row2;
                } else
                {
                    k = com.aviary.android.feather.sdk.;
                }
                view = view.inflate(k, viewgroup, false);
            }
            viewgroup = view1;
            view1 = view;
            if (l == 0)
            {
                viewgroup = getContext().getBaseContext();
                if (FeatherActivity.MATURITY.isKidsFriendly())
                {
                    viewgroup = new PreviewFillColorFreetime(viewgroup);
                } else
                {
                    viewgroup = new PreviewFillColorDrawable(viewgroup);
                }
                ((ImageView)view.findViewById(com.aviary.android.feather.sdk.)).setImageDrawable(viewgroup);
                view.setTag(viewgroup);
                view1 = view;
            }
        } else
        {
            viewgroup = view1;
            view1 = view;
            if (l == 0)
            {
                viewgroup = (PreviewFillColorDrawable)view.getTag();
                view1 = view;
            }
        }
        if (viewgroup != null && l == 0)
        {
            j = sizes[i];
            boolean flag;
            if (DrawingPanel.access$700(DrawingPanel.this) == i)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            viewgroup.setSelected(flag);
            viewgroup.setColor(j);
            try
            {
                view1.setContentDescription((new StringBuilder()).append(mColorContentDescription).append(" ").append(Integer.toHexString(j)).toString());
            }
            // Misplaced declaration of an exception variable
            catch (View view) { }
        } else
        if (l == 2 && FeatherActivity.MATURITY.isKidsFriendly())
        {
            if (i == DrawingPanel.access$700(DrawingPanel.this))
            {
                view1.findViewById(com.aviary.android.feather.sdk.dapter.this._fld0).setVisibility(0);
                view1.findViewById(com.aviary.android.feather.sdk.dapter.this._fld0).setVisibility(8);
            } else
            {
                view1.findViewById(com.aviary.android.feather.sdk.dapter.this._fld0).setVisibility(8);
                view1.findViewById(com.aviary.android.feather.sdk.dapter.this._fld0).setVisibility(0);
            }
        }
        view1.setId(i);
        return view1;
    }

    public int getViewTypeCount()
    {
        return 3;
    }

    public (Context context, int ai[])
    {
        this$0 = DrawingPanel.this;
        super();
        mLayoutInflater = LayoutInflater.from(context);
        sizes = ai;
        mRes = context.getResources();
    }
}
