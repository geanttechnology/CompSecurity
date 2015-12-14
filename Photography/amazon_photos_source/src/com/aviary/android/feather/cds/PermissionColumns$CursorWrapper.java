// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;

// Referenced classes of package com.aviary.android.feather.cds:
//            PermissionColumns

static final class  extends 
{

    private String hashCode;
    private String value;

    public static  create(Cursor cursor)
    {
        if (isValid(cursor))
        {
              = new <init>(cursor.getLong(0));
            int i = cursor.getColumnIndex("perm_value");
            if (i > -1)
            {
                .value = cursor.getString(i);
            }
            i = cursor.getColumnIndex("perm_hash");
            if (i > -1)
            {
                .hashCode = cursor.getString(i);
            }
            return ;
        } else
        {
            return null;
        }
    }

    public Object clone()
    {
        hashCode hashcode = new <init>(getId());
        hashcode.hashCode = hashCode;
        hashcode.value = value;
        return hashcode;
    }

    public String getHashCode()
    {
        return hashCode;
    }

    public String getValue()
    {
        return value;
    }

    public String toString()
    {
        return (new StringBuilder()).append("PermissionColumns.Permission{").append(value).append(", ").append(hashCode).append("}").toString();
    }

    public (long l)
    {
        super(l);
    }
}
