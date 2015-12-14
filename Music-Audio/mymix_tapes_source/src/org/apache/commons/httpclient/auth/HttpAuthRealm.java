// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.auth;


// Referenced classes of package org.apache.commons.httpclient.auth:
//            AuthScope

public class HttpAuthRealm extends AuthScope
{

    public HttpAuthRealm(String s, String s1)
    {
        super(s, -1, s1, ANY_SCHEME);
    }
}
