// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.server;

import android.util.Log;
import com.supersonic.mediationsdk.logger.SupersonicLoggerManager;
import com.supersonic.mediationsdk.logger.ThreadExceptionHandler;
import org.json.JSONObject;

// Referenced classes of package com.supersonic.mediationsdk.server:
//            ServerURL, HttpFunctions

public class Server
{

    private static String TAG = "ServerUtils";
    private static String UniqueUsersURL = "http://www.ultraadserver.com/api/rest/v1.1/uniqueusers?";

    public Server()
    {
    }

    public static void callAsyncRequestURL(String s, boolean flag)
    {
        s = new Thread(new Runnable(s, flag) {

            final boolean val$hit;
            final String val$requestUrl;

            public void run()
            {
                Server.callRequestURL(requestUrl, hit);
            }

            
            {
                requestUrl = s;
                hit = flag;
                super();
            }
        }, "callAsyncRequestURL");
        s.setUncaughtExceptionHandler(new ThreadExceptionHandler());
        s.start();
    }

    public static JSONObject callRequestURL(String s, boolean flag)
    {
        Object obj1 = null;
        Object obj = new JSONObject(HttpFunctions.getStringFromURL(ServerURL.getRequestURL(s, flag)));
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NETWORK, (new StringBuilder()).append("callRequestURL(reqUrl:").append(s).append(", ").append("hit:").append(flag).append(")").toString(), 1);
        return ((JSONObject) (obj));
        obj;
_L2:
        StringBuilder stringbuilder = new StringBuilder("callRequestURL(reqUrl:");
        if (s == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(s);
        }
        stringbuilder.append(", hit:").append(flag).append(")");
        if (obj != null)
        {
            SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NETWORK, (new StringBuilder()).append(stringbuilder.toString()).append(", e:").append(Log.getStackTraceString(((Throwable) (obj)))).toString(), 0);
            return ((JSONObject) (obj1));
        } else
        {
            SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NETWORK, stringbuilder.toString(), 0);
            return ((JSONObject) (obj1));
        }
        Throwable throwable;
        throwable;
        obj1 = obj;
        obj = throwable;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected static String getUniqueUsersBaseURL()
    {
        return UniqueUsersURL;
    }

    public static void notifyUniqueUser(String s, String s1)
    {
        (new Thread(new Runnable(s, s1) {

            JSONObject obj;
            final String val$applicationKey;
            final String val$applicationUserId;

            public void run()
            {
                try
                {
                    obj = new JSONObject(HttpFunctions.getStringFromURL(ServerURL.getUniqueUsersURL(applicationKey, applicationUserId)));
                    return;
                }
                catch (Throwable throwable)
                {
                    StringBuilder stringbuilder = new StringBuilder("notifyUniqueUser(appKey:");
                    if (applicationKey != null)
                    {
                        stringbuilder.append(applicationKey);
                    } else
                    {
                        stringbuilder.append("null");
                    }
                    stringbuilder.append(", userId:");
                    if (applicationUserId != null)
                    {
                        stringbuilder.append(applicationUserId);
                    } else
                    {
                        stringbuilder.append("null");
                    }
                    stringbuilder.append(")");
                    if (throwable != null)
                    {
                        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NETWORK, (new StringBuilder()).append(stringbuilder.toString()).append(", e:").append(Log.getStackTraceString(throwable)).toString(), 0);
                        return;
                    } else
                    {
                        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NETWORK, stringbuilder.toString(), 0);
                        return;
                    }
                }
            }

            
            {
                applicationKey = s;
                applicationUserId = s1;
                super();
                obj = null;
            }
        })).start();
    }

}
