// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.configs;

import com.inmobi.commons.core.c.a;
import com.inmobi.commons.core.network.NetworkError;
import com.inmobi.commons.core.network.c;
import com.inmobi.commons.core.utilities.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.core.configs:
//            a, ConfigError

final class ConfigNetworkResponse
{
    public static class ConfigResponse
    {

        private ConfigResponseStatus a;
        private com.inmobi.commons.core.configs.a b;
        private ConfigError c;

        private void a(JSONObject jsonobject)
        {
            a = ConfigResponseStatus.fromValue(jsonobject.getInt("status"));
            if (a != ConfigResponseStatus.SUCCESS)
            {
                break MISSING_BLOCK_LABEL_274;
            }
            jsonobject = jsonobject.getJSONObject("content");
            b.a(jsonobject);
            if (b.c())
            {
                return;
            }
            try
            {
                a(new ConfigError(ConfigError.ErrorCode.PARSING_ERROR, "The received config has failed validation."));
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.commons.core.configs.ConfigNetworkResponse.c(), (new StringBuilder()).append("Config type:").append(b.a()).append(" Error code:").append(c().a()).append(" Error message:").append(c().b()).toString());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                a(new ConfigError(ConfigError.ErrorCode.PARSING_ERROR, jsonobject.getLocalizedMessage()));
            }
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.commons.core.configs.ConfigNetworkResponse.c(), (new StringBuilder()).append("Config type:").append(b.a()).append(" Error code:").append(c().a()).append(" Error message:").append(c().b()).toString(), jsonobject);
            HashMap hashmap = new HashMap();
            hashmap.put("name", b.a());
            hashmap.put("errorCode", "ParsingError");
            hashmap.put("reason", jsonobject.getLocalizedMessage());
            com.inmobi.commons.core.c.a.a().a("root", "InvalidConfig", hashmap);
            return;
            if (a == ConfigResponseStatus.NOT_MODIFIED)
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.commons.core.configs.ConfigNetworkResponse.c(), (new StringBuilder()).append("Config type:").append(b.a()).append(" Config not modified").toString());
                return;
            }
            a(new ConfigError(ConfigError.ErrorCode.CONFIG_SERVER_INTERNAL_ERROR, a.toString()));
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.commons.core.configs.ConfigNetworkResponse.c(), (new StringBuilder()).append("Config type:").append(b.a()).append(" Error code:").append(c().a()).append(" Error message:").append(c().b()).toString());
            return;
        }

        public com.inmobi.commons.core.configs.a a()
        {
            return b;
        }

        public void a(ConfigError configerror)
        {
            c = configerror;
        }

        public ConfigResponseStatus b()
        {
            return a;
        }

        public ConfigError c()
        {
            return c;
        }

        public boolean d()
        {
            return c != null;
        }

        public ConfigResponse(JSONObject jsonobject, com.inmobi.commons.core.configs.a a1)
        {
            b = a1;
            if (jsonobject != null)
            {
                a(jsonobject);
            }
        }
    }

    public static final class ConfigResponse.ConfigResponseStatus extends Enum
    {

        private static final ConfigResponse.ConfigResponseStatus $VALUES[];
        public static final ConfigResponse.ConfigResponseStatus INTERNAL_ERROR;
        public static final ConfigResponse.ConfigResponseStatus NOT_MODIFIED;
        public static final ConfigResponse.ConfigResponseStatus PRODUCT_NOT_FOUND;
        public static final ConfigResponse.ConfigResponseStatus SUCCESS;
        public static final ConfigResponse.ConfigResponseStatus UNKNOWN;
        private int a;

        public static ConfigResponse.ConfigResponseStatus fromValue(int i)
        {
            ConfigResponse.ConfigResponseStatus aconfigresponsestatus[] = values();
            int k = aconfigresponsestatus.length;
            for (int j = 0; j < k; j++)
            {
                ConfigResponse.ConfigResponseStatus configresponsestatus = aconfigresponsestatus[j];
                if (configresponsestatus.a == i)
                {
                    return configresponsestatus;
                }
            }

            return UNKNOWN;
        }

        public static ConfigResponse.ConfigResponseStatus valueOf(String s)
        {
            return (ConfigResponse.ConfigResponseStatus)Enum.valueOf(com/inmobi/commons/core/configs/ConfigNetworkResponse$ConfigResponse$ConfigResponseStatus, s);
        }

        public static ConfigResponse.ConfigResponseStatus[] values()
        {
            return (ConfigResponse.ConfigResponseStatus[])$VALUES.clone();
        }

        public int getValue()
        {
            return a;
        }

        static 
        {
            SUCCESS = new ConfigResponse.ConfigResponseStatus("SUCCESS", 0, 200);
            NOT_MODIFIED = new ConfigResponse.ConfigResponseStatus("NOT_MODIFIED", 1, 304);
            PRODUCT_NOT_FOUND = new ConfigResponse.ConfigResponseStatus("PRODUCT_NOT_FOUND", 2, 404);
            INTERNAL_ERROR = new ConfigResponse.ConfigResponseStatus("INTERNAL_ERROR", 3, 500);
            UNKNOWN = new ConfigResponse.ConfigResponseStatus("UNKNOWN", 4, -1);
            $VALUES = (new ConfigResponse.ConfigResponseStatus[] {
                SUCCESS, NOT_MODIFIED, PRODUCT_NOT_FOUND, INTERNAL_ERROR, UNKNOWN
            });
        }

        private ConfigResponse.ConfigResponseStatus(String s, int i, int j)
        {
            super(s, i);
            a = j;
        }
    }


    private static final String a = com/inmobi/commons/core/configs/ConfigNetworkResponse.getName();
    private Map b;
    private Map c;
    private c d;
    private ConfigError e;

    ConfigNetworkResponse(Map map, c c1)
    {
        b = map;
        d = c1;
        c = new HashMap();
        d();
    }

    private static String a(Map map)
    {
        Iterator iterator = map.keySet().iterator();
        String s;
        for (map = ""; iterator.hasNext(); map = (new StringBuilder()).append(map).append(s).append(",").toString())
        {
            s = (String)iterator.next();
        }

        return map.substring(0, map.length() - 1);
    }

    private void a(ConfigError configerror)
    {
        e = configerror;
    }

    static String c()
    {
        return a;
    }

    private void d()
    {
        if (!d.a())
        {
            try
            {
                JSONObject jsonobject = new JSONObject(d.b());
                Iterator iterator1 = jsonobject.keys();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    String s = (String)iterator1.next();
                    Object obj = jsonobject.getJSONObject(s);
                    if (b.get(s) != null)
                    {
                        obj = new ConfigResponse(((JSONObject) (obj)), (com.inmobi.commons.core.configs.a)b.get(s));
                        c.put(s, obj);
                    }
                } while (true);
            }
            catch (JSONException jsonexception)
            {
                a(new ConfigError(ConfigError.ErrorCode.PARSING_ERROR, jsonexception.getLocalizedMessage()));
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Error code:").append(b().a()).append(" Error message:").append(b().b()).toString(), jsonexception);
                HashMap hashmap1 = new HashMap();
                hashmap1.put("name", a(b));
                hashmap1.put("errorCode", "ParsingError");
                hashmap1.put("reason", jsonexception.getLocalizedMessage());
                com.inmobi.commons.core.c.a.a().a("root", "InvalidConfig", hashmap1);
            }
            return;
        }
        java.util.Map.Entry entry;
        ConfigResponse configresponse;
        for (Iterator iterator = b.entrySet().iterator(); iterator.hasNext(); c.put(entry.getKey(), configresponse))
        {
            entry = (java.util.Map.Entry)iterator.next();
            configresponse = new ConfigResponse(null, (com.inmobi.commons.core.configs.a)entry.getValue());
            configresponse.a(new ConfigError(ConfigError.ErrorCode.NETWORK_ERROR, "Network error in fetching config."));
        }

        a(new ConfigError(ConfigError.ErrorCode.NETWORK_ERROR, d.c().b()));
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Error code:").append(b().a()).append(" Error message:").append(b().b()).toString());
        HashMap hashmap = new HashMap();
        hashmap.put("name", a(b));
        hashmap.put("errorCode", String.valueOf(d.c().a().getValue()));
        hashmap.put("reason", d.c().b());
        com.inmobi.commons.core.c.a.a().a("root", "InvalidConfig", hashmap);
    }

    public Map a()
    {
        return c;
    }

    public ConfigError b()
    {
        return e;
    }

}
