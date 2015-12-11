// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.content.Context;
import atz;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

// Referenced classes of package com.adobe.mobile:
//            StaticMethods

abstract class WearableDataRequest
{

    protected int timeOut;
    protected String uuid;

    protected WearableDataRequest()
    {
        uuid = UUID.randomUUID().toString();
    }

    protected WearableDataRequest(int i)
    {
        this();
        timeOut = i;
    }

    protected static WearableDataRequest createFileRequest(String s, String s1, int i)
    {
        return new Cache(s, s1, i);
    }

    protected static WearableDataRequest createGetRequest(String s, int i)
    {
        return new Get(s, i);
    }

    protected static WearableDataRequest createPostRequest(String s, String s1, int i)
    {
        return new Post(s, s1, i);
    }

    protected static WearableDataRequest createRequestFromDataMap(atz atz1)
    {
        if (atz1.a("Type"))
        {
            if (atz1.f("Type").equals("POST"))
            {
                return new Post(atz1);
            }
            if (atz1.f("Type").equals("GET"))
            {
                return new Get(atz1);
            }
            if (atz1.f("Type").equals("Config"))
            {
                return new ShareConfig(atz1);
            }
            if (atz1.f("Type").equals("File"))
            {
                return new Cache(atz1);
            }
            if (atz1.f("Type").equals("ThirdParty"))
            {
                return new ThirdPartyRequest(atz1);
            }
        }
        return null;
    }

    protected static WearableDataRequest createShareConfigRequest(int i)
    {
        return new ShareConfig(i);
    }

    protected static WearableDataRequest createThirdPartyRequest(String s, String s1, int i, String s2)
    {
        return new ThirdPartyRequest(s, s1, i, s2);
    }

    private static byte[] readFile(File file)
    {
        byte abyte0[] = new byte[(int)file.length()];
        Object obj = new FileInputStream(file);
        file = ((File) (obj));
        int i = ((InputStream) (obj)).read(abyte0);
        if (i != -1) goto _L2; else goto _L1
_L1:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                StaticMethods.logDebugFormat("Wearable - Failed to close the file input stream", new Object[0]);
                return null;
            }
        }
_L4:
        return null;
_L2:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                StaticMethods.logDebugFormat("Wearable - Failed to close the file input stream", new Object[0]);
            }
        }
        return abyte0;
        file;
        file = null;
_L9:
        StaticMethods.logErrorFormat("Wearable - Failed to read cached file", new Object[0]);
        if (file == null) goto _L4; else goto _L3
_L3:
        try
        {
            file.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            StaticMethods.logDebugFormat("Wearable - Failed to close the file input stream", new Object[0]);
            return null;
        }
        return null;
        file;
        obj = null;
_L8:
        file = ((File) (obj));
        StaticMethods.logErrorFormat("Wearable - Failed to read cached file", new Object[0]);
        if (obj == null) goto _L4; else goto _L5
_L5:
        try
        {
            ((InputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            StaticMethods.logDebugFormat("Wearable - Failed to close the file input stream", new Object[0]);
            return null;
        }
        return null;
        obj;
        file = null;
_L7:
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                StaticMethods.logDebugFormat("Wearable - Failed to close the file input stream", new Object[0]);
            }
        }
        throw obj;
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L7; else goto _L6
_L6:
        file;
          goto _L8
        file;
        file = ((File) (obj));
          goto _L9
    }

    protected abstract atz getDataMap();

    protected int getTimeOut()
    {
        return timeOut;
    }

    protected String getUUID()
    {
        return uuid;
    }

    protected abstract atz handle(Context context);


    private class Cache extends WearableDataRequest
    {

        protected String fileName;
        protected String url;

        protected atz getDataMap()
        {
            atz atz1 = new atz();
            atz1.a("Type", "File");
            atz1.a("ID", uuid);
            atz1.a("URL", url);
            atz1.a("FileName", fileName);
            return atz1;
        }

        protected atz handle(Context context)
        {
            context = new atz();
            context.a("ID", uuid);
            context.a("Type", "File");
            context.a("URL", url);
            File file = RemoteDownload.getFileForCachedURL(url);
            if (file == null)
            {
                context.a("FileFound", false);
            } else
            {
                context.a("FileFound", true);
                if (file.getName().equals(fileName))
                {
                    context.a("Updated", false);
                    return context;
                }
                context.a("Updated", true);
                context.a("FileName", file.getName());
                byte abyte0[] = WearableDataRequest.readFile(file);
                if (abyte0 != null && abyte0.length > 0)
                {
                    context.a("FileContent", Asset.a(abyte0));
                    return context;
                }
            }
            return context;
        }

        protected Cache(atz atz1)
        {
            uuid = atz1.f("ID");
            fileName = atz1.f("FileName");
            url = atz1.f("URL");
        }

        protected Cache(String s, String s1, int i)
        {
            super(i);
            url = s;
            fileName = s1;
        }
    }


    private class Get extends WearableDataRequest
    {

        protected static final String logPrefix = "Wearable GET Requested Forward";
        protected String url;

        protected atz getDataMap()
        {
            atz atz1 = new atz();
            atz1.a("ID", uuid);
            atz1.a("Timeout", timeOut);
            atz1.a("Type", "GET");
            atz1.a("URL", url);
            return atz1;
        }

        protected String getURL()
        {
            return url;
        }

        protected atz handle(Context context)
        {
            context = new atz();
            context.a("Result", RequestHandler.retrieveData(url, null, timeOut, "Wearable GET Requested Forward"));
            context.a("ID", uuid);
            context.a("Type", "GET");
            return context;
        }

        protected Get(atz atz1)
        {
            url = atz1.f("URL");
            uuid = atz1.f("ID");
            timeOut = atz1.d("Timeout");
        }

        protected Get(String s, int i)
        {
            super(i);
            url = s;
        }
    }


    private class Post extends WearableDataRequest
    {

        private static final Object _userAgentMutex = new Object();
        protected static final String logPrefix = "Wearable POST Request Forward";
        private static String userAgent = null;
        protected String body;
        protected String url;

        protected static String getDefaultAcceptLanguage(Context context)
        {
            if (context != null)
            {
                if ((context = context.getResources()) != null && (context = context.getConfiguration()) != null && (context = ((Configuration) (context)).locale) != null)
                {
                    return context.toString().replace('_', '-');
                }
            }
            return null;
        }

        protected static String getDefaultUserAgent(Context context)
        {
            synchronized (_userAgentMutex)
            {
                if (userAgent == null)
                {
                    userAgent = (new StringBuilder()).append("Mozilla/5.0 (Linux; U; Android ").append(android.os.Build.VERSION.RELEASE).append("; ").append(getDefaultAcceptLanguage(context)).append("; ").append(Build.MODEL).append(" Build/").append(Build.ID).append(")").toString();
                }
                context = userAgent;
            }
            return context;
            context;
            obj;
            JVM INSTR monitorexit ;
            throw context;
        }

        protected atz getDataMap()
        {
            atz atz1 = new atz();
            atz1.a("ID", uuid);
            atz1.a("Type", "POST");
            atz1.a("URL", url);
            atz1.a("Timeout", timeOut);
            atz1.a("Body", body);
            return atz1;
        }

        protected String getURL()
        {
            return url;
        }

        protected atz handle(Context context)
        {
            atz atz1 = new atz();
            HashMap hashmap = new HashMap();
            hashmap.put("Accept-Language", getDefaultAcceptLanguage(context));
            hashmap.put("User-Agent", getDefaultUserAgent(context));
            atz1.a("Result", RequestHandler.sendAnalyticsRequest(url, body, hashmap, timeOut, "Wearable POST Request Forward"));
            atz1.a("ID", uuid);
            atz1.a("Type", "POST");
            return atz1;
        }


        protected Post()
        {
        }

        protected Post(atz atz1)
        {
            timeOut = atz1.d("Timeout");
            url = atz1.f("URL");
            body = atz1.f("Body");
            uuid = atz1.f("ID");
        }

        protected Post(String s, String s1, int i)
        {
            super(i);
            url = s;
            body = s1;
        }
    }


    private class ShareConfig extends WearableDataRequest
    {

        protected atz getDataMap()
        {
            atz atz1 = new atz();
            atz1.a("Type", "Config");
            atz1.a("ID", uuid);
            return atz1;
        }

        protected atz handle(Context context)
        {
            context = new atz();
            context.a("ID", uuid);
            context.a("Type", "Config");
            context.a(ConfigSynchronizer.getSharedConfig());
            return context;
        }

        protected ShareConfig(int i)
        {
            super(i);
        }

        protected ShareConfig(atz atz1)
        {
            uuid = atz1.f("ID");
        }
    }


    private class ThirdPartyRequest extends Post
    {

        protected static final String logPrefix = "Wearable Third Party Request Forward";
        protected String postType;

        protected atz getDataMap()
        {
            atz atz1 = super.getDataMap();
            atz1.a("Type", "ThirdParty");
            atz1.a("PostType", postType);
            return atz1;
        }

        protected atz handle(Context context)
        {
            atz atz1 = new atz();
            HashMap hashmap = new HashMap();
            hashmap.put("Accept-Language", getDefaultAcceptLanguage(context));
            hashmap.put("User-Agent", getDefaultUserAgent(context));
            atz1.a("Result", RequestHandler.sendThirdPartyRequest(url, body, hashmap, timeOut, postType, "Wearable Third Party Request Forward"));
            atz1.a("ID", uuid);
            atz1.a("Type", "ThirdParty");
            return atz1;
        }

        protected ThirdPartyRequest(atz atz1)
        {
            super(atz1);
            postType = atz1.f("PostType");
        }

        protected ThirdPartyRequest(String s, String s1, int i)
        {
            super(s, s1, i);
        }

        protected ThirdPartyRequest(String s, String s1, int i, String s2)
        {
            this(s, s1, i);
            postType = s2;
        }
    }

}
