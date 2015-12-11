// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import android.text.TextUtils;
import com.ebay.common.net.api.followinterest.CreateInterestLoadTask;
import com.ebay.common.net.api.followinterest.InterestDescriptor;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.common.content.dm:
//            FollowedEntityDataManager

class val.customTitle
    implements com.ebay.common.net.api.followinterest.tle
{

    final val.completionObserver this$1;
    final val.completionObserver val$completionObserver;
    final String val$customTitle;
    final SearchParameters val$params;

    public void handleInterestCreated(CreateInterestLoadTask createinterestloadtask, Content content)
    {
        if (createinterestloadtask == null || createinterestloadtask.isCancelled() || content.getStatus().hasError())
        {
            if (FollowedEntityDataManager.access$200().customTitle)
            {
                FollowedEntityDataManager.access$200().customTitle("FollowSearchOrchestrator: createFollowForSearch failed");
            }
            if (content == null)
            {
                createinterestloadtask = null;
            } else
            {
                createinterestloadtask = content.getStatus();
            }
            val$completionObserver.completionObserver(new Content(createinterestloadtask));
            return;
        }
        String s = val$params.iafToken;
        createinterestloadtask = s;
        if (TextUtils.isEmpty(s))
        {
            Authentication authentication = FollowedEntityDataManager.access$3700(_fld0);
            createinterestloadtask = s;
            if (authentication != null)
            {
                createinterestloadtask = authentication.iafToken;
            }
        }
        cess._mth1000(this._cls1.this, (InterestDescriptor)content.getData(), val$customTitle, createinterestloadtask, val$completionObserver);
    }

    ()
    {
        this$1 = final_;
        val$completionObserver = 1;
        val$params = searchparameters;
        val$customTitle = String.this;
        super();
    }
}
