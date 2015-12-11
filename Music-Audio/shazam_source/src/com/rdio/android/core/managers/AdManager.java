// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.managers;

import com.google.a.d.e;
import com.google.a.g.a.h;
import com.google.a.g.a.i;
import com.google.a.g.a.m;
import com.google.a.g.a.o;
import com.rdio.android.api.models.Ad;
import com.rdio.android.core.RdioApiRequestArg;
import com.rdio.android.core.RdioApiResponse;
import com.rdio.android.core.RdioService_Api;
import com.rdio.android.core.events.ads.AdCompletedEvent;
import com.rdio.android.core.events.ads.BeginAdBreakEvent;
import com.rdio.android.core.events.ads.HasPendingAdEvent;
import com.rdio.android.core.events.ads.ShouldGetAdEvent;
import com.rdio.android.core.util.Logging;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdManager
{

    public static final String TAG = "AdManager";
    private final String advertisingId;
    private final RdioService_Api apiService;
    private final e eventBus;
    private final m executorService;
    private final boolean iframeSupport;
    private final Logging logging;
    private Set pendingAdKeys;
    private String playbackToken;

    public AdManager(e e1, RdioService_Api rdioservice_api, Logging logging1, String s, boolean flag)
    {
        executorService = o.a(Executors.newCachedThreadPool());
        pendingAdKeys = new HashSet();
        eventBus = e1;
        logging = logging1;
        apiService = rdioservice_api;
        iframeSupport = flag;
        advertisingId = s;
    }

    public AdManager(e e1, RdioService_Api rdioservice_api, Logging logging1, String s, boolean flag, String s1)
    {
        executorService = o.a(Executors.newCachedThreadPool());
        pendingAdKeys = new HashSet();
        eventBus = e1;
        logging = logging1;
        apiService = rdioservice_api;
        advertisingId = s;
        iframeSupport = flag;
        playbackToken = s1;
    }

    private RdioApiRequestArg[] createApiRequestArgs(String s, String s1, double d, double d1)
    {
        ArrayList arraylist = new ArrayList(Arrays.asList(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getAdInfo"), new RdioApiRequestArg("iframeSupport", Boolean.valueOf(iframeSupport))
        }));
        if (s != null)
        {
            arraylist.add(new RdioApiRequestArg("advertisingId", s));
        }
        if (s1 != null)
        {
            arraylist.add(new RdioApiRequestArg("playbackToken", s1));
        }
        if (d != 0.0D || d1 != 0.0D)
        {
            arraylist.add(new RdioApiRequestArg("latitude", Double.valueOf(d)));
            arraylist.add(new RdioApiRequestArg("longitude", Double.valueOf(d1)));
        }
        return (RdioApiRequestArg[])arraylist.toArray(new RdioApiRequestArg[arraylist.size()]);
    }

    private List handleResponse(RdioApiResponse rdioapiresponse)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        if (!rdioapiresponse.isSuccess())
        {
            logging.log(6, "AdManager", "The getAdInfo method failed");
            return arraylist;
        }
        Ad ad;
        Object obj;
        JSONArray jsonarray;
        int j;
        int k;
        try
        {
            rdioapiresponse = ((JSONObject)rdioapiresponse.getResult()).getJSONArray("items");
        }
        // Misplaced declaration of an exception variable
        catch (RdioApiResponse rdioapiresponse)
        {
            logging.log(6, "AdManager", (new StringBuilder("The error processing the result of the getAdInfo method : ")).append(rdioapiresponse).toString());
            return arraylist;
        }
        j = 0;
_L10:
        if (j >= rdioapiresponse.length())
        {
            break MISSING_BLOCK_LABEL_431;
        }
        obj = rdioapiresponse.getJSONObject(j);
        ad = new Ad();
        ad.key = ((JSONObject) (obj)).getString("key");
        ad.surl = ((JSONObject) (obj)).getString("surl");
        ad.duration = ((JSONObject) (obj)).optInt("duration");
        ad.isAd = ((JSONObject) (obj)).optBoolean("isAd");
        ad.title = ((JSONObject) (obj)).optString("title");
        ad.type = ((JSONObject) (obj)).optString("type");
        jsonarray = ((JSONObject) (obj)).optJSONArray("impressionUrls");
        if (jsonarray == null) goto _L2; else goto _L1
_L1:
        k = 0;
_L4:
        if (k >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        ad.impressionUrls.add(jsonarray.getString(k));
        k++;
        if (true) goto _L4; else goto _L3
_L2:
        logging.log(5, "AdManager", "Ad has no impression URLs!");
_L3:
        obj = ((JSONObject) (obj)).optJSONObject("image");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_380;
        }
        ad.image.altText = ((JSONObject) (obj)).getString("altText");
        ad.image.clickthroughUrl = ((JSONObject) (obj)).getString("clickthroughUrl");
        ad.image.height = ((JSONObject) (obj)).getInt("height");
        ad.image.url = ((JSONObject) (obj)).getString("url");
        ad.image.width = ((JSONObject) (obj)).getInt("width");
        obj = ((JSONObject) (obj)).optJSONArray("impressionUrls");
        if (obj == null) goto _L6; else goto _L5
_L5:
        k = 0;
_L8:
        if (k >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        ad.image.impressionUrls.add(((JSONArray) (obj)).getString(k));
        k++;
        if (true) goto _L8; else goto _L7
_L6:
        logging.log(4, "AdManager", "Ad image has no impression URL");
_L7:
        arraylist.add(ad);
        j++;
        continue; /* Loop/switch isn't completed */
        logging.log(4, "AdManager", "Ad has no image");
          goto _L7
        return arraylist;
        if (true) goto _L10; else goto _L9
_L9:
    }

    private void makeGetRequest(final String path)
    {
        i.a(executorService.a(new Runnable() {

            final AdManager this$0;
            final String val$path;

            public void run()
            {
                Object obj;
                Object obj1;
                Object obj2;
                try
                {
                    obj1 = new URL(path);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    logging.log(6, "AdManager", (new StringBuilder("MalformedURLException when trying to request '")).append(path).append("' : ").append(obj).toString());
                    return;
                }
                obj = null;
                obj2 = null;
                obj1 = (HttpURLConnection)((URL) (obj1)).openConnection();
                new BufferedInputStream(((HttpURLConnection) (obj1)).getInputStream());
                if (obj1 != null)
                {
                    ((HttpURLConnection) (obj1)).disconnect();
                }
_L2:
                return;
                obj;
                obj1 = obj2;
                obj2 = obj;
_L5:
                obj = obj1;
                logging.log(6, "AdManager", (new StringBuilder("IOException when trying to request '")).append(path).append("' : ").append(obj2).toString());
                if (obj1 == null) goto _L2; else goto _L1
_L1:
                ((HttpURLConnection) (obj1)).disconnect();
                return;
                Exception exception;
                exception;
                obj1 = obj;
                obj = exception;
_L4:
                if (obj1 != null)
                {
                    ((HttpURLConnection) (obj1)).disconnect();
                }
                throw obj;
                obj;
                if (true) goto _L4; else goto _L3
_L3:
                exception;
                  goto _L5
            }

            
            {
                this$0 = AdManager.this;
                path = s;
                super();
            }
        }), new h() {

            final AdManager this$0;

            public void onFailure(Throwable throwable)
            {
                logging.log(6, "AdManager", "Failed to make GET request!");
            }

            public void onSuccess(Object obj)
            {
                logging.log(3, "AdManager", "Completed GET request.");
            }

            
            {
                this$0 = AdManager.this;
                super();
            }
        });
    }

    public static AdManager newInstance(e e1, RdioService_Api rdioservice_api, Logging logging1, String s, boolean flag)
    {
        rdioservice_api = new AdManager(e1, rdioservice_api, logging1, s, flag);
        e1.register(rdioservice_api);
        return rdioservice_api;
    }

    public static AdManager newInstance(e e1, RdioService_Api rdioservice_api, Logging logging1, String s, boolean flag, String s1)
    {
        rdioservice_api = new AdManager(e1, rdioservice_api, logging1, s, flag, s1);
        e1.register(rdioservice_api);
        return rdioservice_api;
    }

    public void onAdCompleted(AdCompletedEvent adcompletedevent)
    {
        if (!pendingAdKeys.remove(adcompletedevent.ad.key))
        {
            logging.log(5, "AdManager", (new StringBuilder("Was told ad: ")).append(adcompletedevent.ad.key).append(" completed, but it wasn't in the pending set").toString());
        }
        if (adcompletedevent.hadClickthrough)
        {
            makeGetRequest(adcompletedevent.ad.image.clickthroughUrl);
        }
        if (adcompletedevent.showedAd)
        {
            for (Iterator iterator = adcompletedevent.ad.image.impressionUrls.iterator(); iterator.hasNext(); makeGetRequest((String)iterator.next())) { }
        }
        if (adcompletedevent.playedAudio)
        {
            for (adcompletedevent = adcompletedevent.ad.impressionUrls.iterator(); adcompletedevent.hasNext(); makeGetRequest((String)adcompletedevent.next())) { }
        }
    }

    public void onShouldGetAd(final ShouldGetAdEvent event)
    {
        if (!pendingAdKeys.isEmpty())
        {
            logging.log(4, "AdManager", "Ignoring ShouldGetAdEvent, already have at least one pending ad");
            return;
        } else
        {
            RdioApiRequestArg ardioapirequestarg[] = createApiRequestArgs(advertisingId, playbackToken, event.getLatitude(), event.getLongitude());
            apiService.postRequest(ardioapirequestarg, new com.rdio.android.core.RdioService_Api.ResponseListener() {

                final AdManager this$0;
                final ShouldGetAdEvent val$event;

                public void onResponse(RdioApiResponse rdioapiresponse)
                {
                    Ad ad;
                    for (rdioapiresponse = handleResponse(rdioapiresponse).iterator(); rdioapiresponse.hasNext(); eventBus.post(new HasPendingAdEvent(ad)))
                    {
                        ad = (Ad)rdioapiresponse.next();
                        pendingAdKeys.add(ad.key);
                    }

                    if (event.isStartImmediately())
                    {
                        logging.log(4, "AdManager", "Received ads, was told to start them immediately.");
                        eventBus.post(new BeginAdBreakEvent());
                    }
                }

            
            {
                this$0 = AdManager.this;
                event = shouldgetadevent;
                super();
            }
            });
            return;
        }
    }

    public void updatePlaybackToken(String s)
    {
        playbackToken = s;
    }




}
