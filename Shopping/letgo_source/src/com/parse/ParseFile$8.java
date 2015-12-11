// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.parse:
//            ParseFile, ParseFileController, ProgressCallback, ParseFileUtils

class >
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
        if (val$cancellationToken != null && val$cancellationToken.c())
        {
            return cu.h();
        } else
        {
            return ParseFile.getFileController().fetchAsync(ParseFile.access$400(ParseFile.this), null, ParseFile.access$500(val$progressCallback), val$cancellationToken).c(new ct() {

                final ParseFile._cls8 this$1;

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

                public byte[] then(cu cu2)
                    throws Exception
                {
                    cu2 = (File)cu2.e();
                    try
                    {
                        data = ParseFileUtils.readFileToByteArray(cu2);
                        cu2 = data;
                    }
                    // Misplaced declaration of an exception variable
                    catch (cu cu2)
                    {
                        return null;
                    }
                    return cu2;
                }

            
            {
                this$1 = ParseFile._cls8.this;
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

    back()
    {
        this$0 = final_parsefile;
        val$cancellationToken = cu1;
        val$progressCallback = ProgressCallback.this;
        super();
    }
}
