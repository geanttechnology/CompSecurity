// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.helper;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.jsoup.parser.Parser;

// Referenced classes of package org.jsoup.helper:
//            HttpConnection, Validate

public static class <init> extends <init>
    implements org.jsoup.ase
{

    private Collection data;
    private boolean followRedirects;
    private boolean ignoreContentType;
    private boolean ignoreHttpErrors;
    private Parser parser;
    private int timeoutMilliseconds;

    public volatile String cookie(String s)
    {
        return super.kie(s);
    }

    public volatile Map cookies()
    {
        return super.kies();
    }

    public Collection data()
    {
        return data;
    }

    public volatile org.jsoup.equest data(org.jsoup.equest equest)
    {
        return data(equest);
    }

    public data data(org.jsoup.equest equest)
    {
        Validate.notNull(equest, "Key val must not be null");
        data.add(equest);
        return this;
    }

    public org.jsoup.equest followRedirects(boolean flag)
    {
        followRedirects = flag;
        return this;
    }

    public boolean followRedirects()
    {
        return followRedirects;
    }

    public volatile boolean hasCookie(String s)
    {
        return super.Cookie(s);
    }

    public volatile boolean hasHeader(String s)
    {
        return super.Header(s);
    }

    public volatile String header(String s)
    {
        return super.der(s);
    }

    public volatile Map headers()
    {
        return super.ders();
    }

    public org.jsoup.equest ignoreContentType(boolean flag)
    {
        ignoreContentType = flag;
        return this;
    }

    public boolean ignoreContentType()
    {
        return ignoreContentType;
    }

    public org.jsoup.equest ignoreHttpErrors(boolean flag)
    {
        ignoreHttpErrors = flag;
        return this;
    }

    public boolean ignoreHttpErrors()
    {
        return ignoreHttpErrors;
    }

    public volatile org.jsoup.equest method()
    {
        return super.hod();
    }

    public volatile org.jsoup.equest parser(Parser parser1)
    {
        return parser(parser1);
    }

    public parser parser(Parser parser1)
    {
        parser = parser1;
        return this;
    }

    public Parser parser()
    {
        return parser;
    }

    public int timeout()
    {
        return timeoutMilliseconds;
    }

    public volatile org.jsoup.equest timeout(int i)
    {
        return timeout(i);
    }

    public timeout timeout(int i)
    {
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Validate.isTrue(flag, "Timeout milliseconds must be 0 (infinite) or greater");
        timeoutMilliseconds = i;
        return this;
    }

    public volatile URL url()
    {
        return super.();
    }

    private ()
    {
        super(null);
        ignoreHttpErrors = false;
        ignoreContentType = false;
        timeoutMilliseconds = 3000;
        followRedirects = true;
        data = new ArrayList();
        method = org.jsoup.equest.method;
        headers.put("Accept-Encoding", "gzip");
        parser = Parser.htmlParser();
    }

    parser(parser parser1)
    {
        this();
    }
}
