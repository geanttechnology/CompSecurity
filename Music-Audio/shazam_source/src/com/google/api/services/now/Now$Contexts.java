// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now;

import com.google.api.a.c.e.a.b;
import com.google.api.a.d.p;
import com.google.api.a.d.s;
import com.google.api.a.g.l;
import com.google.api.a.g.w;
import com.google.api.services.now.model.Context;
import com.google.api.services.now.model.ListContextsResponse;

// Referenced classes of package com.google.api.services.now:
//            Now, NowRequest

public class this._cls0
{
    public class Create extends NowRequest
    {

        private static final String REST_PATH = "contexts";
        final Now.Contexts this$1;

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

        public Create set(String s, Object obj)
        {
            return (Create)super.set(s, obj);
        }

        public volatile NowRequest set(String s, Object obj)
        {
            return set(s, obj);
        }

        public Create setAlt(String s)
        {
            return (Create)super.setAlt(s);
        }

        public volatile NowRequest setAlt(String s)
        {
            return setAlt(s);
        }

        public Create setFields(String s)
        {
            return (Create)super.setFields(s);
        }

        public volatile NowRequest setFields(String s)
        {
            return setFields(s);
        }

        public Create setKey(String s)
        {
            return (Create)super.setKey(s);
        }

        public volatile NowRequest setKey(String s)
        {
            return setKey(s);
        }

        public Create setOauthToken(String s)
        {
            return (Create)super.setOauthToken(s);
        }

        public volatile NowRequest setOauthToken(String s)
        {
            return setOauthToken(s);
        }

        public Create setPrettyPrint(Boolean boolean1)
        {
            return (Create)super.setPrettyPrint(boolean1);
        }

        public volatile NowRequest setPrettyPrint(Boolean boolean1)
        {
            return setPrettyPrint(boolean1);
        }

        public Create setQuotaUser(String s)
        {
            return (Create)super.setQuotaUser(s);
        }

        public volatile NowRequest setQuotaUser(String s)
        {
            return setQuotaUser(s);
        }

        public Create setUserIp(String s)
        {
            return (Create)super.setUserIp(s);
        }

        public volatile NowRequest setUserIp(String s)
        {
            return setUserIp(s);
        }

        protected Create(Context context)
        {
            this$1 = Now.Contexts.this;
            super(this$0, "POST", "contexts", context, com/google/api/services/now/model/Context);
        }
    }

    public class Delete extends NowRequest
    {

        private static final String REST_PATH = "contexts/{contextId}";
        private String contextId;
        final Now.Contexts this$1;

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

        public Delete set(String s, Object obj)
        {
            return (Delete)super.set(s, obj);
        }

        public volatile NowRequest set(String s, Object obj)
        {
            return set(s, obj);
        }

        public Delete setAlt(String s)
        {
            return (Delete)super.setAlt(s);
        }

        public volatile NowRequest setAlt(String s)
        {
            return setAlt(s);
        }

        public Delete setContextId(String s)
        {
            contextId = s;
            return this;
        }

        public Delete setFields(String s)
        {
            return (Delete)super.setFields(s);
        }

        public volatile NowRequest setFields(String s)
        {
            return setFields(s);
        }

        public Delete setKey(String s)
        {
            return (Delete)super.setKey(s);
        }

        public volatile NowRequest setKey(String s)
        {
            return setKey(s);
        }

        public Delete setOauthToken(String s)
        {
            return (Delete)super.setOauthToken(s);
        }

        public volatile NowRequest setOauthToken(String s)
        {
            return setOauthToken(s);
        }

        public Delete setPrettyPrint(Boolean boolean1)
        {
            return (Delete)super.setPrettyPrint(boolean1);
        }

        public volatile NowRequest setPrettyPrint(Boolean boolean1)
        {
            return setPrettyPrint(boolean1);
        }

        public Delete setQuotaUser(String s)
        {
            return (Delete)super.setQuotaUser(s);
        }

        public volatile NowRequest setQuotaUser(String s)
        {
            return setQuotaUser(s);
        }

        public Delete setUserIp(String s)
        {
            return (Delete)super.setUserIp(s);
        }

        public volatile NowRequest setUserIp(String s)
        {
            return setUserIp(s);
        }

        protected Delete(String s)
        {
            this$1 = Now.Contexts.this;
            super(this$0, "DELETE", "contexts/{contextId}", null, java/lang/Void);
            contextId = (String)w.a(s, "Required parameter contextId must be specified.");
        }
    }

    public class Get extends NowRequest
    {

        private static final String REST_PATH = "contexts/{contextId}";
        private String contextId;
        final Now.Contexts this$1;

        public p buildHttpRequestUsingHead()
        {
            return super.buildHttpRequestUsingHead();
        }

        public s executeUsingHead()
        {
            return super.executeUsingHead();
        }

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

        public Get set(String s, Object obj)
        {
            return (Get)super.set(s, obj);
        }

        public volatile NowRequest set(String s, Object obj)
        {
            return set(s, obj);
        }

        public Get setAlt(String s)
        {
            return (Get)super.setAlt(s);
        }

        public volatile NowRequest setAlt(String s)
        {
            return setAlt(s);
        }

        public Get setContextId(String s)
        {
            contextId = s;
            return this;
        }

        public Get setFields(String s)
        {
            return (Get)super.setFields(s);
        }

        public volatile NowRequest setFields(String s)
        {
            return setFields(s);
        }

        public Get setKey(String s)
        {
            return (Get)super.setKey(s);
        }

        public volatile NowRequest setKey(String s)
        {
            return setKey(s);
        }

        public Get setOauthToken(String s)
        {
            return (Get)super.setOauthToken(s);
        }

        public volatile NowRequest setOauthToken(String s)
        {
            return setOauthToken(s);
        }

        public Get setPrettyPrint(Boolean boolean1)
        {
            return (Get)super.setPrettyPrint(boolean1);
        }

        public volatile NowRequest setPrettyPrint(Boolean boolean1)
        {
            return setPrettyPrint(boolean1);
        }

        public Get setQuotaUser(String s)
        {
            return (Get)super.setQuotaUser(s);
        }

        public volatile NowRequest setQuotaUser(String s)
        {
            return setQuotaUser(s);
        }

        public Get setUserIp(String s)
        {
            return (Get)super.setUserIp(s);
        }

        public volatile NowRequest setUserIp(String s)
        {
            return setUserIp(s);
        }

        protected Get(String s)
        {
            this$1 = Now.Contexts.this;
            super(this$0, "GET", "contexts/{contextId}", null, com/google/api/services/now/model/Context);
            contextId = (String)w.a(s, "Required parameter contextId must be specified.");
        }
    }

    public class List extends NowRequest
    {

        private static final String REST_PATH = "contexts";
        private Integer pageSize;
        private String pageToken;
        final Now.Contexts this$1;

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

        public List set(String s, Object obj)
        {
            return (List)super.set(s, obj);
        }

        public volatile NowRequest set(String s, Object obj)
        {
            return set(s, obj);
        }

        public List setAlt(String s)
        {
            return (List)super.setAlt(s);
        }

        public volatile NowRequest setAlt(String s)
        {
            return setAlt(s);
        }

        public List setFields(String s)
        {
            return (List)super.setFields(s);
        }

        public volatile NowRequest setFields(String s)
        {
            return setFields(s);
        }

        public List setKey(String s)
        {
            return (List)super.setKey(s);
        }

        public volatile NowRequest setKey(String s)
        {
            return setKey(s);
        }

        public List setOauthToken(String s)
        {
            return (List)super.setOauthToken(s);
        }

        public volatile NowRequest setOauthToken(String s)
        {
            return setOauthToken(s);
        }

        public List setPageSize(Integer integer)
        {
            pageSize = integer;
            return this;
        }

        public List setPageToken(String s)
        {
            pageToken = s;
            return this;
        }

        public List setPrettyPrint(Boolean boolean1)
        {
            return (List)super.setPrettyPrint(boolean1);
        }

        public volatile NowRequest setPrettyPrint(Boolean boolean1)
        {
            return setPrettyPrint(boolean1);
        }

        public List setQuotaUser(String s)
        {
            return (List)super.setQuotaUser(s);
        }

        public volatile NowRequest setQuotaUser(String s)
        {
            return setQuotaUser(s);
        }

        public List setUserIp(String s)
        {
            return (List)super.setUserIp(s);
        }

        public volatile NowRequest setUserIp(String s)
        {
            return setUserIp(s);
        }

        protected List()
        {
            this$1 = Now.Contexts.this;
            super(this$0, "GET", "contexts", null, com/google/api/services/now/model/ListContextsResponse);
        }
    }


    final Now this$0;

    public Create create(Context context)
    {
        context = new Create(context);
        initialize(context);
        return context;
    }

    public Delete delete(String s)
    {
        s = new Delete(s);
        initialize(s);
        return s;
    }

    public Get get(String s)
    {
        s = new Get(s);
        initialize(s);
        return s;
    }

    public List list()
    {
        List list1 = new List();
        initialize(list1);
        return list1;
    }

    public this._cls0()
    {
        this$0 = Now.this;
        super();
    }
}
