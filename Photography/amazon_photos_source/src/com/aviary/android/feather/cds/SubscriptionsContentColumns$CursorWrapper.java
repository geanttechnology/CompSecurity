// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;

// Referenced classes of package com.aviary.android.feather.cds:
//            SubscriptionsContentColumns

public static final class subscriptionId extends subscriptionId
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

    public static subscriptionId create(Cursor cursor)
    {
        if (d(cursor))
        {
            subscriptionId subscriptionid = new <init>(cursor.getLong(cursor.getColumnIndex("subscriptions_content_id")), cursor.getLong(cursor.getColumnIndex("subscriptions_subscription_id")));
            int i = cursor.getColumnIndex("subscriptions_content_display_name");
            if (i > -1)
            {
                subscriptionid.displayName = cursor.getString(i);
            }
            i = cursor.getColumnIndex("subscriptions_content_display_description");
            if (i > -1)
            {
                subscriptionid.displayDescription = cursor.getString(i);
            }
            i = cursor.getColumnIndex("subscriptions_content_duration_tier");
            if (i > -1)
            {
                subscriptionid.durationTier = cursor.getInt(i);
            }
            i = cursor.getColumnIndex("subscriptions_content_purchased");
            if (i > -1)
            {
                subscriptionid.purchased = cursor.getInt(i);
            }
            i = cursor.getColumnIndex("subscriptions_content_unlock_type");
            if (i > -1)
            {
                subscriptionid.unlockType = cursor.getString(i);
            }
            return subscriptionid;
        } else
        {
            return null;
        }
    }

    public Object clone()
    {
        unlockType unlocktype = new <init>(id, subscriptionId);
        unlocktype.displayName = displayName;
        unlocktype.displayDescription = displayDescription;
        unlocktype.previewURL = previewURL;
        unlocktype.previewPath = previewPath;
        unlocktype.previewVersion = previewVersion;
        unlocktype.durationTier = durationTier;
        unlocktype.purchased = purchased;
        unlocktype.unlockType = unlockType;
        return unlocktype;
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

    (long l, long l1)
    {
        super(l);
        subscriptionId = l1;
    }
}
