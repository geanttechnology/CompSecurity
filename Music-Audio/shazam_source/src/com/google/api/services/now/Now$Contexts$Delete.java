// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now;

import com.google.api.a.c.e.a.b;
import com.google.api.a.g.l;
import com.google.api.a.g.w;

// Referenced classes of package com.google.api.services.now:
//            NowRequest, Now

public class contextId extends NowRequest
{

    private static final String REST_PATH = "contexts/{contextId}";
    private String contextId;
    final setUserIp this$1;

    public String getContextId()
    {
        return contextId;
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

    public setAlt setContextId(String s)
    {
        contextId = s;
        return this;
    }

    public contextId setFields(String s)
    {
        return (contextId)super.setFields(s);
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

    public setOauthToken setPrettyPrint(Boolean boolean1)
    {
        return (setOauthToken)super.setPrettyPrint(boolean1);
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

    public setQuotaUser setUserIp(String s)
    {
        return (setQuotaUser)super.setUserIp(s);
    }

    public volatile NowRequest setUserIp(String s)
    {
        return setUserIp(s);
    }

    protected (String s)
    {
        this$1 = this._cls1.this;
        super(_fld1, "DELETE", "contexts/{contextId}", null, java/lang/Void);
        contextId = (String)w.a(s, "Required parameter contextId must be specified.");
    }
}
