// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.jsoup.helper.DataUtil;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.safety.Cleaner;
import org.jsoup.safety.Whitelist;

// Referenced classes of package org.jsoup:
//            Connection

public class Jsoup
{

    private Jsoup()
    {
    }

    public static String clean(String s, String s1, Whitelist whitelist)
    {
        s = parseBodyFragment(s, s1);
        return (new Cleaner(whitelist)).clean(s).body().html();
    }

    public static String clean(String s, Whitelist whitelist)
    {
        return clean(s, "", whitelist);
    }

    public static Connection connect(String s)
    {
        return HttpConnection.connect(s);
    }

    public static boolean isValid(String s, Whitelist whitelist)
    {
        s = parseBodyFragment(s, "");
        return (new Cleaner(whitelist)).isValid(s);
    }

    public static Document parse(File file, String s)
        throws IOException
    {
        return DataUtil.load(file, s, file.getAbsolutePath());
    }

    public static Document parse(File file, String s, String s1)
        throws IOException
    {
        return DataUtil.load(file, s, s1);
    }

    public static Document parse(InputStream inputstream, String s, String s1)
        throws IOException
    {
        return DataUtil.load(inputstream, s, s1);
    }

    public static Document parse(InputStream inputstream, String s, String s1, Parser parser)
        throws IOException
    {
        return DataUtil.load(inputstream, s, s1, parser);
    }

    public static Document parse(String s)
    {
        return Parser.parse(s, "");
    }

    public static Document parse(String s, String s1)
    {
        return Parser.parse(s, s1);
    }

    public static Document parse(String s, String s1, Parser parser)
    {
        return parser.parseInput(s, s1);
    }

    public static Document parse(URL url, int i)
        throws IOException
    {
        url = HttpConnection.connect(url);
        url.timeout(i);
        return url.get();
    }

    public static Document parseBodyFragment(String s)
    {
        return Parser.parseBodyFragment(s, "");
    }

    public static Document parseBodyFragment(String s, String s1)
    {
        return Parser.parseBodyFragment(s, s1);
    }
}
