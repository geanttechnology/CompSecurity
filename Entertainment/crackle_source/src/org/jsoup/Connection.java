// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

public interface Connection
{
    public static interface Base
    {

        public abstract String cookie(String s);

        public abstract Base cookie(String s, String s1);

        public abstract Map cookies();

        public abstract boolean hasCookie(String s);

        public abstract boolean hasHeader(String s);

        public abstract String header(String s);

        public abstract Base header(String s, String s1);

        public abstract Map headers();

        public abstract Base method(Method method1);

        public abstract Method method();

        public abstract Base removeCookie(String s);

        public abstract Base removeHeader(String s);

        public abstract URL url();

        public abstract Base url(URL url1);
    }

    public static interface KeyVal
    {

        public abstract String key();

        public abstract KeyVal key(String s);

        public abstract String value();

        public abstract KeyVal value(String s);
    }

    public static final class Method extends Enum
    {

        private static final Method $VALUES[];
        public static final Method GET;
        public static final Method POST;

        public static Method valueOf(String s)
        {
            return (Method)Enum.valueOf(org/jsoup/Connection$Method, s);
        }

        public static Method[] values()
        {
            return (Method[])$VALUES.clone();
        }

        static 
        {
            GET = new Method("GET", 0);
            POST = new Method("POST", 1);
            $VALUES = (new Method[] {
                GET, POST
            });
        }

        private Method(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface Request
        extends Base
    {

        public abstract Collection data();

        public abstract Request data(KeyVal keyval);

        public abstract Request followRedirects(boolean flag);

        public abstract boolean followRedirects();

        public abstract Request ignoreContentType(boolean flag);

        public abstract boolean ignoreContentType();

        public abstract Request ignoreHttpErrors(boolean flag);

        public abstract boolean ignoreHttpErrors();

        public abstract Request parser(Parser parser1);

        public abstract Parser parser();

        public abstract int timeout();

        public abstract Request timeout(int i);
    }

    public static interface Response
        extends Base
    {

        public abstract String body();

        public abstract byte[] bodyAsBytes();

        public abstract String charset();

        public abstract String contentType();

        public abstract Document parse()
            throws IOException;

        public abstract int statusCode();

        public abstract String statusMessage();
    }


    public abstract Connection cookie(String s, String s1);

    public abstract Connection cookies(Map map);

    public abstract Connection data(String s, String s1);

    public abstract Connection data(Map map);

    public transient abstract Connection data(String as[]);

    public abstract Response execute()
        throws IOException;

    public abstract Connection followRedirects(boolean flag);

    public abstract Document get()
        throws IOException;

    public abstract Connection header(String s, String s1);

    public abstract Connection ignoreContentType(boolean flag);

    public abstract Connection ignoreHttpErrors(boolean flag);

    public abstract Connection method(Method method1);

    public abstract Connection parser(Parser parser1);

    public abstract Document post()
        throws IOException;

    public abstract Connection referrer(String s);

    public abstract Request request();

    public abstract Connection request(Request request1);

    public abstract Response response();

    public abstract Connection response(Response response1);

    public abstract Connection timeout(int i);

    public abstract Connection url(String s);

    public abstract Connection url(URL url1);

    public abstract Connection userAgent(String s);
}
