// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.AbsListView;
import com.comcast.cim.utils.UIPresentationUtil;
import it.sephiroth.android.library.widget.AbsHListView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AccessibilityUtil
{
    protected class AccessibleOnHorizontalScrollListener
        implements it.sephiroth.android.library.widget.AbsHListView.OnScrollListener
    {

        private String description;

        public void onScroll(AbsHListView abshlistview, int i, int j, int k)
        {
            String s = UIPresentationUtil.getAbsListStateDescription(abshlistview, description, i, j, k);
            if (abshlistview.getTag() != null)
            {
                abshlistview.setContentDescription(s);
            }
        }

        public void onScrollStateChanged(AbsHListView abshlistview, int i)
        {
        }

        public void setDescription(String s)
        {
            description = s;
        }
    }

    protected class AccessibleOnScrollListener
        implements android.widget.AbsListView.OnScrollListener
    {

        private String description;
        final AccessibilityUtil this$0;

        public void onScroll(AbsListView abslistview, int i, int j, int k)
        {
            String s = UIPresentationUtil.getAbsListStateDescription(abslistview, description, i, j, k);
            if (abslistview.getTag() != null)
            {
                abslistview.setContentDescription(s);
            }
        }

        public void onScrollStateChanged(AbsListView abslistview, int i)
        {
        }

        public void setDescription(String s)
        {
            description = s;
        }

        protected AccessibleOnScrollListener()
        {
            this$0 = AccessibilityUtil.this;
            super();
        }
    }


    final AccessibilityManager accessibilityManager;

    public AccessibilityUtil(AccessibilityManager accessibilitymanager)
    {
        accessibilityManager = accessibilitymanager;
    }

    private boolean isTalkbackRunning()
    {
        for (Iterator iterator = accessibilityManager.getEnabledAccessibilityServiceList(-1).iterator(); iterator.hasNext();)
        {
            if (((AccessibilityServiceInfo)iterator.next()).getId().equals("com.google.android.marvin.talkback/.TalkBackService"))
            {
                return true;
            }
        }

        return false;
    }

    public boolean isAccessibilityEnabled()
    {
        return accessibilityManager.isEnabled() && isTalkbackRunning();
    }

    public void setImportantForAccessibility(View view, int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            view.setImportantForAccessibility(i);
        }
    }

    public void setupAccessibleScrollListener(AbsListView abslistview, String s)
    {
        AccessibleOnScrollListener accessibleonscrolllistener = new AccessibleOnScrollListener();
        accessibleonscrolllistener.setDescription(s);
        abslistview.setOnScrollListener(accessibleonscrolllistener);
    }

    public void toggleScreenFocus(HashMap hashmap, ViewGroup viewgroup, ViewGroup viewgroup1, boolean flag, boolean flag1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            if (viewgroup == viewgroup1 && flag)
            {
                hashmap.clear();
            }
            int i = 0;
            while (i < viewgroup1.getChildCount()) 
            {
                View view = viewgroup1.getChildAt(i);
                if (flag)
                {
                    hashmap.put(view, Integer.valueOf(view.getImportantForAccessibility()));
                    view.setImportantForAccessibility(2);
                } else
                {
                    try
                    {
                        view.setImportantForAccessibility(((Integer)hashmap.get(view)).intValue());
                    }
                    catch (Exception exception) { }
                }
                if (view instanceof ViewGroup)
                {
                    toggleScreenFocus(hashmap, viewgroup, (ViewGroup)view, flag, false);
                }
                if (viewgroup == viewgroup1 && i == 0)
                {
                    if (flag)
                    {
                        if (flag1)
                        {
                            view.setFocusable(true);
                            view.setFocusableInTouchMode(true);
                            setImportantForAccessibility(view, 1);
                            view.setContentDescription(viewgroup.getContext().getString(com.comcast.cim.android.R.string.content_description_close_menu_instructions));
                        }
                    } else
                    {
                        view.setContentDescription(null);
                        setImportantForAccessibility(view, 2);
                        hashmap.clear();
                    }
                }
                i++;
            }
        }
    }
}
