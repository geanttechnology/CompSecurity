// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.hubitem;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.ebay.mobile.sell.HubDisplayState;

// Referenced classes of package com.ebay.mobile.sell.hubitem:
//            CustomHubItem

public class PreferencesHubItem extends CustomHubItem
{

    public PreferencesHubItem(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public int getLabelResource()
    {
        return 0x7f0709d6;
    }

    protected int maximumAllowedContentLines()
    {
        return 2;
    }

    public void setDisplayFromState(HubDisplayState hubdisplaystate, boolean flag)
    {
        String s;
        String s1;
        String s2;
        boolean flag1;
        setStatusIndicator(flag);
        if (!TextUtils.isEmpty(hubdisplaystate.paymentValue))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        s = "";
        s2 = "";
        if (!hubdisplaystate.hasPaypal) goto _L2; else goto _L1
_L1:
        if (!TextUtils.isEmpty(hubdisplaystate.paypalEmail))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        s1 = getResources().getString(0x7f070770);
        s = s1;
        if (flag1)
        {
            s = (new StringBuilder()).append(s1).append(", ").append(hubdisplaystate.paypalEmail).toString();
        }
        s1 = hubdisplaystate.paymentValue;
_L4:
        setCellValue(s, s1, false, null, hubdisplaystate.returnsSummary);
        return;
_L2:
        s1 = s2;
        if (flag1)
        {
            s = hubdisplaystate.paymentValue;
            s1 = s2;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
