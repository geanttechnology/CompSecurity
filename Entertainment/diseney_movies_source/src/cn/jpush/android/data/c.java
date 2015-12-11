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

// Referenced classes of package cn.jpush.android.data:
//            d

public final class c extends SQLiteOpenHelper
{

    public static final String a[];
    public static final String b[];
    private static c c;
    private static final String z[];

    private c(Context context)
    {
        super(context, z[6], null, 3);
    }

    private static c a(Context context)
    {
        if (c == null)
        {
            c = new c(context);
        }
        return c;
    }

    public static String a(Context context, String s)
    {
        SQLiteDatabase sqlitedatabase = a(context).getWritableDatabase();
        Cursor cursor = sqlitedatabase.query(z[4], b, null, null, null, null, null);
        if (cursor == null) goto _L2; else goto _L1
_L1:
        if (cursor.getCount() < 0) goto _L2; else goto _L3
_L3:
        if (!cursor.moveToNext()) goto _L2; else goto _L4
_L4:
        String s1;
        String s2;
        String s3;
        boolean flag;
        s1 = cursor.getString(cursor.getColumnIndex(z[1]));
        context = cursor.getString(cursor.getColumnIndex(z[3]));
        s2 = cursor.getString(cursor.getColumnIndex(z[2]));
        s3 = cursor.getString(cursor.getColumnIndex(z[5]));
        flag = s.endsWith(s1);
        if (!flag) goto _L3; else goto _L5
_L5:
        s = s3;
_L12:
        sqlitedatabase.delete(z[4], z[0], new String[] {
            s1
        });
        s = (new StringBuilder()).append(context).append(",").append(s2).append(",").append(s).toString();
        context = s;
        s = context;
        if (cursor != null)
        {
            cursor.close();
            s = context;
        }
_L7:
        return s;
        context;
        cursor = null;
        context = "";
_L10:
        s = context;
        if (cursor == null) goto _L7; else goto _L6
_L6:
        cursor.close();
        return context;
        context;
        cursor = null;
_L9:
        if (cursor != null)
        {
            cursor.close();
        }
        throw context;
        context;
        if (true) goto _L9; else goto _L8
_L8:
        context;
        context = "";
          goto _L10
        s;
          goto _L10
_L2:
        s = "";
        s1 = "";
        s2 = "";
        context = "";
        if (true) goto _L12; else goto _L11
_L11:
    }

    public static void a(Context context, d d1, String s, String s1)
    {
        String s2;
        SQLiteDatabase sqlitedatabase;
        s2 = d1.c;
        d1 = d1.d;
        sqlitedatabase = a(context).getWritableDatabase();
        context = sqlitedatabase.query(z[4], b, z[0], new String[] {
            s
        }, null, null, null);
        if (context == null) goto _L2; else goto _L1
_L1:
        if (context.getCount() > 0) goto _L3; else goto _L2
_L2:
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(z[3], s2);
        contentvalues.put(z[1], s);
        contentvalues.put(z[2], s1);
        contentvalues.put(z[5], d1);
        sqlitedatabase.insert(z[4], null, contentvalues);
_L4:
        if (context != null)
        {
            context.close();
        }
_L6:
        return;
_L3:
        context.moveToFirst();
        ContentValues contentvalues1 = new ContentValues();
        contentvalues1.put(z[3], s2);
        contentvalues1.put(z[2], s1);
        contentvalues1.put(z[5], d1);
        sqlitedatabase.update(z[4], contentvalues1, z[0], new String[] {
            s
        });
          goto _L4
        d1;
_L9:
        if (context == null) goto _L6; else goto _L5
_L5:
        context.close();
        return;
        d1;
        context = null;
_L8:
        if (context != null)
        {
            context.close();
        }
        throw d1;
        d1;
        if (true) goto _L8; else goto _L7
_L7:
        context;
        context = null;
          goto _L9
    }

    public final void onCreate(SQLiteDatabase sqlitedatabase)
    {
        x.c();
        sqlitedatabase.execSQL(z[7]);
        sqlitedatabase.execSQL(z[8]);
    }

    public final void onDowngrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            super.onDowngrade(sqlitedatabase, i, j);
        }
        (new StringBuilder(z[9])).append(i).append(z[12]).append(j).toString();
        x.c();
        sqlitedatabase.execSQL(z[10]);
        sqlitedatabase.execSQL(z[11]);
        onCreate(sqlitedatabase);
    }

    public final void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        (new StringBuilder(z[9])).append(i).append(z[12]).append(j).toString();
        x.c();
        sqlitedatabase.execSQL(z[10]);
        sqlitedatabase.execSQL(z[11]);
        onCreate(sqlitedatabase);
    }

    static 
    {
        Object obj;
        Object obj1;
        String as1[];
        byte byte0;
        int i;
        obj = new String[13];
        i = 0;
        obj1 = "m\027\"c\025hZm";
        byte0 = -1;
        as1 = ((String []) (obj));
_L13:
        String as[];
        String as2[];
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
        as2 = ((String []) (obj));
        as = as1;
        l = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        String as3[];
        byte byte1;
        as3 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L10:
        l = k;
_L9:
        obj1 = obj;
        i1 = obj1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 116
    //                   0 612
    //                   1 619
    //                   2 626
    //                   3 633;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_633;
_L3:
        byte0 = 124;
_L11:
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
        as = as1;
        as2 = as3;
        j1 = i;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i = j1;
        as3 = as2;
        as1 = as;
        j = l;
        k = i1;
        if (l <= i1)
        {
            obj = (new String(((char []) (obj1)))).intern();
            switch (byte2)
            {
            default:
                as2[j1] = ((String) (obj));
                i = 1;
                obj1 = "m\027\"c\025h";
                byte0 = 0;
                obj = as;
                as1 = as;
                continue; /* Loop/switch isn't completed */

            case 0: // '\0'
                as2[j1] = ((String) (obj));
                i = 2;
                obj1 = "a\006;R#e\003";
                byte0 = 1;
                obj = as;
                as1 = as;
                continue; /* Loop/switch isn't completed */

            case 1: // '\001'
                as2[j1] = ((String) (obj));
                i = 3;
                obj1 = "a\0245c\025h";
                byte0 = 2;
                obj = as;
                as1 = as;
                continue; /* Loop/switch isn't completed */

            case 2: // '\002'
                as2[j1] = ((String) (obj));
                i = 4;
                obj1 = "y\027>U\017x";
                byte0 = 3;
                obj = as;
                as1 = as;
                continue; /* Loop/switch isn't completed */

            case 3: // '\003'
                as2[j1] = ((String) (obj));
                i = 5;
                obj1 = "c\0217N\016e\0037c\025h";
                byte0 = 4;
                obj = as;
                as1 = as;
                continue; /* Loop/switch isn't completed */

            case 4: // '\004'
                as2[j1] = ((String) (obj));
                i = 6;
                obj1 = "\177\002 J\025o\002|X\036";
                byte0 = 5;
                obj = as;
                as1 = as;
                continue; /* Loop/switch isn't completed */

            case 5: // '\005'
                as2[j1] = ((String) (obj));
                i = 7;
                obj1 = "o\0257]\biG&]\036`\002rX\023{\t>U\017xO\rU\030,\016<H\031k\002 \034\f~\016?]\016uG9Y\005,\006'H\023e\t1N\031a\002<HPa\0245c\025hG&Y\004xK Y\fi\006&c\022y\nrU\022x\0025Y\016 \024&]\016x8\"S\017,\016<H\031k\002 \020\031b\003\rL\023\177G;R\bi\0007NPo\b<H\031b\023rH\031t\023{";
                byte0 = 6;
                obj = as;
                as1 = as;
                continue; /* Loop/switch isn't completed */

            case 6: // '\006'
                as2[j1] = ((String) (obj));
                i = 8;
                obj1 = "o\0257]\biG&]\036`\002rI\f`\016!HTS\0166\034\025b\0237[\031~G\"N\025a\006 E\\g\002+\034\035y\023=U\022o\0257Q\031b\023~Q\017k8;X\\x\002*HPm\027\"c\025hG&Y\004xK?]\025b8;X\\x\002*HP,\b$Y\016~\0166Y#e\003rH\031t\023{";
                byte0 = 7;
                obj = as;
                as1 = as;
                continue; /* Loop/switch isn't completed */

            case 7: // '\007'
                as2[j1] = ((String) (obj));
                i = 9;
                obj1 = "X\0177\034\023`\003\004Y\016\177\016=R\\e\024h\034";
                byte0 = 8;
                obj = as;
                as1 = as;
                continue; /* Loop/switch isn't completed */

            case 8: // '\b'
                as2[j1] = ((String) (obj));
                i = 10;
                obj1 = "h\025=L\\x\0060P\031,\003=K\022`\016!H";
                byte0 = 9;
                obj = as;
                as1 = as;
                continue; /* Loop/switch isn't completed */

            case 9: // '\t'
                as2[j1] = ((String) (obj));
                i = 11;
                obj1 = "h\025=L\\x\0060P\031,\022\"P\025\177\023";
                byte0 = 10;
                obj = as;
                as1 = as;
                continue; /* Loop/switch isn't completed */

            case 10: // '\n'
                as2[j1] = ((String) (obj));
                i = 12;
                obj1 = ",\023:Y\\b\002%j\031~\024;S\022,\016!\034F,";
                byte0 = 11;
                obj = as;
                as1 = as;
                continue; /* Loop/switch isn't completed */

            case 11: // '\013'
                as2[j1] = ((String) (obj));
                z = as;
                obj = new String[6];
                i = 0;
                obj1 = "S\0166";
                byte0 = 12;
                as1 = ((String []) (obj));
                continue; /* Loop/switch isn't completed */

            case 12: // '\f'
                as2[j1] = ((String) (obj));
                as[1] = z[3];
                i = 2;
                obj1 = "~\002\"Y\035x8<I\021";
                byte0 = 13;
                obj = as;
                as1 = as;
                continue; /* Loop/switch isn't completed */

            case 13: // '\r'
                as2[j1] = ((String) (obj));
                i = 3;
                obj1 = "\177\0233N\bS\027=O";
                byte0 = 14;
                obj = as;
                as1 = as;
                continue; /* Loop/switch isn't completed */

            case 14: // '\016'
                as2[j1] = ((String) (obj));
                i = 4;
                obj1 = "i\t6c\fc\024";
                byte0 = 15;
                obj = as;
                as1 = as;
                continue; /* Loop/switch isn't completed */

            case 15: // '\017'
                as2[j1] = ((String) (obj));
                i = 5;
                obj1 = "o\b<H\031b\023";
                byte0 = 16;
                obj = as;
                as1 = as;
                continue; /* Loop/switch isn't completed */

            case 16: // '\020'
                as2[j1] = ((String) (obj));
                a = as;
                obj = new String[4];
                i = 0;
                obj1 = "S\0166";
                byte0 = 17;
                as1 = ((String []) (obj));
                continue; /* Loop/switch isn't completed */

            case 17: // '\021'
                as2[j1] = ((String) (obj));
                break;
            }
            break; /* Loop/switch isn't completed */
        }
          goto _L10
_L8:
        byte0 = 12;
          goto _L11
_L5:
        byte0 = 103;
          goto _L11
_L6:
        byte0 = 82;
          goto _L11
        byte0 = 60;
          goto _L11
        if (true) goto _L13; else goto _L12
_L12:
        as[1] = z[3];
        as[2] = z[1];
        as[3] = z[2];
        b = as;
    }
}
