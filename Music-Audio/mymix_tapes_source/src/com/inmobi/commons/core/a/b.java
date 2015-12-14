// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.a;

import android.util.Log;
import com.inmobi.commons.core.c.e;
import com.inmobi.commons.core.utilities.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends e
{

    private static final String a = com/inmobi/commons/core/a/b.getSimpleName();

    public b(Thread thread, Throwable throwable)
    {
        super("crashReporting", "CrashEvent");
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("name", throwable.getClass().getSimpleName());
            jsonobject.put("message", throwable.getMessage());
            jsonobject.put("stack", Log.getStackTraceString(throwable));
            jsonobject.put("thread", thread.getName());
            a(jsonobject.toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Thread thread)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("JSONException: ").append(thread).toString());
        }
    }

}
