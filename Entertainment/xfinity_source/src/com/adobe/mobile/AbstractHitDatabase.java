// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.adobe.mobile:
//            AbstractDatabaseBacking, StaticMethods, MobileConfig, ReferrerHandler, 
//            MobilePrivacyStatus

abstract class AbstractHitDatabase extends AbstractDatabaseBacking
{
    protected static class Hit
    {

        String identifier;
        String postBody;
        String postType;
        int timeout;
        long timestamp;
        String urlFragment;

        protected Hit()
        {
        }
    }

    protected class ReferrerTimeoutTask extends TimerTask
    {

        private boolean kickFlag;
        final AbstractHitDatabase this$0;

        public void run()
        {
            ReferrerHandler.setReferrerProcessed(true);
            StaticMethods.logDebugFormat("%s - Referrer timeout has expired without referrer data", new Object[] {
                logPrefix
            });
            kick(kickFlag);
        }

        ReferrerTimeoutTask(boolean flag)
        {
            this$0 = AbstractHitDatabase.this;
            super();
            kickFlag = false;
            kickFlag = flag;
        }
    }


    protected final Object backgroundMutex = new Object();
    protected boolean bgThreadActive;
    protected String dbCreateStatement;
    protected long lastHitTimestamp;
    protected long numberOfUnsentHits;
    private TimerTask referrerTask;
    private Timer referrerTimer;
    private final Object referrerTimerMutex = new Object();

    AbstractHitDatabase()
    {
        bgThreadActive = false;
    }

    protected void bringOnline()
    {
        if (!bgThreadActive)
        {
            bgThreadActive = true;
            synchronized (backgroundMutex)
            {
                (new Thread(workerThread())).start();
            }
            return;
        } else
        {
            return;
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void clearTrackingQueue()
    {
        Object obj = dbMutex;
        obj;
        JVM INSTR monitorenter ;
        database.delete("HITS", null, null);
        numberOfUnsentHits = 0L;
_L1:
        return;
        Object obj1;
        obj1;
        StaticMethods.logErrorFormat("%s - Unable to clear tracking queue due to an unopened database (%s)", new Object[] {
            logPrefix, ((NullPointerException) (obj1)).getLocalizedMessage()
        });
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        StaticMethods.logErrorFormat("%s - Unable to clear tracking queue due to a sql error (%s)", new Object[] {
            logPrefix, ((SQLException) (obj1)).getLocalizedMessage()
        });
          goto _L1
        obj1;
        StaticMethods.logErrorFormat("%s - Unable to clear tracking queue due to an unexpected error (%s)", new Object[] {
            logPrefix, ((Exception) (obj1)).getLocalizedMessage()
        });
          goto _L1
    }

    protected void deleteHit(String s)
        throws AbstractDatabaseBacking.CorruptedDatabaseException
    {
        if (s == null || s.trim().length() == 0)
        {
            StaticMethods.logDebugFormat("%s - Unable to delete hit due to an invalid parameter", new Object[] {
                logPrefix
            });
            return;
        }
        Object obj = dbMutex;
        obj;
        JVM INSTR monitorenter ;
        database.delete("HITS", "ID = ?", new String[] {
            s
        });
        numberOfUnsentHits = numberOfUnsentHits - 1L;
_L1:
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        s;
        StaticMethods.logErrorFormat("%s - Unable to delete hit due to an unopened database (%s)", new Object[] {
            logPrefix, s.getLocalizedMessage()
        });
          goto _L1
        s;
        StaticMethods.logErrorFormat("%s - Unable to delete hit due to a sql error (%s)", new Object[] {
            logPrefix, s.getLocalizedMessage()
        });
        throw new AbstractDatabaseBacking.CorruptedDatabaseException((new StringBuilder()).append("Unable to delete, database probably corrupted (").append(s.getLocalizedMessage()).append(")").toString());
        s;
        StaticMethods.logErrorFormat("%s - Unable to delete hit due to an unexpected error (%s)", new Object[] {
            logPrefix, s.getLocalizedMessage()
        });
        throw new AbstractDatabaseBacking.CorruptedDatabaseException((new StringBuilder()).append("Unexpected exception, database probably corrupted (").append(s.getLocalizedMessage()).append(")").toString());
    }

    protected void forceKick()
    {
        kick(true);
    }

    protected long getTrackingQueueSize()
    {
        long l = 0L;
        Object obj = dbMutex;
        obj;
        JVM INSTR monitorenter ;
        long l1 = DatabaseUtils.queryNumEntries(database, "HITS");
        l = l1;
_L1:
        obj;
        JVM INSTR monitorexit ;
        return l;
        Object obj1;
        obj1;
        StaticMethods.logErrorFormat("%s - Unable to get tracking queue size due to an unopened database (%s)", new Object[] {
            logPrefix, ((NullPointerException) (obj1)).getLocalizedMessage()
        });
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        StaticMethods.logErrorFormat("%s - Unable to get tracking queue size due to a sql error (%s)", new Object[] {
            logPrefix, ((SQLException) (obj1)).getLocalizedMessage()
        });
          goto _L1
        obj1;
        StaticMethods.logErrorFormat("%s - Unable to get tracking queue size due to an unexpected error (%s)", new Object[] {
            logPrefix, ((Exception) (obj1)).getLocalizedMessage()
        });
          goto _L1
    }

    protected void initializeDatabase()
    {
        try
        {
            database.execSQL(dbCreateStatement);
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

    protected void kick(boolean flag)
    {
        Object obj1;
        boolean flag1;
        flag1 = false;
        obj1 = MobileConfig.getInstance();
        if (ReferrerHandler.getReferrerProcessed() || ((MobileConfig) (obj1)).getReferrerTimeout() <= 0)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        Object obj = referrerTimerMutex;
        obj;
        JVM INSTR monitorenter ;
        obj1 = referrerTask;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        referrerTask = new ReferrerTimeoutTask(flag);
        referrerTimer = new Timer();
        referrerTimer.schedule(referrerTask, MobileConfig.getInstance().getReferrerTimeout());
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        obj1;
        StaticMethods.logErrorFormat("%s - Error creating referrer timer (%s)", new Object[] {
            logPrefix, ((Exception) (obj1)).getMessage()
        });
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        if (referrerTimer == null) goto _L3; else goto _L2
_L2:
        obj = referrerTimerMutex;
        obj;
        JVM INSTR monitorenter ;
        referrerTimer.cancel();
_L4:
        referrerTask = null;
_L3:
        if (((MobileConfig) (obj1)).getPrivacyStatus() == MobilePrivacyStatus.MOBILE_PRIVACY_STATUS_OPT_IN)
        {
            if (!((MobileConfig) (obj1)).getOfflineTrackingEnabled() || numberOfUnsentHits > (long)((MobileConfig) (obj1)).getBatchLimit())
            {
                flag1 = true;
            }
            if (flag1 || flag)
            {
                bringOnline();
                return;
            }
        }
        break MISSING_BLOCK_LABEL_222;
        Exception exception1;
        exception1;
        StaticMethods.logErrorFormat("%s - Error cancelling referrer timer (%s)", new Object[] {
            logPrefix, exception1.getMessage()
        });
          goto _L4
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void postReset()
    {
        numberOfUnsentHits = 0L;
    }

    protected Hit selectOldestHit()
        throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException("getFirstHitInQueue must be overwritten");
    }

    protected Runnable workerThread()
        throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException("workerThread must be overwritten");
    }
}
