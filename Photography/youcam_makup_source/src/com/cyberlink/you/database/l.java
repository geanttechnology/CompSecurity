// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.you.e;
import com.cyberlink.you.i;
import com.cyberlink.you.sticker.StickerObj;
import com.cyberlink.you.utility.ULogUtility;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class l
{

    private static final String a[] = {
        "_id", "StickerId", "PackId", "StickerOrder", "OriginalURL", "OriginalLocalFilePath", "ThumbnailURL", "ThumbnailLocalFilePath", "LastModified", "Width", 
        "Height", "AnimPngFilename", "Duration"
    };
    private final SQLiteDatabase b = e.a();
    private final SQLiteDatabase c = e.b();

    public l()
    {
    }

    private StickerObj a(Cursor cursor)
    {
        long l3 = System.currentTimeMillis();
        int j = cursor.getColumnIndex("_id");
        int k = cursor.getColumnIndex("StickerId");
        int i1 = cursor.getColumnIndex("PackId");
        int j1 = cursor.getColumnIndex("StickerOrder");
        int k1 = cursor.getColumnIndex("LastModified");
        int l1 = cursor.getColumnIndex("OriginalURL");
        int i2 = cursor.getColumnIndex("OriginalLocalFilePath");
        int j2 = cursor.getColumnIndex("ThumbnailURL");
        int k2 = cursor.getColumnIndex("ThumbnailLocalFilePath");
        int l2 = cursor.getColumnIndex("Width");
        int i3 = cursor.getColumnIndex("Height");
        int j3 = cursor.getColumnIndex("AnimPngFilename");
        int k3 = cursor.getColumnIndex("Duration");
        if (j < 0 || k < 0 || i1 < 0 || j1 < 0 || k1 < 0 || l1 < 0 || i2 < 0 || j2 < 0 || k2 < 0 || j3 < 0 || k3 < 0)
        {
            i.c("database.StickerDao", new Object[] {
                "[_get(Cursor)] ", "cursor.getColumnIndex() returned negative number"
            });
            cursor = null;
        } else
        {
            StickerObj stickerobj = new StickerObj(cursor.getLong(j), cursor.getLong(k), cursor.getLong(i1), cursor.getLong(j1), cursor.getLong(k1), cursor.getString(l1), cursor.getString(i2), cursor.getString(j2), cursor.getString(k2), cursor.getInt(l2), cursor.getInt(i3), cursor.getString(j3), cursor.getInt(k3));
            cursor = stickerobj;
            if (i.a() <= 2)
            {
                i.a("database.StickerDao", new Object[] {
                    "[_get(Cursor)] ", "    mediaObj: ", stickerobj.toString()
                });
                i.a("database.StickerDao", new Object[] {
                    "[_get(Cursor)] ", "Iterating takes ", Double.valueOf((double)(System.currentTimeMillis() - l3) / 1000D), " seconds."
                });
                return stickerobj;
            }
        }
        return cursor;
    }

    private StickerObj a(String s, String as[])
    {
        long l1;
        l1 = System.currentTimeMillis();
        s = b.query("Sticker", a, s, as, null, null, null, e.c);
        if (s != null) goto _L2; else goto _L1
_L1:
        as = s;
        i.c("database.StickerDao", new Object[] {
            "[get(String, String[])] ", "Failed to query: cursor is null"
        });
        if (s != null)
        {
            s.close();
        }
        as = null;
_L4:
        return as;
_L2:
        as = s;
        if (i.a() > 2)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        as = s;
        i.a("database.StickerDao", new Object[] {
            "[get(String, String[])] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l1) / 1000D), " seconds."
        });
        as = s;
        if (s.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_164;
        }
        as = s;
        i.b("database.StickerDao", new Object[] {
            "[get(String, String[])] ", "Database has no records."
        });
        if (s != null)
        {
            s.close();
        }
        return null;
        as = s;
        StickerObj stickerobj = a(((Cursor) (s)));
        as = stickerobj;
        if (s == null) goto _L4; else goto _L3
_L3:
        s.close();
        return stickerobj;
        Exception exception;
        exception;
        s = null;
_L8:
        as = s;
        ULogUtility.a("database.StickerDao", "[get(String, String[])] ", exception);
        if (s != null)
        {
            s.close();
        }
        return null;
        s;
        as = null;
_L6:
        if (as != null)
        {
            as.close();
        }
        throw s;
        s;
        if (true) goto _L6; else goto _L5
_L5:
        exception;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private List b(String s, String as[])
    {
        long l1;
        l1 = System.currentTimeMillis();
        as = b.query("Sticker", a, s, as, null, null, null);
        if (as != null) goto _L2; else goto _L1
_L1:
        s = as;
        i.c("database.StickerDao", new Object[] {
            "[get(String, String[])] ", "Failed to query: cursor is null"
        });
        Object obj = null;
        s = obj;
        if (as != null)
        {
            as.close();
            s = obj;
        }
_L4:
        return s;
_L2:
        s = as;
        if (i.a() > 2)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        s = as;
        i.a("database.StickerDao", new Object[] {
            "[get(String, String[])] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l1) / 1000D), " seconds."
        });
        s = as;
        if (as.getCount() > 0)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        s = as;
        i.a("database.StickerDao", new Object[] {
            "[get(String, String[])] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l1) / 1000D), " seconds."
        });
        s = as;
        if (as.moveToFirst())
        {
            break; /* Loop/switch isn't completed */
        }
        s = as;
        i.b("database.StickerDao", new Object[] {
            "[get(String, String[])] ", "Database has no records."
        });
        s = null;
        if (as != null)
        {
            as.close();
            return null;
        }
        if (true) goto _L4; else goto _L3
_L3:
        s = as;
        ArrayList arraylist = new ArrayList();
_L6:
        s = as;
        arraylist.add(a(as));
        s = as;
        boolean flag = as.moveToNext();
        if (flag) goto _L6; else goto _L5
_L5:
        s = arraylist;
        if (as == null) goto _L4; else goto _L7
_L7:
        as.close();
        return arraylist;
        Exception exception;
        exception;
        as = null;
_L11:
        s = as;
        ULogUtility.a("database.StickerDao", "[get(String, String[])] ", exception);
        s = null;
        if (as == null) goto _L4; else goto _L8
_L8:
        as.close();
        return null;
        as;
        s = null;
_L10:
        if (s != null)
        {
            s.close();
        }
        throw as;
        as;
        if (true) goto _L10; else goto _L9
_L9:
        exception;
          goto _L11
    }

    public StickerObj a(long l1)
    {
        return a("StickerId=?", new String[] {
            String.valueOf(l1)
        });
    }

    public void a(long l1, StickerObj stickerobj)
    {
        stickerobj = stickerobj.p();
        stickerobj.remove("_id");
        int j;
        try
        {
            if (i.a() <= 2)
            {
                i.a("database.StickerDao", new Object[] {
                    "[update] ", "db.update to ", "Sticker", ", id: ", Long.valueOf(l1), ", values: ", stickerobj.toString()
                });
            }
            j = c.update("Sticker", stickerobj, "StickerId=?", new String[] {
                String.valueOf(l1)
            });
        }
        // Misplaced declaration of an exception variable
        catch (StickerObj stickerobj)
        {
            ULogUtility.a("database.StickerDao", "[update] ", stickerobj);
            return;
        }
        if (j == 1)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        i.c("database.StickerDao", new Object[] {
            "[update] ", "update id: ", Long.valueOf(l1), ", rowsAffected != 1, rowsAffected: ", Integer.valueOf(j)
        });
    }

    public void a(StickerObj stickerobj)
    {
        stickerobj = stickerobj.p();
        stickerobj.remove("_id");
        long l1;
        try
        {
            if (i.a() <= 2)
            {
                i.a("database.StickerDao", new Object[] {
                    "[insert] ", "db.insert to ", "Sticker", ": ", stickerobj.toString()
                });
            }
            l1 = c.insert("Sticker", null, stickerobj);
        }
        // Misplaced declaration of an exception variable
        catch (StickerObj stickerobj)
        {
            ULogUtility.a("database.StickerDao", "[insert] ", stickerobj);
            return;
        }
        if (l1 >= 0L)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        i.c("database.StickerDao", new Object[] {
            "[insert] ", "db.insert id: ", Long.valueOf(l1)
        });
    }

    public boolean a(List list)
    {
        list = list.iterator();
        boolean flag = false;
        while (list.hasNext()) 
        {
            StickerObj stickerobj = (StickerObj)list.next();
            StickerObj stickerobj1 = a(stickerobj.b());
            if (stickerobj1 == null)
            {
                a(stickerobj);
                flag = true;
            } else
            if (!stickerobj.e().equals(stickerobj1.e()))
            {
                a(stickerobj.b(), stickerobj);
                flag = true;
            } else
            {
                stickerobj.b(stickerobj1.i());
                stickerobj.a(stickerobj1.g());
            }
        }
        return flag;
    }

    public List b(long l1)
    {
        return b("PackId=?", new String[] {
            Long.toString(l1)
        });
    }

}
