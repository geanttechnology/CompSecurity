// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.scan;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

public class ScanHeaderView extends RelativeLayout
{
    private static class a
    {

        private View addItemEditText;

        static View a(a a1)
        {
            return a1.addItemEditText;
        }

        public a(View view)
        {
            addItemEditText = view.findViewById(0x7f100592);
        }
    }


    private ScanSummaryView.a mListener;
    private a mViews;

    public ScanHeaderView(Context context)
    {
        super(context);
        a(context);
    }

    public ScanHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public ScanHeaderView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    static ScanSummaryView.a a(ScanHeaderView scanheaderview)
    {
        return scanheaderview.mListener;
    }

    private void a(Context context)
    {
        mViews = new a(LayoutInflater.from(context).inflate(0x7f0301e4, this, true));
        a.a(mViews).setOnClickListener(new android.view.View.OnClickListener() {

            final ScanHeaderView this$0;

            public void onClick(View view)
            {
                if (ScanHeaderView.a(ScanHeaderView.this) == null)
                {
                    return;
                } else
                {
                    ScanHeaderView.a(ScanHeaderView.this).c();
                    return;
                }
            }

            
            {
                this$0 = ScanHeaderView.this;
                super();
            }
        });
    }

    public void setScanListener(ScanSummaryView.a a1)
    {
        mListener = a1;
    }
}
