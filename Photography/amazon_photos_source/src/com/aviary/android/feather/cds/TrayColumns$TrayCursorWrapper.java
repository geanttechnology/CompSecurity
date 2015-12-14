// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;

// Referenced classes of package com.aviary.android.feather.cds:
//            TrayColumns

public static final class id
{

    private String displayName;
    private boolean free;
    private final long id;
    private String identifier;
    private String installDate;
    private long packId;
    private String packageName;
    private String path;
    private int type;

    public static id create(Cursor cursor)
    {
        boolean flag = true;
        if (apper.isValid(cursor))
        {
            id id1 = new <init>(cursor.getLong(cursor.getColumnIndex("_id")));
            int i = cursor.getColumnIndex("displayName");
            if (i > -1)
            {
                id1.displayName = cursor.getString(i);
            }
            i = cursor.getColumnIndex("identifier");
            if (i > -1)
            {
                id1.identifier = cursor.getString(i);
            }
            i = cursor.getColumnIndex("type");
            if (i > -1)
            {
                id1.type = cursor.getInt(i);
            }
            i = cursor.getColumnIndex("path");
            if (i > -1)
            {
                id1.path = cursor.getString(i);
            }
            i = cursor.getColumnIndex("packagename");
            if (i > -1)
            {
                id1.packageName = cursor.getString(i);
            }
            i = cursor.getColumnIndex("installDate");
            if (i > -1)
            {
                id1.installDate = cursor.getString(i);
            }
            i = cursor.getColumnIndex("isFree");
            if (i > -1)
            {
                if (cursor.getInt(i) != 1)
                {
                    flag = false;
                }
                id1.free = flag;
            }
            i = cursor.getColumnIndex("packId");
            if (i > -1)
            {
                id1.packId = cursor.getLong(i);
            }
            return id1;
        } else
        {
            return null;
        }
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public boolean getFree()
    {
        return free;
    }

    public long getId()
    {
        return id;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public String getInstallDate()
    {
        return installDate;
    }

    public long getPackId()
    {
        return packId;
    }

    public String getPackageName()
    {
        return packageName;
    }

    public String getPath()
    {
        return path;
    }

    public int getType()
    {
        return type;
    }

    apper(long l)
    {
        id = l;
    }
}
