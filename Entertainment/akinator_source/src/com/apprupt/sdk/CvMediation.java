// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.apprupt.sdk.mediation.AdWrapper;
import com.apprupt.sdk.mediation.Adapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

// Referenced classes of package com.apprupt.sdk:
//            Logger, CvMediator, CvSDK, CvConfig, 
//            CvContentOptions, Q, SimpleJSON, CvValueExchange, 
//            CvViewHelper

public class CvMediation
{

    private static final String DEFAULT_KEY = "__default__";
    private static final HashMap cache = new HashMap();
    private static final Logger.log log = Logger.get("Mediation");
    private static final Logger.log qlog = Logger.get("Q");
    private final HashMap adapters = new HashMap();
    final Q.Task configureAdapters = new Q.Task() {

        final CvMediation this$0;

        public void run(Object obj, Q.Resolver resolver)
            throws Exception
        {
            CvMediation.log.v(new Object[] {
                "Processing adapters config..."
            });
            obj = (SimpleJSON)obj;
            SimpleJSON simplejson = ((SimpleJSON) (obj)).getJSONObject("adapters");
            if (simplejson != null)
            {
                JSONArray jsonarray = simplejson.names();
                for (int i = 0; i < jsonarray.length(); i++)
                {
                    String s = (String)jsonarray.get(i);
                    if (adapters.containsKey(s))
                    {
                        llog.i(new Object[] {
                            "Configuration for", s
                        });
                        ((Adapter)adapters.get(s)).configure(simplejson.getJSONObject(s).json);
                    }
                }

            }
            CvMediation.qlog.v(new Object[] {
                "Resolve: process adapters config:", obj
            });
            resolver.resolve(obj);
        }

            
            {
                this$0 = CvMediation.this;
                super();
            }
    };
    final Q.Task configureOrder = new Q.Task() {

        final CvMediation this$0;

        public void run(Object obj, Q.Resolver resolver)
            throws Exception
        {
            CvMediation.log.v(new Object[] {
                "Processing order config..."
            });
            obj = (SimpleJSON)obj;
            SimpleJSON simplejson = ((SimpleJSON) (obj)).getJSONObject("order");
            if (simplejson != null)
            {
                order.clear();
                JSONArray jsonarray = simplejson.names();
                for (int i = 0; i < jsonarray.length(); i++)
                {
                    String s = jsonarray.getString(i);
                    order.put(s, simplejson.getStringsList(s, new ArrayList()));
                }

            }
            if (!order.containsKey("__default__"))
            {
                order.put("__default__", new ArrayList(Arrays.asList(com.apprupt.sdk.mediation.Adapter.Info.defaultOrder())));
            }
            CvMediation.qlog.v(new Object[] {
                "Resolve: process order config:", obj
            });
            resolver.resolve(obj);
        }

            
            {
                this$0 = CvMediation.this;
                super();
            }
    };
    final Q.Task configureValueExchange = new Q.Task() {

        final CvMediation this$0;

        public void run(Object obj, Q.Resolver resolver)
            throws Exception
        {
            CvMediation.log.v(new Object[] {
                "Processing order config..."
            });
            obj = (SimpleJSON)obj;
            CvSDK.valueExchange.configure(((SimpleJSON) (obj)).getJSONObject("valueExchange"));
            resolver.resolve(obj);
        }

            
            {
                this$0 = CvMediation.this;
                super();
            }
    };
    private final Handler handler = new Handler();
    private volatile boolean initialized;
    private final Logger.log llog = Logger.get("Lifecycle.Mediation");
    private HashMap order;
    private Q reloader;
    private long timestamp;

    CvMediation()
    {
        order = new HashMap();
        initialized = false;
        reloader = null;
        timestamp = -1L;
        order.put("__default__", new ArrayList(Arrays.asList(com.apprupt.sdk.mediation.Adapter.Info.defaultOrder())));
    }

    private List buildMediationQueue(String s)
    {
        ArrayList arraylist = new ArrayList();
        if (order.containsKey(s))
        {
            s = (List)order.get(s);
        } else
        {
            s = (List)order.get("__default__");
        }
        s = s.iterator();
        do
        {
            if (!s.hasNext())
            {
                break;
            }
            String s1 = (String)s.next();
            if (adapters.containsKey(s1))
            {
                arraylist.add(adapters.get(s1));
            }
        } while (true);
        return arraylist;
    }

    private void configure(final SimpleJSON json, final long ts)
    {
        handler.post(new Runnable() {

            final CvMediation this$0;
            final SimpleJSON val$json;
            final long val$ts;

            public void run()
            {
                if (ts > timestamp)
                {
                    timestamp = ts;
            /* block-local class not found */
            class _cls2 {}

            /* block-local class not found */
            class _cls1 {}

                    reloader = Q.take(json).then(configureAdapters).then(configureOrder).then(configureValueExchange).success(new _cls2()).failure(new _cls1());
                }
            }

            
            {
                this$0 = CvMediation.this;
                ts = l;
                json = simplejson;
                super();
            }
        });
    }

    private void findAdapters(Activity activity)
    {
        com.apprupt.sdk.mediation.Adapter.Info ainfo[];
        int i;
        int j;
        log.i(new Object[] {
            "Searching for adapters"
        });
        ainfo = com.apprupt.sdk.mediation.Adapter.Info.values();
        j = ainfo.length;
        i = 0;
_L2:
        String s;
        com.apprupt.sdk.mediation.Adapter.Info info;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_183;
        }
        info = ainfo[i];
        s = info.toClassName();
        Adapter adapter = (Adapter)Class.forName(s).newInstance();
        adapter.init(activity);
        if (adapter.isActive())
        {
            log.i(new Object[] {
                "Found active adapter:", s
            });
            adapters.put(info.toString(), adapter);
            break MISSING_BLOCK_LABEL_184;
        }
        try
        {
            log.i(new Object[] {
                "Found adapter but it is inactive", s
            });
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            log.v(new Object[] {
                "Adapter not found:", s
            });
        }
        catch (Exception exception)
        {
            log.e(exception, new Object[0]);
        }
        break MISSING_BLOCK_LABEL_184;
        return;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private HashMap getAdapters()
    {
        return new HashMap(adapters);
    }

    private CvMediator loadAd(final Context mediator, final CvContentOptions contentOptions, CvMediator.Completion completion, com.apprupt.sdk.mediation.AdWrapper.Listener listener)
    {
        llog.v(new Object[] {
            "loadAd->checkConfig"
        });
        mediator = new CvMediator(mediator, contentOptions, completion, listener);
        checkConfig(new Runnable() {

            final CvMediation this$0;
            final CvContentOptions val$contentOptions;
            final CvMediator val$mediator;

            public void run()
            {
            /* block-local class not found */
            class _cls1 {}

                CvViewHelper.runOnUIThread(new _cls1(), true);
            }

            
            {
                this$0 = CvMediation.this;
                contentOptions = cvcontentoptions;
                mediator = cvmediator;
                super();
            }
        });
        return mediator;
    }

    void checkConfig(final Runnable callback)
    {
        if (!initialized)
        {
            throw new InternalError("CvSDK has not been initialized yet! Run CvSDK.initialize(Activity mainActivity) first.");
        } else
        {
            CvSDK.config.doCheck(new Runnable() {

                final CvMediation this$0;
                final Runnable val$callback;

                public void run()
                {
                /* block-local class not found */
                class _cls1 {}

                    handler.post(new _cls1());
                }

            
            {
                this$0 = CvMediation.this;
                callback = runnable;
                super();
            }
            });
            return;
        }
    }

    public CvMediator fetchAd(final Context mediator, final CvContentOptions contentOptions, final CvContentManager.PreloaderListener listener)
    {
        mediator = new CvMediator(mediator, contentOptions, new CvMediator.Completion() {

            final CvMediation this$0;
            final CvContentOptions val$contentOptions;
            final CvContentManager.PreloaderListener val$listener;

            public void onFailure(String s)
            {
            /* block-local class not found */
            class _cls1 {}

                CvViewHelper.runOnUIThread(new _cls1(s), true);
            }

            public void onSuccess(AdWrapper adwrapper)
            {
            /* block-local class not found */
            class _cls2 {}

                CvViewHelper.runOnUIThread(new _cls2(adwrapper), true);
            }

            
            {
                this$0 = CvMediation.this;
                listener = preloaderlistener;
                contentOptions = cvcontentoptions;
                super();
            }
        }, null);
        checkConfig(new Runnable() {

            final CvMediation this$0;
            final CvMediator val$mediator;

            public void run()
            {
                llog.v(new Object[] {
                    "load mediator"
                });
                mediator.load(getAdapters(), buildMediationQueue(mediator.getContentOptions().adSpaceId));
            }

            
            {
                this$0 = CvMediation.this;
                mediator = cvmediator;
                super();
            }
        });
        return mediator;
    }

    void initialize(Activity activity)
    {
        if (initialized)
        {
            log.v(new Object[] {
                "Mediation already initialized, skipping"
            });
        } else
        {
            log.i(new Object[] {
                "Initializing mediation module"
            });
            findAdapters(activity);
            initialized = true;
        }
        CvSDK.config.registerListener(new CvConfig.Listener() {

            final CvMediation this$0;

            public void onConfigUpdated(CvConfig cvconfig)
            {
                configure(cvconfig.get("mediation"), cvconfig.getLastLoaded());
            }

            
            {
                this$0 = CvMediation.this;
                super();
            }
        });
    }

    public CvMediator loadInlineAd(Context context, CvContentOptions cvcontentoptions, CvMediator.Completion completion, com.apprupt.sdk.mediation.InlineAdWrapper.Listener listener)
    {
        if (cvcontentoptions.interstitial)
        {
            throw new InternalError("Invalid arguments set (interstitial + inline listener");
        } else
        {
            return loadAd(context, cvcontentoptions, completion, listener);
        }
    }

    public CvMediator loadInterstitialAd(Context context, CvContentOptions cvcontentoptions, CvMediator.Completion completion)
    {
        if (!cvcontentoptions.interstitial)
        {
            throw new InternalError("Invalid arguments set (inline + interstitial listener");
        } else
        {
            return loadAd(context, cvcontentoptions, completion, null);
        }
    }






/*
    static long access$102(CvMediation cvmediation, long l)
    {
        cvmediation.timestamp = l;
        return l;
    }

*/




/*
    static Q access$202(CvMediation cvmediation, Q q)
    {
        cvmediation.reloader = q;
        return q;
    }

*/







}
