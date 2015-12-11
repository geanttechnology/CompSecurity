// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.examples;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ListLinks
{

    public ListLinks()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        Object obj;
        Object obj1;
        boolean flag;
        if (args.length == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Validate.isTrue(flag, "usage: supply url to fetch");
        args = args[0];
        print("Fetching %s...", new Object[] {
            args
        });
        obj = Jsoup.connect(args).get();
        args = ((Document) (obj)).select("a[href]");
        obj1 = ((Document) (obj)).select("[src]");
        obj = ((Document) (obj)).select("link[href]");
        print("\nMedia: (%d)", new Object[] {
            Integer.valueOf(((Elements) (obj1)).size())
        });
        for (obj1 = ((Elements) (obj1)).iterator(); ((Iterator) (obj1)).hasNext();)
        {
            Element element2 = (Element)((Iterator) (obj1)).next();
            if (element2.tagName().equals("img"))
            {
                print(" * %s: <%s> %sx%s (%s)", new Object[] {
                    element2.tagName(), element2.attr("abs:src"), element2.attr("width"), element2.attr("height"), trim(element2.attr("alt"), 20)
                });
            } else
            {
                print(" * %s: <%s>", new Object[] {
                    element2.tagName(), element2.attr("abs:src")
                });
            }
        }

        print("\nImports: (%d)", new Object[] {
            Integer.valueOf(((Elements) (obj)).size())
        });
        Element element1;
        for (obj = ((Elements) (obj)).iterator(); ((Iterator) (obj)).hasNext(); print(" * %s <%s> (%s)", new Object[] {
    element1.tagName(), element1.attr("abs:href"), element1.attr("rel")
}))
        {
            element1 = (Element)((Iterator) (obj)).next();
        }

        print("\nLinks: (%d)", new Object[] {
            Integer.valueOf(args.size())
        });
        Element element;
        for (args = args.iterator(); args.hasNext(); print(" * a: <%s>  (%s)", new Object[] {
    element.attr("abs:href"), trim(element.text(), 35)
}))
        {
            element = (Element)args.next();
        }

    }

    private static transient void print(String s, Object aobj[])
    {
        System.out.println(String.format(s, aobj));
    }

    private static String trim(String s, int i)
    {
        String s1 = s;
        if (s.length() > i)
        {
            s1 = (new StringBuilder()).append(s.substring(0, i - 1)).append(".").toString();
        }
        return s1;
    }
}
