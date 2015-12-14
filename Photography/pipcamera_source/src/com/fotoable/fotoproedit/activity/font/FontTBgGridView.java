// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import ew;
import ha;
import hn;
import ho;
import java.util.ArrayList;
import ub;

// Referenced classes of package com.fotoable.fotoproedit.activity.font:
//            FontOnlineInfo

public class FontTBgGridView extends GridView
{

    private boolean NoScroll;
    private ho mAdapter;
    private ha mImageWorker;
    private hn mListener;

    public FontTBgGridView(Context context)
    {
        super(context);
        NoScroll = false;
        init();
    }

    public FontTBgGridView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        NoScroll = false;
        init();
    }

    public void init()
    {
        int i = ew.a(getContext(), 6F);
        setVerticalSpacing(i);
        setHorizontalSpacing(i / 2);
        setNumColumns(3);
        setSelector(new ColorDrawable(0));
        mAdapter = new ho(this);
        setAdapter(mAdapter);
        setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final FontTBgGridView a;

            public void onItemClick(AdapterView adapterview, View view, int j, long l)
            {
                if (j < a.mAdapter.a().size())
                {
                    adapterview = (FontOnlineInfo)a.mAdapter.a().get(j);
                    break MISSING_BLOCK_LABEL_35;
                }
                do
                {
                    return;
                } while (a.getContext() != null && (new ub(a.getContext(), adapterview)).a() || a.mListener == null);
                a.mListener.a(adapterview);
            }

            
            {
                a = FontTBgGridView.this;
                super();
            }
        });
    }

    public void onMeasure(int i, int j)
    {
        if (NoScroll)
        {
            super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec(0x1fffffff, 0x80000000));
            return;
        } else
        {
            super.onMeasure(i, j);
            return;
        }
    }

    public void refreshData()
    {
        mAdapter.notifyDataSetChanged();
    }

    public void setData(ArrayList arraylist)
    {
        if (mAdapter != null)
        {
            mAdapter.a(arraylist);
        }
    }

    public void setImageWorker(ha ha)
    {
        mImageWorker = ha;
    }

    public void setListener(hn hn)
    {
        mListener = hn;
    }

    public void setNoScroll(boolean flag)
    {
        NoScroll = flag;
    }



}
