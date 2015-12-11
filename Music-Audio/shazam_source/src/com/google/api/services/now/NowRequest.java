// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now;

import com.google.api.a.c.e.a.a;
import com.google.api.a.c.e.a.b;
import com.google.api.a.d.m;
import com.google.api.a.g.l;

// Referenced classes of package com.google.api.services.now:
//            Now

public abstract class NowRequest extends b
{

    private String alt;
    private String fields;
    private String key;
    private String oauthToken;
    private Boolean prettyPrint;
    private String quotaUser;
    private String userIp;

    public NowRequest(Now now, String s, String s1, Object obj, Class class1)
    {
        super(now, s, s1, obj, class1);
    }

    public volatile a getAbstractGoogleClient()
    {
        return getAbstractGoogleClient();
    }

    public volatile com.google.api.a.c.e.a getAbstractGoogleClient()
    {
        return getAbstractGoogleClient();
    }

    public final Now getAbstractGoogleClient()
    {
        return (Now)super.getAbstractGoogleClient();
    }

    public String getAlt()
    {
        return alt;
    }

    public String getFields()
    {
        return fields;
    }

    public String getKey()
    {
        return key;
    }

    public String getOauthToken()
    {
        return oauthToken;
    }

    public Boolean getPrettyPrint()
    {
        return prettyPrint;
    }

    public String getQuotaUser()
    {
        return quotaUser;
    }

    public String getUserIp()
    {
        return userIp;
    }

    public volatile b set(String s, Object obj)
    {
        return set(s, obj);
    }

    public volatile com.google.api.a.c.e.b set(String s, Object obj)
    {
        return set(s, obj);
    }

    public volatile l set(String s, Object obj)
    {
        return set(s, obj);
    }

    public NowRequest set(String s, Object obj)
    {
        return (NowRequest)super.set(s, obj);
    }

    public NowRequest setAlt(String s)
    {
        alt = s;
        return this;
    }

    public volatile b setDisableGZipContent(boolean flag)
    {
        return setDisableGZipContent(flag);
    }

    public volatile com.google.api.a.c.e.b setDisableGZipContent(boolean flag)
    {
        return setDisableGZipContent(flag);
    }

    public NowRequest setDisableGZipContent(boolean flag)
    {
        return (NowRequest)super.setDisableGZipContent(flag);
    }

    public NowRequest setFields(String s)
    {
        fields = s;
        return this;
    }

    public NowRequest setKey(String s)
    {
        key = s;
        return this;
    }

    public NowRequest setOauthToken(String s)
    {
        oauthToken = s;
        return this;
    }

    public NowRequest setPrettyPrint(Boolean boolean1)
    {
        prettyPrint = boolean1;
        return this;
    }

    public NowRequest setQuotaUser(String s)
    {
        quotaUser = s;
        return this;
    }

    public volatile b setRequestHeaders(m m)
    {
        return setRequestHeaders(m);
    }

    public volatile com.google.api.a.c.e.b setRequestHeaders(m m)
    {
        return setRequestHeaders(m);
    }

    public NowRequest setRequestHeaders(m m)
    {
        return (NowRequest)super.setRequestHeaders(m);
    }

    public NowRequest setUserIp(String s)
    {
        userIp = s;
        return this;
    }
}
