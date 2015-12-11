// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.io.File;
import java.util.concurrent.CancellationException;

// Referenced classes of package com.parse:
//            ParseFileUtils, ParseFileController, ParseAWSRequest, ProgressCallback

class this._cls1
    implements ct
{

    final then this$1;

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

    l.downloadProgressCallback()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseFileController$2

/* anonymous class */
    class ParseFileController._cls2
        implements ct
    {

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
                return (new ParseAWSRequest(ParseRequest.Method.GET, state.url())).executeAsync(awsClient(), null, downloadProgressCallback, cancellationToken).c(new ParseFileController._cls2._cls1());
            }
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$0 = final_parsefilecontroller;
                file = file1;
                cancellationToken = cu1;
                state = state1;
                downloadProgressCallback = ProgressCallback.this;
                super();
            }
    }

}
