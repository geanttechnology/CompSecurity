// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Process;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.adobe.mobile:
//            AbstractHitDatabase, StaticMethods, MobileConfig, MobilePrivacyStatus, 
//            RequestHandler

final class ThirdPartyQueue extends AbstractHitDatabase
{

    protected static final String THIRDPARTY_DB_CREATE_STATEMENT = "CREATE TABLE IF NOT EXISTS HITS (ID INTEGER PRIMARY KEY AUTOINCREMENT, URL TEXT, POSTBODY TEXT, POSTTYPE TEXT, TIMESTAMP INTEGER, TIMEOUT INTEGER)";
    protected static final String THIRDPARTY_FILENAME = "ADBMobile3rdPartyDataCache.sqlite";
    protected static final String THIRDPARTY_LOG_PREFIX = "External Callback";
    private static final int THIRDPARTY_TIMEOUT_COOLDOWN_TIMER = 30;
    private static final int THIRDPARTY_TIMESTAMP_DISABLED_WAIT_THRESHOLD = 60;
    private static final String _hitsNumberOfRowsToReturn = "1";
    private static final String _hitsOrderBy = "ID ASC";
    private static final String _hitsSelectedColumns[] = {
        "ID", "URL", "POSTBODY", "POSTTYPE", "TIMESTAMP", "TIMEOUT"
    };
    private static final String _hitsTableName = "HITS";
    private static ThirdPartyQueue _instance = null;
    private static final Object _instanceMutex = new Object();
    private SQLiteStatement _preparedInsertStatement;

    private ThirdPartyQueue()
    {
        _preparedInsertStatement = null;
        fileName = "ADBMobile3rdPartyDataCache.sqlite";
        logPrefix = "External Callback";
        dbCreateStatement = "CREATE TABLE IF NOT EXISTS HITS (ID INTEGER PRIMARY KEY AUTOINCREMENT, URL TEXT, POSTBODY TEXT, POSTTYPE TEXT, TIMESTAMP INTEGER, TIMEOUT INTEGER)";
        lastHitTimestamp = 0L;
        initDatabaseBacking(new File(StaticMethods.getCacheDirectory(), fileName));
        numberOfUnsentHits = getTrackingQueueSize();
    }

    protected static ThirdPartyQueue sharedInstance()
    {
        ThirdPartyQueue thirdpartyqueue;
        synchronized (_instanceMutex)
        {
            if (_instance == null)
            {
                _instance = new ThirdPartyQueue();
            }
            thirdpartyqueue = _instance;
        }
        return thirdpartyqueue;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void prepareStatements()
    {
        try
        {
            _preparedInsertStatement = database.compileStatement("INSERT INTO HITS (URL, POSTBODY, POSTTYPE, TIMESTAMP, TIMEOUT) VALUES (?, ?, ?, ?, ?)");
            return;
        }
        catch (NullPointerException nullpointerexception)
        {
            StaticMethods.logErrorFormat("%s - Unable to create database due to an invalid path (%s)", new Object[] {
                logPrefix, nullpointerexception.getLocalizedMessage()
            });
            return;
        }
        catch (SQLException sqlexception)
        {
            StaticMethods.logErrorFormat("%s - Unable to create database due to a sql error (%s)", new Object[] {
                logPrefix, sqlexception.getLocalizedMessage()
            });
            return;
        }
        catch (Exception exception)
        {
            StaticMethods.logErrorFormat("%s - Unable to create database due to an unexpected error (%s)", new Object[] {
                logPrefix, exception.getLocalizedMessage()
            });
        }
    }

    protected void queue(String s, String s1, String s2, long l, long l1)
    {
        MobileConfig mobileconfig = MobileConfig.getInstance();
        if (mobileconfig == null)
        {
            StaticMethods.logErrorFormat("%s - Cannot send hit, MobileConfig is null (this really shouldn't happen)", new Object[] {
                logPrefix
            });
            return;
        }
        if (mobileconfig.getPrivacyStatus() == MobilePrivacyStatus.MOBILE_PRIVACY_STATUS_OPT_OUT)
        {
            StaticMethods.logDebugFormat("%s - Ignoring hit due to privacy status being opted out", new Object[] {
                logPrefix
            });
            return;
        }
        Object obj = dbMutex;
        obj;
        JVM INSTR monitorenter ;
        _preparedInsertStatement.bindString(1, s);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        if (s1.length() <= 0) goto _L2; else goto _L3
_L3:
        _preparedInsertStatement.bindString(2, s1);
_L7:
        if (s2 == null) goto _L5; else goto _L4
_L4:
        if (s2.length() <= 0) goto _L5; else goto _L6
_L6:
        _preparedInsertStatement.bindString(3, s2);
_L9:
        _preparedInsertStatement.bindLong(4, l);
        _preparedInsertStatement.bindLong(5, l1);
        _preparedInsertStatement.execute();
        numberOfUnsentHits = numberOfUnsentHits + 1L;
        _preparedInsertStatement.clearBindings();
_L8:
        obj;
        JVM INSTR monitorexit ;
        kick(false);
        return;
_L2:
        _preparedInsertStatement.bindNull(2);
          goto _L7
        s1;
        StaticMethods.logErrorFormat("%s - Unable to insert url (%s)", new Object[] {
            logPrefix, s
        });
        resetDatabase(s1);
          goto _L8
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
_L5:
        _preparedInsertStatement.bindNull(3);
          goto _L9
        s1;
        StaticMethods.logErrorFormat("%s - Unknown error while inserting url (%s)", new Object[] {
            logPrefix, s
        });
        resetDatabase(s1);
          goto _L8
    }

    protected AbstractHitDatabase.Hit selectOldestHit()
    {
        Object obj2;
        Object obj3;
        obj3 = null;
        obj2 = null;
        Object obj5 = dbMutex;
        obj5;
        JVM INSTR monitorenter ;
        Object obj = database.query("HITS", _hitsSelectedColumns, null, null, null, null, "ID ASC", "1");
        Object obj1 = obj;
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_134;
        }
        obj1 = obj;
        obj2 = new AbstractHitDatabase.Hit();
        obj1 = obj;
        obj2.identifier = ((Cursor) (obj)).getString(0);
        obj1 = obj;
        obj2.urlFragment = ((Cursor) (obj)).getString(1);
        obj1 = obj;
        obj2.postBody = ((Cursor) (obj)).getString(2);
        obj1 = obj;
        obj2.postType = ((Cursor) (obj)).getString(3);
        obj1 = obj;
        obj2.timestamp = ((Cursor) (obj)).getLong(4);
        obj1 = obj;
        obj2.timeout = ((Cursor) (obj)).getInt(5);
        obj1 = obj2;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_148;
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
        StaticMethods.logErrorFormat("%s - Unable to read from database (%s)", new Object[] {
            logPrefix, ((SQLException) (obj2)).getMessage()
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
        Object obj4;
        obj4 = null;
        obj = null;
_L6:
        obj1 = obj4;
        StaticMethods.logErrorFormat("%s - Unknown error reading from database (%s)", new Object[] {
            logPrefix, exception.getMessage()
        });
        if (obj4 == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj4)).close();
        obj1 = obj;
          goto _L2
_L5:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_269;
        }
        ((Cursor) (obj1)).close();
        throw obj;
        obj;
          goto _L5
        exception;
        obj1 = null;
        obj4 = obj;
        obj = obj1;
          goto _L6
        exception;
        obj4 = obj;
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
        obj1 = null;
          goto _L5
    }

    protected final Runnable workerThread()
    {
        return new Runnable() {

            final ThirdPartyQueue this$0;

            public void run()
            {
                ThirdPartyQueue thirdpartyqueue;
                HashMap hashmap;
                boolean flag;
                thirdpartyqueue = ThirdPartyQueue.sharedInstance();
                Process.setThreadPriority(10);
                flag = MobileConfig.getInstance().getOfflineTrackingEnabled();
                hashmap = new HashMap();
                hashmap.put("Accept-Language", StaticMethods.getDefaultAcceptLanguage());
                hashmap.put("User-Agent", StaticMethods.getDefaultUserAgent());
_L9:
                if (MobileConfig.getInstance().getPrivacyStatus() != MobilePrivacyStatus.MOBILE_PRIVACY_STATUS_OPT_IN || !MobileConfig.getInstance().networkConnectivity()) goto _L2; else goto _L1
_L1:
                AbstractHitDatabase.Hit hit = thirdpartyqueue.selectOldestHit();
                if (hit != null && hit.urlFragment != null) goto _L3; else goto _L2
_L2:
                thirdpartyqueue.bgThreadActive = false;
                return;
_L3:
                if (!flag && hit.timestamp < StaticMethods.getTimeSince1970() - 60L)
                {
                    try
                    {
                        thirdpartyqueue.deleteHit(hit.identifier);
                    }
                    catch (AbstractDatabaseBacking.CorruptedDatabaseException corrupteddatabaseexception)
                    {
                        thirdpartyqueue.resetDatabase(corrupteddatabaseexception);
                        continue; /* Loop/switch isn't completed */
                    }
                    continue; /* Loop/switch isn't completed */
                }
                String s;
                int i;
                if (hit.postBody != null)
                {
                    s = hit.postBody;
                } else
                {
                    s = "";
                }
                hit.postBody = s;
                if (hit.postType != null)
                {
                    s = hit.postType;
                } else
                {
                    s = "";
                }
                hit.postType = s;
                if (hit.timeout < 2)
                {
                    i = 2000;
                } else
                {
                    i = hit.timeout * 1000;
                }
                hit.timeout = i;
                if (RequestHandler.sendThirdPartyRequest(hit.urlFragment, hit.postBody, hashmap, hit.timeout, hit.postType, logPrefix))
                {
                    try
                    {
                        thirdpartyqueue.deleteHit(hit.identifier);
                    }
                    catch (AbstractDatabaseBacking.CorruptedDatabaseException corrupteddatabaseexception1)
                    {
                        thirdpartyqueue.resetDatabase(corrupteddatabaseexception1);
                        continue; /* Loop/switch isn't completed */
                    }
                    thirdpartyqueue.lastHitTimestamp = hit.timestamp;
                    continue; /* Loop/switch isn't completed */
                }
                StaticMethods.logWarningFormat("%s - Unable to forward hit (%s)", new Object[] {
                    logPrefix, hit.urlFragment
                });
                if (!MobileConfig.getInstance().getOfflineTrackingEnabled()) goto _L5; else goto _L4
_L4:
                int j;
                StaticMethods.logDebugFormat("%s - Network error, imposing internal cooldown (%d seconds)", new Object[] {
                    logPrefix, Long.valueOf(30L)
                });
                j = 0;
_L6:
                if ((long)j >= 30L)
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (!MobileConfig.getInstance().networkConnectivity())
                {
                    continue; /* Loop/switch isn't completed */
                }
                Thread.sleep(1000L);
                j++;
                if (true) goto _L6; else goto _L5
_L5:
                try
                {
                    thirdpartyqueue.deleteHit(hit.identifier);
                    continue; /* Loop/switch isn't completed */
                }
                catch (AbstractDatabaseBacking.CorruptedDatabaseException corrupteddatabaseexception2)
                {
                    thirdpartyqueue.resetDatabase(corrupteddatabaseexception2);
                }
                if (true) goto _L2; else goto _L7
_L7:
                Exception exception;
                exception;
                StaticMethods.logWarningFormat("%s - Background Thread Interrupted (%s)", new Object[] {
                    logPrefix, exception.getMessage()
                });
                if (true) goto _L9; else goto _L8
_L8:
            }

            
            {
                this$0 = ThirdPartyQueue.this;
                super();
            }
        };
    }

}
