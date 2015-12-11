// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.parse:
//            ParseAnalyticsController, Parse, ParseAuthenticationManager, ParseCloudCodeController, 
//            ParsePlugins, ParseCurrentConfigController, ParseConfigController, FileObjectStore, 
//            ParseInstallation, ParseObjectCurrentCoder, OfflineObjectStore, CachedCurrentInstallationController, 
//            ParseCurrentInstallationController, ParseUser, ParseUserCurrentCoder, CachedCurrentUserController, 
//            ParseCurrentUserController, ParseDefaultACLController, ParseFileController, LocalIdManager, 
//            NetworkObjectController, ParseObjectController, ParsePushChannelsController, ParsePushController, 
//            NetworkQueryController, OfflineQueryController, ParseQueryController, CacheQueryController, 
//            NetworkSessionController, ParseSessionController, NetworkUserController, ParseUserController

class ParseCorePlugins
{

    static final String FILENAME_CURRENT_CONFIG = "currentConfig";
    static final String FILENAME_CURRENT_INSTALLATION = "currentInstallation";
    static final String FILENAME_CURRENT_USER = "currentUser";
    private static final ParseCorePlugins INSTANCE = new ParseCorePlugins();
    static final String PIN_CURRENT_INSTALLATION = "_currentInstallation";
    static final String PIN_CURRENT_USER = "_currentUser";
    private AtomicReference analyticsController;
    private AtomicReference authenticationController;
    private AtomicReference cloudCodeController;
    private AtomicReference configController;
    private AtomicReference currentInstallationController;
    private AtomicReference currentUserController;
    private AtomicReference defaultACLController;
    private AtomicReference fileController;
    private AtomicReference localIdManager;
    private AtomicReference objectController;
    private AtomicReference pushChannelsController;
    private AtomicReference pushController;
    private AtomicReference queryController;
    private AtomicReference sessionController;
    private AtomicReference userController;

    private ParseCorePlugins()
    {
        objectController = new AtomicReference();
        userController = new AtomicReference();
        sessionController = new AtomicReference();
        currentUserController = new AtomicReference();
        currentInstallationController = new AtomicReference();
        authenticationController = new AtomicReference();
        queryController = new AtomicReference();
        fileController = new AtomicReference();
        analyticsController = new AtomicReference();
        cloudCodeController = new AtomicReference();
        configController = new AtomicReference();
        pushController = new AtomicReference();
        pushChannelsController = new AtomicReference();
        defaultACLController = new AtomicReference();
        localIdManager = new AtomicReference();
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

    public ParseAuthenticationManager getAuthenticationManager()
    {
        if (authenticationController.get() == null)
        {
            ParseAuthenticationManager parseauthenticationmanager = new ParseAuthenticationManager(getCurrentUserController());
            authenticationController.compareAndSet(null, parseauthenticationmanager);
        }
        return (ParseAuthenticationManager)authenticationController.get();
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
            ParseCurrentConfigController parsecurrentconfigcontroller = new ParseCurrentConfigController(new File(ParsePlugins.get().getParseDir(), "currentConfig"));
            configController.compareAndSet(null, new ParseConfigController(ParsePlugins.get().restClient(), parsecurrentconfigcontroller));
        }
        return (ParseConfigController)configController.get();
    }

    public ParseCurrentInstallationController getCurrentInstallationController()
    {
        if (currentInstallationController.get() == null)
        {
            Object obj = new FileObjectStore(com/parse/ParseInstallation, new File(ParsePlugins.get().getParseDir(), "currentInstallation"), ParseObjectCurrentCoder.get());
            if (Parse.isLocalDatastoreEnabled())
            {
                obj = new OfflineObjectStore(com/parse/ParseInstallation, "_currentInstallation", ((ParseObjectStore) (obj)));
            }
            obj = new CachedCurrentInstallationController(((ParseObjectStore) (obj)), ParsePlugins.get().installationId());
            currentInstallationController.compareAndSet(null, obj);
        }
        return (ParseCurrentInstallationController)currentInstallationController.get();
    }

    public ParseCurrentUserController getCurrentUserController()
    {
        if (currentUserController.get() == null)
        {
            Object obj = new FileObjectStore(com/parse/ParseUser, new File(Parse.getParseDir(), "currentUser"), ParseUserCurrentCoder.get());
            if (Parse.isLocalDatastoreEnabled())
            {
                obj = new OfflineObjectStore(com/parse/ParseUser, "_currentUser", ((ParseObjectStore) (obj)));
            }
            obj = new CachedCurrentUserController(((ParseObjectStore) (obj)));
            currentUserController.compareAndSet(null, obj);
        }
        return (ParseCurrentUserController)currentUserController.get();
    }

    public ParseDefaultACLController getDefaultACLController()
    {
        if (defaultACLController.get() == null)
        {
            ParseDefaultACLController parsedefaultaclcontroller = new ParseDefaultACLController();
            defaultACLController.compareAndSet(null, parsedefaultaclcontroller);
        }
        return (ParseDefaultACLController)defaultACLController.get();
    }

    public ParseFileController getFileController()
    {
        if (fileController.get() == null)
        {
            fileController.compareAndSet(null, new ParseFileController(ParsePlugins.get().restClient(), Parse.getParseCacheDir("files")));
        }
        return (ParseFileController)fileController.get();
    }

    public LocalIdManager getLocalIdManager()
    {
        if (localIdManager.get() == null)
        {
            LocalIdManager localidmanager = new LocalIdManager(Parse.getParseDir());
            localIdManager.compareAndSet(null, localidmanager);
        }
        return (LocalIdManager)localIdManager.get();
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

    public ParseSessionController getSessionController()
    {
        if (sessionController.get() == null)
        {
            sessionController.compareAndSet(null, new NetworkSessionController(ParsePlugins.get().restClient()));
        }
        return (ParseSessionController)sessionController.get();
    }

    public ParseUserController getUserController()
    {
        if (userController.get() == null)
        {
            userController.compareAndSet(null, new NetworkUserController(ParsePlugins.get().restClient()));
        }
        return (ParseUserController)userController.get();
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

    public void registerAuthenticationManager(ParseAuthenticationManager parseauthenticationmanager)
    {
        if (!authenticationController.compareAndSet(null, parseauthenticationmanager))
        {
            throw new IllegalStateException((new StringBuilder()).append("Another authentication manager was already registered: ").append(authenticationController.get()).toString());
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

    public void registerCurrentInstallationController(ParseCurrentInstallationController parsecurrentinstallationcontroller)
    {
        if (!currentInstallationController.compareAndSet(null, parsecurrentinstallationcontroller))
        {
            throw new IllegalStateException((new StringBuilder()).append("Another currentInstallation controller was already registered: ").append(currentInstallationController.get()).toString());
        } else
        {
            return;
        }
    }

    public void registerCurrentUserController(ParseCurrentUserController parsecurrentusercontroller)
    {
        if (!currentUserController.compareAndSet(null, parsecurrentusercontroller))
        {
            throw new IllegalStateException((new StringBuilder()).append("Another currentUser controller was already registered: ").append(currentUserController.get()).toString());
        } else
        {
            return;
        }
    }

    public void registerDefaultACLController(ParseDefaultACLController parsedefaultaclcontroller)
    {
        if (!defaultACLController.compareAndSet(null, parsedefaultaclcontroller))
        {
            throw new IllegalStateException((new StringBuilder()).append("Another defaultACL controller was already registered: ").append(defaultACLController.get()).toString());
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

    public void registerLocalIdManager(LocalIdManager localidmanager)
    {
        if (!localIdManager.compareAndSet(null, localidmanager))
        {
            throw new IllegalStateException((new StringBuilder()).append("Another localId manager was already registered: ").append(localIdManager.get()).toString());
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

    public void registerSessionController(ParseSessionController parsesessioncontroller)
    {
        if (!sessionController.compareAndSet(null, parsesessioncontroller))
        {
            throw new IllegalStateException((new StringBuilder()).append("Another session controller was already registered: ").append(sessionController.get()).toString());
        } else
        {
            return;
        }
    }

    public void registerUserController(ParseUserController parseusercontroller)
    {
        if (!userController.compareAndSet(null, parseusercontroller))
        {
            throw new IllegalStateException((new StringBuilder()).append("Another user controller was already registered: ").append(userController.get()).toString());
        } else
        {
            return;
        }
    }

    void reset()
    {
        objectController.set(null);
        userController.set(null);
        sessionController.set(null);
        currentUserController.set(null);
        currentInstallationController.set(null);
        authenticationController.set(null);
        queryController.set(null);
        fileController.set(null);
        analyticsController.set(null);
        cloudCodeController.set(null);
        configController.set(null);
        pushController.set(null);
        pushChannelsController.set(null);
        defaultACLController.set(null);
        localIdManager.set(null);
    }

}
