// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;

import android.text.TextUtils;

// Referenced classes of package com.ebay.mobile.common:
//            SimpleRefineFragment

public static abstract class titleWithCount extends el
{

    private boolean isEnabled;
    private boolean isSelected;
    private String titleWithCount;
    private final String titleWithoutCount;

    public boolean equals(Object obj)
    {
        if (!(obj instanceof el))
        {
            return false;
        } else
        {
            return TextUtils.equals(((el)obj).getStringIdentifier(), getStringIdentifier());
        }
    }

    public abstract String getStringIdentifier();

    public String getTitle()
    {
        return titleWithCount;
    }

    public int hashCode()
    {
        String s = getStringIdentifier();
        if (s == null)
        {
            return super.hashCode();
        } else
        {
            return s.hashCode();
        }
    }

    public abstract boolean isDefaultRefinement();

    public boolean isEnabled()
    {
        return isEnabled;
    }

    protected boolean isSelected()
    {
        return isSelected;
    }

    protected final void setSelectionState(boolean flag)
    {
        isSelected = flag;
    }

    public void updateTitleWithCount(int i)
    {
        titleWithCount = (new StringBuilder()).append(titleWithoutCount).append(" (").append(i).append(")").toString();
        boolean flag;
        if (i != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isEnabled = flag;
    }

    public el(String s)
    {
        isEnabled = true;
        isSelected = false;
        titleWithoutCount = s;
        titleWithCount = s;
    }
}
