// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.medialets;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.renderer.ParamParser;

public class Parameters
{

    public static final String FW_PARAMETER_AD_BLOCK_KEYWORDS = "adBlockKeywords";
    public static final String FW_PARAMETER_AD_BLOCK_KEYWORDS_2 = "adBlockKeywords2";
    public static final String FW_PARAMETER_AD_SLOT_KEY = "adSlotKey";
    public static final String FW_PARAMETER_AD_SLOT_KEYWORDS = "adSlotKeywords";
    public static final String FW_PARAMETER_AD_SLOT_KEYWORDS_2 = "adSlotKeywords2";
    public static final String FW_PARAMETER_KEY_VALUE_PAIRS = "keyValuePairs";
    public static final String FW_PARAMETER_NAMESPACE_PREFIX = "renderer.medialets";
    private String adBlockKeywords;
    private String adSlotKey;
    private String adSlotKeywords;
    private HashMap keyValuePairs;
    private Logger logger;
    private boolean serviceConnected;

    public Parameters()
    {
        serviceConnected = false;
        logger = Logger.getLogger(this);
    }

    private String merge(String s, String s1)
    {
        logger.debug((new StringBuilder()).append("merg(").append(s).append(",").append(s1).append(")").toString());
        String s2;
        if (s == null || s.length() == 0)
        {
            s2 = s1;
        } else
        {
            s2 = s;
            if (s1 != null)
            {
                s2 = s;
                if (s1.length() != 0)
                {
                    s = s.split(",");
                    String as[] = s1.split(",");
                    s1 = new HashSet();
                    s1.addAll(Arrays.asList(s));
                    s1.addAll(Arrays.asList(as));
                    s = new StringBuilder();
                    String s3;
                    for (s1 = s1.iterator(); s1.hasNext(); s.append((new StringBuilder()).append(s3).append(",").toString()))
                    {
                        s3 = (String)s1.next();
                    }

                    if (s.length() > 0)
                    {
                        s.deleteCharAt(s.length() - 1);
                    }
                    logger.debug((new StringBuilder()).append("merg result:").append(s).toString());
                    return s.toString();
                }
            }
        }
        return s2;
    }

    private HashMap parseKeyValues(String s)
    {
        logger.debug((new StringBuilder()).append("parseKeyValues(").append(s).append(")").toString());
        if (s == null || s.length() == 0)
        {
            s = null;
        } else
        {
            HashMap hashmap = new HashMap();
            s = s.split("&");
            int j = s.length;
            int i = 0;
            while (i < j) 
            {
                String s1 = s[i];
                String as[] = s1.split("=");
                if (as.length == 2)
                {
                    hashmap.put(as[0], as[1]);
                } else
                {
                    logger.debug((new StringBuilder()).append("invalid key value pair:").append(s1).toString());
                }
                i++;
            }
            s = hashmap;
            if (hashmap.isEmpty())
            {
                return null;
            }
        }
        return s;
    }

    public void extractParam(IRendererContext irenderercontext)
    {
        ParamParser paramparser;
label0:
        {
            paramparser = new ParamParser(irenderercontext, "renderer.medialets");
            serviceConnected = paramparser.parseBoolean("extension.medialets.service_connected", Boolean.valueOf(false)).booleanValue();
            adSlotKey = paramparser.parseString("adSlotKey", null);
            keyValuePairs = parseKeyValues(paramparser.parseString("keyValuePairs", null));
            String s = merge(paramparser.parseString("adSlotKeywords", null), paramparser.parseString("adSlotKeywords2", null));
            if (s != null)
            {
                irenderercontext = s;
                if (s.length() != 0)
                {
                    break label0;
                }
            }
            irenderercontext = null;
        }
label1:
        {
            adSlotKeywords = irenderercontext;
            String s1 = merge(paramparser.parseString("adBlockKeywords", null), paramparser.parseString("adBlockKeywords2", null));
            if (s1 != null)
            {
                irenderercontext = s1;
                if (s1.length() != 0)
                {
                    break label1;
                }
            }
            irenderercontext = null;
        }
        adBlockKeywords = irenderercontext;
        logger.debug(toJSONString());
    }

    public String getAdBlockKeywords()
    {
        return adBlockKeywords;
    }

    public String getAdSlotKey()
    {
        return adSlotKey;
    }

    public String getAdSlotKeywords()
    {
        return adSlotKeywords;
    }

    public HashMap getKeyValuePairs()
    {
        return keyValuePairs;
    }

    public boolean serviceConnected()
    {
        return serviceConnected;
    }

    public String toJSONString()
    {
        JSONObject jsonobject;
        int i;
        jsonobject = new JSONObject();
        i = 0;
_L2:
        Field field;
        if (i >= tv/freewheel/renderers/medialets/Parameters.getDeclaredFields().length)
        {
            break; /* Loop/switch isn't completed */
        }
        field = tv/freewheel/renderers/medialets/Parameters.getDeclaredFields()[i];
        if (Modifier.isStatic(field.getModifiers()))
        {
            break MISSING_BLOCK_LABEL_116;
        }
        Object obj1 = field.get(this);
        Object obj = obj1;
        if (obj1 instanceof Calendar)
        {
            obj = ((Calendar)obj1).getTime().toString();
        }
        obj1 = obj;
        if (!(obj instanceof Integer))
        {
            break MISSING_BLOCK_LABEL_105;
        }
        obj1 = obj;
        if (field.getName().indexOf("Color") >= 0)
        {
            obj1 = Integer.toHexString(((Integer)obj).intValue());
        }
        jsonobject.put(field.getName(), obj1);
_L3:
        i++;
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        logger.error(exception.toString());
          goto _L3
_L1:
        return jsonobject.toString();
    }
}
