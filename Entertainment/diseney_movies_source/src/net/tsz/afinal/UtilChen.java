// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal;

import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.Field;

public class UtilChen
{

    public UtilChen()
    {
    }

    public static void addTab(String s, SQLiteDatabase sqlitedatabase, Object obj)
    {
        StringBuffer stringbuffer;
        String s1;
        int j;
        s = (new StringBuilder("CREATE TABLE IF NOT EXISTS ")).append(s).toString();
        stringbuffer = new StringBuffer();
        s1 = (new StringBuilder("VARCHAR(200)")).append(",").toString();
        obj = obj.getClass().getDeclaredFields();
        j = obj.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            Field field;
            try
            {
                stringbuffer.deleteCharAt(stringbuffer.lastIndexOf(","));
                sqlitedatabase.execSQL((new StringBuilder(String.valueOf(s))).append("(").append(stringbuffer.toString()).append(")").toString());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            break MISSING_BLOCK_LABEL_191;
        }
        field = obj[i];
        field.setAccessible(true);
        stringbuffer.append((new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(field.getName()))).append(" ").toString()))).append(s1).toString());
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
