// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.SSLSessionCache;
import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
import com.parse.http.ParseNetworkInterceptor;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.parse:
//            InstallationId, ParseHttpClient, Parse, ManifestInfo

class ParsePlugins
{
    static class Android extends ParsePlugins
    {

        private final Context applicationContext;

        static Android get()
        {
            return (Android)ParsePlugins.get();
        }

        static void initialize(Context context, String s, String s1)
        {
            ParsePlugins.set(new Android(context, s, s1));
        }

        Context applicationContext()
        {
            return applicationContext;
        }

        File getCacheDir()
        {
            File file;
            synchronized (lock)
            {
                if (cacheDir == null)
                {
                    cacheDir = new File(applicationContext.getCacheDir(), "com.parse");
                }
                file = ParsePlugins.createFileDir(cacheDir);
            }
            return file;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        File getFilesDir()
        {
            File file;
            synchronized (lock)
            {
                if (filesDir == null)
                {
                    filesDir = new File(applicationContext.getFilesDir(), "com.parse");
                }
                file = ParsePlugins.createFileDir(filesDir);
            }
            return file;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        File getParseDir()
        {
            File file;
            synchronized (lock)
            {
                if (parseDir == null)
                {
                    parseDir = applicationContext.getDir("Parse", 0);
                }
                file = ParsePlugins.createFileDir(parseDir);
            }
            return file;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public ParseHttpClient newHttpClient()
        {
            return ParseHttpClient.createClient(10000, new SSLSessionCache(applicationContext));
        }

        String userAgent()
        {
            String s = "unknown";
            String s1;
            s1 = applicationContext.getPackageName();
            int i = applicationContext.getPackageManager().getPackageInfo(s1, 0).versionCode;
            s1 = (new StringBuilder()).append(s1).append("/").append(i).toString();
            s = s1;
_L2:
            return (new StringBuilder()).append("Parse Android SDK 1.10.3 (").append(s).append(") API Level ").append(android.os.Build.VERSION.SDK_INT).toString();
            android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
            namenotfoundexception;
            if (true) goto _L2; else goto _L1
_L1:
        }

        private Android(Context context, String s, String s1)
        {
            super(s, s1, null);
            applicationContext = context.getApplicationContext();
        }
    }


    private static final String INSTALLATION_ID_LOCATION = "installationId";
    private static final Object LOCK = new Object();
    private static ParsePlugins instance;
    private final String applicationId;
    File cacheDir;
    private final String clientKey;
    File filesDir;
    private InstallationId installationId;
    final Object lock;
    File parseDir;
    private ParseHttpClient restClient;

    private ParsePlugins(String s, String s1)
    {
        lock = new Object();
        applicationId = s;
        clientKey = s1;
    }


    private static File createFileDir(File file)
    {
        if (!file.exists())
        {
            if (file.mkdirs());
        }
        return file;
    }

    static ParsePlugins get()
    {
        ParsePlugins parseplugins;
        synchronized (LOCK)
        {
            parseplugins = instance;
        }
        return parseplugins;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static void initialize(String s, String s1)
    {
        set(new ParsePlugins(s, s1));
    }

    static void reset()
    {
        synchronized (LOCK)
        {
            instance = null;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static void set(ParsePlugins parseplugins)
    {
        Object obj = LOCK;
        obj;
        JVM INSTR monitorenter ;
        if (instance != null)
        {
            throw new IllegalStateException("ParsePlugins is already initialized");
        }
        break MISSING_BLOCK_LABEL_27;
        parseplugins;
        obj;
        JVM INSTR monitorexit ;
        throw parseplugins;
        instance = parseplugins;
        obj;
        JVM INSTR monitorexit ;
    }

    String applicationId()
    {
        return applicationId;
    }

    String clientKey()
    {
        return clientKey;
    }

    File getCacheDir()
    {
        throw new IllegalStateException("Stub");
    }

    File getFilesDir()
    {
        throw new IllegalStateException("Stub");
    }

    File getParseDir()
    {
        throw new IllegalStateException("Stub");
    }

    InstallationId installationId()
    {
        InstallationId installationid;
        synchronized (lock)
        {
            if (installationId == null)
            {
                installationId = new InstallationId(new File(getParseDir(), "installationId"));
            }
            installationid = installationId;
        }
        return installationid;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ParseHttpClient newHttpClient()
    {
        return ParseHttpClient.createClient(10000, null);
    }

    ParseHttpClient restClient()
    {
        ParseHttpClient parsehttpclient;
        synchronized (lock)
        {
            if (restClient == null)
            {
                restClient = newHttpClient();
                restClient.addInternalInterceptor(new ParseNetworkInterceptor() {

                    final ParsePlugins this$0;

                    public ParseHttpResponse intercept(com.parse.http.ParseNetworkInterceptor.Chain chain)
                        throws IOException
                    {
                        ParseHttpRequest parsehttprequest = chain.getRequest();
                        com.parse.http.ParseHttpRequest.Builder builder = (new com.parse.http.ParseHttpRequest.Builder(parsehttprequest)).addHeader("X-Parse-Application-Id", applicationId).addHeader("X-Parse-Client-Key", clientKey).addHeader("X-Parse-Client-Version", Parse.externalVersionName()).addHeader("X-Parse-App-Build-Version", String.valueOf(ManifestInfo.getVersionCode())).addHeader("X-Parse-App-Display-Version", ManifestInfo.getVersionName()).addHeader("X-Parse-OS-Version", android.os.Build.VERSION.RELEASE).addHeader("User-Agent", userAgent());
                        if (parsehttprequest.getHeader("X-Parse-Installation-Id") == null)
                        {
                            builder.addHeader("X-Parse-Installation-Id", installationId().get());
                        }
                        return chain.proceed(builder.build());
                    }

            
            {
                this$0 = ParsePlugins.this;
                super();
            }
                });
            }
            parsehttpclient = restClient;
        }
        return parsehttpclient;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    String userAgent()
    {
        return "Parse Java SDK";
    }




}
