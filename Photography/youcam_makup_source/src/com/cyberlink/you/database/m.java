// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.cyberlink.you.e;
import com.cyberlink.you.g;
import com.cyberlink.you.i;
import com.cyberlink.you.utility.ULogUtility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.cyberlink.you.database:
//            StickerPackObj

public class m
{

    private static final String a[] = {
        "_id", "PackId", "PackType", "PurchaseType", "PackName", "Description", "Expiration", "Url", "Status", "LastModified", 
        "PublisherLastModified", "PublisherName", "PublisherTitleOfUrl", "PublisherUrl", "isShowed", "iapItem"
    };
    private final SQLiteDatabase b = e.a();
    private final SQLiteDatabase c = e.b();

    public m()
    {
    }

    private StickerPackObj a(Cursor cursor)
    {
        long l4 = System.currentTimeMillis();
        int j = cursor.getColumnIndex("_id");
        int k = cursor.getColumnIndex("PackId");
        int l = cursor.getColumnIndex("PackType");
        int i1 = cursor.getColumnIndex("PurchaseType");
        int j1 = cursor.getColumnIndex("PackName");
        int k1 = cursor.getColumnIndex("Description");
        int l1 = cursor.getColumnIndex("Expiration");
        int i2 = cursor.getColumnIndex("Url");
        int j2 = cursor.getColumnIndex("Status");
        int k2 = cursor.getColumnIndex("LastModified");
        int l2 = cursor.getColumnIndex("PublisherLastModified");
        int i3 = cursor.getColumnIndex("PublisherName");
        int j3 = cursor.getColumnIndex("PublisherTitleOfUrl");
        int k3 = cursor.getColumnIndex("PublisherUrl");
        int l3 = cursor.getColumnIndex("isShowed");
        int i4 = cursor.getColumnIndex("iapItem");
        if (j < 0 || k < 0 || l < 0 || i1 < 0 || j1 < 0 || k1 < 0 || l1 < 0 || i2 < 0 || j2 < 0 || k2 < 0 || l2 < 0 || i3 < 0 || j3 < 0 || k3 < 0 || l3 < 0 || i4 < 0)
        {
            i.c("database.StickerPackDao", new Object[] {
                "[_get(Cursor)] ", "cursor.getColumnIndex() returned negative number"
            });
            cursor = null;
        } else
        {
            long l5 = cursor.getLong(j);
            long l6 = cursor.getLong(k);
            Object obj = cursor.getString(l);
            String s = cursor.getString(i1);
            String s1 = cursor.getString(j1);
            String s2 = cursor.getString(k1);
            String s3 = cursor.getString(l1);
            String s4 = cursor.getString(i2);
            String s5 = cursor.getString(j2).toUpperCase(Locale.getDefault());
            long l7 = cursor.getLong(k2);
            long l8 = cursor.getLong(l2);
            String s6 = cursor.getString(i3);
            String s7 = cursor.getString(j3);
            String s8 = cursor.getString(k3);
            boolean flag;
            if (cursor.getInt(l3) == 0)
            {
                flag = false;
            } else
            {
                flag = true;
            }
            cursor = cursor.getString(i4);
            obj = new StickerPackObj(l5, l6, ((String) (obj)), s, s1, s2, s3, s4, StickerPackObj.Status.valueOf(s5), l7, l8, s6, s7, s8, flag, cursor);
            cursor = ((Cursor) (obj));
            if (i.a() <= 2)
            {
                i.a("database.StickerPackDao", new Object[] {
                    "[_get(Cursor)] ", "    mediaObj: ", ((StickerPackObj) (obj)).toString()
                });
                i.a("database.StickerPackDao", new Object[] {
                    "[_get(Cursor)] ", "Iterating takes ", Double.valueOf((double)(System.currentTimeMillis() - l4) / 1000D), " seconds."
                });
                return ((StickerPackObj) (obj));
            }
        }
        return cursor;
    }

    private StickerPackObj a(String s, String as[])
    {
        long l;
        l = System.currentTimeMillis();
        s = b.query("StickerPack", a, s, as, null, null, null, e.c);
        if (s != null) goto _L2; else goto _L1
_L1:
        as = s;
        i.c("database.StickerPackDao", new Object[] {
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
        i.a("database.StickerPackDao", new Object[] {
            "[get(String, String[])] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l) / 1000D), " seconds."
        });
        as = s;
        if (s.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_164;
        }
        as = s;
        i.b("database.StickerPackDao", new Object[] {
            "[get(String, String[])] ", "Database has no records."
        });
        if (s != null)
        {
            s.close();
        }
        return null;
        as = s;
        StickerPackObj stickerpackobj = a(((Cursor) (s)));
        as = stickerpackobj;
        if (s == null) goto _L4; else goto _L3
_L3:
        s.close();
        return stickerpackobj;
        Exception exception;
        exception;
        s = null;
_L8:
        as = s;
        ULogUtility.a("database.StickerPackDao", "[get(String, String[])] ", exception);
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
        long l;
        l = System.currentTimeMillis();
        as = b.query("StickerPack", a, s, as, null, null, null);
        if (as != null) goto _L2; else goto _L1
_L1:
        s = as;
        i.c("database.StickerPackDao", new Object[] {
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
        i.a("database.StickerPackDao", new Object[] {
            "[get(String, String[])] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l) / 1000D), " seconds."
        });
        s = as;
        if (as.getCount() > 0)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        s = as;
        i.a("database.StickerPackDao", new Object[] {
            "[get(String, String[])] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l) / 1000D), " seconds."
        });
        s = as;
        if (as.moveToFirst())
        {
            break; /* Loop/switch isn't completed */
        }
        s = as;
        i.b("database.StickerPackDao", new Object[] {
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
        ULogUtility.a("database.StickerPackDao", "[get(String, String[])] ", exception);
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

    private void b(StickerPackObj stickerpackobj)
    {
        stickerpackobj = stickerpackobj.s();
        stickerpackobj.remove("_id");
        long l;
        try
        {
            if (i.a() <= 2)
            {
                i.a("database.StickerPackDao", new Object[] {
                    "[insert] ", "db.insert to ", "StickerPack", ": ", stickerpackobj.toString()
                });
            }
            l = c.insert("StickerPack", null, stickerpackobj);
        }
        // Misplaced declaration of an exception variable
        catch (StickerPackObj stickerpackobj)
        {
            ULogUtility.a("database.StickerPackDao", "[insert] ", stickerpackobj);
            return;
        }
        if (l >= 0L)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        i.c("database.StickerPackDao", new Object[] {
            "[insert] ", "db.insert id: ", Long.valueOf(l)
        });
    }

    public StickerPackObj a(long l)
    {
        return a("PackId=?", new String[] {
            String.valueOf(l)
        });
    }

    public List a()
    {
        return b(null, null);
    }

    public void a(long l, StickerPackObj stickerpackobj)
    {
        stickerpackobj = stickerpackobj.s();
        stickerpackobj.remove("_id");
        int j;
        try
        {
            if (i.a() <= 2)
            {
                i.a("database.StickerPackDao", new Object[] {
                    "[update] ", "db.update to ", "StickerPack", ", id: ", Long.valueOf(l), ", values: ", stickerpackobj.toString()
                });
            }
            j = c.update("StickerPack", stickerpackobj, "PackId=?", new String[] {
                String.valueOf(l)
            });
        }
        // Misplaced declaration of an exception variable
        catch (StickerPackObj stickerpackobj)
        {
            ULogUtility.a("database.StickerPackDao", "[update] ", stickerpackobj);
            return;
        }
        if (j == 1)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        i.c("database.StickerPackDao", new Object[] {
            "[update] ", "update id: ", Long.valueOf(l), ", rowsAffected != 1, rowsAffected: ", Integer.valueOf(j)
        });
    }

    public boolean a(StickerPackObj stickerpackobj)
    {
        return a(stickerpackobj, false, false);
    }

    public boolean a(StickerPackObj stickerpackobj, boolean flag, boolean flag1)
    {
        StickerPackObj stickerpackobj1 = a(stickerpackobj.b());
        if (stickerpackobj1 == null)
        {
            b(stickerpackobj);
            return true;
        }
        if (!stickerpackobj.k().equals(stickerpackobj1.k()) || flag)
        {
            if (flag1)
            {
                stickerpackobj.a(stickerpackobj1.j());
            }
            a(stickerpackobj.b(), stickerpackobj);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean a(List list)
    {
        return a(list, false, false);
    }

    public boolean a(List list, boolean flag, boolean flag1)
    {
        list = list.iterator();
        boolean flag2;
        for (flag2 = false; list.hasNext(); flag2 = a((StickerPackObj)list.next(), flag, flag1) | flag2) { }
        return flag2;
    }

    public List b()
    {
        int j = 0;
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Object obj1;
        Object obj2;
        boolean flag;
        obj = new ArrayList();
        obj1 = g.I().getSharedPreferences("U", 0);
        obj2 = ((SharedPreferences) (obj1)).getString("stickerPacksOrder", "");
        flag = ((String) (obj2)).isEmpty();
        if (flag) goto _L2; else goto _L1
_L1:
        Object obj3;
        obj3 = b("isShowed=?", new String[] {
            "1"
        });
        obj1 = new JSONArray(((String) (obj2)));
        if (obj3 == null) goto _L4; else goto _L3
_L3:
        obj2 = new HashMap();
        StickerPackObj stickerpackobj;
        for (obj3 = ((List) (obj3)).iterator(); ((Iterator) (obj3)).hasNext(); ((Map) (obj2)).put(Long.valueOf(stickerpackobj.b()), stickerpackobj))
        {
            stickerpackobj = (StickerPackObj)((Iterator) (obj3)).next();
        }

          goto _L5
_L8:
        ((JSONException) (obj1)).printStackTrace();
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((List) (obj));
_L5:
        obj3 = new ArrayList();
_L9:
        if (j >= ((JSONArray) (obj1)).length()) goto _L7; else goto _L6
_L6:
        Object obj4;
        long l;
        l = ((JSONArray) (obj1)).getLong(j);
        obj4 = (StickerPackObj)((Map) (obj2)).get(Long.valueOf(l));
label0:
        {
            if (obj4 == null)
            {
                break label0;
            }
            try
            {
                ((List) (obj3)).add(obj4);
                ((Map) (obj2)).remove(Long.valueOf(l));
                break MISSING_BLOCK_LABEL_530;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
            finally
            {
                throw obj;
            }
        }
          goto _L8
        Log.d("database.StickerPackDao", String.format(Locale.getDefault(), "PackId=(%1$d) is in Shared Preferences but not in the database with isShow=1!!!", new Object[] {
            Long.valueOf(l)
        }));
        break MISSING_BLOCK_LABEL_530;
_L7:
        if (((Map) (obj2)).size() != 0)
        {
            Log.d("database.StickerPackDao", "Sorted list of Shared Preferences does not inlcude all shown pack of database!!!");
            for (obj1 = ((Map) (obj2)).values().iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj3)).add((StickerPackObj)((Iterator) (obj1)).next())) { }
        }
        ((List) (obj)).addAll(((Collection) (obj3)));
          goto _L4
_L2:
        String as[] = new String[2];
        as[0] = "1";
        as[1] = "Downloaded";
        obj2 = new ArrayList();
        obj4 = b("isShowed=? AND Status=?", as);
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_425;
        }
        ((List) (obj)).addAll(((Collection) (obj4)));
        for (obj4 = ((List) (obj4)).iterator(); ((Iterator) (obj4)).hasNext(); ((List) (obj2)).add(Long.valueOf(((StickerPackObj)((Iterator) (obj4)).next()).b()))) { }
        as = b("isShowed=? AND Status!=?", as);
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_495;
        }
        ((List) (obj)).addAll(as);
        for (as = as.iterator(); as.hasNext(); ((List) (obj2)).add(Long.valueOf(((StickerPackObj)as.next()).b()))) { }
        obj2 = new JSONArray(((Collection) (obj2)));
        ((SharedPreferences) (obj1)).edit().putString("stickerPacksOrder", ((JSONArray) (obj2)).toString()).apply();
          goto _L4
        j++;
          goto _L9
    }

}
