// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;

import android.content.Context;
import java.io.File;
import java.util.Properties;

public class Config
{
    public static final class ServerType extends Enum
    {

        public static final ServerType ap;
        public static final ServerType aq;
        public static final ServerType ar;
        public static final ServerType as;
        public static final ServerType at;
        private static final ServerType au[];

        public static ServerType valueOf(String s)
        {
            return (ServerType)Enum.valueOf(com/sessionm/core/Config$ServerType, s);
        }

        public static ServerType[] values()
        {
            return (ServerType[])au.clone();
        }

        static 
        {
            ap = new ServerType("PRODUCTION", 0);
            aq = new ServerType("STAGING", 1);
            ar = new ServerType("DEVELOPMENT", 2);
            as = new ServerType("JAPAN", 3);
            at = new ServerType("CUSTOM", 4);
            au = (new ServerType[] {
                ap, aq, ar, as, at
            });
        }

        private ServerType(String s, int i1)
        {
            super(s, i1);
        }
    }


    public static final String M = "api.server.url";
    public static final String N = "api.server.url.dev";
    public static final String O = "api.server.url.staging";
    public static final String P = "api.server.url.production";
    public static final String Q = "api.server.url.japan";
    public static final String R = "portal.server.url";
    public static final String S = "portal.server.url.dev";
    public static final String T = "portal.server.url.staging";
    public static final String U = "portal.server.url.production";
    public static final String V = "portal.server.url.japan";
    public static final String W = "ads.server.url";
    public static final String X = "ads.server.url.dev";
    public static final String Y = "ads.server.url.staging";
    public static final String Z = "ads.server.url.japan";
    public static final String aa = "api.version";
    public static final String ab = "app.cache.path";
    public static final String ac = "sdk.version";
    public static final String ad = "deviceIDFile";
    public static final String ae = "uuid";
    public static final String af = "com.sessionm.session.stats";
    public static final String ag = "com.sessionm.session.stats.start";
    public static final String ah = "com.sessionm.location";
    public static final String ai = "com.sessionm.location.collect";
    public static final String aj = "com.sessionm.install";
    public static final String ak = "com.sessionm.install.key";
    private static final Config al = new Config();
    private final Properties am = new Properties();
    private ServerType an;
    private int ao;

    private Config()
    {
        an = ServerType.ap;
        ao = 10;
        am.put("sdk.version", "1.9.8");
        am.put("api.server.url", "https://api.sessionm.com");
        am.put("api.server.url.dev", "http://api.tb.sessionm.com");
        am.put("api.server.url.staging", "https://m.s.sessionm.com");
        am.put("api.server.url.production", "https://api.sessionm.com");
        am.put("api.server.url.japan", "https://api.sessionm.jp");
        am.put("portal.server.url", "https://portal.sessionm.com");
        am.put("portal.server.url.dev", "http://api.tb.sessionm.com");
        am.put("portal.server.url.staging", "https://m.s.sessionm.com");
        am.put("portal.server.url.production", "https://portal.sessionm.com");
        am.put("portal.server.url.japan", "https://portal.sessionm.jp");
        am.put("ads.server.url", "https://ads.sessionm.com");
        am.put("ads.server.url.staging", "https://m.s.sessionm.com");
        am.put("ads.server.url.dev", "http://api.tb.sessionm.com");
        am.put("ads.server.url.japan", "https://ads.sessionm.jp");
        am.put("api.version", "6");
    }

    public static Config h()
    {
        return al;
    }

    public String a(Context context)
    {
        return (new File(context.getCacheDir(), "sessionmrequestcache")).getPath();
    }

    public String b(Context context)
    {
        return (new File(context.getCacheDir(), "sessionmwebcache")).getPath();
    }

    public String c(Context context)
    {
        return (new File(context.getFilesDir(), "sessionmgeodb")).getPath();
    }

    public void c(int i1)
    {
        ao = i1;
    }

    public String d(Context context)
    {
        return (new File(context.getFilesDir(), "sessionmwebdb")).getPath();
    }

    public ServerType getServerType()
    {
        return an;
    }

    public String getValue(String s)
    {
        if (s == null || s.length() == 0)
        {
            return null;
        } else
        {
            return am.getProperty(s);
        }
    }

    public String i()
    {
        return getValue("api.server.url");
    }

    public String j()
    {
        return getValue("ads.server.url");
    }

    public String k()
    {
        return getValue("portal.server.url");
    }

    public int l()
    {
        return ao;
    }

    public transient void setServerType(ServerType servertype, String as[])
    {
        Object obj;
        Object obj1;
        an = servertype;
        obj1 = "";
        obj = "";
        servertype = "";
        if (an != ServerType.ar) goto _L2; else goto _L1
_L1:
        obj1 = getValue("api.server.url.dev");
        obj = getValue("portal.server.url.dev");
        servertype = getValue("ads.server.url.dev");
_L6:
        if (obj1 != null && ((String) (obj1)).length() != 0)
        {
            break; /* Loop/switch isn't completed */
        }
_L4:
        return;
_L2:
        if (an == ServerType.aq)
        {
            obj1 = getValue("api.server.url.staging");
            obj = getValue("portal.server.url.staging");
            servertype = getValue("ads.server.url.staging");
            continue; /* Loop/switch isn't completed */
        }
        if (an == ServerType.ap)
        {
            obj1 = getValue("api.server.url.production");
            obj = getValue("portal.server.url.production");
            servertype = getValue("ads.server.url");
            continue; /* Loop/switch isn't completed */
        }
        if (an == ServerType.as)
        {
            obj1 = getValue("api.server.url.japan");
            obj = getValue("portal.server.url.japan");
            servertype = getValue("ads.server.url.japan");
            continue; /* Loop/switch isn't completed */
        }
        if (an != ServerType.at)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (as == null || as.length == 0) goto _L4; else goto _L3
_L3:
        servertype = as[0];
        obj = servertype;
        obj1 = servertype;
        if (true) goto _L6; else goto _L5
_L5:
        am.setProperty("api.server.url", ((String) (obj1)));
        am.setProperty("portal.server.url", ((String) (obj)));
        am.setProperty("ads.server.url", servertype);
        return;
    }

}
