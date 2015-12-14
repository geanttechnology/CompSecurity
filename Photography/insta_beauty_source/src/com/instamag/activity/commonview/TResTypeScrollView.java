// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import azr;
import bdg;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.instamag.activity.commonview:
//            TResTypeItemView

public class TResTypeScrollView extends HorizontalScrollView
{

    private TResTypeItemView mCurSelectedItem;
    private LinearLayout mLayout;
    public azr mListener;
    List mResTypes;

    public TResTypeScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mResTypes = new ArrayList();
        mListener = null;
        mLayout = new LinearLayout(getContext());
        mLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        mLayout.setOrientation(0);
        setHorizontalScrollBarEnabled(false);
        addView(mLayout);
    }

    public void setScrollViewWithResTypes(List list, azr azr)
    {
        mResTypes = list;
        mListener = azr;
        if (list != null && list.size() > 0)
        {
            mLayout.removeAllViews();
            int i = 0;
            while (i < list.size()) 
            {
                azr = new TResTypeItemView(getContext(), (bdg)list.get(i), mListener);
                if (mCurSelectedItem == null)
                {
                    mCurSelectedItem = azr;
                    mCurSelectedItem.setSelected(true);
                }
                mLayout.addView(azr);
                i++;
            }
        }
    }

    public void setSelectedType(bdg bdg1)
    {
        if (mResTypes != null && mListener != null)
        {
            mLayout.removeAllViews();
            mCurSelectedItem = null;
            for (int i = 0; i < mResTypes.size(); i++)
            {
                TResTypeItemView trestypeitemview = new TResTypeItemView(getContext(), (bdg)mResTypes.get(i), mListener);
                if (((bdg)mResTypes.get(i)).a == bdg1.a)
                {
                    mCurSelectedItem = trestypeitemview;
                    mCurSelectedItem.setSelected(true);
                }
                mLayout.addView(trestypeitemview);
            }

        }
    }
}
