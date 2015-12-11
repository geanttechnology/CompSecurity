// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.io.IOException;

// Referenced classes of package com.parse:
//            ParseRequest

class this._cls0
    implements i
{

    final ParseRequest this$0;

    public j then(j j1)
        throws Exception
    {
        j j2 = j1;
        if (j1.d())
        {
            Exception exception = j1.f();
            j2 = j1;
            if (exception instanceof IOException)
            {
                j2 = j.a(newTemporaryException("i/o failure", exception));
            }
        }
        return j2;
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$0 = ParseRequest.this;
        super();
    }
}
