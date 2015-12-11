// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import com.gotv.crackle.Application;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.model.QueueItem;
import com.gotv.crackle.util.CrackleHMAC;
import com.gotv.crackle.util.Log;
import com.gotv.crackle.util.NetworkUtil;
import com.gotv.crackle.util.OmnitureWrapper;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.data:
//            Localization, DataRequest, CrackleAccountManager, SocialOnAPI, 
//            CacheManager

public class QueueManager
{

    private static final String CHANNEL_TYPE = "channel";
    private static final int ERROR_CODE_BASE = 1400;
    public static final String GET_FULL_LIST_TAG = "FULL_WATCHLIST";
    public static final String GET_HISTORY_TAG = "HISTORY_WATCHLIST";
    private static final String HISTORY_QUEUE_NAME = "history";
    private static final String LOGTAG = "QueueManager";
    private static final String MEDIA_TYPE = "media";
    private static final String REQUEST_FORMAT = "json";
    public static final String TAG = "GENERAL_QUEUE";
    public static final String WATCHLIST_QUEUE_NAME = "queue";
    protected DataRequest.DataRequestListener mDataRequestListener;
    private List mIDsList;
    private List mItems;
    private String mUrl;
    private String mUserId;

    public QueueManager(DataRequest.DataRequestListener datarequestlistener, String s)
    {
        mDataRequestListener = datarequestlistener;
        mUserId = s;
    }

    private void addToUserQueue(String s, String s1, String s2)
    {
        mUrl = String.format("http://%s/queue/%s/add/member/%s/%s/%s?format=%s", new Object[] {
            Application.getInstance().getLocalization().getLoacalizedBaseURL(), s, mUserId, s1, s2, "json"
        });
        doRequest(true);
    }

    private void clearUserQueue(String s)
    {
        mUrl = String.format("http://%s/queue/%s/empty/member/%s?format=%s", new Object[] {
            Application.getInstance().getLocalization().getLoacalizedBaseURL(), s, mUserId, "json"
        });
        doRequest(true);
    }

    private void doGetRequest(boolean flag, String s)
    {
        if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == DataRequest.RequestState.FAILED)
        {
            return;
        }
        Object obj;
        mItems = new ArrayList();
        mIDsList = new ArrayList();
        obj = CrackleHMAC.encodeURL(mUrl);
        HashMap hashmap = new HashMap();
        hashmap.put("Authorization", obj);
        Log.v("QueueManager", (new StringBuilder()).append("URL = ").append(mUrl).toString());
        obj = NetworkUtil.getJSONFromUrl(mUrl, hashmap);
        Log.v("QueueManager", (new StringBuilder()).append("QUEUE OBJECT = ").append(obj).toString());
        obj = ((JSONObject) (obj)).getJSONArray("Items");
        int i = 0;
_L2:
        if (i >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        QueueItem queueitem = new QueueItem(((JSONArray) (obj)).getJSONObject(i));
        mItems.add(queueitem);
        mIDsList.add(queueitem.getID());
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            mDataRequestListener.onDataSuccess(s);
            return;
        }
        catch (JSONException jsonexception)
        {
            mDataRequestListener.onDataFailed(s, DataRequest.getParseErrorString(1400));
            return;
        }
        catch (IOException ioexception)
        {
            mDataRequestListener.onDataFailed(s, DataRequest.getNetworkErrorString(1400));
            return;
        }
        catch (URISyntaxException urisyntaxexception)
        {
            mDataRequestListener.onDataFailed(s, DataRequest.getURIExceptionString(1400));
        }
        return;
    }

    private void doRequest(boolean flag)
    {
        (new Thread() {

            final QueueManager this$0;

            public void run()
            {
                if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == DataRequest.RequestState.FAILED)
                {
                    return;
                }
                try
                {
                    String s = CrackleHMAC.encodeURL(mUrl);
                    HashMap hashmap = new HashMap();
                    hashmap.put("Authorization", s);
                    Log.v("QueueManager", (new StringBuilder()).append("URL = ").append(mUrl).toString());
                    Log.v("QueueManager", NetworkUtil.getJSONFromUrl(mUrl, hashmap).toString(5));
                    mDataRequestListener.onDataSuccess("GENERAL_QUEUE");
                    return;
                }
                catch (JSONException jsonexception)
                {
                    mDataRequestListener.onDataFailed("GENERAL_QUEUE", DataRequest.getParseErrorString(1400));
                    return;
                }
                catch (IOException ioexception)
                {
                    mDataRequestListener.onDataFailed("GENERAL_QUEUE", DataRequest.getNetworkErrorString(1400));
                    return;
                }
                catch (URISyntaxException urisyntaxexception)
                {
                    mDataRequestListener.onDataFailed("GENERAL_QUEUE", DataRequest.getURIExceptionString(1400));
                }
                return;
            }

            
            {
                this$0 = QueueManager.this;
                super();
            }
        }).start();
    }

    private void getUserQueue(final String queueTitle, final String tag)
    {
        (new Thread() {

            final QueueManager this$0;
            final String val$queueTitle;
            final String val$tag;

            public void run()
            {
                mUrl = String.format("http://%s/queue/%s/list/member/%s/%s?format=%s", new Object[] {
                    Application.getInstance().getLocalization().getLoacalizedBaseURL(), queueTitle, mUserId, Application.getInstance().getLocalization().getCurrentCountryCode(), "json"
                });
                doGetRequest(false, tag);
            }

            
            {
                this$0 = QueueManager.this;
                queueTitle = s;
                tag = s1;
                super();
            }
        }).start();
    }

    private void removeFromUserQueue(String s, String s1, String s2)
    {
        mUrl = String.format("http://%s/queue/%s/remove/member/%s/%s/%s?format=%s", new Object[] {
            Application.getInstance().getLocalization().getLoacalizedBaseURL(), s, mUserId, s1, s2, "json"
        });
        doRequest(true);
    }

    public void addChannelToWatchlsit(String s)
    {
        Application.getInstance().getOmnitureTracker().addToWatchlist();
        if (SharedPrefsManager.getSocialOnEnabled() && CrackleAccountManager.isLoggedIn())
        {
            String s1 = CrackleAccountManager.getUserID();
            (new SocialOnAPI()).publishWantToWatchChannelItem(s1, s);
        }
        addToUserQueue("queue", "channel", s);
    }

    public void addMediaToWatchlist(String s)
    {
        Application.getInstance().getOmnitureTracker().addToWatchlist();
        if (SharedPrefsManager.getSocialOnEnabled() && CrackleAccountManager.isLoggedIn())
        {
            String s1 = CrackleAccountManager.getUserID();
            (new SocialOnAPI()).publishWantToWatchMediaItem(s1, s);
        }
        addToUserQueue("queue", "media", s);
    }

    public void addToHistory(String s)
    {
        addToUserQueue("history", "media", s);
    }

    public void clearUserHistory()
    {
        clearUserQueue("history");
    }

    public void clearWatchListCache()
    {
        mUrl = String.format("http://%s/queue/%s/list/member/%s/%s?format=%s", new Object[] {
            Application.getInstance().getLocalization().getLoacalizedBaseURL(), "queue", mUserId, Application.getInstance().getLocalization().getCurrentCountryCode(), "json"
        });
        CacheManager.removeJSONToCache(mUrl);
    }

    public void clearWatchlist(String s)
    {
        clearUserQueue("queue");
    }

    public List getIDsList()
    {
        if (mIDsList == null)
        {
            getWatchList();
        }
        return mIDsList;
    }

    public List getItems()
    {
        return mItems;
    }

    public void getUserHistory()
    {
        getUserQueue("history", "HISTORY_WATCHLIST");
    }

    public void getWatchList()
    {
        (new Thread() {

            final QueueManager this$0;

            public void run()
            {
                mUrl = String.format("http://%s/queue/%s/list/member/%s/%s?format=%s", new Object[] {
                    Application.getInstance().getLocalization().getLoacalizedBaseURL(), "queue", mUserId, Application.getInstance().getLocalization().getCurrentCountryCode(), "json"
                });
                doGetRequest(true, "FULL_WATCHLIST");
            }

            
            {
                this$0 = QueueManager.this;
                super();
            }
        }).start();
    }

    public void removeChannelFromWatchlist(String s)
    {
        Application.getInstance().getOmnitureTracker().removeFromWatchlist();
        removeFromUserQueue("queue", "channel", s);
    }

    public void removeFromHistory(String s)
    {
        removeFromUserQueue("history", "media", s);
    }

    public void removeMediaFromWatchlist(String s)
    {
        Application.getInstance().getOmnitureTracker().removeFromWatchlist();
        removeFromUserQueue("queue", "media", s);
    }



/*
    static String access$002(QueueManager queuemanager, String s)
    {
        queuemanager.mUrl = s;
        return s;
    }

*/


}
