// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import bqo;
import bqp;
import bqr;
import bqs;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.wantu.view:
//            HorizontalListView

public class TMagFilterListScrollView2 extends HorizontalListView
{

    private static final String TAG = "TMagFilterListScrollView";
    private List items;
    private bqr mCallback;
    private int mCurSelectedIndex;
    private View mCurSelectedItem;

    public TMagFilterListScrollView2(Context context)
    {
        super(context, null);
        items = new ArrayList();
        mCurSelectedIndex = -1;
        init();
    }

    public TMagFilterListScrollView2(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        items = new ArrayList();
        mCurSelectedIndex = -1;
        init();
    }

    private final void init()
    {
        setOnItemClickListener(new bqo(this));
    }

    public void addFilterItem(int i, String s)
    {
        bqs bqs1 = new bqs(this);
        bqs1.a = i;
        bqs1.b = s;
        if (items != null)
        {
            items.add(bqs1);
        }
        s = new bqs[items.size()];
        for (i = 0; i < items.size(); i++)
        {
            s[i] = (bqs)items.get(i);
        }

        setAdapter(new bqp(this, getContext(), s));
    }

    public void cancelSelected()
    {
        if (mCurSelectedItem != null)
        {
            mCurSelectedItem.setSelected(false);
            mCurSelectedItem = null;
        }
    }

    public int getItemCount()
    {
        int i = 0;
        if (items != null)
        {
            i = items.size();
        }
        return i;
    }

    public void setCallback(bqr bqr)
    {
        mCallback = bqr;
    }

    public void setItemSelected(int i, Boolean boolean1)
    {
    }



/*
    public static int access$102(TMagFilterListScrollView2 tmagfilterlistscrollview2, int i)
    {
        tmagfilterlistscrollview2.mCurSelectedIndex = i;
        return i;
    }

*/



/*
    public static View access$302(TMagFilterListScrollView2 tmagfilterlistscrollview2, View view)
    {
        tmagfilterlistscrollview2.mCurSelectedItem = view;
        return view;
    }

*/

}
