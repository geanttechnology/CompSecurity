// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.message;

import android.content.Context;
import android.net.Uri;
import com.tencent.mm.sdk.storage.ContentProviderDB;
import java.util.HashMap;
import java.util.Map;

public class RMsgInfoDB extends ContentProviderDB
{

    private static final Map O;
    public static final String TABLE = "message";

    public RMsgInfoDB(Context context)
    {
        super(context);
    }

    public Uri getUriFromTable(String s)
    {
        return (Uri)O.get(s);
    }

    static 
    {
        HashMap hashmap = new HashMap();
        O = hashmap;
        hashmap.put("message", Uri.parse("content://com.tencent.mm.sdk.msginfo.provider/message"));
    }
}
