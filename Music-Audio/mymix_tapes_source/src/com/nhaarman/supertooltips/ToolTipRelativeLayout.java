// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.supertooltips;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import com.nhaarman.supertooltips.exception.NoOverflowMenuRuntimeException;
import com.nhaarman.supertooltips.exception.NoTitleViewRuntimeException;
import com.nhaarman.supertooltips.exception.ViewNotFoundRuntimeException;

// Referenced classes of package com.nhaarman.supertooltips:
//            ToolTipView, ToolTip

public class ToolTipRelativeLayout extends RelativeLayout
{

    public static final String ACTION_BAR = "action_bar";
    public static final String ACTION_BAR_TITLE = "action_bar_title";
    public static final String ACTION_MENU_VIEW = "ActionMenuView";
    public static final String ANDROID = "android";
    public static final String ID = "id";
    public static final String OVERFLOW_MENU_BUTTON = "OverflowMenuButton";

    public ToolTipRelativeLayout(Context context)
    {
        super(context);
    }

    public ToolTipRelativeLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public ToolTipRelativeLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    private static View findActionBarOverflowMenuView(Activity activity)
    {
        Object obj = (ViewGroup)((ViewGroup)activity.getWindow().getDecorView()).findViewById(Resources.getSystem().getIdentifier("action_bar", "id", "android"));
        activity = null;
        int k = ((ViewGroup) (obj)).getChildCount();
        for (int i = 0; i < k; i++)
        {
            if (((ViewGroup) (obj)).getChildAt(i).getClass().getSimpleName().equals("ActionMenuView"))
            {
                activity = (ViewGroup)((ViewGroup) (obj)).getChildAt(i);
            }
        }

        if (activity == null)
        {
            throw new NoOverflowMenuRuntimeException();
        }
        k = activity.getChildCount();
        obj = null;
        for (int j = 0; j < k; j++)
        {
            if (activity.getChildAt(j).getClass().getSimpleName().equals("OverflowMenuButton"))
            {
                obj = activity.getChildAt(j);
            }
        }

        if (obj == null)
        {
            throw new NoOverflowMenuRuntimeException();
        } else
        {
            return ((View) (obj));
        }
    }

    public ToolTipView showToolTipForActionBarHome(Activity activity, ToolTip tooltip)
    {
        return showToolTipForViewResId(activity, tooltip, 0x102002c);
    }

    public ToolTipView showToolTipForActionBarOverflowMenu(Activity activity, ToolTip tooltip)
    {
        return showToolTipForView(tooltip, findActionBarOverflowMenuView(activity));
    }

    public ToolTipView showToolTipForActionBarTitle(Activity activity, ToolTip tooltip)
    {
        int i = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        if (i == 0)
        {
            throw new NoTitleViewRuntimeException();
        } else
        {
            return showToolTipForViewResId(activity, tooltip, i);
        }
    }

    public ToolTipView showToolTipForView(ToolTip tooltip, View view)
    {
        ToolTipView tooltipview = new ToolTipView(getContext());
        tooltipview.setToolTip(tooltip, view);
        addView(tooltipview);
        return tooltipview;
    }

    public ToolTipView showToolTipForViewResId(Activity activity, ToolTip tooltip, int i)
    {
        ToolTipView tooltipview = new ToolTipView(getContext());
        activity = activity.getWindow().getDecorView().findViewById(i);
        if (activity == null)
        {
            throw new ViewNotFoundRuntimeException();
        } else
        {
            tooltipview.setToolTip(tooltip, activity);
            addView(tooltipview);
            return tooltipview;
        }
    }
}
