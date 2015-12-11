// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class r
{
    public static interface a
    {

        public abstract void a(XmlPullParser xmlpullparser, String s)
            throws IOException, XmlPullParserException;
    }


    private static final String NAMESPACE = null;

    public static String a(XmlPullParser xmlpullparser)
        throws IOException, XmlPullParserException
    {
        String s = null;
        if (xmlpullparser.next() == 4)
        {
            s = xmlpullparser.getText();
            xmlpullparser.nextTag();
        }
        xmlpullparser = s;
        if (s != null)
        {
            xmlpullparser = s.trim();
        }
        return xmlpullparser;
    }

    public static String a(XmlPullParser xmlpullparser, String s)
    {
        return xmlpullparser.getAttributeValue(NAMESPACE, s);
    }

    public static void a(XmlPullParser xmlpullparser, StringReader stringreader, String as[], a a1)
        throws IOException, XmlPullParserException
    {
        as = Arrays.asList(as);
        xmlpullparser.setInput(stringreader);
        xmlpullparser.nextTag();
        for (; xmlpullparser.next() != 1; a(xmlpullparser, ((List) (as)), a1)) { }
    }

    public static void a(XmlPullParser xmlpullparser, String s, a a1)
        throws IOException, XmlPullParserException
    {
        s = new ArrayList(Collections.singletonList(s));
        for (; xmlpullparser.next() != 3; a(xmlpullparser, ((List) (s)), a1)) { }
    }

    private static void a(XmlPullParser xmlpullparser, List list, a a1)
        throws IOException, XmlPullParserException
    {
        if (xmlpullparser.getEventType() != 2)
        {
            return;
        }
        String s = xmlpullparser.getName();
        if (!list.contains(s))
        {
            b(xmlpullparser);
            return;
        } else
        {
            xmlpullparser.require(2, NAMESPACE, s);
            a1.a(xmlpullparser, s);
            return;
        }
    }

    static void a(XmlPullParser xmlpullparser, String as[], int i, a a1)
        throws IOException, XmlPullParserException
    {
        b(xmlpullparser, as, i, a1);
    }

    public static void a(XmlPullParser xmlpullparser, String as[], a a1)
        throws IOException, XmlPullParserException
    {
        as = Arrays.asList(as);
        for (; xmlpullparser.next() != 3; a(xmlpullparser, ((List) (as)), a1)) { }
    }

    public static void b(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        if (xmlpullparser.getEventType() != 2)
        {
            throw new IllegalStateException();
        }
        int i = 1;
        do
        {
            if (i == 0)
            {
                break;
            }
            switch (xmlpullparser.next())
            {
            case 2: // '\002'
                i++;
                break;

            case 3: // '\003'
                i--;
                break;
            }
        } while (true);
    }

    private static void b(XmlPullParser xmlpullparser, String as[], int i, a a1)
        throws IOException, XmlPullParserException
    {
        a1 = new a(i + 1, as, a1) {

            final String val$elementHierarchy[];
            final a val$listener;
            final int val$nextLevel;

            public void a(XmlPullParser xmlpullparser1, String s)
                throws IOException, XmlPullParserException
            {
                if (nextLevel >= elementHierarchy.length)
                {
                    listener.a(xmlpullparser1, s);
                    return;
                } else
                {
                    r.a(xmlpullparser1, elementHierarchy, nextLevel, listener);
                    return;
                }
            }

            
            {
                nextLevel = i;
                elementHierarchy = as;
                listener = a1;
                super();
            }
        };
        a(xmlpullparser, as[i], a1);
    }

    public static void b(XmlPullParser xmlpullparser, String as[], a a1)
        throws IOException, XmlPullParserException
    {
        b(xmlpullparser, as, 0, a1);
    }

}
