// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentTypeEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.Contents;
import com.ebay.nautilus.domain.data.UnifiedStream.OutputSelector;
import com.ebay.nautilus.domain.data.UnifiedStream.Pagination;
import com.ebay.nautilus.domain.data.UnifiedStream.PaginationInput;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.api.unifiedstream.UnifiedStreamRequest;
import com.ebay.nautilus.domain.net.api.unifiedstream.UnifiedStreamResponse;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.FwLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserContextObservingDataManager, UserContextDataManager, PagedListManager

public class UssFeedDataManager extends UserContextObservingDataManager
{
    private final class ContentsPageLoader extends PagedListManager
    {

        private final Authentication auth;
        private final EbayCountry country;
        final UssFeedDataManager this$0;

        private Pagination getPagination(List list, ContentSourceEnum contentsourceenum)
        {
label0:
            {
                if (list == null)
                {
                    break label0;
                }
                list = list.iterator();
                Pagination pagination;
                do
                {
                    if (!list.hasNext())
                    {
                        break label0;
                    }
                    pagination = (Pagination)list.next();
                } while (pagination.contentSource != contentsourceenum);
                return pagination;
            }
            return null;
        }

        protected ResultStatus getPage(int i, ArrayList arraylist)
            throws InterruptedException
        {
            Object obj;
            Object obj2;
            com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord contentrecord;
            int j;
            Object obj1 = UssFeedDataManager.getRequestParams(lastRequestTime, lastOutputPagination);
            obj2 = UssFeedDataManager.this;
            static class _cls1
            {

                static final int $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ContentTypeEnum[];

                static 
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ContentTypeEnum = new int[ContentTypeEnum.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ContentTypeEnum[ContentTypeEnum.DEALS_CATEGORY.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ContentTypeEnum[ContentTypeEnum.LISTING.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ContentTypeEnum[ContentTypeEnum.RTM_CAMPAIGN.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ContentTypeEnum[ContentTypeEnum.COLLECTION.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ContentTypeEnum[ContentTypeEnum.RPP_EVENT_GROUP.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            Iterator iterator;
            Iterator iterator1;
            com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing listing;
            if (auth != null)
            {
                obj = auth.iafToken;
            } else
            {
                obj = null;
            }
            obj1 = (UnifiedStreamResponse)((UssFeedDataManager) (obj2)).sendRequest(new UnifiedStreamRequest(((String) (obj)), country, ((com.ebay.nautilus.domain.net.api.unifiedstream.UnifiedStreamRequest.Params) (obj1))));
            obj = ((UnifiedStreamResponse) (obj1)).getResultStatus();
            lastRequestTime = ((UnifiedStreamResponse) (obj1)).requestTime;
            if (((ResultStatus) (obj)).hasError())
            {
                break MISSING_BLOCK_LABEL_463;
            }
            obj1 = ((UnifiedStreamResponse) (obj1)).streamContents;
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_463;
            }
            lastOutputPagination = ((Contents) (obj1)).paginationOutput.pagination;
            j = 0;
            i = 0;
            if (((Contents) (obj1)).contentGroups == null) goto _L2; else goto _L1
_L1:
            obj1 = ((Contents) (obj1)).contentGroups.iterator();
_L5:
            j = i;
            if (!((Iterator) (obj1)).hasNext()) goto _L2; else goto _L3
_L3:
            obj2 = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup)((Iterator) (obj1)).next();
            if (obj2 == null) goto _L5; else goto _L4
_L4:
            iterator = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj2)).contents.iterator();
            j = i;
_L8:
            i = j;
            if (!iterator.hasNext()) goto _L5; else goto _L6
_L6:
            contentrecord = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)iterator.next();
            if (contentrecord == null) goto _L8; else goto _L7
_L7:
            i = 1;
            if (contentrecord.type == null) goto _L10; else goto _L9
_L9:
            _cls1..SwitchMap.com.ebay.nautilus.domain.data.UnifiedStream.ContentTypeEnum[contentrecord.type.ordinal()];
            JVM INSTR tableswitch 1 2: default 260
        //                       1 266
        //                       2 266;
               goto _L11 _L12 _L12
_L11:
            j = i;
              goto _L8
_L12:
            iterator1 = contentrecord.listings.iterator();
_L14:
            j = i;
            if (!iterator1.hasNext()) goto _L8; else goto _L13
_L13:
            listing = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing)iterator1.next();
            arraylist.add(new FeedValueRecord(contentrecord.type, contentrecord.title, listing));
              goto _L14
_L10:
            j = i;
            if (!ContentSourceEnum.FEED.equals(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj2)).contentSource)) goto _L8; else goto _L15
_L15:
            j = i;
            if (contentrecord.feedEvent == null) goto _L8; else goto _L16
_L16:
            j = i;
            if (contentrecord.feedEvent.listings == null) goto _L8; else goto _L17
_L17:
            Iterator iterator2 = contentrecord.feedEvent.listings.iterator();
_L19:
            j = i;
            if (!iterator2.hasNext()) goto _L8; else goto _L18
_L18:
            com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing listing1 = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing)iterator2.next();
            arraylist.add(new FeedValueRecord(ContentTypeEnum.LISTING, contentrecord.title, listing1));
              goto _L19
              goto _L8
_L2:
            if (j == 0)
            {
                totalNumberOfItems = arraylist.size();
            }
            return ((ResultStatus) (obj));
        }

        protected void handleLoadListResult(ListContent listcontent)
        {
            ((Observer)
// JavaClassFileOutputException: get_constant: invalid tag

        protected void onLoadStarted()
        {
        }

        public ContentsPageLoader(EbayCountry ebaycountry, Authentication authentication)
        {
            this$0 = UssFeedDataManager.this;
            super(25);
            country = ebaycountry;
            auth = authentication;
            totalNumberOfItems = 0x7ffffffe;
            highestPageIndex = 0x7ffffffe;
        }
    }

    public class FeedValueRecord
    {

        public com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Collection collection;
        public com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing listing;
        public com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.RppEventGroup rppEventGroup;
        public com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm rtm;
        final UssFeedDataManager this$0;
        public String title;
        public ContentTypeEnum type;

        public FeedValueRecord(ContentTypeEnum contenttypeenum, String s, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Collection collection1)
        {
            this$0 = UssFeedDataManager.this;
            super();
            type = contenttypeenum;
            title = s;
            collection = collection1;
        }

        public FeedValueRecord(ContentTypeEnum contenttypeenum, String s, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing listing1)
        {
            this$0 = UssFeedDataManager.this;
            super();
            type = contenttypeenum;
            title = s;
            listing = listing1;
        }

        public FeedValueRecord(ContentTypeEnum contenttypeenum, String s, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.RppEventGroup rppeventgroup)
        {
            this$0 = UssFeedDataManager.this;
            super();
            type = contenttypeenum;
            title = s;
            rppEventGroup = rppeventgroup;
        }

        public FeedValueRecord(ContentTypeEnum contenttypeenum, String s, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm rtm1)
        {
            this$0 = UssFeedDataManager.this;
            super();
            type = contenttypeenum;
            title = s;
            rtm = rtm1;
        }
    }

    public static final class KeyParams extends UserContextObservingDataManager.KeyBase
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return UssFeedDataManager.KEY;
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

        public volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        public UssFeedDataManager create(EbayContext ebaycontext)
        {
            return new UssFeedDataManager(ebaycontext, this);
        }

        public boolean equals(Object obj)
        {
            return obj instanceof KeyParams;
        }

        public String toString()
        {
            return "UssFeedDataManager.KEY";
        }


        public KeyParams()
        {
        }
    }

    public static interface Observer
    {

        public abstract void onStreamListChanged(UssFeedDataManager ussfeeddatamanager, ListContent listcontent);
    }


    private static final List FEED_SELECTOR;
    public static final KeyParams KEY = new KeyParams();
    public static final int MAX_ENTRIES_PER_PAGE = 25;
    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new LogInfo("UssFeedDm", 3, "UnifiedStream Feed DataManager");
    private ContentsPageLoader contentsPageLoader;
    private boolean isCountryInitialized;
    private boolean isUserInitialized;
    protected List lastOutputPagination;
    protected long lastRequestTime;

    UssFeedDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        UserContextObservingDataManager(ebaycontext, com/ebay/nautilus/domain/content/dm/UssFeedDataManager$Observer, keyparams);
        lastRequestTime = 0L;
        isUserInitialized = false;
        isCountryInitialized = false;
        if (logger.isLoggable)
        {
            FwLog.logMethod(logger, new Object[] {
                keyparams
            });
        }
    }

    protected static com.ebay.nautilus.domain.net.api.unifiedstream.UnifiedStreamRequest.Params getRequestParams(long l, List list)
    {
        com.ebay.nautilus.domain.net.api.unifiedstream.UnifiedStreamRequest.Params params = new Params();
        params.outputSelector = FEED_SELECTOR;
        if (l > 0L)
        {
            params.lastRefreshedTag = EbayDateUtils.formatIso8601DateTime(new Date(l));
        }
        if (list != null && !list.isEmpty())
        {
            params.paginationInput = new PaginationInput();
            params.paginationInput.entriesPerPage = Integer.valueOf(25);
            params.paginationInput.pagination = list;
        }
        params.blended = false;
        return params;
    }

    public void invalidateAndForceReloadData()
    {
        contentsPageLoader = null;
        lastOutputPagination = null;
        lastRequestTime = 0L;
        loadPage(1, null);
    }

    public void invalidateData()
    {
        contentsPageLoader = null;
        lastOutputPagination = null;
        lastRequestTime = 0L;
    }

    public void loadData(Observer observer)
    {
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public void loadPage(int i, Observer observer)
    {
        if (i < 1)
        {
            throw new IllegalArgumentException("pageIndex must be larger than zero (0).");
        }
        NautilusKernel.verifyMain();
        Object obj = getCurrentCountry();
        if (obj == null)
        {
            throw new IllegalStateException("getCurrentCountry() returned null");
        }
        if (contentsPageLoader == null)
        {
            contentsPageLoader = new ContentsPageLoader(((EbayCountry) (obj)), getCurrentUser());
        }
        contentsPageLoader.load(i);
        obj = contentsPageLoader.getData();
        if (observer != null && obj != null)
        {
            observer.onStreamListChanged(this, ((ListContent) (obj)));
        }
    }

    public void onCurrentCountryChanged(UserContextDataManager usercontextdatamanager, EbayCountry ebaycountry)
    {
        if (logger.isLoggable)
        {
            FwLog.logMethod(logger, new Object[] {
                usercontextdatamanager, ebaycountry
            });
        }
        onCurrentCountryChanged(usercontextdatamanager, ebaycountry);
        if (!isCountryInitialized)
        {
            isCountryInitialized = true;
            return;
        } else
        {
            invalidateAndForceReloadData();
            return;
        }
    }

    public void onCurrentUserChanged(UserContextDataManager usercontextdatamanager, String s, String s1, boolean flag)
    {
        if (logger.isLoggable)
        {
            FwLog.logMethod(logger, new Object[] {
                usercontextdatamanager, s, s1, Boolean.valueOf(flag)
            });
        }
        onCurrentUserChanged(usercontextdatamanager, s, s1, flag);
        if (!isUserInitialized)
        {
            isUserInitialized = true;
        } else
        if (!flag)
        {
            invalidateAndForceReloadData();
            return;
        }
    }

    static 
    {
        FEED_SELECTOR = Collections.unmodifiableList(Collections.singletonList(new OutputSelector(ContentSourceEnum.FEED)));
    }


}
