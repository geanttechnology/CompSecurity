// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.jpush.android.util.x;

// Referenced classes of package cn.jpush.android.data:
//            k, j

public final class i
{

    public static final String a[];
    private static final String z[];
    private Context b;
    private j c;
    private SQLiteDatabase d;

    public i(Context context)
    {
        b = context;
    }

    public static void a(Cursor cursor, k k1)
    {
        if (cursor == null || cursor.getCount() == 0)
        {
            x.c();
            return;
        }
        k k2 = k1;
        if (k1 == null)
        {
            k2 = new k();
        }
        k2.a(cursor.getInt(1));
        k2.b(cursor.getInt(2));
        k2.c(cursor.getInt(3));
        k2.d(cursor.getInt(4));
        k2.a(cursor.getString(5));
        k2.b(cursor.getLong(6));
        k2.a(cursor.getLong(7));
        k2.toString();
        x.d();
    }

    public final long a(long l, int i1, int j1, int k1, String s, long l1, long l2)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(z[7], Long.valueOf(l));
        contentvalues.put(z[5], Integer.valueOf(1));
        contentvalues.put(z[3], Integer.valueOf(0));
        contentvalues.put(z[2], Integer.valueOf(0));
        contentvalues.put(z[1], s);
        contentvalues.put(z[6], Long.valueOf(l1));
        contentvalues.put(z[0], Long.valueOf(l2));
        return d.insert(z[4], null, contentvalues);
    }

    public final Cursor a(int l, long l1)
    {
        Object obj = (new StringBuilder(z[14])).append(1).append(z[11]).append("<").append(l1).toString();
        obj = d.query(true, z[4], a, ((String) (obj)), null, null, null, null, null);
        if (obj != null)
        {
            ((Cursor) (obj)).moveToFirst();
        }
        return ((Cursor) (obj));
    }

    public final Cursor a(long l, int i1)
    {
        Object obj = (new StringBuilder(z[8])).append(l).append(z[10]).append(z[9]).toString();
        obj = d.query(true, z[4], a, ((String) (obj)), null, null, null, null, null);
        if (obj != null)
        {
            ((Cursor) (obj)).moveToFirst();
        }
        return ((Cursor) (obj));
    }

    public final Cursor a(long l, long l1)
    {
        Object obj = (new StringBuilder(z[12])).append(0x493e0L + l).append(z[11]).append(">").append(l).toString();
        obj = d.query(true, z[4], a, ((String) (obj)), null, null, null, null, null);
        if (obj != null)
        {
            ((Cursor) (obj)).moveToFirst();
        }
        return ((Cursor) (obj));
    }

    public final void a()
    {
        c = new j(b);
        try
        {
            d = c.getWritableDatabase();
            return;
        }
        catch (Exception exception)
        {
            d = c.getReadableDatabase();
        }
    }

    public final void b()
    {
        d.close();
    }

    public final boolean b(long l, int i1, int j1, int k1, String s, long l1, long l2)
    {
        String s1 = (new StringBuilder(z[8])).append(l).toString();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(z[7], Long.valueOf(l));
        contentvalues.put(z[5], Integer.valueOf(i1));
        contentvalues.put(z[3], Integer.valueOf(j1));
        contentvalues.put(z[2], Integer.valueOf(0));
        contentvalues.put(z[1], s);
        contentvalues.put(z[6], Long.valueOf(l1));
        contentvalues.put(z[0], Long.valueOf(l2));
        return d.update(z[4], contentvalues, s1, null) > 0;
    }

    public final boolean c()
    {
        String s = z[13];
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(z[5], Integer.valueOf(0));
        contentvalues.put(z[3], Integer.valueOf(1));
        contentvalues.put(z[2], Integer.valueOf(0));
        return d.update(z[4], contentvalues, s, null) > 0;
    }

    static 
    {
        Object obj;
        Object obj1;
        String as[];
        byte byte0;
        int l;
        obj = new String[15];
        l = 0;
        obj1 = "\004\r8vm\f<\023~d\r";
        byte0 = -1;
        as = ((String []) (obj));
_L27:
        Object aobj[];
        String as1[];
        char ac[];
        int i1;
        int j1;
        int k1;
        int l1;
        byte byte2;
        int i2;
        ac = ((String) (obj1)).toCharArray();
        i1 = ac.length;
        l1 = 0;
        j1 = 0;
        byte2 = byte0;
        obj1 = ac;
        i2 = l;
        as1 = ((String []) (obj));
        aobj = as;
        k1 = i1;
        if (i1 > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L10:
        k1 = j1;
_L8:
        aobj = ((Object []) (obj));
        l1 = ((int) (aobj[j1]));
        k1 % 5;
        JVM INSTR tableswitch 0 3: default 116
    //                   0 648
    //                   1 655
    //                   2 662
    //                   3 669;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        byte0 = 9;
_L28:
label0:
        {
            aobj[j1] = (char)(byte0 ^ l1);
            k1++;
            if (i1 != 0)
            {
                break label0;
            }
            j1 = i1;
        }
          goto _L8
        l1 = k1;
        k1 = i1;
        aobj = as;
        as1 = as2;
        i2 = l;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        l = i2;
        as2 = as1;
        as = ((String []) (aobj));
        i1 = k1;
        j1 = l1;
        if (k1 > l1) goto _L10; else goto _L9
_L9:
        obj = (new String(((char []) (obj1)))).intern();
        byte2;
        JVM INSTR tableswitch 0 14: default 292
    //                   0 314
    //                   1 336
    //                   2 358
    //                   3 380
    //                   4 402
    //                   5 425
    //                   6 449
    //                   7 473
    //                   8 497
    //                   9 521
    //                   10 545
    //                   11 569
    //                   12 593
    //                   13 617
    //                   14 676;
           goto _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26
_L11:
        as1[i2] = ((String) (obj));
        l = 1;
        obj1 = "\004\r8rq\034\021\006";
        byte0 = 0;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L27
_L12:
        as1[i2] = ((String) (obj));
        l = 2;
        obj1 = "\004\r8cp\030\006";
        byte0 = 1;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L27
_L13:
        as1[i2] = ((String) (obj));
        l = 3;
        obj1 = "\004\r8el\005\f\021r";
        byte0 = 2;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L27
_L14:
        as1[i2] = ((String) (obj));
        l = 4;
        obj1 = "\034<\013xj\t\017\tx}\001\005\016th\034\n\by";
        byte0 = 3;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L27
_L15:
        as1[i2] = ((String) (obj));
        l = 5;
        obj1 = "\004\r8tf\035\r\023";
        byte0 = 4;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L27
_L16:
        as1[i2] = ((String) (obj));
        l = 6;
        obj1 = "\004\r8c{\001\004\000r{7\027\016zl";
        byte0 = 5;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L27
_L17:
        as1[i2] = ((String) (obj));
        l = 7;
        obj1 = "\004\r8~m";
        byte0 = 6;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L27
_L18:
        as1[i2] = ((String) (obj));
        l = 8;
        obj1 = "\004\r8~mU";
        byte0 = 7;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L27
_L19:
        as1[i2] = ((String) (obj));
        l = 9;
        obj1 = "US";
        byte0 = 8;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L27
_L20:
        as1[i2] = ((String) (obj));
        l = 10;
        obj1 = "H\002\ts)\004\r8cp\030\006";
        byte0 = 9;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L27
_L21:
        as1[i2] = ((String) (obj));
        l = 11;
        obj1 = "H\002\ts)\004\r8c{\001\004\000r{7\027\016zl";
        byte0 = 10;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L27
_L22:
        as1[i2] = ((String) (obj));
        l = 12;
        obj1 = "\004\r8tf\035\r\023)9H\002\ts)\004\r8c{\001\004\000r{7\027\016zlT";
        byte0 = 11;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L27
_L23:
        as1[i2] = ((String) (obj));
        l = 13;
        obj1 = "\004\r8tf\035\r\023)9";
        byte0 = 12;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L27
_L24:
        as1[i2] = ((String) (obj));
        l = 14;
        obj1 = "\004\r8tf\035\r\023*";
        byte0 = 13;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L27
_L25:
        as1[i2] = ((String) (obj));
        z = ((String []) (aobj));
        obj = new String[8];
        l = 0;
        obj1 = "7\n\003";
        byte0 = 14;
        as = ((String []) (obj));
          goto _L27
_L4:
        byte0 = 104;
          goto _L28
_L5:
        byte0 = 99;
          goto _L28
_L6:
        byte0 = 103;
          goto _L28
_L7:
        byte0 = 23;
          goto _L28
_L26:
        as1[i2] = ((String) (obj));
        aobj[1] = z[7];
        aobj[2] = z[5];
        aobj[3] = z[3];
        aobj[4] = z[2];
        aobj[5] = z[1];
        aobj[6] = z[6];
        aobj[7] = z[0];
        a = ((String []) (aobj));
          goto _L8
    }
}
