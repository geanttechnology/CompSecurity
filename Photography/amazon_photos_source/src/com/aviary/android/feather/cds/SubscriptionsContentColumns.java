// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public final class SubscriptionsContentColumns
{
    public static final class CursorWrapper extends VersionColumns.BaseCursorWrapper
    {

        String displayDescription;
        String displayName;
        int durationTier;
        String previewPath;
        String previewURL;
        String previewVersion;
        int purchased;
        final long subscriptionId;
        String unlockType;

        public static CursorWrapper create(Cursor cursor)
        {
            if (VersionColumns.VersionCursorWrapper.isValid(cursor))
            {
                CursorWrapper cursorwrapper = new CursorWrapper(cursor.getLong(cursor.getColumnIndex("subscriptions_content_id")), cursor.getLong(cursor.getColumnIndex("subscriptions_subscription_id")));
                int i = cursor.getColumnIndex("subscriptions_content_display_name");
                if (i > -1)
                {
                    cursorwrapper.displayName = cursor.getString(i);
                }
                i = cursor.getColumnIndex("subscriptions_content_display_description");
                if (i > -1)
                {
                    cursorwrapper.displayDescription = cursor.getString(i);
                }
                i = cursor.getColumnIndex("subscriptions_content_duration_tier");
                if (i > -1)
                {
                    cursorwrapper.durationTier = cursor.getInt(i);
                }
                i = cursor.getColumnIndex("subscriptions_content_purchased");
                if (i > -1)
                {
                    cursorwrapper.purchased = cursor.getInt(i);
                }
                i = cursor.getColumnIndex("subscriptions_content_unlock_type");
                if (i > -1)
                {
                    cursorwrapper.unlockType = cursor.getString(i);
                }
                return cursorwrapper;
            } else
            {
                return null;
            }
        }

        public Object clone()
        {
            CursorWrapper cursorwrapper = new CursorWrapper(id, subscriptionId);
            cursorwrapper.displayName = displayName;
            cursorwrapper.displayDescription = displayDescription;
            cursorwrapper.previewURL = previewURL;
            cursorwrapper.previewPath = previewPath;
            cursorwrapper.previewVersion = previewVersion;
            cursorwrapper.durationTier = durationTier;
            cursorwrapper.purchased = purchased;
            cursorwrapper.unlockType = unlockType;
            return cursorwrapper;
        }

        public String getDisplayDescription()
        {
            return displayDescription;
        }

        public String getDisplayName()
        {
            return displayName;
        }

        public int getDurationTier()
        {
            return durationTier;
        }

        public String getPreviewPath()
        {
            return previewPath;
        }

        public String getPreviewURL()
        {
            return previewURL;
        }

        public String getPreviewVersion()
        {
            return previewVersion;
        }

        public int getPurchased()
        {
            return purchased;
        }

        public String getUnlockType()
        {
            return unlockType;
        }

        CursorWrapper(long l, long l1)
        {
            super(l);
            subscriptionId = l1;
        }
    }


    public static final String DISPLAY_DESCRIPTION = "subscriptions_content_display_description";
    public static final String DISPLAY_NAME = "subscriptions_content_display_name";
    public static final String DURATION_TIER = "subscriptions_content_duration_tier";
    public static final String PURCHASED = "subscriptions_content_purchased";
    public static final String SUBSCRIPTION_ID = "subscriptions_subscription_id";
    public static final String TABLE_NAME = "subscriptions_content_table";
    public static final String UNLOCK_TYPE = "subscriptions_content_unlock_type";
    public static final String _ID = "subscriptions_content_id";

    private SubscriptionsContentColumns()
    {
    }

    static void create(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS subscriptions_content_table (subscriptions_content_id INTEGER PRIMARY KEY AUTOINCREMENT, subscriptions_subscription_id INTEGER NOT NULL, subscriptions_content_display_name VARCHAR(255) NOT NULL, subscriptions_content_display_description VARCHAR(255) NOT NULL, subscriptions_content_duration_tier INTEGER NOT NULL, subscriptions_content_purchased INTEGER NOT NULL DEFAULT 0, subscriptions_content_unlock_type VARCHAR(255) NOT NULL, FOREIGN KEY(subscriptions_subscription_id) REFERENCES subscription_table(subscription_id) ON DELETE CASCADE);");
    }
}
