// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.http;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.parse.http:
//            ParseHttpBody

public final class ParseHttpRequest
{
    public static final class Builder
    {

        private ParseHttpBody body;
        private Map headers;
        private Method method;
        private String url;

        public Builder addHeader(String s, String s1)
        {
            headers.put(s, s1);
            return this;
        }

        public Builder addHeaders(Map map)
        {
            headers.putAll(map);
            return this;
        }

        public ParseHttpRequest build()
        {
            return new ParseHttpRequest(this);
        }

        public Builder setBody(ParseHttpBody parsehttpbody)
        {
            body = parsehttpbody;
            return this;
        }

        public Builder setHeaders(Map map)
        {
            headers = new HashMap(map);
            return this;
        }

        public Builder setMethod(Method method1)
        {
            method = method1;
            return this;
        }

        public Builder setUrl(String s)
        {
            url = s;
            return this;
        }





        public Builder()
        {
            headers = new HashMap();
        }

        public Builder(ParseHttpRequest parsehttprequest)
        {
            url = parsehttprequest.url;
            method = parsehttprequest.method;
            headers = new HashMap(parsehttprequest.headers);
            body = parsehttprequest.body;
        }
    }

    public static final class Method extends Enum
    {

        private static final Method $VALUES[];
        public static final Method DELETE;
        public static final Method GET;
        public static final Method POST;
        public static final Method PUT;

        public static Method fromString(String s)
        {
            byte byte0 = -1;
            s.hashCode();
            JVM INSTR lookupswitch 4: default 48
        //                       70454: 112
        //                       79599: 140
        //                       2461856: 126
        //                       2012838315: 154;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            break; /* Loop/switch isn't completed */
_L5:
            break MISSING_BLOCK_LABEL_154;
_L6:
            switch (byte0)
            {
            default:
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid http method: <").append(s).append(">").toString());

            case 0: // '\0'
                return GET;

            case 1: // '\001'
                return POST;

            case 2: // '\002'
                return PUT;

            case 3: // '\003'
                return DELETE;
            }
_L2:
            if (s.equals("GET"))
            {
                byte0 = 0;
            }
              goto _L6
_L4:
            if (s.equals("POST"))
            {
                byte0 = 1;
            }
              goto _L6
_L3:
            if (s.equals("PUT"))
            {
                byte0 = 2;
            }
              goto _L6
            if (s.equals("DELETE"))
            {
                byte0 = 3;
            }
              goto _L6
        }

        public static Method valueOf(String s)
        {
            return (Method)Enum.valueOf(com/parse/http/ParseHttpRequest$Method, s);
        }

        public static Method[] values()
        {
            return (Method[])$VALUES.clone();
        }

        public String toString()
        {
            static class _cls1
            {

                static final int $SwitchMap$com$parse$http$ParseHttpRequest$Method[];

                static 
                {
                    $SwitchMap$com$parse$http$ParseHttpRequest$Method = new int[Method.values().length];
                    try
                    {
                        $SwitchMap$com$parse$http$ParseHttpRequest$Method[Method.GET.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$parse$http$ParseHttpRequest$Method[Method.POST.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$parse$http$ParseHttpRequest$Method[Method.PUT.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$parse$http$ParseHttpRequest$Method[Method.DELETE.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.parse.http.ParseHttpRequest.Method[ordinal()])
            {
            default:
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid http method: <").append(this).append(">").toString());

            case 1: // '\001'
                return "GET";

            case 2: // '\002'
                return "POST";

            case 3: // '\003'
                return "PUT";

            case 4: // '\004'
                return "DELETE";
            }
        }

        static 
        {
            GET = new Method("GET", 0);
            POST = new Method("POST", 1);
            PUT = new Method("PUT", 2);
            DELETE = new Method("DELETE", 3);
            $VALUES = (new Method[] {
                GET, POST, PUT, DELETE
            });
        }

        private Method(String s, int i)
        {
            super(s, i);
        }
    }


    private final ParseHttpBody body;
    private final Map headers;
    private final Method method;
    private final String url;

    private ParseHttpRequest(Builder builder)
    {
        url = builder.url;
        method = builder.method;
        headers = Collections.unmodifiableMap(new HashMap(builder.headers));
        body = builder.body;
    }

    ParseHttpRequest(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public Map getAllHeaders()
    {
        return headers;
    }

    public ParseHttpBody getBody()
    {
        return body;
    }

    public String getHeader(String s)
    {
        return (String)headers.get(s);
    }

    public Method getMethod()
    {
        return method;
    }

    public String getUrl()
    {
        return url;
    }




}
