// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.channel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class o extends BroadcastReceiver
{

    public static final Map callbacks = new HashMap();
    private final handleMessage o;

    public static void registerCallBack(String s, o o1)
    {
        callbacks.put(s, o1);
    }

    public static void unregisterCallBack(String s)
    {
        callbacks.remove(s);
    }

    public final void onReceive(Context context, Intent intent)
    {
        Log.d("MicroMsg.SDK.MMessage", (new StringBuilder("receive intent=")).append(intent).toString());
        if (o != null)
        {
            o.handleMessage(intent);
            Log.d("MicroMsg.SDK.MMessage", "mm message self-handled");
        } else
        {
            context = (handleMessage)callbacks.get(intent.getAction());
            if (context != null)
            {
                context.handleMessage(intent);
                Log.d("MicroMsg.SDK.MMessage", "mm message handled");
                return;
            }
        }
    }


    public ()
    {
        this(null);
    }

    public <init>(<init> <init>1)
    {
        o = <init>1;
    }
}
