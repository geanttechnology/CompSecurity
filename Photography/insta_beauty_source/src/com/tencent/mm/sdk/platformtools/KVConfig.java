// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            Log, Util

public class KVConfig
{

    private static boolean aa = false;

    public KVConfig()
    {
    }

    private static void a(Map map)
    {
        if (map == null || map.size() <= 0)
        {
            Log.v("MicroMsg.SDK.KVConfig", "empty values");
        } else
        {
            map = map.entrySet().iterator();
            while (map.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                Log.v("MicroMsg.SDK.KVConfig", (new StringBuilder("key=")).append((String)entry.getKey()).append(" value=").append((String)entry.getValue()).toString());
            }
        }
    }

    private static void a(Map map, String s, Node node, int i)
    {
        boolean flag = false;
        if (node.getNodeName().equals("#text"))
        {
            map.put(s, node.getNodeValue());
        } else
        {
            if (node.getNodeName().equals("#cdata-section"))
            {
                map.put(s, node.getNodeValue());
                return;
            }
            Object obj = (new StringBuilder()).append(s).append(".").append(node.getNodeName());
            if (i > 0)
            {
                s = Integer.valueOf(i);
            } else
            {
                s = "";
            }
            s = ((StringBuilder) (obj)).append(s).toString();
            map.put(s, node.getNodeValue());
            obj = node.getAttributes();
            if (obj != null)
            {
                for (i = 0; i < ((NamedNodeMap) (obj)).getLength(); i++)
                {
                    Node node1 = ((NamedNodeMap) (obj)).item(i);
                    map.put((new StringBuilder()).append(s).append(".$").append(node1.getNodeName()).toString(), node1.getNodeValue());
                }

            }
            obj = new HashMap();
            node = node.getChildNodes();
            i = ((flag) ? 1 : 0);
            while (i < node.getLength()) 
            {
                Node node2 = node.item(i);
                int j = Util.nullAsNil((Integer)((HashMap) (obj)).get(node2.getNodeName()));
                a(map, s, node2, j);
                ((HashMap) (obj)).put(node2.getNodeName(), Integer.valueOf(j + 1));
                i++;
            }
        }
    }

    public static Map parseIni(String s)
    {
        if (s == null || s.length() <= 0)
        {
            s = null;
        } else
        {
            HashMap hashmap = new HashMap();
            s = s.split("\n");
            int j = s.length;
            for (int i = 0; i < j; i++)
            {
                String s1 = s[i];
                if (s1 == null || s1.length() <= 0)
                {
                    continue;
                }
                String as[] = s1.trim().split("=", 2);
                if (as == null || as.length < 2)
                {
                    continue;
                }
                s1 = as[0];
                String s2 = as[1];
                if (s1 != null && s1.length() > 0 && s1.matches("^[a-zA-Z0-9_]*"))
                {
                    hashmap.put(s1, s2);
                }
            }

            s = hashmap;
            if (aa)
            {
                a(hashmap);
                return hashmap;
            }
        }
        return s;
    }

    public static Map parseXml(String s, String s1, String s2)
    {
        int i = s.indexOf('<');
        if (i >= 0) goto _L2; else goto _L1
_L1:
        Log.e("MicroMsg.SDK.KVConfig", "text not in xml format");
_L4:
        return null;
_L2:
        Object obj;
        obj = s;
        if (i > 0)
        {
            Log.w("MicroMsg.SDK.KVConfig", "fix xml header from + %d", new Object[] {
                Integer.valueOf(i)
            });
            obj = s.substring(i);
        }
        if (obj == null || ((String) (obj)).length() <= 0) goto _L4; else goto _L3
_L3:
        HashMap hashmap;
        hashmap = new HashMap();
        s = DocumentBuilderFactory.newInstance();
        try
        {
            s = s.newDocumentBuilder();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        if (s == null)
        {
            Log.e("MicroMsg.SDK.KVConfig", "new Document Builder failed");
            return null;
        }
        obj = new InputSource(new ByteArrayInputStream(((String) (obj)).getBytes()));
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        ((InputSource) (obj)).setEncoding(s2);
        s = s.parse(((InputSource) (obj)));
        s.normalize();
_L6:
        if (s == null)
        {
            Log.e("MicroMsg.SDK.KVConfig", "new Document failed");
            return null;
        }
        break; /* Loop/switch isn't completed */
        s2;
        s = null;
_L7:
        s2.printStackTrace();
        if (true) goto _L6; else goto _L5
        s;
        s.printStackTrace();
        return null;
        s;
        s.printStackTrace();
        return null;
        s;
        s.printStackTrace();
        return null;
_L5:
        s = s.getDocumentElement();
        if (s == null)
        {
            Log.e("MicroMsg.SDK.KVConfig", "getDocumentElement failed");
            return null;
        }
        if (s1 != null && s1.equals(s.getNodeName()))
        {
            a(hashmap, "", s, 0);
        } else
        {
            s = s.getElementsByTagName(s1);
            if (s.getLength() <= 0)
            {
                Log.e("MicroMsg.SDK.KVConfig", "parse item null");
                return null;
            }
            if (s.getLength() > 1)
            {
                Log.w("MicroMsg.SDK.KVConfig", "parse items more than one");
            }
            a(hashmap, "", s.item(0), 0);
        }
        if (aa)
        {
            a(hashmap);
        }
        return hashmap;
        s2;
          goto _L7
    }

}
