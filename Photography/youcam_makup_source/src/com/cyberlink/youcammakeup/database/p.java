// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.jniproxy.UIExifColorSpace;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.pf.common.utility.m;
import java.io.File;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.youcammakeup.database:
//            r, m, q, s, 
//            n, o, c

public class p
{

    private static final String a[] = {
        "_id", "CaptureTime", "Orientation", "PresetCommand", "FileID", "Rating", "FileType", "FileHeight", "FileWidth", "RawSDKMode", 
        "Temperature", "RefreshModifiedTime", "ShareTo", "ThumbOrientation", "OriginalColorSpace", "SourceOrientation"
    };
    private static final String b[] = {
        "_id", "FileID"
    };
    private static final String c[] = {
        "_id"
    };
    private final SQLiteDatabase d = com.cyberlink.youcammakeup.c.a();
    private final SQLiteDatabase e = com.cyberlink.youcammakeup.c.b();
    private r f;

    public p()
    {
    }

    private r a(Cursor cursor)
    {
        if (!cursor.moveToFirst())
        {
            return null;
        }
        System.currentTimeMillis();
        int l = cursor.getColumnIndex("_id");
        int i1 = cursor.getColumnIndex("CaptureTime");
        int j1 = cursor.getColumnIndex("Orientation");
        int k1 = cursor.getColumnIndex("PresetCommand");
        int l1 = cursor.getColumnIndex("FileID");
        int i2 = cursor.getColumnIndex("Rating");
        int j2 = cursor.getColumnIndex("FileType");
        int k2 = cursor.getColumnIndex("FileHeight");
        int l2 = cursor.getColumnIndex("FileWidth");
        int i3 = cursor.getColumnIndex("RawSDKMode");
        int j3 = cursor.getColumnIndex("Temperature");
        int k3 = cursor.getColumnIndex("RefreshModifiedTime");
        int l3 = cursor.getColumnIndex("ShareTo");
        int i4 = cursor.getColumnIndex("ThumbOrientation");
        int j4 = cursor.getColumnIndex("OriginalColorSpace");
        int k4 = cursor.getColumnIndex("SourceOrientation");
        if (l < 0 || i1 < 0 || j1 < 0 || k1 < 0 || l1 < 0 || i2 < 0 || j2 < 0 || k2 < 0 || l2 < 0 || i3 < 0 || j3 < 0 || k3 < 0 || l3 < 0 || i4 < 0 || j4 < 0 || k4 < 0)
        {
            return null;
        } else
        {
            return new r(cursor.getLong(l), cursor.getLong(i1), UIImageOrientation.a(cursor.getInt(j1)), cursor.getString(k1), cursor.getLong(l1), cursor.getInt(i2), cursor.getString(j2), cursor.getInt(k2), cursor.getInt(l2), cursor.getInt(i3), cursor.getString(j3), cursor.getLong(k3), cursor.getInt(l3), UIImageOrientation.a(cursor.getInt(i4)), UIExifColorSpace.a(cursor.getInt(j4)), UIImageOrientation.a(cursor.getInt(k4)), -1L);
        }
    }

    private r a(String s1, String as[])
    {
        r r1 = null;
        System.currentTimeMillis();
        s1 = d.query("Image", a, s1, as, null, null, null, c.c);
        if (s1 != null) goto _L2; else goto _L1
_L1:
        if (s1 != null)
        {
            s1.close();
        }
        as = null;
_L4:
        return as;
_L2:
        r1 = a(((Cursor) (s1)));
        as = r1;
        if (s1 == null) goto _L4; else goto _L3
_L3:
        s1.close();
        return r1;
        s1;
        s1 = null;
_L8:
        if (s1 != null)
        {
            s1.close();
        }
        return null;
        s1;
        as = r1;
_L6:
        if (as != null)
        {
            as.close();
        }
        throw s1;
        Exception exception;
        exception;
        as = s1;
        s1 = exception;
        if (true) goto _L6; else goto _L5
_L5:
        as;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private boolean k(long l)
    {
        return e.delete("Image", "_id=?", new String[] {
            String.valueOf(l)
        }) == 1;
    }

    public r a(long l, com.cyberlink.youcammakeup.database.m m1)
    {
        ContentValues contentvalues = m1.v();
        if (e.update("Image", contentvalues, "_id=?", new String[] {
    String.valueOf(l)
}) != 1)
        {
            return null;
        }
        try
        {
            m1 = new r(l, m1);
        }
        // Misplaced declaration of an exception variable
        catch (com.cyberlink.youcammakeup.database.m m1)
        {
            return null;
        }
        return m1;
    }

    public r a(long l, q q1)
    {
        r r1 = d(l);
        if (r1 == null)
        {
            q1.a = (new StringBuilder()).append("imageObj == null. image ID=").append(l).toString();
        } else
        if (!r1.u())
        {
            return s.a(r1, q1);
        }
        return r1;
    }

    public r a(com.cyberlink.youcammakeup.database.m m1)
    {
        ContentValues contentvalues = m1.v();
        contentvalues.remove("_id");
        long l;
        try
        {
            l = e.insert("Image", null, contentvalues);
        }
        // Misplaced declaration of an exception variable
        catch (com.cyberlink.youcammakeup.database.m m1)
        {
            return null;
        }
        if (l < 0L)
        {
            return null;
        }
        m1 = new r(l, m1);
        return m1;
    }

    public r a(r r1)
    {
        return a(((com.cyberlink.youcammakeup.database.m) (r1)));
    }

    public Long a(long l)
    {
        r r1 = d(l);
        if (r1 == null)
        {
            return null;
        } else
        {
            return Long.valueOf(r1.f());
        }
    }

    public AbstractMap a(String s1)
    {
        HashMap hashmap;
        hashmap = new HashMap();
        if (s1 != "_id" && s1 != "FileID")
        {
            return hashmap;
        }
        Cursor cursor;
        System.currentTimeMillis();
        cursor = d.query("Image", b, null, null, null, null, null, null);
        if (cursor == null)
        {
            if (cursor != null)
            {
                cursor.close();
            }
            return hashmap;
        }
        boolean flag = cursor.moveToFirst();
        if (!flag)
        {
            if (cursor != null)
            {
                cursor.close();
            }
            return hashmap;
        }
        int l;
        int i1;
        i1 = cursor.getColumnIndex("_id");
        l = cursor.getColumnIndex("FileID");
        if (i1 < 0 || l < 0)
        {
            if (cursor != null)
            {
                cursor.close();
            }
            return hashmap;
        }
        HashMap hashmap1;
        System.currentTimeMillis();
        cursor.getCount();
        hashmap1 = new HashMap();
        int j1;
        long l1;
        long l2;
        if (s1.equals("_id"))
        {
            j1 = i1;
        } else
        {
            j1 = l;
        }
        if (s1.equals("_id"))
        {
            i1 = l;
        }
_L2:
        l1 = cursor.getLong(j1);
        l2 = cursor.getLong(i1);
        if (!hashmap1.containsKey(Long.valueOf(l1)))
        {
            break MISSING_BLOCK_LABEL_257;
        }
        ((Long)hashmap1.get(Long.valueOf(l1))).longValue();
_L3:
        flag = cursor.moveToNext();
        if (flag) goto _L2; else goto _L1
_L1:
        if (cursor != null)
        {
            cursor.close();
        }
        return hashmap1;
        hashmap1.put(Long.valueOf(l1), Long.valueOf(l2));
          goto _L3
        s1;
_L7:
        if (cursor != null)
        {
            cursor.close();
        }
        return hashmap;
        s1;
        cursor = null;
_L5:
        if (cursor != null)
        {
            cursor.close();
        }
        throw s1;
        s1;
        if (true) goto _L5; else goto _L4
_L4:
        s1;
        cursor = null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public boolean a(long l, long l1)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("HistorySettingsID", Long.valueOf(l1));
        return e.update("Image", contentvalues, "_id=?", new String[] {
            String.valueOf(l)
        }) == 1;
    }

    public long[] a(long al[])
    {
        boolean flag = false;
        AbstractMap abstractmap = a("FileID");
        ArrayList arraylist = new ArrayList(al.length);
        for (int l = 0; l < al.length; l++)
        {
            long l1 = al[l];
            Long long2 = (Long)abstractmap.get(Long.valueOf(l1));
            Long long1 = long2;
            if (long2 == null)
            {
                long1 = Long.valueOf(a(new com.cyberlink.youcammakeup.database.m(l1)).w());
            }
            arraylist.add(long1);
        }

        al = new long[arraylist.size()];
        Iterator iterator = arraylist.iterator();
        for (int i1 = ((flag) ? 1 : 0); i1 < al.length; i1++)
        {
            al[i1] = ((Long)iterator.next()).longValue();
        }

        return al;
    }

    public o b(long l)
    {
        return com.cyberlink.youcammakeup.c.e().b(a(l).longValue());
    }

    public String b(r r1)
    {
        r1 = com.cyberlink.youcammakeup.c.e().b(r1.f());
        if (r1 == null)
        {
            return null;
        } else
        {
            return r1.b();
        }
    }

    public r c(long l)
    {
        q q1 = new q();
        r r1 = a(l, q1);
        if (r1 == null)
        {
            m.e("database.ImageDao", (new StringBuilder()).append("ImageDao.getAndReadProperty(long) == null. ").append(q1.a).toString());
        }
        return r1;
    }

    public String c(r r1)
    {
        if (r1 == null)
        {
            r1 = null;
        } else
        {
            long l = r1.w();
            Object obj = com.cyberlink.youcammakeup.c.d().c(l);
            if (obj != null)
            {
                obj = ((Collection) (obj)).iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    (new File((String)((Iterator) (obj)).next())).delete();
                }
            }
            r1 = b(r1);
            if (!k(l))
            {
                return null;
            }
        }
        return r1;
    }

    public r d(long l)
    {
        if (l == -5L)
        {
            return f;
        } else
        {
            return a("_id=?", new String[] {
                String.valueOf(l)
            });
        }
    }

    public r e(long l)
    {
        return a("FileID=?", new String[] {
            String.valueOf(l)
        });
    }

    public long f(long l)
    {
        Object obj1 = null;
        Object obj;
        System.currentTimeMillis();
        String as[] = c;
        String s1 = c.c;
        obj = d.query("Image", as, "FileID=?", new String[] {
            String.valueOf(l)
        }, null, null, null, s1);
        if (obj != null) goto _L2; else goto _L1
_L1:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        l = -1L;
_L4:
        return l;
_L2:
        long l1;
        if (((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_108;
        }
        l1 = a(new com.cyberlink.youcammakeup.database.m(l)).w();
        l = l1;
        if (obj == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj)).close();
        return l1;
        int i1 = ((Cursor) (obj)).getColumnIndex("_id");
        if (i1 < 0)
        {
            if (obj != null)
            {
                ((Cursor) (obj)).close();
            }
            return -1L;
        }
        if (((Cursor) (obj)).getCount() <= 1);
        l1 = ((Cursor) (obj)).getLong(i1);
        l = l1;
        if (obj == null) goto _L4; else goto _L5
_L5:
        ((Cursor) (obj)).close();
        return l1;
        obj;
        obj = null;
_L9:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return -1L;
        obj;
_L7:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw obj;
        Exception exception1;
        exception1;
        obj1 = obj;
        obj = exception1;
        if (true) goto _L7; else goto _L6
_L6:
        Exception exception;
        exception;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public String g(long l)
    {
        Object obj = com.cyberlink.youcammakeup.c.e();
        Long long1 = a(l);
        if (long1 != null)
        {
            if ((obj = ((n) (obj)).b(long1.longValue())) != null)
            {
                return ((o) (obj)).b();
            }
        }
        return null;
    }

    public String h(long l)
    {
        return c(d(l));
    }

    long i(long l)
    {
        Object obj1 = null;
        Object obj;
        System.currentTimeMillis();
        obj = c.c;
        obj = d.query("Image", new String[] {
            "HistorySettingsID"
        }, "_id=?", new String[] {
            String.valueOf(l)
        }, null, null, null, ((String) (obj)));
        if (obj != null) goto _L2; else goto _L1
_L1:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        l = -1L;
_L4:
        return l;
_L2:
        boolean flag = ((Cursor) (obj)).moveToFirst();
        if (!flag)
        {
            if (obj != null)
            {
                ((Cursor) (obj)).close();
            }
            return -1L;
        }
        int i1 = ((Cursor) (obj)).getColumnIndex("HistorySettingsID");
        if (i1 < 0)
        {
            if (obj != null)
            {
                ((Cursor) (obj)).close();
            }
            return -1L;
        }
        long l1;
        if (((Cursor) (obj)).getCount() <= 1);
        l1 = ((Cursor) (obj)).getLong(i1);
        l = l1;
        if (obj == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj)).close();
        return l1;
        obj;
        obj = null;
_L8:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return -1L;
        obj;
_L6:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw obj;
        Exception exception1;
        exception1;
        obj1 = obj;
        obj = exception1;
        if (true) goto _L6; else goto _L5
_L5:
        Exception exception;
        exception;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public boolean j(long l)
    {
        return a(l, -1L);
    }

}
