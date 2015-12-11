// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import com.groupon.view.ObservableScrollView;

public class TransparentToolBarHelper
{

    private ActionBar actionBar;
    private ColorDrawable actionBarBackgroundDrawable;
    private View dealImageView;
    private int headerHeight;
    private ObservableScrollView scrollView;
    private TextView toolbarTitleText;

    public TransparentToolBarHelper()
    {
    }

    protected void adjustToolbarTransparency(int i)
    {
        headerHeight = dealImageView.getHeight() - actionBar.getHeight();
        float f;
        if (headerHeight > 0)
        {
            f = (float)Math.min(Math.max(i, 0), headerHeight) / (float)headerHeight;
        } else
        {
            f = 0.0F;
        }
        i = (int)(255F * f);
        actionBarBackgroundDrawable.setAlpha(i);
        if (toolbarTitleText != null)
        {
            toolbarTitleText.setAlpha(f);
        }
    }

    public void initToolBar(ActionBarActivity actionbaractivity)
    {
        actionBar = actionbaractivity.getSupportActionBar();
        dealImageView = actionbaractivity.findViewById(0x7f1001df);
        actionBarBackgroundDrawable = new ColorDrawable(actionbaractivity.getResources().getColor(0x7f0e000d));
        toolbarTitleText = (TextView)actionbaractivity.findViewById(0x7f100562);
        scrollView = (ObservableScrollView)actionbaractivity.findViewById(0x7f1001bb);
        actionBarBackgroundDrawable.setAlpha(0);
        actionBar.setBackgroundDrawable(actionBarBackgroundDrawable);
        if (scrollView != null)
        {
            scrollView.setOnLayoutUpdatedListener(new com.groupon.view.ObservableScrollView.OnLayoutUpdatedListener() {

                final TransparentToolBarHelper this$0;

                public void onLayoutUpdated(boolean flag, int i, int j, int k, int l)
                {
                    adjustToolbarTransparency(scrollView.getScrollY());
                    scrollView.setOnLayoutUpdatedListener(null);
                }

            
            {
                this$0 = TransparentToolBarHelper.this;
                super();
            }
            });
            scrollView.addOnScrollChangedListener(new com.groupon.view.ObservableScrollView.OnScrollChangedListener() {

                final TransparentToolBarHelper this$0;

                public void onScrollChanged(ObservableScrollView observablescrollview, int i, int j, int k, int l)
                {
                    adjustToolbarTransparency(j);
                }

            
            {
                this$0 = TransparentToolBarHelper.this;
                super();
            }
            });
        }
    }

}
