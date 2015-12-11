// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cn.jpush.android.util.x;

final class j extends SQLiteOpenHelper
{

    private static final String z[];

    public j(Context context)
    {
        this(context, z[1], null, 1);
    }

    private j(Context context, String s, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory, int i)
    {
        super(context, s, null, 1);
    }

    public final void onCreate(SQLiteDatabase sqlitedatabase)
    {
        try
        {
            sqlitedatabase.execSQL(z[0]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            x.b();
        }
    }

    public final void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int k)
    {
        sqlitedatabase.execSQL(z[2]);
        onCreate(sqlitedatabase);
    }

    static 
    {
        Object obj1;
        String as2[];
        int i;
        int k;
        as2 = new String[3];
        obj1 = "K\006\002g-Mt\023g;D\021gR&d;$G\025f;3O\037a7&R\020g:g\016&a0go7\\\021\000c+(\004\025o4I\006\036\0062M\rgg,\\\033\016h:Z\021\nc7\\tkJ\027W=#\006\025g: \006\027g gH\fd8kJ\027W7(S\027|t.H\rm3\"TYf;3\006\027}8+\n\025f\0135C\024g\"\"\006\020f \"A\034zt)I\r(:2J\025$8)y\rq$\"\006\020f \"A\034zt)I\r(:2J\025$8)y\034p 5GY|1?RY$8)y\rz= A\034z\0133O\024mt+I\027otkJ\027W5#B&|=*CYd;)AY!o";
        i = -1;
        k = 0;
_L10:
        Object obj;
        String as[];
        int l;
        int i1;
        int j1;
        int k1;
        obj = as2;
        obj1 = ((String) (obj1)).toCharArray();
        l = obj1.length;
        if (l > 1)
        {
            break MISSING_BLOCK_LABEL_281;
        }
        i1 = 0;
        as = ((String []) (obj));
        j1 = k;
        obj = obj1;
        k1 = i;
_L9:
        k = i1;
_L7:
        int l1;
        obj1 = obj;
        l1 = obj1[i1];
        k % 5;
        JVM INSTR tableswitch 0 3: default 96
    //                   0 253
    //                   1 260
    //                   2 267
    //                   3 274;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 121;
_L11:
label0:
        {
            obj1[i1] = (char)(i ^ l1);
            k++;
            if (l != 0)
            {
                break label0;
            }
            i1 = l;
        }
        if (true) goto _L7; else goto _L6
        String as1[];
        int i2;
        i = l;
        as1 = as;
        i2 = j1;
        obj1 = obj;
        l1 = k1;
_L12:
        k1 = l1;
        obj = obj1;
        j1 = i2;
        as = as1;
        l = i;
        i1 = k;
        if (i > k) goto _L9; else goto _L8
_L8:
        obj = (new String(((char []) (obj1)))).intern();
        switch (l1)
        {
        default:
            as1[i2] = ((String) (obj));
            obj1 = "b$2U\021W8(E\030d\013)I\ra2.E\030|=(HWl6";
            k = 1;
            i = 0;
            break;

        case 0: // '\0'
            as1[i2] = ((String) (obj));
            k = 2;
            obj1 = "L\006\bvY\\\025\005j<(\035\001\006<P\035\024r*( \030J\026k5+H\026|=!O\032i .I\027";
            i = 1;
            break;

        case 1: // '\001'
            as1[i2] = ((String) (obj));
            z = as2;
            return;
        }
          goto _L10
_L6:
        i = 8;
          goto _L11
_L3:
        i = 84;
          goto _L11
_L4:
        i = 71;
          goto _L11
_L5:
        i = 38;
          goto _L11
        boolean flag = false;
        l1 = i;
        i2 = k;
        as1 = ((String []) (obj));
        i = l;
        k = ((flag) ? 1 : 0);
          goto _L12
    }
}
