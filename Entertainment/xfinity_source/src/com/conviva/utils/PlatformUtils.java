// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.conviva.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.simple.JSONValue;

// Referenced classes of package com.conviva.utils:
//            Settings

public abstract class PlatformUtils
{

    protected static PlatformUtils _instance = null;
    private static List logBuffer = new LinkedList();
    protected final String DEFAULT_CLIENT_ID = "0";
    private final int MAX_SIZE_LOGBUFFER = 32;
    public final String _PLATFORM = "Android";
    public String _PLATFORM_VER;
    protected final String _TAG = "CONVIVA";
    private Boolean _isSendingPing;
    private String _pingUrl;
    protected int _referenceCount;
    protected Settings _settings;
    public String clientId;

    protected PlatformUtils(Settings settings)
        throws Exception
    {
        _referenceCount = 0;
        _settings = null;
        clientId = "0";
        _pingUrl = null;
        _isSendingPing = Boolean.valueOf(false);
        _PLATFORM_VER = null;
        _settings = settings;
        _referenceCount = 1;
        _pingUrl = null;
        _isSendingPing = Boolean.valueOf(false);
        _instance = this;
    }

    public static PlatformUtils getInstance()
        throws Exception
    {
        if (_instance == null)
        {
            throw new Exception("CreateUtils module has not been called");
        } else
        {
            return _instance;
        }
    }

    private void initPing()
    {
        if (_pingUrl == null)
        {
            String s1 = null;
            String s = s1;
            if (clientId != null)
            {
                int i = clientId.indexOf('.');
                s = s1;
                if (i >= 0)
                {
                    s = clientId.substring(0, i);
                }
            }
            s1 = s;
            if (s == null)
            {
                s1 = (new Integer(randInt())).toString();
            }
            _pingUrl = (new StringBuilder()).append(_settings.pingUrl).append("?").append("uuid=").append(s1.toString()).append("&comp=").append(_settings.pingComponentName).toString();
        }
    }

    private void onUncaughtException(String s, Exception exception)
    {
        try
        {
            ping((new StringBuilder()).append("Uncaught exception: ").append(exception.toString()).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            err((new StringBuilder()).append("Caught exception while sending ping: ").append(s.toString()).toString());
        }
    }

    private String urlEncodeString(String s)
        throws UnsupportedEncodingException
    {
        return URLEncoder.encode(s, "UTF-8");
    }

    public double epochTimeMs()
    {
        return (double)(new Date()).getTime();
    }

    public void err(String s)
    {
        log((new StringBuilder()).append("ERROR: ").append(s).toString());
    }

    public List getLogs(int i)
    {
        List list = logBuffer;
        logBuffer = new LinkedList();
        return list;
    }

    public abstract Map getPlatformMetadata();

    public Settings getSettings()
    {
        return _settings;
    }

    public abstract void httpRequest(Boolean boolean1, String s, String s1, String s2, CallableWithParameters.With1 with1);

    public abstract Boolean inSleepingMode();

    public abstract Boolean isVisible();

    public Map jsonDecode(String s)
    {
        try
        {
            s = (Map)JSONValue.parse(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            err((new StringBuilder()).append("Failed to decode json string: ").append(s.toString()).toString());
            return null;
        }
        return s;
    }

    public void jsonEncode(Map map, CallableWithParameters.With1 with1)
    {
        try
        {
            with1.exec(JSONValue.toJSONString(map));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            err((new StringBuilder()).append("Failed to encode json object: ").append(map.toString()).toString());
        }
    }

    public void log(String s)
    {
        logConsole(s);
        String s1 = String.format("%.3f", new Object[] {
            Double.valueOf(epochTimeMs() / 1000D)
        });
        s = (new StringBuilder()).append("[").append(s1).append("] ").append(s).toString();
        if (logBuffer.size() >= 32)
        {
            logBuffer.remove(0);
        }
        logBuffer.add(s);
    }

    public abstract void logConsole(String s);

    public void logSession(String s, int i)
    {
        log((new StringBuilder()).append("sid=").append(i).append(" ").append(s).toString());
    }

    public int parseInt(String s, int i)
    {
        int j;
        try
        {
            j = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return i;
        }
        return j;
    }

    public void ping(String s)
    {
        if (_isSendingPing.booleanValue())
        {
            return;
        }
        try
        {
            _isSendingPing = Boolean.valueOf(true);
            initPing();
            s = (new StringBuilder()).append(_pingUrl).append("&d=").append(urlEncodeString(s)).toString();
            err((new StringBuilder()).append("Ping: ").append(s).toString());
            httpRequest(Boolean.valueOf(false), s, null, null, null);
            _isSendingPing = Boolean.valueOf(false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            _isSendingPing = Boolean.valueOf(false);
        }
        err("Failed to send ping");
        return;
    }

    public int randInt()
    {
        return (int)Math.floor(Math.random() * 64000D);
    }

    public void runProtected(Callable callable, String s)
    {
        try
        {
            callable.call();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Callable callable)
        {
            onUncaughtException(s, callable);
        }
    }

    public abstract void setClientIdFromServer(String s);

    public abstract void startFetchClientId();

}
