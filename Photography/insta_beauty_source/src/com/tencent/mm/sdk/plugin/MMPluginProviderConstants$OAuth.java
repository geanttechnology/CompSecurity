// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.plugin;

import android.net.Uri;
import android.provider.BaseColumns;

public final class 
    implements BaseColumns
{

    public static final String ACCESS_TOKEN = "accessToken";
    public static final String ACTION_REQUEST_TOKEN = "request_token";
    public static final String API_KEY = "apiKey";
    public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/oauth");
    public static final String REQUEST_TOKEN = "requestToken";
    public static final String SECRET = "secret";


    private ()
    {
    }
}
