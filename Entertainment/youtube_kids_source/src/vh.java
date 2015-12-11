// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

public final class vh
{

    SQLiteOpenHelper a;
    String b[] = {
        "0 AS suggest_format", "display1 AS suggest_text_1", "display2 AS suggest_text_2", "query AS suggest_intent_query", "_id"
    };

    public vh(Context context)
    {
        a = new vi(context);
    }
}
