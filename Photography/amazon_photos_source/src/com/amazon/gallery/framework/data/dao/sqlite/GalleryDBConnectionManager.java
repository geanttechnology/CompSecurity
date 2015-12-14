// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.resource.AndroidResourceUtils;
import com.amazon.gallery.foundation.utils.resource.ResourceUtils;
import com.amazon.gallery.framework.data.account.AccountChangeListener;
import com.amazon.gallery.framework.data.dao.SortTypeDao;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool.BasePoolableObjectFactory;
import org.apache.commons.pool.PoolableObjectFactory;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            GalleryDBOpenHelper, ReadWriteSQLiteDatabase, ReadOnlySQLiteDatabase

public abstract class GalleryDBConnectionManager
    implements AccountChangeListener
{
    public static final class MetricEvent extends Enum
    {

        private static final MetricEvent $VALUES[];
        public static final MetricEvent DbConnectionFailure;
        public static final MetricEvent DbUpgradeTo55;
        public static final MetricEvent HiddenColumnMissingOnUpgrade;

        public static MetricEvent valueOf(String s)
        {
            return (MetricEvent)Enum.valueOf(com/amazon/gallery/framework/data/dao/sqlite/GalleryDBConnectionManager$MetricEvent, s);
        }

        public static MetricEvent[] values()
        {
            return (MetricEvent[])$VALUES.clone();
        }

        static 
        {
            DbConnectionFailure = new MetricEvent("DbConnectionFailure", 0);
            HiddenColumnMissingOnUpgrade = new MetricEvent("HiddenColumnMissingOnUpgrade", 1);
            DbUpgradeTo55 = new MetricEvent("DbUpgradeTo55", 2);
            $VALUES = (new MetricEvent[] {
                DbConnectionFailure, HiddenColumnMissingOnUpgrade, DbUpgradeTo55
            });
        }

        private MetricEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/GalleryDBConnectionManager.getName();
    private AuthenticationManager authenticationManager;
    protected final Context context;
    private String currentConnectionAccount;
    private MediaItemDao mediaItemDao;
    private ComponentProfiler profiler;
    private final PoolableObjectFactory readOnlyDatabaseFactory;
    private final ResourceUtils resourceUtils;
    private SortTypeDao sortDao;
    private TagDao tagDao;
    private ReadWriteSQLiteDatabase writableConn;

    public GalleryDBConnectionManager(Context context1)
    {
        this(context1, ((ResourceUtils) (new AndroidResourceUtils())));
    }

    public GalleryDBConnectionManager(Context context1, ResourceUtils resourceutils)
    {
        readOnlyDatabaseFactory = new BasePoolableObjectFactory() {

            final GalleryDBConnectionManager this$0;

            
            {
                this$0 = GalleryDBConnectionManager.this;
                super();
            }
        };
        context = context1;
        resourceUtils = resourceutils;
    }

    private void checkConnection()
    {
        this;
        JVM INSTR monitorenter ;
        if (writableConn == null)
        {
            writableConn = newWritableConnection();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private SQLiteDatabase newConnection()
    {
        Object obj;
        GalleryDBOpenHelper gallerydbopenhelper;
        int i;
        currentConnectionAccount = getAccountIdentifier();
        gallerydbopenhelper = new GalleryDBOpenHelper(context, resourceUtils, currentConnectionAccount);
        gallerydbopenhelper.setMediaItemDao(mediaItemDao);
        gallerydbopenhelper.setTagDao(tagDao);
        gallerydbopenhelper.setSortTypeDao(sortDao);
        gallerydbopenhelper.setAuthenticationManager(authenticationManager);
        gallerydbopenhelper.setProfiler(profiler);
        obj = null;
        i = 0;
_L2:
        Object obj1;
        obj1 = null;
        if (i >= 3)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        obj1 = gallerydbopenhelper.getWritableDatabase();
        if (obj1 == null)
        {
            onDbConnectFailure();
            throw obj;
        } else
        {
            return ((SQLiteDatabase) (obj1));
        }
        obj1;
        obj = obj1;
        GLogger.ex(TAG, "Can't instantiate database ", ((Throwable) (obj1)));
        profiler.trackEvent(MetricEvent.DbConnectionFailure);
        SystemClock.sleep(100L);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private ReadWriteSQLiteDatabase newWritableConnection()
    {
        SQLiteDatabase sqlitedatabase = newConnection();
        sqlitedatabase.execSQL("PRAGMA synchronous = NORMAL;");
        sqlitedatabase.execSQL("PRAGMA foreign_keys=ON;");
        return new ReadWriteSQLiteDatabase(sqlitedatabase);
    }

    private void onDbConnectFailure()
    {
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int j = sharedpreferences.getInt("db_failure_key", 0) + 1;
        int i = j;
        if (j >= 5)
        {
            boolean flag = context.deleteDatabase(GalleryDBOpenHelper.createDBName(currentConnectionAccount));
            GLogger.i(TAG, "Attempt to delete database, success: %b", new Object[] {
                Boolean.valueOf(flag)
            });
            i = 0;
        }
        sharedpreferences.edit().putInt("db_failure_key", i).commit();
    }

    private void onDbConnectSuccess()
    {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt("db_failure_key", 0).commit();
    }

    private void reset()
    {
        this;
        JVM INSTR monitorenter ;
        if (writableConn != null && !StringUtils.equals(getAccountIdentifier(), currentConnectionAccount))
        {
            GLogger.i(TAG, "Reset connection to database", new Object[0]);
            writableConn = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected abstract String getAccountIdentifier();

    public ReadOnlySQLiteDatabase getReadableConnection()
    {
        checkConnection();
        return writableConn;
    }

    public ReadWriteSQLiteDatabase getWritableConnection()
    {
        checkConnection();
        return writableConn;
    }

    public void init()
    {
        checkConnection();
        onDbConnectSuccess();
    }

    public void onAccountDeregistered()
    {
        reset();
    }

    public void onAccountRegistered()
    {
        reset();
    }

    public void release(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
    }

    public void release(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
    }

    public void setAuthenticationManager(AuthenticationManager authenticationmanager)
    {
        authenticationManager = authenticationmanager;
    }

    public void setMediaItemDao(MediaItemDao mediaitemdao)
    {
        mediaItemDao = mediaitemdao;
    }

    public void setProfiler(Profiler profiler1)
    {
        profiler = new ComponentProfiler(profiler1, com/amazon/gallery/framework/data/dao/sqlite/GalleryDBConnectionManager);
    }

    public void setSortTypeDao(SortTypeDao sorttypedao)
    {
        sortDao = sorttypedao;
    }

    public void setTagDao(TagDao tagdao)
    {
        tagDao = tagdao;
    }

}
