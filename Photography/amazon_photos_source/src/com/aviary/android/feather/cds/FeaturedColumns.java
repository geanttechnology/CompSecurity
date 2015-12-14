// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;
import android.provider.BaseColumns;

public final class FeaturedColumns
    implements BaseColumns
{
    public static final class CursorWrapper
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

        public static CursorWrapper create(Cursor cursor)
        {
            if (VersionColumns.VersionCursorWrapper.isValid(cursor))
            {
                CursorWrapper cursorwrapper = new CursorWrapper(cursor.getLong(cursor.getColumnIndex("_id")));
                int i = cursor.getColumnIndex("displayName");
                if (i > -1)
                {
                    cursorwrapper.displayName = cursor.getString(i);
                }
                i = cursor.getColumnIndex("identifier");
                if (i > -1)
                {
                    cursorwrapper.identifier = cursor.getString(i);
                }
                i = cursor.getColumnIndex("type");
                if (i > -1)
                {
                    cursorwrapper.type = cursor.getInt(i);
                }
                i = cursor.getColumnIndex("iconPath");
                if (i > -1)
                {
                    cursorwrapper.iconPath = cursor.getString(i);
                }
                i = cursor.getColumnIndex("packType");
                if (i > -1)
                {
                    cursorwrapper.packType = cursor.getString(i);
                }
                i = cursor.getColumnIndex("free");
                if (i > -1)
                {
                    cursorwrapper.free = cursor.getInt(i);
                }
                i = cursor.getColumnIndex("purchased");
                if (i > -1)
                {
                    cursorwrapper.purchased = cursor.getInt(i);
                }
                i = cursor.getColumnIndex("contentPath");
                if (i > -1)
                {
                    cursorwrapper.contentPath = cursor.getString(i);
                }
                i = cursor.getColumnIndex("featureURL");
                if (i > -1)
                {
                    cursorwrapper.featureURL = cursor.getString(i);
                }
                i = cursor.getColumnIndex("featureImageLocalPath");
                if (i > -1)
                {
                    cursorwrapper.featureImageLocalPath = cursor.getString(i);
                }
                return cursorwrapper;
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

        CursorWrapper(long l)
        {
            id = l;
        }
    }


    public static final String CONTENT_PATH = "contentPath";
    public static final String DISPLAY_NAME = "displayName";
    public static final String FEATURE_IMAGE_LOCAL_PATH = "featureImageLocalPath";
    public static final String FEATURE_URL = "featureURL";
    public static final String ICON_PATH = "iconPath";
    public static final String IDENTIFIER = "identifier";
    public static final int ID_COLUMN_INDEX = 0;
    public static final String IS_FREE_PURCHASE = "free";
    public static final String PACK_TYPE = "packType";
    public static final String PURCHASED = "purchased";
    public static final String TYPE = "type";
    public static final int TYPE_COLUMN_INDEX = 4;
    public static final int TYPE_FEATURED = 0;
    public static final int TYPE_PACK = 2;
    public static final int TYPE_TITLE = 1;

    private FeaturedColumns()
    {
    }
}
