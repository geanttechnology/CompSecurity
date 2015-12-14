// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.CursorRowProcessor;
import com.amazon.gallery.framework.data.dao.sqlite.SQLiteDaoUtil;
import com.amazon.gallery.framework.model.ThisDayYearInfo;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.thor.settings.HidePreferenceManager;
import com.amazon.gallery.thor.thisday.ThisDayViewCollection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

// Referenced classes of package com.amazon.gallery.framework.data.dao:
//            MediaItemSortType, SortOrder

public class ThisDayDBInfoProvider
{

    private static final String CONTENT_PROVIDER_DAY_WHERE = String.format("strftime('%%m-%%d', %s/1000, 'unixepoch')=strftime('%%m-%%d', '%s', 'localtime')", new Object[] {
        "time_stamp", "_TIME_TO_USE_"
    });
    private static final String CONTENT_PROVIDER_WEEK_WHERE = String.format("strftime('%%m-%%d', %s/1000, 'unixepoch') IN (%s)", new Object[] {
        "time_stamp", WEEK_DAYS
    });
    private static final String ORDER_CLAUSE;
    private static final String RANDOM_CLAUSE = String.format("AND %s != ?", new Object[] {
        "year"
    });
    private static final String RANDOM_COLLECTION_EXCLUDE_HIDDEN_PHOTOS_QUERY = String.format("SELECT * FROM (%s %s ORDER BY random()) %s", new Object[] {
        SELECT_CLAUSE, RANDOM_EXCLUDE_HIDDEN_CLAUSE, RANDOM_ORDER_CLAUSE
    });
    private static final String RANDOM_COLLECTION_QUERY = String.format("SELECT * FROM (%s %s ORDER BY random()) %s", new Object[] {
        SELECT_CLAUSE, RANDOM_CLAUSE, RANDOM_ORDER_CLAUSE
    });
    private static final String RANDOM_EXCLUDE_HIDDEN_CLAUSE = String.format("AND %s %s", new Object[] {
        "hidden = 0", RANDOM_CLAUSE
    });
    private static final String RANDOM_ORDER_CLAUSE = String.format("GROUP BY %s ORDER BY %s DESC", new Object[] {
        "year", "year"
    });
    private static final String SELECT_CLAUSE = String.format("SELECT *, strftime('%%Y', %s/1000, 'unixepoch') AS %s FROM %s WHERE %s = ?", new Object[] {
        "time_stamp", "year", "media_item", "sync_state"
    });
    private static final String THIS_DAY_CLAUSE = String.format("AND %s != 0 AND %s != ? AND %s", new Object[] {
        "has_date", "year", CONTENT_PROVIDER_DAY_WHERE
    });
    private static final String THIS_DAY_EXCLUDE_HIDDEN_CLAUSE = String.format("AND %s %s", new Object[] {
        "hidden = 0", THIS_DAY_CLAUSE
    });
    private static final String THIS_DAY_EXCLUDE_HIDDEN_PHOTOS_QUERY;
    private static final String THIS_DAY_QUERY;
    private static final String THIS_WEEK_CLAUSE = String.format("AND %s != 0 AND %s != ? AND %s", new Object[] {
        "has_date", "year", CONTENT_PROVIDER_WEEK_WHERE
    });
    private static final String THIS_WEEK_EXCLUDE_HIDDEN_CLAUSE = String.format("AND %s %s", new Object[] {
        "hidden = 0", THIS_WEEK_CLAUSE
    });
    private static final String THIS_WEEK_EXCLUDE_HIDDEN_PHOTOS_QUERY;
    private static final String THIS_WEEK_QUERY;
    public static final String WEEK_DAYS = String.format("%s, %s, %s, %s, %s, %s, %s, %s", new Object[] {
        "strftime('%m-%d', '_TIME_TO_USE_', '0 days', 'localtime')", "strftime('%m-%d', '_TIME_TO_USE_', '1 days', 'localtime')", "strftime('%m-%d', '_TIME_TO_USE_', '2 days', 'localtime')", "strftime('%m-%d', '_TIME_TO_USE_', '3 days', 'localtime')", "strftime('%m-%d', '_TIME_TO_USE_', '4 days', 'localtime')", "strftime('%m-%d', '_TIME_TO_USE_', '5 days', 'localtime')", "strftime('%m-%d', '_TIME_TO_USE_', '6 days', 'localtime')", "strftime('%m-%d', '_TIME_TO_USE_', '7 days', 'localtime')"
    });
    private static com.amazon.gallery.framework.data.dao.sqlite.SQLiteDaoUtil.MediaItemColumnIndices mediaItemColumnIndices = new com.amazon.gallery.framework.data.dao.sqlite.SQLiteDaoUtil.MediaItemColumnIndices();
    private final HidePreferenceManager hidePreferenceManager;
    private final MediaItemDao mediaItemDao;
    private final int numMediaItemsToCollect;
    private final SharedPreferences preferences;
    private final String randomLimitClause;

    public ThisDayDBInfoProvider(Context context, MediaItemDao mediaitemdao)
    {
        mediaItemDao = mediaitemdao;
        numMediaItemsToCollect = context.getResources().getInteger(0x7f0d0005);
        hidePreferenceManager = new HidePreferenceManager(context);
        randomLimitClause = (new StringBuilder()).append(" LIMIT ").append(String.valueOf(numMediaItemsToCollect * 2)).toString();
        preferences = context.getSharedPreferences("galleryKindleSharedPrefs", 0);
    }

    public static String getContentProviderDayWhere(Context context)
    {
        return replaceTimeToken(CONTENT_PROVIDER_DAY_WHERE, context.getSharedPreferences("galleryKindleSharedPrefs", 0));
    }

    public static String getContentProviderWeekWhere(Context context)
    {
        return replaceTimeToken(CONTENT_PROVIDER_WEEK_WHERE, context.getSharedPreferences("galleryKindleSharedPrefs", 0));
    }

    private static String getDateToUse(SharedPreferences sharedpreferences)
    {
        if (BuildFlavors.isDebug() && sharedpreferences.contains("THIS_DAY_TIME_OVERRIDE"))
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(sharedpreferences.getLong("THIS_DAY_TIME_OVERRIDE", 0L)));
            if (TimeZone.getDefault().getRawOffset() < 0)
            {
                return String.format("%d-%02d-%02dT02:34:56-07:00", new Object[] {
                    Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5))
                });
            } else
            {
                return String.format("%d-%02d-%02dT02:34:56+05:30", new Object[] {
                    Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5))
                });
            }
        } else
        {
            return "now";
        }
    }

    private static String replaceTimeToken(String s, SharedPreferences sharedpreferences)
    {
        return s.replaceAll("_TIME_TO_USE_", getDateToUse(sharedpreferences));
    }

    private ThisDayViewCollection runQuery(int i, String s)
    {
        final ThisDayViewCollection collection = new ThisDayViewCollection(i, new ArrayList());
        MediaItemDao mediaitemdao = mediaItemDao;
        i = SyncState.SYNCED.value;
        int j = Calendar.getInstance().get(1);
        CursorRowProcessor cursorrowprocessor = new CursorRowProcessor() {

            private ThisDayYearInfo currentBucket;
            private int currentYear;
            final ThisDayDBInfoProvider this$0;
            final ThisDayViewCollection val$collection;

            public MediaItem process(Cursor cursor)
            {
                int k = cursor.getInt(cursor.getColumnIndex("year"));
                if (k != currentYear)
                {
                    currentBucket = new ThisDayYearInfo(k, numMediaItemsToCollect);
                    collection.yearInfoList.add(currentBucket);
                    currentYear = k;
                }
                currentBucket.addMediaItem(SQLiteDaoUtil.itemFromCursor(cursor, mediaItemDao, ThisDayDBInfoProvider.mediaItemColumnIndices));
                return null;
            }

            public volatile Object process(Cursor cursor)
            {
                return process(cursor);
            }

            
            {
                this$0 = ThisDayDBInfoProvider.this;
                collection = thisdayviewcollection;
                super();
            }
        };
        mediaitemdao.getMediaItemDataFromRawQuery(s, new String[] {
            String.valueOf(i), String.valueOf(j)
        }, cursorrowprocessor);
        for (s = collection.yearInfoList.iterator(); s.hasNext(); collection.incrementTotalMediaItemsBy(((ThisDayYearInfo)s.next()).getNumTotalMediaItems())) { }
        return collection;
    }

    public ThisDayViewCollection getCollectionSynchronously(int i)
    {
        String s;
        boolean flag;
        s = THIS_DAY_QUERY;
        flag = hidePreferenceManager.getHiddenPreference();
        i;
        JVM INSTR tableswitch 0 2: default 40
    //                   0 54
    //                   1 72
    //                   2 90;
           goto _L1 _L2 _L3 _L4
_L1:
        return runQuery(i, replaceTimeToken(s, preferences));
_L2:
        if (flag)
        {
            s = THIS_DAY_QUERY;
        } else
        {
            s = THIS_DAY_EXCLUDE_HIDDEN_PHOTOS_QUERY;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (flag)
        {
            s = THIS_WEEK_QUERY;
        } else
        {
            s = THIS_WEEK_EXCLUDE_HIDDEN_PHOTOS_QUERY;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (flag)
        {
            s = (new StringBuilder()).append(RANDOM_COLLECTION_QUERY).append(randomLimitClause).toString();
        } else
        {
            s = (new StringBuilder()).append(RANDOM_COLLECTION_EXCLUDE_HIDDEN_PHOTOS_QUERY).append(randomLimitClause).toString();
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public ThisDayViewCollection getCollectionSynchronously(int i, int j)
    {
        if (i != 0)
        {
            throw new IllegalArgumentException("Specifying data size limit is only supported on This Day queries");
        }
        String s;
        String s1;
        if (hidePreferenceManager.getHiddenPreference())
        {
            s = THIS_DAY_QUERY;
        } else
        {
            s = THIS_DAY_EXCLUDE_HIDDEN_PHOTOS_QUERY;
        }
        s1 = s;
        if (j > 0)
        {
            s1 = (new StringBuilder()).append(s).append(" LIMIT ").append(String.valueOf(j)).toString();
        }
        return runQuery(i, replaceTimeToken(s1, preferences));
    }

    static 
    {
        ORDER_CLAUSE = String.format("ORDER BY %s DESC, %s", new Object[] {
            "year", MediaItemSortType.TIME_STAMP_DESC.getSortOrder().getOrderByString()
        });
        THIS_DAY_QUERY = String.format("%s %s %s", new Object[] {
            SELECT_CLAUSE, THIS_DAY_CLAUSE, ORDER_CLAUSE
        });
        THIS_DAY_EXCLUDE_HIDDEN_PHOTOS_QUERY = String.format("%s %s %s", new Object[] {
            SELECT_CLAUSE, THIS_DAY_EXCLUDE_HIDDEN_CLAUSE, ORDER_CLAUSE
        });
        THIS_WEEK_QUERY = String.format("%s %s %s", new Object[] {
            SELECT_CLAUSE, THIS_WEEK_CLAUSE, ORDER_CLAUSE
        });
        THIS_WEEK_EXCLUDE_HIDDEN_PHOTOS_QUERY = String.format("%s %s %s", new Object[] {
            SELECT_CLAUSE, THIS_WEEK_EXCLUDE_HIDDEN_CLAUSE, ORDER_CLAUSE
        });
    }



}
