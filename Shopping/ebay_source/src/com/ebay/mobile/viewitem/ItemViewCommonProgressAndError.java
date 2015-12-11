// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Activity;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.NetworkUtil;
import com.ebay.nautilus.shell.app.BaseActivity;

public class ItemViewCommonProgressAndError
{
    public static final class LayoutState extends Enum
    {

        private static final LayoutState $VALUES[];
        public static final LayoutState CONNECTION_ERROR;
        public static final LayoutState CUSTOM_ERROR;
        public static final LayoutState NORMAL;
        public static final LayoutState PROGRESS;
        public static final LayoutState SERVICE_ERROR;
        public static final LayoutState TRANSLUCENT_PROGRESS;

        public static LayoutState valueOf(String s)
        {
            return (LayoutState)Enum.valueOf(com/ebay/mobile/viewitem/ItemViewCommonProgressAndError$LayoutState, s);
        }

        public static LayoutState[] values()
        {
            return (LayoutState[])$VALUES.clone();
        }

        static 
        {
            NORMAL = new LayoutState("NORMAL", 0);
            PROGRESS = new LayoutState("PROGRESS", 1);
            TRANSLUCENT_PROGRESS = new LayoutState("TRANSLUCENT_PROGRESS", 2);
            CONNECTION_ERROR = new LayoutState("CONNECTION_ERROR", 3);
            SERVICE_ERROR = new LayoutState("SERVICE_ERROR", 4);
            CUSTOM_ERROR = new LayoutState("CUSTOM_ERROR", 5);
            $VALUES = (new LayoutState[] {
                NORMAL, PROGRESS, TRANSLUCENT_PROGRESS, CONNECTION_ERROR, SERVICE_ERROR, CUSTOM_ERROR
            });
        }

        private LayoutState(String s, int i)
        {
            super(s, i);
        }
    }


    public ItemViewCommonProgressAndError()
    {
    }

    private static ViewGroup findLayout(ViewGroup viewgroup, Activity activity, int i)
    {
        ViewGroup viewgroup1 = null;
        if (viewgroup != null)
        {
            viewgroup1 = (ViewGroup)viewgroup.findViewById(i);
        }
        viewgroup = viewgroup1;
        if (viewgroup1 == null)
        {
            viewgroup = viewgroup1;
            if (activity != null)
            {
                viewgroup = (ViewGroup)activity.findViewById(i);
            }
        }
        return viewgroup;
    }

    public static Button setOkNotRetry(Activity activity)
    {
        activity = (ViewGroup)activity.findViewById(0x7f10013c);
        activity.findViewById(0x7f10013f).setVisibility(8);
        activity = (Button)activity.findViewById(0x7f100140);
        activity.setVisibility(0);
        return activity;
    }

    public static void setPrimaryErrorMessage(Activity activity, String s)
    {
        activity = (TextView)((ViewGroup)activity.findViewById(0x7f10013c)).findViewById(0x7f10013d);
        activity.setMovementMethod(LinkMovementMethod.getInstance());
        activity.setText(Html.fromHtml(s));
    }

    public static void setSecondaryErrorMessage(Activity activity, String s)
    {
        ((TextView)((ViewGroup)activity.findViewById(0x7f10013c)).findViewById(0x7f10013e)).setText(s);
    }

    public static void showLayouts(Activity activity, ViewGroup viewgroup, LayoutState layoutstate)
    {
        showLayouts(activity, viewgroup, layoutstate, true);
    }

    public static void showLayouts(Activity activity, ViewGroup viewgroup, LayoutState layoutstate, boolean flag)
    {
        boolean flag1 = false;
        if (activity != null || viewgroup != null)
        {
            ViewGroup viewgroup1 = findLayout(viewgroup, activity, 0x7f100016);
            if (viewgroup1 != null && LayoutState.NORMAL == layoutstate)
            {
                viewgroup1.setVisibility(0);
            }
            ViewGroup viewgroup2 = findLayout(viewgroup, activity, 0x7f100148);
            int i;
            if (viewgroup2 != null)
            {
                View view = viewgroup2.findViewById(0x7f100149);
                if (view != null)
                {
                    if (flag)
                    {
                        i = 0;
                    } else
                    {
                        i = 8;
                    }
                    view.setVisibility(i);
                }
                if (LayoutState.TRANSLUCENT_PROGRESS == layoutstate)
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                viewgroup2.setVisibility(i);
                viewgroup2.setOnClickListener(new android.view.View.OnClickListener() {

                    public void onClick(View view1)
                    {
                    }

                });
            }
            viewgroup2 = findLayout(viewgroup, activity, 0x7f100143);
            if (viewgroup2 != null)
            {
                view = viewgroup2.findViewById(0x7f100144);
                if (view != null)
                {
                    if (flag)
                    {
                        i = 0;
                    } else
                    {
                        i = 8;
                    }
                    view.setVisibility(i);
                }
                if (LayoutState.PROGRESS == layoutstate)
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                viewgroup2.setVisibility(i);
            }
            viewgroup = findLayout(viewgroup, activity, 0x7f10013c);
            if (viewgroup != null)
            {
                TextView textview = (TextView)viewgroup.findViewById(0x7f10013d);
                TextView textview1 = (TextView)viewgroup.findViewById(0x7f10013e);
                if (layoutstate == LayoutState.SERVICE_ERROR && activity != null && viewgroup1 != null)
                {
                    viewgroup.setVisibility(0);
                    textview.setText(activity.getString(0x7f070a4f));
                    i = ((flag1) ? 1 : 0);
                    if (TextUtils.isEmpty(textview1.getText()))
                    {
                        i = 8;
                    }
                    textview1.setVisibility(i);
                    viewgroup1.setVisibility(8);
                    return;
                }
                if (layoutstate == LayoutState.CONNECTION_ERROR && activity != null && viewgroup1 != null)
                {
                    viewgroup.setVisibility(0);
                    textview.setText(activity.getString(0x7f070265));
                    textview1.setVisibility(8);
                    viewgroup1.setVisibility(8);
                    return;
                }
                if (layoutstate == LayoutState.CUSTOM_ERROR && viewgroup1 != null)
                {
                    viewgroup.setVisibility(0);
                    textview1.setVisibility(8);
                    viewgroup1.setVisibility(8);
                    return;
                } else
                {
                    viewgroup.setVisibility(8);
                    return;
                }
            }
        }
    }

    public static void showLayouts(Activity activity, LayoutState layoutstate)
    {
        showLayouts(activity, null, layoutstate);
    }

    public static LayoutState updateLayoutForLoaderError(BaseActivity baseactivity, EbaySimpleNetLoader ebaysimplenetloader)
    {
        return updateLayoutForLoaderError(baseactivity, ebaysimplenetloader.getResultStatus());
    }

    public static LayoutState updateLayoutForLoaderError(BaseActivity baseactivity, ResultStatus resultstatus)
    {
        if (NetworkUtil.isConnectionError(resultstatus))
        {
            return LayoutState.CONNECTION_ERROR;
        } else
        {
            setSecondaryErrorMessage(baseactivity, MyApp.getDisplayableServiceError(baseactivity.getEbayContext(), resultstatus));
            return LayoutState.SERVICE_ERROR;
        }
    }
}
