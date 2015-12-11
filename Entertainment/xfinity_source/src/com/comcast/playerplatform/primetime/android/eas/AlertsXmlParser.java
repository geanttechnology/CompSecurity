// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.eas;

import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.comcast.playerplatform.primetime.android.eas:
//            Alert

public class AlertsXmlParser
{

    private static final String namespace = null;

    public AlertsXmlParser()
    {
    }

    public static ArrayList parseAlertXML(String s)
        throws XmlPullParserException, IOException
    {
        try
        {
            XmlPullParser xmlpullparser = Xml.newPullParser();
            s = new StringReader(s);
            xmlpullparser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            xmlpullparser.setInput(s);
            xmlpullparser.nextTag();
            s = readAlertXML(xmlpullparser);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("error", s.getMessage());
            return null;
        }
        return s;
    }

    public static String parseFipsCodeResponse(String s)
        throws XmlPullParserException, IOException
    {
        try
        {
            XmlPullParser xmlpullparser = Xml.newPullParser();
            s = new StringReader(s);
            xmlpullparser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            xmlpullparser.setInput(s);
            xmlpullparser.nextTag();
            s = readLocationXML(xmlpullparser);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("error", s.getMessage());
            return "";
        }
        return s;
    }

    private static Alert readAlert(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.require(2, namespace, "alert");
        HashMap hashmap = new HashMap();
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break;
            }
            if (xmlpullparser.getEventType() == 2)
            {
                String s = xmlpullparser.getName();
                if (s.equals("identifier"))
                {
                    hashmap.put(s, readXmlValue(xmlpullparser, s));
                } else
                if (s.equals("info"))
                {
                    hashmap.putAll(readInfo(xmlpullparser));
                } else
                {
                    skip(xmlpullparser);
                }
            }
        } while (true);
        return new Alert(hashmap);
    }

    private static ArrayList readAlertXML(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        ArrayList arraylist = new ArrayList();
        xmlpullparser.require(2, namespace, "alerts");
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break;
            }
            if (xmlpullparser.getEventType() == 2)
            {
                if (xmlpullparser.getName().equals("alert"))
                {
                    Alert alert = readAlert(xmlpullparser);
                    if (alert != null)
                    {
                        arraylist.add(alert);
                    }
                } else
                {
                    skip(xmlpullparser);
                }
            }
        } while (true);
        return arraylist;
    }

    private static void readArea(XmlPullParser xmlpullparser, Map map)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.require(2, namespace, "area");
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break;
            }
            if (xmlpullparser.getEventType() == 2)
            {
                if (xmlpullparser.getName().equals("areaDesc"))
                {
                    map.put(xmlpullparser.getName(), readXmlValue(xmlpullparser, xmlpullparser.getName()));
                } else
                {
                    skip(xmlpullparser);
                }
            }
        } while (true);
    }

    private static void readEvent(XmlPullParser xmlpullparser, Map map)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.require(2, namespace, "eventCode");
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break;
            }
            if (xmlpullparser.getEventType() == 2)
            {
                if (xmlpullparser.getName().equals("value"))
                {
                    map.put("eventCode", readXmlValue(xmlpullparser, xmlpullparser.getName()));
                } else
                {
                    skip(xmlpullparser);
                }
            }
        } while (true);
    }

    private static Map readInfo(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.require(2, namespace, "info");
        HashMap hashmap = new HashMap();
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break;
            }
            if (xmlpullparser.getEventType() == 2)
            {
                String s = xmlpullparser.getName();
                if (s.equals("description") || s.equals("instruction") || s.equals("event") || s.equals("expires") || s.equals("effective"))
                {
                    hashmap.put(s, readXmlValue(xmlpullparser, s));
                } else
                if (s.equals("area"))
                {
                    readArea(xmlpullparser, hashmap);
                } else
                if (s.equals("eventCode"))
                {
                    readEvent(xmlpullparser, hashmap);
                } else
                if (s.endsWith("resource"))
                {
                    readResource(xmlpullparser, hashmap);
                } else
                {
                    skip(xmlpullparser);
                }
            }
        } while (true);
        return hashmap;
    }

    private static String readLocationXML(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        String s = null;
        xmlpullparser.require(2, namespace, "zips");
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break;
            }
            if (xmlpullparser.getEventType() == 2)
            {
                if (xmlpullparser.getName().equals("zip"))
                {
                    s = readZipsXML(xmlpullparser);
                } else
                {
                    skip(xmlpullparser);
                }
            }
        } while (true);
        return s;
    }

    private static void readResource(XmlPullParser xmlpullparser, Map map)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.require(2, namespace, "resource");
        boolean flag = false;
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break;
            }
            if (xmlpullparser.getEventType() == 2)
            {
                if (xmlpullparser.getName().equals("mimeType"))
                {
                    String s = readXmlValue(xmlpullparser, xmlpullparser.getName());
                    if (s.equals("application/x-mpegURL") || s.equals("application/vnd.apple.mpegurl"))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                } else
                if (xmlpullparser.getName().equals("uri") && flag)
                {
                    map.put("resource", readXmlValue(xmlpullparser, xmlpullparser.getName()));
                } else
                {
                    skip(xmlpullparser);
                }
            }
        } while (true);
    }

    private static String readText(XmlPullParser xmlpullparser)
        throws IOException, XmlPullParserException
    {
        String s = "";
        if (xmlpullparser.next() == 4)
        {
            s = xmlpullparser.getText();
            xmlpullparser.nextTag();
        }
        return s;
    }

    private static String readXmlValue(XmlPullParser xmlpullparser, String s)
        throws IOException, XmlPullParserException
    {
        xmlpullparser.require(2, namespace, s);
        String s1 = readText(xmlpullparser);
        xmlpullparser.require(3, namespace, s);
        return s1;
    }

    private static String readZipsXML(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        Object obj = null;
        xmlpullparser.require(2, namespace, "zip");
        do
        {
label0:
            {
                String s = obj;
                if (xmlpullparser.next() != 3)
                {
                    if (xmlpullparser.getEventType() != 2)
                    {
                        continue;
                    }
                    if (!xmlpullparser.getName().equals("countyFips"))
                    {
                        break label0;
                    }
                    s = readText(xmlpullparser);
                }
                return s;
            }
            skip(xmlpullparser);
        } while (true);
    }

    private static void skip(XmlPullParser xmlpullparser)
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

}
