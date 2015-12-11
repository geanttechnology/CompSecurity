// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class biv extends SQLiteOpenHelper
    implements biz
{

    final Context a;
    private final List b;

    public biv(Context context, String s, List list)
    {
        super((Context)b.a(context), s, null, ((List)b.a(list)).size());
        a = context;
        b = list;
    }

    public final void onCreate(SQLiteDatabase sqlitedatabase)
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext(); ((bjd)iterator.next()).a(sqlitedatabase)) { }
    }

    public final void onDowngrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        bmo.e((new StringBuilder(60)).append("Downgrading database from version ").append(i).append(" to ").append(j).toString());
        bja.a(sqlitedatabase);
        onUpgrade(sqlitedatabase, 0, j);
    }

    public final void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        bmo.e((new StringBuilder(58)).append("Upgrading database from version ").append(i).append(" to ").append(j).toString());
        do
        {
            if (i >= j)
            {
                break;
            }
            bjd bjd1 = (bjd)b.get(i);
            bmo.e((new StringBuilder(43)).append("Upgrading to Schema to version: ").append(i).toString());
            try
            {
                bjd1.a(sqlitedatabase);
            }
            // Misplaced declaration of an exception variable
            catch (SQLiteDatabase sqlitedatabase)
            {
                bmo.a(String.format(Locale.US, "Error upgrading from %d to %d", new Object[] {
                    Integer.valueOf(i - 1), Integer.valueOf(i)
                }), sqlitedatabase);
                throw sqlitedatabase;
            }
            i++;
        } while (true);
    }
}
