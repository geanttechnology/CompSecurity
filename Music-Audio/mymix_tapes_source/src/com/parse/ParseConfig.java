// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import bolts.Continuation;
import bolts.Task;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            TaskQueue, ParseDecoder, ParseException, Parse, 
//            ParseCommand, ParseUser, PointerEncodingStrategy, ParseFile, 
//            ParseGeoPoint, ConfigCallback

public class ParseConfig
{

    static final String CURRENT_CONFIG_FILENAME = "currentConfig";
    private static ParseConfig currentConfig;
    private static final Object currentConfigMutex = new Object();
    private static final TaskQueue taskQueue = new TaskQueue();
    private final Map params;

    ParseConfig()
    {
        params = Collections.unmodifiableMap(new HashMap());
    }

    ParseConfig(JSONObject jsonobject, ParseDecoder parsedecoder)
        throws JSONException
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

    static void clearCurrentConfigForTesting()
    {
        synchronized (currentConfigMutex)
        {
            currentConfig = null;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static ParseConfig get()
        throws ParseException
    {
        return (ParseConfig)Parse.waitForTask(getInBackground());
    }

    private static Task getAsync(Task task)
    {
        ParseCommand parsecommand = new ParseCommand("client_config", ParseUser.getCurrentSessionToken());
        parsecommand.enableRetrying();
        return task.continueWithTask(new Continuation(parsecommand) {

            final ParseCommand val$command;

            public Task then(Task task1)
                throws Exception
            {
                return command.executeAsync().cast();
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                command = parsecommand;
                super();
            }
        }).onSuccess(new Continuation() {

            public ParseConfig then(Task task1)
                throws Exception
            {
                ParseConfig parseconfig = new ParseConfig((JSONObject)task1.getResult(), new ParseDecoder());
                parseconfig.saveToDisk(Parse.applicationContext, "currentConfig");
                synchronized (ParseConfig.currentConfigMutex)
                {
                    ParseConfig.currentConfig = parseconfig;
                    parseconfig = ParseConfig.currentConfig;
                }
                return parseconfig;
                exception;
                task1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

        }, Task.BACKGROUND_EXECUTOR);
    }

    public static ParseConfig getCurrentConfig()
    {
        if (currentConfig != null) goto _L2; else goto _L1
_L1:
        Object obj = currentConfigMutex;
        obj;
        JVM INSTR monitorenter ;
        ParseConfig parseconfig = getFromDisk(Parse.applicationContext, "currentConfig");
        if (parseconfig == null) goto _L4; else goto _L3
_L3:
        currentConfig = parseconfig;
        obj;
        JVM INSTR monitorexit ;
_L2:
        return currentConfig;
_L4:
        parseconfig = new ParseConfig();
        if (true) goto _L3; else goto _L5
_L5:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static ParseConfig getFromDisk(Context context, String s)
    {
        context = Parse.getDiskObject(context, s);
        if (context == null)
        {
            return null;
        }
        try
        {
            context = new ParseConfig(context, new ParseDecoder());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    public static Task getInBackground()
    {
        return taskQueue.enqueue(new Continuation() {

            public Task then(Task task)
                throws Exception
            {
                return ParseConfig.getAsync(task);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

        });
    }

    public static void getInBackground(ConfigCallback configcallback)
    {
        Parse.callbackOnMainThreadAsync(getInBackground(), configcallback);
    }

    private void saveToDisk(Context context, String s)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("params", (JSONObject)Parse.encode(params, PointerEncodingStrategy.get()));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeException("could not serialize config to JSON");
        }
        Parse.saveDiskObject(context, s, jsonobject);
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
            s = ((String) (Parse.encode(s, PointerEncodingStrategy.get())));
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
            s = ((String) (Parse.encode(s, PointerEncodingStrategy.get())));
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







/*
    static ParseConfig access$302(ParseConfig parseconfig)
    {
        currentConfig = parseconfig;
        return parseconfig;
    }

*/
}
