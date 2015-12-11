// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParsePlugins, ParseFileUtils, ParseRESTCommand, ParseHttpClient, 
//            ProgressCallback, ParseAWSRequest

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
            int j = afile.length;
            int i = 0;
            while (i < j) 
            {
                ParseFileUtils.deleteQuietly(afile[i]);
                i++;
            }
        }
    }

    public cu fetchAsync(final ParseFile.State state, final String file, final ProgressCallback downloadProgressCallback, final cu cancellationToken)
    {
        if (cancellationToken != null && cancellationToken.c())
        {
            return cu.h();
        } else
        {
            file = getCacheFile(state);
            return cu.a(new Callable() {

                final ParseFileController this$0;
                final File val$file;

                public Boolean call()
                    throws Exception
                {
                    return Boolean.valueOf(file.exists());
                }

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

            
            {
                this$0 = ParseFileController.this;
                file = file1;
                super();
            }
            }, cu.a).b(new ct() {

                final ParseFileController this$0;
                final cu val$cancellationToken;
                final ProgressCallback val$downloadProgressCallback;
                final File val$file;
                final ParseFile.State val$state;

                public cu then(cu cu1)
                    throws Exception
                {
                    if (((Boolean)cu1.e()).booleanValue())
                    {
                        return cu.a(file);
                    }
                    if (cancellationToken != null && cancellationToken.c())
                    {
                        return cu.h();
                    } else
                    {
                        return (new ParseAWSRequest(ParseRequest.Method.GET, state.url())).executeAsync(awsClient(), null, downloadProgressCallback, cancellationToken).c(new ct() {

                            final _cls2 this$1;

                            public File then(cu cu1)
                                throws Exception
                            {
                                if (cancellationToken != null && cancellationToken.c())
                                {
                                    throw new CancellationException();
                                }
                                cu1 = (byte[])cu1.e();
                                if (cu1 != null)
                                {
                                    ParseFileUtils.writeByteArrayToFile(file, cu1);
                                }
                                return file;
                            }

                            public volatile Object then(cu cu1)
                                throws Exception
                            {
                                return then(cu1);
                            }

            
            {
                this$1 = _cls2.this;
                super();
            }
                        });
                    }
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParseFileController.this;
                file = file1;
                cancellationToken = cu1;
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

    public boolean isDataAvailable(ParseFile.State state)
    {
        return getCacheFile(state).exists();
    }

    public cu saveAsync(final ParseFile.State state, final byte data[], String s, ProgressCallback progresscallback, cu cu1)
    {
        if (state.url() != null)
        {
            return cu.a(state);
        }
        if (cu1 != null && cu1.c())
        {
            return cu.h();
        } else
        {
            s = ((ParseRESTFileCommand.Builder)(new ParseRESTFileCommand.Builder()).fileName(state.name()).data(data).contentType(state.mimeType()).sessionToken(s)).build();
            s.enableRetrying();
            return s.executeAsync(restClient, progresscallback, null, cu1).c(new ct() {

                final ParseFileController this$0;
                final byte val$data[];
                final ParseFile.State val$state;

                public ParseFile.State then(cu cu2)
                    throws Exception
                {
                    cu2 = (JSONObject)cu2.e();
                    cu2 = (new ParseFile.State.Builder(state)).name(cu2.getString("name")).url(cu2.getString("url")).build();
                    try
                    {
                        ParseFileUtils.writeByteArrayToFile(getCacheFile(cu2), data);
                    }
                    catch (IOException ioexception)
                    {
                        return cu2;
                    }
                    return cu2;
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseFileController.this;
                state = state1;
                data = abyte0;
                super();
            }
            }, cu.a);
        }
    }
}
