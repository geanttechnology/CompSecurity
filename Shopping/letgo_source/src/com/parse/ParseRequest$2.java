// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;

// Referenced classes of package com.parse:
//            ParseRequest

class this._cls0
    implements ct
{

    final ParseRequest this$0;

    public cu then(cu cu1)
        throws Exception
    {
        cu cu2 = cu1;
        if (cu1.d())
        {
            Exception exception = cu1.f();
            if (exception instanceof ClientProtocolException)
            {
                cu2 = cu.a(newTemporaryException("bad protocol", exception));
            } else
            {
                cu2 = cu1;
                if (exception instanceof IOException)
                {
                    return cu.a(newTemporaryException("i/o failure", exception));
                }
            }
        }
        return cu2;
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ientProtocolException()
    {
        this$0 = ParseRequest.this;
        super();
    }
}
