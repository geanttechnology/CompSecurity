// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.tencent.mm.sdk.plugin:
//            MMPluginOAuth

public class bE extends BroadcastReceiver
{

    private static final Map aA = new HashMap();
    private final MMPluginOAuth bE;

    public static void register(String s, MMPluginOAuth mmpluginoauth)
    {
        aA.put(s, mmpluginoauth);
    }

    public static void unregister(String s)
    {
        aA.remove(s);
    }

    public void onReceive(Context context, Intent intent)
    {
        Log.d("MicroMsg.SDK.MMPluginOAuth", "receive oauth result");
        String s = intent.getStringExtra("com.tencent.mm.sdk.plugin.Intent.REQUEST_TOKEN");
        intent = intent.getStringExtra("com.tencent.mm.sdk.plugin.Intent.ACCESS_TOKEN");
        class _cls1
            implements Runnable
        {

            final MMPluginOAuth bF;
            final String bG;
            final MMPluginOAuth.Receiver bH;

            public void run()
            {
                MMPluginOAuth.a(bF, bG);
            }

            _cls1(MMPluginOAuth mmpluginoauth, String s)
            {
                bH = MMPluginOAuth.Receiver.this;
                bF = mmpluginoauth;
                bG = s;
                super();
            }
        }

        if (bE != null)
        {
            context = bE;
        } else
        {
            context = (MMPluginOAuth)aA.get(s);
            if (context == null)
            {
                Log.e("MicroMsg.SDK.MMPluginOAuth", (new StringBuilder("oauth unregistered, request token = ")).append(s).toString());
                return;
            }
            unregister(MMPluginOAuth.a(context));
        }
        (new Handler()).post(new _cls1(context, intent));
    }


    public _cls1()
    {
        this(null);
    }

    public <init>(MMPluginOAuth mmpluginoauth)
    {
        bE = mmpluginoauth;
    }
}
