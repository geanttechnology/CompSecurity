// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.http;

import java.io.IOException;

// Referenced classes of package com.parse.http:
//            ParseHttpResponse, ParseHttpRequest

public interface ParseNetworkInterceptor
{
    public static interface Chain
    {

        public abstract ParseHttpRequest getRequest();

        public abstract ParseHttpResponse proceed(ParseHttpRequest parsehttprequest)
            throws IOException;
    }


    public abstract ParseHttpResponse intercept(Chain chain)
        throws IOException;
}
