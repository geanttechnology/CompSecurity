// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.text.TextUtils;
import com.ebay.common.Preferences;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.mobile.activities:
//            UserDetailActivity, SignInModalActivity

private class <init> extends com.ebay.mobile.viewitem.server
{

    final UserDetailActivity this$0;

    public void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, com.ebay.mobile.viewitem.r r, boolean flag)
    {
        if (!isFinishing())
        {
            if (viewItemDataManager == null)
            {
                viewItemDataManager = viewitemdatamanager;
            }
            if (!content.getStatus().hasError())
            {
                item = (Item)content.getData();
                initUIState();
                viewitemdatamanager = MyApp.getPrefs().getAuthentication();
                if ((requireSignIn || TextUtils.isEmpty(userId)) && viewitemdatamanager == null)
                {
                    viewitemdatamanager = SignInModalActivity.getIntentForSignIn(getTrackingEventName(), UserDetailActivity.this);
                    startActivityForResult(viewitemdatamanager, 65);
                    return;
                }
                fillUIDetails();
                if (!userProfileLoading)
                {
                    showUserProfile();
                    return;
                }
            } else
            {
                EbayErrorHandler.handleResultStatus(UserDetailActivity.this, 0, content.getStatus());
                return;
            }
        }
    }

    private rver()
    {
        this$0 = UserDetailActivity.this;
        super();
    }

    rver(rver rver)
    {
        this();
    }
}
