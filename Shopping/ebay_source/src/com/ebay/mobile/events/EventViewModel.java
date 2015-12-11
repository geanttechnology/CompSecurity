// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.events;

import android.text.TextUtils;
import com.ebay.mobile.common.view.ViewModel;
import java.util.Date;

public class EventViewModel extends ViewModel
{

    public final Date endDate;
    public final String eventGroupId;
    public final String eventId;
    public String image;
    public final com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.RppEvent rppEvent;
    public final boolean showTimer;
    public final String title;

    public EventViewModel(int i, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.RppEvent rppevent, String s, boolean flag, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        rppEvent = rppevent;
        if (rppevent == null)
        {
            title = null;
            endDate = null;
            showTimer = false;
            eventId = null;
            eventGroupId = null;
            return;
        }
        showTimer = rppevent.showTimer.booleanValue();
        endDate = rppevent.endDate;
        title = rppevent.displayName;
        image = "";
        if (!flag || TextUtils.isEmpty(rppevent.mobileAppHeroImageUrl)) goto _L2; else goto _L1
_L1:
        image = rppevent.mobileAppHeroImageUrl;
_L4:
        if (!TextUtils.isEmpty(rppevent.skinnyHeroImageUrl) && (TextUtils.isEmpty(image) || i == 1))
        {
            image = rppevent.skinnyHeroImageUrl;
        }
        eventId = rppevent.eventId;
        eventGroupId = s;
        return;
_L2:
        image = rppevent.mobileAppBannerImageUrl;
        if (TextUtils.isEmpty(image))
        {
            image = rppevent.mobileAppHeroImageUrl;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
