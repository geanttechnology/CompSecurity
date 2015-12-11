// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;

import android.content.Context;
import java.util.Random;

// Referenced classes of package net.singular.sdk:
//            SingularLog, ManifestHelper, TimeHelper, AdvertisingIdHelper, 
//            FacebookAttributionIdGetter, EventReporter, SingularSQLiteHelper, PostableWorker, 
//            CountersLogger, LogsKeeper, EventStore, Controller, 
//            SessionManager, Collector, KeyValueStore

class NewInjector
{

    private AdvertisingIdHelper advertisingIdHelper;
    private Collector collector;
    private Context context;
    private Controller controller;
    private CountersLogger countersLogger;
    private EventReporter eventReporter;
    private EventStore eventStore;
    private FacebookAttributionIdGetter facebookAttributionGetter;
    private LogsKeeper logsKeeper;
    private final ManifestHelper manifestHelper;
    private PostableWorker networkPostable;
    private Random random;
    private PostableWorker saverPostable;
    private SessionManager sessionManager;
    private SingularLog singularLog;
    private SingularSQLiteHelper singularSQLiteHelper;
    private TimeHelper timeHelper;

    public NewInjector(Context context1, boolean flag)
    {
        context = context1.getApplicationContext();
        singularLog = new SingularLog();
        manifestHelper = new ManifestHelper(context1, singularLog);
        singularLog.initialize(manifestHelper);
        timeHelper = new TimeHelper();
        random = new Random();
        advertisingIdHelper = new AdvertisingIdHelper(context1);
        facebookAttributionGetter = new FacebookAttributionIdGetter(context1, singularLog);
        eventReporter = new EventReporter(singularLog, timeHelper);
        singularSQLiteHelper = new SingularSQLiteHelper(context1, singularLog);
        saverPostable = new PostableWorker("saverThread", singularLog);
        networkPostable = new PostableWorker("networkPostable", singularLog);
        countersLogger = new CountersLogger(saverPostable, this);
        singularLog.setCountersLogger(countersLogger);
        logsKeeper = new LogsKeeper(300);
        singularLog.setLogsKeeper(logsKeeper);
        eventStore = new EventStore(singularLog, singularSQLiteHelper, manifestHelper, countersLogger);
        controller = new Controller(eventStore, eventReporter, timeHelper, networkPostable, saverPostable, countersLogger, random, logsKeeper, singularLog);
        sessionManager = new SessionManager(singularLog, controller, timeHelper, saverPostable, countersLogger, this);
        collector = new Collector(singularLog, context1, advertisingIdHelper, sessionManager, countersLogger, manifestHelper, facebookAttributionGetter, this, flag);
        controller.initController(sessionManager, collector);
        singularLog.setController(controller);
    }

    public KeyValueStore generateKeyValueStore(String s)
    {
        return new KeyValueStore(singularLog, singularSQLiteHelper, s);
    }

    public PostableWorker generatePostableWorker(String s)
    {
        return new PostableWorker(s, singularLog);
    }

    public Controller getController()
    {
        return controller;
    }

    public SingularLog getSingularLog()
    {
        return singularLog;
    }
}
