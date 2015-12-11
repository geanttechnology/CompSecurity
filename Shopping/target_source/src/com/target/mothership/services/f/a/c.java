// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.f.a;

import com.target.mothership.b;
import com.target.mothership.services.f.b.a;
import com.target.mothership.util.o;

// Referenced classes of package com.target.mothership.services.f.a:
//            d

public class c
{
    public static class a
    {

        private static final String AMPERSAND = "&";
        private static final String EQUALS = "=";
        private static final String QUESTION_MARK = "?";
        private final StringBuilder mUrlBuilder;

        private void c(String s, String s1)
        {
            StringBuilder stringbuilder = mUrlBuilder;
            String s2;
            if (mUrlBuilder.indexOf("?") == -1)
            {
                s2 = "?";
            } else
            {
                s2 = "&";
            }
            stringbuilder.append(s2);
            mUrlBuilder.append(s);
            mUrlBuilder.append("=");
            mUrlBuilder.append(s1);
        }

        public a a(String s, String s1)
        {
            if (mUrlBuilder.length() != 0)
            {
                int i = s.length();
                int j = mUrlBuilder.indexOf(s);
                if (j != -1)
                {
                    s = s1;
                    if (s1 == null)
                    {
                        s = "";
                    }
                    mUrlBuilder.replace(j, i + j, s);
                    return this;
                }
            }
            return this;
        }

        public a b(String s, String s1)
        {
            if (mUrlBuilder.length() == 0 || s == null || s1 == null || !o.g(s1))
            {
                return this;
            } else
            {
                c(s, s1);
                return this;
            }
        }

        public String toString()
        {
            return mUrlBuilder.toString();
        }

        private a(c c1, com.target.mothership.services.f.b.a a1)
        {
            c1 = (new StringBuilder()).append(a1.a(c1.host)).append(c1.path).toString();
            if (c1 == null)
            {
                c1 = "";
            }
            mUrlBuilder = new StringBuilder(c1);
        }


        private a(String s)
        {
            if (s == null)
            {
                s = "";
            }
            mUrlBuilder = new StringBuilder(s);
        }

    }


    private static final String APP_PARAM = "app";
    private static final String KEY_PARAM = "key";
    public final String completeUrl;
    public final com.target.mothership.services.f.b.a.a host;
    public final int method;
    public final String path;

    public c(d.a a1, com.target.mothership.services.f.b.a.a a2, String s)
    {
        method = com.target.mothership.services.f.a.d.a(a1);
        host = a2;
        path = s;
        completeUrl = null;
    }

    public c(d.a a1, String s)
    {
        method = com.target.mothership.services.f.a.d.a(a1);
        completeUrl = s;
        host = null;
        path = null;
    }

    private void a(a a1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[];

            static 
            {
                $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host = new int[com.target.mothership.services.f.b.a.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[com.target.mothership.services.f.b.a.a.Apigee.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[com.target.mothership.services.f.b.a.a.ApigeeSecure.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[com.target.mothership.services.f.b.a.a.ApigeePciSecure.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[com.target.mothership.services.f.b.a.a.Codebroker.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[com.target.mothership.services.f.b.a.a.Lists.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.mothership.services.url.hosts.BaseHostProvider.Host[host.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            b(a1);
            return;

        case 3: // '\003'
            c(a1);
            return;

        case 4: // '\004'
            d(a1);
            // fall through

        case 5: // '\005'
            b(a1);
            break;
        }
    }

    private void b(a a1)
    {
        a1.b("key", com.target.mothership.b.a().d());
    }

    private void c(a a1)
    {
        a1.b("key", com.target.mothership.b.a().e());
    }

    private void d(a a1)
    {
        a1.b("key", com.target.mothership.b.a().f());
        a1.b("app", com.target.mothership.b.a().g());
    }

    public a a(com.target.mothership.services.f.b.a a1)
    {
        if (completeUrl != null)
        {
            return new a(completeUrl, null);
        } else
        {
            a1 = new a(this, a1, null);
            a(((a) (a1)));
            return a1;
        }
    }
}
