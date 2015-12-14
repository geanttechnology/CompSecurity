// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;

// Referenced classes of package com.aviary.android.feather.cds:
//            FeaturedColumns

public static final class id
{

    private String contentPath;
    private String displayName;
    private String featureImageLocalPath;
    private String featureURL;
    private String featuredIconPath;
    private int free;
    private String iconPath;
    private final long id;
    private String identifier;
    private String packType;
    private int purchased;
    private int type;

    public static id create(Cursor cursor)
    {
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
            i = cursor.getColumnIndex("iconPath");
            if (i > -1)
            {
                id1.iconPath = cursor.getString(i);
            }
            i = cursor.getColumnIndex("packType");
            if (i > -1)
            {
                id1.packType = cursor.getString(i);
            }
            i = cursor.getColumnIndex("free");
            if (i > -1)
            {
                id1.free = cursor.getInt(i);
            }
            i = cursor.getColumnIndex("purchased");
            if (i > -1)
            {
                id1.purchased = cursor.getInt(i);
            }
            i = cursor.getColumnIndex("contentPath");
            if (i > -1)
            {
                id1.contentPath = cursor.getString(i);
            }
            i = cursor.getColumnIndex("featureURL");
            if (i > -1)
            {
                id1.featureURL = cursor.getString(i);
            }
            i = cursor.getColumnIndex("featureImageLocalPath");
            if (i > -1)
            {
                id1.featureImageLocalPath = cursor.getString(i);
            }
            return id1;
        } else
        {
            return null;
        }
    }

    public String getContentPath()
    {
        return contentPath;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getFeatureImageLocalPath()
    {
        return featureImageLocalPath;
    }

    public String getFeatureURL()
    {
        return featureURL;
    }

    public String getFeaturedIconPath()
    {
        return featuredIconPath;
    }

    public int getFree()
    {
        return free;
    }

    public String getIconPath()
    {
        return iconPath;
    }

    public long getId()
    {
        return id;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public String getPackType()
    {
        return packType;
    }

    public int getPurchased()
    {
        return purchased;
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
