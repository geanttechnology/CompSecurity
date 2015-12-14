// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;

// Referenced classes of package com.aviary.android.feather.cds:
//            SubscriptionsColumns

public static final class nit> extends nit>
{

    rapper content;
    String identifier;
    String versionKey;
    int visible;

    public static nit> create(Cursor cursor)
    {
        if (.isValid(cursor))
        {
            nit> nit> = new <init>(cursor.getLong(cursor.getColumnIndex("subscription_id")));
            int i = cursor.getColumnIndex("subscription_identifier");
            if (i > -1)
            {
                nit>.identifier = cursor.getString(i);
            }
            i = cursor.getColumnIndex("subscription_version_key");
            if (i > -1)
            {
                nit>.versionKey = cursor.getString(i);
            }
            i = cursor.getColumnIndex("subscription_visible");
            if (i > -1)
            {
                nit>.visible = cursor.getInt(i);
            }
            return nit>;
        } else
        {
            return null;
        }
    }

    public Object clone()
    {
        visible visible1 = new <init>(id);
        visible1.identifier = identifier;
        visible1.versionKey = versionKey;
        visible1.visible = visible;
        if (content != null)
        {
            visible1.content = (rapper)content.clone();
        }
        return visible1;
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof rapper.clone))
        {
            obj = (rapper.clone)obj;
            if (id == ((id) (obj)).id)
            {
                return true;
            }
        }
        return false;
    }

    public rapper getContent()
    {
        return content;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public String getVersionKey()
    {
        return versionKey;
    }

    public int getVisible()
    {
        return visible;
    }

    public int hashCode()
    {
        return Long.valueOf(id).hashCode();
    }

    public void setContent(rapper rapper)
    {
        content = rapper;
    }

    rapper(long l)
    {
        super(l);
    }
}
