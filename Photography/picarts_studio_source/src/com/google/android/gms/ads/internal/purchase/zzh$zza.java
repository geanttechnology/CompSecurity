// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.ads.internal.purchase:
//            zzh

public class zzCZ extends SQLiteOpenHelper
{

    final zzh zzCZ;

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL(zzh.zzfp());
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        zzb.zzaG((new StringBuilder("Database updated from version ")).append(i).append(" to version ").append(j).toString());
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
        onCreate(sqlitedatabase);
    }

    public (zzh zzh1, Context context, String s)
    {
        zzCZ = zzh1;
        super(context, s, null, 4);
    }
}
