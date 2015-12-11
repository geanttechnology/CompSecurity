// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.groupon.util.DeviceInfoUtil;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.view:
//            LocationBar

public class FilterBar extends LocationBar
{

    private DeviceInfoUtil deviceInfoUtil;

    public FilterBar(Context context)
    {
        this(context, null);
    }

    public FilterBar(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public FilterBar(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        deviceInfoUtil = (DeviceInfoUtil)RoboGuice.getInjector(context).getInstance(com/groupon/util/DeviceInfoUtil);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        buttonView.setVisibility(8);
        int i = (int)TypedValue.applyDimension(1, 19F, deviceInfoUtil.getDisplayMetrics());
        titleBar.setPadding(i, titleBar.getPaddingTop(), titleBar.getPaddingRight(), titleBar.getPaddingBottom());
    }

    public void setTextSize(float f)
    {
        textView.setTextSize(f);
    }
}
