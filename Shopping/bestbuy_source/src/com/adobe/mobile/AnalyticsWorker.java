// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Process;
import java.io.File;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.adobe.mobile:
//            AbstractHitDatabase, StaticMethods, MobileConfig, ReferrerHandler, 
//            MobilePrivacyStatus, RequestHandler

final class AnalyticsWorker extends AbstractHitDatabase
{

    protected static final String ANALYTICS_DB_CREATE_STATEMENT = "CREATE TABLE IF NOT EXISTS HITS (ID INTEGER PRIMARY KEY AUTOINCREMENT, URL TEXT, TIMESTAMP INTEGER)";
    protected static final String ANALYTICS_FILENAME = "ADBMobileDataCache.sqlite";
    private static final int CONNECTION_TIMEOUT_MSEC = 5000;
    private static final int TIMESTAMP_DISABLED_WAIT_THRESHOLD = 60;
    private static AnalyticsWorker _instance = null;
    private static final Object _instanceMutex = new Object();
    private static volatile boolean analyticsGetBaseURL_pred = true;
    private static String baseURL;
    private static final SecureRandom randomGen = new SecureRandom();
    protected SQLiteStatement _preparedInsertStatement;

    protected AnalyticsWorker()
    {
        _preparedInsertStatement = null;
        fileName = "ADBMobileDataCache.sqlite";
        logPrefix = "Analytics";
        dbCreateStatement = "CREATE TABLE IF NOT EXISTS HITS (ID INTEGER PRIMARY KEY AUTOINCREMENT, URL TEXT, TIMESTAMP INTEGER)";
        lastHitTimestamp = 0L;
        initDatabaseBacking(new File(StaticMethods.getCacheDirectory(), fileName));
        numberOfUnsentHits = getTrackingQueueSize();
    }

    private static String getBaseURL()
    {
        if (analyticsGetBaseURL_pred)
        {
            analyticsGetBaseURL_pred = false;
            StringBuilder stringbuilder = new StringBuilder();
            String s;
            if (MobileConfig.getInstance().getSSL())
            {
                s = "https://";
            } else
            {
                s = "http://";
            }
            baseURL = stringbuilder.append(s).append(MobileConfig.getInstance().getTrackingServer()).append("/b/ss/").append(StaticMethods.URLEncode(MobileConfig.getInstance().getReportSuiteIds())).append("/0/JAVA-").append("4.6.1-AN").append("/s").toString();
            StaticMethods.logDebugFormat("Analytics - Setting base request URL(%s)", new Object[] {
                baseURL
            });
        }
        return baseURL;
    }

    public static AnalyticsWorker sharedInstance()
    {
        AnalyticsWorker analyticsworker;
        synchronized (_instanceMutex)
        {
            if (_instance == null)
            {
                _instance = new AnalyticsWorker();
            }
            analyticsworker = _instance;
        }
        return analyticsworker;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void kickWithReferrerData(Map map)
    {
        if (map == null || map.size() <= 0)
        {
            ReferrerHandler.setReferrerProcessed(true);
            kick(false);
            return;
        }
        AbstractHitDatabase.Hit hit = selectOldestHit();
        if (hit != null && hit.urlFragment != null)
        {
            hit.urlFragment = StaticMethods.appendContextData(map, hit.urlFragment);
            updateHitInDatabase(hit);
            ReferrerHandler.setReferrerProcessed(true);
        }
        kick(false);
    }

    protected void preMigrate()
    {
        File file;
        File file1;
        file = new File((new StringBuilder()).append(StaticMethods.getCacheDirectory()).append(fileName).toString());
        file1 = new File(StaticMethods.getCacheDirectory(), fileName);
        if (!file.exists() || file1.exists())
        {
            break MISSING_BLOCK_LABEL_77;
        }
        if (!file.renameTo(file1))
        {
            StaticMethods.logWarningFormat("Analytics - Unable to migrate old hits db, creating new hits db (move file returned false)", new Object[0]);
        }
        return;
        Exception exception;
        exception;
        StaticMethods.logWarningFormat("Analytics - Unable to migrate old hits db, creating new hits db (%s)", new Object[] {
            exception.getLocalizedMessage()
        });
        return;
    }

    protected void prepareStatements()
    {
        try
        {
            _preparedInsertStatement = database.compileStatement("INSERT INTO HITS (URL, TIMESTAMP) VALUES (?, ?)");
            return;
        }
        catch (NullPointerException nullpointerexception)
        {
            StaticMethods.logErrorFormat("Analytics - Unable to create database due to an invalid path (%s)", new Object[] {
                nullpointerexception.getLocalizedMessage()
            });
            return;
        }
        catch (SQLException sqlexception)
        {
            StaticMethods.logErrorFormat("Analytics - Unable to create database due to a sql error (%s)", new Object[] {
                sqlexception.getLocalizedMessage()
            });
            return;
        }
        catch (Exception exception)
        {
            StaticMethods.logErrorFormat("Analytics - Unable to create database due to an unexpected error (%s)", new Object[] {
                exception.getLocalizedMessage()
            });
        }
    }

    protected void queue(String s, long l)
    {
        MobileConfig mobileconfig = MobileConfig.getInstance();
        if (mobileconfig == null)
        {
            StaticMethods.logErrorFormat("Analytics - Cannot send hit, MobileConfig is null (this really shouldn't happen)", new Object[0]);
            return;
        }
        if (mobileconfig.getPrivacyStatus() == MobilePrivacyStatus.MOBILE_PRIVACY_STATUS_OPT_OUT)
        {
            StaticMethods.logDebugFormat("Analytics - Ignoring hit due to privacy status being opted out", new Object[0]);
            return;
        }
        Object obj = dbMutex;
        obj;
        JVM INSTR monitorenter ;
        _preparedInsertStatement.bindString(1, s);
        _preparedInsertStatement.bindLong(2, l);
        _preparedInsertStatement.execute();
        StaticMethods.updateLastKnownTimestamp(Long.valueOf(l));
        numberOfUnsentHits = numberOfUnsentHits + 1L;
        _preparedInsertStatement.clearBindings();
_L1:
        kick(false);
        return;
        Object obj1;
        obj1;
        StaticMethods.logErrorFormat("Analytics - Unable to insert url (%s)", new Object[] {
            s
        });
        resetDatabase(((Exception) (obj1)));
          goto _L1
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        obj1;
        StaticMethods.logErrorFormat("Analytics - Unknown error while inserting url (%s)", new Object[] {
            s
        });
        resetDatabase(((Exception) (obj1)));
          goto _L1
    }

    protected AbstractHitDatabase.Hit selectOldestHit()
    {
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        obj3 = null;
        obj1 = null;
        obj2 = null;
        obj4 = null;
        Object obj5 = dbMutex;
        obj5;
        JVM INSTR monitorenter ;
        Object obj = database.query("HITS", new String[] {
            "ID", "URL", "TIMESTAMP"
        }, null, null, null, null, "ID ASC", "1");
        obj2 = obj4;
        obj1 = obj;
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_125;
        }
        obj1 = obj;
        obj2 = new AbstractHitDatabase.Hit();
        obj1 = obj;
        obj2.identifier = ((Cursor) (obj)).getString(0);
        obj1 = obj;
        obj2.urlFragment = ((Cursor) (obj)).getString(1);
        obj1 = obj;
        obj2.timestamp = ((Cursor) (obj)).getLong(2);
        obj1 = obj2;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        ((Cursor) (obj)).close();
        obj1 = obj2;
_L2:
        obj5;
        JVM INSTR monitorexit ;
        return ((AbstractHitDatabase.Hit) (obj1));
        obj2;
        obj = null;
_L7:
        obj1 = obj;
        StaticMethods.logErrorFormat("Analytics - Unable to read from database (%s)", new Object[] {
            ((SQLException) (obj2)).getMessage()
        });
        obj1 = obj3;
        if (obj == null) goto _L2; else goto _L1
_L1:
        ((Cursor) (obj)).close();
        obj1 = obj3;
          goto _L2
        obj;
        obj5;
        JVM INSTR monitorexit ;
        throw obj;
        Exception exception;
        exception;
        obj = null;
_L6:
        obj2 = obj1;
        StaticMethods.logErrorFormat("Analytics - Unknown error reading from database (%s)", new Object[] {
            exception.getMessage()
        });
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj1)).close();
        obj1 = obj;
          goto _L2
_L5:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_240;
        }
        ((Cursor) (obj1)).close();
        throw obj;
        obj;
          goto _L5
        exception;
        obj2 = null;
        obj1 = obj;
        obj = obj2;
          goto _L6
        exception;
        obj1 = obj;
        obj = obj2;
          goto _L6
        obj2;
          goto _L7
        obj1;
        exception = ((Exception) (obj2));
        obj2 = obj1;
          goto _L7
_L4:
        obj1 = obj;
          goto _L2
        obj;
        obj1 = obj2;
          goto _L5
    }

    protected void updateHitInDatabase(AbstractHitDatabase.Hit hit)
    {
        Object obj = dbMutex;
        obj;
        JVM INSTR monitorenter ;
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("URL", hit.urlFragment);
        database.update("HITS", contentvalues, (new StringBuilder()).append("id=").append(hit.identifier).toString(), null);
_L1:
        return;
        hit;
        StaticMethods.logErrorFormat("Analytics - Unable to update url in database (%s)", new Object[] {
            hit.getMessage()
        });
          goto _L1
        hit;
        obj;
        JVM INSTR monitorexit ;
        throw hit;
        hit;
        StaticMethods.logErrorFormat("Analytics - Unknown error updating url in database (%s)", new Object[] {
            hit.getMessage()
        });
          goto _L1
    }

    protected final Runnable workerThread()
    {
        return new Runnable() {

            final AnalyticsWorker this$0;

            public void run()
            {
                AnalyticsWorker analyticsworker;
                HashMap hashmap;
                analyticsworker = AnalyticsWorker.sharedInstance();
                Process.setThreadPriority(10);
                hashmap = new HashMap();
                hashmap.put("Accept-Language", StaticMethods.getDefaultAcceptLanguage());
                hashmap.put("User-Agent", StaticMethods.getDefaultUserAgent());
_L9:
                if (MobileConfig.getInstance().getPrivacyStatus() != MobilePrivacyStatus.MOBILE_PRIVACY_STATUS_OPT_IN || !MobileConfig.getInstance().networkConnectivity()) goto _L2; else goto _L1
_L1:
                AbstractHitDatabase.Hit hit = analyticsworker.selectOldestHit();
                if (hit != null) goto _L3; else goto _L2
_L2:
                analyticsworker.bgThreadActive = false;
                return;
_L3:
                Object obj;
                if (MobileConfig.getInstance().getOfflineTrackingEnabled())
                {
                    if (hit.timestamp - analyticsworker.lastHitTimestamp < 0L)
                    {
                        long l = analyticsworker.lastHitTimestamp + 1L;
                        String s = (new StringBuilder()).append("&ts=").append(Long.toString(hit.timestamp)).toString();
                        String s1 = (new StringBuilder()).append("&ts=").append(Long.toString(l)).toString();
                        hit.urlFragment = hit.urlFragment.replaceFirst(s, s1);
                        StaticMethods.logDebugFormat("Analytics - Adjusting out of order hit timestamp(%d->%d)", new Object[] {
                            Long.valueOf(hit.timestamp), Long.valueOf(l)
                        });
                        hit.timestamp = l;
                    }
                } else
                if (hit.timestamp < StaticMethods.getTimeSince1970() - 60L)
                {
                    try
                    {
                        analyticsworker.deleteHit(hit.identifier);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        AnalyticsWorker.sharedInstance().resetDatabase(((Exception) (obj)));
                        continue; /* Loop/switch isn't completed */
                    }
                    continue; /* Loop/switch isn't completed */
                }
                if (hit.urlFragment.startsWith("ndh"))
                {
                    obj = hit.urlFragment;
                } else
                {
                    obj = hit.urlFragment.substring(hit.urlFragment.indexOf('?') + 1);
                }
                if (RequestHandler.sendAnalyticsRequest((new StringBuilder()).append(AnalyticsWorker.getBaseURL()).append(AnalyticsWorker.randomGen.nextInt(0x5f5e100)).toString(), ((String) (obj)), hashmap, 5000, logPrefix))
                {
                    try
                    {
                        analyticsworker.deleteHit(hit.identifier);
                    }
                    catch (AbstractDatabaseBacking.CorruptedDatabaseException corrupteddatabaseexception)
                    {
                        AnalyticsWorker.sharedInstance().resetDatabase(corrupteddatabaseexception);
                        continue; /* Loop/switch isn't completed */
                    }
                    analyticsworker.lastHitTimestamp = hit.timestamp;
                    continue; /* Loop/switch isn't completed */
                }
                StaticMethods.logWarningFormat("Analytics - Unable to send hit", new Object[0]);
                if (!MobileConfig.getInstance().getOfflineTrackingEnabled()) goto _L5; else goto _L4
_L4:
                int i;
                StaticMethods.logDebugFormat("Analytics - Network error, imposing internal cooldown(%d seconds)", new Object[] {
                    Long.valueOf(30L)
                });
                i = 0;
_L6:
                if ((long)i >= 30L)
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (!MobileConfig.getInstance().networkConnectivity())
                {
                    continue; /* Loop/switch isn't completed */
                }
                Thread.sleep(1000L);
                i++;
                if (true) goto _L6; else goto _L5
_L5:
                try
                {
                    analyticsworker.deleteHit(hit.identifier);
                    continue; /* Loop/switch isn't completed */
                }
                catch (AbstractDatabaseBacking.CorruptedDatabaseException corrupteddatabaseexception1)
                {
                    AnalyticsWorker.sharedInstance().resetDatabase(corrupteddatabaseexception1);
                }
                if (true) goto _L2; else goto _L7
_L7:
                Exception exception;
                exception;
                StaticMethods.logWarningFormat("Analytics - Background Thread Interrupted(%s)", new Object[] {
                    exception.getMessage()
                });
                if (true) goto _L9; else goto _L8
_L8:
            }

            
            {
                this$0 = AnalyticsWorker.this;
                super();
            }
        };
    }



}
