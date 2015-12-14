// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.http;

import java.util.Map;

// Referenced classes of package com.amazon.insights.core.http:
//            HttpClient

public static interface od
{

    public abstract od addHeader(String s, String s1);

    public abstract Map getHeaders();

    public abstract od getMethod();

    public abstract Map getParams();

    public abstract byte[] getPostBodyBytes();

    public abstract String getUrl();

    public abstract od setMethod(od od);

    public abstract od setPostBody(String s);

    public abstract od setPostBody(byte abyte0[]);

    public abstract od setUrl(String s);
}
