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
//            w, v

public final class u
{

    public static final String a[];
    private static final String z[];
    private Context b;
    private v c;
    private SQLiteDatabase d;

    public u(Context context)
    {
        b = context;
    }

    public static w a(Cursor cursor)
    {
        if (cursor == null || cursor.getCount() == 0)
        {
            x.c();
            return null;
        } else
        {
            w w1 = new w();
            w1.a(cursor.getString(1));
            w1.b(cursor.getString(2));
            w1.c(cursor.getString(3));
            w1.d(cursor.getString(4));
            w1.e(cursor.getString(5));
            w1.a(cursor.getInt(6));
            w1.b(cursor.getInt(7));
            w1.c(cursor.getInt(8));
            w1.d(cursor.getInt(9));
            w1.e(cursor.getInt(10));
            w1.f(cursor.getInt(11));
            w1.toString();
            x.d();
            return w1;
        }
    }

    public final int a(boolean flag)
    {
        Object obj = z[4];
        if (flag)
        {
            obj = z[7];
        }
        obj = (new StringBuilder(z[6])).append(((String) (obj))).append(z[5]).toString();
        obj = d.rawQuery(((String) (obj)), null);
        if (obj != null)
        {
            ((Cursor) (obj)).moveToFirst();
            int i = ((Cursor) (obj)).getInt(0);
            ((Cursor) (obj)).close();
            return i;
        } else
        {
            return 0;
        }
    }

    public final long a(String s, String s1, String s2, String s3, String s4, int i, int j, 
            int k, int l, int i1, int j1)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(z[18], s);
        contentvalues.put(z[11], s1);
        contentvalues.put(z[17], s2);
        contentvalues.put(z[16], s3);
        contentvalues.put(z[10], s4);
        contentvalues.put(z[4], Integer.valueOf(i));
        contentvalues.put(z[7], Integer.valueOf(1));
        contentvalues.put(z[12], Integer.valueOf(k));
        contentvalues.put(z[15], Integer.valueOf(l));
        contentvalues.put(z[13], Integer.valueOf(i1));
        contentvalues.put(z[14], Integer.valueOf(0));
        return d.insert(z[8], null, contentvalues);
    }

    public final void a()
    {
        c = new v(b);
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

    public final boolean a(String s)
    {
label0:
        {
            String s1 = z[1];
            s = d.rawQuery(s1, new String[] {
                s
            });
            if (s != null)
            {
                s.moveToFirst();
                if (s.getInt(0) != 0)
                {
                    break label0;
                }
            }
            return false;
        }
        return true;
    }

    public final Cursor b(String s)
    {
        s = (new StringBuilder(z[9])).append(s).append("'").toString();
        s = d.query(true, z[8], a, s, null, null, null, null, null);
        if (s != null)
        {
            s.moveToFirst();
        }
        return s;
    }

    public final void b()
    {
        d.close();
    }

    public final boolean b(String s, String s1, String s2, String s3, String s4, int i, int j, 
            int k, int l, int i1, int j1)
    {
        String s5 = (new StringBuilder(z[9])).append(s).append("'").toString();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(z[18], s);
        contentvalues.put(z[11], s1);
        contentvalues.put(z[17], s2);
        contentvalues.put(z[16], s3);
        contentvalues.put(z[10], s4);
        contentvalues.put(z[4], Integer.valueOf(i));
        contentvalues.put(z[7], Integer.valueOf(j));
        contentvalues.put(z[12], Integer.valueOf(k));
        contentvalues.put(z[15], Integer.valueOf(l));
        contentvalues.put(z[13], Integer.valueOf(i1));
        contentvalues.put(z[14], Integer.valueOf(j1));
        return d.update(z[8], contentvalues, s5, null) > 0;
    }

    public final void c()
    {
        String s = z[0];
        d.execSQL(s);
    }

    public final Cursor d()
    {
        Object obj = z[2];
        obj = d.rawQuery(((String) (obj)), null);
        if (obj != null)
        {
            ((Cursor) (obj)).moveToFirst();
        }
        return ((Cursor) (obj));
    }

    public final Cursor e()
    {
        Object obj = z[3];
        obj = d.rawQuery(((String) (obj)), null);
        if (obj != null)
        {
            ((Cursor) (obj)).moveToFirst();
        }
        return ((Cursor) (obj));
    }

    static 
    {
        Object obj;
        Object obj1;
        String as[];
        byte byte0;
        int i;
        obj = new String[19];
        i = 0;
        obj1 = "8\027\005\036\0049R\017\t\0371R\003\013\005/\0326\b\004=\006\000\b\0045\021\032";
        byte0 = -1;
        as = ((String []) (obj));
_L31:
        Object aobj[];
        String as1[];
        char ac[];
        int j;
        int k;
        int l;
        int i1;
        byte byte2;
        int j1;
        ac = ((String) (obj1)).toCharArray();
        j = ac.length;
        i1 = 0;
        k = 0;
        byte2 = byte0;
        obj1 = ac;
        j1 = i;
        as1 = ((String []) (obj));
        aobj = as;
        l = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L10:
        l = k;
_L8:
        aobj = ((Object []) (obj));
        i1 = ((int) (aobj[k]));
        l % 5;
        JVM INSTR tableswitch 0 3: default 116
    //                   0 769
    //                   1 776
    //                   2 783
    //                   3 790;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        byte0 = 112;
_L32:
label0:
        {
            aobj[k] = (char)(byte0 ^ i1);
            l++;
            if (j != 0)
            {
                break label0;
            }
            k = j;
        }
          goto _L8
        i1 = l;
        l = j;
        aobj = as;
        as1 = as2;
        j1 = i;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i = j1;
        as2 = as1;
        as = ((String []) (aobj));
        j = l;
        k = i1;
        if (l > i1) goto _L10; else goto _L9
_L9:
        obj = (new String(((char []) (obj1)))).intern();
        byte2;
        JVM INSTR tableswitch 0 18: default 308
    //                   0 330
    //                   1 352
    //                   2 374
    //                   3 396
    //                   4 418
    //                   5 441
    //                   6 465
    //                   7 489
    //                   8 513
    //                   9 537
    //                   10 561
    //                   11 585
    //                   12 609
    //                   13 633
    //                   14 657
    //                   15 681
    //                   16 705
    //                   17 729
    //                   18 797;
           goto _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30
_L11:
        as1[j1] = ((String) (obj));
        i = 1;
        obj1 = "/\027\005\036\023(R*4%\022&A\b\004\003\001\006\t\004\003\031\f\002Y|\024\033\024\035|\030\031\016\0034-\032\017\021(\033\032\017\031?\001I\f\0309\000\f[\003(-\032\024\002(-\002\036\t|OID";
        byte0 = 0;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L31
_L12:
        as1[j1] = ((String) (obj));
        i = 2;
        obj1 = "/\027\005\036\023(RC[\026.\035\004[\032,\007\032\023//\006\b\017\031/\006\000\030\003|\005\001\036\0029R\032\017/:\023\000\027\0258RW[@|R\006\t\0249\000I\031\t|\001\035$\026=\033\005\036\024|\026\f\b\023|\036\000\026\031(RZ";
        byte0 = 1;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L31
_L13:
        as1[j1] = ((String) (obj));
        i = 3;
        obj1 = "/\027\005\036\023(RC[\026.\035\004[\032,\007\032\023//\006\b\017\031/\006\000\030\003|\005\001\036\0029R\032\017/(\035\035\032\034|LIKP=\034\r[\003(-\017\032\0310\027\r[M|BI[\037.\026\f\tP>\013I\b\004\003\006\006\017\0210R\r\036\003?R\005\022\0355\006IH";
        byte0 = 2;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L31
_L14:
        as1[j1] = ((String) (obj));
        i = 4;
        obj1 = "/\0066\035\0215\036\f\037";
        byte0 = 3;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L31
_L15:
        as1[j1] = ((String) (obj));
        i = 5;
        obj1 = "uR\017\t\0371R\003\013\005/\0326\b\004=\006\000\b\0045\021\032";
        byte0 = 4;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L31
_L16:
        as1[j1] = ((String) (obj));
        i = 6;
        obj1 = "/\027\005\036\023(R:.=t";
        byte0 = 5;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L31
_L17:
        as1[j1] = ((String) (obj));
        i = 7;
        obj1 = "/\0066\017\037(\023\005";
        byte0 = 6;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L31
_L18:
        as1[j1] = ((String) (obj));
        i = 8;
        obj1 = "6\002\034\b\030\003\001\035\032\0045\001\035\022\023/";
        byte0 = 7;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L31
_L19:
        as1[j1] = ((String) (obj));
        i = 9;
        obj1 = "/\0066\b\037.\0066\020\025%ON";
        byte0 = 8;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L31
_L20:
        as1[j1] = ((String) (obj));
        i = 10;
        obj1 = "/\0066\b\037)\000\n\036";
        byte0 = 9;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L31
_L21:
        as1[j1] = ((String) (obj));
        i = 11;
        obj1 = "/\0066\025\025(";
        byte0 = 10;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L31
_L22:
        as1[j1] = ((String) (obj));
        i = 12;
        obj1 = "/\0066\030\037)\034\035$A";
        byte0 = 11;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L31
_L23:
        as1[j1] = ((String) (obj));
        i = 13;
        obj1 = "/\0066\030\037)\034\035$C\003CY";
        byte0 = 12;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L31
_L24:
        as1[j1] = ((String) (obj));
        i = 14;
        obj1 = "/\0066\030\037)\034\035$Al";
        byte0 = 13;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L31
_L25:
        as1[j1] = ((String) (obj));
        i = 15;
        obj1 = "/\0066\030\037)\034\035$A\003A";
        byte0 = 14;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L31
_L26:
        as1[j1] = ((String) (obj));
        i = 16;
        obj1 = "/\0066\027\037?\023\005$\0242\001";
        byte0 = 15;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L31
_L27:
        as1[j1] = ((String) (obj));
        i = 17;
        obj1 = "/\0066\030\0372\0346\022\0";
        byte0 = 16;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L31
_L28:
        as1[j1] = ((String) (obj));
        i = 18;
        obj1 = "/\0066\b\037.\0066\020\025%";
        byte0 = 17;
        obj = ((Object) (aobj));
        as = ((String []) (aobj));
          goto _L31
_L29:
        as1[j1] = ((String) (obj));
        z = ((String []) (aobj));
        obj = new String[12];
        obj[0] = z[18];
        i = 1;
        obj1 = "\003\033\r";
        byte0 = 18;
        as = ((String []) (obj));
          goto _L31
_L4:
        byte0 = 92;
          goto _L32
_L5:
        byte0 = 114;
          goto _L32
_L6:
        byte0 = 105;
          goto _L32
_L7:
        byte0 = 123;
          goto _L32
_L30:
        as1[j1] = ((String) (obj));
        aobj[2] = z[11];
        aobj[3] = z[17];
        aobj[4] = z[16];
        aobj[5] = z[10];
        aobj[6] = z[4];
        aobj[7] = z[7];
        aobj[8] = z[12];
        aobj[9] = z[15];
        aobj[10] = z[13];
        aobj[11] = z[14];
        a = ((String []) (aobj));
          goto _L8
    }
}
