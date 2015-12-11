// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import android.text.TextUtils;
import com.ebay.common.model.followinterest.FollowDescriptor;
import com.ebay.common.model.followinterest.FollowType;
import com.ebay.common.net.api.followinterest.CreateFollowLoadTask;
import com.ebay.common.net.api.followinterest.CreateInterestLoadTask;
import com.ebay.common.net.api.followinterest.InterestDescriptor;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.ebay.common.content.dm:
//            FollowedEntityDataManager

private class <init>
{

    final FollowedEntityDataManager this$0;

    private void createFollowForInterest(final InterestDescriptor interestDescriptor, String s, String s1, final <init> completionObserver)
    {
        completionObserver = new com.ebay.common.net.api.followinterest.CreateFollowLoadTask.Observer() {

            final FollowedEntityDataManager.FollowSearchOrchestrator this$1;
            final FollowedEntityDataManager.Observer val$completionObserver;
            final InterestDescriptor val$interestDescriptor;

            public void handleFollowCreated(CreateFollowLoadTask createfollowloadtask, Content content)
            {
                NautilusKernel.verifyMain();
                if (createfollowloadtask == null || createfollowloadtask.isCancelled() || content == null || content.getStatus().hasError())
                {
                    if (FollowedEntityDataManager.access$200().isLoggable)
                    {
                        FollowedEntityDataManager.access$200().log("FollowSearchOrchestrator: createFollowForInterest failed");
                    }
                    completionObserver.onSearchFollowed(content);
                    return;
                }
                createfollowloadtask = FollowedEntityDataManager.access$1200();
                if (createfollowloadtask != null)
                {
                    createfollowloadtask.removeFollow(FollowType.INTEREST, Long.toString(interestDescriptor.interestId));
                    createfollowloadtask.addFollow(FollowType.INTEREST, (FollowDescriptor)content.getData());
                }
                FollowedEntityDataManager.access$800(this$0).setDirty();
                completionObserver.onSearchFollowed(content);
                FollowedEntityDataManager.access$1400(this$0);
            }

            
            {
                this$1 = FollowedEntityDataManager.FollowSearchOrchestrator.this;
                completionObserver = observer;
                interestDescriptor = interestdescriptor;
                super();
            }
        };
        FollowedEntityDataManager.access$3900(FollowedEntityDataManager.this, s1, interestDescriptor, s, completionObserver);
    }

    private void createFollowForSearchInternal(final SearchParameters params, final String customTitle, final this._cls0 completionObserver)
    {
        customTitle = new com.ebay.common.net.api.followinterest.CreateInterestLoadTask.Observer() {

            final FollowedEntityDataManager.FollowSearchOrchestrator this$1;
            final FollowedEntityDataManager.Observer val$completionObserver;
            final String val$customTitle;
            final SearchParameters val$params;

            public void handleInterestCreated(CreateInterestLoadTask createinterestloadtask, Content content)
            {
                if (createinterestloadtask == null || createinterestloadtask.isCancelled() || content.getStatus().hasError())
                {
                    if (FollowedEntityDataManager.access$200().isLoggable)
                    {
                        FollowedEntityDataManager.access$200().log("FollowSearchOrchestrator: createFollowForSearch failed");
                    }
                    if (content == null)
                    {
                        createinterestloadtask = null;
                    } else
                    {
                        createinterestloadtask = content.getStatus();
                    }
                    completionObserver.onSearchFollowed(new Content(createinterestloadtask));
                    return;
                }
                String s = params.iafToken;
                createinterestloadtask = s;
                if (TextUtils.isEmpty(s))
                {
                    Authentication authentication = FollowedEntityDataManager.access$3700(this$0);
                    createinterestloadtask = s;
                    if (authentication != null)
                    {
                        createinterestloadtask = authentication.iafToken;
                    }
                }
                createFollowForInterest((InterestDescriptor)content.getData(), customTitle, createinterestloadtask, completionObserver);
            }

            
            {
                this$1 = FollowedEntityDataManager.FollowSearchOrchestrator.this;
                completionObserver = observer;
                params = searchparameters;
                customTitle = s;
                super();
            }
        };
        FollowedEntityDataManager.access$3800(FollowedEntityDataManager.this, params.iafToken, params, customTitle);
    }

    public void createFollowForSearch(SearchParameters searchparameters, String s)
    {
        createFollowForSearchInternal(searchparameters, s, (createFollowForSearchInternal)FollowedEntityDataManager.access$3500(FollowedEntityDataManager.this));
    }

    public Content createFollowForSearchSynchronous(SearchParameters searchparameters, String s)
    {
        NautilusKernel.verifyNotMain();
        final this._cls0 syncState = new this._cls0(FollowedEntityDataManager.this);
        createFollowForSearchInternal(searchparameters, s, new FollowedEntityDataManager.SimpleObserver() {

            final FollowedEntityDataManager.FollowSearchOrchestrator this$1;
            final FollowedEntityDataManager.SyncResult val$syncState;

            public void onSearchFollowed(Content content)
            {
                ((FollowedEntityDataManager.Observer)FollowedEntityDataManager.access$3600(this$0)).onSearchFollowed(content);
                syncState.result = content;
                syncState.wait.countDown();
            }

            
            {
                this$1 = FollowedEntityDataManager.FollowSearchOrchestrator.this;
                syncState = syncresult;
                super();
            }
        });
        try
        {
            syncState.syncState.await(FollowedEntityDataManager.access$500(FollowedEntityDataManager.this).axAggregateOperationTimeoutMs(), TimeUnit.MILLISECONDS);
        }
        // Misplaced declaration of an exception variable
        catch (SearchParameters searchparameters)
        {
            searchparameters = new Content(ResultStatus.CANCELED);
            return new Content(searchparameters.getData(), searchparameters.getStatus());
        }
        return syncState.axAggregateOperationTimeoutMs;
    }


    private _cls3.val.interestDescriptor()
    {
        this$0 = FollowedEntityDataManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
