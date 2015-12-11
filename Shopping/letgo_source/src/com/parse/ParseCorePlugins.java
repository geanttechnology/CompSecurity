// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.parse:
//            ParseAnalyticsController, Parse, ParseCloudCodeController, ParsePlugins, 
//            ParseCurrentConfigController, ParseConfigController, ParseFileController, NetworkObjectController, 
//            ParseObjectController, ParsePushChannelsController, ParsePushController, NetworkQueryController, 
//            OfflineQueryController, ParseQueryController, CacheQueryController

class ParseCorePlugins
{

    static final String CURRENT_CONFIG_FILENAME = "currentConfig";
    private static final ParseCorePlugins INSTANCE = new ParseCorePlugins();
    private AtomicReference analyticsController;
    private AtomicReference cloudCodeController;
    private AtomicReference configController;
    private AtomicReference fileController;
    private AtomicReference objectController;
    private AtomicReference pushChannelsController;
    private AtomicReference pushController;
    private AtomicReference queryController;

    private ParseCorePlugins()
    {
        objectController = new AtomicReference();
        queryController = new AtomicReference();
        fileController = new AtomicReference();
        analyticsController = new AtomicReference();
        cloudCodeController = new AtomicReference();
        configController = new AtomicReference();
        pushController = new AtomicReference();
        pushChannelsController = new AtomicReference();
    }

    public static ParseCorePlugins getInstance()
    {
        return INSTANCE;
    }

    public ParseAnalyticsController getAnalyticsController()
    {
        if (analyticsController.get() == null)
        {
            analyticsController.compareAndSet(null, new ParseAnalyticsController(Parse.getEventuallyQueue()));
        }
        return (ParseAnalyticsController)analyticsController.get();
    }

    public ParseCloudCodeController getCloudCodeController()
    {
        if (cloudCodeController.get() == null)
        {
            cloudCodeController.compareAndSet(null, new ParseCloudCodeController(ParsePlugins.get().restClient()));
        }
        return (ParseCloudCodeController)cloudCodeController.get();
    }

    public ParseConfigController getConfigController()
    {
        if (configController.get() == null)
        {
            ParseCurrentConfigController parsecurrentconfigcontroller = new ParseCurrentConfigController(new File(Parse.getParseDir(), "currentConfig"));
            configController.compareAndSet(null, new ParseConfigController(ParsePlugins.get().restClient(), parsecurrentconfigcontroller));
        }
        return (ParseConfigController)configController.get();
    }

    public ParseFileController getFileController()
    {
        if (fileController.get() == null)
        {
            fileController.compareAndSet(null, new ParseFileController(ParsePlugins.get().restClient(), Parse.getParseCacheDir("files")));
        }
        return (ParseFileController)fileController.get();
    }

    public ParseObjectController getObjectController()
    {
        if (objectController.get() == null)
        {
            objectController.compareAndSet(null, new NetworkObjectController(ParsePlugins.get().restClient()));
        }
        return (ParseObjectController)objectController.get();
    }

    public ParsePushChannelsController getPushChannelsController()
    {
        if (pushChannelsController.get() == null)
        {
            pushChannelsController.compareAndSet(null, new ParsePushChannelsController());
        }
        return (ParsePushChannelsController)pushChannelsController.get();
    }

    public ParsePushController getPushController()
    {
        if (pushController.get() == null)
        {
            pushController.compareAndSet(null, new ParsePushController(ParsePlugins.get().restClient()));
        }
        return (ParsePushController)pushController.get();
    }

    public ParseQueryController getQueryController()
    {
        if (queryController.get() == null)
        {
            Object obj = new NetworkQueryController(ParsePlugins.get().restClient());
            if (Parse.isLocalDatastoreEnabled())
            {
                obj = new OfflineQueryController(Parse.getLocalDatastore(), ((ParseQueryController) (obj)));
            } else
            {
                obj = new CacheQueryController(((NetworkQueryController) (obj)));
            }
            queryController.compareAndSet(null, obj);
        }
        return (ParseQueryController)queryController.get();
    }

    public void registerAnalyticsController(ParseAnalyticsController parseanalyticscontroller)
    {
        if (!analyticsController.compareAndSet(null, parseanalyticscontroller))
        {
            throw new IllegalStateException((new StringBuilder()).append("Another analytics controller was already registered: ").append(analyticsController.get()).toString());
        } else
        {
            return;
        }
    }

    public void registerCloudCodeController(ParseCloudCodeController parsecloudcodecontroller)
    {
        if (!cloudCodeController.compareAndSet(null, parsecloudcodecontroller))
        {
            throw new IllegalStateException((new StringBuilder()).append("Another cloud code controller was already registered: ").append(cloudCodeController.get()).toString());
        } else
        {
            return;
        }
    }

    public void registerConfigController(ParseConfigController parseconfigcontroller)
    {
        if (!configController.compareAndSet(null, parseconfigcontroller))
        {
            throw new IllegalStateException((new StringBuilder()).append("Another config controller was already registered: ").append(configController.get()).toString());
        } else
        {
            return;
        }
    }

    public void registerFileController(ParseFileController parsefilecontroller)
    {
        if (!fileController.compareAndSet(null, parsefilecontroller))
        {
            throw new IllegalStateException((new StringBuilder()).append("Another file controller was already registered: ").append(fileController.get()).toString());
        } else
        {
            return;
        }
    }

    public void registerObjectController(ParseObjectController parseobjectcontroller)
    {
        if (!objectController.compareAndSet(null, parseobjectcontroller))
        {
            throw new IllegalStateException((new StringBuilder()).append("Another object controller was already registered: ").append(objectController.get()).toString());
        } else
        {
            return;
        }
    }

    public void registerPushChannelsController(ParsePushChannelsController parsepushchannelscontroller)
    {
        if (!pushChannelsController.compareAndSet(null, parsepushchannelscontroller))
        {
            throw new IllegalStateException((new StringBuilder()).append("Another pushChannels controller was already registered: ").append(pushChannelsController.get()).toString());
        } else
        {
            return;
        }
    }

    public void registerPushController(ParsePushController parsepushcontroller)
    {
        if (!pushController.compareAndSet(null, parsepushcontroller))
        {
            throw new IllegalStateException((new StringBuilder()).append("Another push controller was already registered: ").append(pushController.get()).toString());
        } else
        {
            return;
        }
    }

    public void registerQueryController(ParseQueryController parsequerycontroller)
    {
        if (!queryController.compareAndSet(null, parsequerycontroller))
        {
            throw new IllegalStateException((new StringBuilder()).append("Another query controller was already registered: ").append(queryController.get()).toString());
        } else
        {
            return;
        }
    }

    void reset()
    {
        objectController.set(null);
        queryController.set(null);
        fileController.set(null);
        analyticsController.set(null);
        cloudCodeController.set(null);
        configController.set(null);
        pushController.set(null);
        pushChannelsController.set(null);
    }

}
