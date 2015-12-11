// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ebay.common.Preferences;
import com.ebay.common.model.search.SavedSearch;
import com.ebay.common.net.api.finding.FindNewItemsForFavoriteSearch;
import com.ebay.common.net.api.followinterest.FollowedSearchApi;
import com.ebay.common.net.api.fuss.EbayFussApi;
import com.ebay.common.util.EbayDateFormat;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.search.SearchUtil;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.Duration;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingRequest;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.mobile.notifications:
//            ItemCache, NotificationPreferenceManager, DevLog, PollService

public final class PollServiceListCache
{
    private static final class GetMyEbayRequest extends EbayTradingRequest
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            return XmlSerializerHelper.buildXmlRequest(this);
        }

        public void buildXmlRequest(XmlSerializer xmlserializer)
            throws IOException
        {
            String s = (new StringBuilder()).append(getOperationName()).append("Request").toString();
            xmlserializer.setPrefix("", "urn:ebay:apis:eBLBaseComponents");
            xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", s);
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "DetailLevel", "ReturnSummary");
            XmlSerializerHelper.writeErrorLocale(xmlserializer, "urn:ebay:apis:eBLBaseComponents");
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "OutputSelector", "WatchList.ItemArray.Item.ItemID");
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "OutputSelector", "WatchList.ItemArray.Item.TimeLeft");
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "OutputSelector", "WatchList.ItemArray.Item.ListingDetails.EndTime");
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "OutputSelector", "BidList.ItemArray.Item.TimeLeft");
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "OutputSelector", "BidList.ItemArray.Item.ListingDetails.EndTime");
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "HideVariations", "true");
            writeInclude(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "WatchList", 200);
            writeInclude(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "BidList", 1);
            writeInclude(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "WonList", 0);
            writeInclude(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "LostList", 0);
            xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", s);
        }

        public GetMyEbayResponse getResponse()
        {
            return new GetMyEbayResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        protected final void writeInclude(XmlSerializer xmlserializer, String s, String s1, int i)
            throws IOException
        {
            xmlserializer.startTag(s, s1);
            if (i <= 0)
            {
                XmlSerializerHelper.writeSimple(xmlserializer, s, "Include", "false");
            } else
            {
                XmlSerializerHelper.writePagination(xmlserializer, s, 1, i);
                XmlSerializerHelper.writeSimple(xmlserializer, s, "Sort", "TimeLeft");
            }
            xmlserializer.endTag(s, s1);
        }

        public GetMyEbayRequest(EbayTradingApi ebaytradingapi)
        {
            super(ebaytradingapi, "GetMyeBayBuying");
        }
    }

    private static final class GetMyEbayResponse extends EbayResponse
    {

        public Long soonestBidEndingDate;
        public ArrayList watchItems;

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            RootElement rootelement = new RootElement(this);
            SaxHandler.parseXml(inputstream, rootelement);
            if (rootelement.watchList != null && rootelement.watchList.items != null && !rootelement.watchList.items.isEmpty())
            {
                watchItems = rootelement.watchList.items;
            }
            if (rootelement.bidList != null && rootelement.bidList.items != null && !rootelement.bidList.items.isEmpty())
            {
                soonestBidEndingDate = Long.valueOf(((WatchItemDates)rootelement.bidList.items.get(0)).endDate);
            }
        }

        private GetMyEbayResponse()
        {
            soonestBidEndingDate = null;
            watchItems = null;
        }

    }

    private static final class GetMyEbayResponse.RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        ListElement bidList;
        private final GetMyEbayResponse response;
        private final TimestampElement timestamp;
        ListElement watchList;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(response);
                }
                if ("Timestamp".equals(s1))
                {
                    return timestamp;
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(response, "urn:ebay:apis:eBLBaseComponents");
                }
                if ("BidList".equals(s1))
                {
                    s = new ListElement(1, timestamp.hostTime);
                    bidList = s;
                    return s;
                }
                if ("WatchList".equals(s1))
                {
                    s = new ListElement(200, timestamp.hostTime);
                    watchList = s;
                    return s;
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public GetMyEbayResponse.RootElement(GetMyEbayResponse getmyebayresponse)
        {
            bidList = null;
            watchList = null;
            response = getmyebayresponse;
            timestamp = new TimestampElement(getmyebayresponse);
        }
    }

    static final class GetMyEbayResponse.RootElement.Item extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final WatchItemDates item;
        final long timestamp;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ItemID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final GetMyEbayResponse.RootElement.Item this$0;

                    public void setValue(long l)
                        throws SAXException
                    {
                        item.id = l;
                    }

            
            {
                this$0 = GetMyEbayResponse.RootElement.Item.this;
                super();
            }
                };
            }
            if ("ListingDetails".equals(s1))
            {
                return new ListingDetails();
            }
            if ("TimeLeft".equals(s1) && timestamp != 0L && item.endDate == 0x7fffffffffffffffL)
            {
                return new TimeLeft();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public GetMyEbayResponse.RootElement.Item(WatchItemDates watchitemdates, long l)
        {
            item = watchitemdates;
            timestamp = l;
        }
    }

    private final class GetMyEbayResponse.RootElement.Item.EndTime extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final GetMyEbayResponse.RootElement.Item this$0;

        public void text(String s)
            throws SAXException
        {
            try
            {
                s = EbayDateFormat.parse(s);
                item.endDate = s.getTime();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new SAXNotRecognizedException(s.getLocalizedMessage());
            }
        }

        private GetMyEbayResponse.RootElement.Item.EndTime()
        {
            this$0 = GetMyEbayResponse.RootElement.Item.this;
            super();
        }

    }

    private final class GetMyEbayResponse.RootElement.Item.ListingDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMyEbayResponse.RootElement.Item this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("EndTime".equals(s1))
            {
                return new GetMyEbayResponse.RootElement.Item.EndTime();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetMyEbayResponse.RootElement.Item.ListingDetails()
        {
            this$0 = GetMyEbayResponse.RootElement.Item.this;
            super();
        }

    }

    private final class GetMyEbayResponse.RootElement.Item.TimeLeft extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final GetMyEbayResponse.RootElement.Item this$0;

        public void text(String s)
            throws SAXException
        {
            try
            {
                Date date = new Date(timestamp);
                s = Duration.parse(s, date).getEndFromStart(date);
                item.endDate = s.getTime();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new SAXNotSupportedException(s.getLocalizedMessage());
            }
        }

        private GetMyEbayResponse.RootElement.Item.TimeLeft()
        {
            this$0 = GetMyEbayResponse.RootElement.Item.this;
            super();
        }

    }

    private static final class GetMyEbayResponse.RootElement.ListElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        public ArrayList items;
        private final int maxItemCount;
        private final long timestamp;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ItemArray".equals(s1))
            {
                s = new ArrayList(maxItemCount);
                items = s;
                return new ItemArray(s, timestamp);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public GetMyEbayResponse.RootElement.ListElement(int i, long l)
        {
            items = null;
            maxItemCount = i;
            timestamp = l;
        }
    }

    private static final class GetMyEbayResponse.RootElement.ListElement.ItemArray extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final ArrayList items;
        private final long timestamp;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Item".equals(s1))
            {
                s = new WatchItemDates();
                items.add(s);
                return new GetMyEbayResponse.RootElement.Item(s, timestamp);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public GetMyEbayResponse.RootElement.ListElement.ItemArray(ArrayList arraylist, long l)
        {
            items = arraylist;
            timestamp = l;
        }
    }

    public static final class WatchItemDates
    {

        public long endDate;
        public long id;

        public WatchItemDates()
        {
            id = 0L;
            endDate = 0x7fffffffffffffffL;
        }
    }


    private static final String API_INVALID_SELLER_ID_ERROR_CODE = "28";
    private static final String API_NO_SAVED_SEARCH_ERROR_CODE = "85";
    private static final String LOG_TAG = "PollServiceListCache";
    public final Long soonestBidEndingDate;
    public final ArrayList watchItems;

    public PollServiceListCache(Long long1, ArrayList arraylist)
    {
        soonestBidEndingDate = long1;
        watchItems = arraylist;
    }

    public static List fetchSavedSearchList(Context context, EbayContext ebaycontext, String s)
        throws com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException
    {
        ebaycontext = refreshSavedSearchList(context, ebaycontext, s);
        if (ebaycontext.size() == 0)
        {
            (new ItemCache(context)).setSearchNewItemCountsReady();
        }
        return ebaycontext;
    }

    public static long getSinceTime(PollService.SavedSearchPollData savedsearchpolldata)
    {
label0:
        {
            long l = 0L;
            if (savedsearchpolldata != null)
            {
                if (savedsearchpolldata.viewTime <= 0L)
                {
                    break label0;
                }
                l = savedsearchpolldata.viewTime;
            }
            return l;
        }
        return savedsearchpolldata.sinceTime;
    }

    public static boolean hasNew(PollService.SavedSearchPollData savedsearchpolldata)
    {
        return savedsearchpolldata.newItemCount > 0 && savedsearchpolldata.viewTime < savedsearchpolldata.sinceTime;
    }

    private static com.ebay.common.model.mdns.PlatformNotificationsEvent.SavedSearchEvent pollSavedSearchNewItemCounts(Context context, EbayContext ebaycontext, String s, long l, boolean flag)
    {
        Preferences preferences;
        ArrayList arraylist;
        ArrayList arraylist1;
        ItemCache itemcache;
        Iterator iterator;
        boolean flag3;
        flag3 = DeviceConfiguration.getAsync().get(DcsBoolean.searchSavedSearchUseFollowInterest);
        preferences = MyApp.getPrefs();
        arraylist = (new NotificationPreferenceManager(context)).getNotifyEnabledSavedSearchIdList(preferences.getCurrentUser());
        if (DevLog.logNotifications.isLoggable)
        {
            FwLog.println(DevLog.logNotifications, (new StringBuilder()).append("pollSavedSearchNewItemCounts: forNotification? ").append(flag).append(", notified search ids coount: ").append(arraylist.size()).toString());
        }
        itemcache = new ItemCache(context);
        itemcache.setSearchNewItemCountsBusy();
        if (DevLog.logNotifications.isLoggable)
        {
            FwLog.println(DevLog.logNotifications, "pollSavedSearchNewItemCounts: start to poll, set state busy");
        }
        arraylist1 = new ArrayList();
        context = new com.ebay.common.model.mdns.PlatformNotificationsEvent.SavedSearchEvent();
        iterator = itemcache.getSavedSearches().values().iterator();
_L9:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        PollService.SavedSearchPollData savedsearchpolldata = (PollService.SavedSearchPollData)iterator.next();
        if (preferences.isSignedIn()) goto _L3; else goto _L2
_L2:
        itemcache.setSearchNewItemCountsReady();
        if (DevLog.logNotifications.isLoggable)
        {
            FwLog.println(DevLog.logNotifications, "pollSavedSearchNewItemCounts: finish polling, set state ready");
        }
        if (!flag || arraylist1.isEmpty())
        {
            return null;
        }
          goto _L4
_L3:
        int i;
        boolean flag2;
        long l1;
        if (flag && !arraylist.contains(savedsearchpolldata.searchId))
        {
            if (DevLog.logNotifications.isLoggable)
            {
                FwLog.println(DevLog.logNotifications, (new StringBuilder()).append("pollSavedSearchNewItemCounts: FOR Notification, and id is not notif enabled: ").append(savedsearchpolldata.searchId).toString());
            }
            continue; /* Loop/switch isn't completed */
        }
        if (hasNew(savedsearchpolldata))
        {
            if (TextUtils.isEmpty(((com.ebay.common.model.mdns.PlatformNotificationsEvent.SavedSearchEvent) (context)).title))
            {
                context.title = savedsearchpolldata.searchName;
            }
            arraylist1.add(savedsearchpolldata.searchId);
            if (DevLog.logNotifications.isLoggable)
            {
                FwLog.println(DevLog.logNotifications, (new StringBuilder()).append("pollSavedSearchNewItemCounts: search is new: search id=").append(savedsearchpolldata.searchId).append(" has new items and NOT viewed, no work").toString());
            }
            continue; /* Loop/switch isn't completed */
        }
        if (savedsearchpolldata.pollTime > l)
        {
            savedsearchpolldata.pollTime = 0L;
        }
        if (savedsearchpolldata.pollTime != 0L)
        {
            l1 = savedsearchpolldata.pollTime;
        } else
        {
            l1 = l - 0x36ee80L;
        }
        flag2 = false;
        if (!flag3) goto _L6; else goto _L5
_L5:
        i = SearchUtil.getNewFollowItemCountSince(ebaycontext, savedsearchpolldata.searchId, l1);
_L7:
        itemcache.updateSavedSearch(savedsearchpolldata.searchId, savedsearchpolldata.searchName, i, l, 0L, l1);
        if (i > 0)
        {
            if (TextUtils.isEmpty(((com.ebay.common.model.mdns.PlatformNotificationsEvent.SavedSearchEvent) (context)).title))
            {
                context.title = savedsearchpolldata.searchName;
            }
            arraylist1.add(savedsearchpolldata.searchId);
            if (DevLog.logNotifications.isLoggable)
            {
                FwLog.println(DevLog.logNotifications, (new StringBuilder()).append("pollSavedSearchNewItemCounts: db search updated: polled count for search id=").append(savedsearchpolldata.searchId).append(", new count=").append(i).append(", db updated").toString());
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        try
        {
            i = FindNewItemsForFavoriteSearch.getNewItemCountSince(ebaycontext, s, savedsearchpolldata.searchId, l1);
            continue; /* Loop/switch isn't completed */
        }
        catch (com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException ebayrequesterrorexception)
        {
            i = ((flag2) ? 1 : 0);
            if (ebayrequesterrorexception.getErrors() == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            Iterator iterator1 = ebayrequesterrorexception.getErrors().iterator();
            do
            {
                i = ((flag2) ? 1 : 0);
                if (!iterator1.hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                EbayResponseError ebayresponseerror = (EbayResponseError)iterator1.next();
                if (ebayresponseerror.code.equals("28"))
                {
                    Log.w("PollServiceListCache", (new StringBuilder()).append("API findItemsForFavoriteSearch warning, search: ").append(savedsearchpolldata.searchName).append(", warning: ").append(ebayresponseerror.toString()).toString());
                } else
                {
                    Log.w("PollServiceListCache", (new StringBuilder()).append("API findItemsForFavoriteSearch error, search: ").append(savedsearchpolldata.searchName).append(", error: ").append(ebayrequesterrorexception).toString());
                    Log.w("PollServiceListCache", (new StringBuilder()).append("API findItemsForFavoriteSearch error, pollTime: ").append(savedsearchpolldata.pollTime).append(", now: ").append(l).append(" since: ").append(l1).toString());
                }
            } while (true);
        }
        catch (Exception exception)
        {
            Log.w("PollService", "pollSavedSearchNewItemCounts: Exception:", exception);
            i = ((flag2) ? 1 : 0);
        }
        if (true) goto _L7; else goto _L4
_L4:
        ebaycontext = new StringBuilder();
        boolean flag1 = true;
        for (s = arraylist1.iterator(); s.hasNext();)
        {
            String s1 = (String)s.next();
            if (!flag1)
            {
                ebaycontext.append(",");
            }
            ebaycontext.append(s1);
            flag1 = false;
        }

        context.searchIds = ebaycontext.toString();
        return context;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static void refreshNewItemCounts(Context context, EbayContext ebaycontext, String s, long l)
    {
        long l1;
        boolean flag;
        if (l == 0L)
        {
            l1 = System.currentTimeMillis();
        } else
        {
            l1 = l;
        }
        if (l != 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s = pollSavedSearchNewItemCounts(context, ebaycontext, s, l1, flag);
        if (s != null)
        {
            if (DevLog.logNotifications.isLoggable)
            {
                FwLog.println(DevLog.logNotifications, (new StringBuilder()).append("refreshSavedSearches: got saved search event: ").append(s.toString()).toString());
            }
            if (l != 0L)
            {
                if (DevLog.logNotifications.isLoggable)
                {
                    FwLog.println(DevLog.logNotifications, (new StringBuilder()).append("refreshSavedSearches: this is a periodical poll, sending saved search notification now: ").append(s.toString()).toString());
                }
                PollService.createSavedSearchNotification(context, ebaycontext, s);
                return;
            }
        }
    }

    public static List refreshSavedSearchList(Context context, EbayContext ebaycontext, String s)
        throws com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException
    {
        Object obj;
        ItemCache itemcache;
        Object obj1;
        boolean flag;
        itemcache = new ItemCache(context);
        itemcache.setSearchListBusy();
        if (DevLog.logNotifications.isLoggable)
        {
            FwLog.println(DevLog.logNotifications, "pollSavedSearchList: start to poll, set state busy");
        }
        flag = DeviceConfiguration.getAsync().get(DcsBoolean.searchSavedSearchUseFollowInterest);
        obj1 = EbayApiUtil.getFindingUserSettingsApi(ebaycontext);
        obj = null;
        if (!flag) goto _L2; else goto _L1
_L1:
        obj1 = MyApp.getPrefs().getCurrentSite();
        obj = FollowedSearchApi.retrieveFavoriteSearch(ebaycontext, s, ((com.ebay.nautilus.domain.EbaySite) (obj1)));
        s = FollowedSearchApi.retrieveFavoriteSearchNotifications(ebaycontext, s, ((com.ebay.nautilus.domain.EbaySite) (obj1)));
        ebaycontext = ((EbayContext) (obj));
_L14:
        if (ebaycontext.size() != 0) goto _L4; else goto _L3
_L3:
        itemcache.purgeSavedSearches();
        if (DevLog.logNotifications.isLoggable)
        {
            FwLog.println(DevLog.logNotifications, "pollSavedSearchList: user has NO saved search, purged cache");
        }
        itemcache.setSearchListReady();
        itemcache.setSearchNewItemCountsReady();
        itemcache.setSearchListReady();
        context = ebaycontext;
        if (DevLog.logNotifications.isLoggable)
        {
            FwLog.println(DevLog.logNotifications, "pollSavedSearchList: finish polling, set state ready");
            context = ebaycontext;
        }
_L9:
        return context;
_L2:
        ebaycontext = ((EbayFussApi) (obj1)).retrieveFavoriteSearch(s);
        s = ((String) (obj));
        continue; /* Loop/switch isn't completed */
_L4:
        Iterator iterator;
        obj = new ArrayList();
        obj1 = itemcache.getSavedSearches();
        iterator = ebaycontext.iterator();
_L7:
        SavedSearch savedsearch;
        PollService.SavedSearchPollData savedsearchpolldata;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_338;
        }
        savedsearch = (SavedSearch)iterator.next();
        ((List) (obj)).add(savedsearch.id);
        savedsearchpolldata = (PollService.SavedSearchPollData)((TreeMap) (obj1)).get(Long.valueOf(Long.parseLong(savedsearch.id)));
        if (savedsearchpolldata == null) goto _L6; else goto _L5
_L5:
        if (savedsearchpolldata.searchName != null && savedsearchpolldata.searchName.equals(savedsearch.name)) goto _L7; else goto _L6
_L6:
        itemcache.addSavedSearch(savedsearch.id, savedsearch.name, 0, 0L, 0L, 0L);
          goto _L7
        context;
        if (EbayErrorUtil.userNotLoggedIn(context.getErrors()))
        {
            MyApp.signOutForIafTokenFailure(null);
            throw context;
        }
        break MISSING_BLOCK_LABEL_531;
        context;
        itemcache.setSearchListReady();
        if (DevLog.logNotifications.isLoggable)
        {
            FwLog.println(DevLog.logNotifications, "pollSavedSearchList: finish polling, set state ready");
        }
        throw context;
        for (obj1 = ((TreeMap) (obj1)).keySet().iterator(); ((Iterator) (obj1)).hasNext();)
        {
            Long long1 = (Long)((Iterator) (obj1)).next();
            if (!((List) (obj)).contains(long1.toString()))
            {
                itemcache.deleteSavedSearch(long1.toString());
                if (DevLog.logNotifications.isLoggable)
                {
                    FwLog.println(DevLog.logNotifications, (new StringBuilder()).append("pollSavedSearchList: old search deleted, id").append(long1).toString());
                }
            }
        }

        break; /* Loop/switch isn't completed */
        context;
        Log.w("PollService", "pollSavedSearchList: Exception: ", context);
        ebaycontext = new ArrayList();
        itemcache.setSearchListReady();
        context = ebaycontext;
        if (DevLog.logNotifications.isLoggable)
        {
            FwLog.println(DevLog.logNotifications, "pollSavedSearchList: finish polling, set state ready");
            return ebaycontext;
        }
        if (true) goto _L9; else goto _L8
_L8:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_504;
        }
        (new NotificationPreferenceManager(context)).setNotifyEnabledSavedSearchIdList(MyApp.getPrefs().getCurrentUser(), s);
        itemcache.setSearchListReady();
        context = ebaycontext;
        if (!DevLog.logNotifications.isLoggable) goto _L9; else goto _L10
_L10:
        FwLog.println(DevLog.logNotifications, "pollSavedSearchList: finish polling, set state ready");
        return ebaycontext;
        context = context.getErrors().iterator();
_L11:
        do
        {
            if (!context.hasNext())
            {
                break MISSING_BLOCK_LABEL_628;
            }
            ebaycontext = (EbayResponseError)context.next();
            if (!((EbayResponseError) (ebaycontext)).code.equals("85"))
            {
                break MISSING_BLOCK_LABEL_596;
            }
            itemcache.purgeSavedSearches();
            if (DevLog.logNotifications.isLoggable)
            {
                FwLog.println(DevLog.logNotifications, "pollSavedSearchList: API error 85: user has NO saved search, purged cache");
            }
        } while (true);
        Log.w("PollServiceListCache", (new StringBuilder()).append("pollSavedSearchList: API activateAndGet error: ").append(ebaycontext.toString()).toString());
          goto _L11
        ebaycontext = new ArrayList();
        itemcache.setSearchListReady();
        context = ebaycontext;
        if (!DevLog.logNotifications.isLoggable) goto _L9; else goto _L12
_L12:
        FwLog.println(DevLog.logNotifications, "pollSavedSearchList: finish polling, set state ready");
        return ebaycontext;
        if (true) goto _L14; else goto _L13
_L13:
    }

    public static List refreshSavedSearchListAndNewItemCounts(Context context, EbayContext ebaycontext, String s, long l)
        throws com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException
    {
        List list = fetchSavedSearchList(context, ebaycontext, s);
        refreshNewItemCounts(context, ebaycontext, s, l);
        return list;
    }
}
