// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.InternalDomainError;
import com.ebay.nautilus.domain.data.FollowingContent;
import com.ebay.nautilus.domain.data.HiddenFollows;
import com.ebay.nautilus.domain.net.api.feed.FeedRequest;
import com.ebay.nautilus.domain.net.api.feed.FeedResponse;
import com.ebay.nautilus.domain.net.api.feed.HiddenFollowsRequest;
import com.ebay.nautilus.domain.net.api.feed.HiddenFollowsResponse;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserContextObservingDataManager, UserContextDataManager

public class FollowingContentDataManager extends UserContextObservingDataManager
{
    public static final class KeyParams extends UserContextObservingDataManager.KeyBase
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return FollowingContentDataManager.KEY;
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public KeyParams[] newArray(int i)
            {
                return new KeyParams[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };

        public FollowingContentDataManager create(EbayContext ebaycontext)
        {
            return new FollowingContentDataManager(ebaycontext);
        }

        public volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }


        protected KeyParams()
        {
        }
    }

    private final class LoadTask extends AsyncTask
    {

        private final EbayCountry country;
        private final String iafToken;
        final FollowingContentDataManager this$0;

        protected transient Content doInBackground(Void avoid[])
        {
            if (FollowingContentDataManager.log.isLoggable)
            {
                FollowingContentDataManager.log.log((new StringBuilder()).append("Starting background task: ").append(this).toString());
            }
            if (iafToken != null) goto _L2; else goto _L1
_L1:
            avoid = ResultStatus.create(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                InternalDomainError.getPleaseSignInMessage()
            });
_L4:
            return new Content(avoid);
_L2:
            if (country != null)
            {
                break; /* Loop/switch isn't completed */
            }
            avoid = ResultStatus.create(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                InternalDomainError.getCountryNotSpecifiedMessage()
            });
            if (true) goto _L4; else goto _L3
_L3:
            ResultStatus resultstatus;
            FeedResponse feedresponse;
            try
            {
                feedresponse = (FeedResponse)sendRequest(new FeedRequest(iafToken, country));
                resultstatus = feedresponse.getResultStatus();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return null;
            }
            avoid = resultstatus;
            if (resultstatus.hasError()) goto _L4; else goto _L5
_L5:
            avoid = new Content(new FollowingContent(feedresponse.feed), resultstatus);
            return avoid;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleLoadDataResult(this, null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleLoadDataResult(this, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public LoadTask(EbayCountry ebaycountry, String s)
        {
            this$0 = FollowingContentDataManager.this;
            super();
            country = ebaycountry;
            iafToken = s;
        }
    }

    public static interface Observer
    {

        public abstract void onFollowingContentChanged(FollowingContentDataManager followingcontentdatamanager, Content content);

        public abstract void onSetFollowedEntityIsHiddenComplete(FollowingContentDataManager followingcontentdatamanager, Content content);
    }

    private final class UpdateTask extends AsyncTask
    {

        private final EbayCountry country;
        final com.ebay.nautilus.domain.data.FollowingContent.FollowedEntity entity;
        private final String iafToken;
        final Observer observer;
        final FollowingContentDataManager this$0;

        protected transient Content doInBackground(com.ebay.nautilus.domain.net.api.feed.HiddenFollowsRequest.Params aparams[])
        {
            if (FollowingContentDataManager.log.isLoggable)
            {
                FollowingContentDataManager.log.log((new StringBuilder()).append("Starting background task: ").append(this).toString());
            }
            if (iafToken != null) goto _L2; else goto _L1
_L1:
            aparams = ResultStatus.create(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                InternalDomainError.getPleaseSignInMessage()
            });
_L4:
            return new Content(aparams);
_L2:
            if (country != null)
            {
                break; /* Loop/switch isn't completed */
            }
            aparams = ResultStatus.create(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                InternalDomainError.getCountryNotSpecifiedMessage()
            });
            if (true) goto _L4; else goto _L3
_L3:
            if (aparams == null)
            {
                break MISSING_BLOCK_LABEL_160;
            }
            if (aparams.length <= 0)
            {
                break MISSING_BLOCK_LABEL_160;
            }
            aparams = aparams[0];
_L6:
            ResultStatus resultstatus;
            HiddenFollowsResponse hiddenfollowsresponse;
            try
            {
                hiddenfollowsresponse = (HiddenFollowsResponse)sendRequest(new HiddenFollowsRequest(iafToken, country, aparams));
                resultstatus = hiddenfollowsresponse.getResultStatus();
            }
            // Misplaced declaration of an exception variable
            catch (com.ebay.nautilus.domain.net.api.feed.HiddenFollowsRequest.Params aparams[])
            {
                return null;
            }
            aparams = resultstatus;
            if (resultstatus.hasError()) goto _L4; else goto _L5
_L5:
            aparams = new Content(hiddenfollowsresponse.hiddenFollows, resultstatus);
            return aparams;
            aparams = null;
              goto _L6
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((com.ebay.nautilus.domain.net.api.feed.HiddenFollowsRequest.Params[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleUpdateDataResult(this, null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleUpdateDataResult(this, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public UpdateTask(Observer observer1, com.ebay.nautilus.domain.data.FollowingContent.FollowedEntity followedentity, EbayCountry ebaycountry, Authentication authentication)
        {
            this$0 = FollowingContentDataManager.this;
            super();
            observer = observer1;
            entity = followedentity;
            country = ebaycountry;
            if (authentication != null)
            {
                followingcontentdatamanager = authentication.iafToken;
            } else
            {
                followingcontentdatamanager = null;
            }
            iafToken = FollowingContentDataManager.this;
        }
    }


    public static final KeyParams KEY = new KeyParams();
    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("FollowingContent", 3, "FollowingContentDataManager");
    private Content data;
    private boolean initialized;
    private HiddenFollows lastUpdateSuccessResult;
    private LoadTask loadTask;
    private com.ebay.nautilus.domain.net.api.feed.HiddenFollowsRequest.Params updateParams;
    private final LinkedList updateTasks = new LinkedList();

    FollowingContentDataManager(EbayContext ebaycontext)
    {
        super(ebaycontext, com/ebay/nautilus/domain/content/dm/FollowingContentDataManager$Observer, KEY);
        initialized = false;
        data = null;
    }

    private void cancelTasks()
    {
        NautilusKernel.verifyMain();
        if (loadTask != null)
        {
            loadTask.cancel(true);
            loadTask = null;
        }
        cancelUpdateTasks();
    }

    private void cancelUpdateTasks()
    {
        NautilusKernel.verifyMain();
        for (Iterator iterator = updateTasks.iterator(); iterator.hasNext(); ((UpdateTask)iterator.next()).cancel(true)) { }
        updateTasks.clear();
        updateParams = null;
    }

    private void updateFollowedEntity(com.ebay.nautilus.domain.data.FollowingContent.FollowedEntity followedentity, HiddenFollows hiddenfollows)
    {
        if (followedentity == null || hiddenfollows == null) goto _L2; else goto _L1
_L1:
        followedentity.hiddenFeedEvents = false;
        if (hiddenfollows.hiddenInterests == null) goto _L4; else goto _L3
_L3:
        Iterator iterator = hiddenfollows.hiddenInterests.iterator();
_L7:
        if (!iterator.hasNext()) goto _L4; else goto _L5
_L5:
        if (!followedentity.equals((com.ebay.nautilus.domain.data.HiddenFollows.HiddenInterest)iterator.next())) goto _L7; else goto _L6
_L6:
        followedentity.hiddenFeedEvents = true;
_L2:
        return;
_L4:
        if (hiddenfollows.hiddenUsers == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        Iterator iterator1 = hiddenfollows.hiddenUsers.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
        } while (!followedentity.equals((com.ebay.nautilus.domain.data.HiddenFollows.HiddenUser)iterator1.next()));
        followedentity.hiddenFeedEvents = true;
        return;
        if (hiddenfollows.hiddenCollections == null) goto _L2; else goto _L8
_L8:
        hiddenfollows = hiddenfollows.hiddenCollections.iterator();
        while (hiddenfollows.hasNext()) 
        {
            if (followedentity.equals((com.ebay.nautilus.domain.data.HiddenFollows.HiddenCollection)hiddenfollows.next()))
            {
                followedentity.hiddenFeedEvents = true;
                return;
            }
        }
        if (true) goto _L2; else goto _L9
_L9:
    }

    private void updateFollowingContent(HiddenFollows hiddenfollows)
    {
        if (data != null && hiddenfollows != null)
        {
            FollowingContent followingcontent = (FollowingContent)data.getData();
            if (followingcontent != null && followingcontent.followedEntities != null)
            {
                HashMap hashmap2 = new HashMap();
                HashMap hashmap1 = new HashMap();
                HashMap hashmap = new HashMap();
                if (followingcontent.followedEntities.interests != null)
                {
                    for (Iterator iterator1 = followingcontent.followedEntities.interests.iterator(); iterator1.hasNext();)
                    {
                        com.ebay.nautilus.domain.data.FollowingContent.FollowedInterest followedinterest = (com.ebay.nautilus.domain.data.FollowingContent.FollowedInterest)iterator1.next();
                        hashmap2.put(followedinterest.interestId, followedinterest);
                        followedinterest.hiddenFeedEvents = false;
                    }

                }
                if (followingcontent.followedEntities.users != null)
                {
                    for (Iterator iterator2 = followingcontent.followedEntities.users.iterator(); iterator2.hasNext();)
                    {
                        com.ebay.nautilus.domain.data.FollowingContent.FollowedUser followeduser1 = (com.ebay.nautilus.domain.data.FollowingContent.FollowedUser)iterator2.next();
                        hashmap1.put(followeduser1.username, followeduser1);
                        followeduser1.hiddenFeedEvents = false;
                    }

                }
                if (followingcontent.followedEntities.collections != null)
                {
                    for (Iterator iterator3 = followingcontent.followedEntities.collections.iterator(); iterator3.hasNext();)
                    {
                        com.ebay.nautilus.domain.data.FollowingContent.FollowedCollection followedcollection1 = (com.ebay.nautilus.domain.data.FollowingContent.FollowedCollection)iterator3.next();
                        hashmap.put(followedcollection1.collectionId, followedcollection1);
                        followedcollection1.hiddenFeedEvents = false;
                    }

                }
                if (hiddenfollows.hiddenInterests != null)
                {
                    Iterator iterator4 = hiddenfollows.hiddenInterests.iterator();
                    do
                    {
                        if (!iterator4.hasNext())
                        {
                            break;
                        }
                        com.ebay.nautilus.domain.data.FollowingContent.FollowedInterest followedinterest1 = (com.ebay.nautilus.domain.data.FollowingContent.FollowedInterest)hashmap2.get(((com.ebay.nautilus.domain.data.HiddenFollows.HiddenInterest)iterator4.next()).interestId);
                        if (followedinterest1 != null)
                        {
                            followedinterest1.hiddenFeedEvents = true;
                        }
                    } while (true);
                }
                if (followingcontent.followedEntities.users != null)
                {
                    Iterator iterator = hiddenfollows.hiddenUsers.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        com.ebay.nautilus.domain.data.FollowingContent.FollowedUser followeduser = (com.ebay.nautilus.domain.data.FollowingContent.FollowedUser)hashmap1.get(((com.ebay.nautilus.domain.data.HiddenFollows.HiddenUser)iterator.next()).username);
                        if (followeduser != null)
                        {
                            followeduser.hiddenFeedEvents = true;
                        }
                    } while (true);
                }
                if (followingcontent.followedEntities.collections != null)
                {
                    hiddenfollows = hiddenfollows.hiddenCollections.iterator();
                    do
                    {
                        if (!hiddenfollows.hasNext())
                        {
                            break;
                        }
                        com.ebay.nautilus.domain.data.FollowingContent.FollowedCollection followedcollection = (com.ebay.nautilus.domain.data.FollowingContent.FollowedCollection)hashmap.get(((com.ebay.nautilus.domain.data.HiddenFollows.HiddenCollection)hiddenfollows.next()).collectionId);
                        if (followedcollection != null)
                        {
                            followedcollection.hiddenFeedEvents = true;
                        }
                    } while (true);
                }
            }
        }
    }

    protected void create()
    {
        super.create();
        initialized = true;
    }

    public void flush()
    {
        NautilusKernel.verifyMain();
        if (log.isLoggable)
        {
            log.log("flushing cache");
        }
        cancelTasks();
        data = null;
    }

    void handleLoadDataResult(LoadTask loadtask, Content content)
    {
        if (log.isLoggable)
        {
            log.log("handleLoadDataResult");
        }
        if (loadTask == loadtask)
        {
            loadTask = null;
            updateParams = null;
        }
        if (content != null)
        {
            if (!content.getStatus().hasError())
            {
                data = content;
            }
            ((Observer)dispatcher).onFollowingContentChanged(this, content);
            if (log.isLoggable)
            {
                log.log("handleLoadDataResult:  dispatched onFollowingContentChanged to all observers");
                return;
            }
        }
    }

    void handleUpdateDataResult(UpdateTask updatetask, Content content)
    {
        if (log.isLoggable)
        {
            log.log("handleUpdateDataResult");
        }
        if (content != null)
        {
            ResultStatus resultstatus = content.getStatus();
            content = (HiddenFollows)content.getData();
            UpdateTask updatetask1;
            do
            {
                updatetask1 = (UpdateTask)updateTasks.remove();
                updateFollowedEntity(updatetask1.entity, content);
                updatetask1.observer.onSetFollowedEntityIsHiddenComplete(this, new Content(updatetask1.entity, resultstatus));
                if (log.isLoggable)
                {
                    log.log("handleUpdateDataResult:  dispatched onSetFollowedEntityIsHiddenComplete");
                }
            } while (updatetask1 != updatetask);
            if (resultstatus != null && !resultstatus.hasError())
            {
                lastUpdateSuccessResult = content;
            }
        } else
        {
            while ((UpdateTask)updateTasks.remove() != updatetask) ;
        }
        if (updateTasks.isEmpty())
        {
            if (data != null && lastUpdateSuccessResult != null)
            {
                updateFollowingContent(lastUpdateSuccessResult);
                ((Observer)dispatcher).onFollowingContentChanged(this, data);
                if (log.isLoggable)
                {
                    log.log("handleUpdateDataResult:  dispatched onFollowingContentChanged to all observers");
                }
            }
            lastUpdateSuccessResult = null;
            return;
        } else
        {
            executeOnThreadPool((AsyncTask)updateTasks.getLast(), new com.ebay.nautilus.domain.net.api.feed.HiddenFollowsRequest.Params[] {
                updateParams
            });
            return;
        }
    }

    public void invalidateAndForceReloadData()
    {
        flush();
        loadData(((Observer) (null)));
    }

    public void loadData(Observer observer)
    {
        Authentication authentication;
        NautilusKernel.verifyMain();
        authentication = getCurrentUser();
        if (authentication != null) goto _L2; else goto _L1
_L1:
        Content content;
        flush();
        content = new Content(new FollowingContent(null));
_L6:
        if (observer != null && content != null)
        {
            observer.onFollowingContentChanged(this, content);
        }
_L4:
        return;
_L2:
        if (loadTask != null) goto _L4; else goto _L3
_L3:
        cancelUpdateTasks();
        Content content1 = data;
        content = content1;
        if (content1 == null)
        {
            loadTask = new LoadTask(getCurrentCountry(), authentication.iafToken);
            executeOnThreadPool(loadTask, new Void[0]);
            content = content1;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public void onCurrentUserChanged(UserContextDataManager usercontextdatamanager, String s, String s1, boolean flag)
    {
        super.onCurrentUserChanged(usercontextdatamanager, s, s1, flag);
        if (initialized)
        {
            if (log.isLoggable)
            {
                log.log((new StringBuilder()).append("onCurrentUserChanged userId=").append(s).append(" iafToken=").append(s1).toString());
            }
            if (!flag)
            {
                flush();
                if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
                {
                    loadData(((Observer) (null)));
                    return;
                }
            }
        }
    }

    protected void onLastObserverUnregistered()
    {
        cancelTasks();
    }

    public void setFollowedEntityIsHidden(Observer observer, com.ebay.nautilus.domain.data.FollowingContent.FollowedEntity followedentity, boolean flag)
    {
        if (log.isLoggable)
        {
            log.log((new StringBuilder()).append("setFollowedEntityIsHidden: ").append(this).toString());
        }
        NautilusKernel.verifyMain();
        observer = (Observer)getSafeCallback(observer);
        if (loadTask != null)
        {
            return;
        }
        if (updateParams == null)
        {
            updateParams = new com.ebay.nautilus.domain.net.api.feed.HiddenFollowsRequest.Params((FollowingContent)data.getData());
        }
        updateParams.setFollowedEntityIsHidden(followedentity, flag);
        observer = new UpdateTask(observer, followedentity, getCurrentCountry(), getCurrentUser());
        if (updateTasks.isEmpty())
        {
            executeOnThreadPool(observer, new com.ebay.nautilus.domain.net.api.feed.HiddenFollowsRequest.Params[] {
                updateParams
            });
        }
        updateTasks.add(observer);
    }



}
