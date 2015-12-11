// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SearchHistoryHeader extends LinearLayout
    implements android.view.View.OnClickListener
{
    public static interface a
    {

        public abstract void a();
    }

    static class b extends com.target.ui.view.a
    {

        final Button clearBtn;
        final TextView title;

        b(View view)
        {
            super(view);
            title = (TextView)view.findViewById(0x7f1005a0);
            clearBtn = (Button)view.findViewById(0x7f1005a1);
        }
    }


    private a mListener;
    private b mViews;

    public SearchHistoryHeader(Context context)
    {
        super(context);
        a();
    }

    public SearchHistoryHeader(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    private void a()
    {
        inflate(getContext(), 0x7f0301ea, this);
        mViews = new b(this);
        mViews.clearBtn.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        if (mListener == null)
        {
            return;
        }
        switch (view.getId())
        {
        default:
            return;

        case 2131756449: 
            mListener.a();
            break;
        }
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }
}
