// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.hubitem;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.ebay.mobile.sell.HubDisplayState;

// Referenced classes of package com.ebay.mobile.sell.hubitem:
//            CustomHubItem

public class PhotosHubItem extends CustomHubItem
{

    public PhotosHubItem(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public int getEmptyResource()
    {
        return 0x7f0709ad;
    }

    public int getLabelResource()
    {
        return 0x7f070588;
    }

    public void setDisplayFromState(HubDisplayState hubdisplaystate, boolean flag)
    {
        int i = hubdisplaystate.photoCountValue;
        setStatusIndicator(flag);
        if (flag)
        {
            setCellValue(getResources().getQuantityString(0x7f08002b, i, new Object[] {
                Integer.valueOf(i)
            }));
            return;
        } else
        {
            setCellValue(null);
            return;
        }
    }
}
