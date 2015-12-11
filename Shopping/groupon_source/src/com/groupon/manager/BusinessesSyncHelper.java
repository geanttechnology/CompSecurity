// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import android.os.SystemClock;
import com.groupon.Channel;
import com.groupon.db.dao.DaoBusiness;
import com.groupon.db.dao.DaoWidgetSummary;
import com.groupon.db.models.Business;
import com.groupon.models.Place;
import com.groupon.util.BuyUtils;
import java.io.InputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.ObjectMapper;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.manager:
//            SyncManagerUtils, AsyncHttp

public class BusinessesSyncHelper
{

    private DaoBusiness businessDao;
    private BuyUtils buyUtil;
    private String channel;
    private Context context;
    private JsonFactory jsonFactory;
    private DaoWidgetSummary widgetSummaryDao;
    private String widgetsChannel;

    public BusinessesSyncHelper(Context context1, String s)
    {
        context = context1;
        channel = s;
        widgetsChannel = getWidgetsChannelName(s);
    }

    public static String staticGetWidgetsChannelName(String s)
    {
        return Channel.encodePath(new String[] {
            s, "WIDGETS"
        });
    }

    public String getChannel()
    {
        return channel;
    }

    protected List getNameValueParams(String s, Place place)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(new String[] {
            "query", s
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "locale", "en_US"
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "context", "mobile_search"
        }));
        if (place != null)
        {
            arraylist.addAll(Arrays.asList(new Serializable[] {
                "lat", Double.valueOf(place.lat)
            }));
            arraylist.addAll(Arrays.asList(new Serializable[] {
                "lng", Double.valueOf(place.lng)
            }));
        }
        return arraylist;
    }

    protected String getUrl()
        throws MalformedURLException
    {
        return "https:/businesses/search";
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
        return SyncManagerUtils.getLastUpdatedForWidgetSummaries(widgetSummaryDao, widgetsChannel);
    }

    protected void process(final InputStream jp, final String channel)
        throws Exception
    {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.enable(new org.codehaus.jackson.map.DeserializationConfig.Feature[] {
            org.codehaus.jackson.map.DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY
        });
        long l = SystemClock.elapsedRealtime();
        jp = jsonFactory.createJsonParser(jp);
        businessDao.callBatchTasks(new Callable() {

            final BusinessesSyncHelper this$0;
            final String val$channel;
            final JsonParser val$jp;
            final ObjectMapper val$mapper;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                businessDao.clearByChannelId(channel);
                do
                {
                    if (jp.nextToken() == null)
                    {
                        break;
                    }
                    if (Strings.equals(jp.getCurrentName(), "businesses"))
                    {
                        jp.nextToken();
                        while (jp.nextToken() == JsonToken.START_OBJECT) 
                        {
                            Business business = (Business)mapper.readValue(jp, com/groupon/db/models/Business);
                            business.afterJsonDeserializationPostProcessor(buyUtil);
                            business.channel = channel;
                            businessDao.save(business);
                        }
                    }
                } while (true);
                return null;
            }

            
            {
                this$0 = BusinessesSyncHelper.this;
                channel = s;
                jp = jsonparser;
                mapper = objectmapper;
                super();
            }
        });
        long l1 = SystemClock.elapsedRealtime();
        Ln.d("Merchant Pages     response parsing time: %s", new Object[] {
            (new StringBuilder()).append(l1 - l).append(" ms").toString()
        });
    }

    public BusinessesSyncHelper setChannel(String s)
    {
        channel = s;
        widgetsChannel = getWidgetsChannelName(s);
        return this;
    }

    public AsyncHttp startAsyncRequest(String s, Place place)
        throws Exception
    {
        s = ((String) (getNameValueParams(s, place).toArray()));
        return (new AsyncHttp(context, java/io/InputStream, getUrl(), s)).execute();
    }


}
