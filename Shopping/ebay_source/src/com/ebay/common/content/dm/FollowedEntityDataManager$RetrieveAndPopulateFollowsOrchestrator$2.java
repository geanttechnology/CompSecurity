// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import android.text.TextUtils;
import com.ebay.common.model.followinterest.FollowDescriptor;
import com.ebay.common.model.followinterest.FollowList;
import com.ebay.common.net.api.followinterest.GetInterestsLoadTask;
import com.ebay.common.net.api.followinterest.InterestDescriptor;
import com.ebay.nautilus.domain.content.DatedContent;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.common.content.dm:
//            FollowedEntityDataManager

class val.followList
    implements com.ebay.common.net.api.followinterest.st
{

    final val.stateInFlight this$1;
    final FollowList val$followList;
    final val.stateInFlight val$stateInFlight;

    public void handleInterestsLoaded(GetInterestsLoadTask getinterestsloadtask, DatedContent datedcontent)
    {
        Object obj = datedcontent.getStatus();
        if (val$stateInFlight != cess._mth2300(this._cls1.this) || ResultStatus.CANCELED.equals(obj))
        {
            if (FollowedEntityDataManager.access$200()._fld1)
            {
                FollowedEntityDataManager.access$200()._mth1("RetrieveAndPopulateFollowsOrchestrator: retrieveInterestDetailForFollows was canceled");
            }
            return;
        }
        if (getinterestsloadtask == null || getinterestsloadtask.isCancelled() || ((ResultStatus) (obj)).hasError())
        {
            if (FollowedEntityDataManager.access$200()._fld1)
            {
                FollowedEntityDataManager.access$200()._mth1("TEST_getFollows/GetInterestsLoadTask has failed");
            }
            cess._mth2302(this._cls1.this, null);
            ((this._cls1)FollowedEntityDataManager.access$3100(_fld0))._mth0(_fld0, new DatedContent(((ResultStatus) (obj)), 0L));
            return;
        }
        getinterestsloadtask = new LinkedHashMap();
        val$stateInFlight.stateInFlight = new DatedContent(getinterestsloadtask, datedcontent.getLastUpdatedMillis());
        datedcontent = (Map)datedcontent.getData();
        obj = val$followList.interests.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            FollowDescriptor followdescriptor = (FollowDescriptor)((Iterator) (obj)).next();
            Object obj1 = followdescriptor.getInterestId();
            if (!TextUtils.isEmpty(((CharSequence) (obj1))) && datedcontent.containsKey(obj1))
            {
                obj1 = (InterestDescriptor)datedcontent.get(obj1);
                followdescriptor.interest = ((InterestDescriptor) (obj1));
                getinterestsloadtask.put(followdescriptor, obj1);
            }
        } while (true);
        cess._mth2302(this._cls1.this, null);
        FollowedEntityDataManager.access$3200(val$stateInFlight);
        ((val.stateInFlight)FollowedEntityDataManager.access$3300(_fld0))._mth0(_fld0, val$stateInFlight.stateInFlight);
    }

    ()
    {
        this$1 = final_;
        val$stateInFlight = 1;
        val$followList = FollowList.this;
        super();
    }
}
