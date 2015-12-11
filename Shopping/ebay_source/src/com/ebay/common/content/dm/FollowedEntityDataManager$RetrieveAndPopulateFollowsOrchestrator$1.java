// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import com.ebay.common.model.followinterest.FollowList;
import com.ebay.common.net.api.followinterest.GetFollowsLoadTask;
import com.ebay.nautilus.domain.content.DatedContent;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.common.content.dm:
//            FollowedEntityDataManager

class val.stateInFlight
    implements com.ebay.common.net.api.followinterest.light
{

    final val.stateInFlight this$1;
    final val.stateInFlight val$stateInFlight;

    public void handleFollowsLoaded(GetFollowsLoadTask getfollowsloadtask, DatedContent datedcontent)
    {
        if (val$stateInFlight != cess._mth2300(this._cls1.this))
        {
            if (FollowedEntityDataManager.access$200()._fld1)
            {
                FollowedEntityDataManager.access$200()._mth1("getFollowsInternal - a preempted task has been abandoned in favor of a newer task");
            }
            return;
        }
        if (getfollowsloadtask == null || getfollowsloadtask.isCancelled() || datedcontent.getStatus().hasError())
        {
            if (FollowedEntityDataManager.access$200()._fld1)
            {
                FollowedEntityDataManager.access$200()._mth1("GetFollowsLoadTask has failed, or was cancelled");
            }
            cess._mth2302(this._cls1.this, null);
            getfollowsloadtask = datedcontent.getStatus();
            ((this._cls1)FollowedEntityDataManager.access$2400(_fld0))._mth0(_fld0, new DatedContent(getfollowsloadtask, 0x7fffffffL));
            ((is._cls0)FollowedEntityDataManager.access$2500(_fld0))._mth0(_fld0, new DatedContent(getfollowsloadtask, 0x7fffffffL));
            ((is._cls0)FollowedEntityDataManager.access$2600(_fld0))._mth0(_fld0, new DatedContent(getfollowsloadtask, 0x7fffffffL));
            return;
        } else
        {
            getfollowsloadtask = (FollowList)datedcontent.getData();
            val$stateInFlight.stateInFlight = datedcontent.getStatus();
            val$stateInFlight.stateInFlight = new DatedContent(((FollowList) (getfollowsloadtask)).collections, datedcontent.getLastUpdatedMillis());
            val$stateInFlight.stateInFlight = new DatedContent(((FollowList) (getfollowsloadtask)).users, datedcontent.getLastUpdatedMillis());
            ((val.stateInFlight)FollowedEntityDataManager.access$2700(_fld0))._mth0(_fld0, val$stateInFlight.stateInFlight);
            ((val.stateInFlight)FollowedEntityDataManager.access$2800(_fld0))._mth0(_fld0, val$stateInFlight.stateInFlight);
            cess._mth2900(this._cls1.this, getfollowsloadtask, val$stateInFlight);
            return;
        }
    }

    ()
    {
        this$1 = final_;
        val$stateInFlight = val.stateInFlight.this;
        super();
    }
}
