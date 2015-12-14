// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.plugin;

import android.net.Uri;
import android.provider.BaseColumns;

public final class 
    implements BaseColumns
{

    public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
    public static final String KEY = "key";
    public static final String TYPE = "type";
    public static final String VALUE = "value";


    private ()
    {
    }
}
