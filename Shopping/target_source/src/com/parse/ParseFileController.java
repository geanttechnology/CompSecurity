// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParsePlugins, ParseFileUtils, ParseExecutors, ParseRESTCommand, 
//            ParseHttpClient, ProgressCallback, ParseAWSRequest

class ParseFileController
{

    private ParseHttpClient awsClient;
    private final File cachePath;
    private final Object lock = new Object();
    private final ParseHttpClient restClient;

    public ParseFileController(ParseHttpClient parsehttpclient, File file)
    {
        restClient = parsehttpclient;
        cachePath = file;
    }

    ParseFileController awsClient(ParseHttpClient parsehttpclient)
    {
        synchronized (lock)
        {
            awsClient = parsehttpclient;
        }
        return this;
        parsehttpclient;
        obj;
        JVM INSTR monitorexit ;
        throw parsehttpclient;
    }

    ParseHttpClient awsClient()
    {
        ParseHttpClient parsehttpclient;
        synchronized (lock)
        {
            if (awsClient == null)
            {
                awsClient = ParsePlugins.get().newHttpClient();
            }
            parsehttpclient = awsClient;
        }
        return parsehttpclient;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void clearCache()
    {
        File afile[] = cachePath.listFiles();
        if (afile != null)
        {
            int k = afile.length;
            int i = 0;
            while (i < k) 
            {
                ParseFileUtils.deleteQuietly(afile[i]);
                i++;
            }
        }
    }

    public j fetchAsync(final ParseFile.State state, final String cacheFile, final ProgressCallback downloadProgressCallback, final j cancellationToken)
    {
        if (cancellationToken != null && cancellationToken.c())
        {
            return j.h();
        } else
        {
            cacheFile = getCacheFile(state);
            return j.a(new Callable() {

                final ParseFileController this$0;
                final File val$cacheFile;

                public Boolean call()
                    throws Exception
                {
                    return Boolean.valueOf(cacheFile.exists());
                }

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

            
            {
                this$0 = ParseFileController.this;
                cacheFile = file;
                super();
            }
            }, ParseExecutors.io()).b(new i() {

                final ParseFileController this$0;
                final File val$cacheFile;
                final j val$cancellationToken;
                final ProgressCallback val$downloadProgressCallback;
                final ParseFile.State val$state;

                public j then(j j1)
                    throws Exception
                {
                    if (((Boolean)j1.e()).booleanValue())
                    {
                        return j.a(cacheFile);
                    }
                    if (cancellationToken != null && cancellationToken.c())
                    {
                        return j.h();
                    } else
                    {
                        j1 = getTempFile(state);
                        return (new ParseAWSRequest(com.parse.http.ParseHttpRequest.Method.GET, state.url(), j1)).executeAsync(awsClient(), null, downloadProgressCallback, cancellationToken).b(j1. new i() {

                            final _cls3 this$1;
                            final File val$tempFile;

                            public j then(j j1)
                                throws Exception
                            {
                                if (cancellationToken != null && cancellationToken.c())
                                {
                                    throw new CancellationException();
                                }
                                if (j1.d())
                                {
                                    ParseFileUtils.deleteQuietly(tempFile);
                                    return j1.i();
                                } else
                                {
                                    ParseFileUtils.deleteQuietly(cacheFile);
                                    ParseFileUtils.moveFile(tempFile, cacheFile);
                                    return j.a(cacheFile);
                                }
                            }

                            public volatile Object then(j j1)
                                throws Exception
                            {
                                return then(j1);
                            }

            
            {
                this$1 = final__pcls3;
                tempFile = File.this;
                super();
            }
                        }, ParseExecutors.io());
                    }
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParseFileController.this;
                cacheFile = file;
                cancellationToken = j1;
                state = state1;
                downloadProgressCallback = progresscallback;
                super();
            }
            });
        }
    }

    public File getCacheFile(ParseFile.State state)
    {
        return new File(cachePath, state.name());
    }

    File getTempFile(ParseFile.State state)
    {
        if (state.url() == null)
        {
            return null;
        } else
        {
            return new File(cachePath, (new StringBuilder()).append(state.url()).append(".tmp").toString());
        }
    }

    public boolean isDataAvailable(ParseFile.State state)
    {
        return getCacheFile(state).exists();
    }

    public j saveAsync(final ParseFile.State state, final File file, String s, ProgressCallback progresscallback, j j1)
    {
        if (state.url() != null)
        {
            return j.a(state);
        }
        if (j1 != null && j1.c())
        {
            return j.h();
        } else
        {
            s = ((ParseRESTFileCommand.Builder)(new ParseRESTFileCommand.Builder()).fileName(state.name()).file(file).contentType(state.mimeType()).sessionToken(s)).build();
            s.enableRetrying();
            return s.executeAsync(restClient, progresscallback, null, j1).c(new i() {

                final ParseFileController this$0;
                final File val$file;
                final ParseFile.State val$state;

                public ParseFile.State then(j j2)
                    throws Exception
                {
                    j2 = (JSONObject)j2.e();
                    j2 = (new ParseFile.State.Builder(state)).name(j2.getString("name")).url(j2.getString("url")).build();
                    try
                    {
                        ParseFileUtils.copyFile(file, getCacheFile(j2));
                    }
                    catch (IOException ioexception)
                    {
                        return j2;
                    }
                    return j2;
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$0 = ParseFileController.this;
                state = state1;
                file = file1;
                super();
            }
            }, ParseExecutors.io());
        }
    }

    public j saveAsync(final ParseFile.State state, final byte data[], String s, ProgressCallback progresscallback, j j1)
    {
        if (state.url() != null)
        {
            return j.a(state);
        }
        if (j1 != null && j1.c())
        {
            return j.h();
        } else
        {
            s = ((ParseRESTFileCommand.Builder)(new ParseRESTFileCommand.Builder()).fileName(state.name()).data(data).contentType(state.mimeType()).sessionToken(s)).build();
            s.enableRetrying();
            return s.executeAsync(restClient, progresscallback, null, j1).c(new i() {

                final ParseFileController this$0;
                final byte val$data[];
                final ParseFile.State val$state;

                public ParseFile.State then(j j2)
                    throws Exception
                {
                    j2 = (JSONObject)j2.e();
                    j2 = (new ParseFile.State.Builder(state)).name(j2.getString("name")).url(j2.getString("url")).build();
                    try
                    {
                        ParseFileUtils.writeByteArrayToFile(getCacheFile(j2), data);
                    }
                    catch (IOException ioexception)
                    {
                        return j2;
                    }
                    return j2;
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$0 = ParseFileController.this;
                state = state1;
                data = abyte0;
                super();
            }
            }, ParseExecutors.io());
        }
    }
}
