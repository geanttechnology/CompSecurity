// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.hubitem;

import android.content.Context;
import android.util.AttributeSet;
import com.ebay.mobile.sell.HubDisplayState;

// Referenced classes of package com.ebay.mobile.sell.hubitem:
//            CustomHubItem

public class TitleHubItem extends CustomHubItem
{

    public TitleHubItem(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public int getLabelResource()
    {
        return 0x7f0709da;
    }

    protected int maximumAllowedContentLines()
    {
        return 2;
    }

    public void setDisplayFromState(HubDisplayState hubdisplaystate, boolean flag)
    {
        setStatusIndicator(flag);
        setCellValue(hubdisplaystate.titleValue, hubdisplaystate.subtitleValue, false);
    }
}
