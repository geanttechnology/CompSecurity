// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import android.content.Context;
import android.content.IntentFilter;

public class ProxyChangeListener
{

    private static boolean a = true;
    private static boolean e;
    private long b;
    private Context c;
    private ProxyReceiver d;

    private ProxyChangeListener(Context context)
    {
        c = context;
    }

    static void a(ProxyChangeListener proxychangelistener, ProxyConfig proxyconfig)
    {
label0:
        {
            if (a && proxychangelistener.b != 0L)
            {
                if (proxyconfig == null)
                {
                    break label0;
                }
                proxychangelistener.nativeProxySettingsChangedTo(proxychangelistener.b, proxyconfig.a, proxyconfig.b, proxyconfig.c, proxyconfig.d);
            }
            return;
        }
        proxychangelistener.nativeProxySettingsChanged(proxychangelistener.b);
    }

    public static ProxyChangeListener create(Context context)
    {
        return new ProxyChangeListener(context);
    }

    public static String getProperty(String s)
    {
        return System.getProperty(s);
    }

    private native void nativeProxySettingsChanged(long l);

    private native void nativeProxySettingsChangedTo(long l, String s, int i, String s1, String as[]);

    public void start(long l)
    {
        if (!e && b != 0L)
        {
            throw new AssertionError();
        }
        b = l;
        if (d == null)
        {
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("android.intent.action.PROXY_CHANGE");
            d = new ProxyReceiver();
            c.getApplicationContext().registerReceiver(d, intentfilter);
        }
    }

    public void stop()
    {
        b = 0L;
        if (d != null)
        {
            c.unregisterReceiver(d);
            d = null;
        }
    }

    static 
    {
        boolean flag;
        if (!org/chromium/net/ProxyChangeListener.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e = flag;
    }

    private class ProxyConfig
    {

        public final String a;
        public final int b;
        public final String c;
        public final String d[];

        public ProxyConfig(String s, int i, String s1, String as[])
        {
            a = s;
            b = i;
            c = s1;
            d = as;
        }
    }


    private class ProxyReceiver extends BroadcastReceiver
    {

        private ProxyChangeListener a;

        private static ProxyConfig a(Intent intent)
        {
            Object obj;
            Object obj1;
            Class class1;
            Method method;
            int i;
            if (android.os.Build.VERSION.SDK_INT <= 19)
            {
                obj = "android.net.ProxyProperties";
                obj1 = "proxy";
            } else
            {
                obj = "android.net.ProxyInfo";
                obj1 = "android.intent.extra.PROXY_INFO";
            }
            try
            {
                obj1 = intent.getExtras().get(((String) (obj1)));
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                Log.e("ProxyChangeListener", (new StringBuilder("Using no proxy configuration due to exception:")).append(intent).toString());
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                Log.e("ProxyChangeListener", (new StringBuilder("Using no proxy configuration due to exception:")).append(intent).toString());
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                Log.e("ProxyChangeListener", (new StringBuilder("Using no proxy configuration due to exception:")).append(intent).toString());
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                Log.e("ProxyChangeListener", (new StringBuilder("Using no proxy configuration due to exception:")).append(intent).toString());
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                Log.e("ProxyChangeListener", (new StringBuilder("Using no proxy configuration due to exception:")).append(intent).toString());
                return null;
            }
            if (obj1 == null)
            {
                return null;
            }
            class1 = Class.forName(((String) (obj)));
            obj = class1.getDeclaredMethod("getHost", new Class[0]);
            intent = class1.getDeclaredMethod("getPort", new Class[0]);
            method = class1.getDeclaredMethod("getExclusionList", new Class[0]);
            obj = (String)((Method) (obj)).invoke(obj1, new Object[0]);
            i = ((Integer)intent.invoke(obj1, new Object[0])).intValue();
            if (android.os.Build.VERSION.SDK_INT <= 19)
            {
                intent = ((String)method.invoke(obj1, new Object[0])).split(",");
            } else
            {
                intent = (String[])method.invoke(obj1, new Object[0]);
            }
            if (android.os.Build.VERSION.SDK_INT == 19)
            {
                obj1 = (String)class1.getDeclaredMethod("getPacFileUrl", new Class[0]).invoke(obj1, new Object[0]);
                if (!TextUtils.isEmpty(((CharSequence) (obj1))))
                {
                    return new ProxyConfig(((String) (obj)), i, ((String) (obj1)), intent);
                }
                break MISSING_BLOCK_LABEL_248;
            }
            if (android.os.Build.VERSION.SDK_INT > 19)
            {
                obj1 = (Uri)class1.getDeclaredMethod("getPacFileUrl", new Class[0]).invoke(obj1, new Object[0]);
                if (!Uri.EMPTY.equals(obj1))
                {
                    return new ProxyConfig(((String) (obj)), i, ((Uri) (obj1)).toString(), intent);
                }
            }
            intent = new ProxyConfig(((String) (obj)), i, null, intent);
            return intent;
        }

        public void onReceive(Context context, Intent intent)
        {
            if (intent.getAction().equals("android.intent.action.PROXY_CHANGE"))
            {
                ProxyChangeListener.a(a, a(intent));
            }
        }

        ProxyReceiver()
        {
            a = ProxyChangeListener.this;
            super();
        }
    }

}
