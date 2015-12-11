// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;


// Referenced classes of package co.vine.android.provider:
//            VineDatabaseSQL

public static final class A
{

    public static final int INDEX_AVATAR_URL = 6;
    public static final int INDEX_CLEARED = 4;
    public static final int INDEX_CONVERSATION_ROW_ID = 5;
    public static final int INDEX_ID = 0;
    public static final int INDEX_MESSAGE = 3;
    public static final int INDEX_NOTIFICATION_ID = 1;
    public static final int INDEX_TYPE = 2;
    public static final String PROJECTION[] = {
        "_id", "notification_id", "notification_type", "message", "cleared", "conversation_row_id", "avatar_url"
    };


    public A()
    {
    }
}
