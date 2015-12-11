// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.connection.myebay;


// Referenced classes of package com.ebay.mobile.connection.myebay:
//            BuyingFragment

private static class count
{

    int count;
    final int displayMode;
    final String displayText;
    boolean isSelected;
    final boolean showCount;

    public String getDropDownString()
    {
        if (showCount)
        {
            return (new StringBuilder()).append(displayText).append(" (").append(count).append(")").toString();
        } else
        {
            return displayText;
        }
    }

    public boolean isEnabled()
    {
        return !showCount || count > 0;
    }

    public String toString()
    {
        return displayText;
    }

    public (String s)
    {
        this(s, -1, false);
    }

    public <init>(String s, int i, boolean flag)
    {
        displayText = s;
        displayMode = i;
        showCount = flag;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isSelected = flag;
        count = 0;
    }
}
