// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.IOException;

// Referenced classes of package com.parse:
//            ParseNetworkInterceptor, ParseHttpRequest, ParseHttpResponse

public static interface 
{

    public abstract ParseHttpRequest getRequest();

    public abstract ParseHttpResponse proceed(ParseHttpRequest parsehttprequest)
        throws IOException;
}
