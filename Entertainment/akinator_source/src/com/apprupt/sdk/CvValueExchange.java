// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.format.DateFormat;
import com.apprupt.sdk.mediation.AdWrapper;
import com.apprupt.sdk.mediation.Adapter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.apprupt.sdk:
//            Logger, SimpleJSON, CvSDK, CvMediation, 
//            CvViewHelper

public class CvValueExchange
{
    private class Cappings
    {

        private RewardConfig config;
        final CvValueExchange this$0;
        private String ts;
        private int views;

        private boolean canShowAd()
        {
            return viewsLeft() > 0;
        }

        private void incrementViews()
        {
            update(false);
            views = views + 1;
            saveCappings();
        }

        private JSONObject toJSON()
        {
            SimpleJSON simplejson = new SimpleJSON();
            simplejson.put("ts", ts);
            simplejson.put("views", Integer.valueOf(views));
            return simplejson.json;
        }

        private void update(RewardConfig rewardconfig)
        {
            config = rewardconfig;
            update(false);
        }

        private void update(boolean flag)
        {
            String s = DateFormat.format("yy/MM/dd", Calendar.getInstance().getTime()).toString();
            if (!ts.equals(s))
            {
                ts = s;
                views = 0;
                if (flag)
                {
                    saveCappings();
                }
            }
        }

        private int viewsLeft()
        {
            update(true);
            return Math.max(0, config.capping - views);
        }






        private Cappings(RewardConfig rewardconfig, SimpleJSON simplejson)
        {
            this$0 = CvValueExchange.this;
            super();
            views = 0;
            ts = "-----";
            if (simplejson != null)
            {
                views = simplejson.getInt("views", Integer.valueOf(0));
                ts = simplejson.getString("ts", "-----");
            }
            update(rewardconfig);
        }

    }

    public static interface Listener
    {

        public abstract void onReward(Reward reward);
    }

    public class Reward
    {

        public final int adSpaceId;
        public final String currency;
        public final int rewardAmount;
        final CvValueExchange this$0;

        private Reward(int i, String s, int j)
        {
            this$0 = CvValueExchange.this;
            super();
            adSpaceId = i;
            currency = s;
            rewardAmount = j;
        }

    }

    private class RewardConfig
    {

        final int capping;
        final String currency;
        final int reward;
        final CvValueExchange this$0;

        private RewardConfig(String s, int i, int j)
        {
            this$0 = CvValueExchange.this;
            super();
            currency = s;
            reward = i;
            capping = j;
        }

    }

    static final class Status extends Enum
    {

        private static final Status $VALUES[];
        public static final Status DISABLED;
        public static final Status EXCEEDED;
        public static final Status READY;

        public static Status valueOf(String s)
        {
            return (Status)Enum.valueOf(com/apprupt/sdk/CvValueExchange$Status, s);
        }

        public static Status[] values()
        {
            return (Status[])$VALUES.clone();
        }

        static 
        {
            DISABLED = new Status("DISABLED", 0);
            READY = new Status("READY", 1);
            EXCEEDED = new Status("EXCEEDED", 2);
            $VALUES = (new Status[] {
                DISABLED, READY, EXCEEDED
            });
        }

        private Status(String s, int i)
        {
            super(s, i);
        }
    }


    private static final Logger.log llog = Logger.get("Lifecycle.VE");
    private volatile HashMap cappings;
    private volatile HashMap config;
    private volatile Context context;
    private volatile Listener listener;

    public CvValueExchange()
    {
        listener = null;
        config = new HashMap();
        cappings = new HashMap();
    }

    private RewardConfig createConfig(SimpleJSON simplejson, RewardConfig rewardconfig)
    {
        return new RewardConfig(simplejson.getString("currency", rewardconfig.currency), simplejson.getInt("rewardAmount", Integer.valueOf(rewardconfig.reward)), simplejson.getInt("dailyLimit", Integer.valueOf(rewardconfig.capping)));
    }

    RewardConfig configForAdSpace(String s)
    {
        if (config.containsKey(s))
        {
            return (RewardConfig)config.get(s);
        } else
        {
            return null;
        }
    }

    void configure(SimpleJSON simplejson)
    {
        Object obj1 = sharedPreferences();
        Object obj = simplejson;
        if (simplejson == null)
        {
            simplejson = ((SharedPreferences) (obj1)).getString("config", null);
            if (simplejson == null || simplejson.length() == 0)
            {
                return;
            }
            obj = new SimpleJSON(simplejson);
        }
        llog.i(new Object[] {
            "Got ve config", ((SimpleJSON) (obj)).toString()
        });
        simplejson = ((SharedPreferences) (obj1)).edit();
        simplejson.putString("config", ((SimpleJSON) (obj)).toString());
        simplejson.commit();
        simplejson = ((SharedPreferences) (obj1)).getString("cappings", null);
        RewardConfig rewardconfig;
        SimpleJSON simplejson1;
        JSONArray jsonarray;
        int i;
        if (simplejson != null && simplejson.length() > 0)
        {
            simplejson = new SimpleJSON(simplejson);
        } else
        {
            simplejson = new SimpleJSON();
        }
        rewardconfig = createConfig(((SimpleJSON) (obj)), new RewardConfig("Credits", 1, 20));
        simplejson1 = ((SimpleJSON) (obj)).getJSONObject("spaces");
        jsonarray = simplejson1.names();
        config.clear();
        cappings.clear();
        i = 0;
        if (i >= jsonarray.length()) goto _L2; else goto _L1
_L1:
        obj = null;
        obj1 = jsonarray.getString(i);
        obj = obj1;
_L4:
        if (obj != null)
        {
            obj1 = createConfig(simplejson1.getJSONObject(((String) (obj)), new SimpleJSON()), rewardconfig);
            config.put(obj, obj1);
            obj1 = new Cappings(((RewardConfig) (obj1)), simplejson.getJSONObject(((String) (obj))));
            cappings.put(obj, obj1);
            llog.i(new Object[] {
                "ve config for", obj, Integer.valueOf(((Cappings) (obj1)).viewsLeft())
            });
        }
        i++;
        break MISSING_BLOCK_LABEL_176;
_L2:
        saveCappings();
        return;
        JSONException jsonexception;
        jsonexception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void fetchInterstitial(final Context context, final int adSpaceId, final CvContentManager.PreloaderListener listener, final String categories, final String keywords)
    {
        CvSDK.mediation.checkConfig(new Runnable() {

            final CvValueExchange this$0;
            final int val$adSpaceId;
            final String val$categories;
            final Context val$context;
            final String val$keywords;
            final CvContentManager.PreloaderListener val$listener;

            public void run()
            {
                CvValueExchange.llog.i(new Object[] {
                    "Preparing for ve..."
                });
            /* block-local class not found */
            class _cls1 {}

                CvViewHelper.runOnUIThread(new _cls1(), true);
            }

            
            {
                this$0 = CvValueExchange.this;
                adSpaceId = i;
                listener = preloaderlistener;
                categories = s;
                keywords = s1;
                context = context1;
                super();
            }
        });
    }

    void grantReward(final String adSpaceId, Adapter adapter, AdWrapper adwrapper)
    {
        CvViewHelper.runOnUIThread(new Runnable() {

            final CvValueExchange this$0;
            final String val$adSpaceId;

            public void run()
            {
                Cappings cappings1 = (Cappings)cappings.get(adSpaceId);
                if (cappings1 != null)
                {
                    CvValueExchange.llog.i(new Object[] {
                        "Grant rewardAmount ", cappings1.config.currency, Integer.valueOf(cappings1.config.reward), Integer.valueOf(cappings1.viewsLeft())
                    });
                    RewardConfig rewardconfig = cappings1.config;
                    if (rewardconfig != null && listener != null)
                    {
                        listener.onReward(new Reward(Integer.valueOf(adSpaceId).intValue(), rewardconfig.currency, rewardconfig.reward));
                        cappings1.incrementViews();
                    }
                    return;
                } else
                {
                    CvValueExchange.llog.e(new Object[] {
                        "Grant rewardAmount - unknown space", adSpaceId
                    });
                    return;
                }
            }

            
            {
                this$0 = CvValueExchange.this;
                adSpaceId = s;
                super();
            }
        });
    }

    void saveCappings()
    {
        Object obj = cappings.entrySet().iterator();
        SimpleJSON simplejson = new SimpleJSON();
        java.util.Map.Entry entry;
        for (; ((Iterator) (obj)).hasNext(); simplejson.put((String)entry.getKey(), ((Cappings)entry.getValue()).toJSON()))
        {
            entry = (java.util.Map.Entry)((Iterator) (obj)).next();
        }

        obj = sharedPreferences().edit();
        ((android.content.SharedPreferences.Editor) (obj)).putString("cappings", simplejson.toString());
        ((android.content.SharedPreferences.Editor) (obj)).commit();
    }

    void setContext(Context context1)
    {
        context = context1.getApplicationContext();
    }

    public void setValueExchangeListener(Listener listener1)
    {
        listener = listener1;
    }

    SharedPreferences sharedPreferences()
    {
        return context.getSharedPreferences("cvValueExchange", 0);
    }

    Status spaceStatus(int i)
    {
        Cappings cappings1 = (Cappings)cappings.get(Integer.toString(i));
        if (cappings1 == null)
        {
            return Status.DISABLED;
        }
        if (cappings1.viewsLeft() > 0)
        {
            return Status.READY;
        } else
        {
            return Status.EXCEEDED;
        }
    }

    Status spaceStatus(String s)
    {
        return spaceStatus(Integer.valueOf(s).intValue());
    }

    public void startInterstitial(Context context1, int i)
    {
        startInterstitial(context1, i, null, "", "");
    }

    public void startInterstitial(Context context1, int i, CvSDK.CvInterstitialListener cvinterstitiallistener)
    {
        startInterstitial(context1, i, cvinterstitiallistener, "", "");
    }

    public void startInterstitial(Context context1, int i, CvSDK.CvInterstitialListener cvinterstitiallistener, String s)
    {
        startInterstitial(context1, i, cvinterstitiallistener, s, "");
    }

    public void startInterstitial(final Context context, final int adSpaceId, final CvSDK.CvInterstitialListener listener, final String categories, final String keywords)
    {
        CvSDK.mediation.checkConfig(new Runnable() {

            final CvValueExchange this$0;
            final int val$adSpaceId;
            final String val$categories;
            final Context val$context;
            final String val$keywords;
            final CvSDK.CvInterstitialListener val$listener;

            public void run()
            {
                CvValueExchange.llog.i(new Object[] {
                    "Preparing for ve..."
                });
            /* block-local class not found */
            class _cls1 {}

                CvViewHelper.runOnUIThread(new _cls1(), true);
            }

            
            {
                this$0 = CvValueExchange.this;
                adSpaceId = i;
                listener = cvinterstitiallistener;
                categories = s;
                keywords = s1;
                context = context1;
                super();
            }
        });
    }

    public void startInterstitial(Context context1, int i, String s)
    {
        startInterstitial(context1, i, null, s, "");
    }

    public void startInterstitial(Context context1, int i, String s, String s1)
    {
        startInterstitial(context1, i, null, s, s1);
    }

    public int viewsLeftForAdSpace(int i)
    {
        Cappings cappings1 = (Cappings)cappings.get(Integer.toString(i));
        if (cappings1 == null)
        {
            return 0;
        } else
        {
            return cappings1.viewsLeft();
        }
    }




}
