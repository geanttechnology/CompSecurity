// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp.cache;

import java.io.Serializable;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

public class HttpCacheKey
    implements Serializable
{

    private final String digest;
    private final String key;

    public HttpCacheKey(String s)
    {
        key = s;
        digest = new String(Hex.encodeHex(DigestUtils.sha(s)));
    }

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
            obj = (HttpCacheKey)obj;
            return key.equals(((HttpCacheKey) (obj)).key);
        }
    }

    public String getKey()
    {
        return key;
    }

    public int hashCode()
    {
        return key.hashCode();
    }

    public String toDigest()
    {
        return digest;
    }

    public String toString()
    {
        return (new StringBuilder()).append(com/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey.getName()).append("{key=").append(key).append(",digest=").append(toDigest()).append("}").toString();
    }
}
