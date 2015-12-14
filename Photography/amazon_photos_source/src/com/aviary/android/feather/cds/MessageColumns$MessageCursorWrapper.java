// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;

// Referenced classes of package com.aviary.android.feather.cds:
//            MessageColumns

public static final class it> extends it>
{

    String identifier;
    String messageType;
    String versionKey;

    public static it> create(Cursor cursor)
    {
        if (alid(cursor))
        {
            it> it> = new <init>(cursor.getLong(cursor.getColumnIndex("msg_id")));
            int i = cursor.getColumnIndex("msg_type");
            if (i > -1)
            {
                it>.messageType = cursor.getString(i);
            }
            i = cursor.getColumnIndex("msg_versionKey");
            if (i > -1)
            {
                it>.versionKey = cursor.getString(i);
            }
            i = cursor.getColumnIndex("msg_identifier");
            if (i > -1)
            {
                it>.identifier = cursor.getString(i);
            }
            return it>;
        } else
        {
            return null;
        }
    }

    public Object clone()
    {
        identifier identifier1 = new <init>(id);
        identifier1.messageType = messageType;
        identifier1.versionKey = versionKey;
        identifier1.identifier = identifier;
        return identifier1;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public String getMessageType()
    {
        return messageType;
    }

    public String getVersionKey()
    {
        return versionKey;
    }

    public (long l)
    {
        super(l);
    }
}
