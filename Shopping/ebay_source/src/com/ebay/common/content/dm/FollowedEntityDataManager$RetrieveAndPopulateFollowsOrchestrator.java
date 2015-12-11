// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import android.text.TextUtils;
import com.ebay.common.model.followinterest.FollowDescriptor;
import com.ebay.common.model.followinterest.FollowList;
import com.ebay.common.net.api.followinterest.GetFollowsLoadTask;
import com.ebay.common.net.api.followinterest.GetInterestsLoadTask;
import com.ebay.common.net.api.followinterest.InterestDescriptor;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.DatedContent;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.common.content.dm:
//            FollowedEntityDataManager

private class <init>
{

    private pendingFollowState pendingFollowState;
    final FollowedEntityDataManager this$0;

    private void getFollowsInternal(String s, EbaySite ebaysite, boolean flag)
    {
        if (pendingFollowState != null)
        {
            pendingFollowState.pendingFollowState = ResultStatus.CANCELED;
        }
        pendingFollowState = new pendingFollowState(s, ebaysite);
        com.ebay.common.net.api.followinterest.List list = new com.ebay.common.net.api.followinterest.GetFollowsLoadTask.Observer() {

            final FollowedEntityDataManager.RetrieveAndPopulateFollowsOrchestrator this$1;
            final FollowedEntityDataManager.FollowState val$stateInFlight;

            public void handleFollowsLoaded(GetFollowsLoadTask getfollowsloadtask, DatedContent datedcontent)
            {
                if (stateInFlight != pendingFollowState)
                {
                    if (FollowedEntityDataManager.access$200().isLoggable)
                    {
                        FollowedEntityDataManager.access$200().log("getFollowsInternal - a preempted task has been abandoned in favor of a newer task");
                    }
                    return;
                }
                if (getfollowsloadtask == null || getfollowsloadtask.isCancelled() || datedcontent.getStatus().hasError())
                {
                    if (FollowedEntityDataManager.access$200().isLoggable)
                    {
                        FollowedEntityDataManager.access$200().log("GetFollowsLoadTask has failed, or was cancelled");
                    }
                    pendingFollowState = null;
                    getfollowsloadtask = datedcontent.getStatus();
                    ((FollowedEntityDataManager.Observer)FollowedEntityDataManager.access$2400(this$0)).onFollowedSearchesLoaded(this$0, new DatedContent(getfollowsloadtask, 0x7fffffffL));
                    ((FollowedEntityDataManager.Observer)FollowedEntityDataManager.access$2500(this$0)).onFollowedCollectionsLoaded(this$0, new DatedContent(getfollowsloadtask, 0x7fffffffL));
                    ((FollowedEntityDataManager.Observer)FollowedEntityDataManager.access$2600(this$0)).onFollowedUsersLoaded(this$0, new DatedContent(getfollowsloadtask, 0x7fffffffL));
                    return;
                } else
                {
                    getfollowsloadtask = (FollowList)datedcontent.getData();
                    stateInFlight.resultStatus = datedcontent.getStatus();
                    stateInFlight.followedCollectionsContent = new DatedContent(((FollowList) (getfollowsloadtask)).collections, datedcontent.getLastUpdatedMillis());
                    stateInFlight.followedUsersContent = new DatedContent(((FollowList) (getfollowsloadtask)).users, datedcontent.getLastUpdatedMillis());
                    ((FollowedEntityDataManager.Observer)FollowedEntityDataManager.access$2700(this$0)).onFollowedCollectionsLoaded(this$0, stateInFlight.followedCollectionsContent);
                    ((FollowedEntityDataManager.Observer)FollowedEntityDataManager.access$2800(this$0)).onFollowedUsersLoaded(this$0, stateInFlight.followedUsersContent);
                    retrieveInterestDetailForFollows(getfollowsloadtask, stateInFlight);
                    return;
                }
            }

            
            {
                this$1 = FollowedEntityDataManager.RetrieveAndPopulateFollowsOrchestrator.this;
                stateInFlight = followstate;
                super();
            }
        };
        FollowedEntityDataManager.access$3000(FollowedEntityDataManager.this, s, ebaysite, flag, list);
    }

    private void retrieveInterestDetailForFollows(final FollowList followList, final this._cls0 stateInFlight)
    {
        com.ebay.common.net.api.followinterest.nFlight nflight = new com.ebay.common.net.api.followinterest.GetInterestsLoadTask.Observer() {

            final FollowedEntityDataManager.RetrieveAndPopulateFollowsOrchestrator this$1;
            final FollowList val$followList;
            final FollowedEntityDataManager.FollowState val$stateInFlight;

            public void handleInterestsLoaded(GetInterestsLoadTask getinterestsloadtask, DatedContent datedcontent)
            {
                Object obj = datedcontent.getStatus();
                if (stateInFlight != pendingFollowState || ResultStatus.CANCELED.equals(obj))
                {
                    if (FollowedEntityDataManager.access$200().isLoggable)
                    {
                        FollowedEntityDataManager.access$200().log("RetrieveAndPopulateFollowsOrchestrator: retrieveInterestDetailForFollows was canceled");
                    }
                    return;
                }
                if (getinterestsloadtask == null || getinterestsloadtask.isCancelled() || ((ResultStatus) (obj)).hasError())
                {
                    if (FollowedEntityDataManager.access$200().isLoggable)
                    {
                        FollowedEntityDataManager.access$200().log("TEST_getFollows/GetInterestsLoadTask has failed");
                    }
                    pendingFollowState = null;
                    ((FollowedEntityDataManager.Observer)FollowedEntityDataManager.access$3100(this$0)).onFollowedSearchesLoaded(this$0, new DatedContent(((ResultStatus) (obj)), 0L));
                    return;
                }
                getinterestsloadtask = new LinkedHashMap();
                stateInFlight.followedInterestsContent = new DatedContent(getinterestsloadtask, datedcontent.getLastUpdatedMillis());
                datedcontent = (Map)datedcontent.getData();
                obj = followList.interests.iterator();
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
                pendingFollowState = null;
                FollowedEntityDataManager.access$3200(stateInFlight);
                ((FollowedEntityDataManager.Observer)FollowedEntityDataManager.access$3300(this$0)).onFollowedSearchesLoaded(this$0, stateInFlight.followedInterestsContent);
            }

            
            {
                this$1 = FollowedEntityDataManager.RetrieveAndPopulateFollowsOrchestrator.this;
                stateInFlight = followstate;
                followList = followlist;
                super();
            }
        };
        ArrayList arraylist = new ArrayList();
        for (followList = followList.interests.iterator(); followList.hasNext(); arraylist.add(((FollowDescriptor)followList.next()).getInterestId())) { }
        FollowedEntityDataManager.access$3400(FollowedEntityDataManager.this, stateInFlight._fld0, stateInFlight._fld0.idString, arraylist, FollowedEntityDataManager.access$500(FollowedEntityDataManager.this).Request(), nflight);
    }

    public void getFollows(String s, EbaySite ebaysite, boolean flag)
    {
        NautilusKernel.verifyMain();
        if (!flag && pendingFollowState != null && pendingFollowState.pendingFollowState(s, ebaysite))
        {
            if (FollowedEntityDataManager.access$200().dingFollowState)
            {
                FollowedEntityDataManager.access$200().dingFollowState("operation already in flight;getFollows() returning without invocation");
            }
            return;
        } else
        {
            getFollowsInternal(s, ebaysite, flag);
            return;
        }
    }

    public void setDirty()
    {
        if (pendingFollowState != null)
        {
            if (FollowedEntityDataManager.access$200().dingFollowState)
            {
                FollowedEntityDataManager.access$200().dingFollowState("Restarting getFollows");
            }
            getFollowsInternal(pendingFollowState.pendingFollowState, pendingFollowState.pendingFollowState, true);
        }
    }



/*
    static _cls2 access$2302(_cls2 _pcls2, _cls2 _pcls2_1)
    {
        _pcls2.pendingFollowState = _pcls2_1;
        return _pcls2_1;
    }

*/


    private _cls2.val.followList()
    {
        this$0 = FollowedEntityDataManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
