// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import org.json.JSONObject;

// Referenced classes of package com.apprupt.sdk:
//            Logger, SerialExecutor, SimpleJSON, Q, 
//            CvUnderscore, CvUrl, URLRequest, CvCrypto

public class CvConfig
{
    static interface Listener
    {

        public abstract void onConfigUpdated(CvConfig cvconfig);
    }

    static interface PropertiesProvider
    {

        public abstract Q.Task getRequestPrepareTask();
    }


    private static final String BUNDLE_FORMAT = "android.%s";
    private static final String CFG_RQ_KEY_BUNDLE = "bundle";
    private static final String CFG_RQ_PARAM = "_";
    private static final String CFG_RQ_URL_PATH = "/mCfg";
    private static final long ERROR_RELOAD_INTERVAL = 0x927c0L;
    private static final long RELOAD_INTERVAL = 0x1b77400L;
    private static final Logger.log qlog = Logger.get("Q");
    private volatile String bundle;
    private volatile SimpleJSON config;
    final Q.Task configRequest = new Q.Task() {

        final CvConfig this$0;

        public void run(Object obj, Q.Resolver resolver)
            throws Exception
        {
            log.v(new Object[] {
                "Requesting config"
            });
            obj = (CvUnderscore)obj;
            CvConfig.qlog.v(new Object[] {
                "Resolve: load config, result: <URLRequest>"
            });
            resolver.resolve(URLRequest.post(CvUrl.build("/mCfg")).addPostParam("_", ((CvUnderscore) (obj)).toString()).defer());
        }

            
            {
                this$0 = CvConfig.this;
                super();
            }
    };
    private Context context;
    final Q.Task decodeConfig = new Q.Task() {

        final CvConfig this$0;

        public void run(Object obj, Q.Resolver resolver)
            throws Exception
        {
            log.v(new Object[] {
                "Config decode"
            });
            obj = CvCrypto.decode(((URLRequest.URLResponse)obj).data);
            if (obj == null || obj.length == 0)
            {
                throw new Exception("Cannot decode response data");
            }
            obj = new String(((byte []) (obj)));
            if (((String) (obj)).length() == 0)
            {
                throw new Exception("Cannot decode response data!");
            } else
            {
                log.v(new Object[] {
                    "Resolve: decode config:", obj
                });
                resolver.resolve(obj);
                return;
            }
        }

            
            {
                this$0 = CvConfig.this;
                super();
            }
    };
    final Q.SuccessHandler finishLoading = new Q.SuccessHandler() {

        final CvConfig this$0;

        public void onSuccess(Object obj)
        {
            serialQueue.execute(((_cls1) (obj)). new Runnable() {

                final _cls14 this$1;
                final Object val$result;

                public void run()
                {
                    config = (SimpleJSON)result;
                    loader = null;
                    log.v(new Object[] {
                        "Calling listeners"
                    });
                    Listener listener;
                    for (Iterator iterator = listeners.iterator(); iterator.hasNext(); callListener(listener))
                    {
                        listener = (Listener)iterator.next();
                        log.v(new Object[] {
                            "Calling listener..."
                        });
                    }

                    log.v(new Object[] {
                        "Calling waiting objects"
                    });
                    for (; waitingQueue.size() > 0; handler.post((Runnable)waitingQueue.poll()))
                    {
                        log.v(new Object[] {
                            "Calling waiting  object..."
                        });
                    }

                    log.i(new Object[] {
                        "Config done! next reload:", Long.valueOf(nextReload)
                    });
                }

            
            {
                this$1 = final__pcls14;
                result = Object.this;
                super();
            }
            });
        }

            
            {
                this$0 = CvConfig.this;
                super();
            }
    };
    private final Handler handler = new Handler(Looper.getMainLooper());
    private volatile long lastLoaded;
    private final List listeners = new ArrayList();
    private volatile Q loader;
    private final Logger.log log = Logger.get("CvConfig");
    private volatile long nextReload;
    final Q.Task parseConfig = new Q.Task() {

        final CvConfig this$0;

        public void run(Object obj, Q.Resolver resolver)
            throws Exception
        {
label0:
            {
                log.v(new Object[] {
                    "Parsing config..."
                });
                obj = (String)obj;
                if (((String) (obj)).equals("null") || !((String) (obj)).startsWith("{") || !((String) (obj)).endsWith("}"))
                {
                    throw new Exception("Cannot parse response - invalid JSON string");
                }
                SimpleJSON simplejson = new SimpleJSON(new JSONObject(((String) (obj))));
                SimpleJSON simplejson1 = simplejson.getJSONObject("mediation", new SimpleJSON("{\"dummy\":true}"));
                if (simplejson1 != null && !simplejson1.getBoolean("dummy", false))
                {
                    obj = simplejson;
                    if (simplejson1.has("adapters"))
                    {
                        break label0;
                    }
                }
                obj = new SimpleJSON();
                ((SimpleJSON) (obj)).put("mediation", simplejson.json);
            }
            log.v(new Object[] {
                "Resolve: parse config:", obj
            });
            resolver.resolve(obj);
        }

            
            {
                this$0 = CvConfig.this;
                super();
            }
    };
    final Q.Task prepareParams = new Q.Task() {

        final CvConfig this$0;

        public void run(Object obj, Q.Resolver resolver)
            throws Exception
        {
            log.v(new Object[] {
                "Preparing params"
            });
            obj = CvUnderscore.create().put("bundle", String.format("android.%s", new Object[] {
                getBundleId()
            }));
            boolean flag = false;
            Q q = Q.take(obj);
            Iterator iterator = propertiesProviders.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Q.Task task = ((PropertiesProvider)iterator.next()).getRequestPrepareTask();
                if (task != null)
                {
                    flag = true;
                    q.then(task);
                }
            } while (true);
            if (flag)
            {
                q.success(resolver. new Q.SuccessHandler() {

                    final _cls7 this$1;
                    final Q.Resolver val$resolver;

                    public void onSuccess(Object obj)
                    {
                        resolver.resolve(obj);
                    }

            
            {
                this$1 = final__pcls7;
                resolver = Q.Resolver.this;
                super();
            }
                }).failure(resolver. new Q.FailureHandler() {

                    final _cls7 this$1;
                    final Q.Resolver val$resolver;

                    public void onFailure(Throwable throwable, Object obj)
                    {
                        resolver.fail(throwable, obj);
                    }

            
            {
                this$1 = final__pcls7;
                resolver = Q.Resolver.this;
                super();
            }
                });
                return;
            } else
            {
                resolver.resolve(obj);
                return;
            }
        }

            
            {
                this$0 = CvConfig.this;
                super();
            }
    };
    private final List propertiesProviders = new ArrayList();
    private volatile int requestCounter;
    final Q.Task restoreConfig = new Q.Task() {

        final CvConfig this$0;

        public void run(Object obj, Q.Resolver resolver)
            throws Exception
        {
            obj = context.openFileInput(getConfigFilename());
            StringBuilder stringbuilder = new StringBuilder();
            do
            {
                int i = ((FileInputStream) (obj)).read();
                if (i != -1)
                {
                    stringbuilder.append((char)i);
                } else
                {
                    ((FileInputStream) (obj)).close();
                    resolver.resolve(stringbuilder.toString());
                    return;
                }
            } while (true);
        }

            
            {
                this$0 = CvConfig.this;
                super();
            }
    };
    final Q.Task saveConfig = new Q.Task() {

        final CvConfig this$0;

        public void run(Object obj, Q.Resolver resolver)
            throws Exception
        {
            obj = (SimpleJSON)obj;
            try
            {
                FileOutputStream fileoutputstream = context.openFileOutput(getConfigFilename(), 0);
                fileoutputstream.write(((SimpleJSON) (obj)).toString().getBytes());
                fileoutputstream.close();
            }
            catch (Exception exception)
            {
                log.e(new Object[] {
                    "Cannot write config file, skipping"
                });
            }
            resolver.resolve(obj);
        }

            
            {
                this$0 = CvConfig.this;
                super();
            }
    };
    private final SerialExecutor serialQueue = new SerialExecutor();
    private final Queue waitingQueue = new ArrayDeque();

    CvConfig()
    {
        loader = null;
        context = null;
        lastLoaded = 0L;
        nextReload = 0L;
        requestCounter = 0;
        config = new SimpleJSON();
        bundle = null;
    }

    private void callListener(final Listener listener)
    {
        handler.post(new Runnable() {

            final CvConfig this$0;
            final Listener val$listener;

            public void run()
            {
                listener.onConfigUpdated(CvConfig.this);
            }

            
            {
                this$0 = CvConfig.this;
                listener = listener1;
                super();
            }
        });
    }

    private void loadConfig()
    {
        this;
        JVM INSTR monitorenter ;
        if (Looper.myLooper() == null)
        {
            Looper.prepare();
        }
        log.v(new Object[] {
            (new StringBuilder()).append("Creating q...").append(loader).toString()
        });
        loader = new Q();
        log.v(new Object[] {
            "Adding steps:"
        });
        log.v(new Object[] {
            " - prepare params"
        });
        loader.then(prepareParams);
        log.v(new Object[] {
            " - request config"
        });
        loader.then(configRequest);
        log.v(new Object[] {
            " - decode data"
        });
        loader.then(decodeConfig);
        log.v(new Object[] {
            " - parse data"
        });
        loader.then(parseConfig);
        log.v(new Object[] {
            " - save data to files"
        });
        loader.then(saveConfig);
        log.v(new Object[] {
            "Add error handler"
        });
        loader.failure(new Q.FailureHandler() {

            final CvConfig this$0;

            public void onFailure(Throwable throwable, Object obj)
            {
                log.w(throwable, new Object[] {
                    "Cannot load mCfg"
                });
                nextReload = System.currentTimeMillis() + 0x927c0L;
            /* block-local class not found */
            class _cls1 {}

                Q.when(restoreConfig).then(parseConfig).failure(new _cls1()).success(finishLoading);
            }

            
            {
                this$0 = CvConfig.this;
                super();
            }
        });
        log.v(new Object[] {
            "Add success handler"
        });
        loader.success(new Q.SuccessHandler() {

            final CvConfig this$0;

            public void onSuccess(Object obj)
            {
                log.i(new Object[] {
                    "Config loaded successfully"
                });
                lastLoaded = System.currentTimeMillis();
                nextReload = lastLoaded + 0x1b77400L;
                finishLoading.onSuccess(obj);
            }

            
            {
                this$0 = CvConfig.this;
                super();
            }
        });
        log.v(new Object[] {
            "Loading configuration"
        });
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void doCheck(final Runnable callback)
    {
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final CvConfig this$0;
            final Runnable val$callback;

            public void run()
            {
                boolean flag = true;
                CvConfig cvconfig = CvConfig.this;
                cvconfig;
                JVM INSTR monitorenter ;
                log.v(new Object[] {
                    "do check..."
                });
                Exception exception;
                if (nextReload > System.currentTimeMillis())
                {
                    flag = false;
                }
                if (loader != null || flag)
                {
                    break MISSING_BLOCK_LABEL_83;
                }
                if (callback != null)
                {
                    handler.post(callback);
                }
                cvconfig;
                JVM INSTR monitorexit ;
                return;
                if (callback != null)
                {
                    waitingQueue.offer(callback);
                }
                if (context == null || loader != null || !flag)
                {
                    break MISSING_BLOCK_LABEL_138;
                }
                loadConfig();
                cvconfig;
                JVM INSTR monitorexit ;
                return;
                exception;
                cvconfig;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                this$0 = CvConfig.this;
                callback = runnable;
                super();
            }
        });
    }

    public SimpleJSON get(String s)
    {
        if (config == null)
        {
            return new SimpleJSON();
        }
        if (!config.has(s) || config.getJSONObject(s) == null)
        {
            config.put(s, new SimpleJSON());
        }
        return config.getJSONObject(s);
    }

    String getBundleId()
    {
        if (bundle == null)
        {
            return context.getApplicationContext().getPackageName();
        } else
        {
            return bundle;
        }
    }

    String getConfigFilename()
    {
        return String.format("com.apprupt.config-%s", new Object[] {
            context.getPackageName()
        });
    }

    public long getLastLoaded()
    {
        return lastLoaded;
    }

    void initialize(final Context context)
    {
        log.v(new Object[] {
            "Initializing config..."
        });
        serialQueue.execute(new Runnable() {

            final CvConfig this$0;
            final Context val$context;

            public void run()
            {
                log.i(new Object[] {
                    "Config initialized"
                });
                CvConfig.this.context = context.getApplicationContext();
                doCheck(null);
            }

            
            {
                this$0 = CvConfig.this;
                context = context1;
                super();
            }
        });
    }

    void overrideBundle(String s)
    {
        if (s == null || s.length() == 0)
        {
            bundle = null;
            return;
        } else
        {
            bundle = s;
            return;
        }
    }

    void registerListener(final Listener listener)
    {
        serialQueue.execute(new Runnable() {

            final CvConfig this$0;
            final Listener val$listener;

            public void run()
            {
                listeners.add(listener);
                int i = requestCounter;
            /* block-local class not found */
            class _cls1 {}

                if (loader == null)
                {
                    doCheck(new _cls1(i + 0));
                }
            }

            
            {
                this$0 = CvConfig.this;
                listener = listener1;
                super();
            }
        });
    }

    void unregisterListener(final Listener listener)
    {
        serialQueue.execute(new Runnable() {

            final CvConfig this$0;
            final Listener val$listener;

            public void run()
            {
                listeners.remove(listener);
            }

            
            {
                this$0 = CvConfig.this;
                listener = listener1;
                super();
            }
        });
    }






/*
    static Context access$102(CvConfig cvconfig, Context context1)
    {
        cvconfig.context = context1;
        return context1;
    }

*/



/*
    static SimpleJSON access$1202(CvConfig cvconfig, SimpleJSON simplejson)
    {
        cvconfig.config = simplejson;
        return simplejson;
    }

*/







/*
    static Q access$402(CvConfig cvconfig, Q q)
    {
        cvconfig.loader = q;
        return q;
    }

*/



/*
    static long access$502(CvConfig cvconfig, long l)
    {
        cvconfig.nextReload = l;
        return l;
    }

*/






/*
    static long access$902(CvConfig cvconfig, long l)
    {
        cvconfig.lastLoaded = l;
        return l;
    }

*/
}
