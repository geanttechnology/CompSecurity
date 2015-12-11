// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now;

import com.google.api.a.c.e.a.b;
import com.google.api.a.d.p;
import com.google.api.a.d.s;
import com.google.api.a.g.l;
import com.google.api.a.g.w;
import com.google.api.services.now.model.ListCardsResponse;

// Referenced classes of package com.google.api.services.now:
//            NowRequest, Now

public class userId extends NowRequest
{

    private static final String REST_PATH = "users/{userId}/cards";
    private Integer pageSize;
    private String pageToken;
    final setUserIp this$2;
    private String userId;

    public p buildHttpRequestUsingHead()
    {
        return super.buildHttpRequestUsingHead();
    }

    public s executeUsingHead()
    {
        return super.executeUsingHead();
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public String getPageToken()
    {
        return pageToken;
    }

    public String getUserId()
    {
        return userId;
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

    public set set(String s, Object obj)
    {
        return (set)super.set(s, obj);
    }

    public volatile NowRequest set(String s, Object obj)
    {
        return set(s, obj);
    }

    public set setAlt(String s)
    {
        return (set)super.setAlt(s);
    }

    public volatile NowRequest setAlt(String s)
    {
        return setAlt(s);
    }

    public setAlt setFields(String s)
    {
        return (setAlt)super.setFields(s);
    }

    public volatile NowRequest setFields(String s)
    {
        return setFields(s);
    }

    public setFields setKey(String s)
    {
        return (setFields)super.setKey(s);
    }

    public volatile NowRequest setKey(String s)
    {
        return setKey(s);
    }

    public setKey setOauthToken(String s)
    {
        return (setKey)super.setOauthToken(s);
    }

    public volatile NowRequest setOauthToken(String s)
    {
        return setOauthToken(s);
    }

    public setOauthToken setPageSize(Integer integer)
    {
        pageSize = integer;
        return this;
    }

    public pageSize setPageToken(String s)
    {
        pageToken = s;
        return this;
    }

    public pageToken setPrettyPrint(Boolean boolean1)
    {
        return (pageToken)super.setPrettyPrint(boolean1);
    }

    public volatile NowRequest setPrettyPrint(Boolean boolean1)
    {
        return setPrettyPrint(boolean1);
    }

    public setPrettyPrint setQuotaUser(String s)
    {
        return (setPrettyPrint)super.setQuotaUser(s);
    }

    public volatile NowRequest setQuotaUser(String s)
    {
        return setQuotaUser(s);
    }

    public setQuotaUser setUserId(String s)
    {
        userId = s;
        return this;
    }

    public userId setUserIp(String s)
    {
        return (userId)super.setUserIp(s);
    }

    public volatile NowRequest setUserIp(String s)
    {
        return setUserIp(s);
    }

    protected se(String s)
    {
        this$2 = this._cls2.this;
        super(_fld2, "GET", "users/{userId}/cards", null, com/google/api/services/now/model/ListCardsResponse);
        userId = (String)w.a(s, "Required parameter userId must be specified.");
    }
}
