// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.DisplayMetrics;
import android.view.Display;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.medialets.advertising:
//            ag, ae, a, y, 
//            aa

final class h
    implements ag
{
    private static final class a extends SQLiteOpenHelper
    {

        public final void onCreate(SQLiteDatabase sqlitedatabase)
        {
            sqlitedatabase.execSQL("CREATE TABLE ad_cache (adID CHAR(50) PRIMARY KEY, fetchTimestamp TIMESTAMP, lastModTimestamp TIMESTAMP, lastDisplayTimestamp TIMESTAMP, adType TEXT, adSlotType TEXT, adClipType TEXT, width TEXT, height TEXT, expandedWidth TEXT, expandedHeight TEXT, image BLOB, imageName TEXT, clickThroughURLString TEXT, htmlResources TEXT, otherResources TEXT, impressions INT DEFAULT '0', runImpressions INT DEFAULT '0', maxImpressions INT, maxRunImpressions INT, startTimestamp TIMESTAMP, endTimestamp TIMESTAMP, displayTimeSlices TEXT, blockList TEXT, slotTargetKey TEXT, slotTargetNames TEXT, slotTargetKeywords TEXT, avcClassName TEXT, mainFile TEXT, expandedMainFile TEXT, expandedTitle TEXT, isTest TEXT, adVersion TEXT, minNetwork TEXT, displaysCloseButton TEXT, closeButtonLibID TEXT, closeButtonOrientation TEXT, adWeight TEXT, trackingPixels TEXT, notForAdRotation TEXT, transparentView TEXT, creativeDownloaded INT DEFAULT '0');");
        }

        public final void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
        {
        }

        public a()
        {
            super(h.mContext, "medialytics.db", null, 1);
        }
    }


    private static Lock a = new ReentrantLock();
    protected static Context mContext;
    private a b;

    public h(Context context)
    {
        mContext = context;
        b = new a();
    }

    private boolean d(ae ae1)
    {
        SQLiteDatabase sqlitedatabase;
        SQLiteDatabase sqlitedatabase1;
        sqlitedatabase1 = null;
        sqlitedatabase = null;
        if (c(ae1))
        {
            e(ae1);
        }
        a.lock();
        SQLiteDatabase sqlitedatabase2 = b.getWritableDatabase();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        long l = sqlitedatabase2.insert("ad_cache", null, ae1.u());
        if (sqlitedatabase2 != null)
        {
            sqlitedatabase2.close();
        }
        a.unlock();
_L1:
        SQLException sqlexception;
        return l > 0L;
        sqlexception;
        sqlitedatabase1 = sqlitedatabase;
        com.medialets.advertising.a.c((new StringBuilder()).append("Error inserting ").append(ae1.d()).append(" into cache: ").append(sqlexception.toString()).toString());
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        a.unlock();
        l = -1L;
          goto _L1
        ae1;
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        a.unlock();
        throw ae1;
    }

    private boolean e(ae ae1)
    {
        SQLiteDatabase sqlitedatabase;
        SQLiteDatabase sqlitedatabase1;
        sqlitedatabase1 = null;
        sqlitedatabase = null;
        a.lock();
        SQLiteDatabase sqlitedatabase2 = b.getWritableDatabase();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        int i = sqlitedatabase2.update("ad_cache", ae1.u(), "adID=?", new String[] {
            ae1.d()
        });
        if (sqlitedatabase2 != null)
        {
            sqlitedatabase2.close();
        }
        a.unlock();
_L1:
        SQLException sqlexception;
        return i > 0;
        sqlexception;
        sqlitedatabase1 = sqlitedatabase;
        com.medialets.advertising.a.c((new StringBuilder()).append("Error updating ").append(ae1.d()).append(" in the cache: ").append(sqlexception.toString()).toString());
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        a.unlock();
        i = -1;
          goto _L1
        ae1;
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        a.unlock();
        throw ae1;
    }

    private boolean f(ae ae1)
    {
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        a.lock();
        SQLiteDatabase sqlitedatabase = b.getWritableDatabase();
        int i;
        try
        {
            ae1 = ae1.d();
            ae1 = sqlitedatabase.query("ad_cache", new String[] {
                "adID"
            }, "adID=?", new String[] {
                ae1
            }, null, null, null);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ae1 = null;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            continue; /* Loop/switch isn't completed */
        }
_L1:
        i = ae1.getCount();
        Exception exception;
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (ae1 != null)
        {
            ae1.close();
        }
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        a.unlock();
        return flag;
        obj;
        ae1 = null;
        sqlitedatabase = obj1;
_L4:
        com.medialets.advertising.a.c((new StringBuilder()).append("Error checking for record: ").append(((SQLException) (obj)).toString()).toString());
        if (ae1 != null)
        {
            ae1.close();
        }
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        a.unlock();
        return false;
        ae1;
        sqlitedatabase = null;
_L2:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        a.unlock();
        throw ae1;
        exception;
        obj = ae1;
        ae1 = exception;
        continue; /* Loop/switch isn't completed */
        exception;
        obj = ae1;
        ae1 = exception;
        if (true) goto _L2; else goto _L1
        obj;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final ae a(String s)
    {
        a.lock();
        Object obj = b.getWritableDatabase();
        Object obj1;
        ae ae1;
        Object obj2;
        try
        {
            obj1 = ((SQLiteDatabase) (obj)).query("ad_cache", null, "adID=?", new String[] {
                s
            }, null, null, null);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            obj1 = obj;
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            obj1 = obj;
            obj = null;
        }
        if (!((Cursor) (obj1)).moveToNext()) goto _L2; else goto _L1
_L1:
        ae1 = ae.a(((Cursor) (obj1)));
        s = ae1;
_L7:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        if (obj != null)
        {
            ((SQLiteDatabase) (obj)).close();
        }
        a.unlock();
        return s;
        obj2;
        obj = null;
        obj1 = null;
_L5:
        com.medialets.advertising.a.c((new StringBuilder()).append("Error retrieving ad ").append(s).append(" from cache: ").append(((SQLException) (obj2)).toString()).toString());
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        if (obj1 != null)
        {
            ((SQLiteDatabase) (obj1)).close();
        }
        a.unlock();
        return null;
        s;
        obj = null;
        obj1 = null;
_L4:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        if (obj1 != null)
        {
            ((SQLiteDatabase) (obj1)).close();
        }
        a.unlock();
        throw s;
        s;
        obj2 = obj;
        obj = obj1;
        obj1 = obj2;
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L4; else goto _L3
_L3:
        obj2;
        SQLiteDatabase sqlitedatabase = ((SQLiteDatabase) (obj));
        obj = obj1;
        obj1 = sqlitedatabase;
        if (true) goto _L5; else goto _L2
_L2:
        s = null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final Vector a(int i, int j, int k)
    {
        Object obj2 = null;
        Object obj1 = null;
        Vector vector = new Vector();
        Object obj = new DisplayMetrics();
        y.c().getMetrics(((DisplayMetrics) (obj)));
        SQLException sqlexception;
        Object obj3;
        int l;
        if (k == 1)
        {
            l = Math.round((float)i / ((DisplayMetrics) (obj)).density);
            k = Math.round((float)j / ((DisplayMetrics) (obj)).density);
        } else
        {
            k = j;
            l = i;
        }
        a.lock();
        try
        {
            obj = b.getWritableDatabase();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            obj = null;
        }
        obj1 = new Date();
        obj1 = aa.sDateFormat.format(((Date) (obj1)));
        obj1 = ((SQLiteDatabase) (obj)).rawQuery("SELECT * FROM ad_cache WHERE impressions < maxImpressions AND runImpressions < maxRunImpressions AND (width = ? OR width = ?) AND (height = ? OR height = ?) AND startTimestamp < ? AND endTimestamp > ? AND notForAdRotation = 0 AND creativeDownloaded = 1 ORDER BY lastDisplayTimestamp ASC", new String[] {
            String.valueOf(i), String.valueOf(l), String.valueOf(j), String.valueOf(k), obj1, obj1
        });
        obj2 = obj1;
        while (((Cursor) (obj2)).moveToNext()) 
        {
            vector.add(ae.a(((Cursor) (obj2))));
        }
          goto _L1
        sqlexception;
        obj1 = obj;
        obj = obj2;
        obj2 = sqlexception;
_L7:
        com.medialets.advertising.a.c((new StringBuilder()).append("Error retrieving advertisements: ").append(((SQLException) (obj2)).toString()).toString());
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        if (obj1 != null)
        {
            ((SQLiteDatabase) (obj1)).close();
        }
        a.unlock();
_L3:
        com.medialets.advertising.a.d((new StringBuilder()).append("Number of ads from store: ").append(vector.size()).toString());
        return vector;
_L1:
        if (obj2 != null)
        {
            ((Cursor) (obj2)).close();
        }
        if (obj != null)
        {
            ((SQLiteDatabase) (obj)).close();
        }
        a.unlock();
        if (true) goto _L3; else goto _L2
_L2:
        break MISSING_BLOCK_LABEL_79;
_L5:
        if (obj2 != null)
        {
            ((Cursor) (obj2)).close();
        }
        if (obj != null)
        {
            ((SQLiteDatabase) (obj)).close();
        }
        a.unlock();
        throw obj1;
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        continue; /* Loop/switch isn't completed */
        obj2;
        obj3 = obj1;
        obj1 = obj2;
        obj2 = obj;
        obj = obj3;
        if (true) goto _L5; else goto _L4
_L4:
        break MISSING_BLOCK_LABEL_79;
        obj2;
        obj3 = null;
        obj1 = obj;
        obj = obj3;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final boolean a()
    {
        SQLiteDatabase sqlitedatabase;
        SQLiteDatabase sqlitedatabase1;
        sqlitedatabase1 = null;
        sqlitedatabase = null;
        a.lock();
        SQLiteDatabase sqlitedatabase2 = b.getWritableDatabase();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        int i = sqlitedatabase2.delete("ad_cache", "1", null);
        if (sqlitedatabase2 != null)
        {
            sqlitedatabase2.close();
        }
        a.unlock();
_L1:
        Exception exception;
        SQLException sqlexception;
        return i > 0;
        sqlexception;
        sqlitedatabase1 = sqlitedatabase;
        com.medialets.advertising.a.c((new StringBuilder()).append("Error attempting to delete the cache...").append(sqlexception.toString()).toString());
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        a.unlock();
        i = -1;
          goto _L1
        exception;
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        a.unlock();
        throw exception;
    }

    public final boolean a(ae ae1)
    {
        if (!f(ae1))
        {
            return d(ae1);
        } else
        {
            return e(ae1);
        }
    }

    public final Vector b()
    {
        Object obj;
        Object obj1;
        Object obj2;
        obj2 = null;
        obj1 = null;
        Vector vector = new Vector();
        a.lock();
        Object obj3;
        Exception exception;
        try
        {
            obj = b.getWritableDatabase();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            obj1 = null;
        }
        obj1 = new Date();
        obj1 = ((SQLiteDatabase) (obj)).query("ad_cache", null, "endTimestamp < ?", new String[] {
            aa.sDateFormat.format(((Date) (obj1)))
        }, null, null, null);
        while (((Cursor) (obj1)).moveToNext()) 
        {
            vector.add(ae.a(((Cursor) (obj1))));
        }
          goto _L1
        obj2;
        obj3 = obj1;
        obj1 = obj;
        obj = obj3;
_L5:
        com.medialets.advertising.a.c((new StringBuilder()).append("Error retrieving expired advertisements: ").append(((SQLException) (obj2)).toString()).toString());
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        if (obj1 != null)
        {
            ((SQLiteDatabase) (obj1)).close();
        }
        a.unlock();
        return vector;
_L1:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        if (obj != null)
        {
            ((SQLiteDatabase) (obj)).close();
        }
        a.unlock();
        return vector;
_L3:
        if (obj2 != null)
        {
            ((Cursor) (obj2)).close();
        }
        if (obj1 != null)
        {
            ((SQLiteDatabase) (obj1)).close();
        }
        a.unlock();
        throw obj;
        exception;
        obj1 = obj;
        obj = exception;
        continue; /* Loop/switch isn't completed */
        exception;
        obj2 = obj1;
        obj1 = obj;
        obj = exception;
        continue; /* Loop/switch isn't completed */
        exception;
        obj2 = obj;
        obj = exception;
        if (true) goto _L3; else goto _L2
_L2:
        break MISSING_BLOCK_LABEL_29;
        obj2;
        Object obj4 = null;
        obj1 = obj;
        obj = obj4;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final boolean b(ae ae1)
    {
        SQLiteDatabase sqlitedatabase;
        SQLiteDatabase sqlitedatabase1;
        sqlitedatabase1 = null;
        sqlitedatabase = null;
        a.lock();
        SQLiteDatabase sqlitedatabase2 = b.getWritableDatabase();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        int i = sqlitedatabase2.delete("ad_cache", "adID=?", new String[] {
            ae1.d()
        });
        if (sqlitedatabase2 != null)
        {
            sqlitedatabase2.close();
        }
        a.unlock();
_L1:
        SQLException sqlexception;
        return i > 0;
        sqlexception;
        sqlitedatabase1 = sqlitedatabase;
        com.medialets.advertising.a.c((new StringBuilder()).append("Error removing ").append(ae1.d()).append(" from the cache: ").append(sqlexception.toString()).toString());
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        a.unlock();
        i = -1;
          goto _L1
        ae1;
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        a.unlock();
        throw ae1;
    }

    public final boolean c(ae ae1)
    {
        Object obj1;
        Object obj2;
        obj2 = null;
        obj1 = null;
        a.lock();
        Object obj = b.getWritableDatabase();
        int j;
        try
        {
            obj1 = ae1.d();
            int i = ae1.c();
            obj1 = ((SQLiteDatabase) (obj)).query("ad_cache", new String[] {
                "adID"
            }, "adID=? AND adVersion=? AND creativeDownloaded = 1", new String[] {
                obj1, String.valueOf(i)
            }, null, null, null);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            Object obj3 = null;
            obj1 = obj;
            obj = obj3;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            obj1 = obj2;
            continue; /* Loop/switch isn't completed */
        }
        j = ((Cursor) (obj1)).getCount();
        SQLiteDatabase sqlitedatabase;
        boolean flag;
        if (j > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        if (obj != null)
        {
            ((SQLiteDatabase) (obj)).close();
        }
        a.unlock();
        return flag;
        obj2;
        obj = null;
_L4:
        com.medialets.advertising.a.c((new StringBuilder()).append("Error checking cache for ").append(ae1.d()).append(": ").append(((SQLException) (obj2)).toString()).toString());
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        if (obj1 != null)
        {
            ((SQLiteDatabase) (obj1)).close();
        }
        a.unlock();
        return false;
        ae1;
        obj = null;
        obj1 = obj2;
_L2:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        if (obj != null)
        {
            ((SQLiteDatabase) (obj)).close();
        }
        a.unlock();
        throw ae1;
        ae1;
        continue; /* Loop/switch isn't completed */
        ae1;
        obj2 = obj;
        obj = obj1;
        obj1 = obj2;
        if (true) goto _L2; else goto _L1
_L1:
        break MISSING_BLOCK_LABEL_69;
        obj2;
        sqlitedatabase = ((SQLiteDatabase) (obj));
        obj = obj1;
        obj1 = sqlitedatabase;
        if (true) goto _L4; else goto _L3
_L3:
    }

}
