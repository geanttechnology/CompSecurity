// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.dump.api;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public final class DumpHelper
{

    public static final String SEND_DUMP_ACTION = "com.fanhattan.services.SEND_DUMP";
    public static final String SERVICE_CLASS_NAME = "com.fanhattan.services.dump.DumpService";
    public static final String SERVICE_PCK = "com.fanhattan.services";
    public static final String TAG = "DumpHelper";

    private DumpHelper()
    {
        throw new IllegalAccessError();
    }

    public static boolean sendDump(Context context)
    {
        try
        {
            Intent intent = new Intent("com.fanhattan.services.SEND_DUMP");
            intent.setClassName("com.fanhattan.services", "com.fanhattan.services.dump.DumpService");
            context.startService(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("DumpHelper", (new StringBuilder()).append("Cannot send dump ").append(context.getMessage()).toString());
            return false;
        }
        return true;
    }
}
