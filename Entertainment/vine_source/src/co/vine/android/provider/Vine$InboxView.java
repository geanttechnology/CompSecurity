// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.net.Uri;
import android.provider.BaseColumns;

// Referenced classes of package co.vine.android.provider:
//            Vine

public static final class lumns
    implements BaseColumns, onsColumns, lumns
{

    public static final String AVATAR_URL = "avatar_url";
    public static final Uri CONTENT_URI;
    public static final String FOLLOWING_FLAG = "following_flag";
    public static final String PARAM_HIDDEN = "hidden";
    public static final String PARAM_NETWORK_TYPE = "network_type";
    public static final String PROFILE_BACKGROUND = "profile_background";
    public static final String RECIPIENTS_COUNT = "recipients_count";
    public static final String TABLE_NAME = "inbox_view";
    public static final String USERNAME = "username";
    public static final String USER_ID = "user_id";

    static 
    {
        CONTENT_URI = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("inbox_view").toString());
    }

    public lumns()
    {
    }
}
