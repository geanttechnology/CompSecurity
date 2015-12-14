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
//            TextPanel

class mRes extends BaseAdapter
{

    private static final int INVALID_POSITION = 1;
    private static final int VALID_POSITION = 0;
    LayoutInflater mLayoutInflater;
    Resources mRes;
    private int sizes[];
    final TextPanel this$0;

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
        boolean flag1 = true;
        int k = getItemViewType(i);
        viewgroup = null;
        View view1;
        if (view == null)
        {
            view = mLayoutInflater;
            int j;
            if (FeatherActivity.MATURITY.isKidsFriendly())
            {
                j = com.aviary.android.feather.sdk.tem_view_freetime_row2;
            } else
            {
                j = com.aviary.android.feather.sdk.tem_view;
            }
            view = view.inflate(j, TextPanel.access$100(TextPanel.this), false);
            view1 = view;
            if (k == 0)
            {
                viewgroup = getContext().getBaseContext();
                if (FeatherActivity.MATURITY.isKidsFriendly())
                {
                    viewgroup = new PreviewFillColorFreetime(viewgroup);
                } else
                {
                    viewgroup = new PreviewFillColorDrawable(viewgroup);
                }
                ((ImageView)view.findViewById(com.aviary.android.feather.sdk.Drawable)).setImageDrawable(viewgroup);
                view.setTag(viewgroup);
                view1 = view;
            }
        } else
        {
            view1 = view;
            if (k == 0)
            {
                viewgroup = (PreviewFillColorDrawable)view.getTag();
                view1 = view;
            }
        }
        if (viewgroup != null && k == 0)
        {
            j = sizes[i];
            boolean flag;
            if (i == TextPanel.access$200(TextPanel.this))
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
        }
        if (TextPanel.access$200(TextPanel.this) == i)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        view1.setSelected(flag);
        view1.setId(i);
        return view1;
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    public e(Context context, int ai[])
    {
        this$0 = TextPanel.this;
        super();
        mLayoutInflater = LayoutInflater.from(context);
        sizes = ai;
        mRes = context.getResources();
    }
}
