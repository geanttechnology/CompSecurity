// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.hubitem;

import android.content.Context;
import android.util.AttributeSet;
import com.ebay.mobile.sell.HubDisplayState;

// Referenced classes of package com.ebay.mobile.sell.hubitem:
//            CustomHubItem

public class ConditionHubItem extends CustomHubItem
{

    public ConditionHubItem(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public int getLabelResource()
    {
        return 0x7f0709d4;
    }

    public void setDisplayFromState(HubDisplayState hubdisplaystate, boolean flag)
    {
        String s = hubdisplaystate.conditionValue;
        int i;
        if (hubdisplaystate.conditionVisible)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        setVisibility(i);
        setStatusIndicator(flag);
        setCellValue(s);
    }
}
