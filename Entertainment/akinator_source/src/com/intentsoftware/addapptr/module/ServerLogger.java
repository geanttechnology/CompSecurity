// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.intentsoftware.addapptr.module;

import android.content.Context;
import com.intentsoftware.addapptr.http.PostRequest;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Queue;
import org.apache.http.entity.StringEntity;

// Referenced classes of package com.intentsoftware.addapptr.module:
//            Logger

public class ServerLogger
{

    private static final String LOG_SERVER_URL = "https://loghost.addapptr.com/cgi-bin/logger.cgi";
    private static final int LOG_SIZE = 200;
    private static Queue log = new LimitedQueue(200);
    private static String packageName;

    public ServerLogger()
    {
    }

    public static void init(Context context)
    {
        packageName = context.getApplicationContext().getPackageName();
    }

    public static void log(String s)
    {
        long l = System.currentTimeMillis() / 1000L;
        if (Logger.isLoggable(2))
        {
            Logger.v(com/intentsoftware/addapptr/module/ServerLogger, (new StringBuilder()).append("adding log line: ").append(s).toString());
        }
        log.add((new StringBuilder()).append(l).append(": ").append(s).append("\n").toString());
    }

    public static void writeLog(String s)
    {
        String s3 = (new StringBuilder()).append(packageName).append("_Trigger.").append(s).append(".txt").toString();
        String s2 = (new StringBuilder()).append("https://loghost.addapptr.com/cgi-bin/logger.cgi?").append(s3).toString();
        String s1 = "";
        for (Iterator iterator = log.iterator(); iterator.hasNext();)
        {
            String s4 = (String)iterator.next();
            s1 = (new StringBuilder()).append(s1).append(s4).toString();
        }

        s1 = (new StringBuilder()).append(s1).append(s3).toString();
        s1 = (new StringBuilder()).append(s1).append("\n------------------------------------------------------\n").toString();
        if (Logger.isLoggable(2))
        {
            Logger.v(com/intentsoftware/addapptr/module/ServerLogger, (new StringBuilder()).append("sending log file, trigger: ").append(s).toString());
            Logger.v(com/intentsoftware/addapptr/module/ServerLogger, (new StringBuilder()).append("contents:\n").append(s1).toString());
        }
        try
        {
            new PostRequest(s2, new StringEntity(s1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }


    // Unreferenced inner class com/intentsoftware/addapptr/module/ServerLogger$LimitedQueue
    /* block-local class not found */
    class LimitedQueue {}

}
