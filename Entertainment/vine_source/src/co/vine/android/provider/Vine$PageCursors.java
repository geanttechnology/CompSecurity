// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.net.Uri;
import android.provider.BaseColumns;

// Referenced classes of package co.vine.android.provider:
//            Vine

public static final class 
    implements BaseColumns
{

    public static final String ANCHOR = "anchor";
    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.vine.android.page_cursor";
    public static final Uri CONTENT_URI;
    public static final int CURSOR_UNDEFINED = -1;
    public static final String KIND = "kind";
    public static final int KIND_ACTIVITY = 3;
    public static final int KIND_COMMENTS = 5;
    public static final int KIND_CONVERSATIONS = 6;
    public static final int KIND_FRIENDS = 8;
    public static final int KIND_MESSAGES = 7;
    public static final int KIND_POSTS_TIMELINE = 2;
    public static final int KIND_TAGS = 4;
    public static final int KIND_USERS = 1;
    public static final String NEXT_PAGE = "next_page";
    public static final int PAGE_NEW = 1;
    public static final int PAGE_TYPE_NEWER = 2;
    public static final int PAGE_TYPE_OLDER = 3;
    public static final String PREVIOUS_PAGE = "previous_page";
    public static final String REVERSED = "reversed";
    public static final String TABLE_NAME = "page_cursors";
    public static final String TAG = "tag";
    public static final String TYPE = "type";

    static 
    {
        CONTENT_URI = Uri.parse((new StringBuilder()).append(Vine.CONTENT_AUTHORITY).append("page_cursors").toString());
    }

    public ()
    {
    }
}
