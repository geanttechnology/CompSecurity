// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.plugin;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Handler;
import com.tencent.mm.sdk.platformtools.Log;

public class MMPluginOAuth
{

    private final Context R;
    private final IResult bA;
    private String bB;
    private String bC;
    private Handler handler;

    public MMPluginOAuth(Context context, IResult iresult)
    {
        R = context;
        bA = iresult;
    }

    static String a(MMPluginOAuth mmpluginoauth)
    {
        return mmpluginoauth.bC;
    }

    static void a(MMPluginOAuth mmpluginoauth, String s)
    {
        Receiver.unregister(mmpluginoauth.bC);
        mmpluginoauth.bB = s;
        Log.i("MicroMsg.SDK.MMPluginOAuth", (new StringBuilder("access token: ")).append(s).toString());
        if (mmpluginoauth.bA != null)
        {
            mmpluginoauth.bA.onResult(mmpluginoauth);
        }
    }

    static IResult b(MMPluginOAuth mmpluginoauth)
    {
        return mmpluginoauth.bA;
    }

    public String getAccessToken()
    {
        return bB;
    }

    public String getRequestToken()
    {
        return bC;
    }

    public void start()
    {
        start(null);
    }

    public boolean start(Handler handler1)
    {
        Handler handler2 = handler1;
        if (handler1 == null)
        {
            handler2 = new Handler();
        }
        handler = handler2;
        handler1 = R.getContentResolver().query(MMPluginProviderConstants.OAuth.CONTENT_URI, null, null, new String[] {
            R.getPackageName(), "request_token"
        }, null);
        if (handler1 != null)
        {
            if (handler1.moveToFirst() && handler1.getColumnCount() >= 2)
            {
                bC = handler1.getString(0);
                bB = handler1.getString(1);
            }
            handler1.close();
        }
        Log.i("MicroMsg.SDK.MMPluginOAuth", (new StringBuilder("request token = ")).append(bC).toString());
        if (bC == null)
        {
            Log.e("MicroMsg.SDK.MMPluginOAuth", "request token failed");
            return false;
        }
        if (bB != null)
        {
            handler.post(new _cls1());
            return true;
        }
        Log.d("MicroMsg.SDK.MMPluginOAuth", "begin to show user oauth page");
        handler1 = new Intent();
        handler1.setClassName("com.tencent.mm", "com.tencent.mm.plugin.PluginOAuthUI");
        handler1.putExtra("com.tencent.mm.sdk.plugin.Intent.REQUEST_TOKEN", bC);
        handler1.putExtra("com.tencent.mm.sdk.plugin.Intent.PACKAGE", R.getPackageName());
        boolean flag;
        if (R.getPackageManager().resolveActivity(handler1, 0x10000) == null)
        {
            Log.e("MicroMsg.SDK.MMPluginOAuth", "show oauth page failed, activity not found");
            flag = false;
        } else
        {
            if (!(R instanceof Activity))
            {
                handler1.setFlags(0x10000000);
            }
            R.startActivity(handler1);
            flag = true;
        }
        if (flag)
        {
            Receiver.register(bC, this);
            return true;
        } else
        {
            return false;
        }
    }

    private class Receiver extends BroadcastReceiver
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
                final Receiver bH;

                public void run()
                {
                    MMPluginOAuth.a(bF, bG);
                }

                _cls1(String s)
                {
                    bH = Receiver.this;
                    bF = MMPluginOAuth.this;
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
            (new Handler()).post(context. new _cls1(intent));
        }


        public Receiver()
        {
            this(null);
        }

        public Receiver(MMPluginOAuth mmpluginoauth)
        {
            bE = mmpluginoauth;
        }
    }


    private class IResult
    {

        public abstract void onResult(MMPluginOAuth mmpluginoauth);

        public abstract void onSessionTimeOut();
    }


    private class _cls1
        implements Runnable
    {

        final MMPluginOAuth bD;

        public void run()
        {
            if (MMPluginOAuth.b(bD) != null)
            {
                MMPluginOAuth.b(bD).onResult(bD);
            }
        }

        _cls1()
        {
            bD = MMPluginOAuth.this;
            super();
        }
    }

}
