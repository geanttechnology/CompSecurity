// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.reviews;

import java.util.ArrayList;
import org.json.JSONObject;

public class Badge
{

    private String badgeKey;
    private String badgeType;
    private String contentType;
    private String id;

    public Badge()
    {
    }

    public static ArrayList loadReviewBadgeData(JSONObject jsonobject, ArrayList arraylist)
    {
        ArrayList arraylist1 = new ArrayList();
        for (int i = 0; i < arraylist.size(); i++)
        {
            String s = (String)arraylist.get(i);
            JSONObject jsonobject1 = jsonobject.optJSONObject(s);
            if (jsonobject1 != null)
            {
                Badge badge = new Badge();
                badge.badgeKey = s;
                badge.badgeType = jsonobject1.optString("BadgeType");
                badge.id = jsonobject1.optString("Id");
                badge.contentType = jsonobject1.optString("ContentType");
                arraylist1.add(badge);
            }
        }

        return arraylist1;
    }

    public String getBadgeKey()
    {
        return badgeKey;
    }

    public String getBadgeType()
    {
        return badgeType;
    }

    public String getContentType()
    {
        return contentType;
    }

    public String getId()
    {
        return id;
    }
}
