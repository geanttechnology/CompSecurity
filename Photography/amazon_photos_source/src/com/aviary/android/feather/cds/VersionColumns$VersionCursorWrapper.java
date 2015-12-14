// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;

// Referenced classes of package com.aviary.android.feather.cds:
//            VersionColumns

public static class it> extends it>
{

    private String assetsBaseURL;
    private String versionKey;

    public static it> create(Cursor cursor)
    {
        if (isValid(cursor))
        {
            it> it> = new <init>(cursor.getLong(cursor.getColumnIndex("version_id")));
            int i = cursor.getColumnIndex("version_versionKey");
            if (i > -1)
            {
                it>.versionKey = cursor.getString(i);
            }
            i = cursor.getColumnIndex("version_assetsBaseURL");
            if (i > -1)
            {
                it>.assetsBaseURL = cursor.getString(i);
            }
            return it>;
        } else
        {
            return null;
        }
    }

    public Object clone()
    {
        assetsBaseURL assetsbaseurl = new <init>(id);
        assetsbaseurl.assetsBaseURL = assetsBaseURL;
        assetsbaseurl.versionKey = versionKey;
        return assetsbaseurl;
    }

    public String getAssetsBaseURL()
    {
        return assetsBaseURL;
    }

    public String getVersionKey()
    {
        return versionKey;
    }

    public String toString()
    {
        return (new StringBuilder()).append("VersionColumns.Version{ id: ").append(id).append(", versionKey: ").append(versionKey).append(", assetsBaseURL: ").append(assetsBaseURL).append(" }").toString();
    }

    public (long l)
    {
        super(l);
    }
}
