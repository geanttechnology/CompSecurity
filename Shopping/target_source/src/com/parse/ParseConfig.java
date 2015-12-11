// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            TaskQueue, ParseDecoder, ParseException, ParseTaskUtils, 
//            ParseUser, ParseCorePlugins, ParseConfigController, ParseCurrentConfigController, 
//            PointerEncoder, ParseFile, ParseGeoPoint, ConfigCallback

public class ParseConfig
{

    static final TaskQueue taskQueue = new TaskQueue();
    final Map params;

    ParseConfig()
    {
        params = Collections.unmodifiableMap(new HashMap());
    }

    ParseConfig(JSONObject jsonobject, ParseDecoder parsedecoder)
    {
        jsonobject = (Map)((Map)parsedecoder.decode(jsonobject)).get("params");
        if (jsonobject == null)
        {
            throw new RuntimeException("Object did not contain the 'params' key.");
        } else
        {
            params = Collections.unmodifiableMap(jsonobject);
            return;
        }
    }

    public static ParseConfig get()
        throws ParseException
    {
        return (ParseConfig)ParseTaskUtils.wait(getInBackground());
    }

    private static j getAsync(j j1)
    {
        return ParseUser.getCurrentSessionTokenAsync().d(new i(j1) {

            final j val$toAwait;

            public j then(j j2)
                throws Exception
            {
                j2 = (String)j2.e();
                return toAwait.b(j2. new i() {

                    final _cls2 this$0;
                    final String val$sessionToken;

                    public j then(j j1)
                        throws Exception
                    {
                        return ParseConfig.getConfigController().getAsync(sessionToken);
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$0 = final__pcls2;
                sessionToken = String.this;
                super();
            }
                });
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                toAwait = j1;
                super();
            }
        });
    }

    static ParseConfigController getConfigController()
    {
        return ParseCorePlugins.getInstance().getConfigController();
    }

    public static ParseConfig getCurrentConfig()
    {
        ParseConfig parseconfig;
        try
        {
            parseconfig = (ParseConfig)ParseTaskUtils.wait(getConfigController().getCurrentConfigController().getCurrentConfigAsync());
        }
        catch (ParseException parseexception)
        {
            return new ParseConfig();
        }
        return parseconfig;
    }

    public static j getInBackground()
    {
        return taskQueue.enqueue(new i() {

            public j then(j j1)
                throws Exception
            {
                return ParseConfig.getAsync(j1);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

        });
    }

    public static void getInBackground(ConfigCallback configcallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(getInBackground(), configcallback);
    }

    public Object get(String s)
    {
        return get(s, null);
    }

    public Object get(String s, Object obj)
    {
        if (!params.containsKey(s))
        {
            return obj;
        }
        if (params.get(s) == JSONObject.NULL)
        {
            return null;
        } else
        {
            return params.get(s);
        }
    }

    public boolean getBoolean(String s)
    {
        return getBoolean(s, false);
    }

    public boolean getBoolean(String s, boolean flag)
    {
        if (params.containsKey(s))
        {
            if ((s = ((String) (params.get(s)))) instanceof Boolean)
            {
                return ((Boolean)s).booleanValue();
            }
        }
        return flag;
    }

    public Date getDate(String s)
    {
        return getDate(s, null);
    }

    public Date getDate(String s, Date date)
    {
        if (!params.containsKey(s))
        {
            return date;
        }
        s = ((String) (params.get(s)));
        if (s == null || s == JSONObject.NULL)
        {
            return null;
        }
        if (s instanceof Date)
        {
            s = (Date)s;
        } else
        {
            s = date;
        }
        return s;
    }

    public double getDouble(String s)
    {
        return getDouble(s, 0.0D);
    }

    public double getDouble(String s, double d)
    {
        s = getNumber(s);
        if (s != null)
        {
            d = s.doubleValue();
        }
        return d;
    }

    public int getInt(String s)
    {
        return getInt(s, 0);
    }

    public int getInt(String s, int i)
    {
        s = getNumber(s);
        if (s != null)
        {
            i = s.intValue();
        }
        return i;
    }

    public JSONArray getJSONArray(String s)
    {
        return getJSONArray(s, null);
    }

    public JSONArray getJSONArray(String s, JSONArray jsonarray)
    {
        s = getList(s);
        if (s != null)
        {
            s = ((String) (PointerEncoder.get().encode(s)));
        } else
        {
            s = null;
        }
        if (s == null || (s instanceof JSONArray))
        {
            jsonarray = (JSONArray)s;
        }
        return jsonarray;
    }

    public JSONObject getJSONObject(String s)
    {
        return getJSONObject(s, null);
    }

    public JSONObject getJSONObject(String s, JSONObject jsonobject)
    {
        s = getMap(s);
        if (s != null)
        {
            s = ((String) (PointerEncoder.get().encode(s)));
        } else
        {
            s = null;
        }
        if (s == null || (s instanceof JSONObject))
        {
            jsonobject = (JSONObject)s;
        }
        return jsonobject;
    }

    public List getList(String s)
    {
        return getList(s, null);
    }

    public List getList(String s, List list)
    {
        if (!params.containsKey(s))
        {
            return list;
        }
        s = ((String) (params.get(s)));
        if (s == null || s == JSONObject.NULL)
        {
            return null;
        }
        if (s instanceof List)
        {
            s = (List)s;
        } else
        {
            s = list;
        }
        return s;
    }

    public long getLong(String s)
    {
        return getLong(s, 0L);
    }

    public long getLong(String s, long l)
    {
        s = getNumber(s);
        if (s != null)
        {
            l = s.longValue();
        }
        return l;
    }

    public Map getMap(String s)
    {
        return getMap(s, null);
    }

    public Map getMap(String s, Map map)
    {
        if (!params.containsKey(s))
        {
            return map;
        }
        s = ((String) (params.get(s)));
        if (s == null || s == JSONObject.NULL)
        {
            return null;
        }
        if (s instanceof Map)
        {
            s = (Map)s;
        } else
        {
            s = map;
        }
        return s;
    }

    public Number getNumber(String s)
    {
        return getNumber(s, null);
    }

    public Number getNumber(String s, Number number)
    {
        if (!params.containsKey(s))
        {
            return number;
        }
        s = ((String) (params.get(s)));
        if (s == null || s == JSONObject.NULL)
        {
            return null;
        }
        if (s instanceof Number)
        {
            s = (Number)s;
        } else
        {
            s = number;
        }
        return s;
    }

    Map getParams()
    {
        return Collections.unmodifiableMap(new HashMap(params));
    }

    public ParseFile getParseFile(String s)
    {
        return getParseFile(s, null);
    }

    public ParseFile getParseFile(String s, ParseFile parsefile)
    {
        if (!params.containsKey(s))
        {
            return parsefile;
        }
        s = ((String) (params.get(s)));
        if (s == null || s == JSONObject.NULL)
        {
            return null;
        }
        if (s instanceof ParseFile)
        {
            s = (ParseFile)s;
        } else
        {
            s = parsefile;
        }
        return s;
    }

    public ParseGeoPoint getParseGeoPoint(String s)
    {
        return getParseGeoPoint(s, null);
    }

    public ParseGeoPoint getParseGeoPoint(String s, ParseGeoPoint parsegeopoint)
    {
        if (!params.containsKey(s))
        {
            return parsegeopoint;
        }
        s = ((String) (params.get(s)));
        if (s == null || s == JSONObject.NULL)
        {
            return null;
        }
        if (s instanceof ParseGeoPoint)
        {
            s = (ParseGeoPoint)s;
        } else
        {
            s = parsegeopoint;
        }
        return s;
    }

    public String getString(String s)
    {
        return getString(s, null);
    }

    public String getString(String s, String s1)
    {
        if (!params.containsKey(s))
        {
            return s1;
        }
        s = ((String) (params.get(s)));
        if (s == null || s == JSONObject.NULL)
        {
            return null;
        }
        if (s instanceof String)
        {
            s = (String)s;
        } else
        {
            s = s1;
        }
        return s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ParseConfig[").append(params.toString()).append("]").toString();
    }


}
