// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import com.ebay.common.model.followinterest.FollowDescriptor;
import com.ebay.common.model.followinterest.FollowList;
import com.ebay.common.model.followinterest.FollowType;
import com.ebay.common.net.api.followinterest.CreateFollowLoadTask;
import com.ebay.common.net.api.followinterest.CreateInterestLoadTask;
import com.ebay.common.net.api.followinterest.DeleteFollowLoadTask;
import com.ebay.common.net.api.followinterest.FollowSvcShared;
import com.ebay.common.net.api.followinterest.GetFollowersLoadTask;
import com.ebay.common.net.api.followinterest.GetFollowsLoadTask;
import com.ebay.common.net.api.followinterest.GetInterestsLoadTask;
import com.ebay.common.net.api.followinterest.InterestDescriptor;
import com.ebay.common.net.api.followinterest.SaasSearchRequest;
import com.ebay.common.net.api.followinterest.UpdateFollowLoadTask;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.NautilusDomain;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.DatedContent;
import com.ebay.nautilus.domain.content.dm.FollowingContentDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextObservingDataManager;
import com.ebay.nautilus.domain.content.dm.UssContentsDataManager;
import com.ebay.nautilus.domain.content.dm.UssFeedDataManager;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DcsNautilusInteger;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FollowedEntityDataManager extends UserContextObservingDataManager
{
    public static interface FollowInterestConfig
    {

        public abstract boolean enablePersistentCache();

        public abstract long getFollowCacheTtl();

        public abstract long getInterestCacheTtl();

        public abstract int getMaxAggregateOperationTimeoutMs();

        public abstract int getMaxCachedFollowerSummaries();

        public abstract int getMaxInterestsPerRequest();
    }

    public static class FollowState
    {

        public DatedContent followedCollectionsContent;
        public DatedContent followedInterestsContent;
        public DatedContent followedUsersContent;
        public final String iafToken;
        public ResultStatus resultStatus;
        public final EbaySite site;

        public void addFollow(FollowType followtype, FollowDescriptor followdescriptor)
        {
            if (followdescriptor != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            NautilusKernel.verifyMain();
            static class _cls15
            {

                static final int $SwitchMap$com$ebay$common$model$followinterest$FollowType[];

                static 
                {
                    $SwitchMap$com$ebay$common$model$followinterest$FollowType = new int[FollowType.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$common$model$followinterest$FollowType[FollowType.INTEREST.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$ebay$common$model$followinterest$FollowType[FollowType.COLLECTION.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$ebay$common$model$followinterest$FollowType[FollowType.USER.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls15..SwitchMap.com.ebay.common.model.followinterest.FollowType[followtype.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                if (followdescriptor.interest != null)
                {
                    removeFollow(followtype, followdescriptor.getInterestId());
                    if (followedInterestsContent == null)
                    {
                        followedInterestsContent = new DatedContent(new LinkedHashMap(), ResultStatus.SUCCESS);
                    }
                    ((Map)followedInterestsContent.getData()).put(followdescriptor, followdescriptor.interest);
                    return;
                }
                break;

            case 2: // '\002'
                removeFollow(followtype, followdescriptor.collectionId);
                if (followedCollectionsContent == null)
                {
                    followedCollectionsContent = new DatedContent(new ArrayList(), ResultStatus.SUCCESS);
                }
                ((List)followedCollectionsContent.getData()).add(followdescriptor);
                return;

            case 3: // '\003'
                removeFollow(followtype, followdescriptor.username);
                if (followedUsersContent == null)
                {
                    followedUsersContent = new DatedContent(new ArrayList(), ResultStatus.SUCCESS);
                }
                ((List)followedUsersContent.getData()).add(followdescriptor);
                return;
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        public FollowDescriptor getFollowById(FollowType followtype, String s)
        {
            _cls15..SwitchMap.com.ebay.common.model.followinterest.FollowType[followtype.ordinal()];
            JVM INSTR tableswitch 1 3: default 36
        //                       1 40
        //                       2 101
        //                       3 165;
               goto _L1 _L2 _L3 _L4
_L1:
            followtype = null;
_L6:
            return followtype;
_L2:
            followtype = ((Map)followedInterestsContent.getData()).entrySet().iterator();
            FollowDescriptor followdescriptor;
            do
            {
                if (!followtype.hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                followdescriptor = (FollowDescriptor)((java.util.Map.Entry)followtype.next()).getKey();
            } while (!s.equals(followdescriptor.getInterestId()));
            return followdescriptor;
_L3:
            Iterator iterator = ((List)followedCollectionsContent.getData()).iterator();
_L8:
            FollowDescriptor followdescriptor1;
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            followdescriptor1 = (FollowDescriptor)iterator.next();
            followtype = followdescriptor1;
            if (s.equals(followdescriptor1.id)) goto _L6; else goto _L5
_L5:
            if (!s.equals(followdescriptor1.collectionId)) goto _L8; else goto _L7
_L7:
            return followdescriptor1;
_L4:
            iterator = ((List)followedUsersContent.getData()).iterator();
_L11:
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            followdescriptor1 = (FollowDescriptor)iterator.next();
            followtype = followdescriptor1;
            if (s.equals(followdescriptor1.id)) goto _L6; else goto _L9
_L9:
            if (!s.equals(followdescriptor1.username)) goto _L11; else goto _L10
_L10:
            return followdescriptor1;
            if (true) goto _L1; else goto _L12
_L12:
        }

        public FollowDescriptor getFollowByInterestId(String s)
        {
            for (Iterator iterator = ((Map)followedInterestsContent.getData()).entrySet().iterator(); iterator.hasNext();)
            {
                FollowDescriptor followdescriptor = (FollowDescriptor)((java.util.Map.Entry)iterator.next()).getKey();
                if (followdescriptor.getInterestId().equals(s))
                {
                    return followdescriptor;
                }
            }

            return null;
        }

        public List getFollowedInterestsByName(String s)
        {
            LinkedList linkedlist = new LinkedList();
            Iterator iterator = ((Map)followedInterestsContent.getData()).entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                FollowDescriptor followdescriptor = (FollowDescriptor)((java.util.Map.Entry)iterator.next()).getKey();
                if (followdescriptor.getInterestTitle().equals(s))
                {
                    linkedlist.add(followdescriptor);
                }
            } while (true);
            return linkedlist;
        }

        public boolean isApplicable(String s, EbaySite ebaysite)
        {
            return iafToken.equals(s) && site.equals(ebaysite);
        }

        public void removeFollow(FollowType followtype, String s)
        {
            NautilusKernel.verifyMain();
            if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
            return;
_L2:
            FollowDescriptor followdescriptor;
            switch (_cls15..SwitchMap.com.ebay.common.model.followinterest.FollowType[followtype.ordinal()])
            {
            default:
                return;

            case 3: // '\003'
                continue; /* Loop/switch isn't completed */

            case 1: // '\001'
                if (followedInterestsContent == null)
                {
                    continue; /* Loop/switch isn't completed */
                }
                followtype = ((Map)followedInterestsContent.getData()).entrySet().iterator();
                do
                {
                    if (!followtype.hasNext())
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    followdescriptor = (FollowDescriptor)((java.util.Map.Entry)followtype.next()).getKey();
                } while (!s.equals(followdescriptor.getInterestId()));
                break; /* Loop/switch isn't completed */

            case 2: // '\002'
                if (followedCollectionsContent == null)
                {
                    continue; /* Loop/switch isn't completed */
                }
                followtype = ((List)followedCollectionsContent.getData()).iterator();
                do
                {
                    if (!followtype.hasNext())
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    followdescriptor = (FollowDescriptor)followtype.next();
                } while (!s.equals(followdescriptor.id) && !s.equals(followdescriptor.collectionId));
                break; /* Loop/switch isn't completed */
            }
            if (true) goto _L1; else goto _L3
_L3:
            ((Map)followedInterestsContent.getData()).remove(followdescriptor);
            return;
            if (true) goto _L1; else goto _L4
_L4:
            ((List)followedCollectionsContent.getData()).remove(followdescriptor);
            return;
            if (followedUsersContent == null) goto _L1; else goto _L5
_L5:
            followtype = ((List)followedUsersContent.getData()).iterator();
            do
            {
                if (!followtype.hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                followdescriptor = (FollowDescriptor)followtype.next();
            } while (!s.equals(followdescriptor.id) && !s.equals(followdescriptor.username));
            break; /* Loop/switch isn't completed */
            if (true) goto _L1; else goto _L6
_L6:
            ((List)followedUsersContent.getData()).remove(followdescriptor);
            return;
        }

        public FollowState(String s, EbaySite ebaysite)
        {
            iafToken = s;
            site = ebaysite;
        }
    }

    public static final class KeyParams extends com.ebay.nautilus.domain.content.dm.UserContextObservingDataManager.KeyBase
    {

        static final KeyParams KEY = new KeyParams();

        protected FollowedEntityDataManager create(EbayContext ebaycontext)
        {
            return new FollowedEntityDataManager(ebaycontext, com/ebay/common/content/dm/FollowedEntityDataManager$Observer, this);
        }

        protected volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }


        KeyParams()
        {
        }
    }

    public static interface Observer
    {

        public abstract void onCollectionFollowed(Content content);

        public abstract void onFollowDeleted(FollowType followtype, String s, ResultStatus resultstatus);

        public abstract void onFollowedCollectionsLoaded(FollowedEntityDataManager followedentitydatamanager, DatedContent datedcontent);

        public abstract void onFollowedSearchesLoaded(FollowedEntityDataManager followedentitydatamanager, DatedContent datedcontent);

        public abstract void onFollowedUsersLoaded(FollowedEntityDataManager followedentitydatamanager, DatedContent datedcontent);

        public abstract void onFollowersLoaded(FollowType followtype, Content content);

        public abstract void onFollowsUpdated(FollowedEntityDataManager followedentitydatamanager, Content content);

        public abstract void onSearchFollowed(Content content);

        public abstract void onUserFollowed(Content content);
    }

    public static interface OnFollowedSearchesChanged
    {

        public abstract String getSearchQuery();

        public abstract void onFollowedInterestDeleted(String s);

        public abstract void onFollowedInterestsLoaded(Map map);

        public abstract void onSearchFollowed(FollowDescriptor followdescriptor);
    }

    private class RetrieveAndPopulateFollowsOrchestrator
    {

        private FollowState pendingFollowState;
        final FollowedEntityDataManager this$0;

        private void getFollowsInternal(String s, EbaySite ebaysite, boolean flag)
        {
            if (pendingFollowState != null)
            {
                pendingFollowState.resultStatus = ResultStatus.CANCELED;
            }
            pendingFollowState = new FollowState(s, ebaysite);
            com.ebay.common.net.api.followinterest.GetFollowsLoadTask.Observer observer = pendingFollowState. new com.ebay.common.net.api.followinterest.GetFollowsLoadTask.Observer() ;
            getFollowsForUser(s, ebaysite, flag, observer);
        }

        private void retrieveInterestDetailForFollows(FollowList followlist, final FollowState stateInFlight)
        {
            com.ebay.common.net.api.followinterest.GetInterestsLoadTask.Observer observer = followlist. new com.ebay.common.net.api.followinterest.GetInterestsLoadTask.Observer() {

                final RetrieveAndPopulateFollowsOrchestrator this$1;
                final FollowList val$followList;
                final FollowState val$stateInFlight;

                public void handleInterestsLoaded(GetInterestsLoadTask getinterestsloadtask, DatedContent datedcontent)
                {
                    Object obj = datedcontent.getStatus();
                    if (stateInFlight != pendingFollowState || ResultStatus.CANCELED.equals(obj))
                    {
                        if (FollowedEntityDataManager.logger.isLoggable)
                        {
                            FollowedEntityDataManager.logger.log("RetrieveAndPopulateFollowsOrchestrator: retrieveInterestDetailForFollows was canceled");
                        }
                        return;
                    }
                    if (getinterestsloadtask == null || getinterestsloadtask.isCancelled() || ((ResultStatus) (obj)).hasError())
                    {
                        if (FollowedEntityDataManager.logger.isLoggable)
                        {
                            FollowedEntityDataManager.logger.log("TEST_getFollows/GetInterestsLoadTask has failed");
                        }
                        pendingFollowState = null;
                        ((Observer)get).onFollowedSearchesLoaded(_fld0, new DatedContent(((ResultStatus) (obj)), 0L));
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
                    FollowedEntityDataManager.setFollowState(stateInFlight);
                    ((Observer)get).onFollowedSearchesLoaded(_fld0, stateInFlight.followedInterestsContent);
                }

            
            {
                this$1 = final_retrieveandpopulatefollowsorchestrator;
                stateInFlight = followstate;
                followList = FollowList.this;
                super();
            }
            };
            ArrayList arraylist = new ArrayList();
            for (followlist = followlist.interests.iterator(); followlist.hasNext(); arraylist.add(((FollowDescriptor)followlist.next()).getInterestId())) { }
            getInterests(stateInFlight.iafToken, stateInFlight.site.idString, arraylist, config.getMaxInterestsPerRequest(), observer);
        }

        public void getFollows(String s, EbaySite ebaysite, boolean flag)
        {
            NautilusKernel.verifyMain();
            if (!flag && pendingFollowState != null && pendingFollowState.isApplicable(s, ebaysite))
            {
                if (FollowedEntityDataManager.logger.isLoggable)
                {
                    FollowedEntityDataManager.logger.log("operation already in flight;getFollows() returning without invocation");
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
                if (FollowedEntityDataManager.logger.isLoggable)
                {
                    FollowedEntityDataManager.logger.log("Restarting getFollows");
                }
                getFollowsInternal(pendingFollowState.iafToken, pendingFollowState.site, true);
            }
        }



/*
        static FollowState access$2302(RetrieveAndPopulateFollowsOrchestrator retrieveandpopulatefollowsorchestrator, FollowState followstate)
        {
            retrieveandpopulatefollowsorchestrator.pendingFollowState = followstate;
            return followstate;
        }

*/


        private RetrieveAndPopulateFollowsOrchestrator()
        {
            this$0 = FollowedEntityDataManager.this;
            super();
        }

    }

    public static class SimpleObserver
        implements Observer
    {

        public void onCollectionFollowed(Content content)
        {
        }

        public void onFollowDeleted(FollowType followtype, String s, ResultStatus resultstatus)
        {
        }

        public void onFollowedCollectionsLoaded(FollowedEntityDataManager followedentitydatamanager, DatedContent datedcontent)
        {
        }

        public void onFollowedSearchesLoaded(FollowedEntityDataManager followedentitydatamanager, DatedContent datedcontent)
        {
        }

        public void onFollowedUsersLoaded(FollowedEntityDataManager followedentitydatamanager, DatedContent datedcontent)
        {
        }

        public void onFollowersLoaded(FollowType followtype, Content content)
        {
        }

        public void onFollowsUpdated(FollowedEntityDataManager followedentitydatamanager, Content content)
        {
        }

        public void onSearchFollowed(Content content)
        {
        }

        public void onUserFollowed(Content content)
        {
        }

        public SimpleObserver()
        {
        }
    }

    class SyncResult
    {

        public Content result;
        final FollowedEntityDataManager this$0;
        public final CountDownLatch wait = new CountDownLatch(1);

        SyncResult()
        {
            this$0 = FollowedEntityDataManager.this;
            super();
        }
    }

    private static class SynchronousFollowedSearchesLoadedObserver extends SimpleObserver
    {

        public DatedContent collectionResultContent;
        public FollowedEntityDataManager dm;
        public DatedContent interestResultContent;
        public CountDownLatch sync;
        public DatedContent userResultContent;

        public void onFollowedCollectionsLoaded(FollowedEntityDataManager followedentitydatamanager, DatedContent datedcontent)
        {
            boolean flag;
            if (collectionResultContent == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            collectionResultContent = datedcontent;
            if (flag)
            {
                sync.countDown();
            }
        }

        public void onFollowedSearchesLoaded(FollowedEntityDataManager followedentitydatamanager, DatedContent datedcontent)
        {
            boolean flag;
            if (interestResultContent == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            interestResultContent = datedcontent;
            if (flag)
            {
                sync.countDown();
            }
        }

        public void onFollowedUsersLoaded(FollowedEntityDataManager followedentitydatamanager, DatedContent datedcontent)
        {
            boolean flag;
            if (userResultContent == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            userResultContent = datedcontent;
            if (flag)
            {
                sync.countDown();
            }
        }

        private SynchronousFollowedSearchesLoadedObserver()
        {
            sync = new CountDownLatch(3);
        }

    }

    public static abstract class WatchFollowsObserverBase extends SimpleObserver
    {

        protected final Context context;
        protected final Map currentlyFollowedInterests = new LinkedHashMap();
        protected OnFollowedSearchesChanged observer;

        public abstract SearchParameters getDefaultSearchParameters();

        public FollowDescriptor getFollow(SearchParameters searchparameters)
        {
label0:
            {
                if (currentlyFollowedInterests.isEmpty())
                {
                    break label0;
                }
                searchparameters = SaasSearchRequest.fromSearchParameters(searchparameters);
                Iterator iterator = currentlyFollowedInterests.keySet().iterator();
                SaasSearchRequest saassearchrequest;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    saassearchrequest = (SaasSearchRequest)iterator.next();
                } while (!saassearchrequest.equals(searchparameters));
                return (FollowDescriptor)currentlyFollowedInterests.get(saassearchrequest);
            }
            return null;
        }

        protected transient void onDeleteSavedSearchesFromCache(Context context1, String as[])
        {
        }

        public void onFollowDeleted(FollowType followtype, String s, ResultStatus resultstatus)
        {
            if (!resultstatus.hasError() && followtype == FollowType.INTEREST)
            {
                followtype = currentlyFollowedInterests.entrySet().iterator();
                do
                {
                    if (!followtype.hasNext())
                    {
                        break;
                    }
                    resultstatus = (java.util.Map.Entry)followtype.next();
                    if (!((FollowDescriptor)resultstatus.getValue()).interestId.equals(s))
                    {
                        continue;
                    }
                    currentlyFollowedInterests.remove(resultstatus.getKey());
                    break;
                } while (true);
                if (s != null)
                {
                    onDeleteSavedSearchesFromCache(context, new String[] {
                        s
                    });
                }
                if (observer != null)
                {
                    observer.onFollowedInterestDeleted(s);
                    return;
                }
            }
        }

        public void onFollowedSearchesLoaded(FollowedEntityDataManager followedentitydatamanager, DatedContent datedcontent)
        {
            currentlyFollowedInterests.clear();
            if (!datedcontent.getStatus().hasError())
            {
                datedcontent = (Map)datedcontent.getData();
                followedentitydatamanager = getDefaultSearchParameters();
                FollowDescriptor followdescriptor;
                SaasSearchRequest saassearchrequest;
                for (datedcontent = datedcontent.keySet().iterator(); datedcontent.hasNext(); currentlyFollowedInterests.put(saassearchrequest, followdescriptor))
                {
                    followdescriptor = (FollowDescriptor)datedcontent.next();
                    saassearchrequest = SaasSearchRequest.fromSearchParameters(followdescriptor.interest.getSearchParameters(followedentitydatamanager));
                }

            }
            if (observer != null)
            {
                observer.onFollowedInterestsLoaded(currentlyFollowedInterests);
            }
        }

        public void onSearchFollowed(Content content)
        {
            if (!content.getStatus().hasError() && content.getData() != null)
            {
                Object obj = getDefaultSearchParameters();
                content = (FollowDescriptor)content.getData();
                obj = SaasSearchRequest.fromSearchParameters(((FollowDescriptor) (content)).interest.getSearchParameters(((SearchParameters) (obj))));
                currentlyFollowedInterests.put(obj, content);
                if (observer != null)
                {
                    observer.onSearchFollowed(content);
                    return;
                }
            }
        }

        public WatchFollowsObserverBase(Context context1, OnFollowedSearchesChanged onfollowedsearcheschanged)
        {
            context = context1;
            observer = onfollowedsearcheschanged;
        }
    }


    private static final FollowInterestConfig DEFAULT_CONFIG = new FollowInterestConfig() {

        final DeviceConfiguration dc = DeviceConfiguration.getAsync();

        public boolean enablePersistentCache()
        {
            return dc.get(DcsNautilusBoolean.searchFollowEnablePersistentCache);
        }

        public long getFollowCacheTtl()
        {
            return (long)dc.get(DcsNautilusInteger.searchFollowMaxFollowCacheTtlInMinutes) * 60000L;
        }

        public long getInterestCacheTtl()
        {
            return (long)dc.get(DcsNautilusInteger.searchFollowMaxInterestCacheTtlInDays) * 0x5265c00L;
        }

        public int getMaxAggregateOperationTimeoutMs()
        {
            return dc.get(DcsNautilusInteger.searchFollowAggregateOperationTimeoutMs);
        }

        public int getMaxCachedFollowerSummaries()
        {
            return dc.get(DcsNautilusInteger.searchFollowMaxCachedFollowerSummaries);
        }

        public int getMaxInterestsPerRequest()
        {
            return dc.get(DcsNautilusInteger.searchFollowMaxInterestsPerRequest);
        }

    };
    public static final KeyParams KEY;
    private static volatile FollowState _followCache;
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new LogInfo("FIDataManager", 2, "Log saved search data manager usage");
    private FollowInterestConfig config;
    private final FollowSearchOrchestrator followSearchOrchestrator;
    private Map followerCache;
    private final RetrieveAndPopulateFollowsOrchestrator retrieveAndPopulateFollowsOrchestrator;

    private FollowedEntityDataManager(EbayContext ebaycontext, Class class1, KeyParams keyparams)
    {
        super(ebaycontext, class1, keyparams);
        retrieveAndPopulateFollowsOrchestrator = new RetrieveAndPopulateFollowsOrchestrator();
        followSearchOrchestrator = new FollowSearchOrchestrator();
        setConfig(DEFAULT_CONFIG);
        NautilusDomain.initializeDataManager(getEbayContext(), this);
        if (logger.isLoggable)
        {
            logger.log("Instantiated");
        }
    }


    private void createFollowForCollection(String s, String s1, String s2, com.ebay.common.net.api.followinterest.CreateFollowLoadTask.Observer observer)
    {
        observer = new CreateFollowLoadTask(getEbayContext(), observer);
        com.ebay.common.net.api.followinterest.CreateFollowLoadTask.Params params = new com.ebay.common.net.api.followinterest.CreateFollowLoadTask.Params();
        params.id = s1;
        params.iafToken = s;
        params.followType = FollowType.COLLECTION;
        params.marketPlaceId = s2;
        executeOnThreadPool(observer, new com.ebay.common.net.api.followinterest.CreateFollowLoadTask.Params[] {
            params
        });
    }

    private void createFollowForInterest(String s, InterestDescriptor interestdescriptor, String s1, com.ebay.common.net.api.followinterest.CreateFollowLoadTask.Observer observer)
    {
        observer = new CreateFollowLoadTask(getEbayContext(), observer);
        com.ebay.common.net.api.followinterest.CreateFollowLoadTask.Params params = new com.ebay.common.net.api.followinterest.CreateFollowLoadTask.Params();
        params.interestDescriptor = interestdescriptor;
        params.iafToken = s;
        params.customTitle = s1;
        params.followType = FollowType.INTEREST;
        params.marketPlaceId = interestdescriptor.marketplaceId;
        executeOnThreadPool(observer, new com.ebay.common.net.api.followinterest.CreateFollowLoadTask.Params[] {
            params
        });
    }

    private void createFollowForUser(String s, String s1, String s2, com.ebay.common.net.api.followinterest.CreateFollowLoadTask.Observer observer)
    {
        observer = new CreateFollowLoadTask(getEbayContext(), observer);
        com.ebay.common.net.api.followinterest.CreateFollowLoadTask.Params params = new com.ebay.common.net.api.followinterest.CreateFollowLoadTask.Params();
        params.id = s1;
        params.iafToken = s;
        params.followType = FollowType.USER;
        params.marketPlaceId = s2;
        executeOnThreadPool(observer, new com.ebay.common.net.api.followinterest.CreateFollowLoadTask.Params[] {
            params
        });
    }

    private void createInterest(String s, SearchParameters searchparameters, com.ebay.common.net.api.followinterest.CreateInterestLoadTask.Observer observer)
    {
        observer = new CreateInterestLoadTask(getEbayContext(), observer);
        com.ebay.common.net.api.followinterest.CreateInterestLoadTask.Params params = new com.ebay.common.net.api.followinterest.CreateInterestLoadTask.Params();
        params.searchParameters = searchparameters;
        params.iafToken = s;
        executeOnThreadPool(observer, new com.ebay.common.net.api.followinterest.CreateInterestLoadTask.Params[] {
            params
        });
    }

    private void deleteFollowedSearchByNameInternal(String s, String s1)
    {
        NautilusKernel.verifyMain();
        FollowState followstate = getFollowState();
        if (followstate != null)
        {
            s = followstate.getFollowedInterestsByName(s).iterator();
            while (s.hasNext()) 
            {
                FollowDescriptor followdescriptor = (FollowDescriptor)s.next();
                deleteFollow(FollowType.INTEREST, followdescriptor.getInterestId(), s1);
            }
        }
    }

    private static FollowState getFollowState()
    {
        NautilusKernel.verifyMain();
        return _followCache;
    }

    private void getFollowsForUser(String s, EbaySite ebaysite, boolean flag, com.ebay.common.net.api.followinterest.GetFollowsLoadTask.Observer observer)
    {
        observer = new GetFollowsLoadTask(getEbayContext(), observer);
        com.ebay.common.net.api.followinterest.GetFollowsLoadTask.Params params = new com.ebay.common.net.api.followinterest.GetFollowsLoadTask.Params();
        params.marketPlaceId = ebaysite.idString;
        params.iafToken = s;
        params.forceRefresh = flag;
        params.cacheConfig = new com.ebay.common.net.api.followinterest.GetFollowsLoadTask.CacheConfig() {

            final FollowedEntityDataManager this$0;

            public boolean enablePersistence()
            {
                return config.enablePersistentCache();
            }

            public long getMaxTtl()
            {
                return config.getFollowCacheTtl();
            }

            
            {
                this$0 = FollowedEntityDataManager.this;
                super();
            }
        };
        executeOnThreadPool(observer, new com.ebay.common.net.api.followinterest.GetFollowsLoadTask.Params[] {
            params
        });
    }

    public static Content getFollowsSynchronous(EbayContext ebaycontext, String s, EbaySite ebaysite, boolean flag, Observer observer)
    {
        Object obj;
        SynchronousFollowedSearchesLoadedObserver synchronousfollowedsearchesloadedobserver;
        NautilusKernel.verifyNotMain();
        obj = null;
        synchronousfollowedsearchesloadedobserver = new SynchronousFollowedSearchesLoadedObserver();
        runOnMainThread(new Runnable(ebaycontext, synchronousfollowedsearchesloadedobserver, s, ebaysite, flag) {

            final EbayContext val$ebayContext;
            final boolean val$forceRefresh;
            final String val$iafToken;
            final EbaySite val$site;
            final SynchronousFollowedSearchesLoadedObserver val$syncObserver;

            public void run()
            {
                FollowedEntityDataManager followedentitydatamanager = (FollowedEntityDataManager)DataManager.get(ebayContext, FollowedEntityDataManager.KEY);
                syncObserver.dm = followedentitydatamanager;
                followedentitydatamanager.registerObserver(syncObserver);
                followedentitydatamanager.retrieveAndPopulateFollowsOrchestrator.getFollows(iafToken, site, forceRefresh);
            }

            
            {
                ebayContext = ebaycontext;
                syncObserver = synchronousfollowedsearchesloadedobserver;
                iafToken = s;
                site = ebaysite;
                forceRefresh = flag;
                super();
            }
        });
        flag = synchronousfollowedsearchesloadedobserver.sync.await(DeviceConfiguration.getAsync().get(DcsNautilusInteger.searchFollowAggregateOperationTimeoutMs), TimeUnit.MILLISECONDS);
        runOnMainThread(new Runnable(synchronousfollowedsearchesloadedobserver) {

            final SynchronousFollowedSearchesLoadedObserver val$syncObserver;

            public void run()
            {
                syncObserver.dm.unregisterObserver(syncObserver);
            }

            
            {
                syncObserver = synchronousfollowedsearchesloadedobserver;
                super();
            }
        });
        s = new LinkedHashMap();
        ebaycontext = obj;
        if (!flag) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = 0;
        i = j;
        if (synchronousfollowedsearchesloadedobserver.interestResultContent == null)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        i = j;
        if (synchronousfollowedsearchesloadedobserver.interestResultContent.getStatus().hasError())
        {
            break MISSING_BLOCK_LABEL_155;
        }
        j = 0 + 1;
        i = j;
        if (synchronousfollowedsearchesloadedobserver.interestResultContent.getData() == null)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        s.putAll((Map)synchronousfollowedsearchesloadedobserver.interestResultContent.getData());
        i = j;
        j = i;
        if (synchronousfollowedsearchesloadedobserver.userResultContent == null) goto _L4; else goto _L3
_L3:
        j = i;
        if (synchronousfollowedsearchesloadedobserver.userResultContent.getStatus().hasError()) goto _L4; else goto _L5
_L5:
        i++;
        j = i;
        if (synchronousfollowedsearchesloadedobserver.userResultContent.getData() == null) goto _L4; else goto _L6
_L6:
        ebaycontext = ((List)synchronousfollowedsearchesloadedobserver.userResultContent.getData()).iterator();
_L7:
        j = i;
        if (!ebaycontext.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s.put((FollowDescriptor)ebaycontext.next(), null);
        if (true) goto _L7; else goto _L4
_L2:
        s = ebaycontext;
        if (ebaycontext == null)
        {
            s = new Content(ResultStatus.CANCELED);
        }
        if (observer != null)
        {
            observer.onFollowedSearchesLoaded(synchronousfollowedsearchesloadedobserver.dm, synchronousfollowedsearchesloadedobserver.interestResultContent);
            observer.onFollowedUsersLoaded(synchronousfollowedsearchesloadedobserver.dm, synchronousfollowedsearchesloadedobserver.userResultContent);
            observer.onFollowedCollectionsLoaded(synchronousfollowedsearchesloadedobserver.dm, synchronousfollowedsearchesloadedobserver.collectionResultContent);
        }
        return s;
_L4:
        i = j;
        if (synchronousfollowedsearchesloadedobserver.collectionResultContent == null) goto _L9; else goto _L8
_L8:
        i = j;
        if (synchronousfollowedsearchesloadedobserver.collectionResultContent.getStatus().hasError()) goto _L9; else goto _L10
_L10:
        j++;
        i = j;
        if (synchronousfollowedsearchesloadedobserver.collectionResultContent.getData() == null) goto _L9; else goto _L11
_L11:
        ebaycontext = ((List)synchronousfollowedsearchesloadedobserver.collectionResultContent.getData()).iterator();
_L12:
        i = j;
        if (!ebaycontext.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s.put((FollowDescriptor)ebaycontext.next(), null);
        if (true) goto _L12; else goto _L9
_L9:
        ebaycontext = obj;
        if (i == 3)
        {
            try
            {
                ebaycontext = new Content(s, ResultStatus.SUCCESS);
            }
            // Misplaced declaration of an exception variable
            catch (EbayContext ebaycontext)
            {
                ebaycontext = obj;
            }
        }
        if (true) goto _L2; else goto _L13
_L13:
    }

    private void getInterests(String s, String s1, List list, int i, com.ebay.common.net.api.followinterest.GetInterestsLoadTask.Observer observer)
    {
        observer = new GetInterestsLoadTask(getEbayContext(), observer);
        com.ebay.common.net.api.followinterest.GetInterestsLoadTask.Params params = new com.ebay.common.net.api.followinterest.GetInterestsLoadTask.Params();
        params.maxInterestsPerRequest = i;
        params.interestIds = list;
        params.iafToken = s;
        params.marketPlaceId = s1;
        params.cacheConfig = new com.ebay.common.net.api.followinterest.GetInterestsLoadTask.CacheConfig() {

            final FollowedEntityDataManager this$0;

            public boolean enablePersistence()
            {
                return config.enablePersistentCache();
            }

            public long getMaxTtl()
            {
                return config.getInterestCacheTtl();
            }

            
            {
                this$0 = FollowedEntityDataManager.this;
                super();
            }
        };
        executeOnThreadPool(observer, new com.ebay.common.net.api.followinterest.GetInterestsLoadTask.Params[] {
            params
        });
    }

    private void invalidateCoordinatedData()
    {
        Object obj = getEbayContext();
        UssContentsDataManager.invalidateActivityChannelData(((EbayContext) (obj)), new ContentSourceEnum[] {
            ContentSourceEnum.FOLLOW
        });
        FollowingContentDataManager followingcontentdatamanager = (FollowingContentDataManager)FollowingContentDataManager.getIfExists(((EbayContext) (obj)), FollowingContentDataManager.KEY);
        if (followingcontentdatamanager != null)
        {
            followingcontentdatamanager.flush();
        }
        obj = (UssFeedDataManager)UssFeedDataManager.getIfExists(((EbayContext) (obj)), UssFeedDataManager.KEY);
        if (obj != null)
        {
            ((UssFeedDataManager) (obj)).invalidateData();
        }
    }

    public static void purgeCache(Context context)
    {
        setFollowState(null);
        GetFollowsLoadTask.invalidateCache(context);
        GetInterestsLoadTask.invalidateCache();
    }

    private static void setFollowState(FollowState followstate)
    {
        NautilusKernel.verifyMain();
        _followCache = followstate;
    }

    public void QA_followInterest(String s, String s1, String s2, String s3, final Runnable onComplete)
    {
        InterestDescriptor interestdescriptor = new InterestDescriptor();
        interestdescriptor.interestId = Long.parseLong(s1, 10);
        s1 = new CreateFollowLoadTask(getEbayContext(), new com.ebay.common.net.api.followinterest.CreateFollowLoadTask.Observer() {

            final FollowedEntityDataManager this$0;
            final Runnable val$onComplete;

            public void handleFollowCreated(CreateFollowLoadTask createfollowloadtask, Content content)
            {
                if (onComplete != null)
                {
                    onComplete.run();
                }
            }

            
            {
                this$0 = FollowedEntityDataManager.this;
                onComplete = runnable;
                super();
            }
        });
        onComplete = new com.ebay.common.net.api.followinterest.CreateFollowLoadTask.Params();
        onComplete.interestDescriptor = interestdescriptor;
        onComplete.iafToken = s;
        onComplete.customTitle = s3;
        onComplete.followType = FollowType.INTEREST;
        onComplete.marketPlaceId = s2;
        executeOnThreadPool(s1, new com.ebay.common.net.api.followinterest.CreateFollowLoadTask.Params[] {
            onComplete
        });
    }

    public void TEST_deleteFollowedInterest(FollowDescriptor followdescriptor, String s)
    {
        deleteFollow(FollowType.INTEREST, followdescriptor.getInterestId(), s);
    }

    public void TEST_updateFollow(String s, FollowDescriptor followdescriptor, String s1, List list)
    {
        if (followdescriptor == null)
        {
            return;
        } else
        {
            final String interestId = followdescriptor.getInterestId();
            Object obj = new com.ebay.common.net.api.followinterest.UpdateFollowLoadTask.Observer() ;
            obj = new UpdateFollowLoadTask(getEbayContext(), ((com.ebay.common.net.api.followinterest.UpdateFollowLoadTask.Observer) (obj)));
            com.ebay.common.net.api.followinterest.UpdateFollowLoadTask.Params params = new Params();
            params.iafToken = s;
            params.entityId = interestId;
            params.followType = FollowType.INTEREST;
            params.customTitle = s1;
            params.notifications = list;
            params.marketPlaceId = followdescriptor.interest.marketplaceId;
            executeOnThreadPool(((android.os.AsyncTask) (obj)), new com.ebay.common.net.api.followinterest.UpdateFollowLoadTask.Params[] {
                params
            });
            return;
        }
    }

    public void configChanged()
    {
        followerCache = new HashMap();
    }

    public void deleteFollow(final FollowType followType, final String id, String s)
    {
        Object obj = new com.ebay.common.net.api.followinterest.DeleteFollowLoadTask.Observer() ;
        obj = new DeleteFollowLoadTask(getEbayContext(), ((com.ebay.common.net.api.followinterest.DeleteFollowLoadTask.Observer) (obj)));
        com.ebay.common.net.api.followinterest.DeleteFollowLoadTask.Params params = new Params();
        params.followType = followType;
        params.id = id;
        params.iafToken = s;
        executeOnThreadPool(((android.os.AsyncTask) (obj)), new com.ebay.common.net.api.followinterest.DeleteFollowLoadTask.Params[] {
            params
        });
    }

    public void deleteFollowedSearchByName(final String searchName, final String iafToken)
    {
        if (!FollowSvcShared.isMain())
        {
            runOnMainThread(new Runnable() {

                final FollowedEntityDataManager this$0;
                final String val$iafToken;
                final String val$searchName;

                public void run()
                {
                    deleteFollowedSearchByNameInternal(searchName, iafToken);
                }

            
            {
                this$0 = FollowedEntityDataManager.this;
                searchName = s;
                iafToken = s1;
                super();
            }
            });
            return;
        } else
        {
            deleteFollowedSearchByNameInternal(searchName, iafToken);
            return;
        }
    }

    public void followCollection(final String collectionId, String s)
    {
        com.ebay.common.net.api.followinterest.CreateFollowLoadTask.Observer observer = new com.ebay.common.net.api.followinterest.CreateFollowLoadTask.Observer() ;
        createFollowForCollection(getCurrentUser().iafToken, collectionId, s, observer);
    }

    public void followExistingInterest(InterestDescriptor interestdescriptor, String s, String s1, final Observer onCompleteObserver)
    {
        followSearchOrchestrator.createFollowForInterest(interestdescriptor, s, s1, new SimpleObserver() );
    }

    public Content followSearchSynchronous(SearchParameters searchparameters, String s)
    {
        return followSearchOrchestrator.createFollowForSearchSynchronous(searchparameters, s);
    }

    public void followUser(final String username, String s)
    {
        Authentication authentication = getCurrentUser();
        if (authentication == null)
        {
            return;
        } else
        {
            com.ebay.common.net.api.followinterest.CreateFollowLoadTask.Observer observer = new com.ebay.common.net.api.followinterest.CreateFollowLoadTask.Observer() ;
            createFollowForUser(authentication.iafToken, username, s, observer);
            return;
        }
    }

    public FollowDescriptor getFollowByInterestId(String s)
    {
        NautilusKernel.verifyMain();
        FollowState followstate = getFollowState();
        if (followstate != null)
        {
            return followstate.getFollowByInterestId(s);
        } else
        {
            return null;
        }
    }

    public void getFollowers(final FollowType followType, final String id, String s, Observer observer, boolean flag)
    {
        if (logger.isLoggable)
        {
            logger.log("getFollowers");
        }
        if (flag || followerCache == null || !followerCache.containsKey(followType)) goto _L2; else goto _L1
_L1:
        com.ebay.common.net.api.followinterest.GetFollowersLoadTask.FollowerSummary followersummary = (com.ebay.common.net.api.followinterest.GetFollowersLoadTask.FollowerSummary)((LruCache)followerCache.get(followType)).get(id);
        if (followersummary == null) goto _L2; else goto _L3
_L3:
        if (logger.isLoggable)
        {
            logger.log("getFollowers - delivering from cache");
        }
        if (observer != null)
        {
            observer.onFollowersLoaded(followType, new Content(followersummary, ResultStatus.SUCCESS));
        }
_L5:
        return;
_L2:
        Object obj = getCurrentUser();
        if (obj != null)
        {
            obj = ((Authentication) (obj)).iafToken;
        } else
        {
            obj = null;
        }
        if (obj == null)
        {
            if (logger.isLoggable)
            {
                logger.log("getFollowers - cancel - iafToken required");
            }
            if (observer != null)
            {
                observer.onFollowersLoaded(followType, new Content(ResultStatus.CANCELED));
                return;
            }
        } else
        {
            observer = new com.ebay.common.net.api.followinterest.GetFollowersLoadTask.Observer() ;
            observer = new GetFollowersLoadTask(getEbayContext(), observer);
            com.ebay.common.net.api.followinterest.GetFollowersLoadTask.Params params = new Params();
            params.iafToken = ((String) (obj));
            params.marketPlaceId = s;
            params.id = id;
            params.followType = followType;
            executeOnThreadPool(observer, new com.ebay.common.net.api.followinterest.GetFollowersLoadTask.Params[] {
                params
            });
            return;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void getFollows(String s, EbaySite ebaysite, boolean flag)
    {
        NautilusKernel.verifyMain();
        retrieveAndPopulateFollowsOrchestrator.getFollows(s, ebaysite, flag);
    }

    public void loadData(Observer observer)
    {
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public void setConfig(FollowInterestConfig followinterestconfig)
    {
        if (followinterestconfig == null)
        {
            throw new InvalidParameterException("FollowInterestDataManager.setConfig(): 'config' cannot be null");
        } else
        {
            config = followinterestconfig;
            configChanged();
            return;
        }
    }

    public void updateSavedSearchNotifications(final String maxThreads, final EbaySite pendingUpdates, Map map)
    {
        NautilusKernel.verifyNotMain();
        pendingUpdates = getFollowsSynchronous(getEbayContext(), maxThreads, pendingUpdates, false, null);
        if (pendingUpdates != null && !pendingUpdates.getStatus().hasError())
        {
            pendingUpdates = (Map)pendingUpdates.getData();
            ArrayList arraylist = new ArrayList();
            Iterator iterator = pendingUpdates.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                FollowDescriptor followdescriptor = (FollowDescriptor)((java.util.Map.Entry)iterator.next()).getKey();
                if (followdescriptor.type == FollowType.INTEREST)
                {
                    String s = followdescriptor.getInterestId();
                    pendingUpdates = Collections.emptyList();
                    if (map.containsKey(s))
                    {
                        pendingUpdates = (List)map.get(s);
                    }
                    boolean flag;
                    boolean flag1;
                    if (pendingUpdates != null && !pendingUpdates.isEmpty())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (followdescriptor.notifications != null && !followdescriptor.notifications.isEmpty())
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (flag != flag1)
                    {
                        FollowDescriptor followdescriptor1 = FollowDescriptor.create(followdescriptor);
                        followdescriptor1.interest = followdescriptor.interest;
                        followdescriptor1.notifications = pendingUpdates;
                        pendingUpdates = new Params();
                        pendingUpdates.iafToken = maxThreads;
                        pendingUpdates.entityId = s;
                        pendingUpdates.followType = FollowType.INTEREST;
                        pendingUpdates.notifications = followdescriptor1.notifications;
                        pendingUpdates.originalFollow = followdescriptor;
                        pendingUpdates.marketPlaceId = followdescriptor.interest.marketplaceId;
                        arraylist.add(pendingUpdates);
                    }
                }
            } while (true);
            pendingUpdates = new AtomicInteger(arraylist.size());
            maxThreads = new Semaphore(3);
            pendingUpdates = new com.ebay.common.net.api.followinterest.UpdateFollowLoadTask.Observer() ;
            map = arraylist.iterator();
            while (map.hasNext()) 
            {
                com.ebay.common.net.api.followinterest.UpdateFollowLoadTask.Params params = (com.ebay.common.net.api.followinterest.UpdateFollowLoadTask.Params)map.next();
                try
                {
                    maxThreads.acquire();
                }
                // Misplaced declaration of an exception variable
                catch (final String maxThreads)
                {
                    logger.log("updateSavedSearchNotifications() was interrupted; update is incomplete, but will be synchronized upon next update");
                    return;
                }
                executeOnThreadPool(new UpdateFollowLoadTask(getEbayContext(), pendingUpdates), new com.ebay.common.net.api.followinterest.UpdateFollowLoadTask.Params[] {
                    params
                });
            }
        }
    }

    static 
    {
        KEY = KeyParams.KEY;
    }



































    // Unreferenced inner class com/ebay/common/content/dm/FollowedEntityDataManager$FollowSearchOrchestrator$1

/* anonymous class */
}
