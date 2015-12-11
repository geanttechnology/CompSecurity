// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http;

import java.net.HttpCookie;

// Referenced classes of package com.groupon.http:
//            SharedPreferencesCookieStore

private static final class version
{

    public String comment;
    public String commentURL;
    public boolean discard;
    public String domain;
    public long maxAge;
    public String name;
    public String path;
    public String portList;
    public boolean secure;
    public String value;
    public int version;

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        } else
        {
            obj = (version)obj;
            return name.equals(((name) (obj)).name);
        }
    }

    public boolean hasExpired()
    {
        while (maxAge == -1L || maxAge > 0L) 
        {
            return false;
        }
        return true;
    }

    public int hashCode()
    {
        return name.hashCode();
    }

    public HttpCookie toHttpCookie()
    {
        HttpCookie httpcookie = new HttpCookie(name, value);
        httpcookie.setComment(comment);
        httpcookie.setCommentURL(commentURL);
        httpcookie.setDiscard(discard);
        httpcookie.setDomain(domain);
        httpcookie.setMaxAge(maxAge);
        httpcookie.setPath(path);
        httpcookie.setPortlist(portList);
        httpcookie.setSecure(secure);
        httpcookie.setVersion(version);
        return httpcookie;
    }

    public ()
    {
        maxAge = -1L;
    }

    public maxAge(HttpCookie httpcookie)
    {
        maxAge = -1L;
        comment = httpcookie.getComment();
        commentURL = httpcookie.getCommentURL();
        discard = httpcookie.getDiscard();
        domain = httpcookie.getDomain();
        maxAge = httpcookie.getMaxAge();
        name = httpcookie.getName();
        path = httpcookie.getPath();
        portList = httpcookie.getPortlist();
        secure = httpcookie.getSecure();
        value = httpcookie.getValue();
        version = httpcookie.getVersion();
    }
}
