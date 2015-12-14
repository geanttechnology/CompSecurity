// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteException;
import android.util.LruCache;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.account.AccountChangeListener;
import com.amazon.gallery.framework.data.dao.sqlite.DBReadExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.DBWriteExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.GalleryDBConnectionManager;
import com.amazon.gallery.framework.data.dao.sqlite.ReadOnlySQLiteDatabase;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;
import com.amazon.gallery.framework.data.dao.sqlite.SQLiteDaoUtil;
import com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DynamicAlbumDao extends LruCache
    implements AccountChangeListener
{
    public static final class CacheStatus extends Enum
    {

        private static final CacheStatus $VALUES[];
        public static final CacheStatus FILLING;
        public static final CacheStatus FULL;
        public static final CacheStatus NORMAL;

        public static CacheStatus valueOf(String s)
        {
            return (CacheStatus)Enum.valueOf(com/amazon/gallery/framework/data/dao/DynamicAlbumDao$CacheStatus, s);
        }

        public static CacheStatus[] values()
        {
            return (CacheStatus[])$VALUES.clone();
        }

        static 
        {
            NORMAL = new CacheStatus("NORMAL", 0);
            FILLING = new CacheStatus("FILLING", 1);
            FULL = new CacheStatus("FULL", 2);
            $VALUES = (new CacheStatus[] {
                NORMAL, FILLING, FULL
            });
        }

        private CacheStatus(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/framework/data/dao/DynamicAlbumDao.getName();
    private static ThreadLocal addDynamicAlbumSqLiteStatement;
    private static ThreadLocal addToDynamicAlbumSqLiteStatement;
    private static ThreadLocal deleteDynamicAlbumSqLiteStatement;
    private static ThreadLocal trimDynamicAlbumSqLiteStatement;
    private final GalleryDBConnectionManager connectionManager;
    private final Context context;

    public DynamicAlbumDao(GalleryDBConnectionManager gallerydbconnectionmanager, Context context1)
    {
        super(50);
        connectionManager = gallerydbconnectionmanager;
        context = context1;
        setupPreparedStatements();
    }

    private void insertDynamicAlbum(final List mediaItems, final long tagId, final boolean notifyChange)
    {
        (new DBWriteExecutor() {

            final DynamicAlbumDao this$0;
            final List val$mediaItems;
            final boolean val$notifyChange;
            final long val$tagId;

            public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                return execute(readwritesqlitedatabase);
            }

            public Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                try
                {
                    readwritesqlitedatabase = (com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement)DynamicAlbumDao.addDynamicAlbumSqLiteStatement.get();
                    long l = System.currentTimeMillis();
                    for (Iterator iterator = mediaItems.iterator(); iterator.hasNext(); readwritesqlitedatabase.executeInsert())
                    {
                        readwritesqlitedatabase.bindLong(1, ((Long)iterator.next()).longValue());
                        readwritesqlitedatabase.bindLong(2, tagId);
                        readwritesqlitedatabase.bindLong(3, l);
                    }

                }
                // Misplaced declaration of an exception variable
                catch (ReadWriteSQLiteDatabase readwritesqlitedatabase)
                {
                    GLogger.e(DynamicAlbumDao.TAG, "Error inserting dynamic album", new Object[] {
                        readwritesqlitedatabase
                    });
                }
                return null;
            }

            protected void postTransaction()
            {
                if (notifyChange)
                {
                    notifyContentResolversOfChange(tagId);
                }
            }

            
            {
                this$0 = DynamicAlbumDao.this;
                mediaItems = list;
                tagId = l;
                notifyChange = flag;
                super();
            }
        }).execute(connectionManager);
    }

    private void notifyContentResolversOfChange(long l)
    {
        SharedPreferences sharedpreferences = context.getSharedPreferences("galleryKindleSharedPrefs", 0);
        boolean flag = sharedpreferences.getBoolean("partialSyncStatus", false);
        boolean flag1 = sharedpreferences.getBoolean("coldBootStatus", false);
        if (!flag || flag1)
        {
            android.net.Uri uri = GalleryInternalContentProvider.createDynamicAlbumMediaUri(l);
            context.getContentResolver().notifyChange(uri, null);
        }
    }

    private List partitionIdsForSQLiteMax(List list)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < list.size(); i += 999)
        {
            arraylist.add(new ArrayList(list.subList(i, Math.min(list.size(), i + 999))));
        }

        return arraylist;
    }

    private Map reconstructCacheFromDb()
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        List list = getDynamicAlbumTagIds();
        for (int i = 0; i < 50 && i < list.size(); i++)
        {
            linkedhashmap.put((Long)list.get(i), CacheStatus.NORMAL);
        }

        return linkedhashmap;
    }

    private void setupPreparedStatements()
    {
        addDynamicAlbumSqLiteStatement = new ThreadLocal() {

            final DynamicAlbumDao this$0;

            protected com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement initialValue()
            {
                String s = SQLiteDaoUtil.replaceClause("dynamic_album_membership", new String[] {
                    "media_item_id", "tag_id", "cache_time"
                });
                return connectionManager.getWritableConnection().compileStatement(s);
            }

            protected volatile Object initialValue()
            {
                return initialValue();
            }

            
            {
                this$0 = DynamicAlbumDao.this;
                super();
            }
        };
        addToDynamicAlbumSqLiteStatement = new ThreadLocal() {

            final DynamicAlbumDao this$0;

            protected com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement initialValue()
            {
                String s = SQLiteDaoUtil.replaceClause("dynamic_album_membership", new String[] {
                    "media_item_id", "tag_id", "cache_time"
                });
                return connectionManager.getWritableConnection().compileStatement(s);
            }

            protected volatile Object initialValue()
            {
                return initialValue();
            }

            
            {
                this$0 = DynamicAlbumDao.this;
                super();
            }
        };
        deleteDynamicAlbumSqLiteStatement = new ThreadLocal() {

            final DynamicAlbumDao this$0;

            protected com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement initialValue()
            {
                String s = SQLiteDaoUtil.deleteClause("dynamic_album_membership", "tag_id=?");
                return connectionManager.getWritableConnection().compileStatement(s);
            }

            protected volatile Object initialValue()
            {
                return initialValue();
            }

            
            {
                this$0 = DynamicAlbumDao.this;
                super();
            }
        };
        trimDynamicAlbumSqLiteStatement = new ThreadLocal() {

            final DynamicAlbumDao this$0;

            protected com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement initialValue()
            {
                String s = SQLiteDaoUtil.deleteClause("dynamic_album_membership", "tag_id=? AND media_item_id NOT IN (SELECT media_item_id FROM dynamic_album_membership WHERE tag_id=? ORDER BY ROWID DESC LIMIT 1000)");
                return connectionManager.getWritableConnection().compileStatement(s);
            }

            protected volatile Object initialValue()
            {
                return initialValue();
            }

            
            {
                this$0 = DynamicAlbumDao.this;
                super();
            }
        };
    }

    private void trimCache(long l)
    {
        Map map = snapshot();
        Iterator iterator = map.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            long l1 = ((Long)iterator.next()).longValue();
            if (l1 != l && map.get(Long.valueOf(l1)) == CacheStatus.FULL)
            {
                trimTagCache(l1);
            }
        } while (true);
    }

    private void trimTagCache(final long id)
    {
        (new DBWriteExecutor() {

            final DynamicAlbumDao this$0;
            final long val$id;

            public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                return execute(readwritesqlitedatabase);
            }

            public Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                readwritesqlitedatabase = (com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement)DynamicAlbumDao.trimDynamicAlbumSqLiteStatement.get();
                readwritesqlitedatabase.bindLong(1, id);
                readwritesqlitedatabase.bindLong(2, id);
                readwritesqlitedatabase.executeUpdateDelete();
                return null;
            }

            
            {
                this$0 = DynamicAlbumDao.this;
                id = l;
                super();
            }
        }).execute(connectionManager);
        put(Long.valueOf(id), CacheStatus.NORMAL);
    }

    public void addToDynamicAlbum(final long tagId, final List mediaItemIds)
    {
        if (!contains(tagId))
        {
            GLogger.d(TAG, "Skipping addToDynamicAlbum insertion because album is not in cache", new Object[0]);
            return;
        } else
        {
            (new DBWriteExecutor() {

                final DynamicAlbumDao this$0;
                final List val$mediaItemIds;
                final long val$tagId;

                public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
                {
                    return execute(readwritesqlitedatabase);
                }

                public Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
                {
                    readwritesqlitedatabase = (com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement)DynamicAlbumDao.addToDynamicAlbumSqLiteStatement.get();
                    long l = System.currentTimeMillis();
                    for (Iterator iterator = mediaItemIds.iterator(); iterator.hasNext(); readwritesqlitedatabase.executeInsert())
                    {
                        readwritesqlitedatabase.bindLong(1, ((Long)iterator.next()).longValue());
                        readwritesqlitedatabase.bindLong(2, tagId);
                        readwritesqlitedatabase.bindLong(3, l);
                    }

                    return null;
                }

                protected void postTransaction()
                {
                    notifyContentResolversOfChange(tagId);
                }

            
            {
                this$0 = DynamicAlbumDao.this;
                mediaItemIds = list;
                tagId = l;
                super();
            }
            }).execute(connectionManager);
            return;
        }
    }

    public boolean contains(long l)
    {
        return get(Long.valueOf(l)) != null;
    }

    public void deleteDynamicAlbum(final long tagId)
    {
        (new DBWriteExecutor() {

            final DynamicAlbumDao this$0;
            final long val$tagId;

            public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                return execute(readwritesqlitedatabase);
            }

            public Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                readwritesqlitedatabase = (com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement)DynamicAlbumDao.deleteDynamicAlbumSqLiteStatement.get();
                readwritesqlitedatabase.bindLong(1, tagId);
                readwritesqlitedatabase.executeUpdateDelete();
                return null;
            }

            
            {
                this$0 = DynamicAlbumDao.this;
                tagId = l;
                super();
            }
        }).execute(connectionManager);
    }

    public void deleteFromDynamicAlbum(final long tagId, final List mediaItemIds)
    {
        if (!contains(tagId))
        {
            GLogger.d(TAG, "Skipping deleteFromDynamicAlbum insertion because album is not in cache", new Object[0]);
            return;
        } else
        {
            (new DBWriteExecutor() {

                final DynamicAlbumDao this$0;
                final List val$mediaItemIds;
                final long val$tagId;

                public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
                {
                    return execute(readwritesqlitedatabase);
                }

                public Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
                {
                    Object obj = new ArrayList(mediaItemIds.size());
                    for (int i = 0; i < mediaItemIds.size(); i++)
                    {
                        ((List) (obj)).add(String.valueOf(mediaItemIds.get(i)));
                    }

                    Object obj1;
                    for (obj = partitionIdsForSQLiteMax(((List) (obj))).iterator(); ((Iterator) (obj)).hasNext(); ((com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement) (obj1)).executeUpdateDelete())
                    {
                        obj1 = Arrays.toString(((List)((Iterator) (obj)).next()).toArray()).replace('[', '(').replace(']', ')');
                        obj1 = readwritesqlitedatabase.compileStatement(SQLiteDaoUtil.deleteClause("dynamic_album_membership", (new StringBuilder()).append("tag_id=? AND media_item_id IN ").append(((String) (obj1))).toString()));
                        ((com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement) (obj1)).bindLong(1, tagId);
                    }

                    return null;
                }

                protected void postTransaction()
                {
                    notifyContentResolversOfChange(tagId);
                }

            
            {
                this$0 = DynamicAlbumDao.this;
                mediaItemIds = list;
                tagId = l;
                super();
            }
            }).execute(connectionManager);
            return;
        }
    }

    public void entryRemoved(boolean flag, Long long1, CacheStatus cachestatus, CacheStatus cachestatus1)
    {
        if (flag)
        {
            GLogger.d(TAG, "Node evicted from dynamic album LRU cache: %s", new Object[] {
                long1
            });
            deleteDynamicAlbum(long1.longValue());
        }
    }

    public volatile void entryRemoved(boolean flag, Object obj, Object obj1, Object obj2)
    {
        entryRemoved(flag, (Long)obj, (CacheStatus)obj1, (CacheStatus)obj2);
    }

    public List getDynamicAlbumTagIds()
    {
        return (List)(new DBReadExecutor() {

            final DynamicAlbumDao this$0;

            public volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return execute(readonlysqlitedatabase);
            }

            public List execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                ReadOnlySQLiteDatabase readonlysqlitedatabase1;
                ReadOnlySQLiteDatabase readonlysqlitedatabase2;
                ArrayList arraylist;
                arraylist = new ArrayList();
                readonlysqlitedatabase2 = null;
                readonlysqlitedatabase1 = null;
                readonlysqlitedatabase = readonlysqlitedatabase.query(true, "dynamic_album_membership", new String[] {
                    "tag_id"
                }, null, null, "tag_id", null, "cache_time ASC", null);
                readonlysqlitedatabase1 = readonlysqlitedatabase;
                readonlysqlitedatabase2 = readonlysqlitedatabase;
                int i = readonlysqlitedatabase.getColumnIndex("tag_id");
                readonlysqlitedatabase1 = readonlysqlitedatabase;
                readonlysqlitedatabase2 = readonlysqlitedatabase;
                if (!readonlysqlitedatabase.moveToFirst()) goto _L2; else goto _L1
_L1:
                readonlysqlitedatabase1 = readonlysqlitedatabase;
                readonlysqlitedatabase2 = readonlysqlitedatabase;
                arraylist.add(Long.valueOf(readonlysqlitedatabase.getLong(i)));
_L5:
                readonlysqlitedatabase1 = readonlysqlitedatabase;
                readonlysqlitedatabase2 = readonlysqlitedatabase;
                if (!readonlysqlitedatabase.moveToNext()) goto _L2; else goto _L3
_L3:
                readonlysqlitedatabase1 = readonlysqlitedatabase;
                readonlysqlitedatabase2 = readonlysqlitedatabase;
                arraylist.add(Long.valueOf(readonlysqlitedatabase.getLong(i)));
                if (true) goto _L5; else goto _L4
_L4:
                readonlysqlitedatabase;
                readonlysqlitedatabase2 = readonlysqlitedatabase1;
                GLogger.ex(DynamicAlbumDao.TAG, "Error fetching dynamic album node ids", readonlysqlitedatabase);
                if (readonlysqlitedatabase1 != null)
                {
                    readonlysqlitedatabase1.close();
                }
_L7:
                return arraylist;
_L2:
                if (readonlysqlitedatabase == null) goto _L7; else goto _L6
_L6:
                readonlysqlitedatabase.close();
                return arraylist;
                readonlysqlitedatabase;
                if (readonlysqlitedatabase2 != null)
                {
                    readonlysqlitedatabase2.close();
                }
                throw readonlysqlitedatabase;
            }

            
            {
                this$0 = DynamicAlbumDao.this;
                super();
            }
        }).execute(connectionManager);
    }

    public void insert(long l, List list, CacheStatus cachestatus)
    {
        trimCache(l);
        put(Long.valueOf(l), cachestatus);
        if (cachestatus == CacheStatus.NORMAL)
        {
            deleteDynamicAlbum(l);
        }
        if (list != null)
        {
            insertDynamicAlbum(list, l, true);
        }
    }

    public void onAccountDeregistered()
    {
        GLogger.d(TAG, "Account de-registered - clearing dynamic album cache", new Object[0]);
        evictAll();
    }

    public void onAccountRegistered()
    {
    }

    public void reconstruct()
    {
        Map map = reconstructCacheFromDb();
        Long long1;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); put(long1, map.get(long1)))
        {
            long1 = (Long)iterator.next();
        }

    }









}
