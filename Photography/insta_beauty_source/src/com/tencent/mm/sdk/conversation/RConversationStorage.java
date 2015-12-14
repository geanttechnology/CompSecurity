// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.conversation;

import android.content.Context;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

// Referenced classes of package com.tencent.mm.sdk.conversation:
//            RConversationDB, RConversation

public class RConversationStorage extends MAutoStorage
{

    public static final String AUTHORITY = "com.tencent.mm.sdk.conversation.provider";
    public static final String PRIMARY_KEY = "username";
    public static final String TABLE = "rconversation";

    private RConversationStorage(ISQLiteDatabase isqlitedatabase)
    {
        super(isqlitedatabase);
    }

    public static RConversationStorage create(Context context)
    {
        return new RConversationStorage(new RConversationDB(context));
    }

    public RConversation get(String s)
    {
        RConversation rconversation = new RConversation();
        rconversation.field_username = s;
        s = rconversation;
        if (!super.get(rconversation, new String[] {
    "username"
}))
        {
            s = null;
        }
        return s;
    }

    public String[] getColumns()
    {
        return RConversation.COLUMNS;
    }

    public String getPrimaryKey()
    {
        return "username";
    }

    public String getTableName()
    {
        return "rconversation";
    }
}
