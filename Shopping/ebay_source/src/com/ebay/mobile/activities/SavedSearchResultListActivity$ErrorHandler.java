// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.shell.app.BaseActivity;

// Referenced classes of package com.ebay.mobile.activities:
//            SavedSearchResultListActivity

private static final class allowRetry extends EbayErrorHandler
{

    public final boolean allowRetry;
    public boolean wasRetry;

    protected void onNetworkError(EbayResponseError ebayresponseerror)
    {
        if (allowRetry)
        {
            wasRetry = true;
            activity.showDialog(0x7f070151);
            return;
        } else
        {
            super.onNetworkError(ebayresponseerror);
            return;
        }
    }

    public (BaseActivity baseactivity, boolean flag)
    {
        super(baseactivity, false, true);
        wasRetry = false;
        allowRetry = flag;
    }
}
