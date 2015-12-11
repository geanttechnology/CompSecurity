// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import com.groupon.callbacks.OnToggleListener;

// Referenced classes of package com.groupon.view:
//            HeaderToggleView

public class HeaderTogglePresenter
{

    private HeaderToggleView headerToggle;
    private boolean isToggled;
    private OnToggleListener onToggleListener;
    private String title;

    public HeaderTogglePresenter(HeaderToggleView headertoggleview)
    {
        headerToggle = headertoggleview;
    }

    public String getTitle()
    {
        return title;
    }

    public boolean isToggled()
    {
        return isToggled;
    }

    public void setEnabled(boolean flag)
    {
        headerToggle.setEnabled(flag);
    }

    public void setOnToggleListener(OnToggleListener ontogglelistener)
    {
        onToggleListener = ontogglelistener;
    }

    public void setTitle(String s)
    {
        title = s;
        headerToggle.setTitle(s);
    }

    public void setToggle(boolean flag)
    {
        isToggled = flag;
        headerToggle.setToggled(flag);
    }

    public boolean toggle()
    {
        boolean flag;
        if (!isToggled)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isToggled = flag;
        if (onToggleListener != null)
        {
            onToggleListener.onToggle(isToggled);
        }
        return isToggled;
    }
}
