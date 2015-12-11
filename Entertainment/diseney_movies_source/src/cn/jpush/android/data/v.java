// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cn.jpush.android.util.x;

final class v extends SQLiteOpenHelper
{

    private static final String z[];

    public v(Context context)
    {
        this(context, z[0], null, 1);
    }

    private v(Context context, String s, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory, int i)
    {
        super(context, s, null, 1);
    }

    public final void onCreate(SQLiteDatabase sqlitedatabase)
    {
        try
        {
            sqlitedatabase.execSQL(z[1]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            x.b();
        }
    }

    public final void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        sqlitedatabase.execSQL(z[2]);
        onCreate(sqlitedatabase);
    }

    static 
    {
        Object obj1;
        String as2[];
        int i;
        int j;
        as2 = new String[3];
        obj1 = "Ca4 7vb52+@b5:<Z?%1";
        i = -1;
        j = 0;
_L10:
        Object obj;
        String as[];
        int k;
        int l;
        int i1;
        int j1;
        obj = as2;
        obj1 = ((String) (obj1)).toCharArray();
        k = obj1.length;
        if (k > 1)
        {
            break MISSING_BLOCK_LABEL_281;
        }
        l = 0;
        as = ((String []) (obj));
        i1 = j;
        obj = obj1;
        j1 = i;
_L9:
        j = l;
_L7:
        int k1;
        obj1 = obj;
        k1 = obj1[l];
        j % 5;
        JVM INSTR tableswitch 0 3: default 96
    //                   0 253
    //                   1 260
    //                   2 267
    //                   3 274;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 95;
_L11:
label0:
        {
            obj1[l] = (char)(i ^ k1);
            j++;
            if (k != 0)
            {
                break label0;
            }
            l = k;
        }
        if (true) goto _L7; else goto _L6
        String as1[];
        int l1;
        i = k;
        as1 = as;
        l1 = i1;
        obj1 = obj;
        k1 = j1;
_L12:
        j1 = k1;
        obj = obj1;
        i1 = l1;
        as = as1;
        k = i;
        l = j;
        if (i > j) goto _L9; else goto _L8
_L8:
        obj = (new String(((char []) (obj1)))).intern();
        switch (k1)
        {
        default:
            as1[l1] = ((String) (obj));
            obj1 = "jC\004\022\013l1\025\022\035eTa9/\\b)\f,]p5:,]x\" \177\001N(7\177`_\025\026\030lCa\003\r`\\\000\001\006\tZ\004\n\177hD\025\034\026gR\023\026\022l_\025ssZe\036 0[e\0368:P156']1/<+\t\1774?3\005b5\f1Lea':Qea=0]1/&3E=2'\000J~/=\000@aa':Qea=0]1/&3E=2'\000E~\"23vu/ \177]t9'sZe\036 0\\c\"6\177@\177568Lca=0]1/&3E=2'\000Op(?:M1(=+Lv$!\177G~5s1\\}-\177,]N5<+H}a:1]t&6-\t\177.'\177Gd-?sZe\03600\\\1775\fn\tx/':Nt3\177,]N\"<*Ge\036b\000\0321(=+Lv$!sZe\03600\\\1775\flv qs6Ge$4:[=2'\000J~4=+v qs6Ge$4:[8z";
            j = 1;
            i = 0;
            break;

        case 0: // '\0'
            as1[l1] = ((String) (obj));
            j = 2;
            obj1 = "mC\016\003\177}P\003\037\032\tX\007s\032qX\022\007\f\t{1&,AN2'>]x2'6Jb";
            i = 1;
            break;

        case 1: // '\001'
            as1[l1] = ((String) (obj));
            z = as2;
            return;
        }
          goto _L10
_L6:
        i = 41;
          goto _L11
_L3:
        i = 17;
          goto _L11
_L4:
        i = 65;
          goto _L11
_L5:
        i = 83;
          goto _L11
        boolean flag = false;
        k1 = i;
        l1 = j;
        as1 = ((String []) (obj));
        i = k;
        j = ((flag) ? 1 : 0);
          goto _L12
    }
}
