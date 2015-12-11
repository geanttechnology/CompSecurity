// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.parse:
//            ParseFileUtils, ParseFile, ParseFileController, ProgressCallback

class this._cls1
    implements ct
{

    final  this$1;

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    public byte[] then(cu cu1)
        throws Exception
    {
        cu1 = (File)cu1.e();
        try
        {
            data = ParseFileUtils.readFileToByteArray(cu1);
            cu1 = data;
        }
        // Misplaced declaration of an exception variable
        catch (cu cu1)
        {
            return null;
        }
        return cu1;
    }

    ck()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseFile$8

/* anonymous class */
    class ParseFile._cls8
        implements ct
    {

        final ParseFile this$0;
        final cu val$cancellationToken;
        final ProgressCallback val$progressCallback;

        public cu then(cu cu1)
            throws Exception
        {
            if (data != null)
            {
                return cu.a(data);
            }
            if (cancellationToken != null && cancellationToken.c())
            {
                return cu.h();
            } else
            {
                return ParseFile.getFileController().fetchAsync(ParseFile.access$400(ParseFile.this), null, ParseFile.access$500(progressCallback), cancellationToken).c(new ParseFile._cls8._cls1());
            }
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$0 = final_parsefile;
                cancellationToken = cu1;
                progressCallback = ProgressCallback.this;
                super();
            }
    }

}
