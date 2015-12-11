// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.Application;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Stack;

// Referenced classes of package com.groupon.util:
//            DeviceInfoUtil

public class LayoutUtil
{

    private Application application;
    private DeviceInfoUtil deviceInfoUtil;

    public LayoutUtil()
    {
    }

    public void alignStartEndViews(View view, View view1)
    {
        if ((view.getLayoutParams() instanceof android.widget.RelativeLayout.LayoutParams) && (view1.getLayoutParams() instanceof android.widget.RelativeLayout.LayoutParams))
        {
            view = (android.widget.RelativeLayout.LayoutParams)view.getLayoutParams();
            int i;
            if (deviceInfoUtil.isRTLLanguage())
            {
                i = 1;
            } else
            {
                i = 0;
            }
            view.addRule(i, view1.getId());
        }
    }

    public void alignViewBaselines(View view, View view1)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)view.getLayoutParams();
        layoutparams.addRule(4, view1.getId());
        view.setLayoutParams(layoutparams);
    }

    public boolean isLandscape()
    {
        return application.getResources().getBoolean(0x7f090006);
    }

    public void reverseLinearLayoutOnRtl(LinearLayout linearlayout)
    {
        if (linearlayout != null && deviceInfoUtil.isRTLLanguage())
        {
            Stack stack = new Stack();
            for (int i = 0; i < linearlayout.getChildCount(); i++)
            {
                stack.push(linearlayout.getChildAt(i));
            }

            linearlayout.removeAllViews();
            while (!stack.isEmpty()) 
            {
                linearlayout.addView((View)stack.pop());
            }
        }
    }

    public void setDrawableStart(TextView textview, int i)
    {
        if (textview == null)
        {
            return;
        }
        boolean flag = deviceInfoUtil.isRTLLanguage();
        int j;
        if (flag)
        {
            j = 0;
        } else
        {
            j = i;
        }
        if (!flag)
        {
            i = 0;
        }
        textview.setCompoundDrawablesWithIntrinsicBounds(j, 0, i, 0);
    }

    public void setGravityEnd(View view)
    {
        if (view != null)
        {
            boolean flag = deviceInfoUtil.isRTLLanguage();
            android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
            if (layoutparams instanceof android.widget.RelativeLayout.LayoutParams)
            {
                view = (android.widget.RelativeLayout.LayoutParams)view.getLayoutParams();
                byte byte0;
                if (flag)
                {
                    byte0 = 9;
                } else
                {
                    byte0 = 11;
                }
                view.addRule(byte0);
                return;
            }
            if (layoutparams instanceof android.widget.LinearLayout.LayoutParams)
            {
                view = (android.widget.LinearLayout.LayoutParams)view.getLayoutParams();
                int i;
                if (flag)
                {
                    i = 3;
                } else
                {
                    i = 5;
                }
                view.gravity = i;
                return;
            }
        }
    }

    public void setGravityStart(View view)
    {
        if (view != null)
        {
            boolean flag = deviceInfoUtil.isRTLLanguage();
            android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
            if (layoutparams instanceof android.widget.RelativeLayout.LayoutParams)
            {
                view = (android.widget.RelativeLayout.LayoutParams)view.getLayoutParams();
                byte byte0;
                if (flag)
                {
                    byte0 = 11;
                } else
                {
                    byte0 = 9;
                }
                view.addRule(byte0);
                return;
            }
            if (layoutparams instanceof android.widget.LinearLayout.LayoutParams)
            {
                view = (android.widget.LinearLayout.LayoutParams)view.getLayoutParams();
                int i;
                if (flag)
                {
                    i = 5;
                } else
                {
                    i = 3;
                }
                view.gravity = i;
                return;
            }
        }
    }

    public void setStartViewEndView(View view, View view1)
    {
        if (view != null && view1 != null)
        {
            alignStartEndViews(view, view1);
            setViewStartEndPadding(view, 0, (int)application.getResources().getDimension(0x7f0b00cb));
        }
    }

    public void setViewStartEndPadding(View view, int i, int j)
    {
        if (view != null)
        {
            boolean flag = deviceInfoUtil.isRTLLanguage();
            int k;
            if (flag)
            {
                k = j;
            } else
            {
                k = i;
            }
            if (!flag)
            {
                i = j;
            }
            view.setPadding(k, 0, i, 0);
        }
    }
}
