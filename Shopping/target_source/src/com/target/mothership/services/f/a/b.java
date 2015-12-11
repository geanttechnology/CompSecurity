// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.f.a;

import android.net.Uri;
import com.target.mothership.services.f.b.a;
import com.target.mothership.services.n;
import com.target.mothership.services.t;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.target.mothership.services.f.a:
//            c

public class com.target.mothership.services.f.a.b
{
    protected static class a
    {

        private String mValue;

        public String a()
        {
            return mValue;
        }

        public String b()
        {
            return String.format("{%s}", new Object[] {
                mValue
            });
        }

        public a(String s)
        {
            mValue = s;
        }
    }

    public static class b
    {

        private final String mBody;
        private final t mContentType;
        private final Map mHeaders;
        private final boolean mIgnoreCacheHeaders;
        private final int mMethod;
        private int mNumTries;
        private final c.a mTargetUrl;
        private final c mTargetedEndpoint;
        private String mUrl;

        public void a()
        {
            mNumTries = mNumTries + 1;
        }

        public void a(String s, String s1)
        {
            mHeaders.put(s, s1);
        }

        public void a(Map map)
        {
            String s;
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); mTargetUrl.b(s, (String)map.get(s)))
            {
                s = (String)iterator.next();
            }

            mUrl = mTargetUrl.toString();
        }

        public int b()
        {
            return mNumTries;
        }

        public int c()
        {
            return mMethod;
        }

        public String d()
        {
            return mBody;
        }

        public String e()
        {
            return mUrl;
        }

        public Map f()
        {
            if (mHeaders != null)
            {
                return mHeaders;
            } else
            {
                return Collections.emptyMap();
            }
        }

        public t g()
        {
            return mContentType;
        }

        public boolean h()
        {
            return mIgnoreCacheHeaders;
        }

        public c i()
        {
            return mTargetedEndpoint;
        }

        private b(c c1, c.a a1, String s, Map map, t t1, t t2, boolean flag)
        {
            mTargetedEndpoint = c1;
            mMethod = c1.method;
            mUrl = a1.toString();
            mTargetUrl = a1;
            mBody = s;
            mContentType = t2;
            mIgnoreCacheHeaders = flag;
            mHeaders = new android.support.v4.f.a();
            if (t1 == t.Json)
            {
                mHeaders.put("Accept", "application/json");
            } else
            {
                mHeaders.put("Accept", "application/xml");
            }
            mHeaders.put("User-Agent", com.target.mothership.b.a().h());
            if (map != null)
            {
                mHeaders.putAll(map);
            }
        }

    }


    private static final String ACCEPT_HEADER_KEY = "Accept";
    private static final String JSON_TYPE = "application/json";
    private static final String USER_AGENT_HEADER_KEY = "User-Agent";
    private static final String XML_TYPE = "application/xml";
    protected com.target.mothership.services.f.b.a mHosts;

    public com.target.mothership.services.f.a.b(com.target.mothership.services.f.b.a a1)
    {
        mHosts = a1;
    }

    protected b a(c c1, n n1, Map map, Map map1, Map map2)
    {
        return a(c1, n1, map, map1, map2, t.Json, t.Json, false);
    }

    protected b a(c c1, n n1, Map map, Map map1, Map map2, t t1, t t2, 
            boolean flag)
    {
        c.a a1 = c1.a(mHosts);
        if (map != null)
        {
            String s1;
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); a1.a(s1, Uri.encode((String)map.get(s1), "UTF-8")))
            {
                s1 = (String)iterator.next();
            }

        }
        if (map1 != null)
        {
            String s;
            for (map = map1.keySet().iterator(); map.hasNext(); a1.b(s, Uri.encode((String)map1.get(s), "UTF-8")))
            {
                s = (String)map.next();
            }

        }
        map = null;
        if (n1 != null)
        {
            map = n1.a();
        }
        return new b(c1, a1, map, map2, t1, t2, flag);
    }

    protected b a(c c1, n n1, Map map, Map map1, Map map2, boolean flag)
    {
        return a(c1, n1, map, map1, map2, t.Json, t.Json, flag);
    }

    protected b b(c c1, n n1, Map map, Map map1, Map map2)
    {
        return a(c1, n1, map, map1, map2, t.Xml, t.Xml, false);
    }
}
