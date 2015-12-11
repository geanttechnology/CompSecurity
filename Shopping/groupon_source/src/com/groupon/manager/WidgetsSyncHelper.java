// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import com.groupon.Channel;
import com.groupon.cookies.CookieFactory;
import com.groupon.db.dao.DaoDealSummary;
import com.groupon.db.dao.DaoWidgetSummary;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.Relevance;
import com.groupon.db.models.WidgetSummary;
import com.groupon.manager.deserializer.StreamingJsonDeserializer;
import com.groupon.models.MoreAssets;
import com.groupon.models.MoreAssetsDeals;
import com.groupon.models.Slot;
import com.groupon.models.View;
import com.groupon.models.Widget;
import com.groupon.models.division.Division;
import com.groupon.service.LocationService;
import com.groupon.service.LoginService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.util.ApiGenerateShowParamBuilder;
import com.groupon.util.BuyUtils;
import com.groupon.util.CountryUtil;
import com.groupon.util.HttpUtil;
import com.groupon.util.LoggingUtils;
import com.groupon.view.UrlImageView;
import com.j256.ormlite.dao.Dao;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.manager:
//            SyncManagerUtils, WidgetSyncManagerContext, AsyncHttp

public class WidgetsSyncHelper
{
    public class DealDeserializer extends StreamingJsonDeserializer
    {

        private ObjectMapper internalMapper;
        final WidgetsSyncHelper this$0;
        private WidgetSyncManagerContext widgetSyncManagerContext;

        public Deal deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException
        {
            jsonparser = (Deal)internalMapper.readValue(jsonparser, com/groupon/db/models/Deal);
            jsonparser.afterJsonDeserializationPostProcessor((BuyUtils)buyUtil.get());
            jsonparser.parentWidgetSummary = widgetSyncManagerContext.getCurrentlyParsedWidgetSummary();
            try
            {
                ((DaoDealSummary)dealSummaryDao.get()).save(new DealSummary(jsonparser, widgetsChannel));
                UrlImageView.prefetch((Application)context.getApplicationContext(), jsonparser.getImageUrl());
                widgetSyncManagerContext.incDealCount();
            }
            // Misplaced declaration of an exception variable
            catch (JsonParser jsonparser)
            {
                throw new RuntimeException(jsonparser);
            }
            return null;
        }

        public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            return deserialize(jsonparser, deserializationcontext);
        }

        public DealDeserializer(WidgetSyncManagerContext widgetsyncmanagercontext)
        {
            this$0 = WidgetsSyncHelper.this;
            super();
            internalMapper = new ObjectMapper();
            widgetSyncManagerContext = widgetsyncmanagercontext;
        }
    }

    protected static class Scenario
    {

        private String id;
        private String requestId;
        private Collection slots;
        private String treatment;

        public void afterJsonDeserializationPostProcessor(String s, WidgetSyncManagerContext widgetsyncmanagercontext, DaoWidgetSummary daowidgetsummary)
        {
            for (Iterator iterator = slots.iterator(); iterator.hasNext();)
            {
                Slot slot = (Slot)iterator.next();
                Iterator iterator1 = slot.widgets.iterator();
                while (iterator1.hasNext()) 
                {
                    Widget widget = (Widget)iterator1.next();
                    WidgetSummary widgetsummary = widget.widgetSummary;
                    widgetsummary.slotId = slot.id;
                    widgetsummary.channel = s;
                    widgetsummary.requestId = requestId;
                    widgetsummary.scenarioId = id;
                    widgetsummary.scenarioTreatment = treatment;
                    MoreAssetsDeals moreassetsdeals = widget.moreAssets.deals;
                    widgetsummary.moreAssetsDealsUrl = moreassetsdeals.url;
                    widgetsummary.moreAssetsDealsCount = moreassetsdeals.count;
                    if (widget.relevanceService != null)
                    {
                        widgetsummary.relevanceServiceContext = widget.relevanceService.context;
                        widgetsummary.relevanceServiceTreatment = widget.relevanceService.treatment;
                    }
                    widgetsummary.treatment = widget.treatment;
                    widgetsummary.displayName = widget.displayName;
                    widgetsummary.type = widget.type;
                    if (widget.view != null)
                    {
                        widgetsummary.viewLayout = widget.view.layout;
                        if (Strings.notEmpty(widget.view.campaign))
                        {
                            widgetsummary.campaign = widget.view.campaign;
                        }
                    }
                    try
                    {
                        daowidgetsummary.update(widgetsummary);
                        widgetsyncmanagercontext.incWidgetCount();
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        throw new RuntimeException(s);
                    }
                }
            }

        }


        protected Scenario()
        {
            requestId = "";
            id = "";
            treatment = "";
            slots = Collections.emptyList();
        }
    }

    public class WidgetDeserializer extends StreamingJsonDeserializer
    {

        private ObjectMapper internalMapper;
        final WidgetsSyncHelper this$0;
        private WidgetSyncManagerContext widgetSyncManagerContext;

        public Widget deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException
        {
            deserializationcontext = new WidgetSummary();
            deserializationcontext.channel = widgetsChannel;
            widgetSyncManagerContext.setCurrentlyParsedWidgetSummary(deserializationcontext);
            try
            {
                ((DaoWidgetSummary)widgetSummaryDao.get()).create(deserializationcontext);
            }
            // Misplaced declaration of an exception variable
            catch (JsonParser jsonparser)
            {
                throw new RuntimeException(jsonparser);
            }
            jsonparser = (Widget)internalMapper.readValue(jsonparser, com/groupon/models/Widget);
            jsonparser.widgetSummary = deserializationcontext;
            return jsonparser;
        }

        public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            return deserialize(jsonparser, deserializationcontext);
        }

        public WidgetDeserializer(WidgetSyncManagerContext widgetsyncmanagercontext)
        {
            this$0 = WidgetsSyncHelper.this;
            super();
            internalMapper = new ObjectMapper();
            widgetSyncManagerContext = widgetsyncmanagercontext;
            SimpleModule simplemodule = new SimpleModule("DealDeserializerModule", new Version(1, 0, 0, null));
            simplemodule.addDeserializer(com/groupon/db/models/Deal, new DealDeserializer(widgetsyncmanagercontext));
            internalMapper.registerModule(simplemodule);
        }
    }

    protected static class WidgetsResponse
    {

        private Scenario scenario;


        protected WidgetsResponse()
        {
        }
    }


    protected static final String UNKNOWN_SCENARIO_PREFIX = "unknown";
    private Lazy buyUtil;
    private String channel;
    protected Context context;
    private Lazy cookieFactory;
    private Lazy countryUtil;
    private CurrentCountryManager currentCountryManager;
    protected Lazy currentDivisionManager;
    private Lazy dealSummaryDao;
    protected String fragmentName;
    protected Lazy internetDateFormat;
    private Lazy jsonFactory;
    private Location location;
    private Lazy locationService;
    private Lazy loggingUtils;
    private Lazy loginService;
    private String nstChannel;
    private Lazy paginationDao;
    private Lazy prefs;
    private boolean requiresRedirectLogging;
    private String scenarioIdPrefix;
    private String scenarioIdVariantPostfix;
    private Lazy widgetSummaryDao;
    protected String widgetsChannel;

    public WidgetsSyncHelper(Context context1, String s, String s1, String s2)
    {
        requiresRedirectLogging = true;
        context = context1;
        channel = s;
        widgetsChannel = getWidgetsChannelName(s);
        nstChannel = s1;
        scenarioIdPrefix = s2;
        currentDivisionManager = new Lazy(context1) {

            final WidgetsSyncHelper this$0;

            
            {
                this$0 = WidgetsSyncHelper.this;
                super(context1);
            }
        };
        jsonFactory = new Lazy(context1) {

            final WidgetsSyncHelper this$0;

            
            {
                this$0 = WidgetsSyncHelper.this;
                super(context1);
            }
        };
        dealSummaryDao = new Lazy(context1) {

            final WidgetsSyncHelper this$0;

            
            {
                this$0 = WidgetsSyncHelper.this;
                super(context1);
            }
        };
        paginationDao = new Lazy(context1) {

            final WidgetsSyncHelper this$0;

            
            {
                this$0 = WidgetsSyncHelper.this;
                super(context1);
            }
        };
        widgetSummaryDao = new Lazy(context1) {

            final WidgetsSyncHelper this$0;

            
            {
                this$0 = WidgetsSyncHelper.this;
                super(context1);
            }
        };
        countryUtil = new Lazy(context1) {

            final WidgetsSyncHelper this$0;

            
            {
                this$0 = WidgetsSyncHelper.this;
                super(context1);
            }
        };
        loginService = new Lazy(context1) {

            final WidgetsSyncHelper this$0;

            
            {
                this$0 = WidgetsSyncHelper.this;
                super(context1);
            }
        };
        locationService = new Lazy(context1) {

            final WidgetsSyncHelper this$0;

            
            {
                this$0 = WidgetsSyncHelper.this;
                super(context1);
            }
        };
        cookieFactory = new Lazy(context1) {

            final WidgetsSyncHelper this$0;

            
            {
                this$0 = WidgetsSyncHelper.this;
                super(context1);
            }
        };
        loggingUtils = new Lazy(context1) {

            final WidgetsSyncHelper this$0;

            
            {
                this$0 = WidgetsSyncHelper.this;
                super(context1);
            }
        };
        prefs = new Lazy(context1) {

            final WidgetsSyncHelper this$0;

            
            {
                this$0 = WidgetsSyncHelper.this;
                super(context1);
            }
        };
        buyUtil = new Lazy(context1) {

            final WidgetsSyncHelper this$0;

            
            {
                this$0 = WidgetsSyncHelper.this;
                super(context1);
            }
        };
        internetDateFormat = new Lazy(context1) {

            final WidgetsSyncHelper this$0;

            
            {
                this$0 = WidgetsSyncHelper.this;
                super(context1);
            }
        };
    }

    private void init()
    {
    }

    public static String staticGetWidgetsChannelName(String s)
    {
        return Channel.encodePath(new String[] {
            s, "WIDGETS"
        });
    }

    protected Object[] addExtraNstNameValueParams(Object aobj[])
    {
        return aobj;
    }

    public WidgetsSyncHelper configureChannels(String s, String s1, String s2)
    {
        channel = s;
        widgetsChannel = s1;
        nstChannel = s2;
        return this;
    }

    public String getChannel()
    {
        return channel;
    }

    protected List getNameValueParams()
    {
        ArrayList arraylist = new ArrayList();
        String s = (new ApiGenerateShowParamBuilder()).dealOptionGiftWrappingCharge(true).images(true).build();
        arraylist.addAll(Arrays.asList(new String[] {
            "visitor_id", ((CookieFactory)cookieFactory.get()).getBrowserCookie()
        }));
        location = ((LocationService)locationService.get()).getLocation();
        if (location != null)
        {
            arraylist.addAll(Arrays.asList(new Serializable[] {
                "lat", Double.valueOf(location.getLatitude())
            }));
            arraylist.addAll(Arrays.asList(new Serializable[] {
                "lng", Double.valueOf(location.getLongitude())
            }));
        }
        arraylist.addAll(Arrays.asList(new String[] {
            "geo_source", "mobile"
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "division_id", ((CurrentDivisionManager)currentDivisionManager.get()).getCurrentDivision().getIdOrParentId()
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "show", s
        }));
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "locale", ((CountryUtil)countryUtil.get()).getLocale(currentCountryManager.getCurrentCountry())
        }));
        if (((LoginService)loginService.get()).isLoggedIn())
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "consumer_id", ((LoginService)loginService.get()).getConsumerId()
            }));
        }
        return arraylist;
    }

    public String getScenarioIdName()
    {
        return (new StringBuilder()).append(scenarioIdPrefix).append(scenarioIdVariantPostfix).toString();
    }

    protected String getUrl()
        throws MalformedURLException
    {
        return String.format("https:/widgets/%s", new Object[] {
            getScenarioIdName()
        });
    }

    public String getWidgetsChannel()
    {
        return widgetsChannel;
    }

    public String getWidgetsChannelName(String s)
    {
        return staticGetWidgetsChannelName(s);
    }

    public boolean isEnabled(Void void1, int i, int j)
    {
        return i == 0;
    }

    protected long lastUpdated()
        throws Exception
    {
        return SyncManagerUtils.getLastUpdatedForWidgetSummaries((Dao)widgetSummaryDao.get(), widgetsChannel);
    }

    protected List overrideWithSecretAdminParams(List list)
    {
        Object obj;
label0:
        {
            String s = ((SharedPreferences)prefs.get()).getString("widgetPreview", "");
            String s1 = ((SharedPreferences)prefs.get()).getString("widgetDatetime", "");
            if (!Strings.notEmpty(s))
            {
                obj = list;
                if (!Strings.notEmpty(s1))
                {
                    break label0;
                }
            }
            list = HttpUtil.arrayToHash(list);
            obj = new HashMap();
            if (Strings.notEmpty(s))
            {
                ((HashMap) (obj)).put("megamind_preview", s);
            }
            if (Strings.notEmpty(s1))
            {
                ((HashMap) (obj)).put("datetime", s1);
            }
            list.putAll(((java.util.Map) (obj)));
            obj = HttpUtil.hashToArray(list);
        }
        return ((List) (obj));
    }

    protected void process(InputStream inputstream, Object aobj[])
        throws Exception
    {
        WidgetSyncManagerContext widgetsyncmanagercontext = new WidgetSyncManagerContext();
        Object obj1 = new SimpleModule("WidgetDeserializerModule", new Version(1, 0, 0, null));
        ((SimpleModule) (obj1)).addDeserializer(com/groupon/models/Widget, new WidgetDeserializer(widgetsyncmanagercontext));
        Object obj = new ObjectMapper();
        ((ObjectMapper) (obj)).enable(new org.codehaus.jackson.map.DeserializationConfig.Feature[] {
            org.codehaus.jackson.map.DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY
        });
        ((ObjectMapper) (obj)).registerModule(((org.codehaus.jackson.map.Module) (obj1)));
        long l = System.currentTimeMillis();
        inputstream = ((JsonFactory)jsonFactory.get()).createJsonParser(inputstream);
        SyncManagerUtils.deleteRecordsForChannelAndSubchannels((Dao)paginationDao.get(), widgetsChannel);
        SyncManagerUtils.deleteRecordsForChannelAndSubchannels((Dao)dealSummaryDao.get(), widgetsChannel);
        SyncManagerUtils.deleteRecordsForChannelAndSubchannels((Dao)widgetSummaryDao.get(), widgetsChannel);
        Object obj2 = ((WidgetsResponse)((ObjectMapper) (obj)).readValue(inputstream, com/groupon/manager/WidgetsSyncHelper$WidgetsResponse)).scenario;
        ((Scenario) (obj2)).afterJsonDeserializationPostProcessor(widgetsChannel, widgetsyncmanagercontext, (DaoWidgetSummary)widgetSummaryDao.get());
        long l1 = System.currentTimeMillis();
        Ln.d("Widget response parsing time: %s", new Object[] {
            (new StringBuilder()).append(l1 - l).append(" ms").toString()
        });
        inputstream = (LoggingUtils)loggingUtils.get();
        obj = fragmentName;
        obj1 = nstChannel;
        aobj = HttpUtil.nvpsToQueryString(addExtraNstNameValueParams(aobj));
        String s = getScenarioIdName();
        obj2 = ((Scenario) (obj2)).requestId;
        float f;
        float f1;
        if (location != null)
        {
            f = (float)location.getLatitude();
        } else
        {
            f = 0.0F;
        }
        if (location != null)
        {
            f1 = (float)location.getLongitude();
        } else
        {
            f1 = 0.0F;
        }
        inputstream.logWidgetDealSearch(((String) (obj)), "", ((String) (obj1)), ((String) (aobj)), s, ((String) (obj2)), f, f1, "", widgetsyncmanagercontext.getDealCount(), requiresRedirectLogging);
    }

    public WidgetsSyncHelper setChannel(String s)
    {
        channel = s;
        widgetsChannel = getWidgetsChannelName(s);
        return this;
    }

    public WidgetsSyncHelper setFragmentName(String s)
    {
        fragmentName = s;
        return this;
    }

    public WidgetsSyncHelper setRequiresRedirectLogging(boolean flag)
    {
        requiresRedirectLogging = flag;
        return this;
    }

    public WidgetsSyncHelper setScenarioIdVariantPostfix(String s)
    {
        scenarioIdVariantPostfix = s;
        return this;
    }

    public AsyncHttp startAsyncRequest()
        throws Exception
    {
        List list = overrideWithSecretAdminParams(getNameValueParams());
        return (new AsyncHttp(context, java/io/InputStream, getUrl(), list.toArray())).execute();
    }



}
