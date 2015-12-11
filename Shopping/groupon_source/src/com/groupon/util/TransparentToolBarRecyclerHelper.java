// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.TypedValue;
import android.widget.TextView;

// Referenced classes of package com.groupon.util:
//            DeviceInfoUtil

public class TransparentToolBarRecyclerHelper
{

    private ActionBar actionBar;
    private ColorDrawable actionBarBackgroundDrawable;
    private int currentTotalY;
    private int dealImageHeight;
    DeviceInfoUtil deviceInfoUtil;
    private TextView toolbarTitleText;

    public TransparentToolBarRecyclerHelper()
    {
    }

    public void adjustToolbarTransparency(int i)
    {
        currentTotalY = currentTotalY + i;
        i = dealImageHeight - actionBar.getHeight();
        float f;
        if (i > 0)
        {
            f = (float)Math.min(Math.max(currentTotalY, 0), i) / (float)i;
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

    public void initToolBar(ActionBarActivity actionbaractivity, float f)
    {
        actionBar = actionbaractivity.getSupportActionBar();
        dealImageHeight = (int)TypedValue.applyDimension(1, f, deviceInfoUtil.getDisplayMetrics());
        actionBarBackgroundDrawable = new ColorDrawable(actionbaractivity.getResources().getColor(0x7f0e000d));
        toolbarTitleText = (TextView)actionbaractivity.findViewById(0x7f100562);
        actionBarBackgroundDrawable.setAlpha(0);
        actionBar.setBackgroundDrawable(actionBarBackgroundDrawable);
        toolbarTitleText.setAlpha(0.0F);
    }
}
