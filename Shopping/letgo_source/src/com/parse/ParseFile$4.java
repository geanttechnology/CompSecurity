// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseFile, ParseFileController, ProgressCallback

class >
    implements ct
{

    final ParseFile this$0;
    final cu val$cancellationToken;
    final String val$sessionToken;
    final ProgressCallback val$uploadProgressCallback;

    public cu then(cu cu1)
        throws Exception
    {
        if (!isDirty())
        {
            return cu.a(null);
        }
        if (val$cancellationToken != null && val$cancellationToken.c())
        {
            return cu.h();
        } else
        {
            return ParseFile.getFileController().saveAsync(ParseFile.access$400(ParseFile.this), data, val$sessionToken, ParseFile.access$500(val$uploadProgressCallback), val$cancellationToken).d(new ct() {

                final ParseFile._cls4 this$1;

                public cu then(cu cu2)
                    throws Exception
                {
                    ParseFile.access$402(this$0, (ParseFile.State)cu2.e());
                    return cu2.j();
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$1 = ParseFile._cls4.this;
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
        val$sessionToken = s;
        val$uploadProgressCallback = ProgressCallback.this;
        super();
    }
}
