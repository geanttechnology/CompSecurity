// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cn.jpush.android.util.x;

public final class r extends SQLiteOpenHelper
{

    private static r a;
    private static final String z[];

    private r(Context context)
    {
        super(context, z[4], null, 3);
    }

    public static Cursor a(Context context)
    {
        try
        {
            context = c(context).getWritableDatabase();
            String s = z[5];
            String s1 = z[1];
            String s2 = z[7];
            String s3 = z[6];
            String s4 = z[1];
            context = context.query(s, new String[] {
                s1, s2, s3
            }, null, null, null, null, s4);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            x.h();
            return null;
        }
        return context;
    }

    public static boolean a(Context context, int i)
    {
        boolean flag = false;
        try
        {
            i = c(context).getWritableDatabase().delete(z[5], (new StringBuilder(z[3])).append(i).toString(), null);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            x.h();
            return false;
        }
        if (i > 0)
        {
            flag = true;
        }
        return flag;
    }

    public static boolean a(Context context, String s)
    {
        long l;
        try
        {
            context = c(context).getWritableDatabase();
            ContentValues contentvalues = new ContentValues();
            contentvalues.put(z[2], s);
            l = context.insert(z[0], z[1], contentvalues);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            x.h();
            return false;
        }
        return l > 0L;
    }

    public static boolean a(Context context, String s, String s1)
    {
        long l;
        try
        {
            context = c(context).getWritableDatabase();
            ContentValues contentvalues = new ContentValues();
            contentvalues.put(z[6], s);
            contentvalues.put(z[7], s1);
            l = context.insert(z[5], z[1], contentvalues);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            x.h();
            return false;
        }
        return l > 0L;
    }

    public static Cursor b(Context context)
    {
        try
        {
            context = c(context).getWritableDatabase();
            String s = z[0];
            String s1 = z[1];
            String s2 = z[2];
            String s3 = z[1];
            context = context.query(s, new String[] {
                s1, s2
            }, null, null, null, null, s3);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            x.h();
            return null;
        }
        return context;
    }

    public static boolean b(Context context, int i)
    {
        boolean flag = false;
        try
        {
            i = c(context).getWritableDatabase().delete(z[0], (new StringBuilder(z[3])).append(i).toString(), null);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            x.h();
            return false;
        }
        if (i > 0)
        {
            flag = true;
        }
        return flag;
    }

    private static r c(Context context)
    {
        if (a == null)
        {
            a = new r(context);
        }
        return a;
    }

    public final void onCreate(SQLiteDatabase sqlitedatabase)
    {
        x.d();
        sqlitedatabase.execSQL(z[13]);
        sqlitedatabase.execSQL(z[12]);
    }

    public final void onDowngrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            super.onDowngrade(sqlitedatabase, i, j);
        }
        (new StringBuilder(z[10])).append(i).append(z[8]).append(j).toString();
        x.c();
        sqlitedatabase.execSQL(z[9]);
        sqlitedatabase.execSQL(z[11]);
        onCreate(sqlitedatabase);
    }

    public final void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        (new StringBuilder(z[10])).append(i).append(z[8]).append(j).toString();
        x.c();
        sqlitedatabase.execSQL(z[9]);
        sqlitedatabase.execSQL(z[11]);
        onCreate(sqlitedatabase);
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i;
        as = new String[14];
        i = 0;
        obj1 = "\034\023\004c\000\t\022\030Y";
        byte0 = -1;
        obj = as;
_L12:
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
        l = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        l = k;
_L9:
        obj1 = obj;
        i1 = obj1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 544
    //                   1 551
    //                   2 558
    //                   3 565;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_565;
_L3:
        byte0 = 116;
_L13:
label0:
        {
            obj1[k] = (char)(byte0 ^ i1);
            l++;
            if (j != 0)
            {
                break label0;
            }
            k = j;
        }
        if (true) goto _L9; else goto _L8
        i1 = l;
        l = j;
        as1 = as2;
        j1 = i;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i = j1;
        as2 = as1;
        j = l;
        k = i1;
        if (l > i1) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[j1] = ((String) (obj));
            i = 1;
            obj1 = "\032\025\004c\035\f";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j1] = ((String) (obj));
            i = 2;
            obj1 = "\034\023\004c\020\t\004\025";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j1] = ((String) (obj));
            i = 3;
            obj1 = "\032\025\004c\035\fM";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j1] = ((String) (obj));
            i = 4;
            obj1 = "\032\025\004\022\020\n";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j1] = ((String) (obj));
            i = 5;
            obj1 = "\032\025\004c\000\t\022\030Y";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[j1] = ((String) (obj));
            i = 6;
            obj1 = "\032\025\004c\004\032\025\022U\f";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[j1] = ((String) (obj));
            i = 7;
            obj1 = "\032\025\004c\020\t\004\025";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[j1] = ((String) (obj));
            i = 8;
            obj1 = "H\004\034YT\006\025\003j\021\032\003\035S\032H\031\007\034NH";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[j1] = ((String) (obj));
            i = 9;
            obj1 = "\f\002\033LT\034\021\026P\021H92\034109'h'H\002\021L+\034\021\026P\021";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[j1] = ((String) (obj));
            i = 10;
            obj1 = "<\030\021\034\033\004\024\"Y\006\033\031\033RT\001\003N\034";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[j1] = ((String) (obj));
            i = 11;
            obj1 = "\f\002\033LT\034\021\026P\021H92\034109'h'H\004\027L+\034\021\026P\021";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[j1] = ((String) (obj));
            i = 12;
            obj1 = "+\"1} -P }6$5TH\027\030/\000]\026\004\025T\024\006\r\000+U\020H\031\032H\021\017\025\006\034\004\032\031\031]\006\021P\037Y\rH\021\001H\033\001\036\027N\021\005\025\032HX\034\023\004c\020\t\004\025\034 -( \025";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[j1] = ((String) (obj));
            i = 13;
            obj1 = "+\"1} -P }6$5TN\021\030/\000]\026\004\025T\024\006\r\000+U\020H\031\032H\021\017\025\006\034\004\032\031\031]\006\021P\037Y\rH\021\001H\033\001\036\027N\021\005\025\032HX\032\025\004c\004\032\025\022U\fH$1d D\002\021L+\f\021\000]T<5,h]";
            byte0 = 12;
            obj = as;
            break;

        case 12: // '\f'
            as1[j1] = ((String) (obj));
            z = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 104;
          goto _L13
_L5:
        byte0 = 112;
          goto _L13
_L6:
        byte0 = 116;
          goto _L13
        byte0 = 60;
          goto _L13
    }
}
