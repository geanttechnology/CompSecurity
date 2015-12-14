// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.contact;

import android.content.Context;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

// Referenced classes of package com.tencent.mm.sdk.contact:
//            RContactDB, RContact

public class RContactStorage extends MAutoStorage
{

    public static final String AUTHORITY = "com.tencent.mm.sdk.contact.provider";
    public static final String PRIMARY_KEY = "";
    public static final String TABLE = "rcontact";

    private RContactStorage(ISQLiteDatabase isqlitedatabase)
    {
        super(isqlitedatabase);
    }

    public static RContactStorage create(Context context)
    {
        return new RContactStorage(new RContactDB(context));
    }

    public RContact get(String s)
    {
        RContact rcontact = new RContact();
        rcontact.field_username = s;
        s = rcontact;
        if (!super.get(rcontact, new String[] {
    "username"
}))
        {
            s = null;
        }
        return s;
    }

    public String[] getColumns()
    {
        return RContact.COLUMNS;
    }

    public String getPrimaryKey()
    {
        return "";
    }

    public String getTableName()
    {
        return "rcontact";
    }
}
