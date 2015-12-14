// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model.parsers;

import android.text.TextUtils;
import com.socialin.android.apiv3.model.BannerItem;
import java.util.Iterator;
import java.util.List;

public class BannerItemsFilter
{

    private boolean showButton;
    private boolean showMessage;
    private boolean showMessageTitle;

    public BannerItemsFilter()
    {
    }

    public void evaluateContentWrapping(List list)
    {
        showButton = false;
        showMessageTitle = false;
        showMessage = false;
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            BannerItem banneritem = (BannerItem)list.next();
            if (!TextUtils.isEmpty(banneritem.message))
            {
                showMessage = true;
            }
            if (!TextUtils.isEmpty(banneritem.messageTitle))
            {
                showMessageTitle = true;
            }
            if (banneritem.button != null)
            {
                showButton = true;
            }
        } while (true);
    }

    public boolean isBannerDataEmpty()
    {
        return !showButton && !showMessageTitle && !showMessage;
    }

    public boolean isButtonVisible()
    {
        return showButton;
    }

    public boolean isMsgTitleVisible()
    {
        return showMessageTitle;
    }

    public boolean isMsgVisible()
    {
        return showMessage;
    }
}
