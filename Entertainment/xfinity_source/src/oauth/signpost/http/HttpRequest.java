// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package oauth.signpost.http;

import java.io.IOException;
import java.io.InputStream;

public interface HttpRequest
{

    public abstract String getContentType();

    public abstract String getHeader(String s);

    public abstract InputStream getMessagePayload()
        throws IOException;

    public abstract String getMethod();

    public abstract String getRequestUrl();

    public abstract void setHeader(String s, String s1);
}
