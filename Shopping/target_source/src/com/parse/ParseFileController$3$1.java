// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.io.File;
import java.util.concurrent.CancellationException;

// Referenced classes of package com.parse:
//            ParseFileUtils, ParseFileController, ParseAWSRequest, ParseExecutors, 
//            ProgressCallback

class val.tempFile
    implements i
{

    final then this$1;
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
            ParseFileUtils.deleteQuietly(val$tempFile);
            return j1.i();
        } else
        {
            ParseFileUtils.deleteQuietly(cacheFile);
            ParseFileUtils.moveFile(val$tempFile, cacheFile);
            return j.a(cacheFile);
        }
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    l.downloadProgressCallback()
    {
        this$1 = final_downloadprogresscallback;
        val$tempFile = File.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseFileController$3

/* anonymous class */
    class ParseFileController._cls3
        implements i
    {

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
                return (new ParseAWSRequest(com.parse.http.ParseHttpRequest.Method.GET, state.url(), j1)).executeAsync(awsClient(), null, downloadProgressCallback, cancellationToken).b(j1. new ParseFileController._cls3._cls1(), ParseExecutors.io());
            }
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = final_parsefilecontroller;
                cacheFile = file;
                cancellationToken = j1;
                state = state1;
                downloadProgressCallback = ProgressCallback.this;
                super();
            }
    }

}
