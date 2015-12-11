// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.provider.BaseColumns;

// Referenced classes of package co.vine.android.provider:
//            Vine

public static interface 
    extends BaseColumns
{

    public static final String LAST_SECTION_REFRESH = "last_section_refresh";
    public static final String SECTION_INDEX = "section_index";
    public static final String SECTION_TITLE = "section_title";
    public static final String SECTION_TYPE = "section_type";
    public static final String TABLE_NAME = "user_sections";
    public static final int TYPE_FRIENDS = 1;
    public static final int TYPE_RECIPIENT = 0;
    public static final String USER_ID = "user_id";
}
